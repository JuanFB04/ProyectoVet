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
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.io.Serializable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Funciones{
    
    //El método'agendarCita' pide que se ingrese una fecha para luego registrar una cita en esa fecha, además ordenas las citas en orden de proximidad
    public static void agendarCita(Scanner scanner) {
    // Estas líneas de código inicializan una lista llamada `Citas` y se crea el objeto `Panel_Control` llamado `panel` para interactuar con el usuario.
    Panel_Control panel = new Panel_Control();
    List<LocalDate> Citas = new ArrayList<>();

    // El bucle `while (true)` es un bucle infinito que continúa ejecutándose hasta que se encuentra una declaración de interrupción.
    while (true) {
        String citaingresada= panel.pedirFechaCita(scanner);
        if (citaingresada.equalsIgnoreCase("salir")) {
            break;
        }
        // Este bloque de código es responsable de analizar la entrada del usuario como una fecha y agregarla a la lista `Citas`.
        try {
            LocalDate fecha = LocalDate.parse(citaingresada);
            Citas.add(fecha);
        } catch (Exception e) {
            panel.mensaje("Ha ingresado la fecha con un formato incorrecto, por favor, inténtelo de nuevo.");
        }
    }

    ordenarproximas(Citas);

    // Este código imprime la lista ordenada de fechas ("Citas") y luego itera sobre cada fecha en la lista y la imprime.
    panel.mensaje("Estas son las citas ordenadas por proximidad:");
    for (LocalDate cita : Citas) {
        System.out.println(cita);
    }
    panel.mensaje("\nPresione cualquier tecla para regresar");
    scanner.nextLine();
}

    //El método 'ordenarproximas' es un método privado que toma como parámetro la lista.
    private static void ordenarproximas(List<LocalDate> citas) {
    LocalDate proximafecha = LocalDate.now();

    // El código `Collections.sort(citas, (uno, dos) -> {...})` ordena las fechas (`citas`) según su proximidad respecto a la fecha actual (`proximafecha`).
    Collections.sort(citas, (uno, dos) -> {
        long diferencia = ChronoUnit.DAYS.between(proximafecha, uno);
        long diferencias = ChronoUnit.DAYS.between(proximafecha, dos);
        return Long.compare(Math.abs(diferencia), Math.abs(diferencias));
    });
}

}
//Clase creada para la persistencia de datos
class Base implements Serializable{
    private ArrayList<Cliente> listclientes;

    //constructor
    public Base(ArrayList<Cliente> listclientes){
        this.listclientes=listclientes;
    }

    //get
    public ArrayList<Cliente> getListClientes(){return listclientes;}

    //Agrega un cliente a la lista de clientes ya creada
    public void addCliente(Cliente cliente){
        listclientes.add(cliente);
    }
    
}

//Clase creada para la persistencia de datos
class Archivo implements Serializable{
    //Guarda a la clase Base en un archivo
    public void guardar(Base base) throws FileNotFoundException, IOException{
        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("baseVet.obj"));
        salida.writeObject(base);
        salida.close();
    }
    //Lee el archivo guardado y pasa su información a un objeto de tipo Base
    public Base recuperar() throws IOException, ClassNotFoundException{
        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("baseVet.obj"));
        Base base = (Base) entrada.readObject();
        entrada.close();
        return base;
    }

}