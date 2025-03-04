
package Frames;

import Clases.Menu;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JOptionPane;


public class MenuFrame extends javax.swing.JFrame {
    // Lista para almacenar los pedidos
    private LinkedList<Menu> pedidos = new LinkedList<>();
    private String nombreMesero;
    private String nombreMesa;
    /**
     * Creates new form MenuFrame
     */
    public MenuFrame() {
        initComponents();
        //accion del boton agregar
        // Acción del botón Agregar Pedido
        
    }
    
    // Método para agregar pedido a la LinkedList
    private void agregarPedido(){
        //Obtener selecciones de combobox
        String cantCeviche= (String) jComboBoxCeviche.getSelectedItem();
        String cantJalea= (String) jComboBoxJalea.getSelectedItem();
        String cantArroz= (String) jComboBoxarrozMariscos.getSelectedItem();
        String cantlecheTigre = (String) jComboBoxlecheTigre.getSelectedItem();
        String cantGaseosa= (String) jComboBoxGaseosa.getSelectedItem();
        String cantAgua= (String) jComboBoxAgua.getSelectedItem();
        String cantChicha = (String) jComboBoxChicha.getSelectedItem();
        
        // Verificar y agregar a la lista de pedidos
        if (!cantCeviche.equals("0")) {
            pedidos.add(new Menu(100, "Ceviche", Integer.parseInt(cantCeviche), 25.0));
        }
        if (!cantJalea.equals("0")) {
            pedidos.add(new Menu(200, "Jalea", Integer.parseInt(cantJalea), 30.0));
        }
        if (!cantArroz.equals("0")) {
            pedidos.add(new Menu(300, "Arroz con Mariscos", Integer.parseInt(cantArroz), 28.0));
        }
        if (!cantlecheTigre.equals("0")) {
            pedidos.add(new Menu(400, "Leche de Tigre", Integer.parseInt(cantlecheTigre), 18.0));
        }
        
        if (!cantGaseosa.equals("0")) {
            pedidos.add(new Menu(200, "Gaseosa", Integer.parseInt(cantGaseosa), 4));
        }
        if (!cantAgua.equals("0")) {
            pedidos.add(new Menu(300, "Agua", Integer.parseInt(cantArroz), 2));
        }
        if (!cantChicha.equals("0")) {
            pedidos.add(new Menu(400, "Chicha", Integer.parseInt(cantChicha), 10));
        }
        
        StringBuilder resumen = new StringBuilder("Pedidos:\n");
        for (Menu pedido : pedidos) {
              resumen.append(pedido.toString()).append("\n");
        }
        //JOptionPane.showMessageDialog(this, resumen.toString(), "Resumen del Pedido", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void mostrarDatosMeseroMesa() {
        DatosMeseroMesaDialog dialog = new DatosMeseroMesaDialog(this, true);
        dialog.setLocationRelativeTo(this); 

        // Generar resumen del pedido
        StringBuilder resumen = new StringBuilder();
        double total=0;
        for (Menu pedido : pedidos) {
            //verificar que la cant dsea mayor a 0 para evitar registros innecesarios
            if(pedido.getCantplato()>0){
                resumen.append(pedido.toString()).append("\n");
                total += pedido.getCantplato()*pedido.getPrecio();
            }
            
        }
        dialog.mostrarOrdenMenu(resumen.toString(), total);

        // Mostrar el diálogo
        dialog.setVisible(true);

        // Verificar si el usuario confirmó
        if (dialog.isConfirmado()) {
            nombreMesero = dialog.getNombreMesero();
            nombreMesa = dialog.getNombreMesa();
            //Guarda el pedido confirmado solo si hay pedidos validos
            if(!pedidos.isEmpty()){
                guardarEnArchivo();
            }
            //limpiar para refrescar menu
            limpiarMenu();
        } else {
            limpiarMenu();
        }
        
        
    }
    
     private void guardarEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("factura.txt", true))) {
            writer.write("Nombre del Mesero: " + nombreMesero + "\n");
            writer.write("Nombre de la Mesa: " + nombreMesa + "\n");
            writer.write("Pedidos:\n");
            
            double total=0;
            
            for (Menu pedido : pedidos) {
                //verificar que la cant sea mayor a 0 antes de escribir en el archivo
                if(pedido.getCantplato()>0){
                    writer.write(pedido.toString() + "\n");
                    total += pedido.getCantplato()*pedido.getPrecio();
                }
            }
            writer.write("Total: S/" + total + "\n");
            writer.write("===================================\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
    private void limpiarMenu() {
        // Limpia la lista de pedidos
        pedidos.clear();

        // Reinicia los JComboBox a su valor por defecto (índice 0)
        jComboBoxAgua.setSelectedIndex(0);
        jComboBoxCeviche.setSelectedIndex(0);
        jComboBoxChicha.setSelectedIndex(0);
        jComboBoxGaseosa.setSelectedIndex(0);
        jComboBoxJalea.setSelectedIndex(0);
        jComboBoxarrozMariscos.setSelectedIndex(0);
        jComboBoxlecheTigre.setSelectedIndex(0);

        // Refresca el JTextArea (si tienes alguno en MenuFrame)
        // jTextAreaResumen.setText(""); // Descomenta si tienes un JTextArea en MenuFrame
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1FondoMenu = new javax.swing.JPanel();
        jComboBoxAgua = new javax.swing.JComboBox<>();
        jComboBoxlecheTigre = new javax.swing.JComboBox<>();
        jComboBoxJalea = new javax.swing.JComboBox<>();
        jComboBoxGaseosa = new javax.swing.JComboBox<>();
        jComboBoxChicha = new javax.swing.JComboBox<>();
        jComboBoxCeviche = new javax.swing.JComboBox<>();
        jComboBoxarrozMariscos = new javax.swing.JComboBox<>();
        jButton2AgregarPedido = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel1fondo = new javax.swing.JLabel();
        jLabel1fondoo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setFocusTraversalPolicyProvider(true);
        setMinimumSize(null);

        jPanel1FondoMenu.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1FondoMenu.setMinimumSize(new java.awt.Dimension(860, 800));
        jPanel1FondoMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxAgua.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        jPanel1FondoMenu.add(jComboBoxAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 400, -1, -1));

        jComboBoxlecheTigre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        jPanel1FondoMenu.add(jComboBoxlecheTigre, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, -1, -1));

        jComboBoxJalea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        jPanel1FondoMenu.add(jComboBoxJalea, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, -1, -1));

        jComboBoxGaseosa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        jPanel1FondoMenu.add(jComboBoxGaseosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 260, -1, -1));

        jComboBoxChicha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        jPanel1FondoMenu.add(jComboBoxChicha, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 330, -1, -1));

        jComboBoxCeviche.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        jPanel1FondoMenu.add(jComboBoxCeviche, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, -1, -1));

        jComboBoxarrozMariscos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        jComboBoxarrozMariscos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxarrozMariscosActionPerformed(evt);
            }
        });
        jPanel1FondoMenu.add(jComboBoxarrozMariscos, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, -1, -1));

        jButton2AgregarPedido.setBackground(new java.awt.Color(204, 0, 51));
        jButton2AgregarPedido.setFont(new java.awt.Font("Bahnschrift", 3, 18)); // NOI18N
        jButton2AgregarPedido.setForeground(new java.awt.Color(255, 255, 255));
        jButton2AgregarPedido.setText("Agregar Pedido");
        jButton2AgregarPedido.setToolTipText("");
        jButton2AgregarPedido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2AgregarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2AgregarPedidoActionPerformed(evt);
            }
        });
        jPanel1FondoMenu.add(jButton2AgregarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 500, 150, 40));

        jButton1.setBackground(new java.awt.Color(204, 0, 51));
        jButton1.setFont(new java.awt.Font("Bahnschrift", 3, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back (1).png"))); // NOI18N
        jButton1.setText("Volver");
        jButton1.setToolTipText("");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1FondoMenu.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Agua mineral");
        jPanel1FondoMenu.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Chicha");
        jPanel1FondoMenu.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 330, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Gaseosa");
        jPanel1FondoMenu.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, -1, -1));

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("BEBIDAS");
        jPanel1FondoMenu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jalea");
        jPanel1FondoMenu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Leche de tigre");
        jPanel1FondoMenu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Arroz con Mariscos");
        jPanel1FondoMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ceviche");
        jPanel1FondoMenu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        jLabel1fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/plantilla-de-menu-de-restaurante_23-2147535344.jpg"))); // NOI18N
        jPanel1FondoMenu.add(jLabel1fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 40, 660, 540));

        jLabel1fondoo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/plantilla-de-menu-de-restaurante_23-2147535344.jpg"))); // NOI18N
        jPanel1FondoMenu.add(jLabel1fondoo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 610, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1FondoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1FondoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 585, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2AgregarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2AgregarPedidoActionPerformed
        agregarPedido();
        mostrarDatosMeseroMesa();
    }//GEN-LAST:event_jButton2AgregarPedidoActionPerformed

    private void jComboBoxarrozMariscosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxarrozMariscosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxarrozMariscosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose(); // Cierra el JFrame actual
        new VistaLogin().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2AgregarPedido;
    private javax.swing.JComboBox<String> jComboBoxAgua;
    private javax.swing.JComboBox<String> jComboBoxCeviche;
    private javax.swing.JComboBox<String> jComboBoxChicha;
    private javax.swing.JComboBox<String> jComboBoxGaseosa;
    private javax.swing.JComboBox<String> jComboBoxJalea;
    private javax.swing.JComboBox<String> jComboBoxarrozMariscos;
    private javax.swing.JComboBox<String> jComboBoxlecheTigre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1fondo;
    private javax.swing.JLabel jLabel1fondoo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1FondoMenu;
    // End of variables declaration//GEN-END:variables
}
