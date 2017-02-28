package sanchez.daniel.triviathewalkingdead;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by daniel.rodriguez on 24/01/2017.
 */
public class PreguntasRespuestas extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName(); //Se obtiene nombre de clase actual y se guarda en TAG

    public TextView txtPreg, txtResp1, txtResp2, txtResp3, txtResp4;
    PreguntasRespuestasController preguntasRespuestasController; //Comunicarse con el controller

    @Override
    protected void onCreate(Bundle savedInstanceState) { //Main
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preguntas_respuestas); //Se conectan controlador con vista
        preguntasRespuestasController = new PreguntasRespuestasController(this);

        txtPreg=(TextView)this.findViewById(R.id.txtPregunta);
        txtResp1=(TextView)this.findViewById(R.id.txtResp1);
        txtResp2=(TextView)this.findViewById(R.id.txtResp2);
        txtResp3=(TextView)this.findViewById(R.id.txtResp3);
        txtResp4=(TextView)this.findViewById(R.id.txtResp4);

        //Log.e(TAG, "" + (AlmacenDatos.getInstance().preguntas == null)); //Log para ver si accede correctamente a las preguntas del servidor

        AlmacenDatos almacen = AlmacenDatos.getInstance();
        int i = almacen.idPreguntaActual; //idPregunta actual
        Pregunta pregunta = almacen.preguntas[i]; //Pregunta actual, se le pasa el id (int i)
        Log.e(TAG, pregunta + ""); //Pregunta

        View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Respuesta respuesta = (Respuesta) v.getTag();
                if(respuesta.getCorrecta() == 1) { //Usuario acierta respuesta correcta (bbdd: 1 correcta, 0 incorrecta)
                    finish();
                    startActivity(getIntent()); //Comienza activity con nueva pregunta y respuestas
                }
            }
        };

        if(i < almacen.preguntas.length) { //Cuando llegue a última pregunta + 1, ya no entra en el if, xq sería igual
            txtPreg.setText(pregunta.getTexto()); //En almacen.preguntas estan todas las preguntas y se van sacando una a una
            almacen.idPreguntaActual++; //Obtener siguiente pregunta, int i suma 1

            txtResp1.setOnClickListener(click);
            txtResp2.setOnClickListener(click);
            txtResp3.setOnClickListener(click);
            txtResp4.setOnClickListener(click);

            txtResp1.setText(pregunta.getRespuestas()[0].getTexto()); //Se obtiene respuesta de la pregunta correspondiente pos[0] de array respuestas
            txtResp1.setTag(pregunta.getRespuestas()[0]);
            txtResp2.setText(pregunta.getRespuestas()[1].getTexto());
            txtResp2.setTag(pregunta.getRespuestas()[1]);
            txtResp3.setText(pregunta.getRespuestas()[2].getTexto());
            txtResp3.setTag(pregunta.getRespuestas()[2]);
            txtResp4.setText(pregunta.getRespuestas()[3].getTexto());
            txtResp4.setTag(pregunta.getRespuestas()[3]);
        }
    }

    @Override
    public void onBackPressed() { //Para si se da al táctil del móvil de volver no haga nada
    }
}