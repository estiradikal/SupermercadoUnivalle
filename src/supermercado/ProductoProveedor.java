package supermercado;

import java.io.Serializable;

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

public class ProductoProveedor implements Serializable{

    /**
     * Declaración de variables
     */
    protected int Id;
    protected String nombre;
    protected int precio;
    protected String medida; // Kg: Kilogramos o Unid: Unidades

    /**
     * Constructor de ProductoProveedor
     * @param Id El id del producto (int)
     * @param nombre El nombre del producto (String)
     * @param precio El precio del producto (int)
     * @param medida La medida (kilogramos o unidades) del producto (String)
     */
    public ProductoProveedor(int Id, String nombre, int precio, String medida) {
        this.Id = Id;
        this.nombre = nombre;
        this.precio = precio;
        this.medida = medida;
    }

    /**
     * Obtiene el id del producto
     * @return Id El id del producto (int)
     */
    public int getId() {
        return Id;
    }

    /**
     * Asigna un id al producto
     * @param Id El nuevo id del producto (int)
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * Obtiene el nombre del producto
     * @return nombre El nombre del producto (String)
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna un nombre al producto
     * @param nombre El nuevo nombre delproducto (String)
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto
     * @return precio El precio del producto (int)
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Asigna un precio al producto
     * @param precio  El precio del producto (int)
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la forma en como se mide el producto
     * Kg: Kilogramos | Unid: Unidades
     * @return medida La medida del producto (String)
     */
    public String getMedida() {
        return medida;
    }

    /**
     * Asigna la medida del producto
     * Kg: Kilogramos | Unid: Unidades
     * @param medida La medida del producto (String)
     */
    public void setMedida(String medida) {
        this.medida = medida;
    }
}
