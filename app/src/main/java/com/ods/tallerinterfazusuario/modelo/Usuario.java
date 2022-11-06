package com.ods.tallerinterfazusuario.modelo;

import com.orm.SugarRecord;

import java.math.BigInteger;

public class Usuario extends SugarRecord{
    private String nombre;
    private String correo;
    private String numeroTelefono;
    private String contrasena;
    private Boolean estado;

    public Usuario(){
        super();
    }

    public Usuario (
           String nombre,
           String correo,
           String numeroTelefono,
           String contrasena
    ){
        this.nombre=nombre;
        this.correo=correo;
        this.numeroTelefono=numeroTelefono;
        this.contrasena=contrasena;
        this.estado=true;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
