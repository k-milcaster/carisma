package carismaresepsionis.boundaries;

import carismainterface.entity.Pasien;
import carismainterface.entity.Kamar;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author devan
 */
public class Rawatinap extends javax.swing.JFrame {
    private ClientSocket client;
    private String userName;
    private PasienService ps;
    private DefaultTableModel tablePasien = new DefaultTableModel();
    private DaftarRawatInapController daftarRawatInapController;
    settergetter simpanan = new settergetter();
    String a, b, c, d, e, f;
    
    public Rawatinap(ClientSocket client, String userName) throws RemoteException {
        
        this.client = client;
        RawatinapController control = new RawatinapController(this.client);
        ps = client.getPasienService();
        this.userName = userName;
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        //control.getNamaPasien();
        
        a = namapasien.getText();
        b = idpasien.getText();
        c = NamaPenyakitpasien.getText();
        d = namaKamar.getText();
        e = kelasKamar.getText();
        f = tarif.getText();
       
    }

//    void awalan
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablelistkamarpasien = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        carnampas = new javax.swing.JTextField();
        idpasien = new javax.swing.JTextField();
        namapasien = new javax.swing.JTextField();
        NamaPenyakitpasien = new javax.swing.JTextField();
        kelasKamar = new javax.swing.JTextField();
        namaKamar = new javax.swing.JTextField();
        ok = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tarif = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablepasien = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tablelistkamarpasien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama Kamar", "Kelas Kamar", "Tarif", "Fasilitas"
            }
        ));
        tablelistkamarpasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablelistkamarpasienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablelistkamarpasien);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(430, 190, 540, 402);

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("List Kamar Kosong");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(426, 133, 452, 40);

        carnampas.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        carnampas.setForeground(new java.awt.Color(204, 204, 204));
        carnampas.setText("Cari Nama Pasien");
        carnampas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carnampasActionPerformed(evt);
            }
        });
        carnampas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                carnampasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                carnampasFocusLost(evt);
            }
        });
        carnampas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                carnampasKeyReleased(evt);
            }
        });
        getContentPane().add(carnampas);
        carnampas.setBounds(10, 130, 410, 40);

        idpasien.setText("ID Pasien");
        idpasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idpasienActionPerformed(evt);
            }
        });
        getContentPane().add(idpasien);
        idpasien.setBounds(990, 190, 360, 32);

        namapasien.setText("Nama Pasien");
        getContentPane().add(namapasien);
        namapasien.setBounds(990, 230, 360, 32);

        NamaPenyakitpasien.setText("Nama Penyakit");
        getContentPane().add(NamaPenyakitpasien);
        NamaPenyakitpasien.setBounds(990, 270, 360, 31);

        kelasKamar.setText("Kelas Kamar");
        getContentPane().add(kelasKamar);
        kelasKamar.setBounds(990, 370, 170, 32);

        namaKamar.setText("Nama Kamar");
        getContentPane().add(namaKamar);
        namaKamar.setBounds(990, 330, 170, 32);

        ok.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1428228446_ok.png"))); // NOI18N
        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        getContentPane().add(ok);
        ok.setBounds(990, 460, 110, 41);

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registrasi Rawat Inap");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 30, 360, 50);

        tarif.setText("Tarif ");
        tarif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarifActionPerformed(evt);
            }
        });
        getContentPane().add(tarif);
        tarif.setBounds(990, 410, 170, 30);

        jLabel3.setText("Data Kamar");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(990, 310, 90, 14);

        jLabel4.setText("Data Pasien");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(990, 170, 90, 14);

        tablepasien.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null}
            },
            new String [] {
                "ID Pasien", "Nama Pasien"
            }
        ));
        tablepasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablepasienMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablepasien);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 190, 410, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tarifActionPerformed

    private void carnampasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carnampasActionPerformed
       if (evt.getSource() instanceof JTextField) {
            
        }
    }//GEN-LAST:event_carnampasActionPerformed

    private void idpasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idpasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idpasienActionPerformed

    private void tablelistkamarpasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablelistkamarpasienMouseClicked
         int row = tablelistkamarpasien.getSelectedRow();
            
            namaKamar.setText(String.valueOf(tablepasien.getValueAt(row, 0)));
            kelasKamar.setText(String.valueOf(tablepasien.getValueAt(row, 1)));
            tarif.setText(String.valueOf(tablepasien.getValueAt(row, 2)));
        /*RawatinapController ambilData;
        try {
            ambilData = new RawatinapController (client);
            
            int row = tablelistkamarpasien.getSelectedRow();
            String listKamar = " ";
            listKamar = String.valueOf(tablelistkamarpasien.getValueAt(row, 0));
            namaKamar.setText(ambilData.getNamaKamar());
            kelasKamar.setText(ambilData.getKelasKamar());
            tarif.setText(ambilData.getTarifKamar());
            
            
        } catch (RemoteException ex) {
            Logger.getLogger(Rawatinap.class.getName()).log(Level.SEVERE, "ada salah disini", ex);
        }*/
    }//GEN-LAST:event_tablelistkamarpasienMouseClicked

    private void carnampasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_carnampasFocusGained
        if (carnampas.getText().equals("Cari Nama Pasien")) {
            carnampas.setText("");
        }
    }//GEN-LAST:event_carnampasFocusGained

    private void carnampasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_carnampasFocusLost
        if (carnampas.getText().equals("")) {
            carnampas.setText("Cari Nama Pasien");
            carnampas.setForeground(Color.gray);
            carnampas.setFont(new Font("Tahoma", 2, 12));
        }
        
    }//GEN-LAST:event_carnampasFocusLost

    private void carnampasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_carnampasKeyReleased
        carnampas.setForeground(Color.black);
        carnampas.setFont(new Font("Tahoma", 0, 12));
    }//GEN-LAST:event_carnampasKeyReleased

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        //lek default
        if (((a.equals(namapasien.getText())) && (b.equals(idpasien.getText())) && (c.equals(NamaPenyakitpasien.getText())) && (d.equals(namaKamar.getText()))
                && (e.equals(kelasKamar.getText())) && (f.equals(tarif.getText())))) {
            JOptionPane.showMessageDialog(rootPane, "ada yang belum keisi", "Confirm", WIDTH);
            System.out.println("1");

        } //lek kosong
        else  if (((a.equals(namapasien.getText())) || (b.equals(idpasien.getText())) || (c.equals(NamaPenyakitpasien.getText())) || (d.equals(namaKamar.getText()))
                && (e.equals(kelasKamar.getText())) || (f.equals(tarif.getText())))) {
            JOptionPane.showMessageDialog(rootPane, "ada yang belum keisi", "Confirm", WIDTH);
            System.out.println("2");
        } //         int tinggi,bert,umur;
       
        else {

            try {
                //Date date = new Date(tgl_lahir.getDate().getTime());
                //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                //String lah = sdf.format(date);
                //Date now = tgl_regpasien.getDate();
                //String hariIni = sdf.format(now);

                int pilihan = JOptionPane.showConfirmDialog(null, "Yakin Ingin Menyimpan Data?", "Konfirmasi Penyimpanan", JOptionPane.YES_NO_OPTION);
                if (pilihan == 0) {
                    daftarRawatInapController.insertNamaPasien(namapasien.getText(), idpasien.getText(), NamaPenyakitpasien.getText(),  namaKamar.getText(), kelasKamar.getText(), tarif.getText());
                    System.out.println("3");
                    //JOptionPane.showMessageDialog(null, "" + Nama_Pasien.getText() + "\n" + Alamat.getText() + "\n" + Tempat_ID.getText() + "/n" + String.valueOf(Jenis_Kelamin.getSelectedItem()), "Cetak Pasien", JOptionPane.INFORMATION_MESSAGE);
                    //ListPasien.add(Nama_Pasien.getText());
                    namapasien.setText("");
                    idpasien.setText("");
                    NamaPenyakitpasien.setText("");
                    namaKamar.setText("");
                    kelasKamar.setText("");
                    tarif.setText("");
                    

                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }//GEN-LAST:event_okActionPerformed

    private void tablepasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablepasienMouseClicked
         int row = tablepasien.getSelectedRow();
            
            idpasien.setText(String.valueOf(tablepasien.getValueAt(row, 0)));
            namapasien.setText(String.valueOf(tablepasien.getValueAt(row, 1)));
            
            
       
    }//GEN-LAST:event_tablepasienMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NamaPenyakitpasien;
    private javax.swing.JTextField carnampas;
    private javax.swing.JTextField idpasien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField kelasKamar;
    private javax.swing.JTextField namaKamar;
    private javax.swing.JTextField namapasien;
    private javax.swing.JButton ok;
    public javax.swing.JTable tablelistkamarpasien;
    public javax.swing.JTable tablepasien;
    private javax.swing.JTextField tarif;
    // End of variables declaration//GEN-END:variables
}
