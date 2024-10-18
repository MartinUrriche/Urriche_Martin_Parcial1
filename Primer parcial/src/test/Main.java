/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;
import java.time.LocalDate;
import java.util.List;
import model.Sistema;
import model.Servicio;
/**
 *
 * @author Martin
 */
public class Main {
    
    public static void main(String[] args) {
        
        try {
            Sistema sistema = new Sistema();
            
            System.out.println("1-1: Intentar crear objeto Gastronomia");
            try{
                sistema.agregarGastronomia("4892", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            } 
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            
            System.out.println("1-2: Crear objeto Gastronomia");
            sistema.agregarGastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            
            System.out.println("1-3: Intentar crear Hospedaje");
            try {
                sistema.agregarHospedaje("2872", 10.0, true, "Cabaña 3 personas", 1500.0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            System.out.println("1-4: Crear Hospedaje");
            sistema.agregarHospedaje("287282", 10.0, true, "Cabaña 3 personas", 1500.0);
            
            System.out.println(" ");
            
            System.out.println("2-1: Precio final de Gastronomia para el día 2020-10-28:");
            Servicio gastronomia = sistema.traerServicio("489235");
            System.out.println(gastronomia.calcularPrecioFinal(LocalDate.of(2020,10,28)));
            
            System.out.println("2-2: Precio final de Hospedaje para el día 2020-10-27:");
            Servicio hospedaje = sistema.traerServicio("287282");
            System.out.println(hospedaje.calcularPrecioFinal(LocalDate.of(2020,10,27)));
            
            System.out.println(" ");
            
            System.out.println("3) Agregar servicios y imprimir en la lista:");
            sistema.agregarGastronomia("858927", 15.0, true, "Milanesa con puré", 350.0, 3);
            sistema.agregarHospedaje("489259", 10.0, true, "Habitación triple", 2200.0);
            sistema.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);
            sistema.agregarHospedaje("758972", 15.0, false, "Habitación simple", 1000.0);
            
            List<Servicio> listaServicios = sistema.getLstServicio();
            
            for (Servicio servicio : listaServicios) {
                System.out.println(servicio);
            }
            System.out.println(" ");
            System.out.println("4-1: Traer los servicios en promoción:");
            List<Servicio> serviciosEnPromocion = sistema.traerServicio(true);
            
            for (Servicio servicio : serviciosEnPromocion) {
                System.out.println(servicio);
            }
            System.out.println(" ");
            System.out.println("4-2: Traer los servicios en promoción para el día 2020-10-28:");
            List<Servicio> serviciosEnFecha = sistema.traerServicio(true, LocalDate.of(2020, 10, 28));
            for ( Servicio servicio:serviciosEnFecha){
                System.out.println(servicio);
            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
