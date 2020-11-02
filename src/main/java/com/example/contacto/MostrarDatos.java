package com.example.contacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MostrarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //agrego la barra de retroceso
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        //Obtenemos una referencia a los controles de la interfaz
        final TextView lblDatoNombre = (TextView) findViewById(R.id.lblDatoNombre);
        final TextView lblDatoEmail = (TextView) findViewById(R.id.lblDatoMail);
        final TextView lblDatoTelefono = (TextView) findViewById(R.id.lblDatoTelefono);
        final TextView lblDatoMensaje = (TextView) findViewById(R.id.lblDatoMensaje);
        TextView lblDatoFecha = (TextView) findViewById(R.id.lblDatoFecha);
        Button btnEditar = (Button) findViewById(R.id.btnEditar);
        Button btnConfirmar = (Button) findViewById(R.id.btnConfirmar);

        //Recuperamos la información pasada en el intent
        Bundle bundle = this .getIntent().getExtras();
        //Construimos el mensaje a mostrar
        lblDatoNombre.setText(bundle.getString("Nombre"));
        lblDatoEmail.setText(bundle.getString("Email"));
        lblDatoTelefono.setText(bundle.getString("Telefono"));
        lblDatoMensaje.setText(bundle.getString("Mensaje"));
        lblDatoFecha.setText(bundle.getString("Fecha"));

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MostrarDatos.this, R.string.Gracias, Toast.LENGTH_LONG).show();
            }
        });
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(MostrarDatos. this ,
                                MainActivity.class);
                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();
                b.putString( "Nombre" , lblDatoNombre.getText().toString());

                b.putString("Email" , lblDatoEmail.getText().toString());

                b.putString("Telefono", lblDatoTelefono.getText().toString());

                b.putString("Mensaje", lblDatoMensaje.getText().toString());

                //Añadimos la información al intent
                intent.putExtras(b);
                intent.putExtras(b);
                intent.putExtras(b);
                intent.putExtras(b);

                startActivity(intent);
            }
        });



    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}