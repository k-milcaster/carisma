/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import carismainterface.entity.*;
import carismainterface.server.*;
import carismaresepsionis.boundaries.Rawatinap;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vaio Sony
 */
public class RawatinapController {
    private PasienService pasienService;
    private PenyakitService penyakitService;
    private KamarService kamarService;
    public RawatinapController (ClientSocket client) throws RemoteException{
        this.pasienService = client.getPasienService();
      
} 
   
   public DefaultTableModel getNamaPasien(Rawatinap ui) throws RemoteException{
        
        List<Pasien> list = new ArrayList<Pasien>();
        list = pasienService.getPasien();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Pasien");
        model.addColumn("Nama Pasien");
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getIdPasien()});
            System.out.println("lewat");
        }
        ui.tablepasien.setModel(model);
        return model;
    }
   
    
    
    public Penyakit getDetailPenyakit (String idPenyakit) throws RemoteException{
        Penyakit penyakit = penyakitService.getPenyakit(idPenyakit);
        return penyakit;
    }
    
    public DefaultTableModel getNamaKamar(Rawatinap ui) throws RemoteException{
        
        List<Kamar> list = new ArrayList<Kamar>();
        list = kamarService.getKamar();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama Kamar");
        model.addColumn("Kelas Kamar");
        model.addColumn("Tarif Kamar");
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getIdKamar()});
            System.out.println("lewat");
        }
        ui.tablelistkamarpasien.setModel(model);
        return model;
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
