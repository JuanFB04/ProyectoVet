/**
 * Universidad del Valle de Guatemala
 * Programación orientada a objetos
 * @author Juan Ignacio Figueroa 23092
 * @author María Alejandra Martinez Vásquez - 231426
 * @author Marian Montejo- 23352
 * @author Sandra Pineda-231137
 * @fechaCreacion 05/10/23
 * @fechaMod 12/11/23
 */
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Funciones {

    static class Cita implements Comparable<Cita> {
        private Date fecha;
        private String nombreMascota;

        public Cita(Date fecha, String nombreMascota) {
            this.fecha = fecha;
            this.nombreMascota = nombreMascota;
        }

        public Date getFecha() {
            return fecha;
        }

        public String getNombreMascota() {
            return nombreMascota;
        }

        @Override
        public int compareTo(Cita otraCita) {
            return this.fecha.compareTo(otraCita.getFecha());
        }

        @Override
        public String toString() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            return dateFormat.format(fecha) + "," + nombreMascota;
        }
    }

    static class Agenda {
        private List<Cita> citas;

        public Agenda() {
            this.citas = new ArrayList<>();
        }

        public List<Cita> getCitas() {
            return citas;
        }

        public void agendarCita(Date fecha, String nombreMascota) {
            Cita nuevaCita = new Cita(fecha, nombreMascota);
            citas.add(nuevaCita);
            Collections.sort(citas);
        }

        public void mostrarCitas() {
            for (Cita cita : citas) {
                System.out.println("Fecha: " + cita.getFecha() + ", Mascota: " + cita.getNombreMascota());
            }
        }

        public void guardarCitasEnArchivo(String filePath) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (Cita cita : citas) {
                    writer.write(cita.toString());
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void cargarCitasDesdeArchivo(String filePath) {
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("El archivo no existe. Creando uno nuevo.");
                return;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                        Date fecha = dateFormat.parse(parts[0]);
                        String nombreMascota = parts[1];
                        agendarCita(fecha, nombreMascota);
                    }
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
    }
    public static void agendarCita(Scanner scanner) {
            try (Scanner agendas = new Scanner(System.in)) {
                Agenda agenda = new Agenda();
   
             
                agenda.cargarCitasDesdeArchivo("citas.csv");
   
                
                while (true) {
                    System.out.println("¿Qué desea hacer?");
                    System.out.println("1. Agregar una cita");
                    System.out.println("2. Eliminar una cita");
                    System.out.println("3. Mostrar citas");
                    System.out.println("4. Salir");
   
                    int opcion = agendas.nextInt();
                    agendas.nextLine(); 
   
                    switch (opcion) {
                        case 1:
                            while (true) {
                                System.out.println("Ingrese la fecha de la cita (dd-MM-yyyy HH:mm):");
                                String fechaStr = agendas.nextLine();
   
                                System.out.println("Ingrese el nombre de la mascota:");
                                String nombreMascota = agendas.nextLine();
   
                                try {
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                                    Date fecha = dateFormat.parse(fechaStr);
   
                                    agenda.agendarCita(fecha, nombreMascota);
   
                                    System.out.println("Cita agendada con éxito.");
                                } catch (ParseException e) {
                                    System.out.println("Error al procesar la fecha. Por favor, ingrese el formato correcto.");
                                }
   
                                System.out.println("¿Desea agendar otra cita? (si/no):");
                                String respuesta = agendas.nextLine().toLowerCase();
                                if (!respuesta.equals("si")) {
                                    break;
                                }
                            }
   
                       
                            System.out.println("Citas agendadas:");
                            agenda.mostrarCitas();
   
                            agenda.guardarCitasEnArchivo("citas.csv");
                            break;
   
                        case 2:
                            System.out.println("Ingrese la fecha de la cita a eliminar (dd-MM-yyyy HH:mm):");
                            String fechaEliminarStr = agendas.nextLine();
   
                            try {
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                                Date fechaEliminar = dateFormat.parse(fechaEliminarStr);
   
                                agenda.getCitas().removeIf(cita -> cita.getFecha().equals(fechaEliminar));
   
                                System.out.println("Cita eliminada con éxito.");
                            } catch (ParseException e) {
                                System.out.println("Error. Por favor, ingrese el formato correcto.");
                            }
                            break;
   
                        case 3:
                            System.out.println("Citas agendadas:");
                            agenda.mostrarCitas();
                            break;
   
                        case 4:
                            agenda.guardarCitasEnArchivo("citas.csv");
                            System.out.println("Saliendo del programa.");
                            System.exit(0);
                            break;
   
                        default:
                            System.out.println("Opción no válida. Por favor, seleccione una de las opciones del 1 a la 4.");
                    }
                }
            }
        }

public static void calcularDosis(Scanner scanner, ArrayList<Cliente> listclientes) {
    Panel_Control panel = new Panel_Control();
    Medicamentos med = new Medicamentos();
   
    Mascota mascota = panel.pedirMascota(scanner, listclientes);
    int medicamento = panel.pedirMedicamento(scanner);
    
    switch (medicamento) {
        case 1:
            med.calcularDosisXilacina(mascota, panel);
            break;
        case 2:
            med.calcularDosisKetamina(mascota, panel);
            break;
        case 3:
            med.calcularDosisCerenia(mascota, panel);
            break;
        case 4:
            med.calcularDosisMetoclop(mascota, panel);
            break;
        case 5: 
            med.calcularDosisAgromicin(mascota,panel);
            break;
        case 6: 
            med.calcularDosisAmoxigentin(mascota,panel);
            break;
        case 7: 
            med.calcularDosisPenDexa(mascota,panel);
            break;
        case 8: 
            med.calcularDosisEnroflox(mascota,panel);
            break;
        case 9: 
            med.calcularDosisModivitasan(mascota,panel);
            break;
        case 10: 
            med.calcularDosisVitamino(mascota,panel);
            break;
        case 11: 
            med.calcularDosisAgrosona(mascota,panel);
            break;
        case 12: 
            med.calcularDosisAgrogenta(mascota,panel);
            break;
        default:
            panel.mensaje("Opción no válida.");
            break;
    }
}
}

