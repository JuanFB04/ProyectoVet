public class Cliente {
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
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
}
