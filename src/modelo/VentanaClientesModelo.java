package modelo;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaClientesModelo.java
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

public class VentanaClientesModelo {
    
    /**
     * Instancia de Supermercado y ArrayList de Cliente.
     */
    Supermercado supermercado = new Supermercado();
    java.util.List<Cliente> clientes = supermercado.getMisClientes();
    
    /**
     * Constructor de la clase VentanaClientesModelo
     */
    public VentanaClientesModelo(){
    }
    
    /**
     * Registra un nuevo cliente en el arreglo
     * @param cedula La cedula del cliente (int)
     * @param nombre  El nombre del cliente (String)
     */
    public void registrar(int cedula, String nombre){
        clientes.add(new Cliente(cedula, nombre));
        supermercado.setMisClientes(clientes);
    }
    
    /**
     * Modifica un cliente ya existente
     * @param cedulaActual La cedula que tiene el cliente actualmente (int)
     * @param nuevaCedula La cedula que se le asignara (int)
     * @param nuevoNombre El nombre que se le asignara (int)
     */
    public void modificar(int cedulaActual, int nuevaCedula, String nuevoNombre){
        for(Cliente clienteActual: clientes){
            if(clienteActual.getCedula() == cedulaActual){
                clienteActual.setCedula(nuevaCedula);
                clienteActual.setNombre(nuevoNombre);
                break;
            }
        }
        supermercado.setMisClientes(clientes);
    }
    
    /**
     * Elimina el cliente en una posicion del arreglo
     * @param cedula La cedula del cliente (int)
     */
    public void eliminar(int cedula){
        for(Cliente clienteActual: clientes){
            if(clienteActual.getCedula() == cedula){
                clientes.remove(clienteActual);
                break;
            }
        }
        supermercado.setMisClientes(clientes);
    }
    
    /**
     * Obtiene la cantidad de clientes
     * @return La cantidad de clientes (int)
     */
    public int getCantidadClientes(){
        return clientes.size();
    }
    
    /**
     * Obtiene la cedula de un cliente
     * @param indice La posicion del cliente en el arreglo (int)
     * @return El numero de identificacion de la cedula del cliente (int)
     */            
    public int getCedula(int indice){
        return clientes.get(indice).getCedula();
    }
    
    /**
     * Obtiene el nombre de un cliente
     * @param indice La posicion del cliente en el arreglo (int)
     * @return El nombre del clietne (String)
     */
    public String getNombre(int indice){
        return clientes.get(indice).getNombre();
    }
    
    /**
     * Verifica si ya existe un cliente con cierta cedula
     * @param cedula La cedula a verificar (int)
     * @return true: Existe un cliente con esta cedula; false: No existe un cliente con esta cedula (boolean)
     */
    public boolean existeCedula(int cedula){
        boolean respuesta = false;
        
        for(Cliente clienteActual: clientes){
            if(clienteActual.getCedula() == cedula){
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
