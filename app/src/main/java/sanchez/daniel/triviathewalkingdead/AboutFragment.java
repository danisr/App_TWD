package sanchez.daniel.triviathewalkingdead;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by user on 07/02/2017.
 */

public class AboutFragment extends Fragment {
    public MainActivity mainActivity;
    public TextView txtIntroduccion;
    public TextView txtIntroduccionTexto;
    public TextView txtComoJugar;
    public TextView txtComoJugarTexto;
    public TextView txtContacto;
    public TextView txtContactoTexto;
    public Button btnVolverAbout;

    public AboutFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_about, container, false);
        txtIntroduccion = (TextView) v.findViewById(R.id.txtIntroduccion);
        txtIntroduccionTexto = (TextView) v.findViewById(R.id.txtIntroduccionTexto);
        txtComoJugar = (TextView) v.findViewById(R.id.txtComoJugar);
        txtComoJugarTexto = (TextView) v.findViewById(R.id.txtComoJugarTexto);
        txtContacto = (TextView) v.findViewById(R.id.txtContacto);
        txtContactoTexto = (TextView) v.findViewById(R.id.txtContactoTexto);
        btnVolverAbout = (Button) v.findViewById(R.id.btnVolverAbout);

        txtIntroduccionTexto.setText(this.getResources().getString(R.string.introduccion)); //Se recoge info de strings.xml
        txtComoJugarTexto.setText(this.getResources().getString(R.string.comoJugar));
        txtContactoTexto.setText(this.getResources().getString(R.string.contacto));

        mainActivity = (MainActivity) getActivity(); //Para referenciar el mainActivity en esta clase

        return v;
    }

    public void setController(MainActivityController controller) { //Listener del botón volver
        btnVolverAbout.setOnClickListener(controller);
    }
}