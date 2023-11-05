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
import java.util.ArrayList;

public class Panel_Control {
    //Despliega el mensaje ingresado
    public void mensaje(String mensaje){
        System.out.println(mensaje);
    }

    //Despliega las opciones de funciones del programa y regresa la elegida
    public int elegirFuncion(Scanner scanner){
        System.out.println("\nElija una opción:\n| 1. Ingresar datos clientes\n| 2. Mostrar clientes\n| 3. Calcular dosis medicamento\n| 4. Agendar cita\n| 5. Salir");
        int funcion = scanner.nextInt();
        scanner.nextLine();
        return funcion;
    }

    //Toma los datos del cliente y mascota y regresa el objeto de cliente
    public Cliente crearClienteDesdeConsola(Scanner scanner) {
        System.out.println("Ingrese el nombre del cliente:");
        String nombreCliente = scanner.nextLine();

        System.out.println("Ingrese el teléfono del cliente:");
        String telefonoCliente = scanner.nextLine();

        System.out.println("Ingrese el correo del cliente:");
        String correoCliente = scanner.nextLine();

        System.out.println("Ingrese el nombre de la mascota:");
        String nombreMascota = scanner.nextLine();

        System.out.println("Ingrese el tipo de animal de la mascota:");
        String tipoAnimalMascota = scanner.nextLine();

        System.out.println("Ingrese la raza de la mascota:");
        String razaMascota = scanner.nextLine();

        System.out.println("Ingrese la edad de la mascota:");
        int edadMascota = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        System.out.println("Ingrese el peso de la mascota: (kg)");
        double pesoMascota = scanner.nextDouble();
        scanner.nextLine();  // Consumir la nueva línea

        // Crear una instancia de Mascota y Cliente
        Mascota mascota = new Mascota(nombreMascota, tipoAnimalMascota, razaMascota,  edadMascota, pesoMascota);
        Cliente cliente = new Cliente(nombreCliente, telefonoCliente, correoCliente, mascota);
        
        System.out.println("Cliente agregado con éxito");
        System.out.print("Presione cualquier tecla para regresar");
        scanner.nextLine();
        return cliente;
    }

    //Lista todos los atributos de cada cliente y su mascota
    public void listarClientes(Scanner scanner, ArrayList<Cliente> listclientes){
        System.out.println("Clientes registrados:");
        for(Cliente c:listclientes){
            Mascota m = c.getMascota();
            System.out.println("\nCliente: "+c.getNombre()+" | Tel: "+ c.getTelefono()+" | Correo: "+ c.getCorreo());
            System.out.println("Mascota: "+m.getNombre()+" | Tipo animal: "+m.getTipoAnimal()+" | Raza: "+m.getRaza()+" | Edad: "+m.getEdad()+" | Peso: "+m.getPeso()+" kg");
            System.out.print("\nPresione cualquier tecla para regresar");
            scanner.nextLine();
        }
    }

    //Pide la fecha para cita en cierto formato
    public String pedirFechaCita(Scanner scanner){
        System.out.print("Ingrese la fecha en la que desea calendarizar la cita: (YYYY-MM-DD) o escriba 'salir' para terminar: ");
        String citaingresada = scanner.nextLine();
        return citaingresada;
    }

    public int pedirMedicamento(Scanner scanner){
        System.out.println("Seleccione el número de medicamento:");
        System.out.println("1. Xilacina 2% (Perros)");
        System.out.println("2. Ketamina 10% (Perros)");
        System.out.println("3. Cerenia (Gatos)");
        System.out.println("4. Metoclop (Gatos)");
        System.out.println("5. Agromycin® 20 L.A. (Cerdos)");
        System.out.println("6. Amoxigentin® (Cerdos)");
        System.out.println("7. Pen Dexa Strep®(Caballos)");
        System.out.println("8. Enroflox® 10 (Caballos)");
        System.out.println("9. Modivitasan® (Cuyos)");
        System.out.println("10. Vitamino® B (Cuyos)");
        System.out.println("11. Agrosona® (Cabras)");
        System.out.println("12. Agrogenta®(Cabras)");
        int medicamento=0;
        try {
            medicamento = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
        
        }
        
        return medicamento;
    }

    public Mascota pedirMascota(Scanner scanner, ArrayList<Cliente> listclientes){
        System.out.println("Mascotas registradas:");
        ArrayList<Mascota> listmascotas= new ArrayList<Mascota>();
        for(Cliente c:listclientes){
            Mascota m = c.getMascota();
            System.out.println(m.getNombre());
            listmascotas.add(m);
        }
        System.out.println("Ingrese el nombre de la mascota a la que desea aplicar medicamento:");
        String nombreMascota = scanner.nextLine();
        Mascota mascotabuscada = new Mascota("", "","", 0, 0);
        for(Mascota mascota: listmascotas){
            if(mascota.getNombre().equalsIgnoreCase(nombreMascota)){
                mascotabuscada=mascota;
            }
        }
        return mascotabuscada;
    }
}
