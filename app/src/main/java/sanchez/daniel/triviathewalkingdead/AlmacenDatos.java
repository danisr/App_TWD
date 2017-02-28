package sanchez.daniel.triviathewalkingdead;

import java.util.ArrayList;

/**
 * Created by user on 19/02/2017.
 */

public class AlmacenDatos { //Clase q sirve como contenedora de variables, accesible desde otras clases a ésta

    private static volatile AlmacenDatos instance; //Variable que en  linea 25 se hace objeto
    public String nick;
    public int tiempoPregunta;
    public ArrayList<String> puntuaciones;
    public Pregunta preguntas[]; //Array para las preguntas
    public int idPreguntaActual = 0;

    private AlmacenDatos() {
        puntuaciones = new ArrayList<>();
    }

    public static AlmacenDatos getInstance() { //Para poder acceder de otras clases usando este metodo getInstance()
        if(instance == null) { //1ª vez q se llama a getInstance() crea el objeto instance, la próxima vez ya no lo hace
            synchronized (AlmacenDatos.class) {
                if (instance == null) {
                    instance = new AlmacenDatos();
                }
            }
        }
        return instance;
    }
}