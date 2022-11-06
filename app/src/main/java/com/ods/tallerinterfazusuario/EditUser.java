package com.ods.tallerinterfazusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ods.tallerinterfazusuario.modelo.ConsultasUsuario;
import com.ods.tallerinterfazusuario.modelo.Usuario;

import java.util.List;

public class EditUser extends AppCompatActivity {
    ConsultasUsuario consultasUsuario;
    EditText nameEdit, telefonoEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        consultasUsuario = new ConsultasUsuario();
        nameEdit = findViewById(R.id.name_edit);
        telefonoEdit = findViewById(R.id.edit_telefono);
        llenarInformacion();
    }
    public void guardarEdicion (View view){
        List<Usuario> user =consultasUsuario.actualizarUsuario(ConsultasUsuario.usuarioInicio, nameEdit.getText().toString(), telefonoEdit.getText().toString());
        if(user.size() > 0){
            regresarAnterior();
        }else{
            Toast.makeText(getApplicationContext(), "No fue posible actualizar la información, Intentelo m{as tarde", Toast.LENGTH_LONG).show();
        }
    }
    private void regresarAnterior(){
        Intent intent = new Intent(this, PortalInicio.class);
        startActivity(intent);
    }
    private void llenarInformacion(){
        List<Usuario> user = consultasUsuario.buscarUsuario(ConsultasUsuario.usuarioInicio);
        if(user.size() > 0){
            Usuario usuario = user.get(0);
            nameEdit.setText(usuario.getNombre());
            telefonoEdit.setText(usuario.getNumeroTelefono());
        }else{
            Toast.makeText(getApplicationContext(), "Lo sentimos ocurrio un error inesperado", Toast.LENGTH_LONG).show();
            regresarAnterior();
        }
    }
}