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

    
}

