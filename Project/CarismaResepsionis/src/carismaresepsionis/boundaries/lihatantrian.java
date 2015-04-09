package carismaresepsionis.boundaries;

import carismaresepsionis.controller.ClientSocket;

/**
 *
 * @author Fiqhi Darmawan
 */
public class lihatantrian extends javax.swing.JFrame {

    private ClientSocket client;
    private String userName;

    public lihatantrian(ClientSocket client, String userName) {
        this.client = client;
        this.userName = userName;
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel1.setText("Antrian Pasien");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(55, 74, 295, 60);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel2.setText("Nomor Antrian");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(90, 0, 120, 40);
        jPanel3.add(jTextField1);
        jTextField1.setBounds(20, 40, 250, 90);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(60, 150, 290, 150);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Antrian 1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 12))); // NOI18N
        jPanel5.setLayout(null);
        jPanel5.add(jTextField2);
        jTextField2.setBounds(10, 30, 180, 70);

        jPanel2.add(jPanel5);
        jPanel5.setBounds(20, 40, 200, 110);

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel3.setText("Antrian Pasien");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 10, 140, 29);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Antrian 2", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 12))); // NOI18N
        jPanel6.setLayout(null);
        jPanel6.add(jTextField3);
        jTextField3.setBounds(10, 30, 180, 70);

        jPanel2.add(jPanel6);
        jPanel6.setBounds(250, 40, 200, 110);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Antrian 4", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 12))); // NOI18N
        jPanel8.setLayout(null);
        jPanel8.add(jTextField5);
        jTextField5.setBounds(10, 30, 190, 70);

        jPanel2.add(jPanel8);
        jPanel8.setBounds(730, 40, 210, 110);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Antrian 3", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 12))); // NOI18N
        jPanel7.setLayout(null);
        jPanel7.add(jTextField4);
        jTextField4.setBounds(10, 30, 180, 70);

        jPanel2.add(jPanel7);
        jPanel7.setBounds(490, 40, 200, 110);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Antrian 5", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 12))); // NOI18N
        jPanel9.setLayout(null);
        jPanel9.add(jTextField6);
        jTextField6.setBounds(10, 30, 190, 70);

        jPanel2.add(jPanel9);
        jPanel9.setBounds(990, 40, 210, 110);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Antrian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 10))); // NOI18N
        jPanel4.setLayout(null);
        jPanel4.add(jTextField7);
        jTextField7.setBounds(20, 20, 70, 30);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(540, 160, 110, 60);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(60, 430, 1230, 240);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informasi Pasien", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 24), java.awt.Color.black)); // NOI18N
        jPanel10.setLayout(null);

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel11.setFont(new java.awt.Font("Agency FB", 0, 11)); // NOI18N
        jPanel11.setLayout(null);

        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel11.add(jLabel4);
        jLabel4.setBounds(10, 20, 90, 120);

        jLabel5.setText("Foto");
        jPanel11.add(jLabel5);
        jLabel5.setBounds(10, 0, 34, 14);

        jPanel10.add(jPanel11);
        jPanel11.setBounds(410, 40, 110, 150);

        jLabel6.setText("Nama");
        jPanel10.add(jLabel6);
        jLabel6.setBounds(40, 60, 110, 14);

        jLabel7.setText("Alamat");
        jPanel10.add(jLabel7);
        jLabel7.setBounds(40, 90, 100, 14);

        jLabel8.setText("Golongan Darah");
        jPanel10.add(jLabel8);
        jLabel8.setBounds(40, 120, 130, 14);

        jLabel9.setText("Umur");
        jPanel10.add(jLabel9);
        jLabel9.setBounds(40, 150, 80, 14);

        jLabel10.setText("Tinggi Badan");
        jPanel10.add(jLabel10);
        jLabel10.setBounds(40, 180, 100, 14);

        jLabel11.setText("Berat");
        jPanel10.add(jLabel11);
        jLabel11.setBounds(40, 210, 70, 14);

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jPanel10.add(jTextField8);
        jTextField8.setBounds(160, 50, 210, 20);
        jPanel10.add(jTextField9);
        jTextField9.setBounds(160, 80, 210, 20);

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jPanel10.add(jTextField10);
        jTextField10.setBounds(160, 110, 60, 20);

        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jPanel10.add(jTextField11);
        jTextField11.setBounds(160, 140, 60, 20);
        jPanel10.add(jTextField12);
        jTextField12.setBounds(160, 170, 60, 20);
        jPanel10.add(jTextField13);
        jTextField13.setBounds(160, 200, 60, 20);

        jLabel12.setText("Terakhir Periksa");
        jPanel10.add(jLabel12);
        jLabel12.setBounds(40, 240, 100, 14);
        jPanel10.add(jTextField14);
        jTextField14.setBounds(160, 230, 210, 20);

        getContentPane().add(jPanel10);
        jPanel10.setBounds(380, 70, 540, 300);

        jButton1.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1426718664_circle_back_arrow_-24.png"))); // NOI18N
        jButton1.setText("Back");
        getContentPane().add(jButton1);
        jButton1.setBounds(940, 330, 90, 40);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background2.png"))); // NOI18N
        getContentPane().add(jLabel13);
        jLabel13.setBounds(0, 0, 1360, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
