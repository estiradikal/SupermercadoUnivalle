package supermercado;

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

public class Venta {
    
    protected Cliente cliente;
    protected ProductoInventario producto;
    protected int cantidad;
    protected int dia;
    protected int mes;
    protected int anio;

    /**
     * Constructor de la clase Venta
     * @param cliente El cliente que participo en la compra (Cliente)
     * @param producto El producto que se vendió (ProctoInventario)
     * @param cantidad La cantidad de productos que se compró (int)
     * @param dia El dia en el que se hizo la compra (int)
     * @param mes El mes en el que se hizo la compra (int)
     * @param anio El anio en el que se hizo la compra (int)
     */
    public Venta(Cliente cliente, ProductoInventario producto, int cantidad, int dia, int mes, int anio) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    /**
     * Obtiene el cliente que participo en la compra
     * @return cliente El cliente (Cliente)
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Asigna un cliente a la venta 
     * @param cliente El cliente (Cliente)
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene el producto de la compra
     * @return producto El producto que se vendio (ProductoInventario)
     */
    public ProductoInventario getProducto() {
        return producto;
    }

    /**
     * Asigna un producto a la venta
     * @param producto El producto de la venta (ProductoInventario)
     */
    public void setProducto(ProductoInventario producto) {
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

}
