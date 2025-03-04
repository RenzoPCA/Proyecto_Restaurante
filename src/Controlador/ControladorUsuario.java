/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Persona;
import Clases.Administrador;
import Clases.Cocinero;
import Clases.Mesero;
import java.util.HashMap;
import Ingredientes.*;
import Frames.*;


public class ControladorUsuario {
    private HashMap<String, String> personas;
    private VistaLogin vistaLogin;

    public ControladorUsuario(VistaLogin vistaLogin) {
        personas = new HashMap<>();
        this.vistaLogin = vistaLogin;
        // Agregar usuarios de ejemplo
        personas.put("admin", "admin123");
        personas.put("cocinero", "cocinero123");
        personas.put("mesero", "mesero123");
    }

    public void handleLogin(String nombre, String contrasena) {
        if (personas.containsKey(nombre) && personas.get(nombre).equals(contrasena)) {
            Persona persona = obtenerPersona(nombre, contrasena);
            abrirVistaSegunTipo(persona);
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos");
        }
    }

    private Persona obtenerPersona(String nombre, String contrasena) {
        switch (nombre) {
            case "admin":
                return new Administrador(nombre, contrasena);
            case "cocinero":
                return new Cocinero(nombre, contrasena);
            case "mesero":
                return new Mesero(nombre, contrasena, 1); // Asignar un valor para numMesa
            default:
                throw new IllegalArgumentException("Tipo de persona desconocido");
        }
    }

    private void abrirVistaSegunTipo(Persona persona) {
        if (persona instanceof Administrador) {
            abrirVistaAdmin((Administrador) persona);
        } else if (persona instanceof Cocinero) {
            abrirVistaCocinero((Cocinero) persona);
        } else if (persona instanceof Mesero) {
            abrirVistaMesero((Mesero) persona);
        } else {
            throw new IllegalArgumentException("Tipo de persona desconocido");
        }
    }

    private void abrirVistaAdmin(Administrador administrador) {
        System.out.println("Abriendo vista de Admin");
        // Código para abrir la vista de Admin
    }

    private void abrirVistaCocinero(Cocinero cocinero) {
        System.out.println("Abriendo vista de Cocinero");
        new GestorIngredientesUI(); // Abrir la vista de GestorIngredientesUI
        vistaLogin.dispose();
    }

    private void abrirVistaMesero(Mesero mesero) {
        System.out.println("Abriendo vista de Mesero");
        new MenuFrame().setVisible(true); // Abrir la vista de MenuFrame
        vistaLogin.dispose(); // Cerrar la vista de VistaLogin
    }

}
