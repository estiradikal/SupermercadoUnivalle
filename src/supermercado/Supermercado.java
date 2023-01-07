package supermercado;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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

public class Supermercado {
    
    protected java.util.List<ProductoProveedor> productosEnElMercado = new ArrayList<>();
    protected java.util.List<ProductoInventario> misProductos = new ArrayList<>();
    protected java.util.List<Cliente> misClientes = new ArrayList<>();
    protected java.util.List<Proveedor> misProveedores = new ArrayList<>();
    protected java.util.List<Venta> misVentas = new ArrayList<>();

    /**
     * Constructor de la clase Supermercado
     */
    public Supermercado(){
        restaurarDatos();
    }

    /**
     * Obtiene el arreglo de productos en el mercado
     * @return El arreglo de productos en el mercado (List-ProductoProveedor-)
     */
    public List<ProductoProveedor> getProductosEnElMercado() {
        return productosEnElMercado;
    }

    /**
     * Asigna un arreglo de productos en el mercado
     * @param productosEnElMercado El arreglo de productos en el mercado (List-ProductoProveedor-)
     */
    public void setProductosEnElMercado(List<ProductoProveedor> productosEnElMercado) {
        this.productosEnElMercado = productosEnElMercado;
        guardarDatos();
    }

    /**
     * Obtiene el arreglo de productos que pertenecen al supermercado
     * @return misProductos El arreglo de productos (List-ProductoInventario-)
     */
    public List<ProductoInventario> getMisProductos() {
        return misProductos;
    }

    /**
     * Asigna un arreglo de productos al supermercado
     * @param misProductos El arreglo de productos (List-ProductoInventario-)
     */
    public void setMisProductos(List<ProductoInventario> misProductos) {
        this.misProductos = misProductos;
        guardarDatos();
    }

    /**
     * Obtiene el arreglo de los clientes del supermercado
     * @return misClientes El arreglo de clientes (List-Cliente-)
     */
    public List<Cliente> getMisClientes() {
        return misClientes;
    }

    /**
     * Asigna un arreglo de clientes al supermercado
     * @param misClientes El arreglo de clientes (List-Cliente-)
     */
    public void setMisClientes(List<Cliente> misClientes) {
        this.misClientes = misClientes;
        guardarDatos();
    }

    /**
     * Obtiene el arreglo de los proveedores del supermercado
     * @return El arreglo de proveedores (List-Proveedor-)
     */
    public List<Proveedor> getMisProveedores() {
        return misProveedores;        
    }

    /**
     * Asigna un arreglo de proveedores al supermercado
     * @param misProveedores El arreglo de proveedores (List-Proveedor-)
     */
    public void setMisProveedores(List<Proveedor> misProveedores) {
        this.misProveedores = misProveedores;
        guardarDatos();
    }

    /**
     * Obtiene el arreglo de ventas del supermercado
     * @return misVentas El arreglo de ventas del supermercado (List-Venta-)
     */
    public List<Venta> getMisVentas() {
        return misVentas;
    }

    /**
     * Asigna un arreglo de ventas al supermercado
     * @param misVentas El arreglo de ventas del supermercado (List-Venta-)
     */
    public void setMisVentas(List<Venta> misVentas) {
        this.misVentas = misVentas;
        guardarDatos();
    }
    
    public void guardarDatos(){
        try {
            
            ObjectOutputStream backup = new ObjectOutputStream(new FileOutputStream("persistentInfo.data"));
            backup.writeObject(productosEnElMercado);
            backup.writeObject(misProductos);
            backup.writeObject(misClientes);
            backup.writeObject(misProveedores);
            backup.writeObject(misVentas);
            backup.flush();
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: Ruta para exportar valida");
        }
    }
    
    public void restaurarDatos(){
        try {
            
            ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("persistentInfo.data"));
            productosEnElMercado = (ArrayList) recuperar.readObject();
            misProductos = (ArrayList) recuperar.readObject();
            misClientes = (ArrayList) recuperar.readObject();
            misProveedores = (ArrayList) recuperar.readObject();
            misVentas = (ArrayList) recuperar.readObject();
            recuperar.close();
            
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error: ClassNotFoundException");
        } catch (EOFException e) {
            JOptionPane.showMessageDialog(null, "Error: EOFException");
        } catch (IOException e) {
            // El archivo de informacion aun no existe
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error: NullPointerException");
        }
    }
}
