/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

/**
 *
 * @author Fiqhi Darmawan
 */
import carismainterface.entity.Antrian;
import carismainterface.entity.Dokter;
import carismainterface.entity.Kunjungan;
import carismainterface.entity.Pasien;
import carismainterface.entity.Poli;
import carismainterface.entity.User;
import carismainterface.server.AntrianService;
import carismainterface.server.DokterService;
import carismainterface.server.KotaService;
import carismainterface.server.PasienService;
import carismainterface.server.KunjunganService;
import carismainterface.server.PoliService;
import carismainterface.server.UserService;
import carismaresepsionis.boundaries.Menursepsionis;
import carismaresepsionis.boundaries.antrianoffline;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class AntrianOfflineController {
    private PasienService pasienService;
    private AntrianService antrianService;
    private PoliService poliService;
    private DokterService dokterService;
        
    
     public AntrianOfflineController(ClientSocket client) throws RemoteException {
        this.pasienService = client.getPasienService();
        this.antrianService = client.getAntrianService();
        this.poliService = client.getPoliService();
        this.dokterService = client.getDokterService();
    }
     
       public void InsertAntrian(String id_pasien, String id_dokter, String tanggalAntri) throws RemoteException {
       
        Pasien pasien= new Pasien ();
        Antrian antrian = new Antrian();
        
        int nomer_antrian=antrianService.generateNomorAntrian(tanggalAntri);
        String id_antrian = antrianService.generateIDAntrian();
        antrian.setIdAntrian(id_antrian);
        antrian.setPasienIdPasien(id_pasien);
        antrian.setDokterIdDokter(id_dokter);
        antrian.setNomorAntrian(nomer_antrian);
        antrian.setJenisAntrian("OFFLINE");
        antrian.setTglAntrian(tanggalAntri);
        antrian.setHadir("-");
        System.out.println("hasil generate ID=" +id_antrian);
         System.out.println("hasil generate nomor=" +nomer_antrian);
//        System.out.println("hasil role=" +role);
        if(antrianService.insertAntrian(antrian)==true){
            System.out.println("SUKSES");
        }
        else{
            System.out.println("FALSE");
        };
    }
       
     public void setComboBoxPoli(antrianoffline ua) {
        List<Poli> list = new ArrayList();
        try {
            list = poliService.getPoli();
            ua.polidokter.addItem("- Pilih Poli -");
        } catch (RemoteException ex) {
            Logger.getLogger(regispasiencontroller.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < list.size(); i++) {
            ua.polidokter.addItem(list.get(i).getNamaPoli());
            
        } 
    }
          
      public DefaultTableModel getDokterList() throws RemoteException {
        List<Dokter> list = new ArrayList<Dokter>();
        list = dokterService.getDokter();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Dokter");
        model.addColumn("Nama Dokter");
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getIdDokter(), list.get(i).getNamaDokter()});
        }
        //ui.TabelDokter.setModel(model);
        return model;
    }
}
