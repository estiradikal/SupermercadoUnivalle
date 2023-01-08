package modelo;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaProductosModelo.java
 *    Licencia: GNU-GPL 
 *    @version  0.1
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import vista.*;
import controlador.*;
import supermercado.*;

public class VentanaProductosModelo {
    
    Supermercado supermercado = new Supermercado();
    java.util.List<ProductoProveedor> productosEnElMercado = supermercado.getProductosEnElMercado();
    
    /**
     * Constructor de la clase VenatanaProductosModelo
     */
    public VentanaProductosModelo(){
    }
    
    /**
     * Registra un nuevo producto en el arreglo
     * @param id El id del producto (int)
     * @param nombre  El nombre del producto (String)
     * @param precio El precio al que el proveedor vendera el producto (int)
     * @param medida La forma de medir el producto (Kilogramos o Unidades) (String)
     */
    public void registrar(int id, String nombre, int precio, String medida){
        productosEnElMercado.add(new ProductoProveedor(id, nombre, precio, medida));
        supermercado.setProductosEnElMercado(productosEnElMercado);
    }
    
    /**
     * Modifica un producto ya existente
     * @param idActual El id que tiene el producto actualmente (int)
     * @param nuevoId El id que se le asignara (int)
     * @param nuevoNombre El nombre que se le asignara (int)
     * @param nuevoPrecio El precio que se le asignara (int)
     * @param nuevaMedida La forma de medir que se le asignara (String)
     */
    public void modificar(int idActual, int nuevoId, String nuevoNombre, int nuevoPrecio, String nuevaMedida){
        for(ProductoProveedor productoActual: productosEnElMercado){
            if(productoActual.getId() == idActual){
                productoActual.setId(nuevoId);
                productoActual.setNombre(nuevoNombre);
                productoActual.setPrecio(nuevoPrecio);
                productoActual.setMedida(nuevaMedida);
                break;
            }
        }
        supermercado.setProductosEnElMercado(productosEnElMercado);
    }
    
    /**
     * Elimina el producto en una posicion del arreglo
     * @param id el id del producto (int)
     */
    public void eliminar(int id){
        for(ProductoProveedor productoActual: productosEnElMercado){
            if(productoActual.getId() == id){
                productosEnElMercado.remove(productoActual);
                break;
            }
        }
        supermercado.setProductosEnElMercado(productosEnElMercado);
    }
    
    /**
     * Obtiene la cantidad de productosEnElMercado
     * @return el cantidad de productosEnElMercado (int)
     */
    public int getCantidadProductos(){
        return productosEnElMercado.size();
    }
    
    /**
     * Obtiene la id de un producto
     * @param indice el posicion del producto en el arreglo (int)
     * @return El numero de identificacion de la id del producto (int)
     */            
    public int getId(int indice){
        return productosEnElMercado.get(indice).getId();
    }
    
    /**
     * Obtiene el nombre de un producto
     * @param indice el posicion del producto en el arreglo (int)
     * @return El nombre del clietne (String)
     */
    public String getNombre(int indice){
        return productosEnElMercado.get(indice).getNombre();
    }
    
    /**
     * Obtiene el precio de un producto
     * @param indice La posicion del producto en el arreglo (int)
     * @return El precio al que los proveedores venden el producto (int)
     */
    public int getPrecio(int indice){
        return productosEnElMercado.get(indice).getPrecio();
    }
    
    /**
     * Obtiene la forma de medir el producto 
     * @param indice La posicion del producto en el arreglo (int)
     * @return La forma de medir el producto Kg o Unid (String)
     */
    public String getMedida(int indice){
        return productosEnElMercado.get(indice).getMedida();
    }
    
    /**
     * Verifica si ya existe un producto con cierto id
     * @param id el id a verificar (int)
     * @return true: Existe un producto con este id; false: No existe un producto con este id (boolean)
     */
    public boolean existeId(int id){
        boolean respuesta = false;
        
        for(ProductoProveedor productoActual: productosEnElMercado){
            if(productoActual.getId() == id){
                respuesta = true;
                break;
            }
        }
        
        return respuesta;
    }
    
    /**
     * Repasa todos los productos de todos los proveedores para eliminar el producto
     * @param id El id del producto (int)
     */
    public void eliminarProductoDeProveedores(int id){
        java.util.List<Proveedor> proveedores = supermercado.getMisProveedores(); // Copia todos los proveedores
        
        for(Proveedor proveedorActual: proveedores){ // Repasa todos los proveedores
            
            java.util.List<ProductoProveedor> productosDeEsteProveedor = proveedorActual.getMisProductos(); // Copia los productos de cada proveedor
            
            for(ProductoProveedor productoActual: productosDeEsteProveedor){ // Repasa todos los productos de cada proveedor
                
                if(productoActual.getId() == id){ // El proveedor tiene el producto
                    productosDeEsteProveedor.remove(productoActual); // Elimina el producto del proveedor
                    proveedorActual.setMisProductos(productosDeEsteProveedor); // Actualiza los produtos en proveedores
                }
            }
        }
        supermercado.setMisProveedores(proveedores); // Actualiza los proveedores en el sistema
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
