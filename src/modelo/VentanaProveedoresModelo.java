package modelo;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    elboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaProveedoresModelo.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import vista.*;
import controlador.*;
import supermercado.*;

public class VentanaProveedoresModelo {
    
    Supermercado supermercado = new Supermercado();
    java.util.List<Proveedor> proveedores = supermercado.getMisProveedores();
    
    public VentanaProveedoresModelo(){
    }
    
    /**
     * Registra un nuevo proveedor en el arreglo
     * @param id El id del proveedor (int)
     * @param nombre  El nombre del proveedor (String)
     */
    public void registrar(int id, String nombre){
        proveedores.add(new Proveedor(id, nombre));
        supermercado.setMisProveedores(proveedores);
    }
    
    /**
     * Modifica un proveedor ya existente
     * @param idActual el id que tiene el proveedor actualmente (int)
     * @param nuevoId el id que se le asignara (int)
     * @param nuevoNombre El nombre que se le asignara (int)
     */
    public void modificar(int idActual, int nuevoId, String nuevoNombre){
        for(Proveedor proveedorActual: proveedores){
            if(proveedorActual.getId() == idActual){
                proveedorActual.setId(nuevoId);
                proveedorActual.setNombre(nuevoNombre);
                break;
            }
        }
        supermercado.setMisProveedores(proveedores);
    }
    
    /**
     * Elimina el proveedor en una posicion del arreglo
     * @param id el id del proveedor (int)
     */
    public void eliminar(int id){
        for(Proveedor proveedorActual: proveedores){
            if(proveedorActual.getId() == id){
                proveedores.remove(proveedorActual);
                break;
            }
        }
        supermercado.setMisProveedores(proveedores);
    }
    
    /**
     * Obtiene la cantidad de proveedores
     * @return el cantidad de proveedores (int)
     */
    public int getCantidadProveedores(){
        return proveedores.size();
    }
    
    /**
     * Obtiene la id de un proveedor
     * @param indice el posicion del proveedor en el arreglo (int)
     * @return El numero de identificacion de la id del proveedor (int)
     */            
    public int getId(int indice){
        return proveedores.get(indice).getId();
    }
    
    /**
     * Obtiene el nombre de un proveedor
     * @param indice el posicion del proveedor en el arreglo (int)
     * @return El nombre del clietne (String)
     */
    public String getNombre(int indice){
        return proveedores.get(indice).getNombre();
    }
    
    /**
     * Verifica si ya existe un proveedor con cierta id
     * @param id el id a verificar (int)
     * @return true: Existe un proveedor con este id; false: No existe un proveedor con este id (boolean)
     */
    public boolean existeId(int id){
        boolean respuesta = false;
        
        for(Proveedor proveedorActual: proveedores){
            if(proveedorActual.getId() == id){
                respuesta = true;
                break;
            }
        }
        
        return respuesta;
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
