package validadores;

import android.util.Patterns;

import androidx.core.location.GnssStatusCompat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validar implements IValidador {

    @Override
    public boolean validarNombre(String nombre) {
        if(nombre.length() > 2) return true;
        return false;
    }

    @Override
    public boolean validarCorreo(String correo) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(correo).matches();
    }

    @Override
    public boolean validarNumeroTelefono(String numeroTelefono) {
        String numero = String.valueOf(numeroTelefono);
        if(numero.length() >= 7 && numero.length() <= 10) return true;
        return false;
    }

    @Override
    public boolean validarContrasenia(String contrasenia) {
        String REGEX = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#.$%^&+=*_-])"
                + "(?=\\S+$).{8,20}$";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(contrasenia);
        if (m.matches()){
            return true;
        }
        return false;
    }
}
