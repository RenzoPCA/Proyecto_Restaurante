/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Usuario
 */
public class UsuariosPrueba {
    private ControladorUsuario controladorUsuario;

    public UsuariosPrueba() {
        controladorUsuario = new ControladorUsuario();
        inicializarUsuarios();
    }

    private void inicializarUsuarios() {
        controladorUsuario.agregarUsuario("admin", "admin123", "Administrador");
        controladorUsuario.agregarUsuario("mesero", "mesero123", "Mesero");
        controladorUsuario.agregarUsuario("cocinero", "cocinero123", "Cocinero");
    }

    public ControladorUsuario getGestorUsuarios() {
        return controladorUsuario;
    }
}
