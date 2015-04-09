package carismaadministrator.boundary;

import java.util.Date;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class AbsensiDokter extends javax.swing.JFrame {

    private DefaultTableModel tabelModelAbsensi;
    public AbsensiDokter() {
        initComponents();
        Date date = new Date();
        jDateChooser1.setDate(date);
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        comboBoxIdPegawai = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        radioButtonTidak = new javax.swing.JRadioButton();
        radioButtonYa = new javax.swing.JRadioButton();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAbsensi = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelApotekerName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Carisma");
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Absensi Dokter", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Kehadiran");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        comboBoxIdPegawai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboBoxIdPegawai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kamil", "Fitri", "Fiqi", "Sinta", "Novita", " " }));
        comboBoxIdPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxIdPegawaiActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Id Dokter");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tanggal");

        radioButtonTidak.setBackground(new java.awt.Color(255, 255, 255));
        radioButtonTidak.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioButtonTidak.setText("Lembur");
        radioButtonTidak.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioButtonTidakItemStateChanged(evt);
            }
        });

        radioButtonYa.setBackground(new java.awt.Color(255, 255, 255));
        radioButtonYa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioButtonYa.setText("Reguler");
        radioButtonYa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioButtonYaItemStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(jLabel3)
                    .add(jLabel4))
                .add(44, 44, 44)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(comboBoxIdPegawai, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jDateChooser1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(radioButtonYa)
                                .add(45, 45, 45)
                                .add(radioButtonTidak)))
                        .add(0, 84, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(comboBoxIdPegawai, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 38, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel3)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(radioButtonYa)
                        .add(radioButtonTidak)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jDateChooser1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 38, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(13, 13, 13)
                        .add(jLabel4)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 229, 431, 189);

        jToolBar1.setRollover(true);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaadministrator/image/1426717487_save.png"))); // NOI18N
        jButton1.setText("SAVE");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaadministrator/image/1428222456_icon-compose-32.png"))); // NOI18N
        jButton2.setText("EDIT");
        jButton2.setFocusable(false);
        jToolBar1.add(jButton2);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaadministrator/image/1426717770_circle_close_delete-24.png"))); // NOI18N
        jButton3.setText("DELETE");
        jButton3.setFocusable(false);
        jToolBar1.add(jButton3);

        getContentPane().add(jToolBar1);
        jToolBar1.setBounds(450, 230, 230, 41);

        tableAbsensi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Dokter", "Kehadiran Reguler", "Kehadiran Lembur"
            }
        ));
        jScrollPane1.setViewportView(tableAbsensi);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 429, 1346, 260);

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ABSENSI DOKTER");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(-490, 40, 1366, 58);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Administrator :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 189, 135, 22);

        labelApotekerName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelApotekerName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(labelApotekerName);
        labelApotekerName.setBounds(151, 189, 203, 22);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaadministrator/image/background.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1366, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioButtonTidakItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioButtonTidakItemStateChanged
        if (radioButtonTidak.isSelected()) {
            radioButtonYa.setSelected(false);
        }
    }//GEN-LAST:event_radioButtonTidakItemStateChanged

    private void radioButtonYaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioButtonYaItemStateChanged
        if (radioButtonYa.isSelected()) {
            radioButtonTidak.setSelected(false);
        }
    }//GEN-LAST:event_radioButtonYaItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nama = String.valueOf(comboBoxIdPegawai.getSelectedItem());
        int row = tableAbsensi.getSelectedRowCount();
        String hadir = "0";
        
        if (radioButtonYa.isSelected()) {
            hadir = "1";
        }
        tabelModelAbsensi = (DefaultTableModel)tableAbsensi.getModel();
        Object values[] = {nama, hadir, 0};
        tabelModelAbsensi.addRow(values);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboBoxIdPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxIdPegawaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxIdPegawaiActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch(Exception ex){
            System.out.println("Look & Feel exception");
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AbsensiDokter().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboBoxIdPegawai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelApotekerName;
    private javax.swing.JRadioButton radioButtonTidak;
    private javax.swing.JRadioButton radioButtonYa;
    private javax.swing.JTable tableAbsensi;
    // End of variables declaration//GEN-END:variables
}
