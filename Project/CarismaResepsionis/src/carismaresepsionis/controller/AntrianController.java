package carismaresepsionis.controller;

import carismainterface.entity.Antrian;
import carismainterface.entity.Kunjungan;
import carismainterface.entity.Pasien;
import carismainterface.server.AntrianService;
import carismainterface.server.DokterService;
import carismainterface.server.PasienService;
import carismainterface.server.KunjunganService;
import carismainterface.server.PegawaiService;
import carismainterface.server.PoliService;
import carismaresepsionis.boundaries.Menursepsionis;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adinda
 */
public class AntrianController extends Thread {

    private AntrianService antrianService;
    private PasienService pasienService;
    private DokterService dokterService;
    private PoliService poliService;
    private KunjunganService kunjunganService;
    private PegawaiService pegawaiService;
    private Menursepsionis ui;

    public AntrianController(ClientSocket client) throws RemoteException {
        this.ui = null;
        this.poliService = client.getPoliService();
        this.antrianService = client.getAntrianService();
        this.dokterService = client.getDokterService();
        this.pasienService = client.getPasienService();
        this.kunjunganService = client.getKunjunganService();
        this.pegawaiService = client.getPegawaiService();
    }

    public AntrianController(ClientSocket client, Menursepsionis ui) throws RemoteException {
        this.ui = ui;
        this.poliService = client.getPoliService();
        this.antrianService = client.getAntrianService();
        this.dokterService = client.getDokterService();
        this.pasienService = client.getPasienService();
        this.kunjunganService = client.getKunjunganService();
        this.pegawaiService = client.getPegawaiService();
    }

    public void run() {
        while (true) {
            try {
                ui.tableDaftarAntrian.setModel(this.getAntrian());
            } catch (RemoteException ex) {
                Logger.getLogger(AntrianController.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AntrianController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean deleteAntrian(String idAntrian) throws RemoteException {
        return antrianService.antrianTidakHadir(idAntrian);
    }

    //tambahan disini
    public DefaultTableModel getAntrian() throws RemoteException {
        List<Antrian> list = new ArrayList<Antrian>();
        list = antrianService.getAntrian();
        DefaultTableModel tabelAntrian = new DefaultTableModel();
        tabelAntrian.addColumn("No Antrian");
        tabelAntrian.addColumn("Id");
        tabelAntrian.addColumn("Nama Pasien");
        tabelAntrian.addColumn("Poli");
        tabelAntrian.addColumn("Dokter");
        for (int i = 0; i < list.size(); i++) {

            tabelAntrian.addRow(new Object[]{list.get(i).getNomorAntrian(), list.get(i).getIdAntrian(), pasienService.getPasien(list.get(i).getPasienIdPasien()).getNamaPasien(), dokterService.getDokterById(list.get(i).getDokterIdDokter()).get(2), dokterService.getDokterById(list.get(i).getDokterIdDokter()).get(1)});
        }
        return tabelAntrian;
    }

    public Antrian getAntrianDetail(String id) throws RemoteException {
        Antrian antrian = antrianService.getAntrian(id);
        return antrian;
    }

    public Pasien getDetailPasien(String idPasien) throws RemoteException {
        Pasien pasien = pasienService.getPasien(idPasien);
        return pasien;
    }

    public Kunjungan getDetailKunjungan(String idKunjungan) throws RemoteException {
        Kunjungan kunjungan = kunjunganService.getKunjungan(idKunjungan);
        return kunjungan;
    }

    public String getNamaPegawai(String username) throws RemoteException {
        String[] namaPegawai = pegawaiService.getIdNamaPegawai(username);
        return namaPegawai[0];
    }
}
