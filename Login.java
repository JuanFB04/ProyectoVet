/**
 * Universidad del Valle de Guatemala
 * Programación orientada a objetos
 * @author Juan Ignacio Figueroa 23092
 * @author María Alejandra Martinez Vásquez - 231426
 * @author Marian Montejo- 23352
 * @author Sandra Pineda-231137
 * @fechaCreacion 04/11/23
 * @fechaMod 04/11/23
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        // El código crea una instancia de la clase `Autenticacion` con ella llama al método `registrar` en el objeto `autenticacion` para
        // registrar un usuario con el nombre de usuario 
        Autenticacion autenticacion = new Autenticacion();
        
        // Agregar un usuario administrador al iniciar la aplicación
        autenticacion.registrar("administrador", "12345");

        Scanner scanner = new Scanner(System.in);

        // El bucle while (true)` es un bucle infinito que continúa ejecutándose hasta que finaliza el programa
        while (true) {
            System.out.println("Bienvenido, seleccione una de las siguientes opciones: ");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            
            int opcion = scanner.nextInt();

            // Este bloque de código maneja la opción para iniciar sesión
            if (opcion == 1) {
                System.out.print("Usuario: ");
                String nombreUsuario = scanner.next();
                System.out.print("Contraseña: ");
                String contrasena = scanner.next();

                if (autenticacion.autenticar(nombreUsuario, contrasena)) {
                    System.out.println("Inicio de sesión exitoso.");
                } else {
                    System.out.println("Error: Inicio de sesión fallido.");
                }

            // Este bloque de código maneja la opción para registrar usuario
            } else if (opcion == 2) {
                System.out.print("Para crear una cuenta, ingrese los siguientes datos: ");
                System.out.print("Usuario: ");
                String nombreUsuario = scanner.next();
                System.out.print("Contraseña: ");
                String contrasena = scanner.next();

                autenticacion.registrar(nombreUsuario, contrasena);
                System.out.println("Usuario registrado con éxito.");
            } else if (opcion == 3) {
                break;
            } else {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }

        scanner.close();
    }
}

class Usuarios {
    private String usuario;
    private String contrasena;
    
    public Usuarios(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String obtenerUsuario() {
        return usuario;
    }

    public String obtenerContrasena() {
        return contrasena;
    }
}

class Autenticacion {
    private List<Usuarios> usuariosRegistrados;

    public Autenticacion() {
        this.usuariosRegistrados = new ArrayList<>();
    }

    // El método `registrar` en la clase `Autenticacion` se utiliza para registrar un nuevo usuario.
    // Toma dos parámetros: `nombreUsuario` (nombre de usuario) y `contrasena` (contraseña).
    public void registrar(String nombreUsuario, String contrasena) {
        Usuarios nuevoUsuario = new Usuarios(nombreUsuario, contrasena);
        usuariosRegistrados.add(nuevoUsuario);
    }

    // El método `autenticar` en la clase `Autenticacion` se utiliza para autenticar a un usuario. Toma
    // dos parámetros: `nombreUsuario` (nombre de usuario) y `contrasena` (contraseña).
    public boolean autenticar(String nombreUsuario, String contrasena) {
        for (Usuarios usuario : usuariosRegistrados) {
            if (usuario.obtenerUsuario().equals(nombreUsuario) && usuario.obtenerContrasena().equals(contrasena)) {
                return true; // Usuario autenticado
            }
        }
        return false; // Autenticación fallida
    }
}
