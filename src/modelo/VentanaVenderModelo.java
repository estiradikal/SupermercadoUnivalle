
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
    java.util.List<Cliente> misClientes=supermercado.getMisClientes();
    java.util.List<ProductoInventario> misProductos=supermercado.getMisProductos();
    
    //Constructor
    public VentanaVenderModelo(){
        
    }
    
    /**
     * Retorna el tamaño que devuelva el ArrayList
     * @return 
     */
    public int getCantidadClientes(){
        return misClientes.size();
    }
    /**
     * Trae el Id del proveedor
     * @param indice
     * @return 
     */
    public int getIdCliente(int indice){
        return misClientes.get(indice).getCedula();
    }
    /**
     * Trae el nombre del proveedor
     * @param indice
     * @return 
     */
    public String getNombreCliente(int indice){
        return misClientes.get(indice).getNombre();
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public String addCliente(int indice){
        for (Cliente actual:misClientes){
            //return proveedor += actual.getNombre();
        }
        return misClientes.get(indice).getNombre();
        
    }
    
    public int getProveedoresCantidad(){
        return misClientes.size();
    }

    
    public void iniciarVentanaPrincipal() {
        VentanaPrincipalModelo modelo = new VentanaPrincipalModelo();
        VentanaPrincipalVista vista = new VentanaPrincipalVista();
        VentanaPrincipalControlador controlador = new VentanaPrincipalControlador(modelo, vista);
    }
    
}
