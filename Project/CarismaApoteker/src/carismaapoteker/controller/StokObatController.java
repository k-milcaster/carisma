/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaapoteker.controller;

import carismaapoteker.boundaries.StokObat;
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
    
    public StokObatController (ClientSocket client) throws RemoteException{
        //Obat obat = new Obat();
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
            model.addRow(new Object[]{list.get(i).getIdObat(), list.get(i).getNamaObat(), list.get(i).getQtyObat(), list.get(i).getJenisObat(), list.get(i).getKeterangan(), list.get(i).getHargajualObat(),list.get(i).getKeterangan()});
            System.out.println("lewat");
        }
        ui.tableMedicine.setModel(model);
        return model;
    }
       
    }
   

