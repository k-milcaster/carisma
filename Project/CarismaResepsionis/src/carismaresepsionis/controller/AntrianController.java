/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import carismainterface.entity.Antrian;
import carismainterface.server.AntrianService;
import java.rmi.RemoteException;

/**
 *
 * @author Adinda
 */
public class AntrianController {
    private AntrianService antrian;
   
    public AntrianController(ClientSocket client) throws RemoteException{
        this.antrian = client.getAntrianService();
        Antrian antrian = new Antrian();
                                
    }
    public void lihatAntrian(){
    
    
    }

}
