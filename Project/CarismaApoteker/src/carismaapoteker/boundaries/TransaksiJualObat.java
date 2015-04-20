package carismaapoteker.boundaries;

import carismaapoteker.controller.ClientSocket;
import carismaapoteker.controller.TransaksiJualObatController;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sinta Eka Lestari
 */
public class TransaksiJualObat extends javax.swing.JFrame {

    private ClientSocket Client;
    private String userName;
    private DefaultTableModel tableOfSales;
    private int total = 0;
    public int row = 0;
    private TransaksiJualObatController controller;
    java.util.Date dateNow = new java.util.Date();
    
    public TransaksiJualObat(ClientSocket Client, String userName) throws RemoteException {
        this.Client = Client;
        this.userName = userName;
        controller = new TransaksiJualObatController(this.Client);
        initComponents();
      //  controller.getIdObat(this);
        Date date = new Date();
        dateOfSales.setDate(date);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        dateOfSales = new com.toedter.calendar.JDateChooser();
        fieldDescription = new javax.swing.JTextField();
        fieldIdOfSales = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Quantity = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        IdObat = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableOfSales = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jSpinField1 = new com.toedter.components.JSpinField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Carisma Project");
        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        dateOfSales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        dateOfSales.setDateFormatString("yyyy-MM-dd");
        dateOfSales.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        fieldDescription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fieldDescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));

        fieldIdOfSales.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fieldIdOfSales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        fieldIdOfSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIdOfSalesActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tanggal");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Id Transaksi Jual Obat");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Keterangan");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));

        Quantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Quantity.setText("Qty");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ID Obat");

        IdObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdObatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldIdOfSales, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateOfSales, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Quantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(fieldDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addGap(60, 60, 60)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(IdObat, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addComponent(IdObat, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fieldDescription))
                    .addComponent(fieldIdOfSales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateOfSales, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(Quantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(614, 614, 614))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 170, 1350, 158);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaapoteker/image/1426717487_save.png"))); // NOI18N
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1090, 640, 100, 40);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Apoteker :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 110, 94, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaapoteker/image/1426717770_circle_close_delete-24.png"))); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(980, 640, 100, 40);

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("TRANSAKSI PENJUALAN OBAT");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 40, 500, 47);

        jTableOfSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Obat", "Nama Obat", "Quantity"
            }
        ));
        jTableOfSales.setDragEnabled(true);
        jTableOfSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOfSalesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableOfSales);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 340, 1320, 402);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaapoteker/image/background2.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(4, 4, 1370, 740);
        getContentPane().add(jSpinField1);
        jSpinField1.setBounds(10, 130, 120, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = jTableOfSales.getSelectedRow();

        //total = total - jumlah;
        tableOfSales = (DefaultTableModel) jTableOfSales.getModel();
        tableOfSales.removeRow(row);
        jTableOfSales.setModel(tableOfSales);

        //fieldTotal.setText(String.valueOf(total));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if ((fieldIdOfSales.getText().equals("")||fieldDescription.getText().equals(""))){
            JOptionPane.showMessageDialog(null, "Field yang anda isi tidak lengkap","Peringatan",JOptionPane.WARNING_MESSAGE);
        }
        else{
            try {
                TransaksiJualObatController transaksijual = new TransaksiJualObatController(Client);
                transaksijual.insertTransaksijualobat(fieldIdOfSales.getText(), String.valueOf (new java.sql.Date(dateNow.getTime())), fieldDescription.getText());
               //int row = jTableOfSales.getSelectedRow();
                System.out.println("jumlah baris keisi "+jTableOfSales.getSelectedColumnCount());
                
                for (int i = 0; i < jTableOfSales.getSelectedRowCount(); i++) {
                    String idObat = String.valueOf(jTableOfSales.getValueAt(i, 0));
                    String quantity = String.valueOf(jTableOfSales.getValueAt(i, 2));
                    transaksijual.insertDetailtransaksijualobat(fieldIdOfSales.getText(), Integer.parseInt(idObat), Integer.parseInt(quantity));
                }
                
                JOptionPane.showMessageDialog(null, "Data Transaksi Penjualan Obat Tersimpan","Pemberitahuan",JOptionPane.INFORMATION_MESSAGE);
                
            } catch (Exception e) {
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void IdObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdObatActionPerformed
       DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < IdObat.getModel().getSize(); i++) {
            Object item = IdObat.getModel().getElementAt(i);
            model.addElement(item.toString());
        }
       // int obat = IdObat.getSelectedItem();
       // model.addElement(obat);
        
        
    }//GEN-LAST:event_IdObatActionPerformed

    private void fieldIdOfSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldIdOfSalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldIdOfSalesActionPerformed

    private void jTableOfSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOfSalesMouseClicked
        int column = jTableOfSales.getSelectedColumn();
        if (column == 0) {
            try {
                new TabelObat(this, Client).setVisible(true);
            } catch (RemoteException ex) {
                Logger.getLogger(TransaksiJualObat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTableOfSalesMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox IdObat;
    private javax.swing.JLabel Quantity;
    private com.toedter.calendar.JDateChooser dateOfSales;
    private javax.swing.JTextField fieldDescription;
    private javax.swing.JTextField fieldIdOfSales;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.components.JSpinField jSpinField1;
    public javax.swing.JTable jTableOfSales;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
