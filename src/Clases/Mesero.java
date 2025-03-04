package Clases;
import java.util.HashSet;

public class Mesero extends Persona {
    private int numMesa;
    private int numVentas;
    private HashSet<Integer> mesasAtendidas;

    public Mesero(String nombre, String contrasena, int numMesa) {
        super(nombre, contrasena);
        this.numMesa = numMesa;
        this.numVentas = 0;
        this.mesasAtendidas = new HashSet<>();
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

