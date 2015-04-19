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
    
    
    public DaftarRawatInapController (ClientSocket client){
        this.pasienService = client.getPasienService();
       
        
} 
   public void insertNamaPasien (String namaPasien, String idPasien, String namaPenyakit, String namaKamar, String kelasKamar, String tarif) throws RemoteException{
      
       Pasien pasien = new Pasien ();
       pasienService.insertPasien(pasien);
   }
   
   public void getNamaPasien () throws RemoteException{
       Pasien ambilPasien = new Pasien();
       pasienService.getPasien();
   }
   
  
}
