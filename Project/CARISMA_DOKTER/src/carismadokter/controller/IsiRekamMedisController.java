/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismadokter.controller;
import carismadokter.boundaries.IsiResep;
import carismadokter.boundaries.isirekammedis;
import carismainterface.entity.Detailresep;
import carismainterface.entity.Dokter;
import carismainterface.entity.Obat;
import carismainterface.entity.Pasien;
import carismainterface.entity.Penyakit;
import carismainterface.entity.Rekammedik;
import carismainterface.entity.Rekammedikpenyakit;
import carismainterface.entity.Resep;
import carismainterface.entity.User;
import carismainterface.server.DetailresepService;
import carismainterface.server.DokterService;
import carismainterface.server.ObatService;
import carismainterface.server.PenyakitService;
import carismainterface.server.RekammedikService;
import carismainterface.server.RekammedikpenyakitService;
import carismainterface.server.ResepService;
import carismainterface.server.UserService;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
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
    
    
    public IsiRekamMedisController(ClientSocket client) throws RemoteException{
        rekamMedikService = client.getRekamMedikService();
        rekamMedisPenyakitService = client.getRekamMedisPenyakitService();
        resepService = client.getResepService();
        obatService = client.getObatService();
        penyakitService = client.getPenyakitService();
        dokterService = client.getDokterService();
        detailResepService = client.getDetailResepService();
    }
    
    public void insertRekamMedis(String idRekammedik, String idDokter, String idPasien, String tglRekamMedis, String keluhan, String pemeriksaan, String terapi, String alergiObat, String kesimpulanPemeriksaan, String kondisiPasien, String idResep) throws RemoteException{
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
    
    public void insertRekamMedisPenyakit(String idRekamMedis, String idPenyakit) throws RemoteException{
        System.out.println("Eh kesini kook");
        Rekammedikpenyakit rekamMedisPenyakit = new Rekammedikpenyakit(idRekamMedis, idPenyakit);
        rekamMedisPenyakitService.insertRekamMedikPenyakit(rekamMedisPenyakit);
    }
     
    public void insertResep(String idResep, String keterangan) throws RemoteException{
        Resep resep = new Resep();
        resep.setIdResep(idResep);
        resep.setKeterangan(keterangan);
        resepService.insertResep(resep);
    }
    
    public void insertDetailResep(String idDetailResep, String idResep, String namaObat, int quantity, String aturanPakai)throws RemoteException{
        Detailresep detailResep = new Detailresep();
        detailResep.setIdDetailresep(idDetailResep);
        detailResep.setResepIdResep(idResep);
        detailResep.setNamaobatResep(namaObat);
        detailResep.setQtyResep(quantity);
        detailResep.setAturanpakaiResep(aturanPakai);
        detailResepService.insertDetailresep(detailResep);
    }
    
    public String getIdDetailResep() throws RemoteException{
        String idDetailResep = detailResepService.getAutoNumberDetailResep();
        return idDetailResep;
    }
    
    public String getIdResep() throws RemoteException{
        String idResep = resepService.getAutoIdResep();
        return idResep;
    }
    
    public void getNamaObat(IsiResep ui)throws RemoteException{
        List<Obat> list = new ArrayList<Obat>();
        list = obatService.getObat();
        for (int i = 0; i < list.size(); i++) {            
            ui.comboBoxObat.addItem(list.get(i).getNamaObat());
        }               
    }
    
    public void getNamaPenyakit(isirekammedis ui) throws RemoteException{
        List<Penyakit> list = new ArrayList<Penyakit>();
        list = penyakitService.getPenyakit();
        for (int i = 0; i < list.size(); i++) {            
            ui.comboBoxPenyakit.addItem(list.get(i).getIdPenyakit() + " " + list.get(i).getNamaPenyakit());
        }
    }
    
    public String getIdDokter(String userName) throws RemoteException{
        String idDokter = dokterService.getIdDokter(userName);
        return idDokter;
    }
    
    public String getIdRekamMedis(){
        Rekammedik rekamMedik = new Rekammedik();
        String idRekamMedik = rekamMedik.getIdRekammedik();
        return idRekamMedik;
    }
    
    public String getIdPasien(){
        Pasien pasien = new Pasien();
        String idPasien = pasien.getIdPasien();
        return idPasien;
    }
}
