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
   
   public DefaultTableModel getNamaPasienRawatInap() throws RemoteException{
        
        List<Pasien> list = new ArrayList<Pasien>();
      
        list = pasienService.getPasienRawatinap();
   
        DefaultTableModel model = new DefaultTableModel();
  
        model.addColumn("ID Pasien");
        model.addColumn("kota_id_kota"); 
        model.addColumn("nama_pasien");
        model.addColumn("alamat_pasien");
        model.addColumn("kartuid_pasien");
        model.addColumn("nokartuid_pasien");
        model.addColumn("telp_pasien");
        model.addColumn("hp_pasien");
        model.addColumn("tempatlahir_pasien");
        model.addColumn("tgllahir_pasien");
        model.addColumn("kelamin_pasien");
        model.addColumn("darah_pasien");
        model.addColumn("berat_pasien");
        model.addColumn("tinggi_pasien");
        model.addColumn("regdate_pasien");
       
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getIdPasien(),list.get(i).getKotaIdKota(), list.get(i).getNamaPasien(),
            list.get(i).getAlamatPasien(),list.get(i).getKartuidPasien(),list.get(i).getNokartuidPasien(),
                    list.get(i).getTelpPasien(),list.get(i).getHpPasien(),list.get(i).getTempatlahirPasien(),
                           list.get(i).getTgllahirPasien(), list.get(i).getKelaminPasien(),
            list.get(i).getDarahPasien(), list.get(i).getBeratPasien(), list.get(i).getTinggiPasien(),list.get(i).getRegdatePasien()});
            //System.out.println("lewat");
        }
       
        return model;
    }
   
  public DefaultTableModel getNamaPasienRawatInapbyName(String nama) throws RemoteException{
        
        List<Pasien> list = new ArrayList<Pasien>();
        list = pasienService.getPasienRawatinapByName(nama);
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
