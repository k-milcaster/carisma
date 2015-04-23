/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;
import carismainterface.entity.Dokter;
import carismainterface.entity.Poli;
import carismainterface.server.DokterService;
import carismaresepsionis.boundaries.dokterform;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import carismaresepsionis.boundaries.settergetter;


/**
 *
 * @author Anes Dirsi
 */
public class DataDokterController {
    private DokterService dokterService;

 public DataDokterController(ClientSocket client) throws RemoteException {
        this.dokterService = client.getDokterService();
    }
   
 public DokterService getDokter(){
         return this.dokterService;
     }
 
 public String getNamaDokter(){
        Dokter dokter = new Dokter();
        String NamaDokter = dokter.getNamaDokter();
        return NamaDokter;
    }
 
 public String getIdDokter(){
        Dokter dokter = new Dokter();
        String IdDokter = dokter.getIdDokter();
        return IdDokter;
    }
 
 public String getNamaPoli(){
        Poli poli = new Poli();
        String NamaPoli = poli.getNamaPoli();
        return NamaPoli;
    }
 
 public String getTempatlahirDokter(){
        Dokter dokter = new Dokter();
        String TempatlahirDokter = dokter.getTempatlahirDokter();
        return TempatlahirDokter;
    }
  
 public String getTgllahirDokter(){
        Dokter dokter = new Dokter();
        String TgllahirDokter = dokter.getTgllahirDokter();
        return TgllahirDokter;
    }
  
 public String getKelaminDokter(){
        Dokter dokter = new Dokter();
        String KelaminDokter = dokter.getKelaminDokter();
        return KelaminDokter;
    }
  
 public String getAlamatDokter(){
        Dokter dokter = new Dokter();
        String AlamatDokter = dokter.getAlamatDokter();
        return AlamatDokter;
    }
   
 public String getTelpDokter(){
        Dokter dokter = new Dokter();
        String TelpDokter = dokter.getTelpDokter();
        return TelpDokter;
    }
    
 public String getHp1Dokter(){
        Dokter dokter = new Dokter();
        String getHp1Dokter = dokter.getHp1Dokter();
        return getHp1Dokter;
    }
 
 public String getHp2Dokter(){
        Dokter dokter = new Dokter();
        String getHp2Dokter = dokter.getHp2Dokter();
        return getHp2Dokter;
    }
 
 public byte[] getFotoDokter(){
        Dokter dokter = new Dokter();
        byte[] getFotoDokter = dokter.getFotoDokter();
        return getFotoDokter;
    }
   
   public DefaultTableModel getNamaDokter(dokterform ui) throws RemoteException{
        
        List<Dokter> list = new ArrayList<Dokter>();
        list = dokterService.getDokter();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Dokter");
        model.addColumn("Nama Dokter");
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getPoliIdPoli()});
            System.out.println("");
        }
        ui.TabelDokter.setModel(model);
        return model;
    }
   
    public void getKelaminDokter(dokterform ui)throws RemoteException{
        List<Dokter> list = new ArrayList<Dokter>();
        list = dokterService.getDokter();
        for (int i = 0; i < list.size(); i++) {            
            ui.KelaminDokter.addItem(list.get(i).getKelaminDokter());
        }               
    }
}
 