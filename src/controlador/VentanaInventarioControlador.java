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
 *    Archivo:  VentanaInventarioControlador.java
 *    Licencia: GNU-GPL 
 *    @version  1.1
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import vista.*;

public class VentanaInventarioControlador {
    /**
     * Declaración de variables
     */
    protected int selectedId;
    protected int selectedRow;
    /**
     * Instancias de clase
     */
    protected VentanaInventarioModelo modelo = new VentanaInventarioModelo();
    protected VentanaInventarioVista vista = new VentanaInventarioVista();    
    
    /**
     * Constructor de la clase VentanaInventarioControlador
     * @param modelo El modelo de la ventana (VentanaInventarioModelo)
     * @param vista La vista de la ventana (VentanaInventarioVista)
     */
    public VentanaInventarioControlador(VentanaInventarioModelo modelo, VentanaInventarioVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        
        vista.addActionModificar(oyenteModificar);
        vista.addActionEliminar(oyenteEliminar);
        vista.addActionCancelar(oyenteCancelar);
        vista.addActionVolver(oyenteVolver);
        vista.addActionTable(oyenteFilas);
        vista.addPorcentajeListener(mouseGuardPorcentaje);
        vista.addPorcentajeListener(keyGuardPorcentaje);
        
        vista.configurarTabla();
        recargarTodo();
    }
    
    
    //              ELEMENTOS DE LA INTERFAZ               //
    /**
     * Carga los datos del arreglo en el modelo a la tabla
     */
    public void cargarTabla() {
        
        for (int i = 0; i < modelo.getCantidadProductos(); i++) {
            String id = Integer.toString(modelo.getId(i));
            String nombre = modelo.getNombre(i);
            String cantidad = Integer.toString(modelo.getCantidad(i));
            String medida = modelo.getMedida(i);
            String precioDeCompra = Integer.toString(modelo.getPrecioDeCompra(i));
            String precioDeVenta= Integer.toString(modelo.getPrecioDeVenta(i));
            String ganancia = Double.toString(modelo.getGanancia(i));
            vista.nuevaFilaTabla(id, nombre, cantidad, medida, precioDeCompra, precioDeVenta, ganancia);
        }
        
    }

    /**
     * Recarga algunos elementos y datos de la vista
     */
    public void recargarTodo(){
        vista.limpiarTabla();
        vista.limpiarCampos();
        cargarTabla();
        modoVisualizar();
    }
    
    /**
     * Instancia una VentanaPrincipal y cierra la actual
     */
    public void volverAlMenu(){
        vista.cerrar();
        modelo.iniciarVentanaPrincipal();
    }
    
    
    //              MODOS DE OPERACION              //
    /**
     * Habilita o deshabilita elementos en la pantalla para permitir solo la visualizacion
     */
    public void modoVisualizar(){
        vista.setGuiaModificar();
        vista.deshabilitarPorcentaje();
        vista.deshabilitarModificar();
        vista.deshabilitarEliminar();
        vista.deshabilitarCancelar();  
    }
    
    /**
     * * Habilita o deshabilita elementos en la pantalla para permitir la alteracion del inventario
     */
    public void modoModificar(){
        vista.setGuiaVisualizar();
        vista.habilitarPorcentaje();
        vista.habilitarModificar();
        vista.habilitarEliminar();
        vista.habilitarCancelar();  
    }
    
    
    //              FUNCIONES               //
    /**
     * Elimina el producto con el id seleccionado
     */
    public void eliminarProductoActual(){
        modelo.eliminar(selectedId);
        recargarTodo();
    }
        
    
    //              LISTENERS               //
    /**
     * Se encarga de registrar un nuevo cliente cuidando la integridad de la 
     * informacion
     */
    ActionListener oyenteModificar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try{
                double ganancia = Double.parseDouble(vista.getPorcentaje());
                modelo.modificarPrecioDeVenta(selectedId, ganancia);
                recargarTodo();
                JOptionPane.showMessageDialog(null, "Operacion realizada con exito.");
            } catch (NumberFormatException e){
                
            }
            
        }
    };
    
    /**
     * Se encarga de registrar un nuevo cliente cuidando la integridad de la 
     * informacion
     */
    ActionListener oyenteEliminar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                int eleccion = JOptionPane.showConfirmDialog(null, """    
                                                                   Se perdera todo este producto en su inventario.
                                                                   
                                                                   ¿Desea continuar con la operación?""",
                        "Advertencia: Eliminacion de producto",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                switch (eleccion) {
                    case JOptionPane.YES_OPTION:
                        eliminarProductoActual();
                        break;
                }
            } catch (ConcurrentModificationException e) {
                eliminarProductoActual();
            }
        }
    };
    
    /**
     * Recarga todo sin efectuar cambios
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
    
    /**
     * Elimina el contenido del campo de cantidad en la vista
     */
    MouseListener mouseGuardPorcentaje = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            vista.setPorcentaje("");
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
     * Establece las limitaciones del campo de porcentaje
     */
    KeyListener keyGuardPorcentaje = new KeyListener(){
        @Override
        public void keyTyped(KeyEvent evt) { 
            
            // OBTENCION DE TECLA
            int tecla = evt.getKeyChar();
            char caracter = evt.getKeyChar();
            
            // TECLAS PERMITIDAS //
            int punto = 46;
            int backspace = 8;            
            // Teclas permitidas + numeros
            boolean esTeclaPermitida = tecla == punto || tecla == backspace || tecla >= 48 && tecla <= 57;
            
            // ANCHO DEL CAMPO  //
            int anchoDeCampo = 6;
            boolean campoCantidadEstaLleno = vista.getPorcentaje().length() == anchoDeCampo;
            
            // EXISTENCIA DE UN UNICO PUNTO //
            boolean hayPunto = false;  
            int posicionDelPunto = 0;
            String copiaCampo = vista.getPorcentaje();            
            for(int i = 0; i < copiaCampo.length(); i++){
                if(copiaCampo.charAt(i) == '.'){
                    posicionDelPunto = i;
                    hayPunto = true;
                    break;
                }
            }
            // SOLO DOS DECIMALES //
            boolean hayDosDecimales = false;
            if(hayPunto){
                String decimales;
                decimales = copiaCampo.substring(posicionDelPunto+1, copiaCampo.length());
                System.out.println("Decimales: " + decimales);
                if(decimales.length() >= 2)
                    hayDosDecimales = true;
            }
            
            // SOLO TRES ENTEROS //
            boolean hayTresEnteros = false;
            if(!hayPunto && vista.getPorcentaje().length() >= 3){
                hayTresEnteros = true;                
            }
            
            //  CONSUMIR EVENTOS INDESEADOS //
            if(!esTeclaPermitida || campoCantidadEstaLleno || hayDosDecimales)
                evt.consume();
            if(hayPunto && caracter == '.')
                evt.consume();
            if(hayTresEnteros && !hayPunto && caracter != '.')
                evt.consume();
        }

        /**
         * Valida opciones del teclado
         */
        @Override
        public void keyPressed(KeyEvent evt) {
            boolean flechaPresionada = evt.getExtendedKeyCode()== KeyEvent.VK_LEFT;
            
            if(flechaPresionada){
                evt.consume();
            }
        }

        @Override
        public void keyReleased(KeyEvent evt) { 
        }
    };
}
