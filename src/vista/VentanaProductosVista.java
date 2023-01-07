package vista;

import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01 
 *    Laboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaProductosVista.java
 *    Licencia: GNU-GPL 
 *    @version  0.1
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

public class VentanaProductosVista extends javax.swing.JFrame {

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
     * Constructor de VentanaProductosVista
     */
    public VentanaProductosVista() {
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
        lbl_precio = new javax.swing.JLabel();
        txtF_precio = new javax.swing.JTextField();
        lbl_textoGuia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_principal = new javax.swing.JTable();
        btn_cancelar = new javax.swing.JButton();
        btn_registrar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();
        box_medida = new javax.swing.JComboBox<>();
        lbl_valor4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 500));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtF_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 210, -1));

        lbl_id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_id.setText("Id");
        jPanel1.add(lbl_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        lbl_nombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_nombre.setText("Nombre");
        jPanel1.add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        lbl_titulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_titulo.setText("Productos");
        jPanel1.add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel1.add(txtF_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 210, -1));

        lbl_precio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_precio.setText("Precio");
        jPanel1.add(lbl_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));
        jPanel1.add(txtF_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 120, -1));

        lbl_textoGuia.setForeground(new java.awt.Color(0, 102, 102));
        lbl_textoGuia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbl_textoGuia, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 260, 20));

        table_principal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_principal);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 340, 220));

        btn_cancelar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setEnabled(false);
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 90, -1));

        btn_registrar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_registrar.setText("Registrar");
        jPanel1.add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 90, -1));

        btn_modificar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.setEnabled(false);
        jPanel1.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, -1, -1));

        btn_eliminar.setBackground(new java.awt.Color(187, 187, 187));
        btn_eliminar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setEnabled(false);
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 90, -1));

        btn_volver.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_volver.setText("Volver");
        jPanel1.add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, -1, -1));

        box_medida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unid", "Kg" }));
        jPanel1.add(box_medida, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 60, -1));

        lbl_valor4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_valor4.setText("por");
        jPanel1.add(lbl_valor4, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 160, 20, 20));

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
            java.util.logging.Logger.getLogger(VentanaProductosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaProductosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaProductosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaProductosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaProductosVista().setVisible(true);
            }
        });
    }
   
    /**
     * Crea los titulos de la tabla
     */
    public void configurarTabla() {
        String[] titulosTabla = new String[]{"ID", "NOMBRE", "PRECIO"};
        modeloTabla.setColumnIdentifiers(titulosTabla);
    }
   
    public void cerrar(){
        dispose();
    }
    
    public void addActionRegistrar(ActionListener listener){
        btn_registrar.addActionListener(listener);
    }
    
    public void addActionModificar(ActionListener listener){
        btn_modificar.addActionListener(listener);
    }
        
    public void addActionEliminar(ActionListener listener){
        btn_eliminar.addActionListener(listener);
    }
    
    public void addActionVolver(ActionListener listener){
        btn_volver.addActionListener(listener);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box_medida;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_registrar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_precio;
    private javax.swing.JLabel lbl_textoGuia;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_valor4;
    private javax.swing.JTable table_principal;
    private javax.swing.JTextField txtF_id;
    private javax.swing.JTextField txtF_nombre;
    private javax.swing.JTextField txtF_precio;
    // End of variables declaration//GEN-END:variables

}
