/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaapoteker.controller;

import carismaapoteker.boundaries.TransaksiBeliObat;
import carismainterface.entity.Transaksibeliobat;
import carismainterface.server.TransaksibeliobatService;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hana Mahrifah
 */
public class TransaksiBeliObatController {
    private TransaksibeliobatService transaksibeliobat;
    
    
    public TransaksiBeliObatController(ClientSocket client) throws RemoteException{
        Transaksibeliobat trans = new Transaksibeliobat();
        this.transaksibeliobat = client.getTransaksibeliobatService();
    }
    
    public DefaultTableModel getTransaksiBeliObat(TransaksiBeliObat ui){
    List<Transaksibeliobat> list = new ArrayList<Transaksibeliobat>();
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Id Transaksi Beli Obat");
    model.addColumn("Tanggal Beli Obat");
    model.addColumn("Keterangan");
    model.addColumn("Harga Beli Obat");
    for(int i = 0;i<list.size();i++){
        model.addRow(new Object []{list.get(i).getIdTransaksibeliobat(),list.get(i).getDateTransaksibeli(),list.get(i).getKeterangan(),list.get(i).getHargabeliObat()});
        System.out.println("get Transaksi beli obat");
    }
    return model;
    }
//    
//    public void insertTransaksiBeliObat(carismaapoteker.boundaries.TransaksiBeliObat ui){
//        
//    }
}
