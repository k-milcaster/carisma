package carismaresepsionis.boundaries;

import carismaresepsionis.controller.ClientSocket;

/**
 *
 * @author devan
 */
public class Rawatinap extends javax.swing.JFrame {
    private ClientSocket client;
    private String userName;
    public Rawatinap(ClientSocket client, String userName) {
        this.client = client;
        this.userName = userName;
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);

        //   tanggalkustom();
    }

//    void awalan
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablelistkamarpasien = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        carnampas = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablepasien = new javax.swing.JTable();
        idpasien = new javax.swing.JTextField();
        namapasien = new javax.swing.JTextField();
        kategoripenypasien = new javax.swing.JTextField();
        typekamar = new javax.swing.JTextField();
        nokamar = new javax.swing.JTextField();
        ok = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tombolCari = new javax.swing.JButton();
        tarif = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

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
                "Block Nomor", "Type", "Tarif", "Fasilitas"
            }
        ));
        jScrollPane1.setViewportView(tablelistkamarpasien);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(426, 179, 540, 402);

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("List Kamar Kosong");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(426, 133, 452, 40);

        carnampas.setText("Cari Nama Pasien");
        carnampas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carnampasActionPerformed(evt);
            }
        });
        getContentPane().add(carnampas);
        carnampas.setBounds(10, 130, 330, 40);

        tablepasien.setModel(new javax.swing.table.DefaultTableModel(
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
                "Nama Pasien"
            }
        ));
        jScrollPane2.setViewportView(tablepasien);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 179, 406, 402);

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

        kategoripenypasien.setText("Kategori Penyakit Pasien");
        getContentPane().add(kategoripenypasien);
        kategoripenypasien.setBounds(990, 270, 360, 31);

        typekamar.setText("Type");
        getContentPane().add(typekamar);
        typekamar.setBounds(990, 370, 170, 32);

        nokamar.setText("Block Nomor");
        getContentPane().add(nokamar);
        nokamar.setBounds(990, 330, 170, 32);

        ok.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1428228446_ok.png"))); // NOI18N
        ok.setText("OK");
        getContentPane().add(ok);
        ok.setBounds(990, 460, 110, 41);

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registrasi Rawat Inap");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 30, 360, 50);

        tombolCari.setText("CARI");
        getContentPane().add(tombolCari);
        tombolCari.setBounds(350, 130, 57, 40);

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

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background2.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 1370, 690);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tarifActionPerformed

    private void carnampasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carnampasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carnampasActionPerformed

    private void idpasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idpasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idpasienActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField carnampas;
    private javax.swing.JTextField idpasien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField kategoripenypasien;
    private javax.swing.JTextField namapasien;
    private javax.swing.JTextField nokamar;
    private javax.swing.JButton ok;
    private javax.swing.JTable tablelistkamarpasien;
    private javax.swing.JTable tablepasien;
    private javax.swing.JTextField tarif;
    private javax.swing.JButton tombolCari;
    private javax.swing.JTextField typekamar;
    // End of variables declaration//GEN-END:variables
}
