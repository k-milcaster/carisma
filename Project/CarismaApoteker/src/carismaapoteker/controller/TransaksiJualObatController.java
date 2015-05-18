/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaapoteker.controller;

import carismaapoteker.boundaries.TransaksiJualObat;
import carismainterface.entity.Detailtransaksijualobat;
import carismainterface.entity.Obat;
import carismainterface.entity.Transaksijualobat;
import carismainterface.server.DetailtransaksijualobatService;
import carismainterface.server.ObatService;
import carismainterface.server.TransaksijualobatService;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import carismaapoteker.boundaries.TabelObat;
import carismainterface.server.PegawaiService;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sinta Eka Lestari
 */
public class TransaksiJualObatController {

    private TransaksijualobatService transaksijualobat;
    private DetailtransaksijualobatService detailtransaksijual;
    private ObatService obatService;
    private PegawaiService pegawaiService;

    public TransaksiJualObatController(ClientSocket client) throws RemoteException {
       
        this.transaksijualobat = client.getTransaksijualobatService();
        obatService = client.getObatService();
        pegawaiService = client.getPegawaiService();
    }

    public boolean insertTransaksijualobat(String idTransaksijual, String dateTransaksijual, String keterangan) throws RemoteException {
        boolean insert = false;
        Transaksijualobat transaksijual = new Transaksijualobat();
        transaksijual.setIdTransaksijual(idTransaksijual);
        transaksijual.setDateTransaksijual(dateTransaksijual);
        transaksijual.setKeterangan(keterangan);
        insert = transaksijualobat.insertTransaksijualobat(transaksijual);
        return insert;

    }

    public boolean insertDetailtransaksijualobat(String idTransaksi, int idObat, int qty) throws RemoteException {
        boolean insertDetail = false;
        Detailtransaksijualobat detailtransaksi = new Detailtransaksijualobat();
        detailtransaksi.setTransaksijualobat(idTransaksi);
        detailtransaksi.setObat(idObat);
        detailtransaksi.setQty(qty);
        insertDetail = detailtransaksijual.insertDetailtransaksijualobat(detailtransaksi);
        System.out.println("Masuk Insert Detail");
        return insertDetail;

    }

    public DefaultTableModel getTableObat() throws RemoteException {
        List<Obat> list = new ArrayList<Obat>();
        list = obatService.getObat();
        //for (int i = 0; i < list.size(); i++){
        //b.comboBoxObat.addItem(list.get(i).getNamaObat());
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Obat");
        model.addColumn("Nama Obat");
        model.addColumn("Quantity");
        model.addColumn("Jenis");
        model.addColumn("Keterangan");
        model.addColumn("Harga Jual");
        model.addColumn("Stok Kritis");
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getIdObat(), list.get(i).getNamaObat(), list.get(i).getQtyObat(), list.get(i).getJenisObat(), list.get(i).getKeterangan(), list.get(i).getHargajualObat(), list.get(i).getStokkritisObat()});
            System.out.println("Lewati");
        }
        return model;
    }
    
    public int cekStok (int idObat) throws RemoteException{
        int stok = obatService.cekStokObat(idObat);
        return stok;
    }
    public String[] namaPegawai (String username) throws RemoteException{
        String[] namaApoteker = pegawaiService.getIdNamaPegawai(username);
        return namaApoteker;
    }
     public DefaultTableModel getObatbyName (String nama) throws RemoteException{
        System.out.println("xyxyxyx");
        List<Obat> list = new ArrayList<Obat>();
        list = obatService.getObatbyName(nama);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Obat");
        model.addColumn("Nama Obat");
        model.addColumn("Quantity");
        model.addColumn("Jenis");
        model.addColumn("Keterangan");
        model.addColumn("Harga Jual");
        model.addColumn("Stok Kritis");
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getIdObat(), list.get(i).getNamaObat(), list.get(i).getQtyObat(), list.get(i).getJenisObat(), list.get(i).getKeterangan(), list.get(i).getHargajualObat(),list.get(i).getStokkritisObat()});
            System.out.println(model);
        }
        return model;
        
    } 

       
    }
   




