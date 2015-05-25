package carismaresepsionis.boundaries;

import carismainterface.server.UserService;
import carismaresepsionis.boundaries.*;
import carismaresepsionis.controller.ClientSocket;
import carismaresepsionis.controller.DaftarRawatInapController;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author devan
 */
public class DaftarRawatInap extends javax.swing.JFrame {
    private ClientSocket client;
    private String userName;
    private DefaultTableModel tablePasienRawat = new DefaultTableModel();
    String a, b,bb,  c,c1,c2, d, e, f, g, h, i, j, k,l,m;
    settergetter simpanan = new settergetter();

    /*String hitungumur() {
        int umur;
        umur = Integer.parseInt((String) tglLahir.());
        int umurini = 2015 - umur;
   // System.out.println(umurini);
        return String.valueOf(umurini);
    }*/
    
    public DaftarRawatInap(ClientSocket client, String userName) throws RemoteException {
        setJam();
        this.client = client;
        DaftarRawatInapController control = new DaftarRawatInapController(this.client);
        this.userName = userName;
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        TabelPasien.setModel(control.getNamaPasienRawatInap());
 
        Tempat_ID.setEditable(false);
        //UmurPasien.setEditable(false);
        a = Nama_Pasien.getText();
        b = Tempat_Lahir.getText();
        bb = tglLahir.getText();
        c = Alamat.getText();
        c1 = Kota.getText();
        c2 = Provinsi.getText();
        d = No_Hp.getText();
        e = No_tele.getText();
        f = TinggiPasien.getText();
        g = BeratPasien.getText();
        h = Jenis_Kartu.getText();
        i = No_Kartu.getText();
        j = Kamar.getText();
        k = KelasKamar.getText();
        l = jenis_kelamin.getText();
        m = goldar.getText();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nama_Pasien = new javax.swing.JTextField();
        Tempat_Lahir = new javax.swing.JTextField();
        ID = new javax.swing.JLabel();
        Tempat_ID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Alamat = new javax.swing.JTextArea();
        No_Hp = new javax.swing.JTextField();
        No_tele = new javax.swing.JTextField();
        UmurPasien = new javax.swing.JTextField();
        TinggiPasien = new javax.swing.JTextField();
        BeratPasien = new javax.swing.JTextField();
        konfirmKeluar = new javax.swing.JButton();
        CariPasien = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelPasien = new javax.swing.JTable();
        kembali = new javax.swing.JButton();
        Kamar = new javax.swing.JTextField();
        KelasKamar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Jenis_Kartu = new javax.swing.JTextField();
        No_Kartu = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tampilTanggal = new javax.swing.JLabel();
        tampilJam = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tglLahir = new javax.swing.JTextField();
        Kota = new javax.swing.JTextField();
        Provinsi = new javax.swing.JTextField();
        jenis_kelamin = new javax.swing.JTextField();
        goldar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

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
        Nama_Pasien.setBounds(740, 150, 580, 32);

        Tempat_Lahir.setText("Tempat");
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
        Tempat_Lahir.setBounds(631, 288, 180, 32);

        ID.setText("ID PASIEN");
        getContentPane().add(ID);
        ID.setBounds(1140, 110, 79, 32);

        Tempat_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tempat_IDActionPerformed(evt);
            }
        });
        getContentPane().add(Tempat_ID);
        Tempat_ID.setBounds(1220, 110, 99, 32);

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
        jScrollPane1.setBounds(631, 423, 685, 50);

        No_Hp.setText("No_Telp");
        No_Hp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                No_HpMouseClicked(evt);
            }
        });
        No_Hp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No_HpActionPerformed(evt);
            }
        });
        No_Hp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                No_HpFocusGained(evt);
            }
        });
        getContentPane().add(No_Hp);
        No_Hp.setBounds(741, 326, 230, 32);

        No_tele.setText("No_Hp");
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
        No_tele.setBounds(1086, 326, 230, 32);

        UmurPasien.setText("Umur");
        UmurPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UmurPasienActionPerformed(evt);
            }
        });
        getContentPane().add(UmurPasien);
        UmurPasien.setBounds(1220, 560, 100, 32);

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
        TinggiPasien.setBounds(960, 560, 120, 32);

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
        getContentPane().add(BeratPasien);
        BeratPasien.setBounds(1090, 560, 120, 32);

        konfirmKeluar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        konfirmKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1428227814_checked_checkbox.png"))); // NOI18N
        konfirmKeluar.setText("Konfirmasi Keluar");
        konfirmKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konfirmKeluarActionPerformed(evt);
            }
        });
        getContentPane().add(konfirmKeluar);
        konfirmKeluar.setBounds(158, 605, 167, 40);

        CariPasien.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        CariPasien.setForeground(new java.awt.Color(204, 204, 204));
        CariPasien.setText("Cari Nama Pasien");
        CariPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariPasienActionPerformed(evt);
            }
        });
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
        CariPasien.setBounds(45, 105, 560, 32);

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
        jScrollPane2.setViewportView(TabelPasien);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(45, 155, 558, 444);

        kembali.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1426718664_circle_back_arrow_-24.png"))); // NOI18N
        kembali.setText("Back");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });
        getContentPane().add(kembali);
        kembali.setBounds(45, 605, 95, 40);

        Kamar.setText("Kamar");
        Kamar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                KamarFocusGained(evt);
            }
        });
        getContentPane().add(Kamar);
        Kamar.setBounds(740, 190, 580, 32);

        KelasKamar.setText("Kelas Kamar");
        KelasKamar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                KelasKamarFocusGained(evt);
            }
        });
        getContentPane().add(KelasKamar);
        KelasKamar.setBounds(740, 230, 580, 32);

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DAFTAR RAWAT INAP");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 30, 305, 58);

        jLabel3.setText("Nama Pasien");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(630, 160, 90, 20);

        jLabel4.setText("Kamar");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(630, 200, 30, 14);

        jLabel5.setText("Kelas Kamar");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(630, 240, 60, 14);

        jLabel6.setText("Tempat/Tangal Lahir");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(630, 270, 120, 14);

        jLabel7.setText("Nomor HP");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(980, 340, 50, 14);

        jLabel8.setText("Nomor Telepon");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(630, 340, 80, 14);

        jLabel2.setText("Alamat Tinggal");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(630, 410, 100, 14);

        jLabel9.setText("Provinsi");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(970, 480, 80, 14);

        jLabel10.setText("Golongan Darah");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(780, 540, 90, 14);

        jLabel11.setText("Tinggi");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(960, 540, 28, 14);

        jLabel12.setText("Berat");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(1090, 540, 40, 14);

        jLabel13.setText("Umur");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(1220, 540, 25, 14);

        Jenis_Kartu.setText("Jenis Kartu");
        Jenis_Kartu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jenis_KartuMouseClicked(evt);
            }
        });
        Jenis_Kartu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Jenis_KartuFocusGained(evt);
            }
        });
        getContentPane().add(Jenis_Kartu);
        Jenis_Kartu.setBounds(740, 370, 230, 32);

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
        No_Kartu.setBounds(1085, 370, 230, 32);

        jLabel15.setText("Jenis Kartu");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(630, 380, 80, 14);

        jLabel16.setText("Nomor Kartu");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(980, 380, 60, 14);

        tampilTanggal.setBackground(new java.awt.Color(0, 0, 0));
        tampilTanggal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tampilTanggal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tampilTanggal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tanggal", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, null, new java.awt.Color(0, 0, 0)));
        getContentPane().add(tampilTanggal);
        tampilTanggal.setBounds(1050, 50, 130, 40);

        tampilJam.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tampilJam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tampilJam.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jam", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));
        getContentPane().add(tampilJam);
        tampilJam.setBounds(1210, 50, 110, 40);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel17.setText("||");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(1190, 50, 18, 40);

        tglLahir.setText("Tanggal Lahir");
        tglLahir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tglLahirMouseClicked(evt);
            }
        });
        tglLahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglLahirActionPerformed(evt);
            }
        });
        tglLahir.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tglLahirFocusGained(evt);
            }
        });
        getContentPane().add(tglLahir);
        tglLahir.setBounds(840, 290, 160, 30);

        Kota.setText("Kota");
        Kota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KotaMouseClicked(evt);
            }
        });
        Kota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KotaActionPerformed(evt);
            }
        });
        Kota.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                KotaFocusGained(evt);
            }
        });
        getContentPane().add(Kota);
        Kota.setBounds(630, 500, 320, 30);

        Provinsi.setText("Provinsi");
        Provinsi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProvinsiMouseClicked(evt);
            }
        });
        Provinsi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ProvinsiFocusGained(evt);
            }
        });
        getContentPane().add(Provinsi);
        Provinsi.setBounds(970, 500, 350, 30);

        jenis_kelamin.setText("Jenis Kelamin");
        jenis_kelamin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jenis_kelaminMouseClicked(evt);
            }
        });
        jenis_kelamin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jenis_kelaminFocusGained(evt);
            }
        });
        getContentPane().add(jenis_kelamin);
        jenis_kelamin.setBounds(630, 560, 140, 30);

        goldar.setText("Golongan");
        goldar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goldarMouseClicked(evt);
            }
        });
        goldar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                goldarFocusGained(evt);
            }
        });
        getContentPane().add(goldar);
        goldar.setBounds(780, 560, 80, 30);

        jLabel14.setText("Jenis Kelamin");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(630, 540, 80, 14);

        jLabel18.setText("Kota");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(630, 480, 80, 14);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background2.png"))); // NOI18N
        getContentPane().add(jLabel19);
        jLabel19.setBounds(4, 4, 1360, 690);

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

    private void KamarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_KamarFocusGained
        if (j.equals(Kamar.getText())) {
            Kamar.setText("");
        }
    }//GEN-LAST:event_KamarFocusGained

    private void KelasKamarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_KelasKamarFocusGained
        if (j.equals(Kamar.getText())) {
            KelasKamar.setText("");
        }
    }//GEN-LAST:event_KelasKamarFocusGained

    private void konfirmKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konfirmKeluarActionPerformed
        int select = TabelPasien.getSelectedRow();
        DaftarRawatInapController kamar = new DaftarRawatInapController (client);
        try {
            String [] infokamar = {};
            kamar.getNamaKelasKamarbyIdpasien(String.valueOf(tablePasienRawat.getValueAt(select, 0)));
            System.out.println(infokamar[3]);
            kamar.deletePasienKamar(infokamar[3]);
        } catch (RemoteException ex) {
            Logger.getLogger(DaftarRawatInap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_konfirmKeluarActionPerformed

    private void No_HpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No_HpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_No_HpActionPerformed

    private void Jenis_KartuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jenis_KartuMouseClicked
        if (h.equals(Jenis_Kartu.getText())) {
            Jenis_Kartu.setText("");
        }
    }//GEN-LAST:event_Jenis_KartuMouseClicked

    private void Jenis_KartuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Jenis_KartuFocusGained
        if (h.equals(Jenis_Kartu.getText())) {
            Jenis_Kartu.setText("");
        }
    }//GEN-LAST:event_Jenis_KartuFocusGained

    private void No_KartuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_No_KartuMouseClicked
        if (i.equals(No_Kartu.getText())) {
            No_Kartu.setText("");
        }
    }//GEN-LAST:event_No_KartuMouseClicked

    private void No_KartuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_No_KartuFocusGained
        if (i.equals(No_Kartu.getText())) {
            No_Kartu.setText("");
        }
    }//GEN-LAST:event_No_KartuFocusGained

    private void CariPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariPasienActionPerformed
         if (evt.getSource() instanceof JTextField) {
            
        }
    }//GEN-LAST:event_CariPasienActionPerformed

    private void CariPasienFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CariPasienFocusGained
        if (CariPasien.getText().equals("Cari Nama Pasien")) {
            CariPasien.setText("");
        }
    }//GEN-LAST:event_CariPasienFocusGained

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
            DaftarRawatInapController control = new DaftarRawatInapController(client);
            model = control.getNamaPasienRawatInapbyName(CariPasien.getText());
            //System.out.println(model);
            TabelPasien.setModel(model);
        } catch (RemoteException ex) {
            Logger.getLogger(Rawatinap.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_CariPasienKeyReleased

    private void TabelPasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPasienMouseClicked
        
        int row = TabelPasien.getSelectedRow();
        DaftarRawatInapController kamar = new DaftarRawatInapController (client);
        try {
            String [] infokamar = {};
            infokamar = kamar.getNamaKelasKamarbyIdpasien(String.valueOf(TabelPasien.getValueAt(row, 0)));
            
            Tempat_ID.setText(String.valueOf(tablePasienRawat.getValueAt(row, 0)));
            Kota.setText(String.valueOf(tablePasienRawat.getValueAt(row, 1)));
            //Tempat_Lahir.setText(String.valueOf(tablePasienRawat.getValueAt(row, 2)));
            Nama_Pasien.setText(String.valueOf(tablePasienRawat.getValueAt(row, 3)));
            Alamat.setText(String.valueOf(tablePasienRawat.getValueAt(row, 4)));
            Jenis_Kartu.setText(String.valueOf(tablePasienRawat.getValueAt(row, 5)));
            No_Kartu.setText(String.valueOf(tablePasienRawat.getValueAt(row, 6)));
            No_tele.setText(String.valueOf(tablePasienRawat.getValueAt(row, 7)));
            No_Hp.setText(String.valueOf(tablePasienRawat.getValueAt(row, 8)));
            Tempat_Lahir.setText(String.valueOf(tablePasienRawat.getValueAt(row, 9)));
            tglLahir.setText(String.valueOf(tablePasienRawat.getValueAt(row, 10)));
            jenis_kelamin.setText(String.valueOf(tablePasienRawat.getValueAt(row, 11)));
            goldar.setText(String.valueOf(tablePasienRawat.getValueAt(row, 12)));
            BeratPasien.setText(String.valueOf(tablePasienRawat.getValueAt(row, 13)));
            TinggiPasien.setText(String.valueOf(tablePasienRawat.getValueAt(row, 14)));
            Kamar.setText(infokamar[0]);
            KelasKamar.setText(infokamar[1]);
            
        } catch (RemoteException ex) {
            Logger.getLogger(DaftarRawatInap.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_TabelPasienMouseClicked

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        try {
            new Menursepsionis (this.client, this.userName).show();
        
        } catch (RemoteException ex) {
            Logger.getLogger(DaftarRawatInap.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_kembaliActionPerformed

    private void Tempat_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tempat_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tempat_IDActionPerformed

    private void tglLahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglLahirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tglLahirActionPerformed

    private void tglLahirFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tglLahirFocusGained
        if (bb.equals(tglLahir.getText())) {
            tglLahir.setText(""); }
    }//GEN-LAST:event_tglLahirFocusGained

    private void tglLahirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tglLahirMouseClicked
        if (bb.equals(tglLahir.getText())) {
            tglLahir.setText("");
        }
    }//GEN-LAST:event_tglLahirMouseClicked

    private void KotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KotaActionPerformed

    private void KotaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_KotaFocusGained
        if (c1.equals(Kota.getText())) {
            Kota.setText("");
        }// TODO add your handling code here:
    }//GEN-LAST:event_KotaFocusGained

    private void KotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KotaMouseClicked
        if (c1.equals(Kota.getText())) {
            Kota.setText("");
        } // TODO add your handling code here:
    }//GEN-LAST:event_KotaMouseClicked

    private void ProvinsiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProvinsiFocusGained
        if (c2.equals(Provinsi.getText())) {
            Provinsi.setText("");
        } // TODO add your handling code here:
    }//GEN-LAST:event_ProvinsiFocusGained

    private void ProvinsiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProvinsiMouseClicked
        if (c2.equals(Provinsi.getText())) {
            Provinsi.setText("");
        }// TODO add your handling code here:
    }//GEN-LAST:event_ProvinsiMouseClicked

    private void jenis_kelaminFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jenis_kelaminFocusGained
        if (l.equals(jenis_kelamin.getText())) {
            jenis_kelamin.setText("");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jenis_kelaminFocusGained

    private void jenis_kelaminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jenis_kelaminMouseClicked
        if (l.equals(jenis_kelamin.getText())) {
            jenis_kelamin.setText("");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jenis_kelaminMouseClicked

    private void goldarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_goldarFocusGained
        if (m.equals(goldar.getText())) {
            goldar.setText("");
        }// TODO add your handling code here:
    }//GEN-LAST:event_goldarFocusGained

    private void goldarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goldarMouseClicked
        if (m.equals(goldar.getText())) {
            goldar.setText("");
        }// TODO add your handling code here:
    }//GEN-LAST:event_goldarMouseClicked

    private void UmurPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UmurPasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UmurPasienActionPerformed
public void setJam() {
    ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
          Calendar cal = new GregorianCalendar();
        String nolJam = "";
        String nolMenit = "";
        String nolDetik = "";
        String nolTanggal = "";
        String nolBulan = "";
        String nolTahun = "";
        // Membuat Date
        Date dt = new Date();
        // Mengambil nilaj JAM, MENIT, dan DETIK Sekarang
        int nilaiJam = dt.getHours();
        int nilaiMenit = dt.getMinutes();
        int nilaiDetik = dt.getSeconds();
        int nilaiTanggal = cal.get(Calendar.DAY_OF_MONTH);
        int nilaiBulan = cal.get(Calendar.MONTH);
        
        int nilaiTahun = cal.get(Calendar.YEAR);
        // Jika nilai JAM lebih kecil dari 10 (hanya 1 digit)
        if (nilaiJam <= 9) {
          // Tambahkan "0" didepannya
          nolJam = "0";
        }
        // Jika nilai MENIT lebih kecil dari 10 (hanya 1 digit)
        if (nilaiMenit <= 9) {
          // Tambahkan "0" didepannya
          nolMenit = "0";
        }
        // Jika nilai DETIK lebih kecil dari 10 (hanya 1 digit)
        if (nilaiDetik <= 9) {
          // Tambahkan "0" didepannya
          nolDetik = "0";
        }
        if (nilaiTanggal<10){
            nolTanggal="0";
        }
        if ((nilaiBulan+1)<10){
            nolBulan="0";
        }
        if (nilaiTahun<10){
            nolTahun="0";
        }
        // Membuat String JAM, MENIT, DETIK
        String jam = nolJam + Integer.toString(nilaiJam);
        String menit = nolMenit + Integer.toString(nilaiMenit);
        String detik = nolDetik + Integer.toString(nilaiDetik);
        String tanggal = nolTanggal + Integer.toString(nilaiTanggal);
        String bulan = nolBulan + Integer.toString(nilaiBulan+1);
        String tahun = nolTahun + Integer.toString(nilaiTahun);
        // Menampilkan pada Layar
        tampilJam.setText(jam+":"+menit+":"+detik);
        tampilTanggal.setText(tahun+"-"+bulan+"-"+tanggal);
      }
    };
    // Timer
    new Timer(1000, taskPerformer).start();
  }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Alamat;
    private javax.swing.JTextField BeratPasien;
    private javax.swing.JTextField CariPasien;
    private javax.swing.JLabel ID;
    private javax.swing.JTextField Jenis_Kartu;
    private javax.swing.JTextField Kamar;
    private javax.swing.JTextField KelasKamar;
    private javax.swing.JTextField Kota;
    private javax.swing.JTextField Nama_Pasien;
    private javax.swing.JTextField No_Hp;
    private javax.swing.JTextField No_Kartu;
    private javax.swing.JTextField No_tele;
    private javax.swing.JTextField Provinsi;
    public javax.swing.JTable TabelPasien;
    private javax.swing.JTextField Tempat_ID;
    private javax.swing.JTextField Tempat_Lahir;
    private javax.swing.JTextField TinggiPasien;
    private javax.swing.JTextField UmurPasien;
    private javax.swing.JTextField goldar;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jenis_kelamin;
    private javax.swing.JButton kembali;
    private javax.swing.JButton konfirmKeluar;
    private javax.swing.JLabel tampilJam;
    private javax.swing.JLabel tampilTanggal;
    private javax.swing.JTextField tglLahir;
    // End of variables declaration//GEN-END:variables
}
