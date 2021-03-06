package carismaserver.boundaries;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import carismaserver.entity.UserEntity;
import carismainterface.entity.User;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author K-MiL Caster
 */
public class UserManagement extends javax.swing.JFrame {

    private carismaserver.controllers.UserController control = new carismaserver.controllers.UserController();
    private UserEntity userService;
    public Main ui;

    public UserManagement(final Main ui) throws RemoteException {
        this.ui = ui;
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        tableUser.setModel(control.getUsers(this));
        tableUser.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                int row = tableUser.getSelectedRow();
                if (row != -1) {
                    try {
                        userService = new UserEntity(ui);
                        User selected = new User(userService.getUser(tableUser.getValueAt(row, 1).toString()));
                        fieldId.setText(selected.getIdUser().toString());
                        fieldUsername.setText(selected.getUsername());
                        fieldPassword.setText(selected.getPassword());
                        comboRole.setSelectedItem(selected.getRole());
                    } catch (RemoteException ex) {
                        Logger.getLogger(UserManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });
    }

    public void clear(){
        fieldId.setText("");
        fieldUsername.setText("");
        fieldPassword.setText("");
        comboRole.setSelectedIndex(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUser = new javax.swing.JTable();
        buttonInsert = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        fieldUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboRole = new javax.swing.JComboBox();
        fieldId = new javax.swing.JTextField();
        fieldPassword = new javax.swing.JTextField();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 45)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("USER MANAGEMENT");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(90, 20, 310, 50);

        tableUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Username", "Password", "Registered", "Last Login", "Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableUser);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(160, 340, 1030, 270);

        buttonInsert.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/1428222513_icon-ios7-plus-outline-32.png"))); // NOI18N
        buttonInsert.setText("INSERT");
        buttonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertActionPerformed(evt);
            }
        });
        getContentPane().add(buttonInsert);
        buttonInsert.setBounds(440, 170, 120, 41);

        buttonUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/1428222456_icon-compose-32.png"))); // NOI18N
        buttonUpdate.setText("UPDATE");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(buttonUpdate);
        buttonUpdate.setBounds(440, 220, 120, 40);

        buttonDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/1426717770_circle_close_delete-24.png"))); // NOI18N
        buttonDelete.setText("DELETE");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(buttonDelete);
        buttonDelete.setBounds(440, 270, 120, 40);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("ID User :");

        jLabel2.setText("Username :");

        jLabel4.setText("Password :");

        jLabel5.setText("Role :");

        comboRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "administrator", "doctor", "staff", "resepsionis", "pasien", "apoteker" }));

        fieldId.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldId)
                    .addComponent(fieldUsername)
                    .addComponent(fieldPassword)
                    .addComponent(comboRole, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(160, 150, 253, 158);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/background2.png"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 1360, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertActionPerformed
        if(!fieldUsername.getText().equalsIgnoreCase("") && !fieldPassword.getText().equalsIgnoreCase("") && comboRole.getSelectedIndex() != 0){
            try {
                String user = fieldUsername.getText();
                String pass = fieldPassword.getText();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                String now = dateFormat.format(date);
                System.out.println(now);
                String role = (String) comboRole.getItemAt(comboRole.getSelectedIndex());
                boolean success = control.insertUser(this, user, pass, now, role);
                if (success) {
                    JOptionPane.showMessageDialog(this, "Insert User berhasil", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Insert User gagal", "Gagal", JOptionPane.ERROR_MESSAGE);
                }
                tableUser.setModel(control.getUsers(this));
                clear();
            } catch (RemoteException ex) {
                Logger.getLogger(UserManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Ada yang belum terisi", "Data kurang lengkap", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_buttonInsertActionPerformed

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        if(!fieldUsername.getText().equalsIgnoreCase("") && !fieldPassword.getText().equalsIgnoreCase("") && comboRole.getSelectedIndex() != 0){
            try {
                int id = Integer.parseInt(fieldId.getText());
                String user = fieldUsername.getText();
                String pass = fieldPassword.getText();
                String role = (String) comboRole.getItemAt(comboRole.getSelectedIndex());
                boolean success = control.updateUser(this, id, user, pass, role);
                if (success) {
                    JOptionPane.showMessageDialog(this, "Update User berhasil", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Update User gagal", "Gagal", JOptionPane.ERROR_MESSAGE);
                }
                tableUser.setModel(control.getUsers(this));
                clear();
            } catch (RemoteException ex) {
                Logger.getLogger(UserManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Ada yang belum terisi", "Data kurang lengkap", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        if(!fieldUsername.getText().equalsIgnoreCase("") && !fieldPassword.getText().equalsIgnoreCase("") && comboRole.getSelectedIndex() != 0){
            try {
                int id = Integer.parseInt(fieldId.getText());;
                boolean success = control.deleteUser(this, id);
                if (success) {
                    JOptionPane.showMessageDialog(this, "Delete User berhasil", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Delete User gagal", "Gagal", JOptionPane.ERROR_MESSAGE);
                }
                tableUser.setModel(control.getUsers(this));
                clear();
            } catch (RemoteException ex) {
                Logger.getLogger(UserManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Ada yang belum terisi", "Data kurang lengkap", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonInsert;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JComboBox comboRole;
    private javax.swing.JTextField fieldId;
    private javax.swing.JTextField fieldPassword;
    private javax.swing.JTextField fieldUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tableUser;
    // End of variables declaration//GEN-END:variables
}
