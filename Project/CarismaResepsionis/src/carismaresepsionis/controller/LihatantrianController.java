/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import carismainterface.entity.Kunjungan;
import carismainterface.entity.Pasien;
import carismainterface.server.AntrianService;
import carismainterface.server.KunjunganService;
import java.rmi.RemoteException;
import carismaresepsionis.boundaries.settergetter;

/**
 *
 * @author Adinda
 */
public class LihatantrianController {
    private AntrianService antrianService;
    private KunjunganService kunjunganService;
   
    public LihatantrianController(ClientSocket client) throws RemoteException{
        this.antrianService = client.getAntrianService();
        this.kunjunganService = client.getKunjunganService();
    }
    public String getNamaPasien(){
        Pasien pasien = new Pasien();
        String NamaPasien = pasien.getNamaPasien();
        return NamaPasien;
    }
    public String getAlamatPasien(){
        Pasien pasien = new Pasien();
        String AlamatPasien = pasien.getAlamatPasien();
        return AlamatPasien;
    }
    public String getGolDarah(){
        Pasien pasien = new Pasien();
        String GolDarah = pasien.getDarahPasien();
        return GolDarah;
    }
//    public String getUmur(){
//        Pasien pasien = new Pasien();
//        String Umur = pasien.getTgllahirPasien();
//        return Umur;
//    }
    
    public int getTinggi(){
        Pasien pasien = new Pasien();
        Integer Tinggi = pasien.getTinggiPasien();
        return Tinggi;
    }
    public int getBerat(){
        Pasien pasien = new Pasien();
        Integer Berat = pasien.getBeratPasien();
        return Berat;
    }
//    public String getTerakhirPeriksa(){
//        Kunjungan kunjungan = new Kunjungan();
//        String TerakhirPeriksa = kunjungan.getTanggaljamKunjungan();
//        return TerakhirPeriksa;        
//    }
    //public foto
}
