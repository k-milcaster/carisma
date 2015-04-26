package carismakasir.controller;

import carismainterface.entity.Kunjungan;
import carismainterface.server.KunjunganService;
import carismainterface.server.PembayaranService;
import carismakasir.boundary.Kasir;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author K-MiL Caster
 */
public class KasirController {

    private PembayaranService pembayaranService;
    private KunjunganService kunjunganService;
    private Kasir ui;

    public KasirController(ClientSocket Client, Kasir ui) {
        this.pembayaranService = Client.getPembayaranService();
        this.kunjunganService = Client.getKunjunganService();
        this.ui = ui;
    }

    public void showBiaya(String idKunjungan) throws RemoteException {
        Kunjungan target = kunjunganService.getKunjungan(idKunjungan);
        DefaultTableModel model = new DefaultTableModel();
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
                model.addRow(new Object[]{no, "Pembelian Obat "+biayaObat.get(i).get(0), biayaObat.get(i).get(1), biayaObat.get(i).get(2), biayaObat.get(i).get(3)});
                no++;
                total = total + Integer.parseInt(biayaObat.get(i).get(3).toString());
            }
        }
        ui.jTable1.setModel(model);
        ui.fieldTotal.setText(total+"");
    }

    public void cetak() {

    }

}
