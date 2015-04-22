/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaapoteker.controller;

import carismaapoteker.boundaries.StokObat;
import carismainterface.entity.Detailobat;
import carismainterface.entity.Obat;
import carismainterface.server.DetailobatService;
import carismainterface.server.ObatService;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Hana Mahrifah
 */
public class StokObatController {
    private ObatService obatService;
    private DetailobatService detailobatService;
    
    public StokObatController (ClientSocket client) throws RemoteException{
        //Obat obat = new Obat();
        this.detailobatService = client.getDetailonatSerivice();
        this.obatService = client.getObatService();
    }
    public DefaultTableModel getObats(StokObat ui) throws RemoteException{
        List<Obat> list = new ArrayList<Obat>();
        list = obatService.getObat();
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
        }
        ui.tableMedicine.setModel(model);
        return model;
    }
    
    public DefaultTableModel getDetailObat(int id) throws RemoteException{
        List<Detailobat> list = new ArrayList<Detailobat>();
        list = detailobatService.getDetailobatbyIdObat(id);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Obat");
        model.addColumn("Id Detail");
        model.addColumn("Tanggal Kadaluarsa");
        for(int i = 0;i<list.size();i++){
            model.addRow(new Object []{list.get(i).getObatIdObat(),list.get(i).getIdDetail(),list.get(i).getTglkadaluarsaDetail()});
            System.out.println("get detail obat");
        }
        return model;
        
    }
    public void updateStokObat (int idObat, String namaObat, int qtyObat, String jenisObat, String keterangan, int hargaJualObat, int stokKritis) throws RemoteException{   
            Obat obat = new Obat();
            obat.setIdObat(idObat);
            obat.setNamaObat(namaObat);
            obat.setQtyObat(qtyObat);
            obat.setJenisObat(jenisObat);
            obat.setKeterangan(keterangan);
            obat.setHargajualObat(hargaJualObat);
            obat.setStokkritisObat(stokKritis);
            obatService.updateObat(obat);
    
    }
    public DefaultTableModel getObatbyName (String nama) throws RemoteException{
        System.out.println("lalalala");
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
   

