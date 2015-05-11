package carismadokter.boundaries;

import carismadokter.controller.ClientSocket;
import carismadokter.controller.IsiRekamMedisController;
import java.awt.Color;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class IsiResep extends javax.swing.JFrame {

    private ClientSocket client;
    private isirekammedis ui;
    private ArrayList<Integer> listQuantity = new ArrayList<>();
    private ArrayList<String> listAturanPakai = new ArrayList<>();
    private DefaultComboBoxModel listNamaObat = new DefaultComboBoxModel();

    public IsiResep(ClientSocket client, isirekammedis ui) throws RemoteException {
        this.client = client;
        IsiRekamMedisController rekamMedisControl = new IsiRekamMedisController(this.client);

        initComponents();
        this.ui = ui;
        fieldIdResep.setText(rekamMedisControl.getIdResep());
        listNamaObat = rekamMedisControl.getNamaObat();
        comboBoxObat.setModel(listNamaObat);
        setLocationRelativeTo(this);
    }

//    public String getIdDetailResep()throws RemoteException{
//        IsiRekamMedisController rekamMedisControl = new IsiRekamMedisController(this.client);
//        String idDetailResep = rekamMedisControl.getIdDetailResep();
//        return idDetailResep;
//    }
    public void clearField() {
        fieldIdResep.setText("");
        fieldQuantity.setText("");
        fieldAturanPakai.setText("");
        textAreaKeterangan.setText("");
        DefaultListModel model = (DefaultListModel) listNamaObat1.getModel();
        model.removeAllElements();
        listNamaObat1.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listNamaObat1 = new javax.swing.JList();
        comboBoxObat = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        fieldIdResep = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        textAreaKeterangan = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        fieldQuantity = new javax.swing.JTextField();
        fieldAturanPakai = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        buttonSimpanResep = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismadokter/image/Resep.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resep Obat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nama Obat");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 75, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Quantity");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 295, -1, -1));

        listNamaObat1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        listNamaObat1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listNamaObat1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listNamaObat1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listNamaObat1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 105, 260, -1));

        comboBoxObat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(comboBoxObat, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 66, 190, 33));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Id Resep");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 37, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Keterangan");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 382, -1, -1));

        fieldIdResep.setEditable(false);
        fieldIdResep.setBackground(new java.awt.Color(255, 255, 255));
        fieldIdResep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fieldIdResep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        jPanel1.add(fieldIdResep, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 30, 260, 30));

        textAreaKeterangan.setColumns(20);
        textAreaKeterangan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textAreaKeterangan.setLineWrap(true);
        textAreaKeterangan.setRows(5);
        textAreaKeterangan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        jScrollPane3.setViewportView(textAreaKeterangan);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 370, 260, 45));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismadokter/image/tombol-delete.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 241, -1, -1));

        fieldQuantity.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fieldQuantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        jPanel1.add(fieldQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 280, 87, 45));

        fieldAturanPakai.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fieldAturanPakai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        jPanel1.add(fieldAturanPakai, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 280, 85, 45));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Aturan Pakai");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 295, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismadokter/image/1429342283_519691-199_CircledPlus-12.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 66, 52, 33));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismadokter/image/1429342362_checkround-24-12.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 331, 51, 33));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 360, 433));

        buttonSimpanResep.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N
        buttonSimpanResep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismadokter/image/1426717487_save.png"))); // NOI18N
        buttonSimpanResep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanResepActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSimpanResep, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 450, -1, 41));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismadokter/image/Resep.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, -1, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSimpanResepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanResepActionPerformed
        if (String.valueOf(comboBoxObat.getSelectedItem()).equals("") || fieldIdResep.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data yang Anda Masukkan Kurang Lengkap", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                IsiRekamMedisController rekamMedisControl = new IsiRekamMedisController(client);

                int pilihan = JOptionPane.showConfirmDialog(null, "Apakah Data yang Anda Masukkan Sudah Benar?", "Resep Obat", JOptionPane.YES_NO_OPTION);
                if (pilihan == 0) {
                    boolean insertResep = false;
                    boolean insertDetailResep = false;

                    insertResep = rekamMedisControl.insertResep(fieldIdResep.getText(), textAreaKeterangan.getText());
                    for (int i = 0; i < listNamaObat1.getModel().getSize(); i++) {
                        String idDetailResep = rekamMedisControl.getIdDetailResep();
                        insertDetailResep = rekamMedisControl.insertDetailResep(idDetailResep, fieldIdResep.getText(), String.valueOf(listNamaObat1.getModel().getElementAt(i)), listQuantity.get(i), listAturanPakai.get(i));
                    }
                    if (insertDetailResep == true && insertResep == true) {
                        JOptionPane.showMessageDialog(null, "Data Resep Obat Sudah Tersimpan", "Resep", JOptionPane.INFORMATION_MESSAGE);
                        ui.idResep = fieldIdResep.getText();
                        System.out.println(ui.idResep);
                        clearField();
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Resep Obat Tidak Dapat Disimpan", "Resep", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_buttonSimpanResepActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < listNamaObat1.getModel().getSize(); i++) {
            Object item = listNamaObat1.getModel().getElementAt(i);
            model.addElement(item.toString());
        }
        String obat = comboBoxObat.getSelectedItem().toString();
        model.addElement(obat);
        listNamaObat1.setModel(model);
        String quantity = JOptionPane.showInputDialog(null, "Masukkan Quantity Obat", "Quantity Obat", JOptionPane.QUESTION_MESSAGE);
        String aturanPakai = JOptionPane.showInputDialog(null, "Masukkan Aturan Pakai Obat", "Aturan Pakai Obat", JOptionPane.QUESTION_MESSAGE);
        listQuantity.add(Integer.parseInt(quantity));
        listAturanPakai.add(aturanPakai);
        fieldQuantity.setText(quantity);
        fieldAturanPakai.setText(aturanPakai);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void listNamaObat1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listNamaObat1MouseClicked
        int row = listNamaObat1.getSelectedIndex();
        fieldQuantity.setText(String.valueOf(listQuantity.get(row)));
        fieldAturanPakai.setText(String.valueOf(listAturanPakai.get(row)));
    }//GEN-LAST:event_listNamaObat1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultListModel model = (DefaultListModel) listNamaObat1.getModel();
        int row = listNamaObat1.getSelectedIndex();
        model.removeElementAt(row);
        listNamaObat1.setModel(model);
        listQuantity.remove(row);
        listAturanPakai.remove(row);
        fieldQuantity.setText("");
        fieldAturanPakai.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        listQuantity.set(listNamaObat1.getSelectedIndex(), Integer.parseInt(fieldQuantity.getText()));
        listAturanPakai.set(listNamaObat1.getSelectedIndex(), fieldAturanPakai.getText());
        JOptionPane.showMessageDialog(null, "Quantity Obat atau Auturan Pakai\nBerhasil Diubah", "Quantity dan Aturan Pakai", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton5ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSimpanResep;
    public javax.swing.JComboBox comboBoxObat;
    private javax.swing.JTextField fieldAturanPakai;
    public javax.swing.JTextField fieldIdResep;
    private javax.swing.JTextField fieldQuantity;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JList listNamaObat1;
    private javax.swing.JTextArea textAreaKeterangan;
    // End of variables declaration//GEN-END:variables
}
