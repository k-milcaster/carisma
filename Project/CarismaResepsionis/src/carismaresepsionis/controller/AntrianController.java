/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import carismainterface.entity.Antrian;
import carismainterface.entity.Dokter;
import carismainterface.entity.Kunjungan;
import carismainterface.entity.Pasien;
import carismainterface.server.AntrianService;
import carismainterface.server.DokterService;
import carismainterface.server.PasienService;
import carismainterface.server.KunjunganService;
import carismaresepsionis.boundaries.Menursepsionis;
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
    private KunjunganService kunjunganService;
   
    public AntrianController(ClientSocket client) throws RemoteException{
        this.antrianService = client.getAntrianService();
        this.dokterService = client.getDokterService();
        this.pasienService = client.getPasienService();
        this.kunjunganService = client.getKunjunganService();
        
                                
    }
    public DefaultTableModel getAntrian(Menursepsionis ui) throws RemoteException{
        List<Antrian> list = new ArrayList<Antrian>();
        list = antrianService.getAntrian();
        DefaultTableModel tabelAntrian = new DefaultTableModel();
        tabelAntrian.addColumn("No Antrian");
        tabelAntrian.addColumn("Id");
        tabelAntrian.addColumn("Nama Pasien");
        for (int i = 0; i < list.size(); i++) {
            tabelAntrian.addRow(new Object[]{list.get(i).getNomorAntrian(), list.get(i).getIdAntrian(), pasienService.getPasien(list.get(i).getPasienIdPasien()).getNamaPasien()});            
            System.out.println("get antrian pasien");
        }
        ui.tableDaftarAntrian.setModel(tabelAntrian);
        return tabelAntrian;
    }
    
    public Antrian getAntrianDetail(String id) throws RemoteException{
        Antrian antrian = antrianService.getAntrian(id);
        return antrian;
    }
    
    public Pasien getDetailPasien(String idPasien) throws RemoteException{
        Pasien pasien = pasienService.getPasien(idPasien);
        return pasien;
    }
    
    public Kunjungan getDetailKunjungan(String idKunjungan) throws RemoteException{
        Kunjungan kunjungan = kunjunganService.getKunjungan(idKunjungan);
        return kunjungan;
    }

    
    

}
