package POO;

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

public class ProductoInventario extends ProductoProveedor {
    
    protected int cantidad;

    /**
     * Constructor de la clase ProductoProveedor
     * @param cantidad La cantidad de producto que se comprara (int)
     * @param Id El id del producto (String)
     * @param nombre El nombre del producto (String)
     * @param precio El precio del producto (int)
     * @param medida La medida (kilogramos o unidades) del producto (String)
     */
    public ProductoInventario(int cantidad, String Id, String nombre, int precio, String medida) {
        super(Id, nombre, precio, medida);
        this.cantidad = cantidad;
    }

    /**
     * Obtiene la cantidad de producto disponible
     * @return cantidad La cantidad de producto actualmente disponible (int)
     */
    public int getCantidad() {
        return cantidad;
    }

    
    /**
     * Asigna la cantidad de producto disponible
     * @param cantidad La cantidad de producto actualmente disponible (int)
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
