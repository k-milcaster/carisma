package carismadokter.boundaries;

import carismadokter.controller.ClientSocket;
import carismadokter.controller.IsiRekamMedisController;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class IsiResep extends javax.swing.JFrame {

    private ClientSocket client;
    private isirekammedis ui;
    private ArrayList<Integer> listQuantity = new ArrayList<>();
    private ArrayList<String> listAturanPakai = new ArrayList<>();
    
    public IsiResep(ClientSocket client, isirekammedis ui) throws RemoteException{
        this.client = client;
        IsiRekamMedisController rekamMedisControl = new IsiRekamMedisController(this.client);
        
        initComponents();
        this.ui = ui;
        fieldIdResep.setText(rekamMedisControl.getIdResep());
        rekamMedisControl.getNamaObat(this);
    }

    public String getIdDetailResep()throws RemoteException{
        IsiRekamMedisController rekamMedisControl = new IsiRekamMedisController(this.client);
        String idDetailResep = rekamMedisControl.getIdDetailResep();
        return idDetailResep;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listNamaObat2 = new javax.swing.JList();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listNamaObat1 = new javax.swing.JList();
        comboBoxObat = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        fieldInputObat = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        fieldIdResep = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        textAreaKeterangan = new javax.swing.JTextArea();
        buttonSimpanResep = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        fieldQuantity = new javax.swing.JTextField();
        fieldAturanPakai = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resep Obat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nama Obat");

        listNamaObat2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(listNamaObat2);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Quantity");

        listNamaObat1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listNamaObat1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listNamaObat1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listNamaObat1);

        comboBoxObat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Id Resep");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Keterangan");

        fieldInputObat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fieldInputObat.setForeground(new java.awt.Color(204, 204, 204));
        fieldInputObat.setText("(optional)");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Nama Obat");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismadokter/image/tombol-delete.png"))); // NOI18N

        fieldIdResep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        textAreaKeterangan.setColumns(20);
        textAreaKeterangan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textAreaKeterangan.setLineWrap(true);
        textAreaKeterangan.setRows(5);
        jScrollPane3.setViewportView(textAreaKeterangan);

        buttonSimpanResep.setFont(new java.awt.Font("Agency FB", 1, 12)); // NOI18N
        buttonSimpanResep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismadokter/image/1426717487_save.png"))); // NOI18N
        buttonSimpanResep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanResepActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carismadokter/image/tombol-delete.png"))); // NOI18N

        fieldQuantity.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        fieldAturanPakai.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton1.setText("Add");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Aturan Pakai");

        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24)
                        .addComponent(fieldIdResep, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBoxObat, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(fieldInputObat)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldAturanPakai, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonSimpanResep, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(fieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldIdResep, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxObat)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel7)
                        .addComponent(fieldInputObat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldAturanPakai, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(jLabel11))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonSimpanResep, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSimpanResepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanResepActionPerformed
        if (String.valueOf(comboBoxObat.getSelectedItem()).equals("") || fieldIdResep.getText().equals("") ) {
            JOptionPane.showMessageDialog(null, "Data yang Anda Masukkan Kurang Lengkap", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                IsiRekamMedisController rekamMedisControl = new IsiRekamMedisController(client);

                int pilihan = JOptionPane.showConfirmDialog(null, "Apakah Data yang Anda Masukkan Sudah Benar?","Resep Obat", JOptionPane.YES_NO_OPTION);
                if (pilihan == 0) {
                    rekamMedisControl.insertResep(fieldIdResep.getText(), textAreaKeterangan.getText());
                    for (int i = 0; i < listNamaObat1.getModel().getSize(); i++) {
                        System.out.println("masuk if");
                        rekamMedisControl.insertDetailResep(getIdDetailResep(), fieldIdResep.getText(), String.valueOf(listNamaObat1.getModel().getElementAt(i)), listQuantity.get(i), listAturanPakai.get(i));
                    }
                    JOptionPane.showMessageDialog(null, "Data Resep Obat Sudah Tersimpan","Pemberitahuan",JOptionPane.INFORMATION_MESSAGE);
                    ui.idResep = fieldIdResep.getText();
                    System.out.println(ui.idResep);
                }
            } catch (Exception e) {
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
        String quantity = JOptionPane.showInputDialog(null, "Masukkan Quantity Obat","Quantity Obat",JOptionPane.QUESTION_MESSAGE);
        String aturanPakai = JOptionPane.showInputDialog(null, "Masukkan Aturan Pakai Obat","Aturan Pakai Obat",JOptionPane.QUESTION_MESSAGE);
        listQuantity.add(Integer.parseInt(quantity));
        listAturanPakai.add(aturanPakai);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void listNamaObat1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listNamaObat1MouseClicked
        int row = listNamaObat1.getSelectedIndex();
        fieldQuantity.setText(String.valueOf(listQuantity.get(row)));
        fieldAturanPakai.setText(String.valueOf(listAturanPakai.get(row)));
    }//GEN-LAST:event_listNamaObat1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSimpanResep;
    public javax.swing.JComboBox comboBoxObat;
    private javax.swing.JTextField fieldAturanPakai;
    public javax.swing.JTextField fieldIdResep;
    private javax.swing.JTextField fieldInputObat;
    private javax.swing.JTextField fieldQuantity;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JList listNamaObat1;
    private javax.swing.JList listNamaObat2;
    private javax.swing.JTextArea textAreaKeterangan;
    // End of variables declaration//GEN-END:variables
}
