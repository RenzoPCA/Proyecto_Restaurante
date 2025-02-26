package Clases;
import java.util.HashSet;

public class Mesero {
    private String nombre;
    private int numMesa;
    private int numVentas;
    
    private HashSet<Integer> mesasAtendidas;

    public Mesero(String nombre, int numMesa) {
        this.nombre = nombre;
        this.numMesa = numMesa;
        this.numVentas = 0;
        this.mesasAtendidas = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public int getNumVentas() {
        return numVentas;
    }

    public void incrementarVentas() {
        this.numVentas++;
    }

    public void agregarMesa(int mesa) {
        mesasAtendidas.add(mesa);
    }

    public HashSet<Integer> getMesasAtendidas() {
        return mesasAtendidas;
    }
}

