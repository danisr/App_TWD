package sanchez.daniel.triviathewalkingdead;

import android.os.AsyncTask;
import android.util.Log;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by user on 25/02/2017.
 */

public class GestorPreguntas {
    ArrayList<Pregunta> arrPreguntas = new ArrayList<>();

    public void pedirPreguntas () { //Método para ejecutar PHP de preguntas pasando la dirección
        new PeticionPreguntas().execute();
    }

    public class PeticionPreguntas extends AsyncTask<String, Void, Void> { //Extiende de AsyncTask para que se ejecute en 2º plano
        private final String TAG = getClass().getSimpleName(); //Se guarda en TAG el nombre de la clase, sirve para que se muestre en el Log

        @Override
        protected Void doInBackground(String... params) { //Va a recibir de 0 a n Strings
            try {
                URL url = new URL("http://danielsr.hol.es/preguntas.php");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET"); //Conexión
                con.connect();

                InputStream in = con.getInputStream(); //Recibe de php
                String respuesta = inputStreamToString(in); //Lo que recibes de preguntas.php se pasa a String en método inputStramToString()
                Log.e(TAG, respuesta);

                int responseCode = con.getResponseCode(); //Se guarda el int de respuesta

                if(responseCode == HttpURLConnection.HTTP_OK) { //Si la petición ha ido bien (200)
                    Gson gson = new Gson();

                    AlmacenDatos almacen = AlmacenDatos.getInstance(); //Objeto almacen para acceder a variables de AlmacenDatos
                    //Pregunta[].class es el objeto q se quiere pasar al array de preguntas
                    almacen.preguntas = gson.fromJson(respuesta, Pregunta[].class); //Devuelve un Array de Preguntas y se guardan en variable preguntas

                    for(int i = 0; i < almacen.preguntas.length; i++) {
                        url = new URL("http://danielsr.hol.es/respuestas.php?idPregunta="+almacen.preguntas[i].getId()); //URL para sacar respuestas con idPregunta
                        con = (HttpURLConnection) url.openConnection();
                        con.setRequestMethod("GET"); //Conexión
                        con.connect();

                        in = con.getInputStream(); //Recibe de php
                        respuesta = inputStreamToString(in); //Lo que recibes de respuestas.php
                        responseCode = con.getResponseCode();

                        if(responseCode == HttpURLConnection.HTTP_OK) { //Si la petición a ido bien (200)
                            Respuesta[] respuestas = gson.fromJson(respuesta, Respuesta[].class); //Devuelve un Array de Preguntas
                            almacen.preguntas[i].setRespuestas(respuestas); //Se meten las respuestas para la pregunta en array respuestas
                        }
                        //Log.e(TAG, AlmacenDatos.getInstance().preguntas[i].toString());
                    }
                }
            } catch (IOException e) {
                Log.e(TAG, e.getMessage());
                return null;
            }
            return null;
        }
    }

    //Convertir de InputStream a String. Recibe por parámetro lo que llega como respuesta de preguntas.php y lo pasa a String
    public static String inputStreamToString(InputStream is) {
        if(is == null) {
            return null;
        }
        String salida = "";
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String linea;
            while ((linea = br.readLine()) != null) {
                salida = salida.concat(linea);
            }
        } catch (IOException e) {
            salida = null;
        } finally {
            try {
                if(br != null) {
                    br.close();
                }
                if(isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
            }
        }
        return salida;
    }
}