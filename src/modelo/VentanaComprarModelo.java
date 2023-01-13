package modelo;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaInventarioModelo.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import controlador.VentanaPrincipalControlador;
import java.util.ArrayList;
import supermercado.*;
import vista.VentanaPrincipalVista;

public class VentanaComprarModelo {
    
    Supermercado supermercado = new Supermercado();
    java.util.List<Proveedor> proveedores = supermercado.getMisProveedores();;
    java.util.List<ProductoInventario> misProductos = supermercado.getMisProductos();
    java.util.List<ProductoProveedor> productosProveedor = new ArrayList<>();
    
    public VentanaComprarModelo(){
    }
    
    /**
     * Registra un nuevo producto inventario
     * @param id El id (int)
     * @param nombre El nombre del producto (String)
     * @param cantidad La cantidad de producto segun la medida (int)
     * @param precio El precio segun la medida (int)
     * @param medida La medida en unidades o kilos
     */
    public void registrar(int id, String nombre, int cantidad, int precio, String medida){
        misProductos.add(new ProductoInventario(cantidad, id, nombre, precio, medida));
        supermercado.setMisProductos(misProductos);
    }
    
    /**
     * Elimina el producto que cumple con un id
     * @param id La cedula del cliente (int)
     */
    public void eliminar(int id){
        for(ProductoInventario productoActual: misProductos){
            if(productoActual.getId() == id){
                misProductos.remove(productoActual);
                break;
            }
        }
        supermercado.setMisProductos(misProductos);
    }
    
    public String getProveedorCompleto(int indice){
        String proveedorActual = "";
        
        proveedorActual += proveedores.get(indice).getId();
        proveedorActual += "@" + proveedores.get(indice).getNombre();
        
        return proveedorActual;
    }
    
    /**
     * 
     * @param indice
     * @return 
     */
    public int getIdProveedor(int indice){
        return proveedores.get(indice).getId();
    }
    
    /**
     * 
     * @param indice
     * @return 
     */
    public String getNombreProveedor(int indice){
        return proveedores.get(indice).getNombre();
    }
    
    /**
     * 
     * @param indice
     * @return 
     */
    public int getIdProducto(int indice){
        return misProductos.get(indice).getId();
    }
    
    public String getProductoCompleto(int indice){
        String productoActual = "";
        
        productoActual += proveedores.get(indice).getId();
        productoActual += "@" + proveedores.get(indice).getNombre();
        
        return productoActual;
    }
    
    /**
     * 
     * @param indice
     * @return 
     */
    public String getNombreProducto(int indice){
        return misProductos.get(indice).getNombre();
    }
    
    /**
     * 
     * @param indice
     * @return 
     */
    public int getCantidadProducto(int indice){
        return misProductos.get(indice).getCantidad();
    }
    
    /**
     * 
     * @param indice
     * @return 
     */
    public String getPrecioProducto(int indice){
        return Integer.toString(misProductos.get(indice).getPrecio());
    }
    
    /**
     * 
     * @param indice
     * @return 
     */
    public String getMedidaProducto(int indice){
        return misProductos.get(indice).getMedida();
    }
    
    public int getCantidadProductosInventario(){
        return misProductos.size();
    }
    
    public int getCantidadProductosProveedor(){
        return productosProveedor.size();
    }
    
    public int getCantidadProveedores(){
        return proveedores.size();
    }
    
    public void seleccionarProductos(int idProveedor){
        for(Proveedor proveedorActual: proveedores){
            if(proveedorActual.getId() == idProveedor){
                productosProveedor = proveedorActual.getMisProductos();
            }
        }
    }
    
    /**
     * Instancia una nueva VentanaPrincipal
     */
    public void iniciarVentanaPrincipal() {
        VentanaPrincipalModelo modelo = new VentanaPrincipalModelo();
        VentanaPrincipalVista vista = new VentanaPrincipalVista();
        VentanaPrincipalControlador controlador = new VentanaPrincipalControlador(modelo, vista);
    }
}
