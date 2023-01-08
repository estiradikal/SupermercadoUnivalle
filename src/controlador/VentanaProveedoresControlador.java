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
 *    Elboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaProveedoresControlador.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import vista.*;

public class VentanaProveedoresControlador {
    
    protected int selectedId;
    protected int selectedRow;
    
    protected VentanaProveedoresModelo modelo = new VentanaProveedoresModelo();
    protected VentanaProveedoresVista vista = new VentanaProveedoresVista();    
    
    /**
     * Constructor de el clase VentanaProveedoresControlador
     * @param modelo El modelo de el ventana (VentanaProveedoresModelo)
     * @param vista La vista de el ventana (VentanaProveedoresVista)
     */
    public VentanaProveedoresControlador(VentanaProveedoresModelo modelo, VentanaProveedoresVista vista) {
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
     * Carga los datos del arreglo en el modelo a el tabla
     */
    public void cargarTabla() {
        for (int i = 0; i < modelo.getCantidadProveedores(); i++) {
            int id = modelo.getId(i);
            String nombre = modelo.getNombre(i);
            vista.nuevaFila(id, nombre);
        }
    }

    
    //              MODOS DE OPERACION               //
    /**
     * Habilita y deshabilita elementos en el interfaz para REGISTRAR NUEVOS
     * PROVEEDORES
     */
    public void modoRegistrar() {
        vista.setGuiaModificar();
        vista.deshabilitarCancelar();
        vista.deshabilitarModificar();
        vista.deshabilitarEliminar();
        vista.habilitarRegistrar();
    }

    /**
     * Habilita y deshabilita elementos en el interfaz para HACER MODIFICACIONES
     * EN PROVEEDORES EXISTENTES (Modificar datos y eliminar)
     */
    public void modoModificar() {
        vista.setGuiaRegistrar();
        vista.deshabilitarRegistrar();
        vista.habilitarModificar();
        vista.habilitarEliminar();
        vista.habilitarCancelar();
    }
    
    /**
     * Recarga algunos elementos y datos de el vista
     */
    public void recargarTodo(){
        vista.limpiarCampos();
        vista.limpiarTabla();
        modoRegistrar();
        cargarTabla();
    }
    
    /**
     * Instancia una VentanaPrincipal y cierra el actual
     */
    public void volverAlMenu(){
        vista.cerrar();
        modelo.iniciarVentanaPrincipal();
    }
    
    
    //              MEDIDAS DE SEGURIDAD                //
    /**
     * Medida de seguridad, verifica si el campo de nombre esta vacio y retroalimenta al usuario
     * @return true, el campo esta vacio; false, el campo no esta vacio
     */
    public boolean campoNombreEstaVacio(){
        
        boolean respuesta = true;
        
        if(!vista.getNombre().isBlank()){
            respuesta = false;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Error: Debe escribir un nombre en el campo de nombre",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
            
        return respuesta;
    }
    
    /**
     * Medida de seguridad, verifica si el campo de id tiene un numero y retroalimenta al usuario
     * @return true, el campo tiene un numero; false, el campo contiene otros caracteres
     */
    public boolean idEsNumericoEnVista(){
        boolean respuesta = false;
        
        try{
            Integer.parseInt(vista.getId());
            respuesta = true;
        } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Error: Debe escribir un numero en el campo de id",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
        }
        return respuesta;
    }
    
    /**
     * Medida de seguridad, verifica si existe otro proveedor con este id y retroalimenta al usuario
     * @param id El id del proveedor a analizar (int)
     * @return true, este id ya esta ocupado por otro proveedor; false, el id esta libre
     */
    public boolean existeOtroProveedorConEsteId(int id) {
        
        boolean respuesta = false;
        
        if (modelo.existeId(id) && id != selectedId) {
            respuesta = true;
            JOptionPane.showMessageDialog(null,
                    "Error: Ya existe un producto con este id",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        return respuesta;
    }
    
    //              LISTENERS               //
    /**
     * Se encarga de registrar un nuevo proveedor cuidando el integridad de el 
     * informacion
     */
    ActionListener oyenteRegistrar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            
            if(idEsNumericoEnVista()){
                if(!campoNombreEstaVacio()){
                    
                    int id = Integer.parseInt(vista.getId());
                    String nombre;

                    if(!existeOtroProveedorConEsteId(id)){
                        nombre = vista.getNombre();
                        modelo.registrar(id, nombre);

                        JOptionPane.showMessageDialog(null, "Registro exitoso!");
                        recargarTodo();
                    }
                }
            }      
        }
    };
    
    /**
     * Se encarga de modificar un nuevo proveedor cuidando el integridad de el 
     * informacion
     */
    ActionListener oyenteModificar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try{
                int id = Integer.parseInt(vista.getId());
                String nombre = vista.getNombre();
                
                if(vista.getNombre().isBlank())
                    JOptionPane.showMessageDialog(null,
                        "Error: Debe escribir un nombre en el campo de nombre", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                else if (modelo.existeId(id) && id != selectedId){
                    JOptionPane.showMessageDialog(null,
                        "Error: Ya existe alguien con esta id", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
                else {
                    
                    modelo.modificar(selectedId, id, nombre);
            
                    JOptionPane.showMessageDialog(null, "Modificacion exitosa!");
                    recargarTodo();
                }
                 
            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,
                        "Error: Debe escribir un numero en el campo de id", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    
    /**
     * Se encarga de eliminar proveedores del arreglo
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
     * Redirige a el VentanaPrincipal
     */
    ActionListener oyenteVolver = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            volverAlMenu();
        }
    };
    
    /**
     * Gestiona los clics en las filas de el tabla
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
                vista.setId(table.getValueAt(table.getSelectedRow(), 0).toString());
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
