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
 *    @version  1.0.1
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

public class VentanaProveedoresVista extends javax.swing.JFrame {

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
    public VentanaProveedoresVista() {
        initComponents();
        table_principal.setModel(modeloTabla);
        configurarTabla();
    }

    /**
     * Codigo autogenerado por Netbeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtF_id = new javax.swing.JTextField();
        lbl_id = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        lbl_titulo = new javax.swing.JLabel();
        txtF_nombre = new javax.swing.JTextField();
        lbl_textoGuia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_principal = new javax.swing.JTable();
        btn_cancelar = new javax.swing.JButton();
        btn_registrar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 500));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtF_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 190, -1));

        lbl_id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_id.setText("Id");
        jPanel1.add(lbl_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        lbl_nombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_nombre.setText("Nombre");
        jPanel1.add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        lbl_titulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_titulo.setText("Proveedores");
        jPanel1.add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel1.add(txtF_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 190, -1));

        lbl_textoGuia.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_textoGuia.setForeground(new java.awt.Color(0, 102, 102));
        lbl_textoGuia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbl_textoGuia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 340, 20));

        table_principal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_principal);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 340, 220));

        btn_cancelar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setEnabled(false);
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 90, -1));

        btn_registrar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_registrar.setText("Registrar");
        jPanel1.add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 90, -1));

        btn_modificar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.setEnabled(false);
        jPanel1.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, -1, -1));

        btn_eliminar.setBackground(new java.awt.Color(187, 187, 187));
        btn_eliminar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setEnabled(false);
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 90, -1));

        btn_volver.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_volver.setText("Volver");
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });
        jPanel1.add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, -1, -1));

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

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_volverActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaProveedoresVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaProveedoresVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaProveedoresVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaProveedoresVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaProveedoresVista().setVisible(true);
            }
        });
    }
    
    
    //              GETTERS Y SETTERS               //
    /**
     * Obtiene el id en el campo de texto
     * @return El id en el JTextField (String)
     */
    public String getId(){
        return txtF_id.getText();
    }
    
    /**
     * Cambia el id en el campo de texto
     * @param id El nuevo contenido del JTextField (String)
     */
    public void setId(String id){
        txtF_id.setText(id);
    }
    
    /**
     * Obtiene el nommbre en el campo de texto
     * @return El nombre en el JTextField (String)
     */
    public String getNombre(){
        return txtF_nombre.getText();
    }
    
    /**
     * Cambia El nombre en el campo de texto
     * @param nombre El nuevo contenido del JTextField (String)
     */
    public void setNombre(String nombre){
        txtF_nombre.setText(nombre);
    }
    
    
    //              CONFIGURACIONES             //
    /**
     * Crea los titulos de la tabla
     */
    public void configurarTabla() {
        String[] titulosTabla = new String[]{"ID", "NOMBRE"};
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
        lbl_textoGuia.setText("Seleccione proveedores en la tabla (si los hay) para modificarlos");
    }
    
    /**
     * Cierra la ventana actual
     */
    public void cerrar(){
        dispose();
    }
    
    /**
     * Añade una nueva fila con los datos de un proveedor
     * @param id El numero de id del proveedor (int)
     * @param nombre El nombre completo del proveedor (String)
     */
    public void nuevaFila(int id, String nombre) {
        modeloTabla.addRow(new Object[]{
            id, nombre
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

    /**
     * Vacía los textos en los campos de id y nombre
     */
    public void limpiarCampos() {
        txtF_id.setText("");
        txtF_nombre.setText("");
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
        btn_registrar.setEnabled(true);
    }

    /**
     * Deshabilita el boton de registrar
     */
    public void deshabilitarRegistrar() {
        btn_registrar.setEnabled(false);
    }

    /**
     * Habilita el boton de Modificar
     */
    public void habilitarModificar() {
        btn_modificar.setEnabled(true);
    }

    /**
     * Deshabilita el boton de modificar
     */
    public void deshabilitarModificar() {
        btn_modificar.setEnabled(false);
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
        btn_registrar.addActionListener(listener);
    }
    
    /**
     * Añade un ActionListener a btn_modificar
     * @param listener El listener (ActionListener)
     */
    public void addActionModificar(ActionListener listener){
        btn_modificar.addActionListener(listener);
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
        table_principal.addMouseListener(listener);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_registrar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_textoGuia;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JTable table_principal;
    private javax.swing.JTextField txtF_id;
    private javax.swing.JTextField txtF_nombre;
    // End of variables declaration//GEN-END:variables

}
