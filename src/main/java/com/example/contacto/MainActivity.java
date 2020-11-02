package com.example.contacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="Contacto" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Starting");
        //Obtenemos una referencia a los controles de la interfaz
        final EditText txtNombre = (EditText) findViewById(R.id.txtNombre);
        final EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
        final EditText txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        final EditText txtMensaje = (EditText) findViewById(R.id.txtMensaje);
        final DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        Button btnEnviar = (Button) findViewById(R.id.btnEnviar);
        Button btnCancelar = (Button) findViewById(R.id.btnCancelar);

        btnEnviar.setOnClickListener( (new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1;
                int year = datePicker.getYear();
                String date = day + "/" + month + "/" + year;

                //controlamos ingresos
                Boolean ingresoOK = true;
                if(txtNombre.getText().toString().isEmpty()){
                    txtNombre.setError("Dato obligatorio!");
                    ingresoOK = false;
                }
                if(txtEmail.getText().toString().isEmpty()){
                    txtEmail.setError("Dato obligatorio!");
                    ingresoOK = false;
                }
                if(txtMensaje.getText().toString().isEmpty()){
                    txtMensaje.setError("Dato obligatorio!");
                    ingresoOK = false;
                }

                //Creamos el Intent
                Intent intent =
                        new Intent(MainActivity. this ,
                                MostrarDatos.class);
                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();
                b.putString( "Nombre" , txtNombre.getText().toString());
                //Bundle c = new Bundle();
                b.putString("Email" , txtEmail.getText().toString());
                //Bundle d = new Bundle();
                b.putString("Telefono", txtTelefono.getText().toString());
                //Bundle e = new Bundle();
                b.putString("Mensaje", txtMensaje.getText().toString());
                b.putString("Fecha", date);

                //Añadimos la información al intent
                intent.putExtras(b);
                intent.putExtras(b);
                intent.putExtras(b);
                intent.putExtras(b);
                try {
                    if(ingresoOK== true){
                        //Iniciamos la nueva actividad
                        Toast.makeText(MainActivity.this, "Datos ingresados correctamente", Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }
                }catch (Exception ex){
                    Log.e(TAG, "onClick: ERROR"+ ex.getMessage());
                }


                //Log.e(TAG, "onClick: error");
                //Log.i(TAG, "onClick: info"+" "+txtNombre.getText()+" "+txtEmail.getText()+" "+txtMensaje);
                



            }
        }));
        btnCancelar.setOnClickListener( new View.OnClickListener(){
            //limpiamos el formulario
            @Override
            public void onClick (View v) {
                txtNombre.setText(null);
                txtEmail.setText(null);
                txtTelefono.setText(null);
                txtMensaje.setText(null);

            }
        });
        Log.d(TAG, "onCreate: Finishing");
    }
    
}