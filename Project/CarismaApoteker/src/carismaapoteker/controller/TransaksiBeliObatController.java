/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaapoteker.controller;

import carismaapoteker.boundaries.TransaksiBeliObat;
import carismainterface.entity.Detailobat;
import carismainterface.entity.Detailtransaksibeliobat;
import carismainterface.entity.Obat;
import carismainterface.entity.Transaksibeliobat;
import carismainterface.server.DetailobatService;
import carismainterface.server.DetailtransaksibeliobatService;
import carismainterface.server.ObatService;
import carismainterface.server.PegawaiService;
import carismainterface.server.TransaksibeliobatService;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hana Mahrifah
 */
public class TransaksiBeliObatController {

    private TransaksibeliobatService transaksibeliobat;
    private DetailtransaksibeliobatService detailtransaksibeliobat;
    private ObatService obatService;
    private DetailobatService detailobatService;
    private PegawaiService pegawaiService;

    public TransaksiBeliObatController(ClientSocket client) throws RemoteException {
        this.transaksibeliobat = client.getTransaksibeliobatService();
        this.detailtransaksibeliobat = client.getDetailtransaksibeliobatService();
        obatService = client.getObatService();
        detailobatService = client.getDetailonatSerivice();
        this.pegawaiService = client.getPegawaiService();
    }

    public DefaultComboBoxModel getIdObat() throws RemoteException {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        List<Obat> list = new ArrayList<Obat>();
        list = obatService.getObat();
        for (int i = 0; i < list.size(); i++) {
            combo.addElement(list.get(i).getIdObat() + " " + list.get(i).getNamaObat());
        }
        return combo;

    }

//    public DefaultTableModel getTransaksiBeliObat(TransaksiBeliObat ui) throws RemoteException {
//        List<Transaksibeliobat> list = new ArrayList<Transaksibeliobat>();
//        list = transaksibeliobat.getTransaksibeliobat();
//        List<Detailtransaksibeliobat> list1 = new ArrayList<Detailtransaksibeliobat>();
//        list1 = detailtransaksibeliobat.getDetailtransaksibeliobat();
//        List<Obat> list2 = new ArrayList<Obat>();
//        list2 = obatService.getObat();
//        List<Detailobat> list3 = new ArrayList<Detailobat>();
//        list3 = detailobatService.getDetailobat();
//        DefaultTableModel model = new DefaultTableModel();
//        model.addColumn("Id Transaksi Beli Obat");
//        model.addColumn("Tanggal Beli Obat");
//        model.addColumn("Nama Obat");
//        model.addColumn("Jenis Obat");
//        model.addColumn("Harga Beli Obat");
//        model.addColumn("Qty");
//        model.addColumn("Tanggal Kadaluarsa");
//        model.addColumn("Keterangan");
//
//        for (int i = 0; i < list.size(); i++) {
//            model.addRow(new Object[]{list.get(i).getIdTransaksibeliobat(), list.get(i).getDateTransaksibeli(), list2.get(i).getNamaObat(), list2.get(i).getJenisObat(), list.get(i).getHargabeliObat(), list1.get(i).getQty(), list3.get(i).getTglkadaluarsaDetail(), list.get(i).getKeterangan()});
//            System.out.println("get Transaksi beli obat");
//        }
//        return model;
//    }

    public void insertBeliObatLama(String idTransaksiBeliObat, String tglTransaksiBeliObat, String keterangan, int hargaBeliObat) throws RemoteException {
        Transaksibeliobat trans = new Transaksibeliobat();
        trans.setIdTransaksibeliobat(idTransaksiBeliObat);
        trans.setDateTransaksibeli(tglTransaksiBeliObat);
        trans.setKeterangan(keterangan);
        trans.setHargabeliObat(hargaBeliObat);
        transaksibeliobat.insertTransaksibeliobat(trans);

    }

    public void insertStokObatLama(int idObat, String namaObat, int qtyObat, String jenisObat, String keterangan, int hargaJualObat, int stokKritis) throws RemoteException {
        System.out.println("yeah");
        Obat obat = new Obat();
        obat.setIdObat(idObat);
        obat.setNamaObat(namaObat);
        obat.setQtyObat(qtyObat);
        obat.setJenisObat(jenisObat);
        obat.setKeterangan(keterangan);
        obat.setHargajualObat(hargaJualObat);
        obat.setStokkritisObat(stokKritis);
        obatService.insertObat(obat);
    }

    public void insertDetailTransaksiBeliObat(String idTransaski, int idObat, int qtyObat) throws RemoteException {
        Detailtransaksibeliobat trans1 = new Detailtransaksibeliobat();
        trans1.setTransaksibeliobat(idTransaski);
        trans1.setObat(idObat);
        trans1.setQty(qtyObat);
        detailtransaksibeliobat.insertDetailtransaksibeliobat(trans1);
    }

    public void insertDetailObat(int idDetail, int idObat, String TglKadaluarsa) throws RemoteException {
        Detailobat det = new Detailobat();
        det.setIdDetail(idDetail);
        det.setObatIdObat(idObat);
        det.setTglkadaluarsaDetail(TglKadaluarsa);
        detailobatService.insertDetailobat(det);
    }
    public boolean updateStokObat(int id, int qty) throws RemoteException{
        boolean updated = false;
        Obat obat = new Obat();
        obat.setIdObat(id);
        obat.setQtyObat(qty);
        updated = obatService.updateQtyObat(id,qty);
        return updated;
    }
    
    public int getidDetailObat() throws RemoteException{
        int lastIdDetailObat = detailobatService.getLastIdDetailObat() + 1;
        return lastIdDetailObat;
    }
    
    public int getidObat() throws RemoteException{
        int lastIdObat = obatService.getLastIdObat() +1;
        return lastIdObat;
        
    }
    
  
     
    
    public String[] getNamaPegawai (String username) throws RemoteException{
        String[] namaApoteker = pegawaiService.getIdNamaPegawai(username);
        return namaApoteker;
    }

}
