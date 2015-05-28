package carismadokter.controller;

import carismainterface.entity.*;
import carismainterface.server.*;
import java.rmi.RemoteException;

/**
 *
 * @author Adinda
 */
public class AntrianController {
    
    private RekammedikService rekamMedikService;
    private PasienService pasienService;
    private AntrianService antrianService;

    public AntrianController(ClientSocket client) {
        rekamMedikService = client.getRekamMedikService();
        pasienService = client.getPasienService();
        antrianService = client.getAntrianService();
     }
    
    public boolean antrianHadir(String idAntrian) throws RemoteException{
        Antrian antrian = new Antrian();
        antrian.setIdAntrian(idAntrian);
        return antrianService.antrianHadir(idAntrian);
        
    }
    
 
    
}
