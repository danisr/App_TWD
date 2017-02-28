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
 * Created by user on 29/01/2017.
 */

public class Pregunta {
    private int id;
    private String tipo;
    private String texto;
    Respuesta[] respuestas;

    public Pregunta(int id, String tipo, String texto, Respuesta[] respuestas) {
        this.id = id;
        this.tipo = tipo;
        this.texto = texto;
        this.respuestas = respuestas;
    }

    public Pregunta(int id, String tipo, String texto) {
        this.id = id;
        this.tipo = tipo;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Respuesta[] getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(Respuesta[] respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public String toString() {
        String salida = "Pregunta{id-> " + id + ", tipo-> " + tipo + ", texto-> " + texto + ", respuestas [";
        for (Respuesta r : respuestas){
            salida += r.toString() + ", ";
        }
        salida +="]";
        return salida;
    }
}