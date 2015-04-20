package carismakasir.controller;

import carismainterface.entity.Kunjungan;
import carismainterface.server.KunjunganService;
import carismainterface.server.PembayaranService;
import carismakasir.boundary.Kasir;
import java.rmi.RemoteException;
import java.util.ArrayList;

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
        if (target.getPasienKamarIdPeminjaman() != "kosong") {
            ArrayList biayaKamar = pembayaranService.getBiayaKamar(target.getPasienKamarIdPeminjaman());
        }
        if (target.getTransaksijualobatIdTransaksijual() != "kosong") {
            ArrayList<ArrayList> biayaObat = pembayaranService.getBiayaObat(target.getTransaksijualobatIdTransaksijual());
        }        
    }    
    
    public void cetak() {
        
    }
    
}
