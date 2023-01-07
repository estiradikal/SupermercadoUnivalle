package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.*;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01
 *    Elboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaProductosControlador.java
 *    Licencia: GNU-GPL 
 *    @version  0.1
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import vista.*;

public class VentanaProductosControlador {
    protected VentanaProductosModelo modelo = new VentanaProductosModelo();
    protected VentanaProductosVista vista = new VentanaProductosVista();

    public VentanaProductosControlador(VentanaProductosModelo modelo, VentanaProductosVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
    
        vista.addActionVolver(oyenteVolver);
        vista.addActionRegistrar(oyenteRegistrar);
        vista.addActionModificar(oyenteModificar);
        vista.addActionEliminar(oyenteEliminar);
    }
    
    ActionListener oyenteRegistrar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    };
    
    ActionListener oyenteModificar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    };
    
    ActionListener oyenteEliminar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    };
    
    ActionListener oyenteVolver = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            modelo.iniciarVentanaPrincipal();
            vista.cerrar();
        }
    };
}
