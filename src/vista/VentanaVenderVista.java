package vista;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
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

public class VentanaVenderVista extends javax.swing.JFrame {
    
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
    public VentanaVenderVista() {
        initComponents();
        table_vender.setModel(modeloTabla);
        configurarTabla();
    }
    
    /**
     * Codigo autogenerado por Netbeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_cliente = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        lbl_titulo1 = new javax.swing.JLabel();
        lbl_titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_vender = new javax.swing.JTable();
        btn_volver = new javax.swing.JButton();
        box_producto = new javax.swing.JComboBox<>();
        box_cliente = new javax.swing.JComboBox<>();
        lbl_producto = new javax.swing.JLabel();
        txtF_cantidad = new javax.swing.JTextField();
        lbl_cantidad = new javax.swing.JLabel();
        btn_registrar = new javax.swing.JButton();
        lbl_costo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 400));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(520, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(520, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_cliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_cliente.setText("Cliente");
        jPanel1.add(lbl_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        lbl_nombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_nombre.setText("Total a pagar: $ ");
        jPanel1.add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 110, -1));
        lbl_nombre.getAccessibleContext().setAccessibleName("Total a pagar: $");

        lbl_titulo1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_titulo1.setText("Registro de ventas");
        lbl_titulo1.setMaximumSize(new java.awt.Dimension(116, 16));
        lbl_titulo1.setMinimumSize(new java.awt.Dimension(116, 16));
        lbl_titulo1.setPreferredSize(new java.awt.Dimension(116, 16));
        jPanel1.add(lbl_titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, 750, 20));

        lbl_titulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_titulo.setText("Nueva venta");
        lbl_titulo.setMaximumSize(new java.awt.Dimension(83, 16));
        lbl_titulo.setMinimumSize(new java.awt.Dimension(83, 16));
        lbl_titulo.setPreferredSize(new java.awt.Dimension(83, 16));
        jPanel1.add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 750, 20));

        table_vender.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_vender);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 750, 160));

        btn_volver.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_volver.setText("Volver");
        jPanel1.add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 310, 90, -1));

        jPanel1.add(box_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 400, -1));

        jPanel1.add(box_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 400, -1));

        lbl_producto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_producto.setText("Producto");
        jPanel1.add(lbl_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        txtF_cantidad.setText("0");
        jPanel1.add(txtF_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 50, -1));

        lbl_cantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_cantidad.setText("Cantidad");
        jPanel1.add(lbl_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        btn_registrar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_registrar.setText("Registrar");
        jPanel1.add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 90, -1));

        lbl_costo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_costo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_costo.setText("-");
        jPanel1.add(lbl_costo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(VentanaVenderVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaVenderVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaVenderVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaVenderVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new VentanaVenderVista().setVisible(true);
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
     * @return El nombre del cliente de forma id@nombre (String)
     */
    public String getCliente(){
        return box_cliente.getSelectedItem().toString();
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
     * @param cliente El id + nombre del producto (String)
     */
    public void nuevoCliente(String cliente){
        box_cliente.addItem(cliente);
    }
    
     /**
     * Añade un nuevo producto como item seleccionable al JComboBox 
     * @param nombreProducto El id + nombre del producto (String)
     */
    public void nuevoProducto(String nombreProducto){
        box_producto.addItem(nombreProducto);
    }
    
    
    //              CONFIGURACIONES             //
    
     /**
     * Crea los titulos de la tabla
     */
    public void configurarTabla() {
        String[] titulosTabla = new String[]{"FECHA","CLIENTE","PRODUCTO", "COSTO kg/unid ($)","CANTIDAD", "TOTAL ($)"};
        modeloTabla.setColumnIdentifiers(titulosTabla);
        // CENTRAR CONTENIDO DE COLUMNAS
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i = 0; i < titulosTabla.length; i++){
            table_vender.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
    }
    
     /**
     * Añade una nueva fila con los datos de un nuevo afiliado
     *
     * @param fecha La fecha de compra (String)
     * @param nombreCliente El nombre del cliente (String)
     * @param nombreProducto El nombre del producto (String)
     * @param precioDeVenta Precio para vender
     * @param cantidad La cantidad de producto (String)
     * @param total El total a pagar por producto (String)
     * 
     */
    
       public void nuevaFilaTabla(String fecha, String nombreCliente, String nombreProducto,String precioDeVenta, String cantidad, String total) {
        modeloTabla.addRow(new Object[]{
            fecha, nombreCliente,nombreProducto,precioDeVenta, cantidad, total
            
            
        });
    }
   
    /**
     * Cierra la ventana actual
     */
    public void cerrar(){
        dispose();
    }
    
    //              FUNCIONES DE LIMPIEZA                   //
    
    /**
     * Vacia JComboBox de clientes a cero 
     */
    public void eliminarClientesCargados(){
        box_cliente.removeAllItems();
    }
    
    /**
     * Vacia JComboBox de productos a cero 
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

    //              LISTENERS            //
    /**
     * Añade un ActionListener a btn_vender
     * @param listener El listener (ActionListener)
     */
    public void addActionVender(ActionListener listener){
        btn_registrar.addActionListener(listener);
    }

    /**
     * Añade un ActionListener a btn_volver
     * @param listener El listener (ActionListener)
     */
    public void addActionVolver(ActionListener listener){
        btn_volver.addActionListener(listener);
    }
    
    /**
     * Agrega un ActionListener al JComboBox de proveedor
     * @param listener El ActionListener
     */
    public void addClienteListener(ActionListener listener) {
        box_cliente.addActionListener(listener);
    }
    
    /**
     * Agrega un ActionListener al JComboBox de productos
     * @param listener El ActionListener
     */
    public void addProductosListener(ActionListener listener) {
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
    public void addTotalesListener(KeyListener listener){
        txtF_cantidad.addKeyListener(listener);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box_cliente;
    private javax.swing.JComboBox<String> box_producto;
    private javax.swing.JButton btn_registrar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_cantidad;
    private javax.swing.JLabel lbl_cliente;
    private javax.swing.JLabel lbl_costo;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_producto;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_titulo1;
    private javax.swing.JTable table_vender;
    private javax.swing.JTextField txtF_cantidad;
    // End of variables declaration//GEN-END:variables

}
