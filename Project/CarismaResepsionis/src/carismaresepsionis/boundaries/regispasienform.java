package carismaresepsionis.boundaries;

import carismainterface.entity.Pasien;
import carismainterface.server.KotaService;
import carismaresepsionis.controller.ClientSocket;
import carismaresepsionis.controller.regispasiencontroller;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private KotaService kotaService;
    String a, b, c, d, e, f, g, h, i;
    settergetter simpanan = new settergetter();

    /**
     * Creates new form regispasienform
     */
    public regispasienform(ClientSocket client, String userName) throws RemoteException {
        this.client = client;
        registrasicontrol = new regispasiencontroller(this.client);
        kotaService = client.getKotaService();
        //regispasiencontroller control = new regispasiencontroller(this.client);
        //control.getIdUser(this);
        this.userName = userName;
        initComponents();

        registrasicontrol.getTabelPasien(this);
        this.setExtendedState(this.MAXIMIZED_BOTH);

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
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        Nama_Pasien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Nama_PasienKeyTyped(evt);
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
        Tempat_Lahir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Tempat_LahirKeyTyped(evt);
            }
        });
        getContentPane().add(Tempat_Lahir);
        Tempat_Lahir.setBounds(580, 170, 215, 32);

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
        No_Hp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                No_HpKeyTyped(evt);
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
        No_tele.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                No_teleKeyTyped(evt);
            }
        });
        getContentPane().add(No_tele);
        No_tele.setBounds(930, 210, 335, 32);

        Jenis_Kelamin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Jenis Kelamin-", "L", "P" }));
        getContentPane().add(Jenis_Kelamin);
        Jenis_Kelamin.setBounds(580, 390, 134, 32);

        goldar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Golongan Darah-", "A", "B", "AB", "O" }));
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
        TinggiPasien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TinggiPasienKeyTyped(evt);
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
        BeratPasien.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BeratPasienFocusGained(evt);
            }
        });
        BeratPasien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BeratPasienKeyTyped(evt);
            }
        });
        getContentPane().add(BeratPasien);
        BeratPasien.setBounds(720, 440, 130, 32);

        TambahAntri.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TambahAntri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1428222513_icon-ios7-plus-outline-32.png"))); // NOI18N
        TambahAntri.setText("Tambah Antrian");
        TambahAntri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahAntriActionPerformed(evt);
            }
        });
        getContentPane().add(TambahAntri);
        TambahAntri.setBounds(310, 540, 170, 40);

        Kartu_id.setText("KTP Pasien");
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
        Kartu_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Kartu_idKeyTyped(evt);
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
        No_Kartu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                No_KartuKeyTyped(evt);
            }
        });
        getContentPane().add(No_Kartu);
        No_Kartu.setBounds(930, 250, 335, 32);

        CariPasien.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CariPasienFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                CariPasienFocusLost(evt);
            }
        });
        CariPasien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CariPasienKeyReleased(evt);
            }
        });
        getContentPane().add(CariPasien);
        CariPasien.setBounds(20, 60, 457, 32);

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
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1170, 550, 90, 40);

        jLabel3.setText("Tgl Registrasi Pasien");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(580, 500, 120, 14);

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
        tabelpasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelpasienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelpasien);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 120, 452, 402);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background2.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 1359, 700);

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
        if (f.equals(TinggiPasien.getText()) || (g.equals(BeratPasien.getText())) || (a.equals(Nama_Pasien.getText()))
                || (b.equals(Tempat_Lahir.getText())) || (c.equals(Alamat.getText())) || (Kota.getSelectedIndex() == 0) || (Jenis_Kelamin.getSelectedIndex() == 0) || (goldar.getSelectedIndex() == 0)
                || (d.equals(No_Hp.getText())) && (e.equals(No_tele.getText())) || (h.equals(Kartu_id.getText())) && (i.equals(No_Kartu.getText()))) {
            JOptionPane.showMessageDialog(rootPane, "ada yang belum keisi", "Confirm", WIDTH);
            //System.out.println("1");

        } //lek kosong
        else if ("".equals(TinggiPasien.getText()) || ("".equals(BeratPasien.getText())) || ("".equals(Nama_Pasien.getText()))
                || ("".equals(Tempat_Lahir.getText())) || ("".equals(Alamat.getText())) || (Kota.getSelectedIndex() == 0) || (Jenis_Kelamin.getSelectedIndex() == 0) || (goldar.getSelectedIndex() == 0)
                || ("".equals(No_Hp.getText())) && ("".equals(No_tele.getText())) || ("".equals(Kartu_id.getText())) && ("".equals(No_Kartu.getText()))) {
            JOptionPane.showMessageDialog(rootPane, "ada yang belum keisi", "Confirm", WIDTH);
            //System.out.println("2");
        } else {

            try {
                Date date = new Date(tgl_lahir.getDate().getTime());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String lah = sdf.format(date);

                Date now = tgl_regpasien.getDate();
                String hariIni = sdf.format(now);

                int pilihan = JOptionPane.showConfirmDialog(null, "Yakin Ingin Menyimpan Data?", "Konfirmasi Penyimpanan", JOptionPane.YES_NO_OPTION);

                boolean avail = registrasicontrol.cekKartuId(No_Kartu.getText());
                if (pilihan == 0 && !avail) {
                    String userNameandPassword = registrasicontrol.generateUserName(Nama_Pasien.getText(), String.valueOf(tgl_lahir.getDate()));
                    // insert ke table user (id, userbaneadnpasword, usernameandpassword
                    registrasicontrol.InsertUser(userNameandPassword, userNameandPassword, "pasien");
                    registrasicontrol.InsertNamaPasien(String.valueOf(registrasicontrol.ambilidkota(Kota.getSelectedIndex())), Nama_Pasien.getText(), Alamat.getText(), Kartu_id.getText(), No_Kartu.getText(), No_tele.getText(), No_Hp.getText(), Tempat_Lahir.getText(), lah, String.valueOf(Jenis_Kelamin.getSelectedItem()), String.valueOf(goldar.getSelectedItem()), Integer.parseInt(BeratPasien.getText()), Integer.parseInt(TinggiPasien.getText()), hariIni, userNameandPassword);
                    JOptionPane.showMessageDialog(null, "" + Nama_Pasien.getText() + "\n" + Alamat.getText() + "\n" + String.valueOf(Jenis_Kelamin.getSelectedItem()), "Cetak Pasien", JOptionPane.INFORMATION_MESSAGE);
                    registrasicontrol.getTabelPasien(this);
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
                else {
                    JOptionPane.showConfirmDialog(null, "Pasien sudah pernah terdaftar disini", "Konfirmasi", JOptionPane.ERROR_MESSAGE);
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

    private void tabelpasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpasienMouseClicked

        try {
            int row = tabelpasien.getSelectedRow();
            Pasien pasien = new Pasien();
            Date date = new Date();
            pasien = registrasicontrol.getDataPasien(String.valueOf(tabelpasien.getValueAt(row, 0)));
            Nama_Pasien.setText(pasien.getNamaPasien());
            Tempat_Lahir.setText(pasien.getTempatlahirPasien());
            tgl_lahir.setDate(java.sql.Date.valueOf(pasien.getTgllahirPasien()));
            No_Hp.setText(pasien.getHpPasien());
            No_tele.setText(pasien.getTelpPasien());
            Kartu_id.setText(pasien.getNokartuidPasien());
            No_Kartu.setText(pasien.getKartuidPasien());
            Alamat.setText(pasien.getAlamatPasien());
            TinggiPasien.setText(Integer.toString(pasien.getTinggiPasien()));
            BeratPasien.setText(Integer.toString(pasien.getBeratPasien()));
            Jenis_Kelamin.setSelectedItem(pasien.getKelaminPasien());
            goldar.setSelectedItem(pasien.getDarahPasien());
            Kota.setSelectedItem(kotaService.getKota(pasien.getKotaIdKota()).getNamaKota());
            tgl_regpasien.setDate(java.sql.Date.valueOf(pasien.getRegdatePasien()));
        } catch (RemoteException ex) {
            Logger.getLogger(regispasienform.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tabelpasienMouseClicked

    private void TambahAntriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahAntriActionPerformed
        try {
            new antrianoffline(this.client, userName, tabelpasien.getValueAt(tabelpasien.getSelectedRow(), 0).toString(), tabelpasien.getValueAt(tabelpasien.getSelectedRow(), 1).toString()).show();
            //        System.out.println(tabelpasien.getValueAt(tabelpasien.getSelectedRow(), 0).toString());
        } catch (RemoteException ex) {
            Logger.getLogger(regispasienform.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TambahAntriActionPerformed

    private void CariPasienFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CariPasienFocusGained
        if (CariPasien.getText().equals("Cari Nama Pasien")) {
            CariPasien.setText("");
    }//GEN-LAST:event_CariPasienFocusGained
    }
    private void CariPasienFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CariPasienFocusLost
        if (CariPasien.getText().equals("")) {
            CariPasien.setText("Cari Nama Pasien");
            CariPasien.setForeground(Color.gray);
            CariPasien.setFont(new Font("Tahoma", 2, 12));
        }
    }//GEN-LAST:event_CariPasienFocusLost

    private void CariPasienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CariPasienKeyReleased
        CariPasien.setForeground(Color.black);
        CariPasien.setFont(new Font("Tahoma", 0, 12));

        DefaultTableModel model = new DefaultTableModel();
        try {
            regispasiencontroller control = new regispasiencontroller(client);
            model = control.getPasienByName(CariPasien.getText());

            tabelpasien.setModel(model);
        } catch (RemoteException ex) {
            Logger.getLogger(Rawatinap.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_CariPasienKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Nama_PasienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nama_PasienKeyTyped
        typeOnlyCharacter(evt);
    }//GEN-LAST:event_Nama_PasienKeyTyped

    private void Tempat_LahirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tempat_LahirKeyTyped
        typeOnlyCharacter(evt);
    }//GEN-LAST:event_Tempat_LahirKeyTyped

    private void No_HpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_No_HpKeyTyped
        typeOnlyNumber(evt);
    }//GEN-LAST:event_No_HpKeyTyped

    private void No_teleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_No_teleKeyTyped
        typeOnlyNumber(evt);
    }//GEN-LAST:event_No_teleKeyTyped

    private void Kartu_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Kartu_idKeyTyped
        typeOnlyNumber(evt);
    }//GEN-LAST:event_Kartu_idKeyTyped

    private void No_KartuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_No_KartuKeyTyped
        typeOnlyNumber(evt);
    }//GEN-LAST:event_No_KartuKeyTyped

    private void TinggiPasienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TinggiPasienKeyTyped
        typeOnlyNumber(evt);
    }//GEN-LAST:event_TinggiPasienKeyTyped

    private void BeratPasienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BeratPasienKeyTyped
        typeOnlyNumber(evt);
    }//GEN-LAST:event_BeratPasienKeyTyped

    public void typeOnlyCharacter(KeyEvent evt) {
        char c = evt.getKeyChar();
        if ((Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE) {
            getToolkit().beep();
            evt.consume();
        }
    }
    
    public void typeOnlyNumber(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE) {
            getToolkit().beep();
            evt.consume();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Alamat;
    private javax.swing.JTextField BeratPasien;
    private javax.swing.JTextField CariPasien;
    private javax.swing.JButton Confirm;
    private javax.swing.JComboBox Jenis_Kelamin;
    private javax.swing.JTextField Kartu_id;
    public javax.swing.JComboBox Kota;
    private javax.swing.JTextField Nama_Pasien;
    private javax.swing.JTextField No_Hp;
    private javax.swing.JTextField No_Kartu;
    private javax.swing.JTextField No_tele;
    private javax.swing.JButton TambahAntri;
    private javax.swing.JTextField Tempat_Lahir;
    private javax.swing.JTextField TinggiPasien;
    private javax.swing.JComboBox goldar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tabelpasien;
    private com.toedter.calendar.JDateChooser tgl_lahir;
    private com.toedter.calendar.JDateChooser tgl_regpasien;
    // End of variables declaration//GEN-END:variables
}
