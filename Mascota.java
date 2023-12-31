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
import java.io.Serializable;
public class Mascota implements Serializable{
    private String nombre;
    private String tipoAnimal;
    private String raza;
    private int edad;
    private double peso;

    public Mascota(String nombre, String tipoAnimal, String raza, int edad, double peso) {
        this.nombre = nombre;
        this.tipoAnimal = tipoAnimal;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        
    }

    // Getters y setters
    /**
     * @return
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return
     */
    public String getTipoAnimal() {
        return tipoAnimal;
    }
    /**
     * @param tipoAnimal
     */
    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    /**
     * @return
     */
    public String getRaza() {
        return raza;
    }
    /**
     * @param raza
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * @return
     */
    public int getEdad(){
        return edad;
    }
    /**
     * @param edad
     */
    public void setEdad(int edad){
        this.edad = edad;
    }

    /**
     * @return
     */
    public double getPeso() {
        return peso;
    }
    /**
     * @param peso
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

   
}


