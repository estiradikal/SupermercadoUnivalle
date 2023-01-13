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
 *    Archivo:  VentanaInventarioControlador.java
 *    Licencia: GNU-GPL 
 *    @version  1.2
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import vista.*;

public class VentanaComprarControlador {
    
    protected int selectedId;
    protected int selectedRow;
    
    protected VentanaComprarModelo modelo = new VentanaComprarModelo();
    protected VentanaIComprarVista vista = new VentanaIComprarVista();    
    
    /**
     * Constructor de la clase VentanaInventarioControlador
     * @param modelo El modelo de la ventana (VentanaComprarModelo)
     * @param vista La vista de la ventana (VentanaIComprarVista)
     */
    public VentanaComprarControlador(VentanaComprarModelo modelo, VentanaIComprarVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        
        vista.addActionVolver(oyenteVolver);
        vista.addActionComprar(oyenteComprar);
        vista.addActionEliminar(oyenteEliminar);
        vista.addActionCancelar(oyenteCancelar);
        vista.addActionTable(oyenteFilas);
        
        cargarTabla();
        vista.setGuiaModificar();
        cargarProveedores();
    }
    
    
    //              ELEMENTOS DE LA INTERFAZ               //
    /**
     * Carga los datos del arreglo en el modelo a la tabla
     */
    public void cargarTabla() {
        for (int i = 0; i < modelo.getCantidadProductosInventario(); i++) {
            String id = Integer.toString(modelo.getIdProducto(i));
            String nombre = modelo.getNombreProducto(i);
            String cantidad = Integer.toString(modelo.getCantidadProducto(i));
            String medida = modelo.getMedidaProducto(i);
            vista.nuevaFilaTabla(id, nombre, cantidad, medida);
        }
    }

    /**
     * 
     */
    public void cargarProveedores(){
        vista.eliminarProveedoresCargados();
        for(int i = 0; i < modelo.getCantidadProveedores(); i++) {
            String proveedorCompleto = modelo.getProveedorCompleto(i);
            vista.cargarProveedor(proveedorCompleto);
        }
    }
    
    /**
     * 
     * @param proveedorCompleto
     * @return 
     */
    public int obtenerIdProveedor(String proveedorCompleto){
        String cadenaCompacta = proveedorCompleto;
        int id;
        int intermedio = 0;

        for (int i = 0; i < cadenaCompacta.length(); i++) {
            if(cadenaCompacta.charAt(i) == '@'  ){
                intermedio = i;
                break;
            }
        }
        
        id = Integer.parseInt(cadenaCompacta.substring(0, intermedio));
        
        return id;
    }
    
    public String obtenerNombreProveedor(String proveedorCompleto){
        String cadenaCompacta = proveedorCompleto;
        String id;
        int intermedio = 0;

        for (int i = 0; i < cadenaCompacta.length(); i++) {
            if(cadenaCompacta.charAt(i) == '@'  ){
                intermedio = i;
                break;
            }
        }
        
        id = cadenaCompacta.substring(intermedio+1, cadenaCompacta.length());
        
        return id;
    }
    
    /**
     * 
     * @param proveedorCompleto
     * @return 
     */
    public int obtenerIdProducto(String productoCompleto){
        String cadenaCompacta = productoCompleto;
        int id;
        int intermedio = 0;

        for (int i = 0; i < cadenaCompacta.length(); i++) {
            if(cadenaCompacta.charAt(i) == '@'  ){
                intermedio = i;
                break;
            }
        }
        
        id = Integer.parseInt(cadenaCompacta.substring(0, intermedio));
        
        return id;
    }
    
    public String obtenerNombreProducto(String productoCompleto){
        String cadenaCompacta = productoCompleto;
        String id;
        int intermedio = 0;

        for (int i = 0; i < cadenaCompacta.length(); i++) {
            if(cadenaCompacta.charAt(i) == '@'  ){
                intermedio = i;
                break;
            }
        }
        
        id = cadenaCompacta.substring(intermedio+1, cadenaCompacta.length());
        
        return id;
    }
    
    /**
     * 
     * @param idProveedor 
     */
    public void cargarProductosProveedor(int idProveedor){
        modelo.seleccionarProductos(idProveedor);
        for(int i = 0; i < modelo.getCantidadProductosProveedor(); i++){
            String nombreProducto = modelo.getProductoCompleto(i);
            vista.cargarProducto(nombreProducto);
        }
    }
    
    //              MODOS DE OPERACION               //
    /**
     * Habilita y deshabilita elementos en la interfaz para REGISTRAR NUEVOS
     * CLIENTES
     */
    public void modoRegistrar() {
        vista.setGuiaModificar();
        vista.habilitarProveedores();
        vista.habilitarProductos();
        vista.habilitarCantidad();
        vista.deshabilitarCancelar();
        vista.deshabilitarEliminar();
    }

    /**
     * Habilita y deshabilita elementos en la interfaz para HACER MODIFICACIONES
     * EN CLIENTES EXISTENTES (Modificar datos y eliminar)
     */
    public void modoModificar() {
        vista.setGuiaRegistrar();
        vista.deshabilitarProveedores();
        vista.deshabilitarProductos();
        vista.deshabilitarCantidad();
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
     * Medida de seguridad, verifica si el campo de cedula tiene un numero y retroalimenta al usuario
     * @return true, el campo tiene un numero; false, el campo contiene otros caracteres
     */
    public boolean cantidadEsNumeroValidoEnVista(){
        
        boolean respuesta = false;
        
        try{      
            int numero = Integer.parseInt(vista.getCantidad()); // El dato es numerico
            if(numero > 0) // El dato es positivo 
                respuesta = true;
            else // El dato es negativo
                JOptionPane.showMessageDialog(null, 
                        "La cantidad debe ser mayor a cero",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, 
                        "Debe escribir un numero en el campo de cantidad",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
        }
        return respuesta;
    }
    
    public boolean proveedorTieneProductos(){
        
        boolean respuesta = false;
        
        try{
            vista.getProducto();
            respuesta = true;
        } catch(java.lang.NullPointerException e){
            JOptionPane.showMessageDialog(null, 
                        "Este proveedor no tiene ningun producto en su catalogo",
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
    ActionListener oyenteComprar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
          
            if (proveedorTieneProductos() && cantidadEsNumeroValidoEnVista()) {

                int cedula = Integer.parseInt(vista.getCantidad());
                selectedId =-1;
                int idProducto = obtenerIdProducto(vista.getProducto());
                String nombreProducto = obtenerNombreProducto(vista.getProducto()); 
                
                // DESARROLLADOR
                // Aqui se debe registrar el producto en el inventario

                JOptionPane.showMessageDialog(null, "Registro exitoso!");
                recargarTodo();
                
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
