package sanchez.daniel.triviathewalkingdead;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by daniel.rodriguez on 24/01/2017.
 */
public class MainActivityController implements View.OnClickListener {
    MainActivity vista;

    public MainActivityController(MainActivity vista) {
        this.vista = vista;
    }

    @Override
    public void onClick(View view) { //onClick botones
        if (view.getId() == R.id.btnStart) {
            Intent intent = new Intent(vista, PreguntasRespuestas.class); //Inicio de juego
            vista.startActivity(intent);
            vista.finish();//Mata la vista MainActivity

        } else if (view.getId() == R.id.btnPuntuacion) { //Pantalla Puntuación
            vista.cambiarFragment(3);

        } else if (view.getId() == R.id.btnVolverPuntuacion) { //Pantalla Inicio
            vista.cambiarFragment(2);

        } else if (view.getId() == R.id.btnAjustes) { //Pantalla Ajustes
            vista.cambiarFragment(4);

        } else if (view.getId() == R.id.btnCambiarNick) { //Diálogo para cambiar nick
            final EditText input = new EditText(vista);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            input.setLayoutParams(lp);

            new AlertDialog.Builder(vista)
                    .setTitle("Cambio de Nick")
                    .setMessage("Introduzca el nuevo Nick:")
                    .setView(input)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() { // YES
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String nick = input.getText().toString(); // Se recoge lo introducido por usuario

                            //Pasar nuevo nick que aparecerá en fragment de puntuación
                            AlmacenDatos almacen = AlmacenDatos.getInstance(); //Se accede a clase AlmacenDatos
                            almacen.nick = nick; //Se accede a atributo nick de AlmacenDatos y se iguala a variable nick de esta clase

                            Toast.makeText(vista,"¡Nuevo Nick!", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() { // NO
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(vista, "No se cambió el Nick", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .show();

        } else if (view.getId() == R.id.btnTiempo) { //Diálogo para cambiar tiempo
            final CharSequence[] items = { "Fácil: 60 segundos", "Normal: 45 segundos", "Difícil: 25 segundos" };

            AlertDialog.Builder builder = new AlertDialog.Builder(vista);
            builder.setTitle("Cambio de Tiempo");

            builder.setSingleChoiceItems(items, -1,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int item) {

                        }
                    });
            builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() { // YES
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    /// Se recoge el tiempo y pasarlo a preguntasrespuestas


                    Toast.makeText(vista,"¡Nuevo tiempo establecido!", Toast.LENGTH_SHORT).show();
                }
            })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() { // NO
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(vista, "No se cambió el tiempo", Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.setIcon(android.R.drawable.ic_dialog_info);
            builder.show();

        } else if (view.getId() == R.id.btnVolverAjustes) { //Pantalla Inicio
            vista.cambiarFragment(2);

        } else if (view.getId() == R.id.btnAbout) { //Pantalla About
            vista.cambiarFragment(5);

        } else if (view.getId() == R.id.btnVolverAbout) { //Pantalla Inicio
            vista.cambiarFragment(2);
        }
    }
}