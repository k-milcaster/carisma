package carismaresepsionis.boundaries;

import carismaresepsionis.controller.AntrianController;
import carismaresepsionis.controller.ClientSocket;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fiqhi Darmawan
 */
public class lihatantrian extends javax.swing.JFrame {

    private ClientSocket client;
    private String userName;

    public lihatantrian(ClientSocket client, String userName, String idAntrian) throws RemoteException {
        this.client = client;
        this.userName = userName;
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        AntrianController control = new AntrianController(this.client);

        String idPasien = String.valueOf(control.getAntrianDetail(idAntrian).getPasienIdPasien());
        NomorAntrian.setText(String.valueOf(control.getAntrianDetail(idAntrian).getNomorAntrian()));
        NamaPasien.setText(String.valueOf(control.getDetailPasien(idPasien).getNamaPasien()));
        AlamatPasien.setText(String.valueOf(control.getDetailPasien(idPasien).getAlamatPasien()));
        Goldar.setText(String.valueOf(control.getDetailPasien(idPasien).getDarahPasien()));
        Tinggi.setText(String.valueOf(control.getDetailPasien(idPasien).getTinggiPasien()));
        Berat.setText(String.valueOf(control.getDetailPasien(idPasien).getBeratPasien()));
        //TerakhirPeriksa.setText(control.tglTerakhirKunjungan(idPasien));
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        NomorAntrian = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        NamaPasien = new javax.swing.JTextField();
        AlamatPasien = new javax.swing.JTextField();
        Goldar = new javax.swing.JTextField();
        Tinggi = new javax.swing.JTextField();
        Berat = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TerakhirPeriksa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel1.setText("Antrian Pasien");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(55, 74, 295, 60);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel2.setText("Nomor Antrian");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(90, 0, 120, 40);

        NomorAntrian.setEditable(false);
        NomorAntrian.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        NomorAntrian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomorAntrianActionPerformed(evt);
            }
        });
        jPanel3.add(NomorAntrian);
        NomorAntrian.setBounds(20, 40, 250, 90);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(60, 150, 290, 150);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informasi Pasien", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 24), java.awt.Color.black)); // NOI18N
        jPanel10.setLayout(null);

        jLabel6.setText("Nama");
        jPanel10.add(jLabel6);
        jLabel6.setBounds(40, 60, 110, 14);

        jLabel7.setText("Alamat");
        jPanel10.add(jLabel7);
        jLabel7.setBounds(40, 120, 100, 14);

        jLabel8.setText("Golongan Darah");
        jPanel10.add(jLabel8);
        jLabel8.setBounds(40, 210, 130, 14);

        jLabel10.setText("Tinggi Badan");
        jPanel10.add(jLabel10);
        jLabel10.setBounds(40, 250, 100, 14);

        jLabel11.setText("Berat");
        jPanel10.add(jLabel11);
        jLabel11.setBounds(280, 250, 70, 14);

        NamaPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaPasienActionPerformed(evt);
            }
        });
        jPanel10.add(NamaPasien);
        NamaPasien.setBounds(160, 50, 390, 50);

        AlamatPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlamatPasienActionPerformed(evt);
            }
        });
        jPanel10.add(AlamatPasien);
        AlamatPasien.setBounds(160, 110, 390, 70);

        Goldar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoldarActionPerformed(evt);
            }
        });
        jPanel10.add(Goldar);
        Goldar.setBounds(160, 200, 60, 30);
        jPanel10.add(Tinggi);
        Tinggi.setBounds(160, 240, 60, 30);

        Berat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeratActionPerformed(evt);
            }
        });
        jPanel10.add(Berat);
        Berat.setBounds(350, 240, 60, 30);

        jLabel12.setText("Terakhir Periksa");
        jPanel10.add(jLabel12);
        jLabel12.setBounds(40, 290, 100, 14);

        TerakhirPeriksa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TerakhirPeriksaActionPerformed(evt);
            }
        });
        jPanel10.add(TerakhirPeriksa);
        TerakhirPeriksa.setBounds(160, 280, 210, 30);

        getContentPane().add(jPanel10);
        jPanel10.setBounds(380, 70, 810, 330);

        jButton1.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1426718664_circle_back_arrow_-24.png"))); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1200, 340, 90, 40);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background2.png"))); // NOI18N
        getContentPane().add(jLabel13);
        jLabel13.setBounds(0, 0, 1360, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NamaPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaPasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaPasienActionPerformed

    private void GoldarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoldarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GoldarActionPerformed

    private void BeratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeratActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BeratActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.dispose();
       try {
           Menursepsionis menu = new Menursepsionis(client, userName);
           menu.setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(lihatantrian.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TerakhirPeriksaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TerakhirPeriksaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TerakhirPeriksaActionPerformed

    private void AlamatPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlamatPasienActionPerformed
       
    }//GEN-LAST:event_AlamatPasienActionPerformed

    private void NomorAntrianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomorAntrianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomorAntrianActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AlamatPasien;
    private javax.swing.JTextField Berat;
    private javax.swing.JTextField Goldar;
    private javax.swing.JTextField NamaPasien;
    private javax.swing.JTextField NomorAntrian;
    private javax.swing.JTextField TerakhirPeriksa;
    private javax.swing.JTextField Tinggi;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
