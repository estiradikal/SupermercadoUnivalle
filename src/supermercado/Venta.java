package supermercado;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  Supermercado.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

public class Venta implements Serializable{
    
    protected String fecha;
    protected String cliente;
    protected int precio;
    protected String producto;
    protected int cantidad;
    protected int total;
    
    
    
    
    /**
     * Constructor de la clase Venta
     * @param fecha La fecha de la compra de forma MM/dd/yyyy, HH:mm:ss (String)
     * @param cliente El cliente que participo en la compra (Cliente)
     * @param precio El precio del producto a vender (int)
     * @param producto El producto que se vendió (ProctoInventario)
     * @param cantidad La cantidad de productos que se compró (int)
     * @param total El costo total de la compra (int)
     * 
     */
    public Venta(String fecha, String cliente, int precio, String producto, int cantidad, int total) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.precio = precio;
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
      
    }

    /**
     * Obtiene la fecha de la compra
     * @return fecha La fecha como cadena de texto de forma MM/dd/yyyy, HH:mm:ss (String)
     */
    public String getFecha() {
        return fecha;
    }
       
    /**
     * Obtiene el cliente que participo en la compra
     * @return cliente (String)
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * Asigna un cliente a la venta 
     * @param cliente El cliente (String)
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    /**
     * Obtiene el precio del producto en la compra
     * @return precio El precio como numero entero (int)
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Obtiene el producto de la compra
     * @return producto El producto que se vendio (String)
     */
    public String getProducto() {
        return producto;
    }

    /**
     * Asigna un producto a la venta
     * @param producto El producto de la venta (String)
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * Obtiene la cantidad de producto que se vendio
     * @return cantidad La cantidad de producto en la venta (int)
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Asigna una cantidad de producto a la veta
     * @param cantidad La nueva cantidad de producto en la venta (int)
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    /**
     * Obtiene el costo total de la compra
     * @return total El costo total como numero entero (int)
     */
    public int getTotal() {
        return total;
    }

}
