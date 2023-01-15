package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import modelo.*;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01
 *    Elboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaInventarioControlador.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import vista.*;

public class VentanaInventarioControlador {
    
    protected int selectedId;
    
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
        
        vista.addActionRegistrarCompra(oyenteRegistrar);
        vista.addActionVolver(oyenteVolver);
        vista.addActionRegistrarCompra(oyenteRegistrar);
        vista.addCantidadListener(calculadoraDeTotales);
        
        vista.configurarTabla();
        cargarTabla();
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
    public void modoVisualizar(){
        vista.deshabilitarPorcentaje();
        vista.deshabilitarModificar();
        vista.deshabilitarEliminar();
        vista.deshabilitarCancelar();  
    }
    
    public void modoModificar(){
        vista.habilitarPorcentaje();
        vista.habilitarModificar();
        vista.habilitarEliminar();
        vista.habilitarCancelar();  
    }
    
    
    //              MEDIDAS DE SEGURIDAD                //
        
    
    //              LISTENERS               //
    /**
     * Se encarga de registrar un nuevo cliente cuidando la integridad de la 
     * informacion
     */
    ActionListener oyenteRegistrar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
          
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
     * Establece las limitaciones del campo de porcentaje
     */
    KeyListener calculadoraDeTotales = new KeyListener(){
        @Override
        public void keyTyped(KeyEvent evt) { 
            
            int tecla = evt.getKeyChar();
            System.out.println("Tecla: " + tecla);
            char caracter = evt.getKeyChar();
            boolean esTeclaPermitida = tecla == 8 || tecla >= 48 && tecla <= 57;
            boolean campoCantidadEstaVacio = false;
            boolean campoCantidadEstaLleno = vista.getCantidad().length() == 6;
            
            // Verificacion de tecla presionada
            if(!esTeclaPermitida || campoCantidadEstaLleno)
                evt.consume();
        }

        @Override
        public void keyPressed(KeyEvent evt) {
        }

        @Override
        public void keyReleased(KeyEvent evt) { 
        }
    };
}
