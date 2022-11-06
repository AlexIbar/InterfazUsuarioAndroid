package com.ods.tallerinterfazusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ods.tallerinterfazusuario.modelo.ConsultasUsuario;
import com.ods.tallerinterfazusuario.modelo.IConsultasUsuario;
import com.ods.tallerinterfazusuario.modelo.Usuario;

import java.math.BigInteger;
import java.util.List;

import validadores.IValidador;
import validadores.Validar;

public class MainActivity extends AppCompatActivity {
    Validar valida;
    EditText nombreUsuario;
    EditText correoUsuario;
    EditText numeroTelefono;
    EditText contraseniaUsuario;
    ConsultasUsuario consultaUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.valida = new Validar();
        setContentView(R.layout.activity_main);
        nombreUsuario = (EditText) findViewById(R.id.nombreRegistro);
        correoUsuario = (EditText) findViewById(R.id.emailRegistro);
        numeroTelefono = (EditText) findViewById(R.id.numeroTelefono);
        contraseniaUsuario = (EditText) findViewById(R.id.contrasenaRegistro);
        consultaUsuario = new ConsultasUsuario();
    }
    public void crearUsuario(View view){
        if(validaCrearUsuario()){
            //Crear usuario
            List<Usuario> usuario = consultaUsuario.crearUsuario(
                    nombreUsuario.getText().toString(),
                    correoUsuario.getText().toString(),
                    numeroTelefono.getText().toString(),
                    contraseniaUsuario.getText().toString()
            );
            if(usuario.size() == 0 || usuario == null){
                Toast.makeText(getApplicationContext(), "Usuario no creado", Toast.LENGTH_LONG).show();
            }else {
                ConsultasUsuario.usuarioInicio=correoUsuario.getText().toString();
                Intent intent = new Intent(this, PortalInicio.class);
                startActivity(intent);
            }
        }
    }
    public boolean validaCrearUsuario(){
        if(!valida.validarNombre(nombreUsuario.getText().toString())){
            nombreUsuario.setError("Nombre de usuario requerido");
            return false;
        }
        if(!valida.validarCorreo(correoUsuario.getText().toString())){
            correoUsuario.setError("Email no valido");
            return false;
        }
        if(!valida.validarNumeroTelefono(numeroTelefono.getText().toString())){
            numeroTelefono.setError("Numero de telefono no valido");
            return false;
        }
        if(!valida.validarContrasenia(contraseniaUsuario.getText().toString())){
            contraseniaUsuario.setError("Contraseña no valida");
            return false;
        }
        return true;
    }

    public void inicioSesion (View view){
        Intent intent = new Intent(this, InicioActivity.class);
        startActivity(intent);
    }
}