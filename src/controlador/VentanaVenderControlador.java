
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;
import supermercado.*;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01
 *    Laboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaProductosVista.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

public class VentanaVenderControlador {
    
    protected int selectedId;
    protected int selectedRow;
    
    protected VentanaVenderModelo modelo = new VentanaVenderModelo();
    protected VentanaVenderVista vista = new VentanaVenderVista(); 
    
    public VentanaVenderControlador(VentanaVenderModelo modelo, VentanaVenderVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        
        vista.addActionVolver(oyenteVolver);
        vista.addActionVender(oyenteVender);
        vista.addProductosListener(oyenteProductos);
        vista.addCantidadListener(eliminarCantidad);
        vista.addTotalesListener(calculadoraDeTotales);
        
        //cargarTabla();
        cargarClientes();
        cargarProductos();
    }
    
    //              ELEMENTOS DE LA INTERFAZ               //
    /**
     * Carga los datos del arreglo en el modelo a la tabla
     */
    
    public void cargarTabla() {
        for (int i = 0; i < modelo.getCantidadVentas(); i++) {
            String fecha = modelo.getFechaVenta(i);
            String nombre = modelo.getNombreVenta(i);
            String producto = modelo.getProductoVenta(i);
            String precio = Integer.toString(modelo.getPrecioVenta(i));
            String cantidad = Integer.toString(modelo.getCantidadVenta(i));
            String total = Integer.toString(modelo.getTotalVenta(i));
            vista.nuevaFilaTabla(fecha, nombre, producto, precio, cantidad, total);
        }
    }
    
    public void cargarClientes(){
        vista.eliminarClientesCargados();
        for (int i = 0; i < modelo.getCantidadClientes(); i++) {
            String clienteCompleto = modelo.getClienteCifrado(i);
               
            vista.nuevoCliente(clienteCompleto);
            
        }
    }
    
    public void cargarProductos(){
        vista.eliminarProductosCargados();
        for (int i = 0; i < modelo.getCantidadProductos(); i++) {
            String productoCompleto = modelo.getProductoCifrado(i);
            
            vista.nuevoProducto(productoCompleto);
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
    
    //              LISTENERS               //
    
    ActionListener oyenteVender = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
          
            if (cantidadEsNumeroValidoEnVista()) {

                LocalDateTime fechaActual = LocalDateTime.now();
                DateTimeFormatter formatoPresentacion = DateTimeFormatter.ofPattern("MMM/dd/yyyy, HH:mm:ss");                
                String fecha = formatoPresentacion.format(fechaActual);
                
                String nombreClienteCifrado = vista.getCliente();
                String nombreProductoCifrado = vista.getProducto(); // Obtiene el nombre completo del producto
                
                String cliente = modelo.descifrarNombre(nombreClienteCifrado);
                String producto  = modelo.descifrarNombre(nombreProductoCifrado);
                int id = modelo.descifrarId(nombreProductoCifrado);
                int precio = modelo.getPrecioProductoId(id);
                int cantidad = Integer.parseInt(vista.getCantidad());
                int total = modelo.calcularTotal(nombreProductoCifrado, cantidad);
                
                modelo.registrarVenta(fecha, cliente, precio, producto, cantidad, total);

                JOptionPane.showMessageDialog(null, "Registro exitoso!");
                recargarTodo();
            }
        }
    };
    
    ActionListener oyenteProductos = new ActionListener(){
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
