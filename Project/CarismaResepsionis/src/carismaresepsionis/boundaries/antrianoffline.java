/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.boundaries;

import carismainterface.server.DokterService;
import carismaresepsionis.controller.ClientSocket;
import carismaresepsionis.controller.DataDokterController;
import carismaresepsionis.controller.regispasiencontroller;
import carismaresepsionis.controller.AntrianOfflineController;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fiqhi Darmawan
 */
public class antrianoffline extends javax.swing.JFrame {

    private ClientSocket client;
    private String userName;
    private regispasiencontroller registrasicontrol;
    private AntrianOfflineController antrianofflinecontrol;
    private DokterService ds;
    private DefaultTableModel tabeldokter = new DefaultTableModel();
    private DataDokterController DataDokterController;
    DataDokterController control;

    /**
     * Creates new form antrianoffline
     */
//    public antrianoffline() {
//        initComponents();
//    }
    public antrianoffline(ClientSocket client, String username, String idPasien, String namaPasien) throws RemoteException {
        initComponents();
        this.client = client;
        registrasicontrol = new regispasiencontroller(this.client);
        antrianofflinecontrol = new AntrianOfflineController(this.client);
        antrianofflinecontrol.setComboBoxPoli(this);
        idpasien.setText(idPasien);
        namapasien.setText(namaPasien);
        this.userName = username;
        this.setExtendedState(this.MAXIMIZED_BOTH);
        

//          this.client = client;
        control = new DataDokterController(this.client);
//        ds = client.getDokterService();
//        this.userName = userName; 
        tabeldokter_.setModel(control.getDokterList());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        namapasien = new javax.swing.JTextField();
        namadokter = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        polidokter = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        idpasien = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabeldokter_ = new javax.swing.JTable();
        tambahantrian = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Nama Dokter");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 170, 70, 14);

        jLabel4.setText("Nama Pasien");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(160, 320, 70, 20);
        getContentPane().add(namapasien);
        namapasien.setBounds(260, 320, 140, 30);
        getContentPane().add(namadokter);
        namadokter.setBounds(260, 170, 140, 30);

        jLabel2.setText("Poli");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 220, 16, 14);

        polidokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                polidokterActionPerformed(evt);
            }
        });
        getContentPane().add(polidokter);
        polidokter.setBounds(260, 220, 140, 30);

        jLabel3.setText("Id Pasien");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 270, 70, 20);
        getContentPane().add(idpasien);
        idpasien.setBounds(260, 270, 140, 30);

        tabeldokter_.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Dokter", "Nama Dokter", "Hari Kerja", "Jam Kerja"
            }
        ));
        tabeldokter_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeldokter_MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabeldokter_);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(140, 380, 570, 130);

        tambahantrian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1426717487_save.png"))); // NOI18N
        tambahantrian.setText("Tambah Antrian");
        tambahantrian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahantrianActionPerformed(evt);
            }
        });
        getContentPane().add(tambahantrian);
        tambahantrian.setBounds(440, 520, 140, 40);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1426718664_circle_back_arrow_-24.png"))); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(600, 520, 110, 40);

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TAMBAH ANTRIAN");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 0, 270, 70);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background2.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 1360, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabeldokter_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeldokter_MouseClicked
        namadokter.setText(tabeldokter_.getValueAt(tabeldokter_.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tabeldokter_MouseClicked

    private void tambahantrianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahantrianActionPerformed
        try {

            String format_tanggal = "yyyy-MM-dd";
            SimpleDateFormat format = new SimpleDateFormat(format_tanggal);
            Calendar cal = Calendar.getInstance();
            String tanggal = String.valueOf(format.format(cal.getTime()));
//             tabeldokter_.getV
            antrianofflinecontrol.InsertAntrian(idpasien.getText().toString(), tabeldokter_.getValueAt(tabeldokter_.getSelectedRow(), 0).toString(), tanggal);
            this.dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(antrianoffline.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(antrianoffline.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(antrianoffline.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tambahantrianActionPerformed

    private void polidokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_polidokterActionPerformed
        if (polidokter.getSelectedIndex() != 0) {
            try {
                tabeldokter_.setModel(control.getDokterListByPoliAsc(polidokter.getSelectedItem().toString()));
            } catch (RemoteException ex) {
                Logger.getLogger(antrianoffline.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_polidokterActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try {
            new Menursepsionis (this.client, this.userName).show();
        
        } catch (RemoteException ex) {
            Logger.getLogger(antrianoffline.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idpasien;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namadokter;
    private javax.swing.JTextField namapasien;
    public javax.swing.JComboBox polidokter;
    private javax.swing.JTable tabeldokter_;
    private javax.swing.JButton tambahantrian;
    // End of variables declaration//GEN-END:variables
}
