/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;
import carismainterface.entity.Dokter;
import carismainterface.entity.Jadwaldokter;
import carismainterface.server.JadwaldokterService;
import carismaresepsionis.boundaries.jadwaldokter;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Anes Dirsi
 */
public class LihatJadwalDokterController {
    
private JadwaldokterService jadwaldokterService;
    
     public LihatJadwalDokterController(ClientSocket client) throws RemoteException{
        Jadwaldokter lihatjadwaldokter = new Jadwaldokter();
        this.jadwaldokterService = client.getJadwaldokterService();
    }
         
     public JadwaldokterService getJadwaldokter(){
     return this.jadwaldokterService;
    }
    
    public String getIdDokter(){
        Dokter dokter = new Dokter();
        String IdDokter = dokter.getIdDokter();
        return IdDokter;
    }
    
    public Integer getIdJadwalDokter(){
        Jadwaldokter jadwaldokter = new Jadwaldokter();
        Integer JadwalId = jadwaldokter.getJadwalId();
        return JadwalId;
    }
    
     public Jadwaldokter getJadwalDokterDetail(String id) throws RemoteException{
        Jadwaldokter jadwaldokter = jadwaldokterService.getJadwaldokter(id);
        return jadwaldokter;
    }
    
}