/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaapoteker.controller;

import carismainterface.entity.Obat;
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
    
    public StokObatController (ClientSocket client){
        Obat obat = new Obat();
        this.obatService = client.getObatService();
    }
    public void getObats() throws RemoteException{
        List<Obat> list = new ArrayList<Obat>();
        list = obatService.getObat();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Obat");
        model.addColumn("Nama Obat");
        model.addColumn("Quantity");
        model.addColumn("Jenis");
        model.addColumn("Keterangan");
        model.addColumn("Harga Jual");
        model.addColumn("Tanggal Kadaluarsa");
        model.addColumn("Stok Kritis");
        
    }
   
}
