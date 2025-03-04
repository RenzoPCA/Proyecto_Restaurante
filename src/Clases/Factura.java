package Clases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Factura {
    private String numeroFactura;
    private String mesero;
    private String detalleVenta;
    private double total;
    private String fechaHora;
    
    public Factura(String mesero, String detalleVenta, double total){
        this.numeroFactura = generarNumeroFactura();
        this.mesero = mesero;
        this.detalleVenta = detalleVenta;
        this.total = total;
        this.fechaHora = obtenerFechaHoraActual();
    }
    
    private String generarNumeroFactura(){
        return "FACTURA - " + UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }
    
    private String obtenerFechaHoraActual(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-DD HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
    
    private String getNumeroFactura(){
        return numeroFactura;
    }
    
    public String getMesero(){
        return mesero;
    }
    
    public String getDetalleVenta(){
        return detalleVenta;
    }
    
    public double getTotal(){
        return total;
    }
    
    public String getFechaHora(){
        return fechaHora;
    }
    
    @Override
    public String toString(){
        return numeroFactura + "," + mesero + "," + detalleVenta + "," + total + "," + fechaHora;
    }
}
