/**
 * Universidad del Valle de Guatemala
 * Programación orientada a objetos
 * @author Juan Ignacio Figueroa 23092
 * @author María Alejandra Martinez Vásquez - 231426
 * @author Marian Montejo- 23352
 * @author Sandra Pineda-231137
 * @fechaCreacion 04/11/23
 * @fechaMod 05/11/23
 */

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

    public Autenticacion() {
        this.usuariosRegistrados = new ArrayList<>();
    }

    // El método `registrar` en la clase `Autenticacion` se utiliza para registrar un nuevo usuario.
    // Toma dos parámetros: `nombreUsuario` (nombre de usuario) y `contrasena` (contraseña).
    public void registrar(String nombreUsuario, String contrasena) {
        Usuarios nuevoUsuario = new Usuarios(nombreUsuario, contrasena);
        usuariosRegistrados.add(nuevoUsuario);
    }

    // El método `autenticar` en la clase `Autenticacion` se utiliza para autenticar a un usuario. Toma
    // dos parámetros: `nombreUsuario` (nombre de usuario) y `contrasena` (contraseña).
    public boolean autenticar(String nombreUsuario, String contrasena) {
        for (Usuarios usuario : usuariosRegistrados) {
            if (usuario.obtenerUsuario().equals(nombreUsuario) && usuario.obtenerContrasena().equals(contrasena)) {
                return true; // Usuario autenticado
            }
        }
        return false; // Autenticación fallida
    }
}
