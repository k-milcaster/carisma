/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismadokter.controller;

import carismadokter.boundaries.*;
import carismainterface.entity.*;
import carismainterface.server.*;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author User
 */
public class IsiRekamMedisController {

    private RekammedikService rekamMedikService;
    private RekammedikpenyakitService rekamMedisPenyakitService;
    private ResepService resepService;
    private ObatService obatService;
    private PenyakitService penyakitService;
    private DokterService dokterService;
    private DetailresepService detailResepService;
    private PasienService pasienService;
    private KunjunganService kunjunganService;

    public IsiRekamMedisController(ClientSocket client) throws RemoteException {
        rekamMedikService = client.getRekamMedikService();
        rekamMedisPenyakitService = client.getRekamMedisPenyakitService();
        resepService = client.getResepService();
        obatService = client.getObatService();
        penyakitService = client.getPenyakitService();
        dokterService = client.getDokterService();
        detailResepService = client.getDetailResepService();
        pasienService = client.getPasienService();
        kunjunganService = client.getKunjunganService();
    }

    public void insertRekamMedis(String idRekammedik, String idDokter, String idPasien, String tglRekamMedis, String keluhan, String pemeriksaan, String terapi, String alergiObat, String kesimpulanPemeriksaan, String kondisiPasien, String idResep) throws RemoteException {
        Rekammedik rekamMedik = new Rekammedik();
        rekamMedik.setIdRekammedik(idRekammedik);
        rekamMedik.setDokterIdDokter(idDokter);
        rekamMedik.setPasienIdPasien(idPasien);
        rekamMedik.setTglRekammedik(tglRekamMedis);
        rekamMedik.setKeluhanRekammedik(keluhan);
        rekamMedik.setPemeriksaanRekammedik(pemeriksaan);
        rekamMedik.setTerapiRekammedik(terapi);
        rekamMedik.setAlergiobatRekammedik(alergiObat);
        rekamMedik.setKesimpulanRekammedis(kesimpulanPemeriksaan);
        rekamMedik.setKondisipasienkeluarRekammedis(kondisiPasien);
        rekamMedik.setResepIdResep(idResep);
        rekamMedikService.insertRekamMedik(rekamMedik);
    }

    public void insertRekamMedisPenyakit(String idRekamMedis, String idPenyakit) throws RemoteException {
        Rekammedikpenyakit rekamMedisPenyakit = new Rekammedikpenyakit(idRekamMedis, idPenyakit);
        rekamMedisPenyakitService.insertRekamMedikPenyakit(rekamMedisPenyakit);
    }

    public void insertResep(String idResep, String keterangan) throws RemoteException {
        Resep resep = new Resep();
        resep.setIdResep(idResep);
        resep.setKeterangan(keterangan);
        resepService.insertResep(resep);
    }

    public void insertDetailResep(String idDetailResep, String idResep, String namaObat, int quantity, String aturanPakai) throws RemoteException {
        Detailresep detailResep = new Detailresep();
        detailResep.setIdDetailresep(idDetailResep);
        detailResep.setResepIdResep(idResep);
        detailResep.setNamaobatResep(namaObat);
        detailResep.setQtyResep(quantity);
        detailResep.setAturanpakaiResep(aturanPakai);
        detailResepService.insertDetailresep(detailResep);
    }
    
    public void insertKunjungan(String idKunjungan, String idPasien, String idRekamMedik, String tglKunjungan, int biaya) throws RemoteException{
        Kunjungan kunjungan = new Kunjungan();
        kunjungan.setIdKunjungan(idKunjungan);
        kunjungan.setPasienIdPasien(idPasien);
        kunjungan.setRekammedikIdRekammedik(idRekamMedik);
        kunjungan.setTransaksijualobatIdTransaksijual("kosong");
        kunjungan.setPasienKamarIdPeminjaman("kosong");
        kunjungan.setTanggaljamKunjungan(tglKunjungan);
        kunjungan.setBiayaKunjungan(biaya);
        kunjunganService.insertKunjungan(kunjungan);
    }

    public String getIdDetailResep() throws RemoteException {
        String lastIdidDetailResep = detailResepService.getLastIdDetailResep();
        String awalan = "DETRES-".concat(getDateNow().concat("-"));
        //DETRES-2015-04-14-001

        String idDetailResepFix = " ";

        String getDateOnly = " ";
        if (lastIdidDetailResep != null) {
            char[] charDate = lastIdidDetailResep.toCharArray();
            char[] newCharDate = new char[10];
            for (int i = 0; i < 10; i++) {
                newCharDate[i] = charDate[i + 7];
            }
            getDateOnly = String.valueOf(newCharDate);
        }
        if (lastIdidDetailResep == null || (!getDateNow().equals(getDateOnly))) {
            idDetailResepFix = awalan.concat("001");
        } else {
            char[] lastDigit = lastIdidDetailResep.toCharArray();
            char[] newLastDigit = new char[3];
            for (int i = 0; i < 3; i++) {
                newLastDigit[i] = lastDigit[i + 18];
            }
            int lastDigitIdDetail = Integer.parseInt(String.valueOf(newLastDigit)) + 1;
            if (lastDigitIdDetail < 10) {
                idDetailResepFix = awalan.concat("00").concat(String.valueOf(lastDigitIdDetail));
            } else if (lastDigitIdDetail >= 10 && lastDigitIdDetail < 100) {
                idDetailResepFix = awalan.concat("0").concat(String.valueOf(lastDigitIdDetail));
            } else if (lastDigitIdDetail >= 100) {
                idDetailResepFix = awalan.concat("").concat(String.valueOf(lastDigitIdDetail));
            }
        }
        return idDetailResepFix;
    }

    public String getIdResep() throws RemoteException {
        String lastIdResep = resepService.getLastIdResep();
        String awalan = "RES-".concat(getDateNow().concat("-"));
        //RES-2015-04-14-001
        String idResepFix = " ";
        String getDateOnly = " ";
        if (lastIdResep != null) {
            char[] charDate = lastIdResep.toCharArray();
            char[] newCharDate = new char[10];
            for (int i = 0; i < 10; i++) {
                newCharDate[i] = charDate[i + 4];
            }
            getDateOnly = String.valueOf(newCharDate);
        }
        if (lastIdResep == null || (!getDateNow().equals(getDateOnly))) {
            idResepFix = awalan.concat("001");
        } 
        else {
            char[] lastDigit = lastIdResep.toCharArray();
            char[] newLastDigit = new char[3];
            for (int i = 0; i < 3; i++) {
                newLastDigit[i] = lastDigit[i + 15];
            }
            int lastDigitIdDetail = Integer.parseInt(String.valueOf(newLastDigit)) + 1;
            if (lastDigitIdDetail < 10) {
                idResepFix = awalan.concat("00").concat(String.valueOf(lastDigitIdDetail));
            } else if (lastDigitIdDetail >= 10 && lastDigitIdDetail < 100) {
                idResepFix = awalan.concat("0").concat(String.valueOf(lastDigitIdDetail));
            } else if (lastDigitIdDetail >= 100) {
                idResepFix = awalan.concat(String.valueOf(lastDigitIdDetail));
            }
        }
        return idResepFix;
    }

    public String getIdRekamMedis() throws RemoteException {
        String lastIdRekamMedik = rekamMedikService.getlastIdRekamMedik();
        String[] splitDateNow = getDateNow().split("-");
        String dateNow = splitDateNow[0].concat(splitDateNow[1]).concat(splitDateNow[2]);
        String awalan = "REKMED-".concat(dateNow).concat("-");
        //REKMED-20150418-001
        String idRekamMedisFix = " ";
        String getDateOnly = " ";
        if (lastIdRekamMedik != null) {
            char[] charDate = lastIdRekamMedik.toCharArray();
            char[] newCharDate = new char[8];
            for (int i = 0; i < 8; i++) {
                newCharDate[i] = charDate[i + 7];
            }
            getDateOnly = String.valueOf(newCharDate);
        }
        if (lastIdRekamMedik == null || (!dateNow.equals(getDateOnly))) {
            idRekamMedisFix = awalan.concat("001");
        } 
        else {
            char[] lastDigit = lastIdRekamMedik.toCharArray();
            char[] newLastDigit = new char[3];
            for (int i = 0; i < 3; i++) {
                newLastDigit[i] = lastDigit[i + 16];
            }
            int lastDigitIdDetail = Integer.parseInt(String.valueOf(newLastDigit)) + 1;
            if (lastDigitIdDetail < 10) {
                idRekamMedisFix = awalan.concat("00").concat(String.valueOf(lastDigitIdDetail));
            } else if (lastDigitIdDetail >= 10 && lastDigitIdDetail < 100) {
                idRekamMedisFix = awalan.concat("0").concat(String.valueOf(lastDigitIdDetail));
            } else if (lastDigitIdDetail >= 100) {
                idRekamMedisFix = awalan.concat(String.valueOf(lastDigitIdDetail));
            }
        }
        return idRekamMedisFix;
    }
    
    public String getIdKunjungan() throws RemoteException{
        String lastIdKunjungan = kunjunganService.getLastIdKunjungan();
        String[] splitDateNow = getDateNow().split("-");
        String dateNow = splitDateNow[0].concat(splitDateNow[1]).concat(splitDateNow[2]);
        String awalan = "VIS-".concat(dateNow).concat("-");
        // VIS-20150420-001
        String idKunjunganFix = " ";
        String getDateOnly = " ";
        if (lastIdKunjungan != null) {
            char[] charDate = lastIdKunjungan.toCharArray();
            char[] newCharDate = new char[8];
            for (int i = 0; i < 8; i++) {
                newCharDate[i] = charDate[i + 4];
            }
            getDateOnly = String.valueOf(newCharDate);
        }
        if (lastIdKunjungan == null || !dateNow.equals(getDateOnly)) {
            idKunjunganFix = awalan.concat("001");
        }
        else {
            char[] lastDigit = lastIdKunjungan.toCharArray();
            char[] newLastDigit = new char[3];
            for (int i = 0; i < 3; i++) {
                newLastDigit[i] = lastDigit[i + 13];
            }
            int lastDigitIdDetail = Integer.parseInt(String.valueOf(newLastDigit)) + 1;
            if (lastDigitIdDetail < 10) {
                idKunjunganFix = awalan.concat("00").concat(String.valueOf(lastDigitIdDetail));
            } else if (lastDigitIdDetail >= 10 && lastDigitIdDetail < 100) {
                idKunjunganFix = awalan.concat("0").concat(String.valueOf(lastDigitIdDetail));
            } else if (lastDigitIdDetail >= 100) {
                idKunjunganFix = awalan.concat(String.valueOf(lastDigitIdDetail));
            }
        }
        return idKunjunganFix;
    }

    public DefaultComboBoxModel getNamaObat() throws RemoteException {
        DefaultComboBoxModel listNamaObat = new DefaultComboBoxModel();
        List<Obat> list = new ArrayList<Obat>();
        list = obatService.getObat();
        for (int i = 0; i < list.size(); i++) {
            listNamaObat.addElement(list.get(i).getNamaObat());
        }
        return listNamaObat;
    }

    public DefaultComboBoxModel getNamaPenyakit() throws RemoteException {
        DefaultComboBoxModel listNamaPenyakit = new DefaultComboBoxModel();
        List<Penyakit> list = new ArrayList<Penyakit>();
        list = penyakitService.getPenyakit();
        for (int i = 0; i < list.size(); i++) {
            listNamaPenyakit.addElement(list.get(i).getIdPenyakit() + " " + list.get(i).getNamaPenyakit());
        }
        return listNamaPenyakit;
    }

    public String[] getIdNamaDokter(String userName) throws RemoteException {
        String[] dokterInfor = dokterService.getIdNamaDokter(userName);
        return dokterInfor;
    }

    public boolean cekIdPasien(String idPasien) throws RemoteException {
        boolean registered = false;
        if (pasienService.getPasien(idPasien) != null) {
            registered = true;
        }
        return registered;
    }

    public String getDateNow() throws RemoteException {
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        String date = df.format(new java.util.Date());
        return date;
    }
}
