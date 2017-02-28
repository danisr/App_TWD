package sanchez.daniel.triviathewalkingdead;

/**
 * Created by user on 25/02/2017.
 */

public class Respuesta {
    private int id;
    private String texto;
    int correcta;

    public Respuesta(int id, String texto, int correcta) {
        this.id = id;
        this.texto = texto;
        this.correcta = correcta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCorrecta() {
        return correcta;
    }

    public void setCorrecta(int correcta) {
        this.correcta = correcta;
    }

    @Override
    public String toString() {
        return "Respuesta{id=" + id + ", texto='" + texto + ", correcta=" + correcta + '}';
    }
}