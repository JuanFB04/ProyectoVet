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
public class Cliente implements Serializable {
    private String nombre;
    private String telefono;
    private String correo;
    private Mascota mascota;

    public Cliente(String nombre, String telefono, String correo, Mascota mascota) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.mascota = mascota;
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
    public String getTelefono() {
        return telefono;
    }
    /**
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return
     */
    public String getCorreo() {
        return correo;
    }
    /**
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return
     */
    public Mascota getMascota() {
        return mascota;
    }
    /**
     * @param mascota
     */
    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
}
