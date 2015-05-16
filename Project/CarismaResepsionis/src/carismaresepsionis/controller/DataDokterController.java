/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import carismainterface.entity.Dokter;
import carismainterface.entity.Poli;
import carismainterface.server.DokterService;
import carismaresepsionis.boundaries.dokterform;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anes Dirsi
 */
public class DataDokterController {

    private DokterService dokterService;

    public DataDokterController(ClientSocket client) throws RemoteException {
        this.dokterService = client.getDokterService();
    }

    public DefaultTableModel getDokterList() throws RemoteException {
        List<Dokter> list = new ArrayList<Dokter>();
        list = dokterService.getDokter();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Dokter");
        model.addColumn("Nama Dokter");
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getIdDokter(), list.get(i).getNamaDokter()});
        }
        //ui.TabelDokter.setModel(model);
        return model;
    }

    public DefaultTableModel getDokterByName(String nama) throws RemoteException {
        List<Dokter> list = new ArrayList<Dokter>();
        list = dokterService.getDokterByName(nama);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Dokter");
        model.addColumn("Nama Dokter");
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getIdDokter(), list.get(i).getNamaDokter()});
        }
        return model;
    }

    public String[] getDokterByIdDokter(String idDokter) throws RemoteException {
        String[] informasiDokter = dokterService.getDokterById(idDokter);
        return informasiDokter;
    }
}
