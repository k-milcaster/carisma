package carismaresepsionis.boundaries;

import carismainterface.entity.Jadwal;
import carismainterface.server.DokterService;
import carismainterface.server.JadwaldokterService;
import carismaresepsionis.controller.ClientSocket;
import javax.swing.DefaultListModel;
import carismaresepsionis.controller.LihatJadwalDokterController;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Fiqhi Darmawan
 */
public class jadwaldokter extends javax.swing.JFrame {

    private ClientSocket client;
    private String userName;
    private JadwaldokterService jd;
    private LihatJadwalDokterController LihatJadwalDokterController;
    settergetter simpanan = new settergetter();

    public jadwaldokter(ClientSocket client, String userName, String idDokter) throws RemoteException {
        this.client = client;
        LihatJadwalDokterController control = new LihatJadwalDokterController(this.client);
        jd = client.getJadwaldokterService();
        this.userName = userName;
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        ArrayList<Jadwal> jadwal = new ArrayList();
        jadwal = control.lihatJadwal(idDokter);
        System.out.println(jadwal.get(0).getHariJadwalpegawai());
        for (int i = 0; i < jadwal.size(); i++) {
            String hari = jadwal.get(i).getHariJadwalpegawai();
            if (hari.equals("Senin")) {
                senin.setText(jadwal.get(i).getShiftJadwalpegawai());
                System.out.println(jadwal.get(i).getShiftJadwalpegawai()+" yang di GUI");
            } else if (hari.equals("Selasa")) {
                selasa.setText(jadwal.get(i).getShiftJadwalpegawai());
            } else if (hari.equals("Rabu")) {
                rabu.setText(jadwal.get(i).getShiftJadwalpegawai());
            } else if (hari.equals("Kamis")) {
                kamis.setText(jadwal.get(i).getShiftJadwalpegawai());
            } else if (hari.equals("Jumat")) {
                jumat.setText(jadwal.get(i).getShiftJadwalpegawai());
            } else if (hari.equals("Sabtu")) {
                sabtu.setText(jadwal.get(i).getShiftJadwalpegawai());
            } else if (hari.equals("Minggu")) {
                minggu.setText(jadwal.get(i).getShiftJadwalpegawai());
            }

        }

        // String IdDokter = String.valueOf(control.getJadwalDokterDetail(JadwalId).getDokterIdDokter());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        selasa = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        senin = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        rabu = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jumat = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        kamis = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        sabtu = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        minggu = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel7.setFont(new java.awt.Font("Trajan Pro", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("jadwal praktek dokter");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(70, 30, 550, 44);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selasa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 14))); // NOI18N

        selasa.setEditable(false);
        selasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selasaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selasa, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(selasa, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5);
        jPanel5.setBounds(300, 180, 150, 80);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Senin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 14))); // NOI18N

        senin.setEditable(false);
        senin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seninActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(senin, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(senin, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel7);
        jPanel7.setBounds(80, 180, 160, 80);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rabu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 14))); // NOI18N

        rabu.setEditable(false);
        rabu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rabuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rabu, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(rabu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel9);
        jPanel9.setBounds(530, 180, 150, 80);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jum'at", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 14))); // NOI18N

        jumat.setEditable(false);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jumat, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jumat, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel14);
        jPanel14.setBounds(80, 310, 160, 70);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kamis", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 14))); // NOI18N

        kamis.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(kamis, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(kamis, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(750, 180, 140, 76);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sabtu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 14))); // NOI18N

        sabtu.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sabtu, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sabtu, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(300, 310, 150, 70);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Minggu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 14))); // NOI18N

        minggu.setEditable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(minggu, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(minggu, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel6);
        jPanel6.setBounds(530, 310, 150, 71);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1426718664_circle_back_arrow_-24.png"))); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(760, 340, 90, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background2.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1360, 690);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selasaActionPerformed

    private void seninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seninActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seninActionPerformed

    private void rabuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rabuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rabuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jumat;
    private javax.swing.JTextField kamis;
    private javax.swing.JTextField minggu;
    private javax.swing.JTextField rabu;
    private javax.swing.JTextField sabtu;
    private javax.swing.JTextField selasa;
    private javax.swing.JTextField senin;
    // End of variables declaration//GEN-END:variables
}
