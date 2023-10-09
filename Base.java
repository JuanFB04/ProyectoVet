/**
 * Universidad del Valle de Guatemala
 * Programación orientada a objetos
 * @author Juan Ignacio Figueroa 23092
 * @author María Alejandra Martinez Vásquez - 231426
 * @author Marian Montejo- 23352
 * @author Sandra Pineda-231137
 * @fechaCreacion 08/10/23
 * @fechaMod 09/10/12
 */
import java.util.ArrayList;
import java.io.Serializable;

public class Base implements Serializable{ //Clase creada para la persistencia de datos
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