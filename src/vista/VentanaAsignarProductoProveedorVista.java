package vista;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01
 *    Laboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaProductosVista.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

public class VentanaAsignarProductoProveedorVista extends javax.swing.JFrame {
    
    /**
     * Creacion de un modelo de tabla NO editable
     */
    private DefaultTableModel modeloTabla = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };

    /**
     * Constructor de VentanaClientesVista
     */
    public VentanaAsignarProductoProveedorVista() {
        initComponents();
        table_proveedor.setModel(modeloTabla);
        configurarTabla();
    }

    /**
     * Codigo autogenerado por Netbeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_cedula = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        lbl_titulo = new javax.swing.JLabel();
        lbl_textoGuia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_proveedor = new javax.swing.JTable();
        btn_cancelar = new javax.swing.JButton();
        btn_asignar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();
        combo_producto = new javax.swing.JComboBox<>();
        combo_proveedor = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 500));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_cedula.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_cedula.setText("Proveedor");
        jPanel1.add(lbl_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        lbl_nombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_nombre.setText("Producto");
        jPanel1.add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        lbl_titulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_titulo.setText("Asignar");
        jPanel1.add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lbl_textoGuia.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_textoGuia.setForeground(new java.awt.Color(0, 102, 102));
        lbl_textoGuia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbl_textoGuia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 340, 20));

        table_proveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_proveedor);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 340, 220));

        btn_cancelar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setEnabled(false);
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 90, -1));

        btn_asignar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_asignar.setText("Asignar");
        jPanel1.add(btn_asignar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 90, -1));

        btn_eliminar.setBackground(new java.awt.Color(187, 187, 187));
        btn_eliminar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setEnabled(false);
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 90, -1));

        btn_volver.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_volver.setText("Volver");
        jPanel1.add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, -1, -1));

        jPanel1.add(combo_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 190, -1));

        jPanel1.add(combo_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Look & Feel autogenerado por Netbeans
     * @param args 
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaAsignarProductoProveedorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAsignarProductoProveedorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAsignarProductoProveedorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAsignarProductoProveedorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaAsignarProductoProveedorVista().setVisible(true);
            }
        });
    }

    
    //              GETTERS Y SETTERS               //
   
    // Sentencias para realizar...
    
    
    //              CONFIGURACIONES             //
    /**
     * Crea los titulos de la tabla
     */
    public void configurarTabla() {
        String[] titulosTabla = new String[]{"CEDULA", "NOMBRE COMPLETO"};
        modeloTabla.setColumnIdentifiers(titulosTabla);
    }
    
    /**
     * Establece un texto para instruir en el modo Registrar
     */
    public void setGuiaRegistrar() {
        lbl_textoGuia.setText("Modifique los campos arriba o presione Cancelar para el modo registro");
    }

    /**
     * Establece un texto para instruir en el modo Modificar
     */
    public void setGuiaModificar() {
        lbl_textoGuia.setText("Seleccione clientes en la tabla (si los hay) para modificarlos");
    }
    
    /**
     * Cierra la ventana actual
     */
    public void cerrar(){
        dispose();
    }
    
    /**
     * Añade una nueva fila con los datos de un cliente
     * @param cedula El numero de cedula del cliente (int)
     * @param nombre El nombre completo del cliente (String)
     */
    public void nuevaFila(int cedula, String nombre) {
        modeloTabla.addRow(new Object[]{
            cedula, nombre
        });
    }
    
    
    //              FUNCIONES DE LIMPIEZA                   //
    /**
     * Elimina todas las filas de la tabla
     */
    public void limpiarTabla() {
        int filasTabla = modeloTabla.getRowCount();
        for (int i = 0; i < filasTabla; i++) {
            modeloTabla.removeRow(0);
        }
    }

    /**
     * Elimina una fila específica de la tabla
     *
     * @param fila La Fila a eliminar
     */
    public void eliminarFilaTabla(int fila) {
        modeloTabla.removeRow(fila);
    }

    
    //              HABILITAR/DESHABILITAR BOTONES          //
    /**
     * Habilita el boton de cancelar
     */
    public void habilitarCancelar() {
        btn_cancelar.setEnabled(true);
    }

    /**
     * Deshabilita el boton de cancelar
     */
    public void deshabilitarCancelar() {
        btn_cancelar.setEnabled(false);
    }

    /**
     * Habilita el boton de registrar
     */
    public void habilitarRegistrar() {
        btn_asignar.setEnabled(true);
    }

    /**
     * Deshabilita el boton de registrar
     */
    public void deshabilitarRegistrar() {
        btn_asignar.setEnabled(false);
    }

    /**
     * Habilita btn_eliminar y configura su color en rojo
     */
    public void habilitarEliminar() {
        btn_eliminar.setEnabled(true);
        btn_eliminar.setBackground(new java.awt.Color(255, 0, 51));
    }

    /**
     * Deshabilita btn_eliminar y configura su color en gris
     */
    public void deshabilitarEliminar() {
        btn_eliminar.setEnabled(false);
        btn_eliminar.setBackground(new java.awt.Color(187, 187, 187));
    }
    
    
    //              LISTENERS            //
    /**
     * Añade un ActionListener a btn_registrar
     * @param listener El listener (ActionListener)
     */
    public void addActionRegistrar(ActionListener listener){
        btn_asignar.addActionListener(listener);
    }
          
    /**
     * Añade un ActionListener a btn_eliminar
     * @param listener El listener (ActionListener)
     */
    public void addActionEliminar(ActionListener listener){
        btn_eliminar.addActionListener(listener);
    }
    
    /**
     * Añade un ActionListener a btn_cancelar
     * @param listener El listener (ActionListener)
     */
    public void addActionCancelar(ActionListener listener){
        btn_cancelar.addActionListener(listener);
    }
    
    /**
     * Añade un ActionListener a btn_volver
     * @param listener El listener (ActionListener)
     */
    public void addActionVolver(ActionListener listener){
        btn_volver.addActionListener(listener);
    }
    
    /**
     * Agrega un MouseListener a la tabla
     * @param listener El MouseListener
     */
    public void addActionTable(MouseListener listener) {
        table_proveedor.addMouseListener(listener);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_asignar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JComboBox<String> combo_producto;
    private javax.swing.JComboBox<String> combo_proveedor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_cedula;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_textoGuia;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JTable table_proveedor;
    // End of variables declaration//GEN-END:variables

}
