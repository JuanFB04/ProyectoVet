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
import java.util.ArrayList;

public class Programa_Vacunacion {
    public static void main(String[] args)throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Panel_Control panel = new Panel_Control();
        Base base = new Base(new ArrayList<Cliente>());
        Archivo archivo = new Archivo();
        try {
            base = archivo.recuperar();
            System.out.println("Cargando base de datos");
        } catch (Exception e) {
            System.out.println("Creando nueva base de datos");
        }


        int funcion;
        do {
            funcion = panel.elegirFuncion(scanner);
            switch (funcion) {
                case 1: //Se piden los datos del cliente y se guardan en una base de datos
                    Cliente cliente = panel.crearClienteDesdeConsola(scanner);
                    base.addCliente(cliente);
                    archivo.guardar(base);
                    break;

                case 2: //Se abre la base de datos para desplegar todos los clientes registrados
                    panel.listarClientes(scanner,base.getListClientes());
                    break;

                case 3: //Se calcula y muestra dosis de medicamento para la mascota
                    Funciones.calcularDosis(scanner, base);
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
