package Controlador;

import Modelo.DatosLogin;

public class Login {

    public static boolean autenticar(String usuario, String clave, DatosLogin credenciales) {
        String intento = formatearCredenciales(usuario, clave);
        return verificarCredenciales(intento, credenciales);
    }


    private static String formatearCredenciales(String usuario, String clave) {
        return usuario + ";" + clave;
    }

    private static boolean verificarCredenciales(String intento, DatosLogin datos) {
        for (String credencial : datos.getCredenciales()) {
            if (credencial.equals(intento)) {
                return true;
            }
        }
        return false;
    }
}