package carismaresepsionis.boundaries;

//import carismainterface.server.DokterService;
import carismainterface.server.*;
import carismainterface.entity.*;
import carismaresepsionis.controller.AntrianController;
import carismaresepsionis.controller.ClientSocket;
import carismaresepsionis.controller.LoginController;
import carismaresepsionis.controller.RawatinapController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
    private AntrianController control;
    private UserService userService;
     
    public Menursepsionis(ClientSocket client, final String userName) throws RemoteException {
        this.client = client;
        this.userName = userName;
        control = new AntrianController(this.client, this);
        ps = client.getPasienService();
        kamarService = client.getKamarService();
        userService = client.getUserService();
        initComponents();
        control.start();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        Namanya.setEditable(false);
        Namanya.setText(String.valueOf(this.userName));
//        tableAntri = control.getAntrian();
        tableDaftarAntrian.setModel(control.getAntrian());
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                LoginController log = new LoginController(userService, userName);
                try {
                    log.logOut();
                } catch (RemoteException ex) {
                    Logger.getLogger(Menursepsionis.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        //   tanggalkustom();
    }

    
//      public Menursepsionis(ClientSocket client, String username, String idPasien, String namaPasien) throws RemoteException {
//        this.client = client;
//        this.userName = username;
//        control = new AntrianController(this.client, this);
//        ps = client.getPasienService();
//        kamarService = client.getKamarService();
//        userService = client.getUserService();
//        initComponents();
//        control.start();
//        
//        this.setExtendedState(this.MAXIMIZED_BOTH);
//        Namanya.setEditable(false);
//        Namanya.setText(username);
////        Object rowData[] = new Object[3]; 
////          System.out.println("PASIEN = "+idPasien);
////          System.out.println("NAMA PASIEN = "+namaPasien);
////        rowData[0]=tableDaftarAntrian.getRowCount()+1;
////        rowData[1]=idPasien;
////        rowData[2]=namaPasien;
////        tableAntri.addRow(rowData);
////        tableDaftarAntrian.setModel(tableAntri);
//        this.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                LoginController log = new LoginController(userService, userName);
//                try {
//                    log.logOut();
//                } catch (RemoteException ex) {
//                    Logger.getLogger(Menursepsionis.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//        //   tanggalkustom();
//    }
        
        
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
        jLabel2 = new javax.swing.JLabel();

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
        jScrollPane1.setViewportView(tableDaftarAntrian);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(21, 100, 1072, 402);

        RegisPasienReg.setText("Registrasi Pasien Reguler");
        RegisPasienReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisPasienRegActionPerformed(evt);
            }
        });
        getContentPane().add(RegisPasienReg);
        RegisPasienReg.setBounds(1121, 100, 225, 50);

        RegisPasienInap.setText("Registrasi Pasien Rawat Inap");
        RegisPasienInap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisPasienInapActionPerformed(evt);
            }
        });
        getContentPane().add(RegisPasienInap);
        RegisPasienInap.setBounds(1121, 160, 225, 50);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1428228543_unlock.png"))); // NOI18N
        jButton3.setText("Log Out");
        getContentPane().add(jButton3);
        jButton3.setBounds(1221, 340, 120, 50);

        DataDokter.setText("Data Dokter");
        DataDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataDokterActionPerformed(evt);
            }
        });
        getContentPane().add(DataDokter);
        DataDokter.setBounds(1121, 280, 225, 50);

        LihatPasienInap.setText("Lihat Pasien Rawat Inap");
        LihatPasienInap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LihatPasienInapActionPerformed(evt);
            }
        });
        getContentPane().add(LihatPasienInap);
        LihatPasienInap.setBounds(1121, 220, 225, 50);

        buttonTambahAntrian.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonTambahAntrian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1428222513_icon-ios7-plus-outline-32.png"))); // NOI18N
        buttonTambahAntrian.setText("Tambah");
        buttonTambahAntrian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahAntrianActionPerformed(evt);
            }
        });
        getContentPane().add(buttonTambahAntrian);
        buttonTambahAntrian.setBounds(787, 510, 120, 41);

        buttonHapusAntrian.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonHapusAntrian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1426717770_circle_close_delete-24.png"))); // NOI18N
        buttonHapusAntrian.setText("Hapus");
        buttonHapusAntrian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusAntrianActionPerformed(evt);
            }
        });
        getContentPane().add(buttonHapusAntrian);
        buttonHapusAntrian.setBounds(657, 510, 120, 41);

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

        buttonLihatAntrian.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonLihatAntrian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1432134923_eye-32.png"))); // NOI18N
        buttonLihatAntrian.setText("Lihat Detail Antrian");
        buttonLihatAntrian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLihatAntrianActionPerformed(evt);
            }
        });
        getContentPane().add(buttonLihatAntrian);
        buttonLihatAntrian.setBounds(916, 510, 177, 41);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background2.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -10, 1360, 720);

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
           
            control = new RawatinapController(this.client);
            int kamarTersedia = control.kamarTersedia();
            if (kamarTersedia ==0 ) {

                JOptionPane.showMessageDialog(null, "MAAF!! \n Kamar Rawat Inap Penuh", "WARNING!", JOptionPane.ERROR_MESSAGE);

            } else {
                new Rawatinap(this.client, this.userName).show();
                //this.dispose();
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
            control.deleteAntrian(String.valueOf(tableDaftarAntrian.getValueAt(row, 1)));
            tableAntri = (DefaultTableModel) tableDaftarAntrian.getModel();
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tableDaftarAntrian;
    // End of variables declaration//GEN-END:variables

}
