package supermercado;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  Supermercado.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

public class Proveedor implements Serializable{

    protected int id;
    protected String nombre;
    protected java.util.List<ProductoProveedor> misProductos = new ArrayList<>();

    /**
     * Constructor de la clase Proveedor
     * @param id El id del proveedor (int)
     * @param nombre El nombre completo del proveedor (String)
     */
    public Proveedor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Obtiene la id del proveedor
     * @return id El numero de id (int)
     */
    public int getId() {
        return id;
    }

    /**
     * Asigna una id al proveedor
     * @param id El numero de id para asignar (int)
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del proveedor
     * @return nombre El nombre completo del proveedor (String)
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna un nombre al proveedor
     * @param nombre El nombre completo del proveedor (String)
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el arreglo de misProductos
     * @return misProductos El arreglo de productos (List-ProductoProveedor-)
     */
    public List<ProductoProveedor> getMisProductos() {
        return misProductos;
    }

    /**
     * Asigna un arreglo de productos
     * @param misProductos El arreglo de productos (List-ProductoProveedor-)
     */
    public void setMisProductos(List<ProductoProveedor> misProductos) {
        this.misProductos = misProductos;
    }
}
