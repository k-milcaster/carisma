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
<<<<<<< HEAD
   public void insertNamaPasien (String namaPasien, String idPasien, String namaKamar, String kelasKamar, String tarif) throws RemoteException{
      
       PasienKamar pasienkamar = new PasienKamar ();
=======
   public void insertNamaPasien (String namaPasien, String idPasien, int idKamar, String namaKamar, String kelasKamar, String tarif) throws RemoteException{
      
       PasienKamar pasienkamar = new PasienKamar ();
       pasienkamar.setIdPeminjaman(generatePeminjamanId(idPasien, namaKamar));
       pasienkamar.setKamarIdKamar(idKamar);
       //pasienkamar.setDateinPasienKamar();
       //pasienkamar.setDateoutPasienKamar();
>>>>>>> cfb4c7ed7040e9404bb59b630ee8bcfa2ae7741c
       pasienkamarService.insertPasienKamar(pasienkamar);
   }
    
   public String generatePeminjamanId(String idPasien, String namaKamar) {
        String pasienId = Character.toString(idPasien.charAt(0)).toUpperCase() + Character.toString(idPasien.charAt(idPasien.length() - 1)).toUpperCase() + Character.toString(namaKamar.charAt(2)) + Character.toString(namaKamar.charAt(3)) + Character.toString(namaKamar.charAt(5)) + Character.toString(namaKamar.charAt(6)) + Character.toString(namaKamar.charAt(8)) + Character.toString(namaKamar.charAt(9));
        return pasienId;
    }
   
   
   
  
}
