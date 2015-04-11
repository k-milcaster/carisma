/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismadokter.controller;
import carismainterface.entity.Dokter;
import carismainterface.entity.Pasien;
import carismainterface.entity.Rekammedik;
import carismainterface.server.DokterService;
import carismainterface.server.RekammedikService;
import java.rmi.RemoteException;
/**
 *
 * @author User
 */

public class IsiRekamMedisController {
    
    private RekammedikService rekamMedikService;
    
    public IsiRekamMedisController(ClientSocket client) throws RemoteException{
        rekamMedikService = client.getRekamMedikService();
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
    
    public String getIdDokter(){
        Dokter dokter = new Dokter();
        String idDokter = dokter.getIdDokter();
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
