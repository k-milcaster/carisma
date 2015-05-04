package carismaadministrator.boundary;

import carismaadministrator.controller.AbsensiController;
import carismaadministrator.controller.ClientSocket;
import carismainterface.server.UserService;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class AbsensiDokter extends javax.swing.JFrame {

    private ClientSocket clientSocket;
    private UserService login;
    private String userName;
    private AbsensiController absensiController;
    private DefaultComboBoxModel comboBoxModelIdDokter = new DefaultComboBoxModel();
    private DefaultTableModel tabelModelAbsensi = new DefaultTableModel();

    public AbsensiDokter(ClientSocket client, final String userName) throws RemoteException {
        clientSocket = client;
        this.userName = userName;
        login = clientSocket.getUserService();
        initComponents();
        absensiController = new AbsensiController(clientSocket);
        comboBoxModelIdDokter = absensiController.getIdDokter();
        comboBoxIdDokter.setModel(comboBoxModelIdDokter);
        labelApotekerName.setText(this.userName);
        tabelModelAbsensi = absensiController.getTabelAbsensiDokter();
        tableAbsensi.setModel(tabelModelAbsensi);
        Date date = new Date();
        jDateChooser1.setDate(date);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        comboBoxIdDokter = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        radioButtonLembur = new javax.swing.JRadioButton();
        radioButtonReguler = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAbsensi = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        labelApotekerName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Carisma");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Absensi Dokter", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Kehadiran");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        comboBoxIdDokter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Id Dokter");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tanggal");

        radioButtonLembur.setBackground(new java.awt.Color(255, 255, 255));
        radioButtonLembur.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioButtonLembur.setText("Lembur");
        radioButtonLembur.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioButtonLemburItemStateChanged(evt);
            }
        });

        radioButtonReguler.setBackground(new java.awt.Color(255, 255, 255));
        radioButtonReguler.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioButtonReguler.setText("Reguler");
        radioButtonReguler.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioButtonRegulerItemStateChanged(evt);
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
                    .add(comboBoxIdDokter, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jDateChooser1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(radioButtonReguler)
                                .add(45, 45, 45)
                                .add(radioButtonLembur)))
                        .add(0, 97, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(comboBoxIdDokter, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 38, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel3)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(radioButtonReguler)
                        .add(radioButtonLembur)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jDateChooser1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 38, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(13, 13, 13)
                        .add(jLabel4)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaadministrator/image/1426717487_save.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(jButton1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 7, Short.MAX_VALUE)
                .add(jButton1))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 236, -1, 220));

        tableAbsensi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Dokter", "Kehadiran Reguler", "Kehadiran Lembur"
            }
        ));
        tableAbsensi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAbsensiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableAbsensi);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 240, 850, 450));

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel7.setText("Administrator :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        labelApotekerName.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        labelApotekerName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(labelApotekerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 189, 310, 30));

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Absensi Dokter");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 480, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaadministrator/image/background2_2.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableAbsensiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAbsensiMouseClicked
        int row = tableAbsensi.getSelectedRow();

        comboBoxIdDokter.setSelectedItem(String.valueOf(tableAbsensi.getValueAt(row, 0)));
        if (String.valueOf(tableAbsensi.getValueAt(row, 1)).equals("1")) {
            radioButtonReguler.setSelected(true);
        }
        if (String.valueOf(tableAbsensi.getValueAt(row, 2)).equals("1")) {
            radioButtonLembur.setSelected(true);
        }
    }//GEN-LAST:event_tableAbsensiMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (radioButtonReguler.isSelected() == false && radioButtonLembur.isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Data yang Anda Masukkan Kurang Lengkap", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            String hadirReguler = "0";
            String hadirLembur = "0";

            if (radioButtonReguler.isSelected()) {
                hadirReguler = "1";
            }
            if (radioButtonLembur.isSelected()) {
                hadirLembur = "1";
            }

            try {
                String[] idDokter = String.valueOf(comboBoxIdDokter.getSelectedItem()).split(" ");
                absensiController.insertAbsensiDokter(String.valueOf(idDokter[0]), hadirReguler, hadirLembur, String.valueOf(new java.sql.Date(jDateChooser1.getDate().getTime())));
                tabelModelAbsensi = absensiController.getTabelAbsensiDokter();
                tableAbsensi.setModel(tabelModelAbsensi);
            } catch (RemoteException ex) {
                Logger.getLogger(AbsensiDokter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void radioButtonRegulerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioButtonRegulerItemStateChanged
        if (radioButtonReguler.isSelected()) {
            radioButtonLembur.setSelected(false);
        }
    }//GEN-LAST:event_radioButtonRegulerItemStateChanged

    private void radioButtonLemburItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioButtonLemburItemStateChanged
        if (radioButtonLembur.isSelected()) {
            radioButtonReguler.setSelected(false);
        }
    }//GEN-LAST:event_radioButtonLemburItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboBoxIdDokter;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelApotekerName;
    private javax.swing.JRadioButton radioButtonLembur;
    private javax.swing.JRadioButton radioButtonReguler;
    public javax.swing.JTable tableAbsensi;
    // End of variables declaration//GEN-END:variables
}
