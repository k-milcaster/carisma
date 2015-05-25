package carismaapoteker.boundaries;

import carismaapoteker.controller.ClientSocket;
import carismaapoteker.controller.TransaksiBeliObatController;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TransaksiBeliObatBaru extends javax.swing.JFrame {

    private ClientSocket client;
    private TransaksiBeliObat ui;
    private DefaultTableModel tabel = new DefaultTableModel();
    private TransaksiBeliObatController transaksiBeliController;

    public TransaksiBeliObatBaru(ClientSocket client, TransaksiBeliObat ui) throws RemoteException {
        this.client = client;
        this.ui = ui;
        initComponents();
        transaksiBeliController = new TransaksiBeliObatController(this.client);
        setLocationRelativeTo(this);
    }

    public void reset() {
        fieldNamaObat.setText("");
        fieldJenisObat.setText("");
        fieldKeterangan.setText("");
        fieldHarga.setText("");
        fieldStokKritis.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        fieldStokKritis = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fieldNamaObat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fieldJenisObat = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldQuantity = new javax.swing.JTextField();
        fieldKeterangan = new javax.swing.JTextField();
        fieldHarga = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Carisma");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Obat", "Qty Obat", "Jenis Obat", "Keterangan", "Harga Jual", "Stok Kritis"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 622, 227));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaapoteker/image/1426717487_save.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 510, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Insert Obat Baru", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 18))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Jenis Obat");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaapoteker/image/1429342283_519691-199_CircledPlus-12.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        fieldStokKritis.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fieldStokKritis.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        fieldStokKritis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldStokKritisKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Harga Jual");

        fieldNamaObat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fieldNamaObat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Qty Obat");

        fieldJenisObat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fieldJenisObat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nama Obat");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Stok Kritis");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Keterangan");

        fieldQuantity.setEditable(false);
        fieldQuantity.setBackground(new java.awt.Color(255, 255, 255));
        fieldQuantity.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fieldQuantity.setText("0");
        fieldQuantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        fieldKeterangan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fieldKeterangan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        fieldHarga.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fieldHarga.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        fieldHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldHargaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fieldJenisObat, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldQuantity, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldNamaObat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(2, 2, 2))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fieldHarga, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldKeterangan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldStokKritis, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(36, 36, 36))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldStokKritis, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldNamaObat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldJenisObat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 220));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaapoteker/image/Background Insert Obat.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (fieldNamaObat.getText().equals("") || fieldJenisObat.getText().equals("") || fieldHarga.getText().equals("") || fieldStokKritis.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data Obat Belum Lengkap", "Obat", JOptionPane.INFORMATION_MESSAGE);
        } else {
            tabel = (DefaultTableModel) jTable1.getModel();
            tabel.addRow(new Object[]{fieldNamaObat.getText(), fieldQuantity.getText(), fieldJenisObat.getText(), fieldKeterangan.getText(), fieldHarga.getText(), fieldStokKritis.getText()});
            jTable1.setModel(tabel);
            reset();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            int row = jTable1.getRowCount();
            transaksiBeliController = new TransaksiBeliObatController(this.client);
            for (int i = 0; i < row; i++) {
                ui.TambahCombo(String.valueOf(transaksiBeliController.getidObat()) + " " + jTable1.getValueAt(i, 0));
                transaksiBeliController.insertStokObat(transaksiBeliController.getidObat(), String.valueOf(jTable1.getValueAt(i, 0)), Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 1))), String.valueOf(jTable1.getValueAt(i, 2)), String.valueOf(jTable1.getValueAt(i, 3)), Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 4))), Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 5))));
            }
            JOptionPane.showMessageDialog(null, "Data Obat Sudah Tersimpan", "Obat", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void fieldHargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldHargaKeyTyped
        typeOnlyNumber(evt);
    }//GEN-LAST:event_fieldHargaKeyTyped

    private void fieldStokKritisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldStokKritisKeyTyped
        typeOnlyNumber(evt);
    }//GEN-LAST:event_fieldStokKritisKeyTyped
     public void typeOnlyNumber(KeyEvent evt){
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)||c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE){
            getToolkit().beep();
            evt.consume();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fieldHarga;
    private javax.swing.JTextField fieldJenisObat;
    private javax.swing.JTextField fieldKeterangan;
    private javax.swing.JTextField fieldNamaObat;
    private javax.swing.JTextField fieldQuantity;
    private javax.swing.JTextField fieldStokKritis;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
