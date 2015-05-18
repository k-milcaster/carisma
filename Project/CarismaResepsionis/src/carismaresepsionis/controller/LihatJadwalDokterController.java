/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import carismainterface.entity.Dokter;
import carismainterface.entity.Jadwaldokter;
import carismainterface.server.JadwaldokterService;
import carismainterface.entity.Jadwal;
import carismainterface.server.JadwalService;
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
    private JadwalService jadwalService;
    public LihatJadwalDokterController(ClientSocket client) throws RemoteException {
        //Jadwaldokter lihatjadwaldokter = new Jadwaldokter();
        this.jadwaldokterService = client.getJadwaldokterService();
        this.jadwalService = client.getJadwalService();
    }
    
    public ArrayList<Jadwal> lihatJadwal(String idDokter) throws RemoteException{
        List<Jadwaldokter> list = jadwaldokterService.getJadwaldokter(idDokter);
        ArrayList<Jadwal> jadwal = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            jadwal.add(jadwalService.getJadwal(list.get(i).getJadwalId().toString()));
            System.out.println(jadwal.get(i).getHariJadwalpegawai()+ " " +jadwal.get(i).getShiftJadwalpegawai());
        }
        return jadwal;
    }
    
    
    
    
}
