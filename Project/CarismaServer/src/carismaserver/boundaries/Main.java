package carismaserver.boundaries;

import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import carismaserver.controllers.ServerSocket;
import java.rmi.RemoteException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author K-MiL Caster
 */
public class Main extends javax.swing.JFrame {

    private ServerSocket socket;
    private String administrator = "";
    public Main(String administrator) {
        initComponents();
        this.administrator = administrator;
        this.setLocationRelativeTo(null);
        this.who.setText(administrator);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        socket = new ServerSocket(this);
        try {
            socket.Start();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        act = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        who = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        iPLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        portLabel = new javax.swing.JLabel();
        userButton = new javax.swing.JButton();
        doctorButton = new javax.swing.JButton();
        staffButton = new javax.swing.JButton();
        poliButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        loggedInList = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel1.setText("Logged In :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(310, 170, 63, 22);

        act.setColumns(20);
        act.setRows(5);
        jScrollPane2.setViewportView(act);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(310, 510, 508, 128);

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel2.setText("Activity :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(310, 490, 70, 22);

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel3.setText("Logged In As :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(310, 130, 106, 30);

        who.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        who.setText(" ");
        who.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(who);
        who.setBounds(440, 130, 80, 30);

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel4.setText("IP Address :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(630, 130, 95, 29);

        iPLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        iPLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(iPLabel);
        iPLabel.setBounds(740, 130, 90, 30);

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel5.setText("Port :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(690, 170, 43, 29);

        portLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        portLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(portLabel);
        portLabel.setBounds(740, 170, 90, 30);

        userButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        userButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/1428233228_conference.png"))); // NOI18N
        userButton.setText("User Management");
        userButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userButtonActionPerformed(evt);
            }
        });
        getContentPane().add(userButton);
        userButton.setBounds(640, 280, 190, 40);

        doctorButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        doctorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/1428233388_doctor.png"))); // NOI18N
        doctorButton.setText("Doctor Management");
        doctorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorButtonActionPerformed(evt);
            }
        });
        getContentPane().add(doctorButton);
        doctorButton.setBounds(640, 330, 190, 40);

        staffButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        staffButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/1428233519_icon-ios7-people-32.png"))); // NOI18N
        staffButton.setText("Staff Management");
        staffButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffButtonActionPerformed(evt);
            }
        });
        getContentPane().add(staffButton);
        staffButton.setBounds(640, 380, 190, 40);

        poliButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        poliButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/1428233570_doctor_suitecase.png"))); // NOI18N
        poliButton.setText("Poli Management");
        poliButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poliButtonActionPerformed(evt);
            }
        });
        getContentPane().add(poliButton);
        poliButton.setBounds(640, 430, 190, 40);

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("SERVER");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(70, 30, 120, 50);

        logoutButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/1428228543_unlock.png"))); // NOI18N
        logoutButton.setText("Log Out");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(logoutButton);
        logoutButton.setBounds(850, 590, 130, 50);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane1.setViewportView(loggedInList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(310, 200, 180, 270);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/background2.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 1359, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userButtonActionPerformed
        try {
            new UserManagement(this).show();
        } catch (RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_userButtonActionPerformed

    private void doctorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorButtonActionPerformed
        try {
            new DokterManagement(this).show();
        } catch (RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_doctorButtonActionPerformed

    private void staffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffButtonActionPerformed
        try {
            new PegawaiManagement(this).show();
        } catch (RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_staffButtonActionPerformed

    private void poliButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poliButtonActionPerformed
        try {
            new PoliManagement(this).show();
        } catch (RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
//        } catch (SQLException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_poliButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        this.dispose();
        new Login().setVisible(true);
        JOptionPane.showMessageDialog(this, "Terima kasih "+administrator+"\nHave a nice day :)", "LogOut", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_logoutButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea act;
    private javax.swing.JButton doctorButton;
    public javax.swing.JLabel iPLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JList loggedInList;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton poliButton;
    public javax.swing.JLabel portLabel;
    private javax.swing.JButton staffButton;
    private javax.swing.JButton userButton;
    private javax.swing.JLabel who;
    // End of variables declaration//GEN-END:variables
}
