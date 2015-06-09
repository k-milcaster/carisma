package carismaserver.boundaries;

import carismainterface.entity.Pegawai;
import carismainterface.entity.User;
import carismaserver.controllers.DatabaseConnection;
import carismaserver.entity.PegawaiEntity;
import carismaserver.entity.UserEntity;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class PegawaiManagement extends javax.swing.JFrame {

    private carismaserver.controllers.PegawaiController control = new carismaserver.controllers.PegawaiController();
    private PegawaiEntity staffService;
    private UserEntity userService;
    public Main ui;
    private File file;
    private byte[] img = null;
    private DatabaseConnection databaseConnection;
    public List<User> users = new ArrayList<User>();

    public PegawaiManagement(final Main ui) throws RemoteException, SQLException {
        this.ui = ui;
        initComponents();
        userService = new UserEntity(ui);
        tablePegawai.setModel(control.getPegawai(this));
        users = userService.getUser();
        comboUsernamePopupMenuWillBecomeVisible(null);
        tablePegawai.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                int row = tablePegawai.getSelectedRow();
                if (row != -1) {
                    try {
                        staffService = new PegawaiEntity(ui);
                        Pegawai selected = new Pegawai(staffService.getPegawai(tablePegawai.getValueAt(row, 1).toString()));
                        fieldId.setText(selected.getIdPegawai());
                        fieldJabatan.setText(selected.getJabatanPegawai());
                        fieldNama.setText(selected.getNamaPegawai());
                        areaAlamat.setText(selected.getAlamatPegawai());
                        fieldNokartuid.setText(selected.getNokartuidPegawai());
                        fieldTelepon.setText(selected.getTelpPegawai());
                        fieldHP1.setText(selected.getHp1Pegawai());
                        fieldHP2.setText(selected.getHp2Pegawai());
                        fieldTempat.setText(selected.getTempatlahirPegawai());
                        fieldTanggal.setText(selected.getTgllahirPegawai());
                        comboKelamin.setSelectedItem(selected.getKelaminPegawai());
                        comboDarah.setSelectedItem(selected.getDarahPegawai());
                        fieldBank.setText(selected.getBankPegawai());
                        fieldNorek.setText(selected.getNorekPegawai());
                        fieldGajiFix.setText((String) selected.getGajifixPegawai().toString());
                        fieldGajiLembur.setText((String) selected.getGajilemburPegawai().toString());
                        comboUsername.setSelectedItem((userService.getUserById(selected.getUserIdUser())).getUsername());
                        img = selected.getFotoPegawai();
                        if (img != null) {
                            Image imgs = Toolkit.getDefaultToolkit().createImage(img);
                            Image dimg = imgs.getScaledInstance(160, 160, Image.SCALE_SMOOTH);
                            ImageIcon icon = new ImageIcon(dimg);
                            foto.setIcon(icon);
                        } else {
                            foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/Preview.jpg")));
                        }
                    } catch (RemoteException ex) {
                        Logger.getLogger(DokterManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });
    }

    public void clear() {
        this.file = null;
        this.img = null;
        comboUsername.setSelectedItem("--");
        fieldJabatan.setText("");
        fieldId.setText("");
        fieldNama.setText("");
        areaAlamat.setText("");
        fieldNokartuid.setText("");
        fieldTelepon.setText("");
        fieldHP1.setText("");
        fieldHP2.setText("");
        fieldTempat.setText("");
        fieldTanggal.setText("yyyy-mm-dd");
        comboKelamin.setSelectedItem("L");
        comboDarah.setSelectedItem("A");
        fieldBank.setText("");
        fieldNorek.setText("");
        fieldGajiFix.setText("");
        fieldGajiLembur.setText("");
        foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/Preview.jpg")));
    }

    private byte[] extractBytes(String ImageName) throws IOException {
        File fi = new File(ImageName);
        byte[] fileContent = Files.readAllBytes(fi.toPath());

        return fileContent;
    }

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
        jLabel6 = new javax.swing.JLabel();
        fieldTempat = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        fieldTanggal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        comboKelamin = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        comboDarah = new javax.swing.JComboBox();
        buttonUpdate = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        fieldNokartuid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fieldNama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        fieldId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboUsername = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        fieldTelepon = new javax.swing.JTextField();
        fieldHP1 = new javax.swing.JTextField();
        fieldHP2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        fieldJabatan = new javax.swing.JTextField();
        areaAlamat = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonInsert = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        foto = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(922, 569));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablePegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 1100, 190));

        buttonAttach.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonAttach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/1428315110_icon-archive-32.png"))); // NOI18N
        buttonAttach.setText("ATTACH");
        buttonAttach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAttachActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAttach, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 360, 130, 40));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setOpaque(false);

        jLabel19.setText("Gaji Fix :");

        jLabel18.setText("No Rek :");

        jLabel20.setText("Gaji Lembur :");

        jLabel16.setText("Bank :");

        jLabel6.setText("Tempat Lahir :");

        jLabel7.setText("Tanggal Lahir :");

        fieldTanggal.setText("yyyy-mm-dd");
        fieldTanggal.setToolTipText("yyyy-mm-dd");
        fieldTanggal.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel8.setText("Jenis Kelamin :");

        comboKelamin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "L", "P" }));

        jLabel9.setText("Golongan Darah :");

        comboDarah.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "AB", "O" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldTempat, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fieldTanggal)
                    .addComponent(comboKelamin, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboDarah, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fieldBank, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(fieldNorek, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(fieldGajiFix, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(fieldGajiLembur, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldTempat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comboDarah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNorek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldGajiFix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldGajiLembur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 150, 290, 230));

        buttonUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/1428222456_icon-compose-32.png"))); // NOI18N
        buttonUpdate.setText("UPDATE");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(buttonUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 550, 120, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setOpaque(false);

        jLabel2.setText("Nama Staff :");

        jLabel4.setText("Alamat Staff :");

        jLabel1.setText("id Staff :");

        jLabel5.setText("No Kartu ID :");

        jLabel10.setText("Username :");

        comboUsername.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--" }));
        comboUsername.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                comboUsernamePopupMenuWillBecomeVisible(evt);
            }
        });

        jLabel13.setText("Telepon :");

        jLabel14.setText("HP 1 :");

        jLabel15.setText("HP 2:");

        jLabel22.setText("Jabatan :");

        areaAlamat.setColumns(20);
        areaAlamat.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        areaAlamat.setLineWrap(true);
        areaAlamat.setRows(5);
        areaAlamat.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel10)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldNama)
                    .addComponent(fieldNokartuid)
                    .addComponent(comboUsername, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fieldTelepon)
                    .addComponent(fieldHP1)
                    .addComponent(fieldHP2)
                    .addComponent(fieldId)
                    .addComponent(fieldJabatan)
                    .addComponent(areaAlamat))
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
                    .addComponent(areaAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 270, 310));

        jLabel17.setText("Foto:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 45)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("STAFF MANAGEMENT");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 310, 50));

        buttonInsert.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/1428222513_icon-ios7-plus-outline-32.png"))); // NOI18N
        buttonInsert.setText("INSERT");
        buttonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertActionPerformed(evt);
            }
        });
        getContentPane().add(buttonInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 500, 120, 40));

        buttonDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/1426717770_circle_close_delete-24.png"))); // NOI18N
        buttonDelete.setText("DELETE");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(buttonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 600, 120, 40));

        foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/Preview.jpg"))); // NOI18N
        foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        foto.setMaximumSize(new java.awt.Dimension(90, 90));
        foto.setMinimumSize(new java.awt.Dimension(90, 90));
        foto.setPreferredSize(new java.awt.Dimension(90, 90));
        getContentPane().add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 170, 160, 160));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 160, 180, 180));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/background2.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAttachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAttachActionPerformed
        int o = jFileChooser1.showOpenDialog(this);
        if (o == jFileChooser1.APPROVE_OPTION) {
            file = jFileChooser1.getSelectedFile();
            Image img = null;
            try {
                this.img = extractBytes(this.file.toPath().toString());
                img = ImageIO.read(file);
            } catch (IOException e) {
                //e.printStackTrace();
            }
            //System.out.println(file.toPath());
            Image dimg = img.getScaledInstance(160, 160, Image.SCALE_SMOOTH);
            foto.setIcon(new ImageIcon(dimg));
        }
    }//GEN-LAST:event_buttonAttachActionPerformed

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        if (!fieldJabatan.getText().equalsIgnoreCase("") && !fieldId.getText().equalsIgnoreCase("") && !fieldNama.getText().equalsIgnoreCase("") && !areaAlamat.getText().equalsIgnoreCase("")
                && !fieldNokartuid.getText().equalsIgnoreCase("") && !fieldTempat.getText().equalsIgnoreCase("") && !fieldTanggal.getText().equalsIgnoreCase("yyyy/mm/dd")) {
            try {
                int userid = users.get(comboUsername.getSelectedIndex()).getIdUser();
                String jabatan = fieldJabatan.getText();
                String id = fieldId.getText();
                String nama = fieldNama.getText();
                String alamat = areaAlamat.getText();
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
                String foto = "";
                byte[] image = null;
                if (img != null) {
                    image = img;
                } else {
                    foto = "Belum memasukkan foto";
                }
                int gfix = 0;
                if(!fieldGajiFix.getText().equalsIgnoreCase("")){
                    gfix = Integer.parseInt(fieldGajiFix.getText());
                }
                int glembur = 0;
                if(!fieldGajiLembur.getText().equalsIgnoreCase("")){
                    glembur = Integer.parseInt(fieldGajiLembur.getText());
                }
                boolean success = control.updatePegawai(this, userid, jabatan, id, nama, alamat, nokartu, telp, hp1, hp2, tempat, tanggal, kelamin, darah, bank, norek, gfix, glembur, image);
                if (success) {
                    JOptionPane.showMessageDialog(this, "Update Pegawai berhasil\n" + foto, "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Update Pegawai gagal", "Gagal", JOptionPane.ERROR_MESSAGE);
                }
                tablePegawai.setModel(control.getPegawai(this));
                clear();
            } catch (RemoteException ex) {
                Logger.getLogger(PegawaiManagement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PegawaiManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Ada yang belum terisi", "Data kurang lengkap", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void buttonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertActionPerformed
        if (!fieldJabatan.getText().equalsIgnoreCase("") && !fieldId.getText().equalsIgnoreCase("") && !fieldNama.getText().equalsIgnoreCase("") && !areaAlamat.getText().equalsIgnoreCase("")
                && !fieldNokartuid.getText().equalsIgnoreCase("") && !fieldTempat.getText().equalsIgnoreCase("") && !fieldTanggal.getText().equalsIgnoreCase("yyyy/mm/dd")) {
            try {
                int userid = users.get(comboUsername.getSelectedIndex()).getIdUser();;
                String jabatan = fieldJabatan.getText();
                String id = fieldId.getText();
                String nama = fieldNama.getText();
                String alamat = areaAlamat.getText();
                String nokartu = fieldNokartuid.getText();
                String telp = fieldTelepon.getText();
                String hp1 = fieldHP1.getText();
                String hp2 = fieldHP2.getText();
                String tempat = fieldTempat.getText();
                String tanggal = fieldTanggal.getText();
                String kelamin = comboKelamin.getSelectedItem().toString();
                System.out.println(kelamin);
                String darah = comboDarah.getSelectedItem().toString();
                String bank = fieldBank.getText();
                String norek = fieldNorek.getText();
                String foto = "";
                byte[] image = null;
                if (img != null) {
                    image = img;
                } else {
                    foto = "Belum memasukkan foto";
                }
                int gfix = 0;
                if(!fieldGajiFix.getText().equalsIgnoreCase("")){
                    gfix = Integer.parseInt(fieldGajiFix.getText());
                }
                int glembur = 0;
                if(!fieldGajiLembur.getText().equalsIgnoreCase("")){
                    glembur = Integer.parseInt(fieldGajiLembur.getText());
                }
                boolean success = control.insertPegawai(this, userid, jabatan, id, nama, alamat, nokartu, telp, hp1, hp2, tempat, tanggal, kelamin, darah, bank, norek, gfix, glembur, image);
                if (success) {
                    JOptionPane.showMessageDialog(this, "Insert Pegawai berhasil\n" + foto, "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Insert Pegawai gagal", "Gagal", JOptionPane.ERROR_MESSAGE);
                }
                tablePegawai.setModel(control.getPegawai(this));
                clear();
            } catch (RemoteException ex) {
                Logger.getLogger(PegawaiManagement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PegawaiManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Ada yang belum terisi", "Data kurang lengkap", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_buttonInsertActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        if (!fieldId.getText().equalsIgnoreCase("")) {
            boolean success;
            try {
                success = control.deletePegawai(this, fieldId.getText());
                if (success) {
                    JOptionPane.showMessageDialog(this, "Delete Pegawai berhasil", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Delete Pegawai gagal", "Gagal", JOptionPane.ERROR_MESSAGE);
                }
                tablePegawai.setModel(control.getPegawai(this));
                clear();
            } catch (RemoteException ex) {
                Logger.getLogger(DokterManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Ada yang belum terisi", "Data kurang lengkap", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void comboUsernamePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboUsernamePopupMenuWillBecomeVisible
        comboUsername.removeAllItems();
        try {
            users = userService.getUserNonDoctor();
        } catch (RemoteException ex) {
            Logger.getLogger(DokterManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < users.size(); i++) {
            comboUsername.addItem(users.get(i).getUsername());
        }
    }//GEN-LAST:event_comboUsernamePopupMenuWillBecomeVisible

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaAlamat;
    private javax.swing.JButton buttonAttach;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonInsert;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JComboBox comboDarah;
    private javax.swing.JComboBox comboKelamin;
    private javax.swing.JComboBox comboUsername;
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
