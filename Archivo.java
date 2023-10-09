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
import java.io.Serializable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Archivo implements Serializable{//Clase creada para la persistencia de datos
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