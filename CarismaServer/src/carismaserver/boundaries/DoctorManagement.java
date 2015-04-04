package carismaserver.boundaries;

import carismainterface.entity.Dokter;
import carismainterface.entity.User;
import carismaserver.controllers.DatabaseConnection;
import carismaserver.entity.DokterEntity;
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
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author K-MiL Caster
 */
public class DoctorManagement extends javax.swing.JFrame {

    private carismaserver.controllers.DokterManagement control = new carismaserver.controllers.DokterManagement();
    private DokterEntity dokterService;
    public Main ui;
    private File file;
    private DatabaseConnection databaseConnection;

    public DoctorManagement(final Main ui) throws RemoteException, SQLException {
        this.ui = ui;
        initComponents();
        control.getDokter(this);
        setComboBox();
        tableDokter.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                int row = tableDokter.getSelectedRow();
                if (row != -1) {
                    try {
                        dokterService = new DokterEntity(ui);
                        Dokter selected = new Dokter(dokterService.getDokter(tableDokter.getValueAt(row, 1).toString()));                        
                        fieldId.setText(selected.getIdDokter());
                        fieldNama.setText(selected.getNamaDokter());
                        fieldAlamat.setText(selected.getAlamatDokter());
                        fieldNokartuid.setText(selected.getNokartuidDokter());
                        fieldTelepon.setText(selected.getTelpDokter());
                        fieldHP1.setText(selected.getHp1Dokter());
                        fieldHP2.setText(selected.getHp2Dokter());
                        fieldTempat.setText(selected.getTelpDokter());
                        fieldTanggal.setText(selected.getTgllahirDokter());
                        comboKelamin.setSelectedItem(selected.getKelaminDokter());
                        comboDarah.setSelectedItem(selected.getDarahDokter());
                        fieldBank.setText(selected.getBankDokter());
                        fieldNorek.setText(selected.getNorekDokter());
                        fieldGajiFix.setText((String) selected.getGajifixDokter().toString());
                        fieldGajiLembur.setText((String) selected.getGajilemburDokter().toString());
                        fieldGajiKonsul.setText((String) selected.getGajikonsulDokter().toString());
                        setComboBox(selected.getUserIdUser());
                    } catch (RemoteException ex) {
                        Logger.getLogger(DoctorManagement.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(DoctorManagement.class.getName()).log(Level.SEVERE, null, ex);
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDokter = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
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
        fieldPoli = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        fieldGajiFix = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        fieldGajiLembur = new javax.swing.JTextField();
        fieldGajiKonsul = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        fieldNorek = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        fieldBank = new javax.swing.JTextField();
        foto = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        buttonAttach = new javax.swing.JButton();
        buttonInsert = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableDokter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Nama", "Alamat", "No Kartu ID", "Telepon", "HP1", "HP2", "Tempat Lahir", "Tanggal Lahir", "Jenis Kelamin", "Golongan Darah", "Bank", "No Rek", "Gaji Fix", "Gaji Lembur", "Gaji Konsul"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableDokter);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("DOKTER MANAGEMENT");

        jLabel7.setText("Tanggal Lahir :");

        jLabel2.setText("Nama Dokter :");

        fieldTanggal.setText("yyyy-mm-dd");
        fieldTanggal.setToolTipText("yyyy-mm-dd");
        fieldTanggal.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel4.setText("Alamat Dokter :");

        jLabel1.setText("id Dokter :");

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

        jLabel22.setText("id Poli :");

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
                        .addGap(9, 9, 9)
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
                            .addComponent(fieldPoli))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(fieldPoli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel21.setText("Gaji Konsul :");

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
                    .addComponent(jLabel21)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldBank)
                    .addComponent(fieldNorek)
                    .addComponent(fieldGajiFix)
                    .addComponent(fieldGajiLembur)
                    .addComponent(fieldGajiKonsul, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(fieldGajiKonsul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/boundaries/Untitled.jpg"))); // NOI18N
        foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        foto.setMaximumSize(new java.awt.Dimension(72, 96));
        foto.setMinimumSize(new java.awt.Dimension(72, 96));
        foto.setPreferredSize(new java.awt.Dimension(72, 96));

        jLabel17.setText("Foto:");

        buttonAttach.setText("ATTACH");
        buttonAttach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAttachActionPerformed(evt);
            }
        });

        buttonInsert.setText("INSERT");
        buttonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertActionPerformed(evt);
            }
        });

        buttonUpdate.setText("UPDATE");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        buttonDelete.setText("DELETE");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(buttonAttach)
                                            .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(139, 139, 139)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(buttonInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(buttonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonAttach)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonInsert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonUpdate)
                                .addGap(13, 13, 13)
                                .addComponent(buttonDelete)
                                .addGap(78, 78, 78)))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            String bank = fieldBank.getText();
            String norek = fieldNorek.getText();
            byte[] img = extractBytes(file.toPath().toString());
            int gfix = Integer.parseInt(fieldGajiFix.getText());
            int glembur = Integer.parseInt(fieldGajiLembur.getText());
            double gkonsul = Double.parseDouble(fieldGajiKonsul.getText());
            control.insertDokter(this, userid, id, nama, alamat, nokartu, telp, hp1, hp2, tempat, tanggal, kelamin, darah, bank, norek, gfix, glembur, gkonsul, img);
            control.getDokter(this);
        } catch (RemoteException ex) {
            Logger.getLogger(UserManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DoctorManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_buttonInsertActionPerformed

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

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        try {
            String id = fieldId.getText();;
            control.deleteDokter(this, id);
        } catch (RemoteException ex) {
            Logger.getLogger(UserManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

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
    private byte[] extractBytes(String ImageName) throws IOException {
        File fi = new File(ImageName);
        byte[] fileContent = Files.readAllBytes(fi.toPath());

        return fileContent;
    }

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
    private javax.swing.JTextField fieldGajiKonsul;
    private javax.swing.JTextField fieldGajiLembur;
    private javax.swing.JTextField fieldHP1;
    private javax.swing.JTextField fieldHP2;
    private javax.swing.JTextField fieldId;
    private javax.swing.JTextField fieldNama;
    private javax.swing.JTextField fieldNokartuid;
    private javax.swing.JTextField fieldNorek;
    private javax.swing.JTextField fieldPoli;
    private javax.swing.JTextField fieldTanggal;
    private javax.swing.JTextField fieldTelepon;
    private javax.swing.JTextField fieldTempat;
    private javax.swing.JLabel foto;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tableDokter;
    // End of variables declaration//GEN-END:variables
}
