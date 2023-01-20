

package vista;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01
 *    Elboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaProductosVista.java
 *    Licencia: GNU-GPL 
 *    @version  1.2
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

public class VentanaProductosProveedoresVista extends javax.swing.JFrame {

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
     * Constructor de VentanaProveedoresVista
     */
    public VentanaProductosProveedoresVista() {
        initComponents();
        table_principal.setModel(modeloTabla);
        configurarTabla();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        lbl_proveedor = new javax.swing.JLabel();
        box_proveedor = new javax.swing.JComboBox<>();
        lbl_producto = new javax.swing.JLabel();
        box_producto = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_principal = new javax.swing.JTable();
        btn_asignar = new javax.swing.JButton();
        btn_desasignar = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();
        lbl_textoGuia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 540));
        setPreferredSize(new java.awt.Dimension(500, 540));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_titulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_titulo.setText("Asignar productos a proveedores");
        jPanel1.add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btn_cancelar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setEnabled(false);
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 90, -1));

        lbl_proveedor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_proveedor.setText("Proveedor");
        jPanel1.add(lbl_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jPanel1.add(box_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 250, -1));

        lbl_producto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_producto.setText("Producto");
        lbl_producto.setMaximumSize(new java.awt.Dimension(54, 20));
        lbl_producto.setMinimumSize(new java.awt.Dimension(54, 20));
        lbl_producto.setName(""); // NOI18N
        lbl_producto.setPreferredSize(new java.awt.Dimension(54, 20));
        jPanel1.add(lbl_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 70, -1));
        jPanel1.add(box_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 250, -1));

        table_principal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_principal);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 470, 260));

        btn_asignar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_asignar.setText("Asignar");
        jPanel1.add(btn_asignar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 110, -1));

        btn_desasignar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_desasignar.setText("Desasignar");
        btn_desasignar.setEnabled(false);
        jPanel1.add(btn_desasignar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 110, -1));

        btn_volver.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_volver.setText("Volver");
        jPanel1.add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, -1, -1));
        btn_volver.getAccessibleContext().setAccessibleDescription("");

        lbl_textoGuia.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_textoGuia.setForeground(new java.awt.Color(0, 102, 102));
        lbl_textoGuia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbl_textoGuia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 470, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(VentanaProductosProveedoresVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaProductosProveedoresVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaProductosProveedoresVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaProductosProveedoresVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaProductosProveedoresVista().setVisible(true);
            }
        });
    }
    
    //              GETTER Y SETTER             //
    public String getProveedor() {
        return box_proveedor.getSelectedItem().toString(); 
    }
    
    public void setProveedor(String proveedor) {
        box_proveedor.setSelectedItem(proveedor);
    }
    
    public void addProveedor(String proveedor) {
        box_proveedor.addItem(proveedor);
    }
    
    public void addProductoProveedor(String producto) {
        box_producto.addItem(producto);
    }
    
    public String getProductoProveedor() {
        return box_producto.getSelectedItem().toString(); 
    }
    
    public void setProductoProveedor(String ProductoProveedor) {
        box_proveedor.setSelectedItem(ProductoProveedor);
    }
    
    /**
     * Crea los titulos de la tabla
     */
    public void configurarTabla() {
        String[] titulosTabla = new String[]{"ID","PROVEEDOR", "ID","PRODUCTO"};
        modeloTabla.setColumnIdentifiers(titulosTabla);
    }

    /**
     * Añade una nueva fila con los datos de un nuevo afiliado
     *
     * @param Id El Id del nuevo afiliado
     * @param nombre El nombre completo del nuevo afiliado
     */
    public void nuevaFila(int idProveedor, String nombreProveedor, int idProducto, String nombreProducto) {
        modeloTabla.addRow(new Object[]{
            idProveedor, nombreProveedor, idProducto, nombreProducto
        });
    }
    
    /**
     * Establece un texto para instruir en el modo Registrar
     */
    public void setGuiaRegistrar() {
        lbl_textoGuia.setText("Presione Desasignar para continuar o Cancelar para volver al modo asignacion");
    }

    /**
     * Establece un texto para instruir en el modo Modificar
     */
    public void setGuiaModificar() {
        lbl_textoGuia.setText("Seleccione una fila de la tabla para desasignar un producto de un proveedor");
    }
    
    /**
     * Cierra la ventana actual
     */
    public void cerrar() {
        dispose();
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
    public void habilitarCancelar() {
        btn_cancelar.setEnabled(true);
    }

    public void deshabilitarCancelar() {
        btn_cancelar.setEnabled(false);
    }

    public void habilitarRegistrar() {
        btn_asignar.setEnabled(true);
    }

    public void deshabilitarRegistrar() {
        btn_asignar.setEnabled(false);
    }

    /**
     * Habilita btn_eliminar y configura su color en rojo
     */
    public void habilitarEliminar() {
        btn_desasignar.setEnabled(true);
        btn_desasignar.setBackground(new java.awt.Color(255, 0, 51));
    }

    /**
     * Deshabilita btn_eliminar y configura su color en gris
     */
    public void deshabilitarEliminar() {
        btn_desasignar.setEnabled(false);
        btn_desasignar.setBackground(new java.awt.Color(187, 187, 187));
    }
    //                  HABILITA Y DESHABILITA LOS COMBOBOX             //
    public void habilitarBoxes(){
        box_proveedor.setEnabled(true);
        box_producto.setEnabled(true);
    }
    
    public void deshabilitarBoxes(){
        box_proveedor.setEnabled(false);
        box_producto.setEnabled(false);
    }
    
    //                  LISTENERS                       //
    /**
     * Agrega un ActionListener al btn_asignar
     *
     * @param listener El ActionListener
     */
    public void addActionAsignar(ActionListener listener) {
        btn_asignar.addActionListener(listener);
    }

    /**
     * Agrega un ActionListener al btn_desasignar
     *
     * @param listener El ActionListener
     */
    public void addActionDesasignar(ActionListener listener) {
        btn_desasignar.addActionListener(listener);
    }

    /**
     * Agrega un ActionListener al btn_volver
     *
     * @param listener El ActionListener
     */
    public void addActionVolver(ActionListener listener) {
        btn_volver.addActionListener(listener);
    }

    /**
     * Agrega un ActionListener al btn_cancelar
     *
     * @param listener El ActionListener
     */
    public void addActionCancelar(ActionListener listener) {
        btn_cancelar.addActionListener(listener);
    }

    /**
     * Agrega un MouseListener al btn_agregar
     *
     * @param listener El MouseListener
     */
    public void addActionTable(MouseListener listener) {
        table_principal.addMouseListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box_producto;
    private javax.swing.JComboBox<String> box_proveedor;
    private javax.swing.JButton btn_asignar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_desasignar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_producto;
    private javax.swing.JLabel lbl_proveedor;
    private javax.swing.JLabel lbl_textoGuia;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JTable table_principal;
    // End of variables declaration//GEN-END:variables

}
