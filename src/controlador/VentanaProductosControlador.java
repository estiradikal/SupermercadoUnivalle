package controlador;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ConcurrentModificationException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.*;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01
 *    Elboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaProductosControlador.java
 *    Licencia: GNU-GPL 
 *    @version  1.3
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import vista.*;

public class VentanaProductosControlador {
    /**
     * Declaración de variable
     */
    int selectedId;
    int selectedRow;
    /**
     * Instancias de clase
     */
    protected VentanaProductosModelo modelo = new VentanaProductosModelo();
    protected VentanaProductosVista vista = new VentanaProductosVista();
    /**
     * Constructor de la clase VentanaProductosControlador
     * @param modelo. El constructor recibe parametro de la clase VentanaProductosModelo
     * @param vista. El constructor recibe parametro de la clase VentanaProductosVista
     */
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
        vista.addActionCancelar(oyenteCancelar);
        vista.addActionTable(oyenteFilas);
        vista.addActionId(keyguardId);
        
        cargarTabla();
        vista.setGuiaModificar();
    }
    
    
    //              ELEMENTOS DE LA INTERFAZ               //
    /**
     * Carga los datos del arreglo en el modelo a el tabla
     */
    public void cargarTabla() {
        for (int i = 0; i < modelo.getCantidadProductos(); i++) {
            int id = modelo.getId(i);
            String nombre = modelo.getNombre(i);
            int precio = modelo.getPrecio(i);
            String medida = modelo.getMedida(i);
            vista.nuevaFila(id, nombre, precio, medida);
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
    public boolean idEsNumeroValidoEnVista(){
        
        boolean respuesta = false;
        int cantidadDigitoMin = 1; // Cuantos digitos debe tener el numero como minimo para ser aceptado 
        
        try{      
            int numero = Integer.parseInt(vista.getId()); // El dato es numerico
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
     * Medida de seguridad, verifica si el campo de precio tiene un numero y retroalimenta al usuario
     * @return true, el campo tiene un numero; false, el campo contiene otros caracteres
     */
    public boolean precioEsNumericoEnVista(){
        boolean respuesta = false;
        
        try{
            Integer.parseInt(vista.getPrecio());
            respuesta = true;
        } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Error: Debe escribir un numero en el campo de precio",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
        }
        return respuesta;
    }
    
    /**
     * Medida de seguridad, verifica si existe otro producto con este id y retroalimenta al usuario
     * @param id El id del producto a analizar (int)
     * @return true, este id ya esta ocupado por otro producto; false, el id esta libre
     */
    public boolean existeOtroProductoConEsteId(int id) {
        
        boolean respuesta = false;
        
        if (modelo.existeId(id) && id != selectedId) {
            respuesta = true;
            JOptionPane.showMessageDialog(null, """
                                                Ya existe un producto con este ID.
                                                
                                                Nota: Los ceros a la izquierda no son tomados en cuenta en la creacion de un ID.""",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        return respuesta;
    }
    
    
    //              FUNCIONES               //
    /**
     * Modifica el producto con el id seleccionado
     * @param id El nuevo id (int)
     * @param nombre El nuevo nombre (String)
     * @param precio El nuevo precio (int)
     * @param medida La nueva medida kg/unid (String)
     */
    public void modificarProducto(int id, String nombre, int precio, String medida){
        modelo.modificar(selectedId, id, nombre, precio, medida);
        modelo.eliminarProductoDeProveedores(selectedId);
        JOptionPane.showMessageDialog(null, "Modificacion exitosa!");
        recargarTodo();
    }
    
    /**
     * Elimina el producto con el id seleccionado
     */
    public void eliminarProducto() {
        modelo.eliminar(selectedId);
        modelo.eliminarProductoDeProveedores(selectedId);
        JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
        recargarTodo();
    }
    
    
    //              LISTENERS               //
    /**
     * Se encarga de registrar un nuevo producto cuidando la integridad de el 
     * informacion
     */
    ActionListener oyenteRegistrar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
        
            if (idEsNumeroValidoEnVista() && !campoNombreEstaVacio() && precioEsNumericoEnVista()) {

                int id = Integer.parseInt(vista.getId());
                selectedId = -1;
                String nombre = vista.getNombre();
                int precio = Integer.parseInt(vista.getPrecio());
                String medida = vista.getMedida();

                if (!existeOtroProductoConEsteId(id)) {

                    modelo.registrar(id, nombre, precio, medida);

                    JOptionPane.showMessageDialog(null, "Registro exitoso!");
                    recargarTodo();
                }
            }
        }
    };
    
    /**
     * Se encarga de modificar un nuevo producto cuidando la integridad de el 
     * informacion
     */
    ActionListener oyenteModificar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {

            if (idEsNumeroValidoEnVista() && !campoNombreEstaVacio() && precioEsNumericoEnVista()) {

                int id = Integer.parseInt(vista.getId());
                String nombre = vista.getNombre();
                int precio = Integer.parseInt(vista.getPrecio());
                String medida = vista.getMedida();
                
                             if (!existeOtroProductoConEsteId(id)) {

                    int eleccion = JOptionPane.showConfirmDialog(null, """    
                                                                   Por motivos de seguridad, al modificar este producto:
                                                                   
                                                                   - Se desasignará de los proveedores que lo ofrezcan.
                                                                   
                                                                   ¿Desea continuar con la operación?""",
                            "Advertencia: Modificacion de producto",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE);
                    switch (eleccion) {
                        case JOptionPane.YES_OPTION:
                        try {
                            modificarProducto(id, nombre, precio, medida);
                        } catch (ConcurrentModificationException e) {
                            modificarProducto(id, nombre, precio, medida);
                        }
                        break;
                    }
                }

            }
        }
    };
    
    /**
     * Se encarga de eliminar productos del arreglo
     */
    ActionListener oyenteEliminar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try{
                int eleccion = JOptionPane.showConfirmDialog(null, """    
                                                                   Por motivos de seguridad, al eliminar este producto:
                                                                   
                                                                   - Se desasignará de los proveedores que lo ofrezcan.
                                                                   
                                                                   ¿Desea continuar con la operación?""",
                "Advertencia: Eliminacion de producto",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        switch (eleccion) {
            case JOptionPane.YES_OPTION:
                eliminarProducto();
                break;
        }
            } catch(ConcurrentModificationException e){
                eliminarProducto();
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
                vista.setPrecio(table.getValueAt(table.getSelectedRow(), 2).toString());
                vista.setMedida(table.getValueAt(table.getSelectedRow(), 3).toString());
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
    
    /**
     * Establece las limitaciones de un campo de cedula o id
     */
    KeyListener keyguardId = new KeyListener(){
        @Override
        public void keyTyped(KeyEvent evt) { 
            String copiaCampo = vista.getId();
            
            // OBTENCION DE TECLA
            int tecla = evt.getKeyChar();
            char caracter = evt.getKeyChar();
            
            // TECLAS PERMITIDAS //
            int backspace = 8;            
            // Teclas permitidas + numeros
            boolean esTeclaPermitida = tecla == backspace || tecla >= 48 && tecla <= 57;
            
            // ANCHO DEL CAMPO  //
            int anchoDeCampo = 10;
            boolean campoCantidadEstaLleno = copiaCampo.length() == anchoDeCampo;
     
            // ELIMINAR CEROS A LA IZQUIERDA //
            boolean campoEstaVacio = copiaCampo.length() == 0;
            if (campoEstaVacio && caracter == '0') {
                evt.consume();
            }

            //  CONSUMIR EVENTOS INDESEADOS //
            if(!esTeclaPermitida || campoCantidadEstaLleno)
                evt.consume();
        }
        /**
         * Acciones del teclado
         */
        @Override
        public void keyPressed(KeyEvent evt) {
        }

        @Override
        public void keyReleased(KeyEvent evt) { 
        }
    };
}
