/**
 * Universidad del Valle de Guatemala
 * Programación orientada a objetos
 * @author Juan Ignacio Figueroa 23092
 * @author María Alejandra Martinez Vásquez - 231426
 * @author Marian Montejo- 23352
 * @author Sandra Pineda-231137
 * @fechaCreacion 05/10/23
 * @fechaMod 05/11/23
 */
import java.util.Scanner;
import java.io.IOException;
import java.sql.ResultSet;

public class Programa_Vacunacion {
    public static void main(String[] args)throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Panel_Control panel = new Panel_Control();
        BaseDeDatosSQLite baseDeDatos = new BaseDeDatosSQLite(); // Crear una instancia de la clase
        // El código crea una instancia de la clase `Autenticacion` con ella llama al método `registrar` en el objeto `autenticacion` para
        // registrar un usuario con el nombre de usuario 
        Autenticacion autenticacion = new Autenticacion();
        
        // Agregar un usuario administrador al iniciar la aplicación
        autenticacion.registrar("administrador", "12345");

        // El bucle while (true)` es un bucle infinito que continúa ejecutándose hasta que finaliza el programa
        while (true) {
            System.out.println("Bienvenido, seleccione una de las siguientes opciones: ");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            
            int opcion = scanner.nextInt();

            // Este bloque de código maneja la opción para iniciar sesión
            if (opcion == 1) {
                System.out.print("Usuario: ");
                String nombreUsuario = scanner.next();
                System.out.print("Contraseña: ");
                String contrasena = scanner.next();

                if (autenticacion.autenticar(nombreUsuario, contrasena)) {
                    System.out.println("Inicio de sesión exitoso.");
                    break;
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
            }else {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }

        int funcion;
        do {
            funcion = panel.elegirFuncion(scanner);
            switch (funcion) {
                case 1: //Se piden los datos del cliente y se guardan en una base de datos
                    Cliente cliente = panel.crearClienteDesdeConsola(scanner);
                    baseDeDatos.insertarCliente(cliente.getNombre(), cliente.getTelefono(), cliente.getCorreo());
                    break;

                case 2: //Se abre la base de datos para desplegar todos los clientes registrados
                     ResultSet clientes = baseDeDatos.obtenerTodosLosClientes();
                    break;

                    case 3: // Se calcula y muestra dosis de medicamento para la mascota
                    Mascota mascota = panel.pedirMascota(scanner, baseDeDatos.getListClientes());
                    int idMedicamento = panel.pedirMedicamento(scanner);
                
                    Medicamentos medicamentos = new Medicamentos();
                
                    switch (idMedicamento) {
                        case 1:
                            medicamentos.calcularDosisXilacina(mascota, panel);
                            break;
                        case 2:
                            medicamentos.calcularDosisKetamina(mascota, panel);
                            break;
                        case 3:
                            medicamentos.calcularDosisCerenia(mascota, panel);
                            break;
                        case 4:
                            medicamentos.calcularDosisMetoclop(mascota, panel);
                            break;
                        default:
                            panel.mensaje("Medicamento no válido.");
                    }
                    break;
                
                case 4://Se agenda una cita y demuestra la lista de citas en orden de proximidad, en la entrega final se agregará persistencia de datos para que se guarden las citas
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
