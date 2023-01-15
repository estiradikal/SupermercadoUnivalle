package controlador;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaProductosProveedoresControlador.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
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

public class VentanaProductosProveedoresControlador {
    
    protected int selectedId;
    protected int selectedRow;
    
    protected VentanaProductosProveedoresModelo modelo = new VentanaProductosProveedoresModelo();
    protected VentanaProductosProveedoresVista vista = new VentanaProductosProveedoresVista(); 
    
    
    public VentanaProductosProveedoresControlador(VentanaProductosProveedoresModelo modelo, VentanaProductosProveedoresVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        
        vista.addActionVolver(oyenteVolver);
        vista.addActionAsignar(oyenteAsignar);
        /*
        vista.addActionRegistrar(oyenteRegistrar);
        vista.addActionModificar(oyenteModificar);
        vista.addActionEliminar(oyenteEliminar);
        vista.addActionCancelar(oyenteCancelar);
        vista.addActionTable(oyenteFilas);
        */
        
        cargarProductos();
        cargarProveedores();
        cargarTabla();
        
        vista.setGuiaModificar();
    }
    
    //              ELEMENTOS DE LA INTERFAZ               //
        
    public void cargarTabla(){
        
        vista.limpiarTabla();
        
        for(int i = 0; i < modelo.getCantidadProveedores(); i++){
            
            String nombreProveedorActual = modelo.getNombreProveedor(i);
            int idProveedorActual = modelo.getIdProveedor(i);
            
            modelo.seleccionarProductos(idProveedorActual);
            
            for(int j = 0; j < modelo.getCantidadProductosProveedor(); j++){
                
                int idProductoActual = modelo.getIdProductoProveedor(j);
                String nombreProductoActual = modelo.getNombreProductoProveedor(j);                
                
                vista.nuevaFila(idProveedorActual, nombreProveedorActual, idProductoActual, nombreProductoActual);
            }
        }
    }
    
    //              MODOS DE OPERACION               //
    /**
     * Habilita y deshabilita elementos en la interfaz para REGISTRAR NUEVOS
     * CLIENTES
     */
    public void modoRegistrar() {
        vista.setGuiaModificar();
        vista.deshabilitarCancelar();
        vista.deshabilitarModificar();
        vista.deshabilitarEliminar();
        vista.habilitarRegistrar();
    }
    
    
    public void cargarProveedores() {
        for (int i = 0; i < modelo.getCantidadProveedores(); i++) {
            String nombreProveedorActual = modelo.getProveedorCifrado(i);
            vista.addProveedor(nombreProveedorActual);
        }
    }
    
    public void cargarProductos() {
        for (int i = 0; i < modelo.getCantidadProductosEnElMercado(); i++) {
            String nombreProductoActual = modelo.getProductoCifrado(i);
            vista.addProductoProveedor(nombreProductoActual);
        }
    }
    
    /**
     * Habilita y deshabilita elementos en la interfaz para HACER MODIFICACIONES
     * EN CLIENTES EXISTENTES (Modificar datos y eliminar)
     */
    public void modoModificar() {
        vista.setGuiaRegistrar();
        vista.deshabilitarRegistrar();
        vista.habilitarModificar();
        vista.habilitarEliminar();
        vista.habilitarCancelar();
    }
   
    /**
     * Recarga algunos elementos y datos de la vista
     */
    /*
    public void recargarTodo(){
        vista.limpiarTabla();
        modoRegistrar();
        cargarTabla();
    }
    
    /**
     * Instancia una VentanaPrincipal y cierra la actual
     */
    /*
    public void volverAlMenu(){
        vista.cerrar();
        modelo.iniciarVentanaPrincipal();
    }
    
    ActionListener oyenteRegistrar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            modelo.registrar(proveedor);
        }
        
    };
    */
    
    /**
     * Instancia una VentanaPrincipal y cierra la actual
     */
    public void volverAlMenu(){
        vista.cerrar();
        modelo.iniciarVentanaPrincipal();
    }
    
    
    ActionListener oyenteAsignar = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombreProductoCifrado = vista.getProductoProveedor();
            String nombreProveedorCifrado = vista.getProveedor();
            
            modelo.asignarProductoAProveedor(nombreProductoCifrado, nombreProveedorCifrado);
            JOptionPane.showMessageDialog(null, "Ejecucion completada");
            
            cargarTabla();
        }
    };
    
    /**
     * Redirige a el VentanaPrincipal
     */
    ActionListener oyenteVolver = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            volverAlMenu();
        }
    };
}
