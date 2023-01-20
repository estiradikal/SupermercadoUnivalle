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

public class Cliente implements Serializable{
    /**
     * Declaración de variables
     */
    protected int cedula;
    protected String nombre;

    /**
     * Constructor de la clase Cliente
     * @param cedula La cedula del cliente (int)
     * @param nombre El nombre completo del cliente (String)
     */
    public Cliente(int cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    /**
     * Obtiene la cedula del cliente
     * @return cedula El numero de la cedula (int)
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * Asigna una cedula al cliente
     * @param cedula El numero de cedula para asignar (int)
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtiene el nombre del cliente
     * @return nombre El nombre completo del cliente (String)
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna un nombre al cliente
     * @param nombre El nombre completo del cliente (String)
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
