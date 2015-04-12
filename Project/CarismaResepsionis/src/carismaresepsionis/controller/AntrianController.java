/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import carismainterface.entity.Antrian;
import carismainterface.server.AntrianService;
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
   
    public AntrianController(ClientSocket client) throws RemoteException{
        this.antrianService = client.getAntrianService();
        
                                
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

}
