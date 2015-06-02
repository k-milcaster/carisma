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
    
    public Pasien getDetailPasien(String idPasien) throws RemoteException {
        Pasien pasien = pasienService.getPasien(idPasien);
        return pasien;
    }
    
    public Dokter getDokterDetail(String idDokter) throws RemoteException {
        Dokter dokter = dokterService.getDokter(idDokter);
        return dokter;
    }
    
    public DefaultTableModel getRekamMedik() throws RemoteException {
        List<Rekammedik> list = new ArrayList<Rekammedik>();
        list = rekamMedik.getRekamMedik();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id RekamMedik");
        model.addColumn("Id Dokter");
        model.addColumn("Id Pasien");
        model.addColumn("Tgl Pemeriksaan");
        model.addColumn("Keluhan");
        model.addColumn("Pemeriksaan Dokter");
        model.addColumn("Terapi");
        model.addColumn("Alergi Obat");
        model.addColumn("Kesimpulan");
        model.addColumn("Kondisi Pasien Keluar");
        model.addColumn("Id Resep");
        
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getIdRekammedik(), list.get(i).getDokterIdDokter(), list.get(i).getPasienIdPasien(), list.get(i).getTglRekammedik(), list.get(i).getKeluhanRekammedik(), list.get(i).getPemeriksaanRekammedik(), list.get(i).getTerapiRekammedik(), list.get(i).getAlergiobatRekammedik(), list.get(i).getKesimpulanRekammedis(), list.get(i).getKondisipasienkeluarRekammedis(), list.get(i).getResepIdResep() });
        }
        //ui.TabelRekammedik.setModel(model);
        return model;
    }    

} 

