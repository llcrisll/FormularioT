package com.example.cristinalopez.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_c);

        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString(getString(R.string.key_param_nombre));
        String descripcion = extras.getString(getString(R.string.key_param_descripcion));
        String tel = extras.getString(getString(R.string.key_param_tel));
        String mail = extras.getString(getString(R.string.key_param_mail));
        String fecha = extras.getString(getString(R.string.key_param_fecha));

        TextView textViewNom3 = (TextView)findViewById(R.id.textViewNom3);
        textViewNom3.append(nombre);
        TextView textViewDesc7 = (TextView) findViewById(R.id.textViewDesc7);
        textViewDesc7.append(descripcion);
        TextView textViewTel5 = (TextView) findViewById(R.id.textViewTel5);
        textViewTel5.append(tel);
        TextView textViewMail6 = (TextView) findViewById(R.id.textViewMail6);
        textViewMail6.append(mail);
        TextView textViewFec4 = (TextView) findViewById(R.id.textViewFec4);
        textViewFec4.append(fecha);
    }

    public void irEditar(View v){
        TextView textViewNom3 = (TextView) findViewById(R.id.textViewNom3);
        TextView textViewMail6 = (TextView) findViewById(R.id.textViewMail6);
        TextView textViewTel5 = (TextView) findViewById(R.id.textViewTel5);
        TextView textViewDesc7 = (TextView) findViewById(R.id.textViewDesc7);
        TextView textViewFec4 = (TextView) findViewById(R.id.textViewFec4);
        String nombre = textViewNom3.getText().toString();
        String descripcion = textViewDesc7.getText().toString();
        String mail = textViewMail6.getText().toString();
        String tel = textViewTel5.getText().toString();
        String fecha = textViewFec4.getText().toString();

        Intent intent = new Intent(this,MainActivityF.class);
        intent.putExtra(getString(R.string.key_param_nombre), nombre);
        intent.putExtra(getString(R.string.key_param_descripcion), limpiarDesc(descripcion));
        intent.putExtra(getString(R.string.key_param_tel), limpiarTel(tel));
        intent.putExtra(getString(R.string.key_param_mail), limpiarMail(mail));
        intent.putExtra(getString(R.string.key_param_fecha), limpiarFecha(fecha));

        startActivity(intent);
    }

    /*Elimina el texto concatenado al inicio*/
    public String limpiarFecha(String fecha){
        String textoMail = fecha;
        if(fecha!=null&& fecha.startsWith(getString(R.string.fec_nacimiento))){
            textoMail = fecha.substring(getString(R.string.fec_nacimiento).length());
        }
        return textoMail;
    }

    public String limpiarMail(String mail){
        String textoMail = mail;
        if(mail!=null&& mail.startsWith(getString(R.string.mail))){
            textoMail = mail.substring(getString(R.string.mail).length());
        }
        return textoMail;
    }

    public String limpiarTel(String tel){
        String texto = tel;
        if(tel!=null&& tel.startsWith(getString(R.string.tel))){
            texto = tel.substring(getString(R.string.tel).length());
        }
        return texto;
    }

    public String limpiarDesc(String desc){
        String texto = desc;
        if(desc!=null&& desc.startsWith(getString(R.string.des))){
            texto = desc.substring(getString(R.string.des).length());
        }
        return texto;
    }


}
