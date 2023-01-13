package modelo;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaPrincipalModelo.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import vista.*;
import controlador.*;

public class VentanaPrincipalModelo {
    
    /**
     * Constructor de la clase VentanaPrincipalModelo
     */
    public VentanaPrincipalModelo(){
    }
    
    /**
     * Instancia una nueva ventana de productos
     */
    public void iniciarVentanaProductos(){
        VentanaProductosVista vista = new VentanaProductosVista();
        VentanaProductosModelo modelo = new VentanaProductosModelo();
        VentanaProductosControlador controlador = new VentanaProductosControlador(modelo, vista);
    }
    
    /**
     * Instancia una nueva ventana de proveedores
     */
    public void iniciarVentanaProveedores(){
        VentanaProveedoresVista vista = new VentanaProveedoresVista();
        VentanaProveedoresModelo modelo = new VentanaProveedoresModelo();
        VentanaProveedoresControlador controlador = new VentanaProveedoresControlador(modelo, vista);
    }
    
    /**
     * Instancia una nueva ventana de clientes
     */
    public void iniciarVentanaClientes(){
        VentanaClientesVista vista = new VentanaClientesVista();
        VentanaClientesModelo modelo = new VentanaClientesModelo();
        VentanaClientesControlador controlador = new VentanaClientesControlador(modelo, vista);
    }
    
    /**
     * Instancia una nueva ventana paraasignar Productos a proveedores
     */
    public void iniciarVentanaProductosProveedores(){
        VentanaProductosProveedoresVista vista = new VentanaProductosProveedoresVista();
        VentanaProductosProveedoresModelo modelo = new VentanaProductosProveedoresModelo();
        VentanaProductosProveedoresControlador controlador = new VentanaProductosProveedoresControlador(modelo, vista);
    }
    
    /**
     * Instancia una nueva ventana para comprar productos
     */
    public void iniciarVentanaComprarProductos(){
    }
    
    /**
     * Instancia una nueva ventana del registro de ventas
     */
    public void iniciarVentanaRegistroVentas(){
    }
     
}
