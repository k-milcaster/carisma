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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sinta Eka Lestari
 */
public class TransaksiJualObatController {

    private TransaksijualobatService transaksijualobat;
    private DetailtransaksijualobatService detailtransaksijual;
    private ObatService obatService;

    public TransaksiJualObatController(ClientSocket client) throws RemoteException {
        Transaksijualobat trans = new Transaksijualobat();
        this.transaksijualobat = client.getTransaksijualobatService();
        obatService = client.getObatService();
    }

    public void insertTransaksijualobat(String idTransaksijual, String dateTransaksijual, String keterangan) throws RemoteException {
        Transaksijualobat transaksijual = new Transaksijualobat();
        transaksijual.setIdTransaksijual(idTransaksijual);
        transaksijual.setDateTransaksijual(dateTransaksijual);
        transaksijual.setKeterangan(keterangan);
        transaksijualobat.insertTransaksijualbat(transaksijual);

    }

    public void insertDetailtransaksijualobat(String idTransaksi, int idObat, int qty) throws RemoteException {
        Detailtransaksijualobat detailtransaksi = new Detailtransaksijualobat();
        detailtransaksi.setTransaksijualobat(idTransaksi);
        detailtransaksi.setObat(idObat);
        detailtransaksi.setQty(qty);
        detailtransaksijual.insertDetailtransaksijualobat(detailtransaksi);

    }

    public DefaultTableModel getIdObat(TransaksiJualObat b) throws RemoteException {
        List<Obat> list = new ArrayList<Obat>();
        list = obatService.getObat();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Id Obat");
            model.addColumn("Nama Obat");
            model.addColumn("Harga");
            model.addColumn("Jumlah");
            for (int i = 0; i < list.size(); i++) {
            b.IdObat.addItem(list.get(i).getIdObat() + " " + list.get(i).getNamaObat());
            System.out.println(model);
                
            }
            return model;
            
        }

    }

