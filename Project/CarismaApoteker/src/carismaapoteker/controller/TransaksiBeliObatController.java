/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaapoteker.controller;

import carismainterface.entity.Transaksibeliobat;
import carismainterface.server.TransaksibeliobatService;
import java.rmi.RemoteException;

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
    
//    
//    public void insertTransaksiBeliObat(carismaapoteker.boundaries.TransaksiBeliObat ui){
//        
//    }
}
