
package Clases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ventas {
   private String mesero; 
   private String detalleVenta;
   private double total;
   private String fechaHora;
   
   public Ventas(String mesero, String detalleVenta, double total){
       this.mesero = mesero;
       this.detalleVenta = detalleVenta;
       this.total = total;
       this.fechaHora = obtenerFechaHoraActual();
   }
   
   private String obtenerFechaHoraActual(){
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       return LocalDateTime.now().format(formatter);
   }
   
   public String getMesero(){
       return mesero;
   }
   
   public double getTotal(){
       return total;
   }
   
   public String getFechaHora(){
       return fechaHora;
   }
   
   @Override 
    public String toString(){
       return mesero + "," + detalleVenta + "," + total + "," + fechaHora;
   }
}
