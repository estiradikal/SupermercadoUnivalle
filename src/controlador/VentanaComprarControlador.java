package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.*;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01
 *    Elboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaInventarioControlador.java
 *    Licencia: GNU-GPL 
 *    @version  1.4
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import vista.*;

public class VentanaComprarControlador {
    /**
     * Declaración de variable.
     */
    protected int selectedId;
    /**
     * Instancias de clase
     */
    protected VentanaComprarModelo modelo = new VentanaComprarModelo();
    protected VentanaComprarVista vista = new VentanaComprarVista();    
    
    /**
     * Constructor de la clase VentanaInventarioControlador
     * @param modelo El modelo de la ventana (VentanaComprarModelo)
     * @param vista La vista de la ventana (VentanaComprarVista)
     */
    public VentanaComprarControlador(VentanaComprarModelo modelo, VentanaComprarVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        
        vista.addActionRegistrarCompra(oyenteRegistrar);
        vista.addProveedorListener(oyenteProveedor);
        vista.addProductosListener(oyenteProductos);
        vista.addActionVolver(oyenteVolver);
        vista.addActionRegistrarCompra(oyenteRegistrar);
        vista.addCantidadListener(eliminarCantidad);
        vista.addCantidadListener(calculadoraDeTotales);
        
        vista.configurarTabla();
        cargarTabla();
        cargarProveedores();
    }
    
    
    //              ELEMENTOS DE LA INTERFAZ               //
    /**
     * Carga los datos del arreglo en el modelo a la tabla
     */
    public void cargarTabla() {
        for (int i = 0; i < modelo.getCantidadCompras(); i++) {
            String fecha = modelo.getFechaCompra(i);
            String producto = modelo.getProductoCompra(i);
            String precio = Integer.toString(modelo.getPrecioCompra(i));
            String cantidad = Integer.toString(modelo.getCantidadCompra(i));
            String total = Integer.toString(modelo.getTotalCompra(i));
            vista.nuevaFilaTabla(fecha, producto, precio, cantidad, total);
        }
    }

    /**
     * Carga todos los proveedores a la vista 
     */
    public void cargarProveedores(){
        vista.eliminarProveedoresCargados();
        for(int i = 0; i < modelo.getCantidadProveedores(); i++) {
            String proveedorCompleto = modelo.getProveedorCifrado(i);
            vista.cargarProveedor(proveedorCompleto);
        }
    }    
    
    /**
     * Carga todos los productos que ofrece un proveedor en especifico a la vista
     * @param idProveedor El id del proveedor como numero entero (int)
     */
    public void cargarProductosProveedor(int idProveedor){
        modelo.seleccionarProductos(idProveedor);
        for(int i = 0; i < modelo.getCantidadProductosProveedor(); i++){
            String nombreProducto = modelo.getProductoCifrado(i);
            vista.cargarProducto(nombreProducto);
        }
    }
    
    /**
     * Recarga algunos elementos y datos de la vista
     */
    public void recargarTodo(){
        vista.limpiarCampos();
        vista.limpiarTabla();
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
     * Verifica si ya hay un producto seleccionado en la vista para empezar a usarlo
     * @return false
     */
    public boolean productoEstaSeleccionado(){
        
        boolean respuesta = false;
        
        try {
            vista.getProducto();
            respuesta = true;
        } catch (NullPointerException e) {
            // Aun no se ha seleccionado ningun producto
        }
        return respuesta;
    }
    
    /**
     * Verifica si el campo de cantidad esta vacio pero no muestra ningun mensaje
     * @return true, el campo esta vacio; false, el campo contiene otros caracteres
     */
    public boolean campoCantidadEstaVacio(){
        boolean respuesta = true;
        if(vista.getCantidad().isEmpty())
            respuesta = false;
        
        return respuesta;
    }
    
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
                vista.setCantidad("");
        }
        return respuesta;
    }
    
    /**
     * Verifica si el proveedor actual tiene productos para usarlos
     * @return 
     */
    public boolean proveedorTieneProductos(boolean retroalimentar){
        
        boolean respuesta = false;
        
        try{
            vista.getProducto();
            respuesta = true;
        } catch(java.lang.NullPointerException e){
            if(retroalimentar)
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
    ActionListener oyenteRegistrar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
          
            if (proveedorTieneProductos(true) && cantidadEsNumeroValidoEnVista()) {

                LocalDateTime fechaActual = LocalDateTime.now();
                DateTimeFormatter formatoPresentacion = DateTimeFormatter.ofPattern("MM/dd/yyyy, HH:mm:ss");                
                String fecha = formatoPresentacion.format(fechaActual);
                
                String nombreProductoCifrado = vista.getProducto(); // Obtiene el nombre completo del producto
                
                String producto  = modelo.descifrarNombre(nombreProductoCifrado);
                int id = modelo.descifrarId(nombreProductoCifrado);
                int precio = modelo.getPrecioProductoId(id);
                int cantidad = Integer.parseInt(vista.getCantidad());
                int total = modelo.calcularTotal(nombreProductoCifrado, cantidad);
                
                modelo.registrarCompra(fecha, producto, precio, cantidad, total);
                modelo.addProductosAlInventario(nombreProductoCifrado, cantidad, precio);

                JOptionPane.showMessageDialog(null, "Registro exitoso!");
                recargarTodo();
            }
        }
    };
    
    /**
     * Carga solo los productos que pertenecen al proveedor elegido
     */
    ActionListener oyenteProveedor = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                vista.eliminarProductosCargados();  
                
                JComboBox box = (JComboBox) evt.getSource();
                String proveedorSeleccionado = box.getSelectedItem().toString(); 
                
                selectedId = modelo.descifrarId(proveedorSeleccionado);
                
                cargarProductosProveedor(selectedId);
                
            } catch(NullPointerException e) {
                //  Este proveedor aun no tiene productos para ofrecer
            }
        } 
    };
    
    /**
     * Carga solo los productos que pertenecen al proveedor elegido
     */
    ActionListener oyenteProductos = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                vista.setCantidad("");
                vista.setCosto("0");
            } catch(NullPointerException e) {
                //  Este proveedor aun no tiene productos para ofrecer
            }
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
     * Elimina el contenido del campo de cantidad en la vista
     */
    MouseListener eliminarCantidad = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            vista.setCantidad("");
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
     * Calcula el costo total de la compra dinamicamente
     */
    KeyListener calculadoraDeTotales = new KeyListener(){
        @Override
        public void keyTyped(KeyEvent evt) { 
            
            int tecla = evt.getKeyChar();
            char caracter = evt.getKeyChar();
            boolean esNumero = tecla == 8 || tecla >= 48 && tecla <= 57;
            boolean esBackspace = caracter == 8;
            boolean campoCantidadEstaVacio = false;
            boolean campoCantidadEstaLleno = vista.getCantidad().length() == 4;
            
            
            
            // Configurar valor de campo vacio
            if (esBackspace) {
                campoCantidadEstaVacio = vista.getCantidad().length() == 0;   
            }
            
            // Verificacion de tecla presionada
            if(!esNumero || campoCantidadEstaLleno)
                evt.consume();
                        
            try {
                String nombreProductoCifrado = vista.getProducto();
                String cantidadActualizada = "";

                if(campoCantidadEstaVacio){
                    cantidadActualizada = "0";
                }
                else if (esBackspace) {
                    cantidadActualizada = vista.getCantidad().substring(0, vista.getCantidad().length());
                } else if (esNumero && vista.getCantidad().length() != 4) {
                    cantidadActualizada = vista.getCantidad() + caracter;
                }

                int cantidad = Integer.parseInt(cantidadActualizada);
                String total = Integer.toString(modelo.calcularTotal(nombreProductoCifrado, cantidad));
                vista.setCosto(total);

            } catch (NumberFormatException e) {
            } catch (NullPointerException e) {
            }
        }

        /**
         * Validaciones de teclado
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
