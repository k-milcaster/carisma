package carismaadministrator.boundary;

import carismaadministrator.controller.ClientSocket;
import carismaadministrator.controller.LoginController;
import carismainterface.server.UserService;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author K-MiL Caster
 */
public class Login extends javax.swing.JFrame {

    private ClientSocket client;
    private UserService login;

    public Login() throws RemoteException, NotBoundException {
        client = new ClientSocket();
        this.login = client.getUserService();
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaadministrator/image/backgroundlogin.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 1360, 760);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        if (username.getText().equals("") || String.valueOf(password.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(null, "User Name atau Password anda belum terisi!", "Login", JOptionPane.WARNING_MESSAGE);
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
                    new MenuAbsensi(client, username.getText()).show();
                } catch (RemoteException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "User Name atau Password anda salah!");
            }

        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        if (evt.getSource() instanceof JTextField) {
            if (username.getText().equals("") || String.valueOf(password.getPassword()).equals("")) {
                JOptionPane.showMessageDialog(null, "User Name atau Password anda belum terisi!", "Login", JOptionPane.WARNING_MESSAGE);
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
                        new MenuAbsensi(client, username.getText()).show();
                    } catch (RemoteException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "User Name atau Password anda salah!");
                }

            }
        }
    }//GEN-LAST:event_passwordActionPerformed
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.out.println("Look & Feel exception");
        }
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
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
