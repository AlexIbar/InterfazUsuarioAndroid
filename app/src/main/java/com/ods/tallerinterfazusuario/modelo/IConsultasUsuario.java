package com.ods.tallerinterfazusuario.modelo;

import java.math.BigInteger;
import java.util.List;

public interface IConsultasUsuario {
    public List<Usuario> buscarUsuario(String correo);
    public List<Usuario> crearUsuario(String nombre, String correo, String numeroTelefono, String contrasena);
    public List<Usuario> actualizarUsuario(String correo, String nombre, String numeroTelefono);
    public Boolean validarPassword(String correo, String contrasena);
    public Boolean actualizarPassword(String correo, String oldContrasena, String newContrasena);
    public Boolean eliminarUsuario(String correo, String contrasena);
}
