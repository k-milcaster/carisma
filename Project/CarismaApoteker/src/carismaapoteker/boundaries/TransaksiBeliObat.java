package carismaapoteker.boundaries;

import carismaapoteker.controller.ClientSocket;
import carismaapoteker.controller.TransaksiBeliObatController;
import carismainterface.server.DetailobatService;
import carismainterface.server.PegawaiService;
import carismainterface.server.TransaksibeliobatService;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class TransaksiBeliObat extends javax.swing.JFrame {

    private ClientSocket Client;
    private String userName;
    private DefaultTableModel tableTransaksiBeliObat = new DefaultTableModel();
    private DefaultComboBoxModel combo = new DefaultComboBoxModel();
    private PegawaiService pegawaiService;
    private String[] namaPegawai;
    private int total = 0;
    public int row = 0;

    public TransaksiBeliObat(ClientSocket Client, String userName) throws RemoteException {
        this.Client = Client;
        final TransaksiBeliObatController control = new TransaksiBeliObatController(this.Client);
        initComponents();
        this.userName = userName;
        jLabel8.setText(this.userName);
        combo = control.getIdObat();
        boxNamaObat.setModel(combo);
        Date dateNow = new Date();
        jDateChooser1.setDate(dateNow);
        setLocationRelativeTo(this);
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        fieldQuantity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fieldHargaBeli = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fieldKeterangan = new javax.swing.JTextArea();
        boxNamaObat = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableOfBuys = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Carisma");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Tanggal Beli Obat");

        jDateChooser1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        fieldQuantity.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fieldQuantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        fieldQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldQuantityKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Quantity");

        fieldHargaBeli.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fieldHargaBeli.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        fieldHargaBeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldHargaBeliKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Harga Beli");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Keterangan");

        fieldKeterangan.setColumns(20);
        fieldKeterangan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fieldKeterangan.setLineWrap(true);
        fieldKeterangan.setRows(5);
        fieldKeterangan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        jScrollPane1.setViewportView(fieldKeterangan);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Nama Obat");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Tanggal Kadaluarsa");

        jDateChooser2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaapoteker/image/1429342283_519691-199_CircledPlus-12.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaapoteker/image/1428222456_icon-compose-32.png"))); // NOI18N
        jButton3.setText("Obat Baru");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel13))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton2)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel11))
                                    .addGap(11, 11, 11)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(boxNamaObat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 10, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxNamaObat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(124, 124, 124))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, -1, -1));

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel7.setText("Apoteker :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 175, -1, 30));

        jLabel8.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 175, 200, 30));

        jTableOfBuys.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tanggal Beli Obat", "Id - Nama Obat", "Harga Beli", "Quantity", "Tanggal  Kadaluarsa", "Keterangan"
            }
        ));
        jScrollPane2.setViewportView(jTableOfBuys);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 223, 960, 410));

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("TRANSAKSI PEMBELIAN OBAT");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 59, -1, 47));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaapoteker/image/1426717487_save.png"))); // NOI18N
        jButton1.setText("SAVE");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 640, 100, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaapoteker/image/background2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            TransaksiBeliObatController control = new TransaksiBeliObatController(this.Client);
            tableTransaksiBeliObat = (DefaultTableModel) jTableOfBuys.getModel();
            int row = tableTransaksiBeliObat.getRowCount();
            for (int i = 0; i < row; i++) {
                String id = control.getIdTransaksiBeliObat();
                control.insertBeliObat(id, String.valueOf(jTableOfBuys.getValueAt(i, 0)), String.valueOf(jTableOfBuys.getValueAt(i, 5)), Integer.parseInt(String.valueOf(jTableOfBuys.getValueAt(i, 2))));
                control.insertDetailObat(control.getidDetailObat(), Integer.parseInt(String.valueOf(jTableOfBuys.getValueAt(i, 1))), String.valueOf(jTableOfBuys.getValueAt(i, 4)));
                control.insertDetailTransaksiBeliObat(id, Integer.parseInt(String.valueOf(jTableOfBuys.getValueAt(i, 1))), Integer.parseInt(String.valueOf(jTableOfBuys.getValueAt(i, 3))));
                control.updateStokObat(Integer.parseInt(String.valueOf(jTableOfBuys.getValueAt(i, 1))), Integer.parseInt(String.valueOf(jTableOfBuys.getValueAt(i, 3))));
            }
            JOptionPane.showMessageDialog(null, "Data Obat Sudah Tersimpan", "Obat", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception e) {
            System.out.println("Through Catch" + e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void reset() {
        fieldHargaBeli.setText("");
        fieldQuantity.setText("");
        fieldKeterangan.setText("");
        jDateChooser2.setDate(null);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TransaksiBeliObatController control;
        try {
            control = new TransaksiBeliObatController(this.Client);
            if (fieldHargaBeli.getText().equals("") || fieldQuantity.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Data Transaksi Belum Lengkap", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                tableTransaksiBeliObat = (DefaultTableModel) jTableOfBuys.getModel();
                String[] idObat = String.valueOf(boxNamaObat.getSelectedItem()).split(" ");
                tableTransaksiBeliObat.addRow(new Object[]{String.valueOf(new java.sql.Date(jDateChooser1.getDate().getTime())), Integer.parseInt(String.valueOf(idObat[0])), Integer.parseInt(fieldHargaBeli.getText()), Integer.parseInt(fieldQuantity.getText()), String.valueOf(new java.sql.Date(jDateChooser2.getDate().getTime())), fieldKeterangan.getText()});
                jTableOfBuys.setModel(tableTransaksiBeliObat);
                reset();
            }
        } catch (RemoteException ex) {
            Logger.getLogger(TransaksiBeliObat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            new TransaksiBeliObatBaru(Client, this).setVisible(true);
        } catch (Exception e) {
            Logger.getLogger(TransaksiBeliObat.class.getName()).log(Level.SEVERE, null, e);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void fieldHargaBeliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldHargaBeliKeyTyped
        typeOnlyNumber(evt);
    }//GEN-LAST:event_fieldHargaBeliKeyTyped

    private void fieldQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldQuantityKeyTyped
       typeOnlyNumber(evt);
    }//GEN-LAST:event_fieldQuantityKeyTyped
    
    public void typeOnlyNumber(KeyEvent evt){
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)||c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE){
            getToolkit().beep();
            evt.consume();
        }
    }
    
    public void TambahCombo(Object anobject) {
        combo.addElement(anobject);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox boxNamaObat;
    private javax.swing.JTextField fieldHargaBeli;
    private javax.swing.JTextArea fieldKeterangan;
    private javax.swing.JTextField fieldQuantity;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableOfBuys;
    // End of variables declaration//GEN-END:variables
}
