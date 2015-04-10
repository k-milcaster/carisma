
package carismaresepsionis.controller;

import carismainterface.entity.Pasien;
import carismainterface.server.PasienService;
import java.rmi.RemoteException;
/**
 *
 * @author Fiqhi Darmawan
 */
public class regispasiencontroller {

    private PasienService pasienService;
     
  
    public regispasiencontroller( ClientSocket client ) throws RemoteException {    
    this.pasienService = client.getPasienService();
    }
    
    public void InsertNamaPasien() throws RemoteException{
        Pasien pasien = new Pasien();
        pasienService.insertPasien(pasien);
    }

}
