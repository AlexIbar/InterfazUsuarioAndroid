package com.ods.tallerinterfazusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ods.tallerinterfazusuario.modelo.ConsultasUsuario;
import com.ods.tallerinterfazusuario.modelo.Usuario;

import java.util.List;

public class PortalInicio extends AppCompatActivity {
    ImageView avatar;
    TextView userEmail, userName, userTel;
    ConsultasUsuario consultasUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal_inicio);
        avatar = findViewById(R.id.icon_user);
        userEmail =findViewById(R.id.user_email);
        userName =findViewById(R.id.user_name);
        userTel =findViewById(R.id.user_tele);
        avatar.setImageResource(R.drawable.icon_user);
        Log.d("Usuario desde PortalInicio", ConsultasUsuario.usuarioInicio);
        consultasUsuario=new ConsultasUsuario();
        this.getUser();

    }
    private void getUser(){
      List<Usuario> user = consultasUsuario.buscarUsuario(ConsultasUsuario.usuarioInicio);
      if(user.size() > 0){
          Usuario usuario =user.get(0);
          userName.setText(usuario.getNombre());
          userEmail.setText(usuario.getCorreo());
          userTel.setText((CharSequence) usuario.getNumeroTelefono());
      }
    };
    public void editarUsuario(View view){
        Intent intent = new Intent(this, EditUser.class);
        startActivity(intent);
    }
}