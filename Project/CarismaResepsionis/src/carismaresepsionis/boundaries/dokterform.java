package carismaresepsionis.boundaries;

import carismaresepsionis.controller.ClientSocket;
import carismainterface.entity.Dokter;
import carismainterface.entity.Poli;
import carismainterface.entity.Jadwaldokter;
import carismainterface.server.*;
import carismaresepsionis.controller.*;
import java.awt.Color;
import java.awt.Font;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Fiqhi Darmawan, Anes Dirsi
 */
public class dokterform extends javax.swing.JFrame {
    private ClientSocket client;
    private String userName;
    private DokterService ds;
    private DefaultTableModel tabeldokter = new DefaultTableModel();
    private DataDokterController DataDokterController;
    settergetter simpanan = new settergetter();
//    String a, b, c, d, e, f, g, h, i;
    
    public dokterform(ClientSocket client, String userName) throws RemoteException {
        this.client = client;
        DataDokterController control = new DataDokterController(this.client);
        ds = client.getDokterService();
        this.userName = userName;
        initComponents();
        setLocationRelativeTo(this);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        control.getNamaDokter();
        
//        TabelDokter.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//
//            public void valueChanged(ListSelectionEvent e) {
//                int row = TabelDokter.getSelectedRow();
//                if (row != -1) {
//                    try {
//                        Dokter selected = new Dokter(ds.getDokter(TabelDokter.getValueAt(row, 0).toString()));
//                        IdDokter.setText(selected.getIdDokter().toString());
//                        NamaDokter.setText(selected.getNamaDokter());                       
//                    } catch (RemoteException ex) {
//                        Logger.getLogger(dokterform.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
//        });
//        
//        a = NamaDokter.getText();
//        b = NamaPoli.getText();
//        c = TempatlahirDokter.getText();
//        d = AlamatDokter.getText();
//        e = TelpDokter.getText();
//        f = Hp1Dokter.getText();
//        g = Hp2Dokter.getText();
//        h = IdDokter.getText();
//        i = FotoDokter.getText();
//        
//        Date tanggal = new Date();
//        TgllahirDokter.setDate(tanggal);
//       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        CariNamaDokter = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelDokter = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        NamaDokter = new javax.swing.JTextField();
        NamaPoli = new javax.swing.JTextField();
        AlamatDokter = new javax.swing.JTextField();
        Hp1Dokter = new javax.swing.JTextField();
        TelpDokter = new javax.swing.JTextField();
        Hp2Dokter = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        FotoDokter = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        LihatJadwalDokter = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        IdDokter = new javax.swing.JTextField();
        TglLahirDokter = new javax.swing.JTextField();
        JenisKelaminDokter = new javax.swing.JTextField();
        TempatLahirDokter = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        CariNamaDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariNamaDokterActionPerformed(evt);
            }
        });
        CariNamaDokter.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CariNamaDokterFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                CariNamaDokterFocusLost(evt);
            }
        });
        CariNamaDokter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CariNamaDokterKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Cari");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(CariNamaDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(CariNamaDokter, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(50, 130, 225, 40);

        TabelDokter.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Dokter", "Nama Dokter"
            }
        ));
        TabelDokter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelDokterMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelDokter);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 180, 490, 460);

        jLabel1.setFont(new java.awt.Font("Trajan Pro", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data Dokter");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 40, 440, 49);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel5.setText("Informasi Dokter");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(20, 10, 190, 27);

        jLabel6.setText("Nama Dokter");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(20, 100, 190, 14);

        jLabel7.setText("Poli");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(20, 140, 190, 14);

        jLabel8.setText("Tempat Lahir");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(20, 180, 80, 14);

        jLabel9.setText("Tanggal Lahir");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(20, 220, 80, 14);

        jLabel10.setText("Jenis Kelamin");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(20, 260, 80, 14);

        jLabel11.setText("Alamat");
        jPanel4.add(jLabel11);
        jLabel11.setBounds(20, 310, 200, 14);

        jLabel12.setText("No. Telp");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(20, 350, 80, 14);

        jLabel13.setText("No. HP 1");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(20, 390, 260, 14);

        jLabel14.setText("No. HP 2");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(20, 430, 290, 14);

        NamaDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaDokterActionPerformed(evt);
            }
        });
        jPanel4.add(NamaDokter);
        NamaDokter.setBounds(110, 90, 271, 30);
        jPanel4.add(NamaPoli);
        NamaPoli.setBounds(110, 130, 271, 30);
        jPanel4.add(AlamatDokter);
        AlamatDokter.setBounds(110, 300, 272, 30);
        jPanel4.add(Hp1Dokter);
        Hp1Dokter.setBounds(110, 380, 272, 30);
        jPanel4.add(TelpDokter);
        TelpDokter.setBounds(110, 340, 272, 30);
        jPanel4.add(Hp2Dokter);
        Hp2Dokter.setBounds(110, 420, 272, 30);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setText("Foto Dokter");

        FotoDokter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(FotoDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FotoDokter, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.add(jPanel6);
        jPanel6.setBounds(400, 70, 159, 197);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1426718664_circle_back_arrow_-24.png"))); // NOI18N
        jButton2.setText("Back");
        jPanel4.add(jButton2);
        jButton2.setBounds(400, 390, 90, 40);

        LihatJadwalDokter.setText("Lihat Jadwal Prakter");
        LihatJadwalDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LihatJadwalDokterActionPerformed(evt);
            }
        });
        jPanel4.add(LihatJadwalDokter);
        LihatJadwalDokter.setBounds(400, 360, 150, 23);

        jLabel15.setText("Id Dokter");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(20, 60, 70, 14);
        jPanel4.add(IdDokter);
        IdDokter.setBounds(110, 52, 270, 30);

        TglLahirDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TglLahirDokterActionPerformed(evt);
            }
        });
        jPanel4.add(TglLahirDokter);
        TglLahirDokter.setBounds(110, 210, 110, 30);
        jPanel4.add(JenisKelaminDokter);
        JenisKelaminDokter.setBounds(110, 250, 50, 30);
        jPanel4.add(TempatLahirDokter);
        TempatLahirDokter.setBounds(110, 170, 270, 30);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(570, 180, 580, 460);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background2.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 1360, 700);

        jButton1.setText("jButton1");
        getContentPane().add(jButton1);
        jButton1.setBounds(1140, 400, 73, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CariNamaDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariNamaDokterActionPerformed
         if (evt.getSource() instanceof JTextField) {
            
        }
    }//GEN-LAST:event_CariNamaDokterActionPerformed

    private void TempatlahirDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TempatlahirDokterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TempatlahirDokterActionPerformed

    private void NamaDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaDokterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaDokterActionPerformed

    private void CariNamaDokterFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CariNamaDokterFocusGained
        if (CariNamaDokter.getText().equals("Cari Nama Dokter")) {
            CariNamaDokter.setText("");
        }
    }//GEN-LAST:event_CariNamaDokterFocusGained

    private void CariNamaDokterFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CariNamaDokterFocusLost
        if (CariNamaDokter.getText().equals("")) {
            CariNamaDokter.setText("Cari Nama Dokter");
            CariNamaDokter.setForeground(Color.gray);
            CariNamaDokter.setFont(new Font("Tahoma", 2, 12));
        }
    }//GEN-LAST:event_CariNamaDokterFocusLost

    private void CariNamaDokterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CariNamaDokterKeyReleased
        CariNamaDokter.setForeground(Color.black);
        CariNamaDokter.setFont(new Font("Tahoma", 0, 12));
        
        DefaultTableModel model = new DefaultTableModel();
        try {
            DataDokterController control = new DataDokterController(client);
            model = control.getDokterByName(CariNamaDokter.getText());
            System.out.println(model);
            TabelDokter.setModel(model);
        } catch (RemoteException ex) {
            Logger.getLogger(Rawatinap.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_CariNamaDokterKeyReleased

    private void TabelDokterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelDokterMouseClicked
            int row = TabelDokter.getSelectedRow();
        try {
            DataDokterController control = new DataDokterController(client);
            String[] infoDokter = control.getDokterByIdDokter(String.valueOf(TabelDokter.getValueAt(row, 0)));
            IdDokter.setText(infoDokter[0]);
            NamaDokter.setText(infoDokter[1]);
            NamaPoli.setText(infoDokter[2]);
            TempatLahirDokter.setText(infoDokter[3]);
            TglLahirDokter.setText(infoDokter[4]);
            JenisKelaminDokter.setText(infoDokter[5]);
            AlamatDokter.setText(infoDokter[6]);
            TelpDokter.setText(infoDokter[7]);
            Hp1Dokter.setText(infoDokter[8]);
            Hp2Dokter.setText(infoDokter[9]);

        } catch (RemoteException ex) {
            Logger.getLogger(dokterform.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }

    }//GEN-LAST:event_TabelDokterMouseClicked

    private void LihatJadwalDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LihatJadwalDokterActionPerformed
        try {
            new jadwaldokter(this.client, this.userName).show();
        } catch (RemoteException ex) {
            Logger.getLogger(dokterform.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LihatJadwalDokterActionPerformed

    private void TglLahirDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TglLahirDokterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TglLahirDokterActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AlamatDokter;
    private javax.swing.JTextField CariNamaDokter;
    private javax.swing.JLabel FotoDokter;
    private javax.swing.JTextField Hp1Dokter;
    private javax.swing.JTextField Hp2Dokter;
    private javax.swing.JTextField IdDokter;
    public javax.swing.JTextField JenisKelaminDokter;
    private javax.swing.JButton LihatJadwalDokter;
    private javax.swing.JTextField NamaDokter;
    private javax.swing.JTextField NamaPoli;
    public javax.swing.JTable TabelDokter;
    private javax.swing.JTextField TelpDokter;
    public javax.swing.JTextField TempatLahirDokter;
    public javax.swing.JTextField TglLahirDokter;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
