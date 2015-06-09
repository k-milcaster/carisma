/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismadokter.controller;
import carismainterface.entity.Detailresep;
import carismainterface.entity.Dokter;
import carismainterface.entity.Pasien;
import carismainterface.entity.Rekammedik;
import carismainterface.entity.Rekammedikpenyakit;
import carismainterface.server.DetailresepService;
import carismainterface.server.DokterService;
import carismainterface.server.PasienService;
import carismainterface.server.PenyakitService;
import carismainterface.server.PoliService;
import carismainterface.server.RekammedikService;
import carismainterface.server.RekammedikpenyakitService;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Anes Dirsi 
 */
public class LihatRekamMedisController {
    
    private PasienService pasienService;
    private DokterService dokterService;
    private RekammedikService rekamMedikService;
    private DetailresepService detailResepService;
    private RekammedikpenyakitService rekammedikPenyakitService;
    private PenyakitService penyakitService;
    
    public LihatRekamMedisController(ClientSocket client) throws RemoteException {
        this.pasienService = client.getPasienService();
        this.rekamMedikService = client.getRekamMedikService();
        detailResepService = client.getDetailResepService();
        this.dokterService = client.getDokterService(); 
        rekammedikPenyakitService = client.getRekamMedisPenyakitService();
        penyakitService = client.getPenyakitService();
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
        TabelRekammedik.addColumn("Id Resep");
        List<Rekammedik> list = new ArrayList<Rekammedik>();
       
        list = rekamMedikService.getRekamMedikByPasien(idPasien);
        for (int i = 0; i < list.size(); i++) {
            TabelRekammedik.addRow(new Object[]{list.get(i).getIdRekammedik(), dokterService.getDokterById(list.get(i).getDokterIdDokter()).get(1), list.get(i).getPasienIdPasien(), 
                pasienService.getPasien(list.get(i).getPasienIdPasien()).getNamaPasien(), list.get(i).getTglRekammedik(), list.get(i).getResepIdResep() });
        }
        
        return TabelRekammedik;
    }
    
    public Rekammedik getDetailRekamMedik(String idRekamMedik) throws RemoteException{
        Rekammedik rekamMedik = rekamMedikService.getRekamMedik(idRekamMedik);
        return rekamMedik;
    }
    
    public DefaultListModel getNamaObat(String idResep) throws RemoteException{
        DefaultListModel listNamaObat = new DefaultListModel();
        List<Detailresep> list = new ArrayList<Detailresep>();
        list = detailResepService.getDetailresep(idResep);
        for (int i = 0; i < list.size(); i++) {
            listNamaObat.addElement(list.get(i).getNamaobatResep());
        }
        return listNamaObat;
    }
    public DefaultListModel getPenyakitPasien(String idRekamMedik) throws RemoteException{
        DefaultListModel listPenyakitPasien = new DefaultListModel();
        List<Rekammedikpenyakit> list = new ArrayList<Rekammedikpenyakit>();
        list = rekammedikPenyakitService.getPenyakitPasien(idRekamMedik);
        for (int i = 0; i < list.size(); i++) {
            listPenyakitPasien.addElement(penyakitService.getPenyakit(list.get(i).getPenyakitIdPenyakit()).getNamaPenyakit());
        }
        return listPenyakitPasien;
    }
    

} 

