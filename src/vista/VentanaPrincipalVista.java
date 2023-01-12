package vista;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaPrincipalVista.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import java.awt.event.ActionListener;

public class VentanaPrincipalVista extends javax.swing.JFrame {

    /**
     * Constructor de VentanaPrincipalVista
     */
    public VentanaPrincipalVista() {
        initComponents();
    }

    /**
     * Codigo autogenerado por Netbeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();
        lbl_rojoCabecera = new javax.swing.JLabel();
        lbl_gestionar = new javax.swing.JLabel();
        btn_proveedores = new javax.swing.JButton();
        btn_clientes = new javax.swing.JButton();
        btn_productos = new javax.swing.JButton();
        lbl_gestionar1 = new javax.swing.JLabel();
        btn_comprarProductos = new javax.swing.JButton();
        btn_registroVentas = new javax.swing.JButton();
        btn_productosProveedores = new javax.swing.JButton();
        lbl_gestionar2 = new javax.swing.JLabel();
        lbl_gestionar3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(520, 400));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(520, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(520, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_titulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_titulo.setText("Supermercado Universidad del Valle"); // NOI18N
        jPanel1.add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 470, 40));

        lbl_rojoCabecera.setBackground(new java.awt.Color(255, 0, 51));
        lbl_rojoCabecera.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_rojoCabecera.setForeground(new java.awt.Color(255, 0, 0));
        lbl_rojoCabecera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_rojoCabecera.setOpaque(true);
        jPanel1.add(lbl_rojoCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 60));

        lbl_gestionar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_gestionar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_gestionar.setText("Plantillas");
        jPanel1.add(lbl_gestionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 80, -1));

        btn_proveedores.setBackground(new java.awt.Color(255, 0, 51));
        btn_proveedores.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_proveedores.setForeground(new java.awt.Color(255, 255, 255));
        btn_proveedores.setText("Proveedores");
        jPanel1.add(btn_proveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 190, 30));

        btn_clientes.setBackground(new java.awt.Color(255, 0, 51));
        btn_clientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_clientes.setForeground(new java.awt.Color(255, 255, 255));
        btn_clientes.setText("Clientes");
        jPanel1.add(btn_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 190, 30));

        btn_productos.setBackground(new java.awt.Color(255, 0, 51));
        btn_productos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_productos.setForeground(new java.awt.Color(255, 255, 255));
        btn_productos.setText("Productos");
        jPanel1.add(btn_productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 190, 30));

        lbl_gestionar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_gestionar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_gestionar1.setText("Ventas");
        jPanel1.add(lbl_gestionar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 80, -1));

        btn_comprarProductos.setBackground(new java.awt.Color(255, 0, 51));
        btn_comprarProductos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_comprarProductos.setForeground(new java.awt.Color(255, 255, 255));
        btn_comprarProductos.setText("Comprar productos");
        jPanel1.add(btn_comprarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 200, 30));

        btn_registroVentas.setBackground(new java.awt.Color(255, 0, 51));
        btn_registroVentas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_registroVentas.setForeground(new java.awt.Color(255, 255, 255));
        btn_registroVentas.setText("Registro de ventas");
        jPanel1.add(btn_registroVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 200, 30));

        btn_productosProveedores.setBackground(new java.awt.Color(255, 0, 51));
        btn_productosProveedores.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_productosProveedores.setForeground(new java.awt.Color(255, 255, 255));
        btn_productosProveedores.setText("Productos a proveedores");
        btn_productosProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_productosProveedoresActionPerformed(evt);
            }
        });
        jPanel1.add(btn_productosProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 200, 30));

        lbl_gestionar2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_gestionar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_gestionar2.setText("Asignar");
        jPanel1.add(lbl_gestionar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 80, -1));

        lbl_gestionar3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_gestionar3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_gestionar3.setText("Inventario");
        jPanel1.add(lbl_gestionar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 80, -1));

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

    private void btn_productosProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_productosProveedoresActionPerformed
      
    }//GEN-LAST:event_btn_productosProveedoresActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipalVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaPrincipalVista().setVisible(true);
            }
        });
    }
    
    /**
     * Cierra la ventana actual
     */
    public void cerrar(){
        dispose();
    }

    /**
     * Añade un ActionListener al JButton de productos
     * @param listener El ActionListener
     */
    public void addActionProductos(ActionListener listener){
        btn_productos.addActionListener(listener);
    }
    
    /**
     * Añade un ActionListener al JButton de proveedores
     * @param listener El ActionListener
     */
    public void addActionProveedores(ActionListener listener){
        btn_proveedores.addActionListener(listener);
    }
    
    /**
     * Añade un ActionListener al JButton de clientes
     * @param listener El ActionListener
     */
    public void addActionClientes(ActionListener listener){
        btn_clientes.addActionListener(listener);
    }
    
    /**
     * Añade un ActionListener al JButton de Productos a proveedores
     * @param listener El ActionListener
     */
    public void addActionProductosProveedores(ActionListener listener){
        btn_productosProveedores.addActionListener(listener);
    }
    
    /**
     * Añade un ActionListener al JButton de Comprar productos
     * @param listener El ActionListener
     */
    public void addActionComprarProductos(ActionListener listener){
        btn_comprarProductos.addActionListener(listener);
    }
    
    /**
     * Añade un ActionListener al JButton de Registro de Ventas
     * @param listener El ActionListener
     */
    public void addActionRegistroVentas(ActionListener listener){
        btn_registroVentas.addActionListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clientes;
    private javax.swing.JButton btn_comprarProductos;
    private javax.swing.JButton btn_productos;
    private javax.swing.JButton btn_productosProveedores;
    private javax.swing.JButton btn_proveedores;
    private javax.swing.JButton btn_registroVentas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_gestionar;
    private javax.swing.JLabel lbl_gestionar1;
    private javax.swing.JLabel lbl_gestionar2;
    private javax.swing.JLabel lbl_gestionar3;
    private javax.swing.JLabel lbl_rojoCabecera;
    private javax.swing.JLabel lbl_titulo;
    // End of variables declaration//GEN-END:variables

}
