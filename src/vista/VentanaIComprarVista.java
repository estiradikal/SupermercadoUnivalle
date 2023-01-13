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
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;

public class VentanaIComprarVista extends javax.swing.JFrame {
    
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
    public VentanaIComprarVista() {
        initComponents();
    }

    /**
     * Codigo autogenerado por Netbeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_proveedor = new javax.swing.JLabel();
        lbl_producto = new javax.swing.JLabel();
        lbl_titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_principal = new javax.swing.JTable();
        btn_cancelar = new javax.swing.JButton();
        btn_comprar = new javax.swing.JButton();
        lbl_total = new javax.swing.JLabel();
        txtF_cantidad = new javax.swing.JTextField();
        lbl_costo = new javax.swing.JLabel();
        lbl_cantidad = new javax.swing.JLabel();
        box_producto = new javax.swing.JComboBox<>();
        box_proveedor = new javax.swing.JComboBox<>();
        btn_volver = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        lbl_textoGuia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(520, 400));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(520, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(520, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_proveedor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_proveedor.setText("Proveedor");
        jPanel1.add(lbl_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        lbl_producto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_producto.setText("Producto");
        jPanel1.add(lbl_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        lbl_titulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_titulo.setText("Registro de compras");
        jPanel1.add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, 20));

        table_principal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_principal);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 430, 160));

        btn_cancelar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setEnabled(false);
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 90, -1));

        btn_comprar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_comprar.setText("Comprar");
        jPanel1.add(btn_comprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 90, -1));

        lbl_total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_total.setText("Total a pagar: $");
        jPanel1.add(lbl_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, -1, -1));
        jPanel1.add(txtF_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 100, -1));

        lbl_costo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_costo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_costo.setText("0");
        jPanel1.add(lbl_costo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 70, -1));

        lbl_cantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_cantidad.setText("Cantidad");
        jPanel1.add(lbl_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        jPanel1.add(box_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 300, -1));

        jPanel1.add(box_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 300, -1));

        btn_volver.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_volver.setText("Volver");
        jPanel1.add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 90, -1));

        btn_eliminar.setBackground(new java.awt.Color(187, 187, 187));
        btn_eliminar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setEnabled(false);
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, -1, -1));

        lbl_textoGuia.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_textoGuia.setForeground(new java.awt.Color(0, 102, 102));
        lbl_textoGuia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbl_textoGuia, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 430, 20));

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
            java.util.logging.Logger.getLogger(VentanaIComprarVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaIComprarVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaIComprarVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaIComprarVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new VentanaIComprarVista().setVisible(true);
            }
        });
    }
    
    public void setCostro(String costo){
        lbl_costo.setText(costo);
    }
    
    public String getCantidad(){
        return txtF_cantidad.getText();
    }
    
    public String getProveedor(){
        return box_proveedor.getSelectedItem().toString();
    }
    
    public String getProducto(){
        return box_producto.getSelectedItem().toString();
    }
    
    /**
     * Añade una nueva fila a la tabla
     * @param idProducto El id del producto (String)
     * @param nombreProducto El nombre del producto (String)
     * @param cantidad La cantidad de producto (String)
     * @param medida La medida del producto en kg o unid (String)
     */
    public void nuevaFilaTabla(String idProducto, String nombreProducto, String cantidad, String medida) {
        modeloTabla.addRow(new Object[]{
            idProducto, nombreProducto, cantidad, medida
        });
    }
    
    /**
     * Establece un texto para instruir en el modo Registrar
     */
    public void setGuiaRegistrar() {
        lbl_textoGuia.setText("Presione eliminar para eliminar el producto o Cancelar para volver al modo Compra");
    }

    /**
     * Establece un texto para instruir en el modo Modificar
     */
    public void setGuiaModificar() {
        lbl_textoGuia.setText("Seleccione productos de la tabla para eliminarlos de su inventario");
    }
    
    /**
     * Añade un nuevo proveedor como item seleccionable al JComboBox 
     * @param nombreProveedor El id + nombre del producto (String)
     */
    public void cargarProveedor(String nombreProveedor){
        box_proveedor.addItem(nombreProveedor);
    }
    
    /**
     * Añade un nuevo producto como item seleccionable al JComboBox 
     * @param nombreProducto El id + nombre del producto (String)
     */
    public void cargarProducto(String nombreProducto){
        box_producto.addItem(nombreProducto);
    }
    
    /**
     * Vacia el JComboBox de proveedores a cero items
     */
    public void eliminarProveedoresCargados(){
        box_proveedor.removeAllItems();
    }
    
    /**
     * Vacia el JComboBox de productos a cero items
     */
    public void eliminarProductosCargados(){
        box_producto.removeAllItems();
    }
    
    public void cerrar(){
        dispose();
    }
    
    
    //              FUNCIONES DE LIMPIEZA                   //
    public void limpiarCampos(){
        box_proveedor.setSelectedIndex(0);
        box_producto.setSelectedIndex(0);
        lbl_costo.setText("-");
        txtF_cantidad.setText("");
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

    
    //              HABILITAR/DESHABILITAR BOTONES          //
    public void habilitarComprar() {
        btn_comprar.setEnabled(true);
    }

    public void deshabilitarComprar() {
        btn_comprar.setEnabled(false);
    }
    
    public void habilitarCancelar() {
        btn_cancelar.setEnabled(true);
    }

    public void deshabilitarCancelar() {
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
    
    public void habilitarProveedores(){
        box_proveedor.setEnabled(true);
    }
    
    public void deshabilitarProveedores(){
        box_proveedor.setEnabled(false);
    }
    
    public void habilitarProductos(){
        box_producto.setEnabled(true);
    }
    
    public void deshabilitarProductos(){
        box_producto.setEnabled(false);
    }
    
    public void habilitarCantidad(){
        txtF_cantidad.setEnabled(true);
    }
    
    public void deshabilitarCantidad(){
        txtF_cantidad.setEnabled(false);
    }
    
    
    //              LISTENERS               //
    /**
     * Añade un ActionListener al JButton de comprar
     * @param listener El ActionListener
     */
    public void addActionComprar(ActionListener listener){
        btn_comprar.addActionListener(listener);
    }
    
    /**
     * Añade un ActionListener al JButton de cancelar
     * @param listener El ActionListener
     */
    public void addActionCancelar(ActionListener listener){
        btn_cancelar.addActionListener(listener);
    }
    
    /**
     * Añade un ActionListener al JButton de volver
     * @param listener El ActionListener
     */
    public void addActionVolver(ActionListener listener){
        btn_volver.addActionListener(listener);
    }
    
    /**
     * Añade un ActionListener al JButton de eliminar
     * @param listener El ActionListener
     */
    public void addActionEliminar(ActionListener listener){
        btn_eliminar.addActionListener(listener);
    }
    
    /**
     * Agrega un ActionListener al JComboBox de proveedor
     * @param listener El ActionListener
     */
    public void addProveedorListener(ActionListener listener) {
        box_proveedor.addActionListener(listener);
    }
    
    /**
     * Agrega un ActionListener al JComboBox de producto
     * @param listener El ActionListener
     */
    public void addProductoListener(ActionListener listener) {
        box_producto.addActionListener(listener);
    }
    
    /**
     * Agrega un MouseListener a la tabla
     *
     * @param listener El MouseListener
     */
    public void addActionTable(MouseListener listener) {
        table_principal.addMouseListener(listener);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box_producto;
    private javax.swing.JComboBox<String> box_proveedor;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_comprar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_cantidad;
    private javax.swing.JLabel lbl_costo;
    private javax.swing.JLabel lbl_producto;
    private javax.swing.JLabel lbl_proveedor;
    private javax.swing.JLabel lbl_textoGuia;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JTable table_principal;
    private javax.swing.JTextField txtF_cantidad;
    // End of variables declaration//GEN-END:variables

}
