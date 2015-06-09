package carismakasir.boundary;

import carismakasir.controller.ClientSocket;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author K-MiL Caster
 */
public class FirstInstall extends javax.swing.JFrame {

    /**
     * Creates new form FirstInstall
     */
    private String fileName = "D:/carismaconfig";
    private ClientSocket client;

    public FirstInstall() throws IOException {
        initComponents();
        this.setLocationRelativeTo(this);
        createFile();
    }

    private void createFile() throws FileNotFoundException, IOException {

        FileWriter writer = new FileWriter(fileName, true);
        writer.close();
    }

    private boolean testConnection(String host, int port) throws NotBoundException, RemoteException {
        client = new ClientSocket(host, port);
        return client.testConnection();
    }

    private void saveHostPort(String host, int port) throws IOException {
        FileWriter writer = new FileWriter(fileName, false);
        PrintWriter printLine = new PrintWriter(writer);

        printLine.println(host);
        printLine.println(port);
        printLine.close();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        host = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        port = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Welcome");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));
        getContentPane().add(host, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 184, 261, -1));

        jLabel2.setText("Host :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 187, -1, -1));

        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, -1, -1));

        jLabel3.setText("Port :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 218, -1, -1));
        getContentPane().add(port, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 215, 72, -1));

        jLabel4.setText("<html>Sistem mendeteksi bahwa ini adalah pertama kalinya anda menjalankan \nSistem Carisma Client di PC ini.<br> Sebelum anda bisa mennggunakan modul client ini,\nanda perlu melakukan sedikit konfigurasi yand mudah. <br>Cukup masukkan alamat IP PC Server anda dan portnya agar modul klien ini bisa\nterhubung dengan server. \n<br>\n<br>\n<b> - Pastikan PC klien ini terkoneksi di dalam jaringan yang sama dengan Server<br>\n- Pastikan modul Server sudah dijalankan </html>");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 123));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismakasir/image/FS.jpg"))); // NOI18N
        jLabel6.setText(" ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 550, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!host.getText().equalsIgnoreCase("") && !port.getText().equalsIgnoreCase("")) {
            try {
                if (testConnection(host.getText(), Integer.parseInt(port.getText()))) {
                    JOptionPane.showMessageDialog(null, "Selamat konfigurasi anda berhasil! restart aplikasi untuk memulai");
                    saveHostPort(host.getText(), Integer.parseInt(port.getText()));
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Koneksi gagal");
                }
            } catch (NotBoundException ex) {
                Logger.getLogger(FirstInstall.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(FirstInstall.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FirstInstall.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pastikan inputan anda benar");
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField host;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField port;
    // End of variables declaration//GEN-END:variables
}
