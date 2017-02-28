package sanchez.daniel.triviathewalkingdead;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by user on 25/01/2017.
 */

public class InicioFragment extends Fragment {
    public MainActivity mainActivity;
    public Button btnStart;
    public Button btnPuntuacion;
    public Button btnAjustes;
    public Button btnAbout;

    public InicioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_inicio, container, false);
        btnStart = (Button) v.findViewById(R.id.btnStart);
        btnPuntuacion = (Button) v.findViewById(R.id.btnPuntuacion);
        btnAjustes = (Button) v.findViewById(R.id.btnAjustes);
        btnAbout = (Button) v.findViewById(R.id.btnAbout);
        mainActivity = (MainActivity) getActivity(); //Para referenciar el mainActivity en esta clase

        return v;
    }

    public void setController(MainActivityController controller) {
        btnStart.setOnClickListener(controller);
        btnPuntuacion.setOnClickListener(controller);
        btnAjustes.setOnClickListener(controller);
        btnAbout.setOnClickListener(controller);
    }
}