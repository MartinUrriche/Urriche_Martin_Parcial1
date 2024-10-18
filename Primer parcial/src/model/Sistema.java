/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Martin
 */
public class Sistema {
    private List<Servicio> lstServicio;
    
    public Sistema(){
        this.lstServicio = new ArrayList<>();
    }
    
    public Servicio traerServicio(String codServicio){
        
        for(Servicio servicio : lstServicio){
            
            if (servicio.getCodServicio().equals(codServicio)){
                
                return servicio;
            }     
        }
        return null;
    }
    
    
    public List<Servicio> traerServicio(boolean enPromocion){
        List<Servicio> serviciosEnPromocion = new ArrayList<>();
        
        for(Servicio servicio: lstServicio){
            
            if (servicio.isEnPromocion() == enPromocion){
                
                serviciosEnPromocion.add(servicio);
            }
        }
        return serviciosEnPromocion;
    }
    
    public List<Servicio> traerServicio (boolean enPromocion, LocalDate dia){
        List<Servicio> serviciosEnEstaFecha = new ArrayList<>();
        
        for(Servicio servicio: lstServicio){
            
            if(servicio.isEnPromocion() == enPromocion && servicio.calcularPrecioFinal(dia) != 0){
                
                serviciosEnEstaFecha.add(servicio);
            }
        }
        return serviciosEnEstaFecha;
    }
    
    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion,
                                      String gastronomia, double precio, int diaSemDesc) throws Exception {
        
        if (traerServicio(codServicio) != null){
            throw new Exception("El servicio ya existe.");
        }
        
        lstServicio.add(new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc));
        return true;
    }
    
    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion,
                                    String hospedaje,double precioPorNoche)throws Exception{
        
        if(traerServicio(codServicio) != null){
            throw new Exception("El servicio ya existe.");
        }
        
        lstServicio.add(new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche));
        return true;
    }
    
    public List<Servicio> getLstServicio() {
        return lstServicio;
    }
}
