package com.example.cristinalopez.formulario;

import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Calendar;

public class MainActivityF extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_f);

        if (getIntent() != null && getIntent().getExtras() != null) {
            Bundle extras = getIntent().getExtras();
            String nombre = extras.getString(getString(R.string.key_param_nombre));
            String descripcion = extras.getString(getString(R.string.key_param_descripcion));
            String tel = extras.getString(getString(R.string.key_param_tel));
            String mail = extras.getString(getString(R.string.key_param_mail));
            String fechaString = extras.getString(getString(R.string.key_param_fecha));

            EditText edtNombreUsuario = (EditText) findViewById(R.id.edtNombreUsuario);
            edtNombreUsuario.append(nombre);
            EditText edtDescripcion = (EditText) findViewById(R.id.edtDescripcion);
            edtDescripcion.append(descripcion);
            EditText edtMail = (EditText) findViewById(R.id.edtMail);
            edtMail.append(mail);
            EditText edtTelefono = (EditText) findViewById(R.id.edtTelefono);
            edtTelefono.append(tel);
            DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);

            datePicker.init(getAño(fechaString),getMes(fechaString),getDia(fechaString),null);
        }
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private int getMes(String fecha){
        int mes;
        System.out.println(fecha);
        System.out.println("mes"+fecha.substring(3,5));
        try{
            mes = Integer.valueOf(fecha.substring(3,5)).intValue();
            --mes;
        }catch (Exception e){
            mes = 0;
        }
        System.out.println(mes);
        return mes;
    }

    private int getDia(String fecha){
        int mes;
        System.out.println("dia"+fecha.substring(0,2));
        try{
            mes = Integer.valueOf(fecha.substring(0,2)).intValue();
        }catch (Exception e){
            mes = 0;
        }
        System.out.println("dia"+ mes);
        return mes;
    }

    private int getAño(String fecha){
        int mes;
        try{
            mes = Integer.valueOf(fecha.substring(6)).intValue();
        }catch (Exception e){
            mes = 0;
        }
        System.out.println("año"+mes);
        return mes;
    }

    public void irSiguiente(View v) {
        //busca referencia a memoria y la devuelve en un elemento tipo view
        //no se instancia porque ya existe.  Se realiza casteo porque todos los objetos son view
        EditText edtNombreUsuario = (EditText) findViewById(R.id.edtNombreUsuario);
        EditText edtDescripcion = (EditText) findViewById(R.id.edtDescripcion);
        EditText edtMail = (EditText) findViewById(R.id.edtMail);
        EditText edtTelefono = (EditText) findViewById(R.id.edtTelefono);
        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        String nombre = edtNombreUsuario.getText().toString();
        String descripcion = edtDescripcion.getText().toString();
        String tel = edtTelefono.getText().toString();
        String mail = edtMail.getText().toString();
        int dia = 0;
        int mes = 0;
        int año = 0;
        if(datePicker!=null){
            dia = datePicker.getDayOfMonth();
            mes = datePicker.getMonth();
            año = datePicker.getYear();
        }

        String dateCad = getDiaMesString(dia) + "/" + getDiaMesString(++mes) + "/" + año;

        Intent intent = new Intent(this, MainActivityC.class);
        intent.putExtra(getString(R.string.key_param_nombre), nombre);
        intent.putExtra(getString(R.string.key_param_descripcion), descripcion);
        intent.putExtra(getString(R.string.key_param_tel), tel);
        intent.putExtra(getString(R.string.key_param_mail), mail);
        intent.putExtra(getString(R.string.key_param_fecha),dateCad);

        startActivity(intent);
    }

    private String getDiaMesString(int mes){
        String mesCad="";
        try{
            mesCad=String.valueOf(mes);
            if(mesCad.length()==1){
                mesCad = "0"+mesCad;
            }
        }catch (Exception e){
            mesCad ="00";
        }

        return mesCad;
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MainActivityF Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.cristinalopez.formulario/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MainActivityF Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.cristinalopez.formulario/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
