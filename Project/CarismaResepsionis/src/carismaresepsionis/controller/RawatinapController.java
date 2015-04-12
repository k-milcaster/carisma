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
public class RawatinapController {
    private PasienService pasienService;
    
    public RawatinapController (ClientSocket client) throws RemoteException{
        this.pasienService = client.getPasienService();
      
} 
   
    public String getNamaPasien(){
        Pasien pasien = new Pasien();
        String NamaPasien = pasien.getNamaPasien();
        return NamaPasien;
    }
    public String getIdPasien(){
        Pasien pasien = new Pasien();
        String IdPasien = pasien.getIdPasien();
        return IdPasien;
    }
    
    public String getNamaPenyakit(){
        Penyakit penyakit = new Penyakit();
        String NamaPenyakit = penyakit.getNamaPenyakit();
        return NamaPenyakit;
    }
    
    public String getNamaKamar(){
        Kamar kamar = new Kamar();
        String NamaKamar = kamar.getNamaKamar();
        return NamaKamar;
    }
    
    public String getKelasKamar(){
        Kamar kamar = new Kamar();
        String KelasKamar = kamar.getKelas();
        return KelasKamar;
    }
    public String getTarifKamar(){
        Kamar kamar = new Kamar();
        int TarifKamar = kamar.getTarif();
        String gantiParameterTarif = String.valueOf(TarifKamar);
        return gantiParameterTarif;
    }
    
    
    
    
    
}
