/**
 * Universidad del Valle de Guatemala
 * Programación orientada a objetos
 * @author Juan Ignacio Figueroa 23092
 * @author María Alejandra Martinez Vásquez - 231426
 * @author Marian Montejo- 23352
 * @author Sandra Pineda-231137
 * @fechaCreacion 05/10/23
 * @fechaMod 09/10/12
 */
import java.util.Scanner;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Programa_Vacunacion {
    public static void main(String[] args)throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Panel_Control panel = new Panel_Control();
        BaseDeDatosSQLite baseDeDatos = new BaseDeDatosSQLite(); // Crear una instancia de la clase

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
