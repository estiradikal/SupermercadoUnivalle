package controlador;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaPrincipalControlador.java
 *    Licencia: GNU-GPL 
 *    @version  1.1
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;

public class VentanaPrincipalControlador {
    
    protected VentanaPrincipalModelo modelo = new VentanaPrincipalModelo();
    protected VentanaPrincipalVista vista = new VentanaPrincipalVista();

    /**
     * Constructor de la clase VentanaPrincipalControlador
     * @param modelo El modelo asociado al controlador (VentanaPrincipalModelo)
     * @param vista La vista asociada al controlador (VentanaPrincipalVista)
     */
    public VentanaPrincipalControlador(VentanaPrincipalModelo modelo, VentanaPrincipalVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        
        vista.addActionProductos(oyenteProductos);
        vista.addActionProveedores(oyenteProveedores);
        vista.addActionClientes(oyenteClientes);
        vista.addActionProductosProveedores(oyenteProductosProveedores);
        vista.addActionComprarProductos(oyenteComprarProductos);
        vista.addActionRegistroVentas(oyenteRegistroVentas);
    }

    /**
     * Redirige al metodo modelo.iniciarVentanaProductos y cierra la ventana
     */
    ActionListener oyenteProductos = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            vista.cerrar();
            modelo.iniciarVentanaProductos();
        }
    };
    
    /**
     * Redirige al metodo modelo.iniciarVentanaProveedores y cierra la ventana
     */
    ActionListener oyenteProveedores = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            vista.cerrar();
            modelo.iniciarVentanaProveedores();
        }
    };
    
    /**
     * Redirige al metodo modelo.iniciarVentanaClientes y cierra la ventana
     */
    ActionListener oyenteClientes = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            vista.cerrar();
            modelo.iniciarVentanaClientes();
        }
    };
    
    /**
     * Redirige al metodo modelo.iniciarVentanaProductosProveedores y cierra la ventana
     */
    ActionListener oyenteProductosProveedores = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(null, "Aun no implementado");
            vista.cerrar();
            modelo.iniciarVentanaProductosProveedores();
        }
    };
    
    /**
     * Redirige al metodo modelo.iniciarVentanaComprarProductos y cierra la ventana
     */
    ActionListener oyenteComprarProductos = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Aun no implementado");
//            vista.cerrar();
//            modelo.iniciarVentanaComprarProductos();
        }
    };
    
    /**
     * Redirige al modelo.iniciarVentanaRegistroVentas y cierra la ventana
     */
    ActionListener oyenteRegistroVentas = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Aun no implementado");
//            vista.cerrar();
//            modelo.iniciarVentanaRegistroVentas();
        }
    };
}
