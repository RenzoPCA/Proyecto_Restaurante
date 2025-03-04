/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author Usuario
 */
public class Persona {
    private String nombre;
    private String contrasena;

    public Persona(String nombre, String contrasena) {
        if (nombre == null || nombre.isEmpty()) throw new IllegalArgumentException("El nombre no puede estar vacio");
        if (contrasena == null || contrasena.isEmpty()) throw new IllegalArgumentException("La contraseña no puede estar vacio");
        this.nombre = nombre;
        this.contrasena = encriptarContrasena(contrasena);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) throw new IllegalArgumentException("El nombre no puede estar vacio");
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        if (contrasena == null || contrasena.isEmpty()) throw new IllegalArgumentException("La contraseña no puede estar vacio");
        this.contrasena = encriptarContrasena(contrasena);
    }

    private String encriptarContrasena(String contrasena) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(contrasena.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al encriptar la contraseña");
        }
    }

    public boolean verificarContrasena(String contrasenaIngresada) {
        return encriptarContrasena(contrasenaIngresada).equals(this.contrasena);
    }

    @Override
    public String toString() {
        return nombre + "," + contrasena;
    }
}
