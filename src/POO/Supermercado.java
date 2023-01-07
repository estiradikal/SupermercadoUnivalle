package POO;

import java.util.ArrayList;
import java.util.List;

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

public class Supermercado {
    
    protected java.util.List<ProductoProveedor> productosEnElMercado = new ArrayList<>();
    protected java.util.List<ProductoInventario> misProductos = new ArrayList<>();
    protected java.util.List<Cliente> misClientes = new ArrayList<>();
    protected java.util.List<Proveedor> misProveedores = new ArrayList<>();
    protected java.util.List<Venta> misVentas = new ArrayList<>();

    /**
     * Constructor de la clase Supermercado
     */
    public Supermercado(){
    }

    /**
     * Obtiene el arreglo de productos en el mercado
     * @return El arreglo de productos en el mercado (List-ProductoProveedor-)
     */
    public List<ProductoProveedor> getProductosEnElMercado() {
        return productosEnElMercado;
    }

    /**
     * Asigna un arreglo de productos en el mercado
     * @param productosEnElMercado El arreglo de productos en el mercado (List-ProductoProveedor-)
     */
    public void setProductosEnElMercado(List<ProductoProveedor> productosEnElMercado) {
        this.productosEnElMercado = productosEnElMercado;
    }

    /**
     * Obtiene el arreglo de productos que pertenecen al supermercado
     * @return misProductos El arreglo de productos (List-ProductoInventario-)
     */
    public List<ProductoInventario> getMisProductos() {
        return misProductos;
    }

    /**
     * Asigna un arreglo de productos al supermercado
     * @param misProductos El arreglo de productos (List-ProductoInventario-)
     */
    public void setMisProductos(List<ProductoInventario> misProductos) {
        this.misProductos = misProductos;
    }

    /**
     * Obtiene el arreglo de los clientes del supermercado
     * @return misClientes El arreglo de clientes (List-Cliente-)
     */
    public List<Cliente> getMisClientes() {
        return misClientes;
    }

    /**
     * Asigna un arreglo de clientes al supermercado
     * @param misClientes El arreglo de clientes (List-Cliente-)
     */
    public void setMisClientes(List<Cliente> misClientes) {
        this.misClientes = misClientes;
    }

    /**
     * Obtiene el arreglo de los proveedores del supermercado
     * @return El arreglo de proveedores (List-Proveedor-)
     */
    public List<Proveedor> getMisProveedores() {
        return misProveedores;
    }

    /**
     * Asigna un arreglo de proveedores al supermercado
     * @param misProveedores El arreglo de proveedores (List-Proveedor-)
     */
    public void setMisProveedores(List<Proveedor> misProveedores) {
        this.misProveedores = misProveedores;
    }

    /**
     * Obtiene el arreglo de ventas del supermercado
     * @return misVentas El arreglo de ventas del supermercado (List-Venta-)
     */
    public List<Venta> getMisVentas() {
        return misVentas;
    }

    /**
     * Asigna un arreglo de ventas al supermercado
     * @param misVentas El arreglo de ventas del supermercado (List-Venta-)
     */
    public void setMisVentas(List<Venta> misVentas) {
        this.misVentas = misVentas;
    }
    
    
}
