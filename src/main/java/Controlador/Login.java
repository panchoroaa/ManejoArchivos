package Controlador;

public class Login {

    public static void autenticar(String usuario, String clave, DatosLogin credenciales) {
        String intento = formatearCredenciales(usuario, clave);
        verificarCredenciales(intento, credenciales);
    }


    public static String formatearCredenciales(String usuario, String clave) {
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