public class Mascota {
    private String nombre;
    private double peso;
    private String raza;
    private String tipoAnimal;

    public Mascota(String nombre, double peso, String raza, String tipoAnimal) {
        this.nombre = nombre;
        this.peso = peso;
        this.raza = raza;
        this.tipoAnimal = tipoAnimal;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }
}


