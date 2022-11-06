package com.ods.tallerinterfazusuario.modelo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ConsultasUsuario implements IConsultasUsuario{
    public static String usuarioInicio=null;

    public String getUsuarioInicio() {
        return usuarioInicio;
    }

    public void setUsuarioInicio(String usuarioInicio) {
        this.usuarioInicio = usuarioInicio;
    }

    @Override
    public List<Usuario> buscarUsuario(String correo) {
        List<Usuario> listUsuario = Usuario.find(Usuario.class, "correo="+"\'"+correo+"\'");
        return listUsuario;
    }

    @Override
    public Boolean validarPassword(String correo, String contrasena) {
        List<Usuario> listUsuario = Usuario.find(Usuario.class, "correo="+"\'"+correo+"\'"+" and contrasena="+"\'"+contrasena+"\'");
        if(listUsuario.size() <= 0){
            return false;
        }
        return true;
    }

    @Override
    public List<Usuario> crearUsuario(String nombre, String correo, String  numeroTelefono, String contrasena) {
        List<Usuario> usuarioExist = this.buscarUsuario(correo);
        if(usuarioExist.size() == 0){
            Usuario createUser = new Usuario(nombre, correo, numeroTelefono, contrasena);
            createUser.save();
            List<Usuario> usuarioCreado = this.buscarUsuario(correo);
            return usuarioCreado;
        }
        return null;
    }

    @Override
    public List<Usuario> actualizarUsuario(String correo, String nombre, String numeroTelefono) {
        List<Usuario> usuarioExist = this.buscarUsuario(correo);
        if(usuarioExist.size() > 0){
            Usuario usuario = usuarioExist.get(0);
            usuario.setNombre(nombre);
            usuario.setNumeroTelefono(numeroTelefono);
            usuario.save();
            List<Usuario> user = new ArrayList<Usuario>();
            user.add(usuario);
            return user;
        }
        return null;
    }

    @Override
    public Boolean actualizarPassword(String correo, String oldContrasena, String newContrasena) {
        Boolean isUser = validarPassword(correo, oldContrasena);
        if(isUser){
            List<Usuario> traerUsuario = this.buscarUsuario(correo);
            Usuario usuario = traerUsuario.get(0);
            usuario.setContrasena(newContrasena);
            usuario.save();
            return true;
        }
        return false;
    }

    @Override
    public Boolean eliminarUsuario(String correo, String contrasena) {
        Boolean isUser = validarPassword(correo, contrasena);
        if(isUser){
            List<Usuario> traerUsuario = this.buscarUsuario(correo);
            Usuario usuario = traerUsuario.get(0);
            usuario.setEstado(false);
            usuario.save();
            return true;
        }
        return false;
    }
}
