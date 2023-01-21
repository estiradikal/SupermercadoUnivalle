package main;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  main.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import modelo.*;
import vista.*;
import controlador.*;

public class main {
    /**
     * Clase principal que instancia el MVC de VentanaPrincipal
     * @param args 
     */
    public static void main(String[] args) {
        VentanaPrincipalModelo modelo = new VentanaPrincipalModelo();
        VentanaPrincipalVista vista = new VentanaPrincipalVista();
        VentanaPrincipalControlador controlador = new VentanaPrincipalControlador(modelo, vista);
    }
}
