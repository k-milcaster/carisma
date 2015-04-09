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
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tablelistkamarpasien.setModel(new javax.swing.table.DefaultTableModel(
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
                "Block Nomor", "Type"
            }
        ));
        jScrollPane1.setViewportView(tablelistkamarpasien);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(426, 179, 452, 402);

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("List Kamar Kosong");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(426, 133, 452, 40);

        carnampas.setText("Cari Nama Pasien");
        getContentPane().add(carnampas);
        carnampas.setBounds(10, 133, 406, 40);

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
        getContentPane().add(idpasien);
        idpasien.setBounds(896, 179, 449, 32);

        namapasien.setText("Nama Pasien");
        getContentPane().add(namapasien);
        namapasien.setBounds(896, 217, 449, 32);

        kategoripenypasien.setText("Kategori Penyakit Pasien");
        getContentPane().add(kategoripenypasien);
        kategoripenypasien.setBounds(896, 255, 449, 31);

        typekamar.setText("Type");
        getContentPane().add(typekamar);
        typekamar.setBounds(896, 292, 284, 32);

        nokamar.setText("Block Nomor");
        getContentPane().add(nokamar);
        nokamar.setBounds(1186, 292, 159, 32);

        ok.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1428228446_ok.png"))); // NOI18N
        ok.setText("OK");
        getContentPane().add(ok);
        ok.setBounds(1235, 336, 110, 41);

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registrasi Rawat Inap");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 30, 360, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background2.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-70, 10, 1400, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField carnampas;
    private javax.swing.JTextField idpasien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField kategoripenypasien;
    private javax.swing.JTextField namapasien;
    private javax.swing.JTextField nokamar;
    private javax.swing.JButton ok;
    private javax.swing.JTable tablelistkamarpasien;
    private javax.swing.JTable tablepasien;
    private javax.swing.JTextField typekamar;
    // End of variables declaration//GEN-END:variables
}
