package carismadokter.boundaries;

import carismadokter.controller.ClientSocket;
import carismadokter.controller.LihatRekamMedisController;
import carismadokter.controller.LoginController;
import carismainterface.server.PasienService;
import carismainterface.server.RekammedikService;
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
import javax.swing.DefaultListModel;
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
    private DefaultTableModel tabelrekammedik;
    private DefaultListModel listObat;
    private DefaultListModel listPenyakit;
    private LihatRekamMedisController control;
    private UserService login;

    public dokterlihatrekammedis(ClientSocket client, final String userName) throws RemoteException {

        this.client = client;
        this.userName = userName;
        this.login = client.getUserService();
        control = new LihatRekamMedisController(this.client);
        initComponents();
        fieldDoctorName.setText(this.userName);
        this.setExtendedState(this.MAXIMIZED_BOTH);
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

        jPanel1 = new javax.swing.JPanel();
        namaPasien = new javax.swing.JLabel();
        fieldTanggal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        CariNamaPasien = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textAreaKeluhan = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        textAreaPemeriksaan = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        textAreaTerapi = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        textAreaAlergi = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        textAreaKesimpulan = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        textAreaKondisi = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listNamaObat = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        fieldDoctorName = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        listNamaPenyakit = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelRekammedik = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Pasien", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18))); // NOI18N

        namaPasien.setText("Tanggal Rekam Medik");

        jLabel2.setText("Keluhan Pasien");

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        CariNamaPasien.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        CariNamaPasien.setForeground(new java.awt.Color(204, 204, 204));
        CariNamaPasien.setText("Masukkan Id Pasien");
        CariNamaPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariNamaPasienActionPerformed(evt);
            }
        });
        CariNamaPasien.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CariNamaPasienFocusLost(evt);
            }
            public void focusGained(java.awt.event.FocusEvent evt) {
                CariNamaPasienFocusGained(evt);
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
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(CariNamaPasien, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(CariNamaPasien, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );

        textAreaKeluhan.setEditable(false);
        textAreaKeluhan.setColumns(20);
        textAreaKeluhan.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        textAreaKeluhan.setLineWrap(true);
        textAreaKeluhan.setRows(5);
        jScrollPane3.setViewportView(textAreaKeluhan);

        textAreaPemeriksaan.setEditable(false);
        textAreaPemeriksaan.setColumns(20);
        textAreaPemeriksaan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textAreaPemeriksaan.setLineWrap(true);
        textAreaPemeriksaan.setRows(5);
        jScrollPane4.setViewportView(textAreaPemeriksaan);

        jLabel10.setText("Pemeriksaan");

        textAreaTerapi.setEditable(false);
        textAreaTerapi.setColumns(20);
        textAreaTerapi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textAreaTerapi.setLineWrap(true);
        textAreaTerapi.setRows(5);
        jScrollPane5.setViewportView(textAreaTerapi);

        jLabel8.setText("Terapi");

        jLabel18.setText("Alergi Obat");

        textAreaAlergi.setEditable(false);
        textAreaAlergi.setColumns(20);
        textAreaAlergi.setLineWrap(true);
        textAreaAlergi.setRows(5);
        jScrollPane6.setViewportView(textAreaAlergi);

        textAreaKesimpulan.setEditable(false);
        textAreaKesimpulan.setColumns(20);
        textAreaKesimpulan.setLineWrap(true);
        textAreaKesimpulan.setRows(5);
        jScrollPane7.setViewportView(textAreaKesimpulan);

        jLabel3.setText("Kesimpulan");

        textAreaKondisi.setEditable(false);
        textAreaKondisi.setColumns(20);
        textAreaKondisi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textAreaKondisi.setLineWrap(true);
        textAreaKondisi.setRows(5);
        jScrollPane8.setViewportView(textAreaKondisi);

        jLabel4.setText("Kondisi Pasien");

        listNamaObat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(listNamaObat);

        jLabel5.setText("Obat");

        fieldDoctorName.setEditable(false);
        fieldDoctorName.setBackground(new java.awt.Color(255, 255, 255));
        fieldDoctorName.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N

        listNamaPenyakit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane9.setViewportView(listNamaPenyakit);

        jLabel6.setText("Penyakit");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namaPasien)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldTanggal)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane6)
                            .addComponent(jScrollPane7)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fieldDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fieldDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namaPasien))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel10))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(19, 19, 19))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel5)
                                        .addGap(35, 35, 35)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel6))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(140, 90, 860, 310);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TabelRekammedik.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Rekam Medis", "Id Dokter", "Nama Dokter", "Id Pasien", "Nama Pasien", "Tanggal", "Id Resep"
            }
        ));
        TabelRekammedik.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelRekammedikMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelRekammedik);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(140, 440, 860, 250);

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel7.setText("Daftar Rekam Medik Pasien");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(140, 390, 850, 50);

        jLabel11.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Rekam Medik Pasien");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(140, 40, 250, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismadokter/image/background2.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1360, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CariNamaPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariNamaPasienActionPerformed
        try {
            tabelrekammedik = control.getRekamMedik(CariNamaPasien.getText());
            TabelRekammedik.setModel(tabelrekammedik);
            CariNamaPasien.setText("");
        } catch (Exception e) {
            System.out.println("Through Catch " + e);
        }
    }//GEN-LAST:event_CariNamaPasienActionPerformed

    private void CariNamaPasienFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CariNamaPasienFocusGained
        if (CariNamaPasien.getText().equals("Masukkan Id Pasien")) {
            CariNamaPasien.setText("");
            CariNamaPasien.setFont(new Font("Tahoma", 0, 12));
            CariNamaPasien.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_CariNamaPasienFocusGained

    private void CariNamaPasienFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CariNamaPasienFocusLost
        if (rootPaneCheckingEnabled) {
            CariNamaPasien.setText("Masukkan Id Pasien");
            CariNamaPasien.setFont(new Font("Tahoma", 2, 12));
            CariNamaPasien.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_CariNamaPasienFocusLost

    private void TabelRekammedikMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelRekammedikMouseClicked
        int row = TabelRekammedik.getSelectedRow();
        try {
            listObat = new DefaultListModel();
            fieldTanggal.setText(String.valueOf(TabelRekammedik.getValueAt(row, 4)));
            textAreaKeluhan.setText(control.getDetailRekamMedik(String.valueOf(TabelRekammedik.getValueAt(row, 0))).getKeluhanRekammedik());
            textAreaPemeriksaan.setText(control.getDetailRekamMedik(String.valueOf(TabelRekammedik.getValueAt(row, 0))).getPemeriksaanRekammedik());
            textAreaTerapi.setText(control.getDetailRekamMedik(String.valueOf(TabelRekammedik.getValueAt(row, 0))).getTerapiRekammedik());
            textAreaAlergi.setText(control.getDetailRekamMedik(String.valueOf(TabelRekammedik.getValueAt(row, 0))).getAlergiobatRekammedik());
            textAreaKesimpulan.setText(control.getDetailRekamMedik(String.valueOf(TabelRekammedik.getValueAt(row, 0))).getKesimpulanRekammedis());
            textAreaKondisi.setText(control.getDetailRekamMedik(String.valueOf(TabelRekammedik.getValueAt(row, 0))).getKondisipasienkeluarRekammedis());
            listObat = control.getNamaObat(String.valueOf(TabelRekammedik.getValueAt(row, 5)));
            listPenyakit = control.getPenyakitPasien(String.valueOf(TabelRekammedik.getValueAt(row, 0)));
            listNamaObat.setModel(listObat);
            listNamaPenyakit.setModel(listPenyakit);
        } catch (RemoteException ex) {
            Logger.getLogger(dokterlihatrekammedis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TabelRekammedikMouseClicked

    private void CariNamaPasienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CariNamaPasienKeyReleased
        CariNamaPasien.setForeground(Color.BLACK);
        CariNamaPasien.setFont(new Font("Tahoma", 0, 12));
    }//GEN-LAST:event_CariNamaPasienKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CariNamaPasien;
    private javax.swing.JTable TabelRekammedik;
    private javax.swing.JTextField fieldDoctorName;
    private javax.swing.JTextField fieldTanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JList listNamaObat;
    private javax.swing.JList listNamaPenyakit;
    private javax.swing.JLabel namaPasien;
    private javax.swing.JTextArea textAreaAlergi;
    private javax.swing.JTextArea textAreaKeluhan;
    private javax.swing.JTextArea textAreaKesimpulan;
    private javax.swing.JTextArea textAreaKondisi;
    private javax.swing.JTextArea textAreaPemeriksaan;
    private javax.swing.JTextArea textAreaTerapi;
    // End of variables declaration//GEN-END:variables
}
