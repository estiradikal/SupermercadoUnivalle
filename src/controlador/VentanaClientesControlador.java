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
 *    Archivo:  VentanaClientesControlador.java
 *    Licencia: GNU-GPL 
 *    @version  1.2
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
     * Medida de seguridad, verifica si el campo de cedula tiene un numero y retroalimenta al usuario
     * @return true, el campo tiene un numero; false, el campo contiene otros caracteres
     */
    public boolean cedulaEsNumeroValidoEnVista(){
        
        boolean respuesta = false;
        int cantidadDigitoMin = 7; // Cuantos digitos debe tener el numero como minimo para ser aceptado 
        
        try{      
            int numero = Integer.parseInt(vista.getCedula()); // El dato es numerico
            if(numero >= Math.pow(10, cantidadDigitoMin-1)) // El dato es positivo y tiene entre -cantidadDigitoMin- y 10 digitos
                respuesta = true;
            else // El dato es negativo
                JOptionPane.showMessageDialog(null, 
                        "El numero introducido debe: "
                        + "\n* Ser positivo. "
                        + "\n* Tener entre " + cantidadDigitoMin + " y 10 digitos (Los ceros a la izquierda se eliminan)",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, 
                        "El numero introducido debe: "
                        + "\n* Tener entre " + cantidadDigitoMin + " y 10 digitos (Los ceros a la izquierda se eliminan)",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
        }
        return respuesta;
    }
    
    /**
     * Medida de seguridad, verifica si existe otro cliente con este cedula y retroalimenta al usuario
     * @param cedula La cedula del cliente a analizar (int)
     * @return true, este cedula ya esta ocupado por otro cliente; false, el cedula esta libre
     */
    public boolean existeOtroClienteConCedula(int cedula) {
        
        boolean respuesta = false;
        
        if (modelo.existeCedula(cedula) && cedula != selectedId) {
            respuesta = true;
            JOptionPane.showMessageDialog(null, """
                                                Ya existe un cliente con este numero de documento.
                                                                                                
                                                Nota: Los ceros a la izquierda no son tomados en cuenta en la creacion de un ID.""",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        return respuesta;
    }
    
    
    //              LISTENERS               //
    /**
     * Se encarga de registrar un nuevo cliente cuidando la integridad de la 
     * informacion
     */
    ActionListener oyenteRegistrar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
          
            if (cedulaEsNumeroValidoEnVista() && !campoNombreEstaVacio()) {

                int cedula = Integer.parseInt(vista.getCedula());
                selectedId =-1;
                String nombre = vista.getNombre();

                if (!existeOtroClienteConCedula(cedula)) {
                    modelo.registrar(cedula, nombre);

                    JOptionPane.showMessageDialog(null, "Registro exitoso!");
                    recargarTodo();
                }
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
            if (cedulaEsNumeroValidoEnVista() && !campoNombreEstaVacio()) {

                int cedula = Integer.parseInt(vista.getCedula());
                String nombre = vista.getNombre();

                if (!existeOtroClienteConCedula(cedula)) {
                    int eleccion = JOptionPane.showConfirmDialog(null, """    
                                                                   Al modificar este cliente los datos anteriores seran borrados.
                                                               
                                                                   ¿Esta seguro de que desea continuar?""",
                            "Advertencia: Modificacion de cliente",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE);
                    switch (eleccion) {
                        case JOptionPane.YES_OPTION:
                            modelo.modificar(selectedId, cedula, nombre);
                            JOptionPane.showMessageDialog(null, "Modificacion exitosa!");
                            recargarTodo();
                            break;
                    }
                }
            }
        }
    };
    
    /**
     * Se encarga de eliminar clientes del arreglo
     */
    ActionListener oyenteEliminar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int eleccion = JOptionPane.showConfirmDialog(null, """    
                                                                   Esta operacion es irreversible.
                                                               
                                                                   ¿Esta seguro de que desea continuar?""",
                    "Advertencia: Eliminacion de cliente",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            switch (eleccion) {
                case JOptionPane.YES_OPTION:
                    modelo.eliminar(selectedId);
                    JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente.");
                    recargarTodo();
                    break;
            }
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
