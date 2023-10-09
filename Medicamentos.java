import java.util.Scanner;

public class Medicamentos {
    private String tipoAnimal;
    private double peso;

    public Medicamentos(String tipoAnimal, double peso) {
        this.tipoAnimal = tipoAnimal;
        this.peso = peso;
    }

    public void calcularDosis() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el medicamento:");
        System.out.println("1. Xilacina 2% (Perros)");
        System.out.println("2. Ketamina 10% (Perros)");
        System.out.println("3. Cerenia (Gatos)");
        System.out.println("4. Metoclop (Gatos)");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                calcularDosisXilacina();
                break;
            case 2:
                calcularDosisKetamina();
                break;
            case 3:
                calcularDosisCerenia();
                break;
            case 4:
                calcularDosisMetoclop();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public void calcularDosisXilacina() {
        if (tipoAnimal.equalsIgnoreCase("perro")) {
            double dosis = peso * 2 * 1; // Calcular la dosis en mg
            System.out.println("La dosis de Xilacina 2% para un perro de " + peso + " kg es de " + dosis + " mg.");
        } else {
            System.out.println("Xilacina 2% no se utiliza en gatos.");
        }
    }

    public void calcularDosisKetamina() {
        if (tipoAnimal.equalsIgnoreCase("perro")) {
            double dosis = peso * 10 * 1 / 100; // Calcular la dosis en ml
            System.out.println("La dosis de Ketamina 10% para un perro de " + peso + " kg es de " + dosis + " ml.");
        } else {
            System.out.println("Ketamina 10% no se utiliza en gatos.");
        }
    }

    public void calcularDosisCerenia() {
        if (tipoAnimal.equalsIgnoreCase("gato")) {
            double dosis = peso * 1 * 1 / 10; // Calcular la dosis en ml
            System.out.println("La dosis de Cerenia para un gato de " + peso + " kg es de " + dosis + " ml.");
        } else {
            System.out.println("Cerenia no se utiliza en perros.");
        }
    }

    public void calcularDosisMetoclop() {
        if (tipoAnimal.equalsIgnoreCase("gato")) {
            double dosis = peso * 10 * 1 / 5; // Calcular la dosis en ml
            System.out.println("La dosis de Metoclop para un gato de " + peso + " kg es de " + dosis + " ml.");
        } else {
            System.out.println("Metoclop no se utiliza en perros.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el tipo de animal (perro o gato):");
        String tipoAnimal = scanner.nextLine();

        System.out.println("Ingrese el peso del animal en kg:");
        double peso = scanner.nextDouble();

        Medicamentos medicamento = new Medicamentos(tipoAnimal, peso);
        medicamento.calcularDosis();
    }
}

