package carismaapoteker.boundaries;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import carismaapoteker.controller.ClientSocket;
import carismaapoteker.controller.StokObatController;
import carismaapoteker.controller.TransaksiJualObatController;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class TabelObat extends javax.swing.JFrame {

    private TransaksiJualObat ui;
    private ClientSocket client;
    private int count;

    public TabelObat(TransaksiJualObat ui, ClientSocket client) throws RemoteException {
        initComponents();
        this.ui = ui;
        this.client = client;
        TransaksiJualObatController control = new TransaksiJualObatController(this.client);
        setLocationRelativeTo(ui);
        DefaultTableModel tabelObat = new DefaultTableModel();
        tabelObat = control.getTableObat();
        setSize(515, 535);
        setLocationRelativeTo(this);
        tableMedicine.setModel(tabelObat);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMedicine = new javax.swing.JTable();
        fieldSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Daftar Obat");
        getContentPane().setLayout(null);

        tableMedicine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id Obat", "Nama", "harga"
            }
        ));
        tableMedicine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMedicineMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableMedicine);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 91, 480, 398);

        fieldSearch.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        fieldSearch.setForeground(new java.awt.Color(204, 204, 204));
        fieldSearch.setText("cari obat");
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
        getContentPane().add(fieldSearch);
        fieldSearch.setBounds(290, 50, 200, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismaapoteker/image/Menu Absensi.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMedicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMedicineMouseClicked
        int row = tableMedicine.getSelectedRow();
        String id = String.valueOf(tableMedicine.getValueAt(row, 0));
        String nama = String.valueOf(tableMedicine.getValueAt(row, 1));
        String quantity = String.valueOf(tableMedicine.getValueAt(row, 2));

        ui.jTableOfSales.setValueAt(id, ui.row, 0);
        ui.jTableOfSales.setValueAt(nama, ui.row, 1);

        this.dispose();
    }//GEN-LAST:event_tableMedicineMouseClicked

    private void fieldSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldSearchFocusGained
        if (fieldSearch.getText().equals("cari obat")) {
            fieldSearch.setText("");
        }
    }//GEN-LAST:event_fieldSearchFocusGained

    private void fieldSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldSearchFocusLost
        if (fieldSearch.getText().equals("")) {
            fieldSearch.setText("cari obat");
            fieldSearch.setFont(new Font("Tahoma", 0, 12));
            fieldSearch.setForeground(Color.gray);
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
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldSearchActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fieldSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public javax.swing.JTable tableMedicine;
    // End of variables declaration//GEN-END:variables
}
