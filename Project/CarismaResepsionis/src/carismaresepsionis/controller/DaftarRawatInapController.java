/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import carismainterface.entity.*;
import carismainterface.server.*;
import carismaresepsionis.boundaries.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vaio Sony
 */
public class DaftarRawatInapController {

    private PasienService pasienService;
    private PasienKamarService pasienkamarService;
    private KamarService kamarService;
    private KunjunganService kunjunganService;

    public DaftarRawatInapController(ClientSocket client) {
        this.pasienService = client.getPasienService();
        this.pasienkamarService = client.getPasienKamarService();
        this.kamarService = client.getKamarService();
        this.kunjunganService = client.getKunjunganService();

    }

    public boolean insertNamaPasien(String idPasien, int idKamar, String namaKamar, String date) throws RemoteException {
        PasienKamar pasienkamar = new PasienKamar();
        pasienkamar.setIdPeminjaman(generatePeminjamanId(idPasien, namaKamar));
        pasienkamar.setKamarIdKamar(idKamar);
        pasienkamar.setDateinPasienKamar(date);
        pasienkamar.setDateoutPasienKamar("1945-08-17");
        pasienkamar.setKeterangan("kosong");
        pasienkamarService.insertPasienKamar(pasienkamar);
        return true;
    }

    public boolean insertDateOut(String dateOut) throws RemoteException {

        PasienKamar pasienkamar = new PasienKamar();
        pasienkamar.setDateoutPasienKamar(dateOut);
        

        pasienkamarService.insertPasienKamar(pasienkamar);
        return true;
    }

    public String generatePeminjamanId(String idPasien, String namaKamar) {
        //String pasienId = Character.toString(idPasien.charAt(0)).toUpperCase() + Character.toString(idPasien.charAt(idPasien.length() - 1)).toUpperCase() + Character.toString(namaKamar.charAt(2)) + Character.toString(namaKamar.charAt(3)) + Character.toString(namaKamar.charAt(5)) + Character.toString(namaKamar.charAt(6)) + Character.toString(namaKamar.charAt(8)) + Character.toString(namaKamar.charAt(9));
        char[] idPsn = idPasien.toCharArray();
        char[] namaKmr = namaKamar.toCharArray();
        String idPeminjaman = "RENT".concat(String.valueOf(idPsn[0])).concat(String.valueOf(idPsn[1])).concat(String.valueOf(namaKmr[0])).concat(String.valueOf(namaKmr[1]));
        System.out.println("ini idPeminjaman "+idPeminjaman);
        return idPeminjaman;
    }

    public DefaultTableModel getNamaPasienRawatInap() throws RemoteException {

        List<Pasien> list = new ArrayList<Pasien>();
        list = pasienService.getPasienRawatinap();
        DefaultTableModel model = new DefaultTableModel();
        
       
        model.addColumn("ID Pasien");
        model.addColumn("nama_pasien");


        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getIdPasien(), list.get(i).getNamaPasien()});
            System.out.println("lewat");
        }

        return model;
    }

    public DefaultTableModel getNamaPasienRawatInapbyName(String nama) throws RemoteException {

        List<Pasien> list = new ArrayList<Pasien>();
        list = pasienService.getPasienRawatinapByName(nama);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Pasien");
        model.addColumn("Nama Pasien");
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getIdPasien(), list.get(i).getNamaPasien()});
            //System.out.println("lewat");
        }

        return model;
    }
    
    

    public String[] getNamaKelasKamarbyIdpasien(String idPasien) throws RemoteException {

        String[] kamarInfo = new String[3];
        kamarInfo = kamarService.getNamaKelasKamarbyIdpasien(idPasien);
        System.out.println(kamarInfo);
        return kamarInfo;
    }
    
    public boolean updateKunjungan(String idpeminjaman, String idKunjungan) throws RemoteException {
        Kunjungan kun = new Kunjungan();
        kun = kunjunganService.getKunjungan(idKunjungan);
        if (kun != null) {
            kun.setPasienKamarIdPeminjaman(idpeminjaman);
            return kunjunganService.updateKunjungan(kun);
        } else {
            return false;
        }
    }
    
    public boolean cekKunjungan(String idKunjungan) throws RemoteException {
        Kunjungan kun = new Kunjungan();
        kun = kunjunganService.getKunjungan(idKunjungan);
        if (kun != null) {         
            return true;
        } else {
            return false;
        }
    }
    
    public boolean updateDateOut(String dateOut, String idPinjam) throws RemoteException {
       
        PasienKamar pasienkamar = new PasienKamar();        
        pasienkamar.setDateoutPasienKamar(dateOut);
        pasienkamar.setIdPeminjaman(idPinjam);
        pasienkamarService.updatePasienKamar(pasienkamar);
        return true;
    }

    
    public Pasien getIdPasien(String idPasien) throws RemoteException {
        Pasien pasien = pasienService.getPasien(idPasien);
        return pasien;
    }

    public PasienKamar getPasienKamar(String idpeminjaman) throws RemoteException {
        PasienKamar pasienKamar = pasienkamarService.getPasienKamar(idpeminjaman);
        return pasienKamar;
    }
}
