/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaserver.controllers;

import carismainterface.entity.Poli;
import carismaserver.entity.PoliEntity;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kepoterz
 */
public class PoliController {
    public DefaultTableModel getPolis(carismaserver.boundaries.PoliManagement ui) throws RemoteException {
        PoliEntity poliService = new PoliEntity(ui.ui);
        List<Poli> list = new ArrayList<Poli>();
        list = poliService.getPoli();
        DefaultTableModel model = new DefaultTableModel();      
        model.addColumn("No. "); 
        model.addColumn("Nama Poli"); 
        model.addColumn("Keterangan"); 
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{i, list.get(i).getNamaPoli(), list.get(i).getKeterangan()});
        }
        return model;
    }
    
    public boolean insertPoli(carismaserver.boundaries.PoliManagement ui,String idpoli,String namapoli,String keterangan) throws RemoteException {
        PoliEntity poliService = new PoliEntity(ui.ui);
        try {
            Poli poli = new Poli();
            poli.setIdPoli(idpoli);
            poli.setNamaPoli(namapoli);
            poli.setKeterangan(keterangan);
            poliService.insertPoli(poli);
            return true;
        } catch (RemoteException ex) {
            Logger.getLogger(PoliController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean updatePoli(carismaserver.boundaries.PoliManagement ui,String idpoli,String namapoli,String keterangan) throws RemoteException{
        PoliEntity poliService = new PoliEntity(ui.ui);
        try{
            Poli poli = new Poli();
            poli.setIdPoli(idpoli);
            poli.setNamaPoli(namapoli);
            poli.setKeterangan(keterangan);
            poliService.updatePoli(poli);
            return true;
        } catch (RemoteException ex) {
            Logger.getLogger(PoliController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean deletePoli(carismaserver.boundaries.PoliManagement ui,String idpoli) throws RemoteException{
        PoliEntity poliService = new PoliEntity(ui.ui);
        try{
            Poli poli = new Poli(idpoli);
            poliService.deletePoli(poli);
            return true;
        } catch (RemoteException ex) {
            Logger.getLogger(PoliController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
