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
public class Hospedaje extends Servicio {
    private String hospedaje;
    private double precioPorNoche;

    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion,
                     String hospedaje, double precioPorNoche) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }
    
    @Override
    public double calcularPrecioFinal(LocalDate dia){
        
        if (isEnPromocion() && (dia.getDayOfWeek().getValue() >= 1 && dia.getDayOfWeek().getValue() <= 5)){
            return precioPorNoche -(precioPorNoche * getPorcentajeDescuento()/100);
        }
        return precioPorNoche;
    }
    
    @Override 
    public String toString(){
        
        return "Hospedaje (" + "codServicio: " + getCodServicio() + 
               ", porcentajeDescuento: " + getPorcentajeDescuento() + 
               ", enPromocion: " + isEnPromocion() + 
               ", hospedaje: " + hospedaje + 
               ", precioPorNoche: " + precioPorNoche + ")";
    }
}
