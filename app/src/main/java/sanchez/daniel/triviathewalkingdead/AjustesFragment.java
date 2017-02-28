package sanchez.daniel.triviathewalkingdead;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by user on 14/02/2017.
 */

public class AjustesFragment extends Fragment {
    public MainActivity mainActivity;
    public Button btnCambiarNick;
    public Button btnTiempo;
    public Button btnVolverAjustes;

    public AjustesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ajustes, container, false);

        btnCambiarNick = (Button) v.findViewById(R.id.btnCambiarNick);
        btnTiempo = (Button) v.findViewById(R.id.btnTiempo);
        btnVolverAjustes = (Button) v.findViewById(R.id.btnVolverAjustes);

        mainActivity = (MainActivity) getActivity(); //Para referenciar el mainActivity en esta clase

        return v;
    }

    public void setController(MainActivityController controller) { //Listeners de cambio de nick, cambio de tiempo, botón volver
        btnCambiarNick.setOnClickListener(controller);
        btnTiempo.setOnClickListener(controller);
        btnVolverAjustes.setOnClickListener(controller);
    }
}