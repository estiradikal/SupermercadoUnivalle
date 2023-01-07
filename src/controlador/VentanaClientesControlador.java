package controlador;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.*;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
    Laboratorio # 4
    Profesor: Luis Romo Portilla 

    Archivo:  VentanaClientesControlador.java
    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import vista.*;

public class VentanaClientesControlador {
    
    protected int selectedId;
    protected int selectedRow;
    
    protected VentanaClientesModelo modelo = new VentanaClientesModelo();
    protected VentanaClientesVista vista = new VentanaClientesVista();    
    
    /**
     * Constructor de la clase VentanaClientesControlador
     * @param modelo El modelo de la ventana (VentanaClientesModelo)
     * @param vista La vista de la ventana (VentanaClientesVista)
     */
    public VentanaClientesControlador(VentanaClientesModelo modelo, VentanaClientesVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        
        vista.addActionVolver(oyenteVolver);
        vista.addActionRegistrar(oyenteRegistrar);
        vista.addActionModificar(oyenteModificar);
        vista.addActionEliminar(oyenteEliminar);
        vista.addActionCancelar(oyenteCancelar);
        vista.addActionTable(oyenteFilas);
        
        cargarTabla();
        vista.setGuiaModificar();
    }
    
    
    //              ELEMENTOS DE LA INTERFAZ               //
    /**
     * Carga los datos del arreglo en el modelo a la tabla
     */
    public void cargarTabla() {
        for (int i = 0; i < modelo.getCantidadClientes(); i++) {
            int cedula = modelo.getCedula(i);
            String nombre = modelo.getNombre(i);
            vista.nuevaFila(cedula, nombre);
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
    public void recargarTodo(){
        vista.limpiarCampos();
        vista.limpiarTabla();
        modoRegistrar();
        cargarTabla();
    }
    
    /**
     * Instancia una VentanaPrincipal y cierra la actual
     */
    public void volverAlMenu(){
        vista.cerrar();
        modelo.iniciarVentanaPrincipal();
    }
    
    
    //              LISTENERS               //
    /**
     * Se encarga de registrar un nuevo cliente cuidando la integridad de la 
     * informacion
     */
    ActionListener oyenteRegistrar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try{
                int cedula = Integer.parseInt(vista.getCedula());
                String nombre;
                
                if(vista.getNombre().isBlank())
                    JOptionPane.showMessageDialog(null,
                        "Error: Debe escribir un nombre en el campo de nombre", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                else if (modelo.existeCedula(cedula)){
                    JOptionPane.showMessageDialog(null,
                        "Error: Ya existe alguien con esta cedula", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
                else{
                    nombre = vista.getNombre();
                    modelo.registrar(cedula, nombre);
                    
                    JOptionPane.showMessageDialog(null, "Registro exitoso!");
                    recargarTodo();
                }
                 
            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,
                        "Error: Debe escribir un numero en el campo de cedula", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    
    /**
     * Se encarga de modificar un nuevo cliente cuidando la integridad de la 
     * informacion
     */
    ActionListener oyenteModificar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try{
                int cedula = Integer.parseInt(vista.getCedula());
                String nombre = vista.getNombre();
                
                if(vista.getNombre().isBlank())
                    JOptionPane.showMessageDialog(null,
                        "Error: Debe escribir un nombre en el campo de nombre", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                else if (modelo.existeCedula(cedula) && cedula != selectedId){
                    JOptionPane.showMessageDialog(null,
                        "Error: Ya existe alguien con esta cedula", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
                else {
                    
                    modelo.modificar(selectedId, cedula, nombre);
            
                    JOptionPane.showMessageDialog(null, "Modificacion exitosa!");
                    recargarTodo();
                }
                 
            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,
                        "Error: Debe escribir un numero en el campo de cedula", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    
    /**
     * Se encarga de eliminar clientes del arreglo
     */
    ActionListener oyenteEliminar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
         modelo.eliminar(selectedId);
         recargarTodo();
        }
    };
    
    /**
     * Sale del modo modificar sin haber realizado cambios
     */
    ActionListener oyenteCancelar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
         recargarTodo();
        }
    };
    
    /**
     * Redirige a la VentanaPrincipal
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
                selectedId = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
            } catch (NumberFormatException e) {
                
            }

            if (Mouse_evt.getClickCount() == 1) {
                vista.setCedula(table.getValueAt(table.getSelectedRow(), 0).toString());
                vista.setNombre(table.getValueAt(table.getSelectedRow(), 1).toString());
                modoModificar();
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    };
}
