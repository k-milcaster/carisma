/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import carismainterface.entity.*;
import carismainterface.server.*;
import java.rmi.RemoteException;

/**
 *
 * @author Vaio Sony
 */
public class DaftarRawatInapController {
   
    private PasienService pasienService;
    private PasienKamarService pasienkamarService;
    
    public DaftarRawatInapController (ClientSocket client){
        this.pasienService = client.getPasienService();
        this.pasienkamarService = client.getPasienKamarService();
        
} 
   public void insertNamaPasien (String namaPasien, String idPasien, String namaKamar, String kelasKamar, String tarif) throws RemoteException{
      
       PasienKamar pasienkamar = new PasienKamar ();
       pasienkamarService.insertPasienKamar(pasienkamar);
   }
   
   public void getNamaPasien () throws RemoteException{
       Pasien ambilPasien = new Pasien();
       pasienService.getPasien();
   }
   
  
}
