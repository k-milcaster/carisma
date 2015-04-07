package carismaserver.boundaries;

import carismainterface.entity.Pegawai;
import carismaserver.controllers.DatabaseConnection;
import carismaserver.entity.StaffEntity;
import com.mysql.jdbc.Statement;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author K-MiL Caster
 */
public class StaffManagement extends javax.swing.JFrame {

    private carismaserver.controllers.PegawaiManagement control = new carismaserver.controllers.PegawaiManagement();
    private StaffEntity staffService;
    public Main ui;
    private File file;
    private DatabaseConnection databaseConnection;

    public StaffManagement(final Main ui) throws RemoteException, SQLException {
        this.ui = ui;
        initComponents();
        control.getPegawai(this);
        setComboBox();
        tablePegawai.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                int row = tablePegawai.getSelectedRow();
                if (row != -1) {
                    try {
                        staffService = new StaffEntity(ui);
                        Pegawai selected = new Pegawai(staffService.getPegawai(tablePegawai.getValueAt(row, 1).toString()));
                        fieldId.setText(selected.getIdPegawai());
                        fieldNama.setText(selected.getNamaPegawai());
                        fieldAlamat.setText(selected.getAlamatPegawai());
                        fieldNokartuid.setText(selected.getNokartuidPegawai());
                        fieldTelepon.setText(selected.getTelpPegawai());
                        fieldHP1.setText(selected.getHp1Pegawai());
                        fieldHP2.setText(selected.getHp2Pegawai());
                        fieldTempat.setText(selected.getTelpPegawai());
                        fieldTanggal.setText(selected.getTgllahirPegawai());
                        comboKelamin.setSelectedItem(selected.getKelaminPegawai());
                        comboDarah.setSelectedItem(selected.getDarahPegawai());
                        fieldBank.setText(selected.getBankPegawai());
                        fieldNorek.setText(selected.getNorekPegawai());
                        fieldGajiFix.setText((String) selected.getGajifixPegawai().toString());
                        fieldGajiLembur.setText((String) selected.getGajilemburPegawai().toString());                        
                        setComboBox(selected.getUserIdUser());
                    } catch (RemoteException ex) {
                        Logger.getLogger(DoctorManagement.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(StaffManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });
    }

    public void setComboBox() throws SQLException {
        comboUsername.removeAllItems();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = (Statement) databaseConnection.getConnection().createStatement();
            resultSet = statement.executeQuery("SELECT id_user, username FROM user");
            while (resultSet.next()) {
                String userName = resultSet.getString("id_user") + " " + resultSet.getString("username");
                comboUsername.addItem(userName);
            }
        } catch (SQLException ex) {
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
            }
            if (statement != null) {
                statement.close();
            }
        }
    }

    public void setComboBox(int id_user) throws SQLException {
        setComboBox();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = databaseConnection.getConnection().prepareStatement("SELECT id_user, username FROM user WHERE id_user = ?");
            statement.setInt(1, id_user);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String userName = resultSet.getString("id_user") + " " + resultSet.getString("username");
                comboUsername.setSelectedItem(userName);
            }
        } catch (SQLException ex) {
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
            }
        }
    }

    private byte[] extractBytes(String ImageName) throws IOException {
        File fi = new File(ImageName);
        byte[] fileContent = Files.readAllBytes(fi.toPath());

        return fileContent;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePegawai = new javax.swing.JTable();
        buttonAttach = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        fieldGajiFix = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        fieldGajiLembur = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        fieldNorek = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        fieldBank = new javax.swing.JTextField();
        buttonUpdate = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        fieldNokartuid = new javax.swing.JTextField();
        fieldAlamat = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fieldTanggal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fieldNama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fieldId = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldTempat = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        comboUsername = new javax.swing.JComboBox();
        comboKelamin = new javax.swing.JComboBox();
        comboDarah = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        fieldTelepon = new javax.swing.JTextField();
        fieldHP1 = new javax.swing.JTextField();
        fieldHP2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        fieldJabatan = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonInsert = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        foto = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(922, 569));
        getContentPane().setLayout(null);

        tablePegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Nama", "Jabatan", "Alamat", "No Kartu ID", "Telepon", "HP1", "HP2", "Tempat Lahir", "Tanggal Lahir", "Jenis Kelamin", "Golongan Darah", "Bank", "No Rek", "Gaji Fix", "Gaji Lembur"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablePegawai);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 480, 1050, 190);

        buttonAttach.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonAttach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/1428315110_icon-archive-32.png"))); // NOI18N
        buttonAttach.setText("ATTACH");
        buttonAttach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAttachActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAttach);
        buttonAttach.setBounds(630, 390, 130, 40);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel19.setText("Gaji Fix :");

        jLabel18.setText("No Rek :");

        jLabel20.setText("Gaji Lembur :");

        jLabel16.setText("Bank :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldBank, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(fieldNorek)
                    .addComponent(fieldGajiFix)
                    .addComponent(fieldGajiLembur))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(fieldBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(fieldNorek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(fieldGajiFix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(fieldGajiLembur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(500, 100, 255, 151);

        buttonUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/1428222456_icon-compose-32.png"))); // NOI18N
        buttonUpdate.setText("UPDATE");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(buttonUpdate);
        buttonUpdate.setBounds(1130, 530, 120, 40);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setText("Tanggal Lahir :");

        jLabel2.setText("Nama Staff :");

        fieldTanggal.setText("yyyy-mm-dd");
        fieldTanggal.setToolTipText("yyyy-mm-dd");
        fieldTanggal.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel4.setText("Alamat Staff :");

        jLabel1.setText("id Staff :");

        jLabel6.setText("Tempat Lahir :");

        jLabel8.setText("Jenis Kelamin :");

        jLabel9.setText("Golongan Darah :");

        jLabel5.setText("No Kartu ID :");

        jLabel10.setText("Username :");

        comboUsername.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--" }));

        comboKelamin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "L", "P" }));

        comboDarah.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "AB", "O" }));

        jLabel13.setText("Telepon :");

        jLabel14.setText("HP 1 :");

        jLabel15.setText("HP 2:");

        jLabel22.setText("Jabatan :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboDarah, 0, 168, Short.MAX_VALUE)
                            .addComponent(comboKelamin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldTanggal)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel10)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldNama)
                            .addComponent(fieldAlamat)
                            .addComponent(fieldNokartuid)
                            .addComponent(fieldTempat)
                            .addComponent(comboUsername, 0, 168, Short.MAX_VALUE)
                            .addComponent(fieldTelepon)
                            .addComponent(fieldHP1)
                            .addComponent(fieldHP2)
                            .addComponent(fieldId)
                            .addComponent(fieldJabatan))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(fieldJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fieldAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fieldNokartuid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(fieldTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(fieldHP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(fieldHP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fieldTempat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(fieldTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comboDarah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(140, 100, 276, 360);

        jLabel17.setText("Foto:");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(500, 280, 26, 14);

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 45)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("STAFF MANAGEMENT");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 20, 310, 50);

        buttonInsert.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/1428222513_icon-ios7-plus-outline-32.png"))); // NOI18N
        buttonInsert.setText("INSERT");
        buttonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertActionPerformed(evt);
            }
        });
        getContentPane().add(buttonInsert);
        buttonInsert.setBounds(1130, 480, 120, 40);

        buttonDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/1426717770_circle_close_delete-24.png"))); // NOI18N
        buttonDelete.setText("DELETE");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(buttonDelete);
        buttonDelete.setBounds(1130, 580, 120, 40);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/boundaries/Untitled.jpg"))); // NOI18N
        foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        foto.setMaximumSize(new java.awt.Dimension(72, 96));
        foto.setMinimumSize(new java.awt.Dimension(72, 96));
        foto.setPreferredSize(new java.awt.Dimension(72, 96));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(foto, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(foto, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(500, 300, 110, 130);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/background2.png"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, 0, 1360, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAttachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAttachActionPerformed
        int o = jFileChooser1.showOpenDialog(this);
        if (0 == jFileChooser1.APPROVE_OPTION) {
            file = jFileChooser1.getSelectedFile();
            Image img = null;
            try {
                img = ImageIO.read(file);
            } catch (IOException e) {
                //e.printStackTrace();
            }
            //System.out.println(file.toPath());
            Image dimg = img.getScaledInstance(72, 102, Image.SCALE_SMOOTH);
            foto.setIcon(new ImageIcon(dimg));
        }
    }//GEN-LAST:event_buttonAttachActionPerformed

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        //        try {
        //            int id = Integer.parseInt(fieldId.getText());
        //            String user = fieldUsername.getText();
        //            String pass = fieldPassword.getText();
        //            String role = (String)comboRole.getItemAt(comboRole.getSelectedIndex());
        //            control.updateUser(this, id, user, pass, role);
        //            control.getUsers(this);
        //        } catch (RemoteException ex) {
        //            Logger.getLogger(UserManagement.class.getName()).log(Level.SEVERE, null, ex);
        //        }
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void buttonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertActionPerformed
        try {
            String userid = comboUsername.getSelectedItem().toString().substring(0, comboUsername.getSelectedItem().toString().indexOf(" "));
            String id = fieldId.getText();
            String nama = fieldNama.getText();
            String alamat = fieldAlamat.getText();
            String nokartu = fieldNokartuid.getText();
            String telp = fieldTelepon.getText();
            String hp1 = fieldHP1.getText();
            String hp2 = fieldHP2.getText();
            String tempat = fieldTempat.getText();
            String tanggal = fieldTanggal.getText();
            String kelamin = comboKelamin.getSelectedItem().toString();
            String darah = comboDarah.getSelectedItem().toString();
            String jabatan = fieldJabatan.getText();
            String bank = fieldBank.getText();
            String norek = fieldNorek.getText();
            byte[] img = extractBytes(file.toPath().toString());
            int gfix = Integer.parseInt(fieldGajiFix.getText());
            int glembur = Integer.parseInt(fieldGajiLembur.getText());
        control.insertPegawai(this, userid, id, nama, alamat, nokartu, telp, hp1, hp2, tempat, tanggal, kelamin, darah, jabatan, bank, norek, gfix, glembur, img);
        control.getPegawai(this);
        } catch (RemoteException ex) {
            Logger.getLogger(UserManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DoctorManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonInsertActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        //        try {
        //            int id = Integer.parseInt(fieldId.getText());;
        //            control.deleteUser(this, id);
        //            control.getUsers(this);
        //        } catch (RemoteException ex) {
        //            Logger.getLogger(UserManagement.class.getName()).log(Level.SEVERE, null, ex);
        //        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAttach;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonInsert;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JComboBox comboDarah;
    private javax.swing.JComboBox comboKelamin;
    private javax.swing.JComboBox comboUsername;
    private javax.swing.JTextField fieldAlamat;
    private javax.swing.JTextField fieldBank;
    private javax.swing.JTextField fieldGajiFix;
    private javax.swing.JTextField fieldGajiLembur;
    private javax.swing.JTextField fieldHP1;
    private javax.swing.JTextField fieldHP2;
    private javax.swing.JTextField fieldId;
    private javax.swing.JTextField fieldJabatan;
    private javax.swing.JTextField fieldNama;
    private javax.swing.JTextField fieldNokartuid;
    private javax.swing.JTextField fieldNorek;
    private javax.swing.JTextField fieldTanggal;
    private javax.swing.JTextField fieldTelepon;
    private javax.swing.JTextField fieldTempat;
    private javax.swing.JLabel foto;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablePegawai;
    // End of variables declaration//GEN-END:variables
}
