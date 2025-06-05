package Vista;

import Controlador.DatosLogin;
import Controlador.Login;
import java.util.Scanner;

/**
 * Clase responsable de interactuar con el usuario por consola.
 * Controla el menú principal y el flujo de login.
 */
public class ConsolaLogin {
    Scanner scanner = new Scanner(System.in);
    DatosLogin datos = new DatosLogin();
    Login login = new Login();

    /**
     * Controla el ciclo principal del menú del sistema.
     */
    public void menu(String[] args ) {

        String opcion;
        do {
            mostrarOpciones();
            opcion = scanner.nextLine();
            ejecutarOpcion(opcion);

        } while (!opcion.equals("2"));
        scanner.close();
    }
    /**
     * Muestra las opciones disponibles para el usuario.
     */
    private void mostrarOpciones() {
        System.out.println("====== MENÚ PRINCIPAL ======");
        System.out.println("1. Iniciar sesión.");
        System.out.println("2. Salir");
        System.out.print("Selecciona una opción: ");

    }

    /**
     * Ejecuta la opción seleccionada por el usuario.
     *
     * @param opcion opción ingresada por el usuario
     */
    private void ejecutarOpcion(String opcion) {
        switch (opcion) {
            case "1" -> manejarLogin();
            case "2" -> System.out.println("Saliendo del programa...");
            default -> System.out.println("Opción inválida, intenta de nuevo.");
        }

    }

    /**
     * Solicita usuario y contraseña, y muestra el resultado.
     */
    private void manejarLogin() {
        // TODO: Llamar a login.autenticar() y mostrar mensaje según resultado
        System.out.print("Ingresa tu usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingresa tu contraseña: ");
        String clave = scanner.nextLine();
        Login.formatearCredenciales(usuario,clave);
        Login.autenticar(usuario,clave,DatosLogin.getCredenciales());

    }
}