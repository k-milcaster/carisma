/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaserver.boundaries;

import carismainterface.entity.Poli;
import carismaserver.entity.PoliEntity;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author kepoterz
 */
public class PoliManagement extends javax.swing.JFrame {

    private carismaserver.controllers.PoliController control = new carismaserver.controllers.PoliController();
    private PoliEntity poliService;
    public Main ui;
    
    public PoliManagement(final Main ui) throws RemoteException {
        this.ui = ui;
        initComponents();
        tablePoli.setModel(control.getPolis(this));
        tablePoli.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int row = tablePoli.getSelectedRow();
                if (row != -1) {
                    try {
                        poliService = new PoliEntity(ui);
                        Poli selected = new Poli(poliService.getPoli(tablePoli.getValueAt(row, 1).toString()));
                        fieldId.setText(selected.getIdPoli().toString());
                        fieldNama.setText(selected.getNamaPoli());
                        fieldKeterangan.setText(selected.getKeterangan());
                    } catch (RemoteException ex) {
                        Logger.getLogger(PoliManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });
    }

    public void clear(){
        fieldId.setText("");
        fieldNama.setText("");
        fieldKeterangan.setText("");
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablePoli = new javax.swing.JTable();
        buttonInsert = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        fieldNama = new javax.swing.JTextField();
        fieldId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fieldKeterangan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1360, 698));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablePoli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Nama Poli", "Keterangan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablePoli);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 447, 1259, 207));

        buttonInsert.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/1428222513_icon-ios7-plus-outline-32.png"))); // NOI18N
        buttonInsert.setText("INSERT");
        buttonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertActionPerformed(evt);
            }
        });
        getContentPane().add(buttonInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(832, 197, 120, -1));

        buttonUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/1428222456_icon-compose-32.png"))); // NOI18N
        buttonUpdate.setText("UPDATE");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(buttonUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(832, 247, 120, 40));

        buttonDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/1426717770_circle_close_delete-24.png"))); // NOI18N
        buttonDelete.setText("DELETE");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(buttonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(832, 297, 120, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setOpaque(false);

        jLabel3.setText("Keterangan :");

        jLabel1.setText("Id Poli :");

        jLabel2.setText("Nama Poli :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fieldKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 208, -1, -1));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 100, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertActionPerformed
        if(!fieldId.getText().equalsIgnoreCase("") && !fieldNama.getText().equalsIgnoreCase("")){
            try {
                String idpoli = fieldId.getText();
                String namapoli = fieldNama.getText();
                String keterangan = fieldKeterangan.getText();
                boolean success = control.insertPoli(this, idpoli, namapoli, keterangan);
                if (success) {
                    JOptionPane.showMessageDialog(this, "Insert Poli berhasil", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Insert Poli gagal", "Gagal", JOptionPane.ERROR_MESSAGE);
                }
                tablePoli.setModel(control.getPolis(this));
                clear();
            } catch (RemoteException ex) {
                Logger.getLogger(PoliManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Ada yang belum terisi", "Data kurang lengkap", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_buttonInsertActionPerformed

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        if(!fieldId.getText().equalsIgnoreCase("") && !fieldNama.getText().equalsIgnoreCase("")){
            try {
                String idpoli = fieldId.getText();
                String namapoli = fieldNama.getText();
                String keterangan = fieldKeterangan.getText();
                boolean success = control.updatePoli(this, idpoli, namapoli, keterangan);
                if (success) {
                    JOptionPane.showMessageDialog(this, "Update Poli berhasil", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Update Poli gagal", "Gagal", JOptionPane.ERROR_MESSAGE);
                }
                tablePoli.setModel(control.getPolis(this));
                clear();
            } catch (RemoteException ex) {
                Logger.getLogger(PoliManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Ada yang belum terisi", "Data kurang lengkap", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        if(!fieldId.getText().equalsIgnoreCase("") && !fieldNama.getText().equalsIgnoreCase("")){
            try {
                String idpoli = fieldId.getText();;
                boolean success = control.deletePoli(this, idpoli);
                if (success) {
                    JOptionPane.showMessageDialog(this, "Delete Poli berhasil", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Delete Poli gagal", "Gagal", JOptionPane.ERROR_MESSAGE);
                }
                tablePoli.setModel(control.getPolis(this));
                clear();
            } catch (RemoteException ex) {
                Logger.getLogger(PoliManagement.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JTextField fieldId;
    private javax.swing.JTextField fieldKeterangan;
    private javax.swing.JTextField fieldNama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePoli;
    // End of variables declaration//GEN-END:variables
}
