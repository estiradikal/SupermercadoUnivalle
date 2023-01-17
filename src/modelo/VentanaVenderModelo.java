
package modelo;

import controlador.*;
import supermercado.*;
import vista.*;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01
 *    Laboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaProductosVista.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

public class VentanaVenderModelo {
    
    /**
     *Instancia de la clase Supermercado 
     */
    Supermercado supermercado = new Supermercado();
    /**
     * Lista de la clase Proveedores
     */
    java.util.List<Proveedor> misProveedores=supermercado.getMisProveedores();
    java.util.List<ProductoInventario> misProductos=supermercado.getMisProductos();
    
    //Constructor
    public VentanaVenderModelo(){
        
    }
    
    /**
     * Retorna el tamaño que devuelva el ArrayList
     * @return 
     */
    public int getCantidadProveedores(){
        return misProveedores.size();
    }
    /**
     * Trae el Id del proveedor
     * @param indice
     * @return 
     */
    public int getIdProveedor(int indice){
        return misProveedores.get(indice).getId();
    }
    /**
     * Trae el nombre del proveedor
     * @param indice
     * @return 
     */
    public String getNombreProveedor(int indice){
        return misProveedores.get(indice).getNombre();
    }
    /**
     * Retorna la cantidad de productos disponibles en el inventario
     * @return 
     */
    public int getCantidadProductos(){
        return misProductos.size();
    }
    /**
     * Retorna el Id del producto
     * @param indice
     * @return 
     */
    public int getIdProducto(int indice){
        return misProductos.get(indice).getId();
    }
    /**
     * Retorna el nombre del producto
     * @param indice
     * @return 
     */
    public String getNombreProducto(int indice){
        return misProductos.get(indice).getNombre();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public String addProveedor(int indice){
        for (Proveedor actual:misProveedores){
            //return proveedor += actual.getNombre();
        }
        return misProveedores.get(indice).getNombre();
        
    }
    
    public int getProveedoresCantidad(){
        return misProveedores.size();
    }

    
    public void iniciarVentanaPrincipal() {
        VentanaPrincipalModelo modelo = new VentanaPrincipalModelo();
        VentanaPrincipalVista vista = new VentanaPrincipalVista();
        VentanaPrincipalControlador controlador = new VentanaPrincipalControlador(modelo, vista);
    }
    
}
