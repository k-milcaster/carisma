package carismaapoteker.boundaries;

import carismaapoteker.controller.ClientSocket;
import carismaapoteker.controller.TransaksiJualObatController;
import java.awt.HeadlessException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sinta Eka Lestari
 */
public class TransaksiJualObat extends javax.swing.JFrame {

    private ClientSocket Client;
    private String userName;
    private DefaultTableModel tableOfSales;
    private TransaksiJualObatController transaksijualobatController;
    String[] namaPegawai;
    private int total = 0;
    public int row = 0;
    java.util.Date dateNow = new java.util.Date();

    public TransaksiJualObat(ClientSocket Client, String userName) throws RemoteException {
        this.Client = Client;
        this.userName = userName;
        initComponents();
        dateOfSales.setDate(dateNow);
        transaksijualobatController = new TransaksiJualObatController(Client);
        fieldIdOfSales.setText(transaksijualobatController.getIdTransaksiJualObat());
        labelAoptekerName.setText(this.userName);
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    public void clearField() {
        fieldDescription.setText("");
        fieldKunjungan.setText("");
        int row = jTableOfSales.getRowCount();
        for (int i = 0; i < row; i++) {
            tableOfSales = (DefaultTableModel) jTableOfSales.getModel();
            tableOfSales.setValueAt("", i, 0);
            tableOfSales.setValueAt("", i, 1);
            tableOfSales.setValueAt("", i, 2);
            jTableOfSales.setModel(tableOfSales);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        dateOfSales = new com.toedter.calendar.JDateChooser();
        fieldDescription = new javax.swing.JTextField();
        fieldIdOfSales = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fieldKunjungan = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        labelAoptekerName = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableOfSales = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        fieldIdOfSales.setEditable(false);
        fieldIdOfSales.setBackground(new java.awt.Color(255, 255, 255));
        fieldIdOfSales.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fieldIdOfSales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tanggal");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Id Transaksi Jual Obat");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Keterangan");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Id Kunjungan");

        fieldKunjungan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fieldKunjungan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        fieldKunjungan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldKunjunganActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10)
                        .addComponent(fieldKunjungan, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(23, 23, 23)
                        .addComponent(fieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldKunjungan, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addComponent(jLabel8))
                    .addComponent(fieldIdOfSales))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateOfSales, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(458, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 170, 1340, 158);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaapoteker/image/1426717487_save.png"))); // NOI18N
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1250, 650, 100, 40);

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel7.setText("Apoteker :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 130, 79, 29);

        labelAoptekerName.setBackground(new java.awt.Color(0, 0, 0));
        labelAoptekerName.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        labelAoptekerName.setText("\n");
        labelAoptekerName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, labelAoptekerName, org.jdesktop.beansbinding.ObjectProperty.create(), labelAoptekerName, org.jdesktop.beansbinding.BeanProperty.create("labelFor"));
        bindingGroup.addBinding(binding);

        getContentPane().add(labelAoptekerName);
        labelAoptekerName.setBounds(110, 130, 176, 26);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaapoteker/image/1426717770_circle_close_delete-24.png"))); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1140, 650, 100, 40);

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
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
        jTableOfSales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableOfSalesKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTableOfSales);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 340, 1320, 300);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaapoteker/image/background2.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 1360, 700);
        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(580, 110, 5, 5);
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(110, 134, 146, 20);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = jTableOfSales.getSelectedRow();
        tableOfSales.removeRow(row);
        jTableOfSales.setModel(tableOfSales);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (fieldIdOfSales.getText().equals("") || fieldDescription.getText().equals("") || fieldKunjungan.getText().equals("--")) {
            JOptionPane.showMessageDialog(null, "Field yang Anda Isi Kurang Lengkap", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                boolean testKunjungan = transaksijualobatController.cekKunjungan(fieldKunjungan.getText());
                if (testKunjungan) {
                    boolean inserted1 = transaksijualobatController.insertTransaksijualobat(fieldIdOfSales.getText(), String.valueOf(new java.sql.Date(dateNow.getTime())), fieldDescription.getText());
                    int row = jTableOfSales.getSelectedRow() + 1;
                    System.out.println(row);
                    boolean inserted2 = false;
                    boolean updated = false;
                    for (int i = 0; i < row; i++) {
                        inserted2 = transaksijualobatController.insertDetailtransaksijualobat(fieldIdOfSales.getText(), Integer.parseInt(String.valueOf(jTableOfSales.getValueAt(i, 0))), Integer.parseInt(String.valueOf(jTableOfSales.getValueAt(i, 2))));
                        updated = transaksijualobatController.updateStokObat(Integer.parseInt(String.valueOf(jTableOfSales.getValueAt(i, 0))), Integer.parseInt(String.valueOf(jTableOfSales.getValueAt(i, 2))));
                    }
                    if (inserted1 == true && inserted2 == true && updated == true) {
                        JOptionPane.showMessageDialog(null, "Data Penjualan Obat Telah Tersimpan","Transaksi Penjualan Obat",JOptionPane.INFORMATION_MESSAGE);
                    }
                    transaksijualobatController.updateKunjungan(fieldIdOfSales.getText(), fieldKunjungan.getText());
                    clearField();
                    fieldIdOfSales.setText(transaksijualobatController.getIdTransaksiJualObat());
                } else {
                    JOptionPane.showMessageDialog(null, "ID Kunjungan tidak ditemukan", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (RemoteException | HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Bermasalah", e.toString(), JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableOfSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOfSalesMouseClicked
        int colom = jTableOfSales.getSelectedColumn();
        row = jTableOfSales.getSelectedRow();
        if (colom == 0) {
            try {
                new TabelObat(this, Client).setVisible(true);
            } catch (RemoteException ex) {
                Logger.getLogger(TransaksiJualObat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTableOfSalesMouseClicked

    private void jTableOfSalesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableOfSalesKeyReleased
        try {
            int coloumn = jTableOfSales.getSelectedColumn();
            int row = jTableOfSales.getSelectedRow();
            if (coloumn == 2) {
                int qty = Integer.parseInt(String.valueOf(jTableOfSales.getValueAt(row, coloumn)));
                TransaksiJualObatController control = new TransaksiJualObatController(Client);
                int stock = control.cekStok(Integer.parseInt(String.valueOf(jTableOfSales.getValueAt(row, 0)))).getQtyObat();
                System.out.println(stock);
                if (stock < qty) {
                    JOptionPane.showMessageDialog(null, "Stok Obat Tidak Cukup!!!");
                }
            }
        } catch (Exception e) {
            System.out.println("Through Catch (there is an error when checking stok obat) "+e);
        }
    }//GEN-LAST:event_jTableOfSalesKeyReleased

    private void fieldKunjunganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldKunjunganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldKunjunganActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateOfSales;
    private javax.swing.JTextField fieldDescription;
    private javax.swing.JTextField fieldIdOfSales;
    private javax.swing.JTextField fieldKunjungan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jTableOfSales;
    private javax.swing.JLabel labelAoptekerName;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
