package com.ods.tallerinterfazusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ods.tallerinterfazusuario.modelo.ConsultasUsuario;
import com.ods.tallerinterfazusuario.modelo.IConsultasUsuario;
import com.ods.tallerinterfazusuario.modelo.Usuario;

import java.util.List;

import validadores.Validar;

public class InicioActivity extends AppCompatActivity {
    EditText correoUsuario;
    EditText contraseniaUsuario;
    Validar valida;
    ConsultasUsuario consultasUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        correoUsuario = findViewById(R.id.emailInicio);
        contraseniaUsuario = findViewById(R.id.contrasenaInicio);
        this.valida = new Validar();
        this.consultasUsuario = new ConsultasUsuario();

        //Quitar
        //Intent intent = new Intent(this, PortalInicio.class);
        //startActivity(intent);
    }

    public void crearUsuario(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void inicioSesion(View view){
        String correo = correoUsuario.getText().toString();
        String contrasenia = contraseniaUsuario.getText().toString();

        Log.d(correo, contrasenia);
        Log.d("", "Mensaje");
        if(validaUsuario()){
            List<Usuario> usuario = consultasUsuario.buscarUsuario(correo);
            if(usuario.size() > 0 ){
                Boolean canPasar =this.consultasUsuario.validarPassword(correo,contrasenia);
                Log.d("Puede pasar", String.valueOf(canPasar));
                if(canPasar){
                    ConsultasUsuario.usuarioInicio=correo;
                    //Inicio sesion
                    Intent intent = new Intent(this, PortalInicio.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Usuario y/o contraseña no valida", Toast.LENGTH_LONG).show();
                }
            }else {
                Toast.makeText(getApplicationContext(), "Usuario y/o contraseña no valida", Toast.LENGTH_LONG).show();
            }
        }
    };
    public boolean validaUsuario(){
        if(!valida.validarCorreo(correoUsuario.getText().toString())){
            correoUsuario.setError("Email no valido");
            return false;
        }
        if(!valida.validarContrasenia(contraseniaUsuario.getText().toString())){
            contraseniaUsuario.setError("Contraseña no valida");
            return false;
        }
        return true;
    }
}