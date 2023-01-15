package vista;

/**
 *    Fundamentos de programación orientada a eventos 750014C-01  
 *    Laboratorio # 4
 *    Profesor: Luis Romo Portilla 
 *
 *    Archivo:  VentanaInventarioVista.java
 *    Licencia: GNU-GPL 
 *    @version  1.1
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

public class VentanaComprarVista extends javax.swing.JFrame {
    
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
    public VentanaComprarVista() {
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
        lbl_proveedor = new javax.swing.JLabel();
        lbl_producto = new javax.swing.JLabel();
        lbl_titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_principal = new javax.swing.JTable();
        btn_registrar = new javax.swing.JButton();
        lbl_total = new javax.swing.JLabel();
        txtF_cantidad = new javax.swing.JTextField();
        lbl_costo = new javax.swing.JLabel();
        lbl_cantidad = new javax.swing.JLabel();
        box_producto = new javax.swing.JComboBox<>();
        box_proveedor = new javax.swing.JComboBox<>();
        btn_volver = new javax.swing.JButton();
        lbl_titulo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 420));
        setPreferredSize(new java.awt.Dimension(800, 420));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(520, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(520, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_proveedor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_proveedor.setText("Proveedor");
        jPanel1.add(lbl_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        lbl_producto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_producto.setText("Producto");
        jPanel1.add(lbl_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        lbl_titulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_titulo.setText("Nueva compra");
        jPanel1.add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 750, 20));

        table_principal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_principal);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 750, 160));

        btn_registrar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_registrar.setText("Registrar");
        jPanel1.add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 90, -1));

        lbl_total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_total.setText("Total a pagar: $");
        jPanel1.add(lbl_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, -1, -1));

        txtF_cantidad.setText("0");
        jPanel1.add(txtF_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 50, -1));

        lbl_costo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_costo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_costo.setText("-");
        jPanel1.add(lbl_costo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 100, -1));

        lbl_cantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_cantidad.setText("Cantidad");
        jPanel1.add(lbl_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jPanel1.add(box_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 400, -1));

        jPanel1.add(box_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 400, -1));

        btn_volver.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_volver.setText("Volver");
        jPanel1.add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 310, 90, -1));

        lbl_titulo1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_titulo1.setText("Registro de compras");
        jPanel1.add(lbl_titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, 750, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(VentanaComprarVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaComprarVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaComprarVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaComprarVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaComprarVista().setVisible(true);
            }
        });
    }
    
    
    //              GETTERS Y SETTERS               //
    /**
     * Asigna un texto al lbl_costo
     * @param texto El texto que se asignara al campo (String)
     */
    public void setCosto(String texto){
        lbl_costo.setText(texto);
    }
    
    /**
     * Asigna un texto al txtF_cantidad
     * @param texto El texto que se asignara al campo (String)
     */
    public void setCantidad(String texto){
        txtF_cantidad.setText(texto);
    }
        
    /**
     * Obtiene el texto en txt_cantidad
     * @return La cantidad de producto sin verificar validez (String)
     */
    public String getCantidad(){
        return txtF_cantidad.getText();
    }
    
    /**
     * Obtiene el texto en box_proveedor
     * @return El nombre del proveedor de forma id@nombre (String)
     */
    public String getProveedor(){
        return box_proveedor.getSelectedItem().toString();
    }
    
    /**
     * Obtiene el texto en box_producto
     * @return El nombre del producto de forma id@nombre (String)
     */
    public String getProducto(){
        return box_producto.getSelectedItem().toString();
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
    
    
    //              CONFIGURACIONES             //
    /**
     * Crea los titulos de la tabla
     */
    public void configurarTabla() {
        String[] titulosTabla = new String[]{"FECHA", "PRODUCTO", "COSTO kg/unid ($)", "CANTIDAD", "TOTAL ($)", };
        modeloTabla.setColumnIdentifiers(titulosTabla);        
 
        // CENTRAR CONTENIDO DE COLUMNAS
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i = 0; i < titulosTabla.length; i++){
            table_principal.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
    }
    
    /**
     * Añade una nueva fila a la tabla
     * @param idProducto El id del producto (String)
     * @param nombreProducto El nombre del producto (String)
     * @param cantidad La cantidad de producto (String)
     * @param medida La medida del producto en kg o unid (String)
     */
    public void nuevaFilaTabla(String fecha, String nombreProducto, String costoUnid, String cantidad, String costoTotal) {
        modeloTabla.addRow(new Object[]{
            fecha, nombreProducto, costoUnid, cantidad, costoTotal
        });
    }
    
    /**
     * Cierra la ventana actual
     */
    public void cerrar(){
        dispose();
    }
    
    
    //              FUNCIONES DE LIMPIEZA               //
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
    
    public void limpiarCampos(){
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
   
    
    //              LISTENERS               //
    /**
     * Añade un ActionListener al JButton de comprar
     * @param listener El ActionListener
     */
    public void addActionRegistrarCompra(ActionListener listener){
        btn_registrar.addActionListener(listener);
    }   
    
    /**
     * Añade un ActionListener al JButton de volver
     * @param listener El ActionListener
     */
    public void addActionVolver(ActionListener listener){
        btn_volver.addActionListener(listener);
    }
    
    /**
     * Agrega un ActionListener al JComboBox de proveedor
     * @param listener El ActionListener
     */
    public void addProveedorListener(ActionListener listener) {
        box_proveedor.addActionListener(listener);
    }
    
    /**
     * Agrega un ActionListener al JComboBox de productos
     * @param listener El ActionListener
     */
    public void addProductosListener(ActionListener listener) {
        box_producto.addActionListener(listener);
    }
    
    /**
     * Agrega un ActionListener al JComboBox de producto
     * @param listener El ActionListener
     */
    public void addProductoListener(ActionListener listener) {
        box_producto.addActionListener(listener);
    }
    
    /**
     * Añade un MouseListener al txtF_cantidad
     * @param listener El KeyListener
     */
    public void addCantidadListener(MouseListener listener){
        txtF_cantidad.addMouseListener(listener);
    }
    
    /**
     * Añade un KeyListener al txtF_cantidad
     * @param listener El KeyListener
     */
    public void addCantidadListener(KeyListener listener){
        txtF_cantidad.addKeyListener(listener);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box_producto;
    private javax.swing.JComboBox<String> box_proveedor;
    private javax.swing.JButton btn_registrar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_cantidad;
    private javax.swing.JLabel lbl_costo;
    private javax.swing.JLabel lbl_producto;
    private javax.swing.JLabel lbl_proveedor;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_titulo1;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JTable table_principal;
    private javax.swing.JTextField txtF_cantidad;
    // End of variables declaration//GEN-END:variables

}
