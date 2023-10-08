import java.util.Scanner;

public class Panel_Control {
        private static Scanner scanner = new Scanner(System.in);

    public static Cliente crearClienteDesdeConsola() {
        System.out.println("Ingrese el nombre del cliente:");
        String nombreCliente = scanner.nextLine();

        System.out.println("Ingrese el teléfono del cliente:");
        String telefonoCliente = scanner.nextLine();

        System.out.println("Ingrese el correo del cliente:");
        String correoCliente = scanner.nextLine();

        System.out.println("Ingrese el nombre de la mascota:");
        String nombreMascota = scanner.nextLine();

        System.out.println("Ingrese el peso de la mascota:");
        double pesoMascota = scanner.nextDouble();
        scanner.nextLine();  // Consumir la nueva línea

        System.out.println("Ingrese la raza de la mascota:");
        String razaMascota = scanner.nextLine();

        System.out.println("Ingrese el tipo de animal de la mascota:");
        String tipoAnimalMascota = scanner.nextLine();

        // Crear una instancia de Mascota y Cliente
        Mascota mascota = new Mascota(nombreMascota, pesoMascota, razaMascota, tipoAnimalMascota);
        Cliente cliente = new Cliente(nombreCliente, telefonoCliente, correoCliente, mascota);

        return cliente;
    }
}
