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

public class ProductoInventario extends ProductoProveedor implements Serializable{
    /**
     * Declaración de variables
     */
    protected int cantidad;
    int precio;
    protected double porcentajeGanancia;
    protected double ganancia;
    int precioDeVenta;

    /**
     * Constructor de la clase ProductoProveedor
     * @param cantidad La cantidad de producto que se comprara (int)
     * @param Id El id del producto (int)
     * @param nombre El nombre del producto (String)
     * @param precio El precio de compra del producto (int)
     * @param medida La medida (kilogramos o unidades) del producto (String)
     */
    public ProductoInventario(int cantidad, int Id, String nombre, int precio, String medida) {
        super(Id, nombre, precio, medida);
        this.cantidad = cantidad;
        cambiarPrecioDeVenta(10);
    }

    /**
     * Obtiene la cantidad de producto disponible
     * @return cantidad La cantidad de producto actualmente disponible (int)
     */
    public int getCantidad() {
        return cantidad;
    }
    
    /**
     * Asigna la cantidad de producto disponible
     * @param cantidad La cantidad de producto actualmente disponible (int)
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public int getPrecioDeCompra(){
        return precio;
    }
    
    public void actualizarPrecioDeCompra(int nuevoPrecioDeCompra){
        precio = nuevoPrecioDeCompra;
        cambiarPrecioDeVenta(porcentajeGanancia);
    }
    
    public int getPrecioDeVenta(){
        return precioDeVenta;
    }
    
    public double getPorcentajeGanancia(){
        return porcentajeGanancia;
    }
    
    public void cambiarPrecioDeVenta(double porcentajeDeGanancia){
        porcentajeGanancia = porcentajeDeGanancia;
        ganancia = porcentajeGanancia / 100;
        precioDeVenta = (int)Math.round((double)precio + (double)precio * ganancia);
    }
}
