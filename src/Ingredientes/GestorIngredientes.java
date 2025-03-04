/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ingredientes;

/**
 *
 * @author USER
 */
import java.io.*;
import java.util.*;

class GestorIngredientes {
    private ArrayList<Ingrediente> ingredientes = new ArrayList<>();

    public void agregarIngrediente(String nombre, int cantidad) {
        for (Ingrediente ing : ingredientes) {
            if (ing.nombre.equalsIgnoreCase(nombre)) {
                ing.cantidad += cantidad;
                return;
            }
        }
        ingredientes.add(new Ingrediente(nombre, cantidad));
    }

    public void eliminarIngrediente(String nombre, int cantidad) {
        ingredientes.removeIf(ing -> ing.nombre.equalsIgnoreCase(nombre) && (ing.cantidad -= cantidad) <= 0);
    }
    
    public void eliminarTodosLosIngredientes() {
        ingredientes.clear(); // Suponiendo que `ingredientes` es la lista que almacena los ingredientes
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void exportarLista(File archivo) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            for (Ingrediente ing : ingredientes) {
                writer.println(ing.nombre + " - " + ing.cantidad);
            }
        }
    }

    public void importarLista(File archivo) throws IOException {
        ingredientes.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] partes = line.split(" - ");
                if (partes.length == 2) {
                    try {
                        int cantidad = Integer.parseInt(partes[1].trim());
                        agregarIngrediente(partes[0].trim(), cantidad);
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        }
    }
}