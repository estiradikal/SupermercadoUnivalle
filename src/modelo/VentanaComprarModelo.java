package modelo;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaInventarioModelo.java
 *    Licencia: GNU-GPL 
 *    @version  1.2
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import controlador.VentanaPrincipalControlador;
import java.util.ArrayList;
import supermercado.*;
import vista.VentanaPrincipalVista;

public class VentanaComprarModelo {
    
    Supermercado supermercado = new Supermercado();
    java.util.List<Compra> comprasRegistradas = supermercado.getMisCompras();
    java.util.List<Proveedor> proveedores = supermercado.getMisProveedores();
    java.util.List<ProductoProveedor> productosProveedor = new ArrayList<>();
    java.util.List<ProductoInventario> productosInventario = new ArrayList<>();
    
    
    public VentanaComprarModelo(){
    }
    
    
    //              GETTERS CON INDICE              //
    /**
     * Obtiene un nombre del proveedor con informacion relevante id@nombre
     * @param indice La posicion del proveedor en el arreglo (int)
     * @return El nombre del proveedor de forma id@nombre (String)
     */
    public String getProveedorCifrado(int indice){
        String proveedorActual = "";
        
        proveedorActual += proveedores.get(indice).getId();
        proveedorActual += "@" + proveedores.get(indice).getNombre();
        
        return proveedorActual;
    }
    
    /**
     * Obtiene el id de un proveedor 
     * @param indice La posicion del proveedor en el arreglo (int)
     * @return El id del proveedor como numero entero (int)
     */
    public int getIdProveedor(int indice){
        return proveedores.get(indice).getId();
    }
    
    /**
     * Obtiene el nombre de un proveedor
     * @param indice La posicion del proveedor en el arreglo (int)
     * @return El nombre del proveedor como una cadena de texto (String)
     */
    public String getNombreProveedor(int indice){
        return proveedores.get(indice).getNombre();
    }
    
    /**
     * Obtiene un nombre del producto con informacion relevante id@nombre
     * @param indice La posicion del producto en el arreglo (int)
     * @return El nombre del producto de forma id@nombre (String)
     */
    public String getProductoCifrado(int indice){
        String productoActual = "";
        
        productoActual += proveedores.get(indice).getId();
        productoActual += "@" + proveedores.get(indice).getNombre();
        
        return productoActual;
    }
    
    
    //              GETTERS COMPRAS             //
    public String getFechaCompra(int indice){
        return comprasRegistradas.get(indice).getFecha();
    }
    
    public String getProductoCompra(int indice){
        return comprasRegistradas.get(indice).getProducto();
    }
    
    public int getPrecioCompra(int indice){
        return comprasRegistradas.get(indice).getPrecio();
    }
    
    public int getCantidadCompra(int indice){
        return comprasRegistradas.get(indice).getCantidad();
    }
    
    public int getTotalCompra(int indice){
        return comprasRegistradas.get(indice).getTotal();
    }
    
    
    //              GETTERS CON ID              //
    public int getPrecioProductoId(int id){
        int precio = 0;
        for(ProductoProveedor productoActual: productosProveedor){
            if(productoActual.getId() == id){
                precio = productoActual.getPrecio();
            }
        }
        return precio;
    }
    
    
    //             GETTERS CANTIDAD DE ELEMENTOS EN ARRAYS              //    
    public int getCantidadCompras(){
        return comprasRegistradas.size();
    }
    
    public int getCantidadProductosProveedor(){
        return productosProveedor.size();
    }
    
    public int getCantidadProveedores(){
        return proveedores.size();
    }
    
    public void seleccionarProductos(int idProveedor){
        for(Proveedor proveedorActual: proveedores){
            if(proveedorActual.getId() == idProveedor){
                productosProveedor = proveedorActual.getMisProductos();
            }
        }
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
     * @param producto El nombre del producto (String)
     * @param precio El precio del producto (int)
     * @param cantidad La cantidad deproducto  (int)
     * @param total El costo total de la compra (int)
     */
    public void registrarCompra(String fecha, String producto, int precio, int cantidad, int total){
        comprasRegistradas.add(new Compra(fecha, producto, precio, cantidad, total));
        supermercado.setMisCompras(comprasRegistradas);
    }
    
    /**
     * Carga un producto al inventario haciendo la traduccion de Produc
     * @param nombreCifrado El nombre del producto de forma id@nombre (String)
     * @param cantidadNueva La cantidad a agregar (int)
     */
    public void addProductosAlInventario(String nombreCifrado, int cantidadNueva){
        
        boolean modificadoEnInventario = false;
        
        int id = descifrarId(nombreCifrado);
        String nombre = descifrarNombre(nombreCifrado);
        
        // Busca si el producto existe en el inventario para solo modificar su cantidad
        for(ProductoInventario productoActual: productosInventario){
            
            /**
             * // DESARROLLADOR //
             * if(productoActual.getId() == id productoActual.getNombre() == nombre()){
             * Formato de if más seguro pero deberia ser implementado correctamente
             */
            if(productoActual.getId() == id){
                int cantidadAnterior = productoActual.getCantidad();
                productoActual.setCantidad(cantidadAnterior + cantidadNueva);
                modificadoEnInventario = true;
                break;
            }
        }
        
        // Si el producto no existe en el inventario, lo crea de cero y le asigna la cantidad
        if(!modificadoEnInventario){
            
            int precio = -1;
            String medida = "Undefined";
            
            for(ProductoProveedor productoActual: productosProveedor){ // Busca los atributos originales
                if(productoActual.getId() == id){
                    precio = productoActual.getPrecio();
                    medida = productoActual.getMedida();
                }
            }
            productosInventario.add(new ProductoInventario(cantidadNueva, id, nombre, precio, medida));
        }
        supermercado.setMisProductos(productosInventario);
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
        
        for(ProductoProveedor productoActual: productosProveedor){
            if(productoActual.getId() == id){
                precio = productoActual.getPrecio();
                break;
            }
        }
        int total = precio * cantidad;
        return total;
        
    }
    
    /**
     * Instancia una nueva VentanaPrincipal
     */
    public void iniciarVentanaPrincipal() {
        VentanaPrincipalModelo modelo = new VentanaPrincipalModelo();
        VentanaPrincipalVista vista = new VentanaPrincipalVista();
        VentanaPrincipalControlador controlador = new VentanaPrincipalControlador(modelo, vista);
    }
}

