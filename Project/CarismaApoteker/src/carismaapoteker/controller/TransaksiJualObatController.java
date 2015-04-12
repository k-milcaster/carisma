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

/**
 *
 * @author Sinta Eka Lestari
 */
public class TransaksiJualObatController {
    private TransaksijualobatService transaksijualobat;
    private DetailtransaksijualobatService detailtransaksijual;
    private ObatService obatService;
    
    
    public TransaksiJualObatController (ClientSocket client) throws RemoteException{
        Transaksijualobat trans = new Transaksijualobat();
        this.transaksijualobat = client.getTransaksijualobatService();
        obatService = client.getObatService();
    }  
    public void insertTransaksijualobat (String idTransaksijual , String dateTransaksijual, String keterangan) throws RemoteException{
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
    public void getIdObat (TransaksiJualObat b) throws RemoteException{
        List <Obat> list = new ArrayList<Obat>();
        list = obatService.getObat();
        for (int i = 0; i < list.size(); i++){
            b.comboBoxObat.addItem(list.get(i).getNamaObat());
        }
        
    }
    
    }
    

