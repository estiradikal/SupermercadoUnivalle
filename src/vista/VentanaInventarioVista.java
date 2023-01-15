package vista;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaInventarioVista.java
 *    Licencia: GNU-GPL 
 *    @version  1.0
 *    
 *    @author   Alejandro Guerrero Cano           (202179652-3743) {@literal <"alejandro.cano@correounivalle.edu.co">}
 *    @author   Estiven Andres Martinez Granados  (202179687-3743) {@literal <"estiven.martinez@correounivalle.edu.co">}
 *    @author   Juan David Loaiza Santiago        (202177570-3743) {@literal <"juan.loaiza.santiago@correounivalle.edu.co">}
 * 
*/

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class VentanaInventarioVista extends javax.swing.JFrame {
    
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
     * Constructor de VentanaInventarioVista
     */
    public VentanaInventarioVista() {
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
        lbl_titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_principal = new javax.swing.JTable();
        btn_modificar = new javax.swing.JButton();
        txtF_porcentaje = new javax.swing.JTextField();
        lbl_cantidad = new javax.swing.JLabel();
        btn_volver = new javax.swing.JButton();
        lbl_titulo1 = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        lbl_cantidad1 = new javax.swing.JLabel();
        lbl_textoGuia = new javax.swing.JLabel();
        btn_eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 640));
        setPreferredSize(new java.awt.Dimension(1000, 640));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(520, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(520, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_titulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_titulo.setText("Asignar nuevo porcentaje de ganancia");
        jPanel1.add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 950, 20));

        table_principal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_principal);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 950, 450));

        btn_modificar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_modificar.setText("Modificar");
        jPanel1.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 550, 90, -1));

        txtF_porcentaje.setText("0");
        jPanel1.add(txtF_porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 550, 60, -1));

        lbl_cantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_cantidad.setText("Porcentaje de ganancia");
        jPanel1.add(lbl_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        btn_volver.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_volver.setText("Volver");
        jPanel1.add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 550, 90, -1));

        lbl_titulo1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_titulo1.setText("Registro de compras");
        jPanel1.add(lbl_titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, 950, 20));

        btn_cancelar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_cancelar.setText("Cancelar");
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 550, 90, -1));

        lbl_cantidad1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_cantidad1.setText("%");
        jPanel1.add(lbl_cantidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 550, -1, -1));

        lbl_textoGuia.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_textoGuia.setForeground(new java.awt.Color(0, 102, 102));
        lbl_textoGuia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbl_textoGuia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 950, 20));

        btn_eliminar.setBackground(new java.awt.Color(187, 187, 187));
        btn_eliminar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setText("Eliminar producto");
        btn_eliminar.setEnabled(false);
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 550, 160, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(VentanaInventarioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaInventarioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaInventarioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaInventarioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new VentanaInventarioVista().setVisible(true);
            }
        });
    }
    
    /**
     * Asigna un texto al txtF_cantidad
     * @param texto El texto que se asignara al campo (String)
     */
    public void setCantidad(String texto){
        txtF_porcentaje.setText(texto);
    }
        
    /**
     * Obtiene el texto en txt_cantidad
     * @return La cantidad de producto sin verificar validez (String)
     */
    public String getCantidad(){
        return txtF_porcentaje.getText();
    }


    //              CONFIGURACIONES             //
    /**
     * Crea los titulos de la tabla
     */
    public void configurarTabla() {
        String[] titulosTabla = new String[]{"ID", "NOMBRE", "CANTIDAD", "MEDIDA", "PRECIO DE COMPRA ($)", "PRECIO DE VENTA ($)", "GANANCIA (%)" };
        modeloTabla.setColumnIdentifiers(titulosTabla);
        
        // ASIGNAR ANCHOS
        table_principal.getColumnModel().getColumn(0).setPreferredWidth(4);
        table_principal.getColumnModel().getColumn(2).setPreferredWidth(1);
        table_principal.getColumnModel().getColumn(3).setPreferredWidth(1);
        table_principal.getColumnModel().getColumn(6).setPreferredWidth(2);
        
        // CENTRAR CONTENIDO DE COLUMNAS
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i = 0; i < titulosTabla.length; i++){
            table_principal.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
    }
    
    /**
     * Establece un texto para instruir en el modo Visualizar
     */
    public void setGuiaVisualizar() {
        lbl_textoGuia.setText("Cambie el porcentaje de ganacia, elimine  el producto o presione Cancelar si desea descartar los cambios. Consejo: Use máximo dos decimales en el porcentaje");
    }

    /**
     * Establece un texto para instruir en el modo Modificar
     */
    public void setGuiaModificar() {
        lbl_textoGuia.setText("Seleccione productos en la tabla para cambiar su porcentaje de ganancia");
    }
    
    /**
     * Añade una nueva fila a la tabla
     * @param id
     * @param nombre
     * @param cantidad
     * @param medida
     * @param precioDeCompra
     * @param ganancia
     * @param precioDeVenta 
     */
    public void nuevaFilaTabla(String id, String nombre, String cantidad, String medida, String precioDeCompra, String precioDeVenta, String ganancia) {
        modeloTabla.addRow(new Object[]{
            id, nombre, cantidad, medida, precioDeCompra, precioDeVenta, ganancia
        });
    }
    
    /**
     * Cierra la ventana actual
     */
    public void cerrar(){
        dispose();
    }
    
    
    //              HABILITAR/DESHABILITAR BOTONES              //
    public void habilitarModificar(){
        btn_modificar.setEnabled(true);
    }
    
    public void deshabilitarModificar(){
        btn_modificar.setEnabled(false);
    }
    
    public void habilitarPorcentaje(){
        txtF_porcentaje.setEnabled(true);
    }
    
    public void deshabilitarPorcentaje(){
        txtF_porcentaje.setEnabled(false);
    }
    
    public void habilitarCancelar(){
        btn_cancelar.setEnabled(true);
    }
    
    public void deshabilitarCancelar(){
        btn_cancelar.setEnabled(false);
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
    
    
    //              FUNCIONES DE LIMPIEZA               //
    public void limpiarCampos(){
        txtF_porcentaje.setText("");
    }
    
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
   
    
    //              LISTENERS               //
    /**
     * Añade un ActionListener al JButton de comprar
     * @param listener El ActionListener
     */
    public void addActionRegistrarCompra(ActionListener listener){
        btn_modificar.addActionListener(listener);
    }   
    
    /**
     * Añade un ActionListener al JButton de volver
     * @param listener El ActionListener
     */
    public void addActionVolver(ActionListener listener){
        btn_volver.addActionListener(listener);
    }
    
    /**
     * Añade un MouseListener al txtF_cantidad
     * @param listener El KeyListener
     */
    public void addCantidadListener(MouseListener listener){
        txtF_porcentaje.addMouseListener(listener);
    }
    
    /**
     * Añade un KeyListener al txtF_cantidad
     * @param listener El KeyListener
     */
    public void addCantidadListener(KeyListener listener){
        txtF_porcentaje.addKeyListener(listener);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_cantidad;
    private javax.swing.JLabel lbl_cantidad1;
    private javax.swing.JLabel lbl_textoGuia;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_titulo1;
    private javax.swing.JTable table_principal;
    private javax.swing.JTextField txtF_porcentaje;
    // End of variables declaration//GEN-END:variables

}
