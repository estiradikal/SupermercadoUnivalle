package modelo;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaProductosProveedoresModelo.java
 *    Licencia: GNU-GPL 
 *    @version  1.2
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import vista.*;
import controlador.*;
import supermercado.*;

public class VentanaProductosProveedoresModelo {
    
    Supermercado supermercado = new Supermercado();    
    java.util.List<Proveedor> proveedores = supermercado.getMisProveedores();
    java.util.List<ProductoProveedor> productosProveedorActual;
    java.util.List<ProductoProveedor> productosEnElMercado = supermercado.getProductosEnElMercado();
    
    /**
     * Constructor de la clase VentanaProductosModelo
     */
    public VentanaProductosProveedoresModelo(){
    }
    
    
    //              GETTERS CON INDICE              //
    // Proveedores
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
    
    // Productos del mercado
    /**
     * Obtiene un nombre del producto con informacion relevante id@nombre
     * @param indice La posicion del producto en el arreglo (int)
     * @return El nombre del producto de forma id@nombre (String)
     */
    public String getProductoCifrado(int indice){
        String productoActual = "";
        
        productoActual += productosEnElMercado.get(indice).getId();
        productoActual += "@" + productosEnElMercado.get(indice).getNombre();
        
        return productoActual;
    }
    
    public String getNombreProductoMercado(int indice){
        return productosEnElMercado.get(indice).getNombre();
    }
    
    public int getIdProductoMercado(int indice){
        return productosEnElMercado.get(indice).getId();
    }
    
    // Productos del proveedor seleccionado
    public String getNombreProductoProveedor(int indice){
        return productosProveedorActual.get(indice).getNombre();
    }
    
    public int getIdProductoProveedor(int indice){
        return productosProveedorActual.get(indice).getId();
    }
    
    
    //              FUNCIONES ARRAYS                //
    public int getCantidadProveedores(){
        return proveedores.size();
    }
    
    public int getCantidadProductosEnElMercado(){
        return productosEnElMercado.size();
    }
    
    public int getCantidadProductosProveedor(){
        return productosProveedorActual.size();
    }
    
    public void seleccionarProductos(int idProveedor){
        for(Proveedor proveedorActual: proveedores){
            if(proveedorActual.getId() ==idProveedor){
                productosProveedorActual = proveedorActual.getMisProductos();
            }
        }
    }
    
    
    //              FUNCIONES               //
    public void asignarProductoAProveedor(String nombreProductoCifrado, String nombreProveedorCifrado){
        
        // Se recupera el id del producto y del proveedor
        int idProducto = descifrarId(nombreProductoCifrado);
        int idProveedor = descifrarId(nombreProveedorCifrado);
        
        // Se copia el arreglo de productos del proveedor que tiene el idProveedor
        for(Proveedor proveedorActual: proveedores){
            if(proveedorActual.getId() == idProveedor){
                productosProveedorActual = proveedorActual.getMisProductos();
                break;
            }
        }
        
        // Se busca el producto con el idProducto para agregarlo a la copia del proveedor
        for(ProductoProveedor productoActual: productosEnElMercado){
            if(productoActual.getId() == idProducto){
                productosProveedorActual.add(productoActual);
            }
        }
        
        // Se reasigna el arreglo modificado a su proveedor original
        reasignarProductosA(idProveedor);
        
        // Se actualizan los proveedores en supermercado
        supermercado.setMisProveedores(proveedores);
    }
    
    public void desasignarProductoDeProveedor(int idProducto, int idProveedor){
        
        // Se copia el arreglo de productos del proveedor que tiene el idProveedor
        for(Proveedor proveedorActual: proveedores){
            if(proveedorActual.getId() == idProveedor){
                productosProveedorActual = proveedorActual.getMisProductos();
                break;
            }
        }
        
        // Se busca el producto con el idProducto para desasignarlo de la copia del proveedor
        for(ProductoProveedor productoActual: productosProveedorActual){
            if(productoActual.getId() == idProducto){
                productosProveedorActual.remove(productoActual);
                break;
            }
        }
        
        // Se reasigna el arreglo modificado a su proveedor original
        reasignarProductosA(idProveedor);
        
        // Se actualizan los proveedores en supermercado
        supermercado.setMisProveedores(proveedores);
    }
    
    public boolean productoYaOfrecidoPorProveedor(String nombreProductoCifrado, String nombreProveedorCifrado){
        
        boolean respuesta = false;
        
        // Se recupera el id del producto y del proveedor
        int idProducto = descifrarId(nombreProductoCifrado);
        int idProveedor = descifrarId(nombreProveedorCifrado);
        
        // Se copia el arreglo de productos del proveedor que tiene el idProveedor
        for(Proveedor proveedorActual: proveedores){
            if(proveedorActual.getId() == idProveedor){
                productosProveedorActual = proveedorActual.getMisProductos();
                break;
            }
        }
        
        // Se busca si el producto existe en el catalogo del proveedor
        for(ProductoProveedor productoActual: productosProveedorActual){
            if(productoActual.getId() == idProducto){
                respuesta = true;
                break;
            }
        }
        
        return respuesta;
    }
    
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
    
    public void reasignarProductosA(int idProveedor){
        for(Proveedor proveedorActual: proveedores){
            if(proveedorActual.getId() ==idProveedor){
                proveedorActual.setMisProductos(productosProveedorActual);
            }
        }
    }
    
    public void iniciarVentanaPrincipal() {
        VentanaPrincipalModelo modelo = new VentanaPrincipalModelo();
        VentanaPrincipalVista vista = new VentanaPrincipalVista();
        VentanaPrincipalControlador controlador = new VentanaPrincipalControlador(modelo, vista);
    }
}

