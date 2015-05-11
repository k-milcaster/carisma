package carismakasir.controller;

import carismainterface.entity.Kunjungan;
import carismainterface.server.KunjunganService;
import carismainterface.server.PembayaranService;
import carismakasir.boundary.Kasir;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author K-MiL Caster
 */
public class KasirController {

    private PembayaranService pembayaranService;
    private KunjunganService kunjunganService;
    private Kasir ui;
    private String printTo = "D:\\";
    private String fileName = ".pdf";

    public KasirController(ClientSocket Client, Kasir ui) {
        this.pembayaranService = Client.getPembayaranService();
        this.kunjunganService = Client.getKunjunganService();
        this.ui = ui;
    }

    public DefaultTableModel showBiaya(String idKunjungan) throws RemoteException {
        Kunjungan target = kunjunganService.getKunjungan(idKunjungan);
        DefaultTableModel model = new DefaultTableModel();
        if (target == null) {
            return model;
        }
        model.addColumn("No.");
        model.addColumn("Nama");
        model.addColumn("Harga satuan");
        model.addColumn("Qty");
        model.addColumn("SubTotal");
        int total = 0;
        int no = 1;
        int biayaDokter = target.getBiayaKunjungan();
        model.addRow(new Object[]{no, "Biaya Dokter", biayaDokter, "-", biayaDokter});
        no++;
        total = total + biayaDokter;
        if (target.getPasienKamarIdPeminjaman() != "kosong") {
            ArrayList biayaKamar = pembayaranService.getBiayaKamar(target.getPasienKamarIdPeminjaman());
            model.addRow(new Object[]{no, "Biaya Kamar", biayaKamar.get(0), biayaKamar.get(1), biayaKamar.get(2)});
            no++;
            total = total + Integer.parseInt(biayaKamar.get(2).toString());
        }
        if (target.getTransaksijualobatIdTransaksijual() != "kosong") {
            ArrayList<ArrayList> biayaObat = pembayaranService.getBiayaObat(target.getTransaksijualobatIdTransaksijual());
            for (int i = 0; i < biayaObat.size(); i++) {
                model.addRow(new Object[]{no, "Pembelian Obat " + biayaObat.get(i).get(0), biayaObat.get(i).get(1), biayaObat.get(i).get(2), biayaObat.get(i).get(3)});
                no++;
                total = total + Integer.parseInt(biayaObat.get(i).get(3).toString());
            }
        }
        return model;
    }

    public int sumTotal(TableModel model) {
        int sum = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            sum = sum + Integer.parseInt(model.getValueAt(i, 4).toString());
        }
        return sum;
    }

    public boolean doBayar(int pembayaran, int biaya) throws FileNotFoundException {
        if (pembayaran >= biaya) {            
            return true;
        } else {
            return false;
        }

    }

    public boolean cetak() throws FileNotFoundException {
        String FILE = this.printTo + "test" + this.fileName;

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            Image header = Image.getInstance("header.png");
            document.add(header);
            Paragraph space = new Paragraph(" ");
            Paragraph title = new Paragraph("Invoice");
            title.setAlignment(Element.ALIGN_CENTER);
            PdfPTable table = new PdfPTable(ui.jTable1.getColumnCount());
            for (int i = 0; i < ui.jTable1.getColumnCount(); i++) {
                table.addCell(ui.jTable1.getColumnName(i));
            }
            for (int i = 0; i < ui.jTable1.getRowCount(); i++) {
                for (int j = 0; j < ui.jTable1.getColumnCount(); j++) {
                    table.addCell(ui.jTable1.getValueAt(i, j).toString());
                }
            }
            Paragraph total = new Paragraph("Total = " + ui.fieldTotal.getText());
            total.setAlignment(Element.ALIGN_RIGHT);
            document.add(space);
            document.add(title);
            document.add(space);
            document.add(table);
            document.add(total);
            document.close();
            JOptionPane.showMessageDialog(null, "Pembayaran Berhasil");
            return true;
        } catch (DocumentException ex) {
            Logger.getLogger(KasirController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Cetak Gagal");
            return false;
        } catch (IOException ex) {
            Logger.getLogger(KasirController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Cetak Gagal");
            return false;
        }
    }

}
