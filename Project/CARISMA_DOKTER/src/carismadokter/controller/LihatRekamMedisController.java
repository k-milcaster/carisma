/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismadokter.controller;
import carismainterface.entity.Pasien;
import carismainterface.server.PasienService;
import carismainterface.server.RekammedikService;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Anes Dirsi
 */
public class LihatRekamMedisController {
    
    private PasienService pasienService;
    private RekammedikService rekamMedik;
    
    public LihatRekamMedisController(ClientSocket client) throws RemoteException {
        this.pasienService = client.getPasienService();
        this.rekamMedik = client.getRekamMedikService();
    }
    
    public DefaultTableModel getPasienList() throws RemoteException {
        List<Pasien> list = new ArrayList<Pasien>();
        list = pasienService.getPasien();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Pasien");
        model.addColumn("Nama Pasien");
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getIdPasien(), list.get(i).getNamaPasien()});
        }
        //ui.TabelPasien.setModel(model);
        return model;
    }
    
     public DefaultTableModel getPasienbyName (String nama) throws RemoteException{
        List<Pasien> list = new ArrayList<Pasien>();
        list = pasienService.getPasienByName(nama);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Pasien");
        model.addColumn("Nama Pasien");
        
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getIdPasien(), list.get(i).getNamaPasien()});
        }
        return model;
        
    }
     
//     public ArrayList getRekammedikById(String idpasien) throws RemoteException {
//        ArrayList infoRekammedik = rekamMedik.getRekammedikById(idpasien);
//        return infoRekammedik;
//    }
} 

