/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismajadwaldokter.controller;

import carismainterface.entity.Jadwaldokter;
import carismainterface.server.JadwaldokterService;
import java.rmi.RemoteException;

/**
 *
 * @author Muhammad Rizal
 */
public class MelihatJadwalDokterController {
    
    private JadwaldokterService melihatjadwaldokter;
    
     public MelihatJadwalDokterController(ClientSocket client) throws RemoteException{
        Jadwaldokter melihatjadwaldokter = new Jadwaldokter();
        this.melihatjadwaldokter = client.getJadwaldokterService();
    }
}
