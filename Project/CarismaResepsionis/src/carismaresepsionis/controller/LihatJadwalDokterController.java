/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;
import carismainterface.entity.Dokter;
import carismainterface.entity.Poli;
import carismainterface.entity.Jadwaldokter;
import carismainterface.server.JadwaldokterService;
import carismainterface.server.PoliService;
import carismainterface.server.DokterService;
import carismaresepsionis.boundaries.jadwaldokter;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Anes Dirsi
 */
public class LihatJadwalDokterController {
    
private JadwaldokterService lihatjadwaldokter;
private PoliService namapoli;
private DokterService namadokter;
    
     public LihatJadwalDokterController(ClientSocket client) throws RemoteException{
        Jadwaldokter lihatjadwaldokter = new Jadwaldokter();
        this.lihatjadwaldokter = client.getJadwaldokterService();
        this.namapoli = client.getPoliService();
        this.namadokter = client.getDokterService();
    }
     
     public JadwaldokterService getJadwaldokter(){
         return this.lihatjadwaldokter;
     }
     
     public PoliService getPoli(){
         return this.namapoli;
     }
     
     public DokterService getDokter(){
         return this.namadokter;
     }
     
     public String getNamaDokter(){
        Dokter dokter = new Dokter();
        String NamaDokter = dokter.getNamaDokter();
        return NamaDokter;
    }
     
     public String getNamaPoli(){
         Poli poli = new Poli();
         String NamaPoli = poli.getNamaPoli();
         return NamaPoli;
     }
     
     public String getAlamatDokter(){
        Dokter dokter = new Dokter();
        String AlamatDokter = dokter.getAlamatDokter();
        return AlamatDokter;
    }
    
    public void getNamaPoli(jadwaldokter ui)throws RemoteException{
        List<Poli> list = new ArrayList<Poli>();
        list = namapoli.getPoli();
        for (int i = 0; i < list.size(); i++) {            
           ui.comboBoxNamaPoli.addItem(list.get(i).getNamaPoli());
        }               
    }
     
    public void getNamaDokter(jadwaldokter ui)throws RemoteException{
        List<Dokter> list = new ArrayList<Dokter>();
        list = namadokter.getDokter();
        for (int i = 0; i < list.size(); i++) {            
            ui.comboBoxNamaDokter.addItem(list.get(i).getNamaDokter());
        }               
    }
     
}

