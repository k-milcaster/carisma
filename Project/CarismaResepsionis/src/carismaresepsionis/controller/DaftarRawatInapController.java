/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import carismainterface.entity.*;
import carismainterface.server.*;
import carismaresepsionis.boundaries.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vaio Sony
 */
public class DaftarRawatInapController {
   
    private PasienService pasienService;
    private PasienKamarService pasienkamarService;
    private KamarService kamarService;
    
    public DaftarRawatInapController (ClientSocket client){
        this.pasienService = client.getPasienService();
        this.pasienkamarService = client.getPasienKamarService();
        this.kamarService = client.getKamarService();
        
} 

    

   public boolean insertNamaPasien (String namaPasien, String idPasien, int idKamar, String namaKamar, String kelasKamar, String tarif, String date) throws RemoteException{
      
       PasienKamar pasienkamar = new PasienKamar ();
       pasienkamar.setIdPeminjaman(generatePeminjamanId(idPasien, namaKamar));
       pasienkamar.setKamarIdKamar(idKamar);
       pasienkamar.setDateinPasienKamar(date);
       //pasienkamar.setDateoutPasienKamar();

       pasienkamarService.insertPasienKamar(pasienkamar);
       return true;
   }
    
   public String generatePeminjamanId(String idPasien, String namaKamar) {
        String pasienId = Character.toString(idPasien.charAt(0)).toUpperCase() + Character.toString(idPasien.charAt(idPasien.length() - 1)).toUpperCase() + Character.toString(namaKamar.charAt(2)) + Character.toString(namaKamar.charAt(3)) + Character.toString(namaKamar.charAt(5)) + Character.toString(namaKamar.charAt(6)) + Character.toString(namaKamar.charAt(8)) + Character.toString(namaKamar.charAt(9));
        return pasienId;
    }
   
   public DefaultTableModel getNamaPasienRawatInap(DaftarRawatInap ui) throws RemoteException{
        
        List<Pasien> list = new ArrayList<Pasien>();
      
        list = pasienService.getPasienRawatinap();
   
        DefaultTableModel model = new DefaultTableModel();
  
        model.addColumn("ID Pasien");
        model.addColumn("Nama Pasien");
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getIdPasien(),list.get(i).getNamaPasien()});
            //System.out.println("lewat");
        }
        ui.TabelPasien.setModel(model);
        return model;
    }
   
  public DefaultTableModel getNamaPasienRawatInapbyName(String nama) throws RemoteException{
        
        List<Pasien> list = new ArrayList<Pasien>();
        list = pasienService.getPasienRawatinap();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Pasien");
        model.addColumn("Nama Pasien");
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getIdPasien(), list.get(i).getNamaPasien()});
            //System.out.println("lewat");
        }
        
        return model;
    }
   
   public String[] getNamaKelasKamarbyIdpasien (String idPasien) throws RemoteException{
        
        String[] kamarInfo = new String[2];
        kamarInfo = kamarService.getNamaKelasKamarbyIdpasien(idPasien);
        //DefaultTableModel model = new DefaultTableModel();
        //model.addColumn("ID Pasien");
        //model.addColumn("Nama Pasien");
        //for (int i = 0; i < list.size(); i++) {
            //model.addRow(new Object[]{list.get(i).getNamaPasien()});
            //System.out.println("lewat");
        
        return kamarInfo;
    }
  public boolean deletePasienKamar (String unPinjam) throws RemoteException{
      //PasienKamar pasienkamar = new PasienKamar ();
      
      pasienkamarService.deletePasienKamar(unPinjam);
      return true;
  }
}
