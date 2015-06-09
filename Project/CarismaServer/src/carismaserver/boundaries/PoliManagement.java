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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

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
        getContentPane().add(buttonInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 210, 120, -1));

        buttonUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/1428222456_icon-compose-32.png"))); // NOI18N
        buttonUpdate.setText("UPDATE");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(buttonUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, 120, 40));

        buttonDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/1426717770_circle_close_delete-24.png"))); // NOI18N
        buttonDelete.setText("DELETE");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(buttonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, 120, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);
        jPanel1.add(fieldNama);
        fieldNama.setBounds(80, 80, 229, 39);
        jPanel1.add(fieldId);
        fieldId.setBounds(80, 20, 230, 40);

        jLabel3.setText("Keterangan :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 150, 63, 14);
        jPanel1.add(fieldKeterangan);
        fieldKeterangan.setBounds(80, 140, 229, 36);

        jLabel1.setText("Id Poli :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 40, 36, 14);

        jLabel2.setText("Nama Poli :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 100, 53, 14);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 340, 190));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("POLI MANAGEMENT");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaserver/image/background2.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, -1));

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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePoli;
    // End of variables declaration//GEN-END:variables
}
