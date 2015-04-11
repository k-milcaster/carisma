/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaapoteker.controller;

import carismainterface.entity.Transaksijualobat;
import carismainterface.server.TransaksijualobatService;
import java.rmi.RemoteException;

/**
 *
 * @author Sinta Eka Lestari
 */
public class TransaksiJualObatController {
    private TransaksijualobatService transaksijualobat;
    
    public TransaksiJualObatController (ClientSocket client) throws RemoteException{
        Transaksijualobat trans = new Transaksijualobat();
        this.transaksijualobat = client.getTransaksijualobatService();       
    }  
    public void insertTransaksijualobat (String idTransaksijual , String dateTransaksijual, String keterangan) throws RemoteException{
        Transaksijualobat transaksijual = new Transaksijualobat();
        transaksijual.setIdTransaksijual(idTransaksijual);
        transaksijual.setDateTransaksijual(dateTransaksijual);
        transaksijual.setKeterangan(keterangan);
        transaksijualobat.insertTransaksijualbat(transaksijual);
        
        
        
        
    }
   
}
