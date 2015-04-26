package carismaapoteker.boundaries;

import carismaapoteker.controller.ClientSocket;
import carismaapoteker.controller.StokObatController;
import carismainterface.entity.Detailobat;
import carismainterface.entity.Obat;
import carismainterface.entity.User;
import carismainterface.server.ObatService;
import java.awt.Color;
import java.awt.Font;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class StokObat extends javax.swing.JFrame {

    private ClientSocket client;
    private String userName;
    public ObatService os;

    private DefaultTableModel tableObat = new DefaultTableModel();

    public StokObat(ClientSocket Client, String userName) throws RemoteException {
        //    
        this.client = Client;
        final StokObatController control = new StokObatController(this.client);
        os = client.getObatService();
        this.userName = userName;
        initComponents();
        labelApotekerName.setText(this.userName);
        setLocationRelativeTo(this);
        this.setExtendedState(this.MAXIMIZED_BOTH);

        control.getObats(this);

        tableMedicine.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                int row = tableMedicine.getSelectedRow();
                if (row != -1) {
                    try {

                        Obat selected = new Obat(os.getObat(tableMedicine.getValueAt(row, 0).toString()));
                        fieldIdMedicine.setText(selected.getIdObat().toString());
                        fieldMedicineName.setText(selected.getNamaObat());
                        fieldQuantity.setText(selected.getQtyObat().toString());
                        fieldMedicineType.setText(selected.getJenisObat());
                        fieldDescribtion.setText(selected.getKeterangan());
                        fieldPrice.setText(selected.getHargajualObat().toString());
                        //if (selected.getStokkritisObat() != null) {
                        //  System.out.println("masuk if "+selected.getStokkritisObat());
                        fieldStokKritis.setText(String.valueOf(selected.getStokkritisObat()));                        
                        tabelDetailObat.setModel(control.getDetailObat(Integer.parseInt(tableMedicine.getValueAt(row, 0).toString())));
                        //}                        
                    } catch (RemoteException ex) {
                        Logger.getLogger(StokObat.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    fieldIdMedicine.getText();

                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableMedicine = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        fieldSearch = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        fieldQuantity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fieldMedicineName = new javax.swing.JTextField();
        fieldPrice = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        fieldIdMedicine = new javax.swing.JTextField();
        fieldMedicineType = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fieldDescribtion = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        fieldStokKritis = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelApotekerName = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelDetailObat = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Carisma Project");
        getContentPane().setLayout(null);

        tableMedicine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Obat", "Nama Obat", "Quantity", "Jenis", "Keterangan", "Harga Jual", "Stok Kritis"
            }
        ));
        tableMedicine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMedicineMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMedicine);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 472, 1030, 217);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel4.setText("Cari");

        fieldSearch.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        fieldSearch.setForeground(new java.awt.Color(204, 204, 204));
        fieldSearch.setText("search by name");
        fieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldSearchActionPerformed(evt);
            }
        });
        fieldSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldSearchFocusLost(evt);
            }
        });
        fieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(10, 10, 10)
                .addComponent(fieldSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(fieldSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addComponent(jLabel4))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 210, 270, 40);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Data Obat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        fieldQuantity.setEditable(false);
        fieldQuantity.setBackground(new java.awt.Color(255, 255, 255));
        fieldQuantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fieldQuantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Quantity");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Id Obat");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Jenis");

        fieldMedicineName.setEditable(false);
        fieldMedicineName.setBackground(new java.awt.Color(255, 255, 255));
        fieldMedicineName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fieldMedicineName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));

        fieldPrice.setEditable(false);
        fieldPrice.setBackground(new java.awt.Color(255, 255, 255));
        fieldPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fieldPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Harga Jual");

        fieldIdMedicine.setEditable(false);
        fieldIdMedicine.setBackground(new java.awt.Color(255, 255, 255));
        fieldIdMedicine.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fieldIdMedicine.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));

        fieldMedicineType.setEditable(false);
        fieldMedicineType.setBackground(new java.awt.Color(255, 255, 255));
        fieldMedicineType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fieldMedicineType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Keterangan");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Nama Obat");

        fieldDescribtion.setEditable(false);
        fieldDescribtion.setBackground(new java.awt.Color(255, 255, 255));
        fieldDescribtion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fieldDescribtion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Stok Kritis");

        fieldStokKritis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fieldStokKritis.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));

        jButton1.setText("Update Stok Kritis");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldMedicineName, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(fieldQuantity)
                    .addComponent(fieldIdMedicine))
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldMedicineType, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(fieldDescribtion)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(fieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fieldStokKritis, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fieldIdMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldMedicineType, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13)
                    .addComponent(fieldStokKritis, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldMedicineName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(fieldDescribtion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel10))
                    .addComponent(fieldPrice))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 255, 1346, 207);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Apoteker :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 175, 94, 22);

        labelApotekerName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(labelApotekerName);
        labelApotekerName.setBounds(110, 175, 199, 22);

        jLabel12.setFont(new java.awt.Font("Agency FB", 1, 55)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Data Obat");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(-530, 50, 1346, 47);

        tabelDetailObat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane2.setViewportView(tabelDetailObat);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(1050, 470, 320, 210);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaapoteker/image/background.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 1366, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldSearchFocusGained
        if (fieldSearch.getText().equals("search by name")) {
            fieldSearch.setText("");
        }
    }//GEN-LAST:event_fieldSearchFocusGained

    private void fieldSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldSearchFocusLost
        if (fieldSearch.getText().equals("")) {
            fieldSearch.setText("search by name");
            fieldSearch.setForeground(Color.gray);
            fieldSearch.setFont(new Font("Tahoma", 2, 12));
        }

    }//GEN-LAST:event_fieldSearchFocusLost

    private void fieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldSearchKeyReleased
        fieldSearch.setForeground(Color.black);
        fieldSearch.setFont(new Font("Tahoma", 0, 12));
        DefaultTableModel model = new DefaultTableModel();
        try {
            StokObatController control = new StokObatController(client);
            model = control.getObatbyName(fieldSearch.getText());
            System.out.println(model);
            tableMedicine.setModel(model);
        } catch (RemoteException ex) {
            Logger.getLogger(StokObat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_fieldSearchKeyReleased

    private void fieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldSearchActionPerformed
        if (evt.getSource() instanceof JTextField) {

        }
    }//GEN-LAST:event_fieldSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//       try {
//           int id = Integer.parseInt(fieldIdMedicine.getText());
//           int stok = Integer.parseInt(fieldStokKritis.getText());
//           
//       }
        try {
            StokObatController controller = new StokObatController(client);
            int row = tableMedicine.getSelectedRow();
            if (row == -1) {
                return;
            }
            int id = Integer.parseInt(fieldIdMedicine.getText());
            String nama = fieldMedicineName.getText();
            int qty = Integer.parseInt(fieldQuantity.getText());
            String jenis = fieldMedicineType.getText();
            String keterangan = fieldDescribtion.getText();
            int hargaJual = Integer.parseInt(fieldPrice.getText());
            int stokKritis = Integer.parseInt(fieldStokKritis.getText());
            controller.updateStokObat(id, nama, qty, jenis, keterangan, hargaJual, stokKritis);
            controller.getObats(this);
//            fieldMedicineName.setText("");
//            fieldQuantity.setText("");
//            fieldMedicineType.setText("");
//            fieldDescribtion.setText("");
//            fieldPrice.setText("");
            fieldStokKritis.setText("");
        } catch (Exception e) {
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableMedicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMedicineMouseClicked
        int row = tableMedicine.getSelectedRow();
        try {
            StokObatController control = new StokObatController(client);
            
           // control.getDetailObat(this, Integer.parseInt(String.valueOf(tableMedicine.getValueAt(row, 0))));
        } catch (Exception e) {
        }
//          TODO add your handling code here:
    }//GEN-LAST:event_tableMedicineMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fieldDescribtion;
    private javax.swing.JTextField fieldIdMedicine;
    private javax.swing.JTextField fieldMedicineName;
    private javax.swing.JTextField fieldMedicineType;
    private javax.swing.JTextField fieldPrice;
    private javax.swing.JTextField fieldQuantity;
    private javax.swing.JTextField fieldSearch;
    private javax.swing.JTextField fieldStokKritis;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelApotekerName;
    public javax.swing.JTable tabelDetailObat;
    public javax.swing.JTable tableMedicine;
    // End of variables declaration//GEN-END:variables
}
