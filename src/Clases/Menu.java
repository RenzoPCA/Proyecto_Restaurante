
package Clases;

public class Menu {
    private int idPlato;
    private String nombreplato;
    private int cantplato;
    private double precio;

    public Menu(int idPlato, String nombreplato, int cantplato, double precio) {
        this.idPlato = idPlato;
        this.nombreplato = nombreplato;
        this.cantplato = cantplato;
        this.precio = precio;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombreplato() {
        return nombreplato;
    }

    public void setNombreplato(String nombreplato) {
        this.nombreplato = nombreplato;
    }

    public int getCantplato() {
        return cantplato;
    }

    public void setCantplato(int cantplato) {
        this.cantplato = cantplato;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "\n |Plato: " + nombreplato + "| Cantidad: " + cantplato + "| Precio:" + precio + '\n';
    }
    
    
}
