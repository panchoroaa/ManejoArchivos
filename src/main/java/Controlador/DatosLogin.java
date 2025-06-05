package Controlador;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatosLogin {

    private static List<String> credenciales = null;

    public DatosLogin() {
        credenciales = new ArrayList<>();
        cargarCredenciales("login.txt");
    }

    private void cargarCredenciales(String nombreArchivo) {
        try (BufferedReader br = crearLectorArchivo(nombreArchivo)) {
            leerLineasValidas(br);
        } catch (IOException e) {
            errorLectura(e);
        }
    }

    private BufferedReader crearLectorArchivo(String nombreArchivo) throws IOException {
        return new BufferedReader(new FileReader(nombreArchivo));
    }


    private void leerLineasValidas(BufferedReader br) throws IOException {
        String linea;
        while ((linea = br.readLine()) != null) {
            if (validarLinea(linea)) {
                agregarCredencial(linea.trim());
            }
        }
    }

    private boolean validarLinea(String linea) {
        return linea != null && linea.contains(";") && !linea.trim().isEmpty();
    }

    private void agregarCredencial(String credencial) {
        credenciales.add(credencial);
    }

    private void errorLectura(IOException e) {
        System.out.println("Error al leer el archivo de login: " + e.getMessage());
    }

    public static DatosLogin getCredenciales() {
        return (DatosLogin) credenciales;
    }
}