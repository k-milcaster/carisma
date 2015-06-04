/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismadokter.controller;
import carismainterface.entity.Dokter;
import carismainterface.entity.Pasien;
import carismainterface.entity.Rekammedik;
import carismainterface.server.DokterService;
import carismainterface.server.PasienService;
import carismainterface.server.PoliService;
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
    private DokterService dokterService;
    private RekammedikService rekamMedik;
    
    public LihatRekamMedisController(ClientSocket client) throws RemoteException {
        this.pasienService = client.getPasienService();
        this.rekamMedik = client.getRekamMedikService();
        this.dokterService = client.getDokterService();     
    }
    
    public Pasien getPasien(String idPasien) throws RemoteException{
        Pasien pasien = new Pasien();
        return pasien = pasienService.getPasien(idPasien);
    }
    
    public DefaultTableModel getRekamMedik(String idPasien) throws RemoteException {
        DefaultTableModel TabelRekammedik = new DefaultTableModel();
        TabelRekammedik.addColumn("Id RekamMedik");
        TabelRekammedik.addColumn("Nama Dokter");
        TabelRekammedik.addColumn("Id Pasien");
        TabelRekammedik.addColumn("Nama Pasien");        
        TabelRekammedik.addColumn("Tgl Pemeriksaan");
        TabelRekammedik.addColumn("Keluhan");
        TabelRekammedik.addColumn("Pemeriksaan Dokter");
        TabelRekammedik.addColumn("Terapi");
        TabelRekammedik.addColumn("Alergi Obat");
        TabelRekammedik.addColumn("Kesimpulan");
        TabelRekammedik.addColumn("Kondisi Pasien Keluar");
        TabelRekammedik.addColumn("Id Resep");
        List<Rekammedik> list = new ArrayList<Rekammedik>();
        Pasien pasien = new Pasien();
       
        list = rekamMedik.getRekamMedikByPasien(idPasien);
        for (int i = 0; i < list.size(); i++) {
            TabelRekammedik.addRow(new Object[]{list.get(i).getIdRekammedik(), dokterService.getDokterById(list.get(i).getDokterIdDokter()).get(1), list.get(i).getPasienIdPasien(), 
                pasienService.getPasien(list.get(i).getPasienIdPasien()).getNamaPasien(), list.get(i).getTglRekammedik(), list.get(i).getKeluhanRekammedik(), 
                list.get(i).getPemeriksaanRekammedik(), list.get(i).getTerapiRekammedik(), list.get(i).getAlergiobatRekammedik(), list.get(i).getKesimpulanRekammedis(), 
                list.get(i).getKondisipasienkeluarRekammedis(), list.get(i).getResepIdResep() });
        }
        
        return TabelRekammedik;
    }    
    
    

} 

