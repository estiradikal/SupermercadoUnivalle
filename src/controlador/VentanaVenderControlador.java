
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.*;
import vista.*;

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
     //   vista.addActionVender(oyenteVender);
        /*
        vista.addActionRegistrar(oyenteRegistrar);
        vista.addActionModificar(oyenteModificar);
        vista.addActionEliminar(oyenteEliminar);
        vista.addActionCancelar(oyenteCancelar);
        vista.addActionTable(oyenteFilas);
        */
        
        cargarTabla();
        
        vista.setGuiaModificar();
        cargarClientes();
        cargarProductos();
    }
    
    public void cargarClientes(){
        for (int i = 0; i < modelo.getCantidadClientes(); i++) {
            int id=modelo.getIdCliente(i);
            String nombre=modelo.getNombreCliente(i);
            
            String nombreCifrado = id + "@" + nombre;
                    
            vista.nuevoCliente(nombreCifrado);
            
        }
    }
    
    public void cargarProductos(){
        for (int i = 0; i < modelo.getCantidadProductos(); i++) {
            int id=modelo.getIdProducto(i);
            String nombre=modelo.getNombreProducto(i);
            
            String nombreCifrado=id+"@"+nombre;
            vista.nuevoProducto(nombreCifrado);
            
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //              ELEMENTOS DE LA INTERFAZ               //
    /**
     * Carga los datos del arreglo en el modelo a la tabla
     */
    
    public void cargarTabla() {
        for (int i = 0; i < modelo.getCantidadClientes(); i++) {
            String cliente = modelo.addCliente(i);
            /*
            Proveedor copiaProveedor = modelo.getProveedor (i);    
            List<ProductosProveedor> copiaProductos = copiaProveedor.getProductos;
            for (int j = 0; j < copiaProductos.size(); j++) {   
                String nombreProveedor = copiaProveedor.getNombre();
                String idProveedor = String.valueOf(copiaProveedor.getId);
                String nombreProducto = copiaProductos.get(j).getNombre();
                String idProducto = String.valueOf(copiaProductos.get(j).getId());
                vista.nuevaFila(idProveedor, nombreProveedor,idProducto, nombreProducto);
            }
            */
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
    /*
    public void recargarTodo(){
        vista.limpiarTabla();
        modoRegistrar();
        cargarTabla();
    }
    
    /**
     * Instancia una VentanaPrincipal y cierra la actual
     */
    /*
    public void volverAlMenu(){
        vista.cerrar();
        modelo.iniciarVentanaPrincipal();
    }
    
    ActionListener oyenteRegistrar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            modelo.registrar(proveedor);
        }
        
    };
    */
    
    /**
     * Instancia una VentanaPrincipal y cierra la actual
     */
    public void volverAlMenu(){
        vista.cerrar();
        modelo.iniciarVentanaPrincipal();
    }
    
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
