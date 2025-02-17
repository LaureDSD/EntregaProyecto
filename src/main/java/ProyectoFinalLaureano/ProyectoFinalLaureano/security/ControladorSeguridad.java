package ProyectoFinalLaureano.ProyectoFinalLaureano.security;

import java.util.Random;

public class ControladorSeguridad {
    public static String ocultarNumero(String numero, int mostrar ) {
        if(numero==null){
            return numero;
        }
        return "*".repeat(numero.length() - mostrar) + numero.substring(numero.length() - mostrar);
    }

    public static String ocultarEmail(String email, int mostrar) {
        if(email==null){
            return null;
        }
        return "*".repeat(email.indexOf("@") - mostrar) + email.substring(email.indexOf("@") - mostrar, email.indexOf("@")) + email.substring(email.indexOf("@"));
    }
}
