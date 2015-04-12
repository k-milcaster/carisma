package carismadokter.controller;

import carismainterface.entity.Detailresep;
import carismainterface.server.DetailresepService;
import java.rmi.RemoteException;

public class DetailResepController {
    
    private DetailresepService detailResepService;
    
    public DetailResepController(ClientSocket client) throws RemoteException{
        detailResepService = client.getDetailResepService();
    }
    
    public void insertDetailResep(String idDetailResep, String idResep, String namaObat, int quantity, String aturanPakai)throws RemoteException{
        Detailresep detailResep = new Detailresep();
        detailResep.setIdDetailresep(idDetailResep);
        detailResep.setResepIdResep(idResep);
        detailResep.setNamaobatResep(namaObat);
        detailResep.setQtyResep(quantity);
        detailResep.setAturanpakaiResep(aturanPakai);
        detailResepService.insertDetailresep(detailResep);
    }
    
    public String getIdDetailResep(){
        Detailresep detailResep = new Detailresep();
        String idDetailResep = detailResep.getIdDetailresep();
        return idDetailResep;
    }
}
