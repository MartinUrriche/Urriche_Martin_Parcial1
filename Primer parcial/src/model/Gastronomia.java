/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.time.LocalDate;

/**
 *
 * @author Martin
 */
public class Gastronomia extends Servicio {
    private String gastronomia;
    private double precio;
    private int diaSemDesc;

    public Gastronomia( String codServicio, double porcentajeDescuento, boolean enPromocion,
                        String gastronomia, double precio, int diaSemDesc) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    }
    
    @Override
    public double calcularPrecioFinal(LocalDate dia){
        
        if (isEnPromocion() && dia.getDayOfWeek().getValue() == diaSemDesc){
            return precio - (precio * getPorcentajeDescuento()/100);
        }
        return precio;
    }
    
    @Override
    public String toString(){
        
        return "Gastronomia (" + "codServicio: " + getCodServicio() + 
               ", porcentajeDescuento: " + getPorcentajeDescuento() + 
               ", enPromocion: " + isEnPromocion() + 
               ", gastronomia: " + gastronomia + 
               ", precio: " + precio + 
               ", diaSemDesc: " + diaSemDesc + ")";
    }
    
}
