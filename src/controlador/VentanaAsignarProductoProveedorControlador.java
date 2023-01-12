package controlador;

import modelo.*;
import vista.*;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01
 *    Elboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaProductosControlador.java
 *    Licencia: GNU-GPL 
 *    @version  1.2
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

public class VentanaAsignarProductoProveedorControlador {

    int selectedId;
    int selectedRow;

    protected VentanaAsignarProductoProveedorModelo modelo = new VentanaAsignarProductoProveedorModelo();
    protected VentanaAsignarProductoProveedorVista vista = new VentanaAsignarProductoProveedorVista();

    public VentanaAsignarProductoProveedorControlador(VentanaAsignarProductoProveedorModelo Modelo, VentanaAsignarProductoProveedorVista Vista) {

        this.modelo = modelo;
        this.vista = vista;

        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
    }
 
}
