package carismakasir.boundary;

import carismakasir.controller.LoginController;
import carismainterface.server.UserService;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import carismakasir.controller.ClientSocket;
import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author K-MiL Caster
 */
public class Login extends javax.swing.JFrame {

    private ClientSocket client;
    private UserService login;
    
    public Login() throws RemoteException, NotBoundException {
        setHostPort();
        this.login = client.getUserService();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        username.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        getContentPane().add(username);
        username.setBounds(180, 350, 240, 40);

        password.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password);
        password.setBounds(180, 400, 240, 40);

        loginButton.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        loginButton.setText("Log In");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton);
        loginButton.setBounds(320, 450, 100, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("User Name :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 360, 135, 29);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Password   :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 410, 133, 29);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismakasir/image/backgroundlogin.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 1360, 760);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        if (username.getText().equalsIgnoreCase("") || password.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "User Name atau Password anda belum terisi!");
        } else {
            LoginController login = new LoginController(this.login, username.getText(), password.getText());
            boolean success = false;
            try {
                success = login.logIn();
            } catch (RemoteException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (success) {
                try {
                    new Kasir(this.client, username.getText()).show();
                    this.dispose();
                } catch (RemoteException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "User Name atau Password anda salah!");
            }
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        if (evt.getSource() instanceof JTextField) {
            if (username.getText().equalsIgnoreCase("") || password.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "User Name atau Password anda belum terisi!");
            } else {
                LoginController login = new LoginController(this.login, username.getText(), password.getText());
                boolean success = false;
                try {
                    success = login.logIn();
                } catch (RemoteException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (success) {
                    try {
                        new Kasir(this.client, username.getText()).show();
                        this.dispose();
                    } catch (RemoteException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "User Name atau Password anda salah!");
                }
            }
        }
    }//GEN-LAST:event_passwordActionPerformed

    private void setHostPort() throws RemoteException, NotBoundException {
            Scanner s = null;
            try {
                s = new Scanner(new File("D:/carismaconfig"));
            } catch (FileNotFoundException ex) {

            }
            ArrayList<String> list = new ArrayList<String>();
            while (s.hasNext()) {
                list.add(s.next());
            }
            s.close();
            client = new ClientSocket(list.get(0), Integer.parseInt(list.get(1)));
            client.Connect();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
