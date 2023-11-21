/**
 * Universidad del Valle de Guatemala
 * Programación orientada a objetos
 * @author Juan Ignacio Figueroa 23092
 * @author María Alejandra Martinez Vásquez - 231426
 * @author Marian Montejo- 23352
 * @author Sandra Pineda-231137
 * @fechaCreacion 05/10/23
 * @fechaMod 12/11/12
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Usuarios {
    private String usuario;
    private String contrasena;

    public Usuarios(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String obtenerUsuario() {
        return usuario;
    }

    public String obtenerContrasena() {
        return contrasena;
    }
}

class Autenticacion {
    private List<Usuarios> usuariosRegistrados;
    private String archivoUsuarios = "usuarios.csv"; 

    public Autenticacion() {
        this.usuariosRegistrados = cargarUsuariosDesdeCSV();
    }

    public void registrar(String nombreUsuario, String contrasena) {
        Usuarios nuevoUsuario = new Usuarios(nombreUsuario, contrasena);
        usuariosRegistrados.add(nuevoUsuario);
        guardarUsuariosEnCSV();
    }

    public boolean autenticar(String nombreUsuario, String contrasena) {
        for (Usuarios usuario : usuariosRegistrados) {
            if (usuario.obtenerUsuario().equals(nombreUsuario) && usuario.obtenerContrasena().equals(contrasena)) {
                return true; // Usuario autenticado
            }
        }
        return false;
    }

    private void guardarUsuariosEnCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivoUsuarios))) {
            for (Usuarios usuario : usuariosRegistrados) {
                writer.println(usuario.obtenerUsuario() + "," + usuario.obtenerContrasena());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Usuarios> cargarUsuariosDesdeCSV() {
        List<Usuarios> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoUsuarios))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] partes = line.split(",");
                if (partes.length == 2) {
                    usuarios.add(new Usuarios(partes[0], partes[1]));
                }
            }
        } catch (IOException e) {
           
        }
        return usuarios;
    }
}

