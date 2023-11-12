/**
 * Universidad del Valle de Guatemala
 * Programación orientada a objetos
 * @author Juan Ignacio Figueroa 23092
 * @author María Alejandra Martinez Vásquez - 231426
 * @author Marian Montejo- 23352
 * @author Sandra Pineda-231137
 * @fechaCreacion 05/10/23
 * @fechaMod 12/11/23
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Programa_Vacunacion {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Panel_Control panel = new Panel_Control();
        BaseDeDatosSQLite baseDeDatos = new BaseDeDatosSQLite(); 
        baseDeDatos.conexion();
        baseDeDatos.crearTablas();
        Autenticacion autenticacion = new Autenticacion();
        
        // Agregar un usuario administrador al iniciar la aplicación
        autenticacion.registrar("administrador", "12345");

        // El bucle while (true)` es un bucle infinito que continúa ejecutándose hasta que finaliza el programa
        while (true) {
            panel.mensaje("Bienvenido, seleccione una de las siguientes opciones: ");
            panel.mensaje("1. Iniciar sesión");
            panel.mensaje("2. Registrarse");
            
            int opcion = scanner.nextInt();

            // Este bloque de código maneja la opción para iniciar sesión
            if (opcion == 1) {
                panel.mensaje("Usuario: ");
                String nombreUsuario = scanner.next();
                panel.mensaje("Contraseña: ");
                String contrasena = scanner.next();

                if (autenticacion.autenticar(nombreUsuario, contrasena)) {
                    panel.mensaje("Inicio de sesión exitoso.");
                    break;
                } else {
                    panel.mensaje("Error: Inicio de sesión fallido.");
                }

            // Este bloque de código maneja la opción para registrar usuario
            } else if (opcion == 2) {
                
                panel.mensaje("Para crear una cuenta, ingrese los siguientes datos: ");
                panel.mensaje("Usuario: ");
                String nombreUsuario = scanner.next();
                panel.mensaje("Contraseña: ");
                String contrasena = scanner.next();

                autenticacion.registrar(nombreUsuario, contrasena);
                panel.mensaje("Usuario registrado con éxito.");
            }else {
                panel.mensaje("Opción no válida. Inténtelo de nuevo.");
            }
        }

        int funcion;
        do {
            funcion = panel.elegirFuncion(scanner);
            switch (funcion) {
                case 1: //Se piden los datos del cliente y se guardan en una base de datos
                    panel.crearClienteDesdeConsola(scanner);
                    baseDeDatos.cargarClientes();
                    break;
                case 2: //Se abre la base de datos para desplegar todos los clientes registrados
                    baseDeDatos.conexion();
                    baseDeDatos.cargarClientes();
                    ArrayList<Cliente> clientes = baseDeDatos.getClientes();
                    panel.mensaje("--Clientes--");
                    panel.listarClientes(scanner, clientes);
                    break;

                case 3: // Se calcula y muestra dosis de medicamento para la mascota
                    baseDeDatos.conexion();
                    baseDeDatos.cargarClientes();
                    Funciones.calcularDosis(scanner, baseDeDatos.getClientes());
                    break;
                
                case 4://Se agenda una cita y demuestra la lista de citas en orden de proximidad
                    Funciones.agendarCita(scanner);
                    break;
                
                case 5://Cerrar programa
                    panel.mensaje("Programa finalizado");
                    break;
                default:
                    break;
            }
        } while (funcion!=5);
    }
}
