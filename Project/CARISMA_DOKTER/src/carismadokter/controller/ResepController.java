package carismadokter.controller;

import carismadokter.boundaries.isirekammedis;
import carismainterface.entity.Obat;
import carismainterface.entity.Resep;
import carismainterface.server.ObatService;
import carismainterface.server.ResepService;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ResepController {
    
    private ResepService resepService;
    private ObatService obatService;
    
    public ResepController(ClientSocket client) throws RemoteException{
        resepService = client.getResepService();
        obatService = client.getObatService();
    }
    
    public void insertResep(String idResep, String keterangan) throws RemoteException{
        Resep resep = new Resep();
        resep.setIdResep(idResep);
        resep.setKeterangan(keterangan);
        resepService.insertResep(resep);
    }
    
    public String getIdResep(){
        Resep resep = new Resep();
        String idResep = resep.getIdResep();
        return idResep;
    }
    
    public void getNamaObat(isirekammedis ui)throws RemoteException{
        List<Obat> list = new ArrayList<Obat>();
        list = obatService.getObat();
        for (int i = 0; i < list.size(); i++) {            
           // ui.comboBoxObat.addItem(list.get(i).getNamaObat());
        }               
    }
}
