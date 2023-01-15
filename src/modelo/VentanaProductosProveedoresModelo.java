package modelo;

import vista.*;
import controlador.*;
import javax.swing.JComboBox;
import supermercado.*;


/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaProductosProveedoresModelo.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/
public class VentanaProductosProveedoresModelo {
    
    
    Supermercado supermercado = new Supermercado();
    
    java.util.List<Proveedor> proveedores = supermercado.getMisProveedores();
    java.util.List<ProductoProveedor> productosEnElMercado = supermercado.getProductosEnElMercado();
    
    public VentanaProductosProveedoresModelo(){
    }
    
    
    public String getProveedor(int indice){
        return proveedores.get(indice).getNombre();
    }
    
    public int getProveedoresCantidad(){
        return proveedores.size();
    }

    public String getProductos(int indice){
        return productosEnElMercado.get(indice).getNombre();
    }
    
    public int getProductosCantidad(){
        return proveedores.size();
    }
    
    public void iniciarVentanaPrincipal() {
        VentanaPrincipalModelo modelo = new VentanaPrincipalModelo();
        VentanaPrincipalVista vista = new VentanaPrincipalVista();
        VentanaPrincipalControlador controlador = new VentanaPrincipalControlador(modelo, vista);
    }
    
}