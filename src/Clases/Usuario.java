
package Clases;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author Leo
 */

public class Usuario {
    private String nombre;
    private String contrasena;
    private String rol;

    public Usuario(String nombre, String contrasena, String rol) {
        if (nombre == null || nombre.isEmpty()) throw new IllegalArgumentException("El nombre no puede estar vacio");
        if (contrasena == null || contrasena.isEmpty()) throw new IllegalArgumentException("La contraseña no puede estar vacio");
        if (rol == null || rol.isEmpty()) throw new IllegalArgumentException("El rol no puede estar vacio");
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        if (nombre == null || nombre.isEmpty()) throw new IllegalArgumentException("El nombre no puede estar vacio");
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        if (contrasena == null || contrasena.isEmpty()) throw new IllegalArgumentException("La contraseña no puede estar vacio");
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        if (rol == null || rol.isEmpty()) throw new IllegalArgumentException("El rol no puede estar vacio");
        this.rol = rol;
    }
    
    private String encriptarContrasena(String contrasena){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(contrasena.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash){
                hexString.append(String.format("%02x",b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e){
            throw new RuntimeException("Error al encriptar la contraseña");
        }
    }
    
    public boolean verificarContraseña(String contrasenaIngresada){
        return encriptarContrasena(contrasenaIngresada).equals(this.contrasena);
    }
    
    @Override
    public String toString(){
        return nombre + "," + contrasena + "," + rol;
    }
}
