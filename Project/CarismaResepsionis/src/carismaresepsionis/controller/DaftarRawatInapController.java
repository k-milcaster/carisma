/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import carismainterface.entity.*;
import carismainterface.server.PasienService;
import java.rmi.RemoteException;

/**
 *
 * @author Vaio Sony
 */
public class DaftarRawatInapController {
   
    private PasienService pasienService;
    
    
    public DaftarRawatInapController (ClientSocket client) throws RemoteException{
        this.pasienService = client.getPasienService();
       
        
} 
   public void insertNamaPasien () throws RemoteException{
       
       
       Pasien pasien = new Pasien ();
       pasienService.insertPasien(pasien);
   }
   
   public void getNamaPasien () throws RemoteException{
       Pasien ambilPasien = new Pasien();
       pasienService.getPasien();
   }
   
   public String kamarKosong (String parameterA){
       String kamar = "";
       if (parameterA.equals("coba")){
        kamar = "kosong";}
       else {
        kamar = "ada isinya";
       }
       return kamar;
   }
}
