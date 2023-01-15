package modelo;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaInventarioModelo.java
 *    Licencia: GNU-GPL 
 *    @version  1.1
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import vista.*;
import controlador.*;
import supermercado.*;

public class VentanaInventarioModelo {
    
    Supermercado supermercado = new Supermercado();
    java.util.List<ProductoInventario> misProductos = supermercado.getMisProductos();
    
    /**
     * Constructor de la clase VenatanaInventarioModelo
     */
    public VentanaInventarioModelo(){
    }

    
    //              GETTERS CON INDICE              //
    public int getId(int indice){
        return misProductos.get(indice).getId();
    }
    
    public String getNombre(int indice){
        return misProductos.get(indice).getNombre();
    }
    
    public int getCantidad(int indice){
        return misProductos.get(indice).getCantidad();
    }
    
    public String getMedida(int indice){
        return misProductos.get(indice).getMedida();
    }
    
    public int getPrecioDeCompra(int indice){
        return misProductos.get(indice).getPrecioDeCompra();
    }
    
    public int getPrecioDeVenta(int indice){
        return misProductos.get(indice).getPrecioDeVenta();
    }
    
    public double getGanancia(int indice){
        return misProductos.get(indice).getPorcentajeGanancia();
    }
    
    
    //              FUNCIONES               //
    public void modificarPrecioDeVenta(int idProducto, double porcentajeDeGanancia){
        for(ProductoInventario productoActual: misProductos){
            if(productoActual.getId() == idProducto){
                productoActual.cambiarPrecioDeVenta(porcentajeDeGanancia);
                break;
            }
        }
        supermercado.setMisProductos(misProductos);
    }

    /**
     * Elimina un producto del inventario
     * @param idProducto
     */
    public void eliminar(int idProducto){
        for(ProductoInventario productoActual: misProductos){
            if(productoActual.getId() == idProducto){
                misProductos.remove(productoActual);
                break;
            }
        }
        supermercado.setMisProductos(misProductos);
    }

    
    //              FUNCIONES ARRAY             //
    public int getCantidadProductos(){
        return misProductos.size();
    }
    
    //              OTROS                   //
    /**
     * Instancia una nueva VentanaPrincipal
     */
    public void iniciarVentanaPrincipal() {
        VentanaPrincipalModelo modelo = new VentanaPrincipalModelo();
        VentanaPrincipalVista vista = new VentanaPrincipalVista();
        VentanaPrincipalControlador controlador = new VentanaPrincipalControlador(modelo, vista);
    }
}
