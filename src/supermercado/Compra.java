package supermercado;

import java.io.Serializable;

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

public class Compra implements Serializable{
    /**
     * Declaración de variables
     */
    protected String fecha;
    protected String producto;
    protected int precio;
    protected int cantidad;
    protected int total;

    /**
     * Constructor de la clase compra
     * @param fecha La fecha de la compra de forma MM/dd/yyyy, HH:mm:ss (String)
     * @param producto El nombre del producto (String)
     * @param precio El precio del producto (int)
     * @param cantidad La cantidad deproducto  (int)
     * @param total El costo total de la compra (int)
     */
    public Compra(String fecha, String producto, int precio, int cantidad, int total) {
        this.fecha = fecha;
        this.producto = producto;
        this.precio = precio;
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
     * Obtiene el nombre del producto en la compra
     * @return producto El nombre como cadena de texto (String)
     */
    public String getProducto() {
        return producto;
    }

    /**
     * Obtiene el precio del producto en la compra
     * @return precio El precio como numero entero (int)
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Obtiene la cantidad de producto adquirida en la compra
     * @return cantidad La cantidad como numero entero (int)
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Obtiene el costo total de la compra
     * @return total El costo total como numero entero (int)
     */
    public int getTotal() {
        return total;
    }
}
