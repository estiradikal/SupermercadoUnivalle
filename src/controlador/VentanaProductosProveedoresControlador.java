package controlador;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaProductosProveedoresControlador.java
 *    Licencia: GNU-GPL 
 *    @version  1.2
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ConcurrentModificationException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.*;
import vista.*;

public class VentanaProductosProveedoresControlador {
    
    protected int selectedIdProveedor;
    protected int selectedIdProducto;
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
        vista.addActionDesasignar(oyenteDesasignar);
        vista.addActionCancelar(oyenteCancelar);
        vista.addActionTable(oyenteFilas);
        /*
        vista.addActionRegistrar(oyenteRegistrar);
        vista.addActionModificar(oyenteModificar);
        
        vista.addActionCancelar(oyenteCancelar);
        
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
    
    
    //              MODOS DE OPERACION               //
    /**
     * Habilita y deshabilita elementos en la interfaz para REGISTRAR NUEVOS
     * CLIENTES
     */
    public void modoRegistrar() {
        vista.setGuiaModificar();
        vista.habilitarBoxes();
        vista.deshabilitarCancelar();
        vista.deshabilitarEliminar();
        vista.habilitarRegistrar();
    }
    
    /**
     * Habilita y deshabilita elementos en la interfaz para HACER MODIFICACIONES
     * EN CLIENTES EXISTENTES (Modificar datos y eliminar)
     */
    public void modoModificar() {
        vista.setGuiaRegistrar();
        vista.deshabilitarBoxes();  
        vista.deshabilitarRegistrar();
        vista.habilitarEliminar();
        vista.habilitarCancelar();
    }
                 
    /**
     * Instancia una VentanaPrincipal y cierra la actual
     */
    public void volverAlMenu(){
        vista.cerrar();
        modelo.iniciarVentanaPrincipal();
    }
    
    
    //              FUNCIONES                   //
    public void desasignarFilaSeleccionada() {
        modelo.desasignarProductoDeProveedor(selectedIdProducto, selectedIdProveedor);
        cargarTabla();
        modoRegistrar();
                JOptionPane.showMessageDialog(null, """
                                                    La desasignación se realizó con exito.
                                                    
                                                    Este proveedor no ofrecerá más este producto a menos
                                                    de que lo asigne de nuevo.""");
    }
    
    ActionListener oyenteAsignar = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
            String nombreProductoCifrado = vista.getProductoProveedor();
            String nombreProveedorCifrado = vista.getProveedor();

            if (modelo.productoYaOfrecidoPorProveedor(nombreProductoCifrado, nombreProveedorCifrado)) {
                JOptionPane.showMessageDialog(null,
                        "Este proveedor ya ofrece este producto, no es necesario asignar de nuevo",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                modelo.asignarProductoAProveedor(nombreProductoCifrado, nombreProveedorCifrado);
                JOptionPane.showMessageDialog(null, "Asignacion realizada con exito.");
            }

            cargarTabla();
        }
    };
    
    ActionListener oyenteDesasignar = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent evt) {
            try{
                desasignarFilaSeleccionada();
            } catch (ConcurrentModificationException e){
                desasignarFilaSeleccionada();
            }
        }
    };
    
    ActionListener oyenteCancelar = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent evt) {
            modoRegistrar();            
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
    
    /**
     * Gestiona los clics en las filas de la tabla
     */
    MouseListener oyenteFilas = new MouseListener() {
        @Override
        public void mousePressed(MouseEvent Mouse_evt) {
            
            JTable table = (JTable) Mouse_evt.getSource();
            selectedRow = table.getSelectedRow();
            Point point = Mouse_evt.getPoint();
            
            int row = table.rowAtPoint(point);
            
            try {
                selectedIdProveedor = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
                selectedIdProducto = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 2).toString());
            } catch (NumberFormatException e) {
                
            }

            if (Mouse_evt.getClickCount() == 1) {
                modoModificar();
            }
        }

        @Override
        public void mouseClicked(MouseEvent evt) {
        }

        @Override
        public void mouseReleased(MouseEvent evt) {
        }

        @Override
        public void mouseEntered(MouseEvent evt) {
        }

        @Override
        public void mouseExited(MouseEvent evt) {
        }
    };
}
