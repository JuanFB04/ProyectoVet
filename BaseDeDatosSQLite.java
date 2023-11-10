/**
 * Universidad del Valle de Guatemala
 * Programación orientada a objetos
 * @author Juan Ignacio Figueroa 23092
 * @author María Alejandra Martinez Vásquez - 231426
 * @author Marian Montejo- 23352
 * @author Sandra Pineda-231137
 * @fechaCreacion 02/11/23
 * @fechaMod 05/11/23
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDeDatosSQLite {
    private Connection connection = null;

    public void conexion() {
        // Constructor: Establecer la conexión a la base de datos en este punto
        String url = "jdbc:sqlite:./bases/veterinario.db";
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public void crearTablas() {
        crearTablaClientes();
        crearTablaMascotas();
    }

    public void crearTablaClientes() {
        try {
            Statement statement = connection.createStatement();
            String createClientesTableSQL = "CREATE TABLE IF NOT EXISTS clientes (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, telefono TEXT, correo TEXT);";
            statement.execute(createClientesTableSQL);
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla de clientes: " + e.getMessage());
        }
    }

    public void crearTablaMascotas() {
        try {
            Statement statement = connection.createStatement();
            String createMascotasTableSQL = "CREATE TABLE IF NOT EXISTS mascotas (user TEXT PRIMARY KEY NOT NULL, nombre TEXT, tipoAnimal TEXT, raza TEXT NOT NULL, edad TEXT NOT NULL, peso REAL NOT NULL, FOREIGN KEY (user) REFERENCES clientes(correo) );";
            statement.execute(createMascotasTableSQL);
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla de mascotas: " + e.getMessage());
        }
    }


    public void insertarCliente(String nombre, String telefono, String correo) {
        try {
            Statement statement = connection.createStatement();
            String insertClienteSQL = "INSERT INTO clientes (nombre, telefono, correo) VALUES ('" + nombre + "', '" + telefono + "', '" + correo + "');";
            statement.execute(insertClienteSQL);
        } catch (SQLException e) {
            System.out.println("Error al insertar una mascota: " + e.getMessage());
        }
    }

    public void insertarMascota(String user, String nombre, String tipoAnimal, String raza, int edad, double peso) {
        try {
            Statement statement = connection.createStatement();
            String insertMascotaSQL = "INSERT INTO mascotas (user, nombre, tipoAnimal, raza, edad, peso) VALUES ('"+user+"','"+nombre + "', '" + tipoAnimal + "', '"+raza+"', '"+edad+"', '"+ peso + "');";
            statement.execute(insertMascotaSQL);
        } catch (SQLException e) {
            System.out.println("Error al insertar una mascota: " + e.getMessage());
        }
    }


    /**
     * @return
     */
    public ResultSet obtenerTodasLasMascotas() {
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            String selectMascotasSQL = "SELECT * FROM mascotas;";
            resultSet = statement.executeQuery(selectMascotasSQL);
        } catch (SQLException e) {
            System.out.println("Error al obtener las mascotas: " + e.getMessage());
        }
        return resultSet;
    }

    /**
     * @return
     */
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Mascota> mascotas = new ArrayList<>();
    public void cargarClientes() {
        try {
            Statement statement = connection.createStatement();
            String selectClientesSQL = "SELECT * FROM clientes;";
            ResultSet resultSet = statement.executeQuery(selectClientesSQL);

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String telefono = resultSet.getString("telefono");
                String correo = resultSet.getString("correo");
                Cliente cliente = new Cliente(nombre, telefono, correo, null);
                clientes.add(cliente);
            }
            for (Cliente cliente  : clientes) {
                String selectMascotas = "select * from mascotas where user = ?";
                PreparedStatement stmt = connection.prepareStatement(selectMascotas);
                stmt.setString(1,cliente.getCorreo());
                ResultSet rest  = stmt.executeQuery();
                while (rest.next()) {
                    String nombre = rest.getString(2);
                    String tipoA = rest.getString(3);
                    String raza = rest.getString(4);
                    int edad = rest.getInt(5);
                    double peso = rest.getDouble(6);
                    Mascota mascota = new Mascota(nombre, tipoA, raza, edad, peso);
                    cliente.setMascota(mascota);
                    mascotas.add(mascota);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los clientes: " + e.getMessage());
        }
    }

    public void cerrarConexion() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión a la base de datos: " + e.getMessage());
        }
    }

    public ResultSet obtenerTodosLosClientes() {
        return null;
    }

    public ArrayList<Cliente> getClientes(){
        return clientes;
    }
    public ArrayList<Mascota> getMascotas(){
        return mascotas;
    }
}

