/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Usuario;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */

public class ControladorUsuario {
    private HashMap<String, Usuario> usuarios;

    public ControladorUsuario() {
        usuarios = new HashMap<>();
        inicializarUsuarios();
    }

    private void inicializarUsuarios() {
        usuarios.put("admin", new Usuario("admin", "admin123", "Administrador"));
        usuarios.put("mesero", new Usuario("mesero", "mesero123", "Mesero"));
        usuarios.put("cocinero", new Usuario("cocinero", "cocinero123", "Cocinero"));
    }

    public boolean validarUsuario(String nombre, String contrasena) {
        Usuario usuario = usuarios.get(nombre);
        return usuario != null && usuario.getContrasena().equals(contrasena);
    }

    public String obtenerRolUsuario(String nombre) {
        Usuario usuario = usuarios.get(nombre);
        return usuario != null ? usuario.getRol() : null;
    }
    
    public void agregarUsuario(String nombre, String contrasena, String rol) {
        if (!usuarios.containsKey(nombre)) {
            usuarios.put(nombre, new Usuario(nombre, contrasena, rol));
        } else {
            System.out.println("El usuario ya existe.");
        }
    }

    public Usuario obtenerUsuario(String nombre) {
        return usuarios.get(nombre);
    }

    public void eliminarUsuario(String nombre) {
        usuarios.remove(nombre);
    }

}
