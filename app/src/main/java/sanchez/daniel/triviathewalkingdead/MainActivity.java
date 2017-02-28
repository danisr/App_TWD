package sanchez.daniel.triviathewalkingdead;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MainActivityController mainActivityController;
    CreditosFragment creditosFragment;
    InicioFragment inicioFragment;
    PuntuacionFragment puntuacionFragment;
    AjustesFragment ajustesFragment;
    AboutFragment aboutFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityController = new MainActivityController(this);

        FragmentManager fm = getSupportFragmentManager(); //Referencia el objeto que gestiona los fragmentos

        creditosFragment = (CreditosFragment) fm.findFragmentById(R.id.fragmentoCreditos); //Acceder a variables internas
        inicioFragment = (InicioFragment) fm.findFragmentById(R.id.fragmentoInicio);
        puntuacionFragment = (PuntuacionFragment) fm.findFragmentById(R.id.fragmentoPuntuacion);
        ajustesFragment = (AjustesFragment) fm.findFragmentById(R.id.fragmentoAjustes);
        aboutFragment = (AboutFragment) fm.findFragmentById(R.id.fragmentoAbout);

        inicioFragment.setController(mainActivityController); //Para conectar el inicio con el controller
        puntuacionFragment.setController(mainActivityController);
        ajustesFragment.setController(mainActivityController);
        aboutFragment.setController(mainActivityController);

        cambiarFragment(1); //Pasa a pantalla de creditos
    }

    public void cambiarFragment(int ifrg) { //Recibe por parámetro el número del fragment al que se va a cambiar
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.hide(creditosFragment); //Se ocultan todos los fragments
        transaction.hide(inicioFragment);
        transaction.hide(puntuacionFragment);
        transaction.hide(ajustesFragment);
        transaction.hide(aboutFragment);

        if (ifrg == 1) { //Si lo que llega por parámetro es un 1 se muestra creditosFragment
            transaction.show(creditosFragment);
        } else if (ifrg == 2) {
            transaction.show(inicioFragment);
        } else if (ifrg == 3) {
           transaction.show(puntuacionFragment);
        } else if (ifrg == 4) {
            transaction.show(ajustesFragment);
        } else if (ifrg == 5) {
            transaction.show(aboutFragment);
        }
        transaction.commit(); //Realiza la transacción
    }











    /*
    //Para que en login el usuario elija su nacionalidad y se use en ranking de puntuaciones
    public void spinner() {
        //Opción 1: Inicializar con array de Strings
        String [] elements = new String[] {"España", "Francia", "Alemania", "Italia"};

        //Opción 2: Inicializar con ArrayList de Strings
        elementArray = new ArrayList<String>(); //Es lo mismo que el array de elements de arriba
        elementArray.add("Spain");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, elements);

        ArrayAdapter<?> adapterFromXML = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item);

        Spinner spinner = (Spinner) findViewById(R.id.sp_spinner);
        //spinner.setAdapter(adapter); //ArrayAdapter<String> adapter
        spinner.setAdapter(adapterFromXML); //ArrayAdapter<?> adapterFromXML
        spinner.setSelection(2); //Para elegir por donde queremos que empiece el Spinner

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                TextView textView = (TextView) findViewById(R.id.tv_text);
                textView.setText(adapterView.getAdapter().getItem(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                TextView textView = (TextView) findViewById(R.id.tv_text);
                textView.setText("No ");
            }
        });
    }*/

}