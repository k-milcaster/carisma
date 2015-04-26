package carismaresepsionis.boundaries;

import carismainterface.server.DokterService;
import carismainterface.server.PasienService;
import carismainterface.entity.Dokter;
import carismaresepsionis.controller.AntrianController;
import carismaresepsionis.controller.ClientSocket;
import carismaresepsionis.controller.RawatinapController;
import java.rmi.RemoteException;
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

    public Menursepsionis(ClientSocket client, String userName) throws RemoteException {
        this.client = client;
        this.userName = userName;
        AntrianController control = new AntrianController(this.client);
        ps = client.getPasienService();
        initComponents();
        control.getAntrian(this);       
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
        jButton5 = new javax.swing.JButton();
        List_Antrian = new javax.swing.JComboBox();
        RegisPasienReg = new javax.swing.JButton();
        RegisPasienInap = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        DataDokter = new javax.swing.JButton();
        LihatPasienInap = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        Namanya = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

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
        tableDaftarAntrian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDaftarAntrianMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDaftarAntrian);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 100, 1072, 402);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1428228446_ok.png"))); // NOI18N
        jButton5.setText("Ok");
        getContentPane().add(jButton5);
        jButton5.setBounds(376, 559, 110, 50);

        List_Antrian.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Kategori -", "Dokter Umum", "Dokter Anak", "Dokter THT", "Dokter Mata", "Dokter " }));
        List_Antrian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                List_AntrianActionPerformed(evt);
            }
        });
        getContentPane().add(List_Antrian);
        List_Antrian.setBounds(20, 559, 350, 50);

        RegisPasienReg.setText("Registrasi Pasien Reguler");
        RegisPasienReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisPasienRegActionPerformed(evt);
            }
        });
        getContentPane().add(RegisPasienReg);
        RegisPasienReg.setBounds(1120, 100, 225, 50);

        RegisPasienInap.setText("Registrasi Pasien Rawat Inap");
        RegisPasienInap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisPasienInapActionPerformed(evt);
            }
        });
        getContentPane().add(RegisPasienInap);
        RegisPasienInap.setBounds(1120, 160, 225, 50);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1428228543_unlock.png"))); // NOI18N
        jButton3.setText("Log Out");
        getContentPane().add(jButton3);
        jButton3.setBounds(1220, 340, 120, 50);

        DataDokter.setText("Data Dokter");
        DataDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataDokterActionPerformed(evt);
            }
        });
        getContentPane().add(DataDokter);
        DataDokter.setBounds(1120, 280, 225, 50);

        LihatPasienInap.setText("Lihat Pasien Rawat Inap");
        LihatPasienInap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LihatPasienInapActionPerformed(evt);
            }
        });
        getContentPane().add(LihatPasienInap);
        LihatPasienInap.setBounds(1120, 220, 225, 50);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(174, 517, 334, 36);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nama Dokter");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 520, 150, 34);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1428222513_icon-ios7-plus-outline-32.png"))); // NOI18N
        jButton7.setText("Tambah");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(840, 510, 120, 40);

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1426717770_circle_close_delete-24.png"))); // NOI18N
        jButton9.setText("Hapus");
        getContentPane().add(jButton9);
        jButton9.setBounds(970, 510, 120, 40);

        Namanya.setText("Salma Indridinnanti");
        getContentPane().add(Namanya);
        Namanya.setBounds(80, 60, 296, 34);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nama ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 70, 56, 20);

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Menu Resepsionis");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 0, 290, 60);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background2.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 1400, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DataDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataDokterActionPerformed
        try {
            new dokterform(this.client, this.userName).show();
        } catch (RemoteException ex) {
            Logger.getLogger(Menursepsionis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DataDokterActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String a = JOptionPane.showInputDialog("Masukkan Nama Pasien", "");

    }//GEN-LAST:event_jButton7ActionPerformed

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
            control = new RawatinapController(this.client);
            String a = "coba";
            //control.kamarKosong(a);
            if (control.kamarKosong(a).equals("kosong")) {

                //if (tampilUser().equals("benar") && tampilPass() == true) {
                new Rawatinap(this.client, this.userName).show();
                this.dispose();
                //} else {
                // JOptionPane.showMessageDialog(null, "TERJADI ERROR \n Username atau Password Salah", "ERROR!", JOptionPane.ERROR_MESSAGE);
                //}
            } else {
                JOptionPane.showMessageDialog(null, "MAAF!! \n Kamar Rawat Inap Penuh", "ERROR!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Menursepsionis.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_RegisPasienInapActionPerformed

    private void LihatPasienInapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LihatPasienInapActionPerformed

        new DaftarRawatInap(this.client, this.userName).show();

    }//GEN-LAST:event_LihatPasienInapActionPerformed

    private void List_AntrianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_List_AntrianActionPerformed
    }//GEN-LAST:event_List_AntrianActionPerformed

    private void tableDaftarAntrianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDaftarAntrianMouseClicked
        int row = tableDaftarAntrian.getSelectedRow();
        try {
            new lihatantrian(client, userName, String.valueOf(tableDaftarAntrian.getValueAt(row, 1))).setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(Menursepsionis.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_tableDaftarAntrianMouseClicked

    private void NamaDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaDokterActionPerformed
        
    }//GEN-LAST:event_NamaDokterActionPerformed

    private void NamanyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamanyaActionPerformed
        
    }//GEN-LAST:event_NamanyaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DataDokter;
    private javax.swing.JButton LihatPasienInap;
    private javax.swing.JComboBox List_Antrian;
    private javax.swing.JTextField Namanya;
    private javax.swing.JButton RegisPasienInap;
    private javax.swing.JButton RegisPasienReg;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JTable tableDaftarAntrian;
    // End of variables declaration//GEN-END:variables
}
