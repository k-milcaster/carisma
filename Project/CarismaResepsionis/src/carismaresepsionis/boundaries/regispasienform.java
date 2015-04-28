package carismaresepsionis.boundaries;

import carismaresepsionis.controller.ClientSocket;
import carismaresepsionis.controller.regispasiencontroller;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fiqhi Darmawan
 */
public class regispasienform extends javax.swing.JFrame {

    private ClientSocket client;
    private String userName;
    private regispasiencontroller registrasicontrol;
    String a, b, c, d, e, f, g, h, i;
    settergetter simpanan = new settergetter();
    
    
    
    /**
     * Creates new form regispasienform
     */
    public regispasienform(ClientSocket client, String userName) throws RemoteException {
        this.client = client;
        registrasicontrol = new regispasiencontroller(this.client);
        //regispasiencontroller control = new regispasiencontroller(this.client);
        //control.getIdUser(this);
        this.userName = userName;
        initComponents();
        registrasicontrol.getTabelPasien(this);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        Find.requestFocus();
        Tempat_ID.setEditable(false);

        a = Nama_Pasien.getText();
        b = Tempat_Lahir.getText();
        c = Alamat.getText();
        d = No_Hp.getText();
        e = No_tele.getText();
        f = TinggiPasien.getText();
        g = BeratPasien.getText();
        h = Kartu_id.getText();
        i = No_Kartu.getText();
        Date tanggal = new Date();
        tgl_regpasien.setDate(tanggal);

        registrasicontrol.setComboBoxKota(this);


        //   tanggalkustom();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Nama_Pasien = new javax.swing.JTextField();
        Tempat_Lahir = new javax.swing.JTextField();
        ID = new javax.swing.JLabel();
        Tempat_ID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Alamat = new javax.swing.JTextArea();
        No_Hp = new javax.swing.JTextField();
        No_tele = new javax.swing.JTextField();
        Jenis_Kelamin = new javax.swing.JComboBox();
        goldar = new javax.swing.JComboBox();
        TinggiPasien = new javax.swing.JTextField();
        BeratPasien = new javax.swing.JTextField();
        TambahAntri = new javax.swing.JButton();
        Kartu_id = new javax.swing.JTextField();
        No_Kartu = new javax.swing.JTextField();
        CariPasien = new javax.swing.JTextField();
        UpdatePasien = new javax.swing.JButton();
        Find = new javax.swing.JButton();
        Kota = new javax.swing.JComboBox();
        Confirm = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tgl_lahir = new com.toedter.calendar.JDateChooser();
        tgl_regpasien = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelpasien = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Daftar Pasien Baru");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 0, 320, 58);

        Nama_Pasien.setText("Nama_Pasien");
        Nama_Pasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Nama_PasienMouseClicked(evt);
            }
        });
        Nama_Pasien.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Nama_PasienFocusGained(evt);
            }
        });
        getContentPane().add(Nama_Pasien);
        Nama_Pasien.setBounds(580, 130, 685, 32);

        Tempat_Lahir.setText("Tempat Lahir");
        Tempat_Lahir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tempat_LahirMouseClicked(evt);
            }
        });
        Tempat_Lahir.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Tempat_LahirFocusGained(evt);
            }
        });
        getContentPane().add(Tempat_Lahir);
        Tempat_Lahir.setBounds(580, 170, 215, 32);

        ID.setText("ID PASIEN");
        getContentPane().add(ID);
        ID.setBounds(1080, 90, 79, 32);

        Tempat_ID.setText("SDA-1234-C");
        getContentPane().add(Tempat_ID);
        Tempat_ID.setBounds(1170, 90, 99, 32);

        Alamat.setColumns(20);
        Alamat.setRows(5);
        Alamat.setText("Alamat");
        Alamat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AlamatMouseClicked(evt);
            }
        });
        Alamat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                AlamatFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(Alamat);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(580, 300, 340, 71);

        No_Hp.setText("No_HP");
        No_Hp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                No_HpMouseClicked(evt);
            }
        });
        No_Hp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                No_HpFocusGained(evt);
            }
        });
        getContentPane().add(No_Hp);
        No_Hp.setBounds(580, 210, 340, 32);

        No_tele.setText("No_Telp");
        No_tele.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                No_teleMouseClicked(evt);
            }
        });
        No_tele.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                No_teleFocusGained(evt);
            }
        });
        getContentPane().add(No_tele);
        No_tele.setBounds(930, 210, 335, 32);

        Jenis_Kelamin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Jenis Kelamin-", "L", "P" }));
        getContentPane().add(Jenis_Kelamin);
        Jenis_Kelamin.setBounds(580, 390, 134, 32);

        goldar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Golongan Darah-", "A", "B", "AB", "O" }));
        goldar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goldarActionPerformed(evt);
            }
        });
        getContentPane().add(goldar);
        goldar.setBounds(720, 390, 160, 32);

        TinggiPasien.setText("Tinggi Badan");
        TinggiPasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TinggiPasienMouseClicked(evt);
            }
        });
        TinggiPasien.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TinggiPasienFocusGained(evt);
            }
        });
        getContentPane().add(TinggiPasien);
        TinggiPasien.setBounds(580, 440, 134, 32);

        BeratPasien.setText("Berat Badan");
        BeratPasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BeratPasienMouseClicked(evt);
            }
        });
        BeratPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeratPasienActionPerformed(evt);
            }
        });
        BeratPasien.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BeratPasienFocusGained(evt);
            }
        });
        getContentPane().add(BeratPasien);
        BeratPasien.setBounds(720, 440, 130, 32);

        TambahAntri.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TambahAntri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1428222513_icon-ios7-plus-outline-32.png"))); // NOI18N
        TambahAntri.setText("Tambah Antrian");
        getContentPane().add(TambahAntri);
        TambahAntri.setBounds(380, 550, 170, 40);

        Kartu_id.setText("Kartu Id Pasien");
        Kartu_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Kartu_idMouseClicked(evt);
            }
        });
        Kartu_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Kartu_idFocusGained(evt);
            }
        });
        getContentPane().add(Kartu_id);
        Kartu_id.setBounds(580, 250, 340, 32);

        No_Kartu.setText("Nomor_Kartu");
        No_Kartu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                No_KartuMouseClicked(evt);
            }
        });
        No_Kartu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                No_KartuFocusGained(evt);
            }
        });
        getContentPane().add(No_Kartu);
        No_Kartu.setBounds(930, 250, 335, 32);

        CariPasien.setText("- Cari Nama Pasien -");
        getContentPane().add(CariPasien);
        CariPasien.setBounds(20, 60, 457, 32);

        UpdatePasien.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        UpdatePasien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1428227236_card_in_use.png"))); // NOI18N
        UpdatePasien.setText("Cetak Bukti Antrian");
        getContentPane().add(UpdatePasien);
        UpdatePasien.setBounds(190, 550, 180, 40);

        Find.setText("FIND");
        getContentPane().add(Find);
        Find.setBounds(480, 60, 95, 32);

        Kota.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- KOTA -" }));
        getContentPane().add(Kota);
        Kota.setBounds(940, 390, 325, 32);

        Confirm.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Confirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1426717487_save.png"))); // NOI18N
        Confirm.setText("Confirm");
        Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmActionPerformed(evt);
            }
        });
        getContentPane().add(Confirm);
        Confirm.setBounds(1050, 550, 110, 40);

        jButton1.setText("Home");
        getContentPane().add(jButton1);
        jButton1.setBounds(-490, 620, 155, 32);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1426718664_circle_back_arrow_-24.png"))); // NOI18N
        jButton2.setText("Back");
        jButton2.setPreferredSize(new java.awt.Dimension(89, 23));
        getContentPane().add(jButton2);
        jButton2.setBounds(1170, 550, 90, 40);

        jLabel3.setText("Tgl Registrasi Pasien");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(580, 500, 100, 14);

        tgl_lahir.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(tgl_lahir);
        tgl_lahir.setBounds(810, 170, 130, 30);
        getContentPane().add(tgl_regpasien);
        tgl_regpasien.setBounds(700, 490, 140, 30);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(870, 60, 110, 100);

        tabelpasien.setModel(new javax.swing.table.DefaultTableModel(
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
                "Title 1", "Title 2"
            }
        ));
        jScrollPane2.setViewportView(tabelpasien);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 120, 452, 402);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Nama_PasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Nama_PasienMouseClicked

        if (a.equals(Nama_Pasien.getText())) {
            Nama_Pasien.setText("");
        }

    }//GEN-LAST:event_Nama_PasienMouseClicked

    private void Tempat_LahirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tempat_LahirMouseClicked
        if (b.equals(Tempat_Lahir.getText())) {
            Tempat_Lahir.setText("");
        }
    }//GEN-LAST:event_Tempat_LahirMouseClicked

    private void Tempat_LahirFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Tempat_LahirFocusGained
        if ("Tempat".equals(Tempat_Lahir.getText())) {
            Tempat_Lahir.setText("");
        }
    }//GEN-LAST:event_Tempat_LahirFocusGained

    private void Nama_PasienFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Nama_PasienFocusGained
        if (a.equals(Nama_Pasien.getText())) {
            Nama_Pasien.setText("");
        }
    }//GEN-LAST:event_Nama_PasienFocusGained

    private void AlamatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlamatMouseClicked
        if (c.equals(Alamat.getText())) {
            Alamat.setText("");
        }
    }//GEN-LAST:event_AlamatMouseClicked

    private void AlamatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AlamatFocusGained
        if (c.equals(Alamat.getText())) {
            Alamat.setText("");
        }
    }//GEN-LAST:event_AlamatFocusGained

    private void No_HpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_No_HpFocusGained
        if (d.equals(No_Hp.getText())) {
            No_Hp.setText("");
        }
    }//GEN-LAST:event_No_HpFocusGained

    private void No_teleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_No_teleFocusGained
        if (e.equals(No_tele.getText())) {
            No_tele.setText("");
        }
    }//GEN-LAST:event_No_teleFocusGained

    private void No_HpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_No_HpMouseClicked
        if (d.equals(No_Hp.getText())) {
            No_Hp.setText("");
        }
    }//GEN-LAST:event_No_HpMouseClicked

    private void No_teleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_No_teleMouseClicked
        if (e.equals(No_tele.getText())) {
            No_tele.setText("");
        }
    }//GEN-LAST:event_No_teleMouseClicked

    private void TinggiPasienFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TinggiPasienFocusGained
        if (f.equals(TinggiPasien.getText())) {
            TinggiPasien.setText("");
        }
    }//GEN-LAST:event_TinggiPasienFocusGained

    private void TinggiPasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TinggiPasienMouseClicked
        if (f.equals(TinggiPasien.getText())) {
            TinggiPasien.setText("");
        }
    }//GEN-LAST:event_TinggiPasienMouseClicked

    private void BeratPasienFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BeratPasienFocusGained
        if (g.equals(BeratPasien.getText())) {
            BeratPasien.setText("");
        }
    }//GEN-LAST:event_BeratPasienFocusGained

    private void BeratPasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BeratPasienMouseClicked
        if (g.equals(BeratPasien.getText())) {
            BeratPasien.setText("");
        }
    }//GEN-LAST:event_BeratPasienMouseClicked

    private void ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmActionPerformed

        //lek default
        if (f.equals(TinggiPasien.getText()) || (g.equals(BeratPasien.getText())) || ("".equals(Tempat_ID.getText())) || (a.equals(Nama_Pasien.getText()))
                || (b.equals(Tempat_Lahir.getText())) || (c.equals(Alamat.getText())) || (Kota.getSelectedIndex() == 0) || (Jenis_Kelamin.getSelectedIndex() == 0) || (goldar.getSelectedIndex() == 0)
                || (d.equals(No_Hp.getText())) && (e.equals(No_tele.getText())) || (h.equals(Kartu_id.getText())) && (i.equals(No_Kartu.getText()))) {
            JOptionPane.showMessageDialog(rootPane, "ada yang belum keisi", "Confirm", WIDTH);
            System.out.println("1");

        } //lek kosong
        else if ("".equals(TinggiPasien.getText()) || ("".equals(BeratPasien.getText())) || ("".equals(Tempat_ID.getText())) || ("".equals(Nama_Pasien.getText()))
                || ("".equals(Tempat_Lahir.getText())) || ("".equals(Alamat.getText())) || (Kota.getSelectedIndex() == 0) || (Jenis_Kelamin.getSelectedIndex() == 0) || (goldar.getSelectedIndex() == 0)
                || ("".equals(No_Hp.getText())) && ("".equals(No_tele.getText())) || ("".equals(Kartu_id.getText())) && ("".equals(No_Kartu.getText()))) {
            JOptionPane.showMessageDialog(rootPane, "ada yang belum keisi", "Confirm", WIDTH);
            System.out.println("2");
        } 
        else {
          
            try {
                Date date = new Date(tgl_lahir.getDate().getTime());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String lah = sdf.format(date);
                
                Date now = tgl_regpasien.getDate();
                String hariIni = sdf.format(now);

                int pilihan = JOptionPane.showConfirmDialog(null, "Yakin Ingin Menyimpan Data?", "Konfirmasi Penyimpanan", JOptionPane.YES_NO_OPTION);
                if (pilihan == 0) {
                     String userNameandPassword = registrasicontrol.generateUserName(Nama_Pasien.getText(), String.valueOf(tgl_lahir.getDate()));
                    // insert ke table user (id, userbaneadnpasword, usernameandpassword
                    registrasicontrol.InsertUser(userNameandPassword, userNameandPassword, "pasien");
                    registrasicontrol.InsertNamaPasien(Tempat_ID.getText(), String.valueOf(registrasicontrol.ambilidkota(Kota.getSelectedIndex())), Nama_Pasien.getText(), Alamat.getText(), Kartu_id.getText(), No_Kartu.getText(), No_tele.getText(), No_Hp.getText(), Tempat_Lahir.getText(), lah, String.valueOf(Jenis_Kelamin.getSelectedItem()), String.valueOf(goldar.getSelectedItem()), Integer.parseInt(BeratPasien.getText()), Integer.parseInt(TinggiPasien.getText()), hariIni, userNameandPassword);
                    JOptionPane.showMessageDialog(null, "" + Nama_Pasien.getText() + "\n" + Alamat.getText() + "\n" + Tempat_ID.getText() + "/n" + String.valueOf(Jenis_Kelamin.getSelectedItem()), "Cetak Pasien", JOptionPane.INFORMATION_MESSAGE);
                    registrasicontrol.getTabelPasien(this);
                    Tempat_ID.setText("");
                    Kota.setSelectedItem(0);
                    Nama_Pasien.setText("");
                    Alamat.setText("");
                    Kartu_id.setText("");
                    No_Kartu.setText("");
                    No_tele.setText("");
                    No_Hp.setText("");
                    Tempat_Lahir.setText("");
                    tgl_lahir.setDate(null);
                    Jenis_Kelamin.setSelectedItem(0);
                    goldar.setSelectedItem(0);
                    BeratPasien.setText("");
                    TinggiPasien.setText("");
                    tgl_regpasien.setDate(null);

                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }//GEN-LAST:event_ConfirmActionPerformed

    private void Kartu_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Kartu_idFocusGained
        if (h.equals(Kartu_id.getText())) {
            Kartu_id.setText("");
        }
    }//GEN-LAST:event_Kartu_idFocusGained

    private void Kartu_idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Kartu_idMouseClicked
        if (h.equals(Kartu_id.getText())) {
            Kartu_id.setText("");
        }
    }//GEN-LAST:event_Kartu_idMouseClicked

    private void No_KartuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_No_KartuFocusGained
        if (i.equals(No_Kartu.getText())) {
            No_Kartu.setText("");
        }
    }//GEN-LAST:event_No_KartuFocusGained

    private void No_KartuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_No_KartuMouseClicked
        if (i.equals(No_Kartu.getText())) {
            No_Kartu.setText("");
        }
    }//GEN-LAST:event_No_KartuMouseClicked

    private void goldarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goldarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_goldarActionPerformed

    private void BeratPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeratPasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BeratPasienActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Alamat;
    private javax.swing.JTextField BeratPasien;
    private javax.swing.JTextField CariPasien;
    private javax.swing.JButton Confirm;
    private javax.swing.JButton Find;
    private javax.swing.JLabel ID;
    private javax.swing.JComboBox Jenis_Kelamin;
    private javax.swing.JTextField Kartu_id;
    public javax.swing.JComboBox Kota;
    private javax.swing.JTextField Nama_Pasien;
    private javax.swing.JTextField No_Hp;
    private javax.swing.JTextField No_Kartu;
    private javax.swing.JTextField No_tele;
    private javax.swing.JButton TambahAntri;
    private javax.swing.JTextField Tempat_ID;
    private javax.swing.JTextField Tempat_Lahir;
    private javax.swing.JTextField TinggiPasien;
    private javax.swing.JButton UpdatePasien;
    private javax.swing.JComboBox goldar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tabelpasien;
    private com.toedter.calendar.JDateChooser tgl_lahir;
    private com.toedter.calendar.JDateChooser tgl_regpasien;
    // End of variables declaration//GEN-END:variables
}
