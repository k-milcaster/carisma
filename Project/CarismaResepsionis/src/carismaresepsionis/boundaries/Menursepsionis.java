package carismaresepsionis.boundaries;

//import carismainterface.server.DokterService;
import carismainterface.server.*;
import carismainterface.entity.*;
import carismaresepsionis.controller.AntrianController;
import carismaresepsionis.controller.ClientSocket;
import carismaresepsionis.controller.RawatinapController;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author devan
 */
public class Menursepsionis extends javax.swing.JFrame {

    private ClientSocket client;
    private String userName;
    private PasienService ps;
    private DefaultTableModel tableAntri = new DefaultTableModel();
    private KamarService kamarService;
    
    public Menursepsionis(ClientSocket client, String userName) throws RemoteException {
        this.client = client;
        this.userName = userName;
        AntrianController control = new AntrianController(this.client);
        ps = client.getPasienService();
        kamarService = client.getKamarService();
        initComponents();
        tableAntri = control.getAntrian();
        tableDaftarAntrian.setModel(tableAntri);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        Namanya.setEditable(false);
        Namanya.setText(String.valueOf(this.userName));
        
        

        

        //   tanggalkustom();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableDaftarAntrian = new javax.swing.JTable();
        RegisPasienReg = new javax.swing.JButton();
        RegisPasienInap = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        DataDokter = new javax.swing.JButton();
        LihatPasienInap = new javax.swing.JButton();
        buttonTambahAntrian = new javax.swing.JButton();
        buttonHapusAntrian = new javax.swing.JButton();
        Namanya = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonLihatAntrian = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableDaftarAntrian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Daftar Antrian"
            }
        ));
        jScrollPane1.setViewportView(tableDaftarAntrian);

        RegisPasienReg.setText("Registrasi Pasien Reguler");
        RegisPasienReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisPasienRegActionPerformed(evt);
            }
        });

        RegisPasienInap.setText("Registrasi Pasien Rawat Inap");
        RegisPasienInap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisPasienInapActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1428228543_unlock.png"))); // NOI18N
        jButton3.setText("Log Out");

        DataDokter.setText("Data Dokter");
        DataDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataDokterActionPerformed(evt);
            }
        });

        LihatPasienInap.setText("Lihat Pasien Rawat Inap");
        LihatPasienInap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LihatPasienInapActionPerformed(evt);
            }
        });

        buttonTambahAntrian.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonTambahAntrian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1428222513_icon-ios7-plus-outline-32.png"))); // NOI18N
        buttonTambahAntrian.setText("Tambah");
        buttonTambahAntrian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahAntrianActionPerformed(evt);
            }
        });

        buttonHapusAntrian.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonHapusAntrian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1426717770_circle_close_delete-24.png"))); // NOI18N
        buttonHapusAntrian.setText("Hapus");
        buttonHapusAntrian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusAntrianActionPerformed(evt);
            }
        });

        Namanya.setText("Salma Indridinnanti");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nama ");

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Menu Resepsionis");

        buttonLihatAntrian.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonLihatAntrian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1432134923_eye-32.png"))); // NOI18N
        buttonLihatAntrian.setText("Lihat Detail Antrian");
        buttonLihatAntrian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLihatAntrianActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(Namanya, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 21, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonHapusAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonTambahAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(buttonLihatAntrian))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1072, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RegisPasienReg, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RegisPasienInap, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LihatPasienInap, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DataDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Namanya, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RegisPasienReg, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(RegisPasienInap, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(LihatPasienInap, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(DataDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonLihatAntrian)
                    .addComponent(buttonTambahAntrian)
                    .addComponent(buttonHapusAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DataDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataDokterActionPerformed
        try {
            new dokterform(this.client, this.userName).show();
        } catch (RemoteException ex) {
            Logger.getLogger(Menursepsionis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DataDokterActionPerformed

    private void buttonTambahAntrianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahAntrianActionPerformed
        try {
            new regispasienform(client, userName).setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(Menursepsionis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonTambahAntrianActionPerformed

    private void RegisPasienRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisPasienRegActionPerformed
        try {
            new regispasienform(this.client, this.userName).show();
        } catch (RemoteException ex) {
            Logger.getLogger(Menursepsionis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RegisPasienRegActionPerformed

    private void RegisPasienInapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisPasienInapActionPerformed
        RawatinapController control;
        try {
            List<String> list = new ArrayList<String>();
            control = new RawatinapController(this.client);
            list = kamarService.getKamarAvailable();
            //control.kamarKosong(a);
            if (list.equals(null)) {

                
                //if (tampilUser().equals("benar") && tampilPass() == true) {
                JOptionPane.showMessageDialog(null, "MAAF!! \n Kamar Rawat Inap Penuh", "WARNING!", JOptionPane.ERROR_MESSAGE);
                
                //} else {
                // JOptionPane.showMessageDialog(null, "TERJADI ERROR \n Username atau Password Salah", "ERROR!", JOptionPane.ERROR_MESSAGE);
                //}
            } else {
                new Rawatinap(this.client, this.userName).show();
                this.dispose();
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Menursepsionis.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_RegisPasienInapActionPerformed

    private void LihatPasienInapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LihatPasienInapActionPerformed
        try {
            new DaftarRawatInap(this.client, this.userName).show();
        } catch (RemoteException ex) {
            Logger.getLogger(Menursepsionis.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_LihatPasienInapActionPerformed

    private void NamaDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaDokterActionPerformed
        
    }//GEN-LAST:event_NamaDokterActionPerformed

    private void NamanyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamanyaActionPerformed
        
    }//GEN-LAST:event_NamanyaActionPerformed

    private void buttonHapusAntrianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusAntrianActionPerformed
        int row = tableDaftarAntrian.getSelectedRow();
        try {
            AntrianController controller = new AntrianController(client);
            controller.deleteAntrian(String.valueOf(tableDaftarAntrian.getValueAt(row, 0)));
            tableAntri = (DefaultTableModel)tableDaftarAntrian.getModel();
            tableAntri.removeRow(row);
            tableDaftarAntrian.setModel(tableAntri);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_buttonHapusAntrianActionPerformed

    private void buttonLihatAntrianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLihatAntrianActionPerformed
        int row = tableDaftarAntrian.getSelectedRow();
        
        try {
            new lihatantrian(client, userName, String.valueOf(tableDaftarAntrian.getValueAt(row, 1))).setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(Menursepsionis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonLihatAntrianActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DataDokter;
    private javax.swing.JButton LihatPasienInap;
    private javax.swing.JTextField Namanya;
    private javax.swing.JButton RegisPasienInap;
    private javax.swing.JButton RegisPasienReg;
    private javax.swing.JButton buttonHapusAntrian;
    private javax.swing.JButton buttonLihatAntrian;
    private javax.swing.JButton buttonTambahAntrian;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tableDaftarAntrian;
    // End of variables declaration//GEN-END:variables
}
