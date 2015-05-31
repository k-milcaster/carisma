package carismadokter.boundaries;

import carismadokter.controller.ClientSocket;
import carismadokter.controller.LihatRekamMedisController;
import carismadokter.controller.LoginController;
import carismainterface.server.PasienService;
import carismainterface.server.UserService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fiqhi Darmawan
 */
public class dokterlihatrekammedis extends javax.swing.JFrame {
    private ClientSocket client;
    private String userName;
    private PasienService ps;
    private DefaultTableModel tabelpasien = new DefaultTableModel();
    private LihatRekamMedisController LihatRekamMedisController;
    private UserService login;
    
    
    public dokterlihatrekammedis(ClientSocket client, final String userName) throws RemoteException {
        this.client = client;
        LihatRekamMedisController control = new LihatRekamMedisController(this.client);
        ps = client.getPasienService();        
        this.userName = userName;
        this.login = client.getUserService();
        initComponents();
        setLocationRelativeTo(this);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        TabelPasien.setModel(control.getPasienList());
        
        
                this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                LoginController log = new LoginController(login, userName);
                try {
                    log.logOut();
                } catch (RemoteException ex) {
                    Logger.getLogger(dokterlihatrekammedis.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        namaPasien = new javax.swing.JLabel();
        id_rekammedik = new javax.swing.JTextField();
        NamaDokter = new javax.swing.JTextField();
        NamaPasien = new javax.swing.JTextField();
        Tgl_Pemeriksaan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Keluhan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        PemeriksaanDokter = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        CariNamaPasien = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        AlergiObat = new javax.swing.JTextField();
        Kesimpulan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelPasien = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Pasien", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 14))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        jLabel12.setText("Nama");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(40, 60, 60, 16);

        jLabel13.setText("Jenis Kelamin");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(40, 110, 120, 16);

        jLabel14.setText("Umur");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(40, 160, 70, 16);

        jLabel15.setText("Alamat");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(40, 210, 70, 16);

        jLabel16.setText("jLabel16");
        jPanel4.add(jLabel16);
        jLabel16.setBounds(330, 60, 100, 16);

        jLabel17.setText("jLabel17");
        jPanel4.add(jLabel17);
        jLabel17.setBounds(330, 110, 110, 16);
        jPanel4.add(jTextField9);
        jTextField9.setBounds(120, 50, 182, 30);
        jPanel4.add(jTextField10);
        jTextField10.setBounds(120, 100, 182, 31);
        jPanel4.add(jTextField11);
        jTextField11.setBounds(120, 150, 180, 30);

        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField12);
        jTextField12.setBounds(120, 200, 180, 30);
        jPanel4.add(jTextField13);
        jTextField13.setBounds(390, 50, 210, 30);
        jPanel4.add(jTextField14);
        jTextField14.setBounds(390, 100, 210, 30);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Daftar Riwayat dan Rekam Medis Pasien", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18))); // NOI18N
        jPanel1.setLayout(null);

        namaPasien.setText("Id RM");
        jPanel1.add(namaPasien);
        namaPasien.setBounds(40, 100, 33, 16);
        jPanel1.add(id_rekammedik);
        id_rekammedik.setBounds(150, 80, 180, 40);
        jPanel1.add(NamaDokter);
        NamaDokter.setBounds(150, 130, 180, 40);

        NamaPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaPasienActionPerformed(evt);
            }
        });
        jPanel1.add(NamaPasien);
        NamaPasien.setBounds(150, 180, 180, 40);
        jPanel1.add(Tgl_Pemeriksaan);
        Tgl_Pemeriksaan.setBounds(150, 230, 180, 40);

        jLabel2.setText("Dokter");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 150, 80, 16);

        jLabel3.setText("Nama Pasien");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 190, 80, 16);

        jLabel4.setText("Tgl Pemeriksaan");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 240, 100, 16);
        jPanel1.add(Keluhan);
        Keluhan.setBounds(480, 80, 160, 40);

        jLabel5.setText("Keluhan");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(361, 100, 90, 16);
        jPanel1.add(PemeriksaanDokter);
        PemeriksaanDokter.setBounds(480, 130, 160, 40);

        jLabel6.setText("Pemeriksaan Dokter");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(361, 140, 120, 16);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        CariNamaPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariNamaPasienActionPerformed(evt);
            }
        });
        CariNamaPasien.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CariNamaPasienFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                CariNamaPasienFocusLost(evt);
            }
        });
        CariNamaPasien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CariNamaPasienKeyReleased(evt);
            }
        });

        jLabel9.setText("Cari");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CariNamaPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(CariNamaPasien, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(90, 30, 150, 40);

        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(250, 30, 140, 40);
        jPanel1.add(AlergiObat);
        AlergiObat.setBounds(480, 180, 160, 40);
        jPanel1.add(Kesimpulan);
        Kesimpulan.setBounds(480, 230, 160, 40);

        jLabel10.setText("Alergi Obat");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(360, 190, 64, 16);

        jLabel18.setText("Kesimpulan");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(360, 240, 100, 16);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(140, 80, 680, 290);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("jLabel8");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(860, 80, 150, 200);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TabelPasien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id Pasien", "Nama Pasien"
            }
        ));
        TabelPasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPasienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelPasien);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(140, 430, 780, 260);

        jLabel7.setFont(new java.awt.Font("Trajan Pro", 1, 36)); // NOI18N
        jLabel7.setText("Data Pasien");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(140, 390, 600, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismadokter/image/1426718664_circle_back_arrow_-24.png"))); // NOI18N
        jButton1.setText("Back");
        getContentPane().add(jButton1);
        jButton1.setBounds(930, 650, 90, 40);

        jLabel11.setFont(new java.awt.Font("Trajan Pro", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Rekam Medis Pasien");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(140, 40, 420, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismadokter/image/background2.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1360, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void NamaPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaPasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaPasienActionPerformed

    private void CariNamaPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariNamaPasienActionPerformed
        if (evt.getSource() instanceof JTextField) {

        }
    }//GEN-LAST:event_CariNamaPasienActionPerformed

    private void CariNamaPasienFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CariNamaPasienFocusGained
        if (CariNamaPasien.getText().equals("Cari Nama Pasien")) {
            CariNamaPasien.setText("");
        }
    }//GEN-LAST:event_CariNamaPasienFocusGained

    private void CariNamaPasienFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CariNamaPasienFocusLost
        if (CariNamaPasien.getText().equals("")) {
            CariNamaPasien.setText("Cari Nama Dokter");
            CariNamaPasien.setForeground(Color.gray);
            CariNamaPasien.setFont(new Font("Tahoma", 2, 12));
        }
    }//GEN-LAST:event_CariNamaPasienFocusLost

    private void CariNamaPasienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CariNamaPasienKeyReleased
        CariNamaPasien.setForeground(Color.black);
        CariNamaPasien.setFont(new Font("Tahoma", 0, 12));

        DefaultTableModel model = new DefaultTableModel();
        try {
            LihatRekamMedisController control = new LihatRekamMedisController(client);
            model = control.getPasienbyName(CariNamaPasien.getText());

            TabelPasien.setModel(model);
        } catch (RemoteException ex) {
            Logger.getLogger(dokterlihatrekammedis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CariNamaPasienKeyReleased

    private void TabelPasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPasienMouseClicked
//         int row = TabelPasien.getSelectedRow();
//        try {
//            LihatRekamMedisController control = new LihatRekamMedisController(client);
//            ArrayList infoRekammedik = control.getRekammedikById(String.valueOf(TabelPasien.getValueAt(row, 0)));
//            id_rekammedik.setText(infoRekammedik.get(0).toString());
//            NamaDokter.setText(infoRekammedik.get(1).toString());
//            NamaPasien.setText(infoRekammedik.get(2).toString());
//            Tgl_Pemeriksaan.setText(infoRekammedik.get(3).toString());
//            Keluhan.setText(infoRekammedik.get(4).toString());
//            PemeriksaanDokter.setText(infoRekammedik.get(5).toString());
//            AlergiObat.setText(infoRekammedik.get(6).toString());
//            Kesimpulan.setText(infoRekammedik.get(7).toString());
////            byte[] content = null;
////            content = (byte[]) infoRekammedik.get(10);
////            Image imgs = Toolkit.getDefaultToolkit().createImage(content);
////            ImageIcon icon = new ImageIcon(imgs);
////            FotoPasien.setIcon(icon);
//
//        } catch (RemoteException ex) {
//            Logger.getLogger(dokterlihatrekammedis.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println(ex);
//        }

    }//GEN-LAST:event_TabelPasienMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField AlergiObat;
    private javax.swing.JTextField CariNamaPasien;
    private javax.swing.JTextField Keluhan;
    public javax.swing.JTextField Kesimpulan;
    private javax.swing.JTextField NamaDokter;
    private javax.swing.JTextField NamaPasien;
    private javax.swing.JTextField PemeriksaanDokter;
    private javax.swing.JTable TabelPasien;
    private javax.swing.JTextField Tgl_Pemeriksaan;
    private javax.swing.JTextField id_rekammedik;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel namaPasien;
    // End of variables declaration//GEN-END:variables
}
