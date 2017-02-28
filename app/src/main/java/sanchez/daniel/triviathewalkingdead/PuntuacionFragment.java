package sanchez.daniel.triviathewalkingdead;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by user on 16/02/2017.
 */

public class PuntuacionFragment  extends Fragment {
    public MainActivity mainActivity;
    public Button btnVolverPuntuacion;

    public PuntuacionFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_puntuacion, container, false);


        btnVolverPuntuacion = (Button) v.findViewById(R.id.btnVolverPuntuacion);

        mainActivity = (MainActivity) getActivity(); //Para referenciar el mainActivity en esta clase

        return v;
    }

    public void setController(MainActivityController controller) {
        btnVolverPuntuacion.setOnClickListener(controller);
    }
}
