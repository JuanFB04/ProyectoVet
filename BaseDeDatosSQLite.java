import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDeDatosSQLite {
    private Connection connection;

    public BaseDeDatosSQLite() {
        // Constructor: Establecer la conexión a la base de datos en este punto
        String url = "jdbc:sqlite:mi_basededatos.db";
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public void crearTablas() {
        crearTablaClientes();
        crearTablaMascotas();
        crearTablaMedicamentos();
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
            String createMascotasTableSQL = "CREATE TABLE IF NOT EXISTS mascotas (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, tipoAnimal TEXT, peso REAL);";
            statement.execute(createMascotasTableSQL);
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla de mascotas: " + e.getMessage());
        }
    }

    public void crearTablaMedicamentos() {
        try {
            Statement statement = connection.createStatement();
            String createMedicamentosTableSQL = "CREATE TABLE IF NOT EXISTS medicamentos (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT);";
            statement.execute(createMedicamentosTableSQL);
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla de medicamentos: " + e.getMessage());
        }
    }

    public void insertarMascota(String nombre, String tipoAnimal, double peso) {
        try {
            Statement statement = connection.createStatement();
            String insertMascotaSQL = "INSERT INTO mascotas (nombre, tipoAnimal, peso) VALUES ('" + nombre + "', '" + tipoAnimal + "', " + peso + ");";
            statement.execute(insertMascotaSQL);
        } catch (SQLException e) {
            System.out.println("Error al insertar una mascota: " + e.getMessage());
        }
    }

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

    public ArrayList<Cliente> getListClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String selectClientesSQL = "SELECT * FROM clientes;";
            ResultSet resultSet = statement.executeQuery(selectClientesSQL);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String telefono = resultSet.getString("telefono");
                String correo = resultSet.getString("correo");
                Cliente cliente = new Cliente(nombre, telefono, correo, null);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los clientes: " + e.getMessage());
        }
        return clientes;
    }

    public void cerrarConexion() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión a la base de datos: " + e.getMessage());
        }
    }

    public void insertarCliente(String nombre, String telefono, String correo) {
    }

    public ResultSet obtenerTodosLosClientes() {
        return null;
    }
}

