package carismadokter.controller;

import carismainterface.entity.Resep;
import carismainterface.server.ResepService;
import java.rmi.RemoteException;

public class ResepController {
    
    private ResepService resepService;
    
    public ResepController(ClientSocket client) throws RemoteException{
        resepService = client.getResepService();
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
    
}
