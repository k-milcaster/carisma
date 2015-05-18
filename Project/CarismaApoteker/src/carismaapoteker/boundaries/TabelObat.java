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
        tableMedicine.setModel(tabelObat);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMedicine = new javax.swing.JTable();
        fieldCariobat = new javax.swing.JTextField();

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

        tableMedicine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"OB08980", "Aspirin", "7000"},
                {"OB08978", "Paracetamol", "8000"},
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

        fieldCariobat.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        fieldCariobat.setForeground(new java.awt.Color(204, 204, 204));
        fieldCariobat.setText("cari obat");
        fieldCariobat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCariobatActionPerformed(evt);
            }
        });
        fieldCariobat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldCariobatFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldCariobatFocusLost(evt);
            }
        });
        fieldCariobat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCariobatKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(fieldCariobat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fieldCariobat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMedicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMedicineMouseClicked
        int row = tableMedicine.getSelectedRow();
        String id = String.valueOf(tableMedicine.getValueAt(row, 0));
        String nama = String.valueOf(tableMedicine.getValueAt(row, 1));
        String quantity = String.valueOf(tableMedicine.getValueAt(row, 2));

        ui.jTableOfSales.setValueAt(id, ui.row, 0);
        ui.jTableOfSales.setValueAt(nama, ui.row, 1);
       // ui.jTableOfSales.setValueAt(quantity, ui.row, 2);
        ui.row++;

        this.dispose();
    }//GEN-LAST:event_tableMedicineMouseClicked

    private void fieldCariobatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldCariobatFocusGained
        if (fieldCariobat.getText().equals("cari obat")) {
            fieldCariobat.setText("");
        }
    }//GEN-LAST:event_fieldCariobatFocusGained

    private void fieldCariobatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldCariobatFocusLost
        if (fieldCariobat.getText().equals("")) {
            fieldCariobat.setText("cari obat");
            fieldCariobat.setFont(new Font("Tahoma", 0, 11));
            fieldCariobat.setForeground(Color.gray);
        }
    }//GEN-LAST:event_fieldCariobatFocusLost

    private void fieldCariobatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCariobatKeyReleased
        fieldCariobat.setForeground(Color.black);
        fieldCariobat.setFont(new Font("Tahoma", 0, 12));
        DefaultTableModel model = new DefaultTableModel();
        try {
            StokObatController control = new StokObatController(client);
            model = control.getObatbyName(fieldCariobat.getText());
            System.out.println(model);
            tableMedicine.setModel(model);
        } catch (RemoteException ex) {
            Logger.getLogger(StokObat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_fieldCariobatKeyReleased

    private void fieldCariobatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCariobatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariobatActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fieldCariobat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public javax.swing.JTable tableMedicine;
    // End of variables declaration//GEN-END:variables
}
