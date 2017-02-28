package sanchez.daniel.triviathewalkingdead;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by daniel.rodriguez on 24/01/2017.
 */
public class CreditosFragment extends Fragment {
    TimerTask timerTask; //Para pasar de imagen a imagen (habrán 3 imágenes)
    Timer timer; //Para que funcionen todos los timerTask que hayan
    public ImageView img1;
    public ImageView img2;
    public ImageView img3;
    public MainActivity mainActivity;

    public CreditosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_creditos, container, false);
        img1 = (ImageView) v.findViewById(R.id.imgZombie);
        img2 = (ImageView) v.findViewById(R.id.imgRick);
        img3 = (ImageView) v.findViewById(R.id.imgNegan);
        mainActivity = (MainActivity)getActivity(); //Para referenciar el mainActivity en esta clase

        //Peticion a PHP del servidor (preguntas.php) para descargar preguntas de la BBDD.....................................................
        GestorPreguntas peticionPreg = new GestorPreguntas();
        peticionPreg.pedirPreguntas(); //ejecutar URL

        timerTask = new TimerTask() {
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.v("CreditosFragment","ENTRE!!! ");
                        if (img1.getVisibility() == View.VISIBLE ) {
                            img1.setVisibility(View.INVISIBLE);
                            img2.setVisibility(View.VISIBLE);
                        } else if (img2.getVisibility() == View.VISIBLE) {
                            img2.setVisibility(View.INVISIBLE);
                            img3.setVisibility(View.VISIBLE);
                        }
                    }
                });

                if (img3.getVisibility() == View.VISIBLE) {
                    timer.cancel(); //Termina el tiempo
                    mainActivity.cambiarFragment(2); //Se cambia a la vista de inicio
                }
            }
        };
        timer = new Timer();
        timer.schedule(timerTask, 1000, 1000); //(5000) Cuanto tiempo tarda la app en ejecutar la tarea. (10000) Cada cuánto tiempo está realizando la tarea

        return v;
    }
}