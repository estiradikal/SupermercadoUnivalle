
package modelo;

import controlador.*;
import java.util.ArrayList;
import supermercado.*;
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

public class VentanaVenderModelo {
    
    Supermercado supermercado = new Supermercado();
    java.util.List<Cliente> clientes = supermercado.getMisClientes();
    java.util.List<ProductoInventario> misProductos = supermercado.getMisProductos();
    java.util.List<Venta> ventas = supermercado.getMisVentas();
    
    //Constructor
    public VentanaVenderModelo(){  
    }
    
     //              GETTERS CON INDICE              //
    /**
     * Obtiene un nombre del proveedor con informacion relevante id@nombre
     * @param indice La posicion del proveedor en el arreglo (int)
     * @return El nombre del cliente de forma cedula@nombre (String)
     */
    public String getClienteCifrado(int indice){
        String clienteActual = "";
        
        clienteActual += clientes.get(indice).getCedula();
        clienteActual += "@" + clientes.get(indice).getNombre();
        
        return clienteActual;
    }
    
   /**
     * Obtiene el id de un proveedor 
     * @param indice La posicion del proveedor en el arreglo (int)
     * @return La cédula del cliente como numero entero (int)
     */
    public int getCedulaCliente(int indice){
        return clientes.get(indice).getCedula();
    }
    
    /**
     * Obtiene el nombre de un proveedor
     * @param indice La posicion del proveedor en el arreglo (int)
     * @return El nombre del cliente como una cadena de texto (String)
     */
    public String getNombre(int indice){
        return clientes.get(indice).getNombre();
    }
    
    /**
     * Obtiene un nombre del producto con informacion relevante id@nombre
     * @param indice La posicion del producto en el arreglo (int)
     * @return El nombre del producto de forma id@nombre (String)
     */
    public String getProductoCifrado(int indice){
        String productoActual = "";
        
        productoActual += misProductos.get(indice).getId();
        productoActual += "@" + misProductos.get(indice).getNombre();
        
        return productoActual;
    }
    
    
    
    //              GETTERS VENTAS             //
 
    public String getFechaVenta(int indice){
        return ventas.get(indice).getFecha();
    }
    
    public String getNombreVenta(int indice){
        return ventas.get(indice).getCliente();
    }
    
    public String getProductoVenta(int indice){
        return ventas.get(indice).getProducto();
    }
    
    public int getPrecioVenta(int indice){
        return ventas.get(indice).getPrecio();
    }
    
    public int getCantidadVenta(int indice){
        return ventas.get(indice).getCantidad();
    }
    
    public int getTotalVenta(int indice){
        return ventas.get(indice).getTotal();
    }
    
    
    //              GETTERS CON ID              //
    
    public int getPrecioProductoId(int id){
        int precio = 0;
        for(ProductoInventario productoActual: misProductos){
            if(productoActual.getId() == id){
                precio = productoActual.getPrecioDeVenta();
            }
        }
        return precio;
    }
    
    //             GETTERS CANTIDAD DE ELEMENTOS EN ARRAYS              //    
    public int getCantidadClientes(){
        return clientes.size();
    }
    
    public int getCantidadProductos(){
        return misProductos.size();
    }
    
    public int getCantidadVentas(){
        return ventas.size();
    }
    
    
    //              FUNCIONES               //
    
    /**
     * Descifra el id de un producto o proveedor a partir de su nombreCifrado
     * @param nombreCifrado El nombre de forma id@nombre (String)
     * @return id El id del producto o proveedor como un entero (int)
     */
    public int descifrarId(String nombreCifrado){
        String cadenaCompacta = nombreCifrado;
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
    
    /**
     * Descifra el nombre de un producto o proveedor a partir de su nombreCifrado
     * @param nombreCifrado El nombre de forma id@nombre (String)
     * @return nombre El nombre del producto o proveedor como una cadena de texto (String)
     */
    public String descifrarNombre(String nombreCifrado){
        String cadenaCompacta = nombreCifrado;
        String nombre;
        int intermedio = 0;

        for (int i = 0; i < cadenaCompacta.length(); i++) {
            if(cadenaCompacta.charAt(i) == '@'  ){
                intermedio = i;
                break;
            }
        }
        
        nombre = cadenaCompacta.substring(intermedio+1, cadenaCompacta.length());
        
        return nombre;
    }
    
    /**
     * Crea un objeto de tipo compra para el registro de compras
     * @param fecha La fecha de la compra de forma MM/dd/yyyy, HH:mm:ss (String)
     * @param cliente El nombre del cliente (String)
     * @param precio El precio del producto (int)
     * @param producto El nombre del producto (String)
     * @param cantidad La cantidad deproducto  (int)
     * @param total El costo total de la compra (int)
     */
    public void registrarVenta(String fecha, String cliente, int precio, String producto, int cantidad, int total){
        ventas.add(0, new Venta(fecha, cliente, precio, producto, cantidad, total));
        supermercado.setMisVentas(ventas);
    }
    
    /**
     * Calcula el costo total de comprar una cantidad de producto usando su nombreProductoCifrado para identificar el precio
     * @param nombreProductoCifrado El nombre del producto de forma id@nombre (String)
     * @param cantidad La cantidad de producto (int)
     * @return 
     */
    public int calcularTotal(String nombreProductoCifrado, int cantidad){
        
        int id = descifrarId(nombreProductoCifrado);
        int precio = 0;
        
        for(ProductoInventario productoActual: misProductos){
            if(productoActual.getId() == id){
                precio = productoActual.getPrecioDeVenta();
                break;
            }
        }
        int total = precio * cantidad;
        return total;
    }
    
    
    public void iniciarVentanaPrincipal() {
        VentanaPrincipalModelo modelo = new VentanaPrincipalModelo();
        VentanaPrincipalVista vista = new VentanaPrincipalVista();
        VentanaPrincipalControlador controlador = new VentanaPrincipalControlador(modelo, vista);
    }
    
}
