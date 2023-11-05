/**
 * Universidad del Valle de Guatemala
 * Programación orientada a objetos
 * @author Juan Ignacio Figueroa 23092
 * @author María Alejandra Martinez Vásquez - 231426
 * @author Marian Montejo- 23352
 * @author Sandra Pineda-231137
 * @fechaCreacion 09/10/23
 * @fechaMod 09/10/12
 */
public class Medicamentos {

    public void calcularDosisXilacina(Mascota mascota, Panel_Control panel) {
        if (mascota.getTipoAnimal().equalsIgnoreCase("perro")) {
            double dosis = mascota.getPeso() * 2; // Calcular la dosis en mg
            panel.mensaje("La dosis de Xilacina 2% para un perro de " + mascota.getPeso() + " kg es de " + dosis + " mg.");
        } else {
            panel.mensaje("Xilacina 2% es únicamente para perros.");
        }
    }

    public void calcularDosisKetamina(Mascota mascota, Panel_Control panel) {
        if (mascota.getTipoAnimal().equalsIgnoreCase("perro")) {
            double dosis = (mascota.getPeso())/10; // Calcular la dosis en ml
            panel.mensaje("La dosis de Ketamina 10% para un perro de " + mascota.getPeso() + " kg es de " + dosis + " ml.");
        } else {
            panel.mensaje("Ketamina 10% es únicamente para perros.");
        }
    }

    public void calcularDosisCerenia(Mascota mascota, Panel_Control panel) {
        if (mascota.getTipoAnimal().equalsIgnoreCase("gato")) {
            double dosis = (mascota.getPeso())/ 10; // Calcular la dosis en ml
            panel.mensaje("La dosis de Cerenia para un gato de " + mascota.getPeso() + " kg es de " + dosis + " ml.");
        } else {
            panel.mensaje("Cerenia es únicamente para gatos.");
        }
    }

    public void calcularDosisMetoclop(Mascota mascota, Panel_Control panel) {
        if (mascota.getTipoAnimal().equalsIgnoreCase("gato")) {
            double dosis = mascota.getPeso() * 2; // Calcular la dosis en ml
            panel.mensaje("La dosis de Metoclop para un gato de " + mascota.getPeso() + " kg es de " + dosis + " ml.");
        } else {
            panel.mensaje("Metoclop es únicamente para gatos.");
        }
    }

    public void calcularDosisAgromicin(Mascota mascota, Panel_Control panel){
        if (mascota.getTipoAnimal().equalsIgnoreCase("cerdo")){
            double dosis = mascota.getPeso() / 10;
            panel.mensaje("La dosis de Agromicin® 20 L.A. para un cerdo de " + mascota.getPeso() + " kg es de " + dosis + " ml.");
        }  else {
            panel.mensaje("Agromicin® 20 L.A. es únicamente para cerdos.");

        }  
    }
    public void calcularDosisAmoxigentin(Mascota mascota, Panel_Control panel){
        if (mascota.getTipoAnimal().equalsIgnoreCase("cerdo")){
            double dosis = mascota.getPeso() / 10;
            panel.mensaje("La dosis de Amoxigentin® para un cerdo de " + mascota.getPeso() + " kg es de " + dosis + " ml.");
        }  else {
            panel.mensaje("Amoxigentin® es únicamente para cerdos.");

        }  
    }

    /**
     * @param mascota
     * @param panel
     */
    public void calcularDosisPenDexa(Mascota mascota, Panel_Control panel){
        if (mascota.getTipoAnimal().equalsIgnoreCase("caballo")){
            double dosis = mascota.getPeso() / 25;
            panel.mensaje("La dosis de Pen Dexa Strep® para un caballo de " + mascota.getPeso() + " kg es de " + dosis + " ml.");
        }  else {
            panel.mensaje("Pen Dexa Strep® es únicamente para caballos.");

        }  
    }

    public void calcularDosisEnroflox(Mascota mascota, Panel_Control panel){
        if (mascota.getTipoAnimal().equalsIgnoreCase("caballo")){
            double dosis = mascota.getPeso() / 40;
            panel.mensaje("La dosis de Enroflox® 10 para un caballo de " + mascota.getPeso() + " kg es de " + dosis + " ml.");
        }  else {
            panel.mensaje("Enroflox® 10 es únicamente para caballos.");

        }  
    }

    public void calcularDosisModivitasan(Mascota mascota, Panel_Control panel){
        if (mascota.getTipoAnimal().equalsIgnoreCase("cuyo")){
            double dosis = mascota.getPeso() * (0.05 / 2);
            panel.mensaje("La dosis de Modivitasan® para un cuyo de " + mascota.getPeso() + " kg es de " + dosis + " ml.");
        }  else {
            panel.mensaje("Modivitasan® es únicamente para cuyos.");

        }  
    }

    public void calcularDosisVitamino(Mascota mascota, Panel_Control panel){
        if (mascota.getTipoAnimal().equalsIgnoreCase("cuyo")){
            double dosis = mascota.getPeso() * (1 / mascota.getPeso());
            panel.mensaje("La dosis de Vitamino® B para un cuyo de " + mascota.getPeso() + " kg es de " + dosis + " ml.");
        }  else {
            panel.mensaje("Vitamino® B es únicamente para cuyos.");

        }  
    }

    public void calcularDosisAgrosona(Mascota mascota, Panel_Control panel){
        if (mascota.getTipoAnimal().equalsIgnoreCase("cabra")){
            double dosis = mascota.getPeso() /10;
            panel.mensaje("La dosis de Agrosona® para una cabra de " + mascota.getPeso() + " kg es de " + dosis + " ml.");
        }  else {
            panel.mensaje("Agrosona® es únicamente para cabras.");

        }  
    }

    public void calcularDosisAgrogenta(Mascota mascota, Panel_Control panel){
        if (mascota.getTipoAnimal().equalsIgnoreCase("cabra")){
            double dosis = mascota.getPeso() /27.5;
            panel.mensaje("La dosis de Agrogenta® para una cabra de " + mascota.getPeso() + " kg es de " + dosis + " ml.");
        }  else {
            panel.mensaje("Agrogenta® es únicamente para cabras.");

        }  
    }
}
