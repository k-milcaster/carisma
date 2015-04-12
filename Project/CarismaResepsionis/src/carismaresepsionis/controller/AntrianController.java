/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import carismainterface.entity.Antrian;
import carismainterface.entity.Dokter;
import carismainterface.entity.Pasien;
import carismainterface.server.AntrianService;
import carismainterface.server.DokterService;
import carismainterface.server.PasienService;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adinda
 */
public class AntrianController {
    private AntrianService antrianService;
    private PasienService pasienService;
    private DokterService dokterService;
   
    public AntrianController(ClientSocket client) throws RemoteException{
        this.antrianService = client.getAntrianService();
        this.dokterService = client.getDokterService();
        this.pasienService = client.getPasienService();
        
                                
    }
    public void insertAntrian(String id_antrian, String pasien_id_pasien,String dokter_id_dokter, int nomor_antrian, String jenis_antrian, String tanggal_antrian, String hadir) throws RemoteException {
        Antrian antrian = new Antrian();
        antrian.setIdAntrian(id_antrian);
        antrian.setPasienIdPasien(pasien_id_pasien);
        antrian.setDokterIdDokter(dokter_id_dokter);
        antrian.setNomorAntrian(nomor_antrian);
        antrian.setJenisAntrian(jenis_antrian);
        antrian.setTglAntrian(tanggal_antrian);
        antrian.setHadir(hadir);
        antrianService.insertAntrian(antrian);
    
    }
    public String getIdPasien(){
        Pasien pasien = new Pasien();
        String idPasien = pasien.getIdPasien();
        return idPasien;
    }
    public String getIdDokter(){
        Dokter dokter = new Dokter();
        String idDokter = dokter.getIdDokter();
        return idDokter;
    }

}
