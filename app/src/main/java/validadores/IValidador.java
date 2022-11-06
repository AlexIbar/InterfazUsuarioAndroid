package validadores;

public interface IValidador {
    public boolean validarNombre(String nombre);
    public boolean validarCorreo(String correo);
    public boolean validarNumeroTelefono(String numeroTelefono);
    public boolean validarContrasenia(String contrasenia);
}
