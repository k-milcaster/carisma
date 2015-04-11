/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import carismainterface.entity.Antrian;
import carismainterface.server.AntrianService;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adinda
 */
public class AntrianController {
    private AntrianService antrian;
   
    public AntrianController(ClientSocket client) throws RemoteException{
        this.antrian = client.getAntrianService();
        Antrian antrian = new Antrian();
                                
    }
    public void lihatAntrian() throws RemoteException{
     List<Antrian> list = new ArrayList<Antrian>();
        list = antrian.getAntrian();
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("Id Antrian");
        tabel.addColumn("Pasien id_pasien");
        tabel.addColumn("Dokter id_dokter");
        tabel.addColumn("Nomor Antrian");
        tabel.addColumn("Jenis Antrian");
        tabel.addColumn("Tanggal Antrian");
        tabel.addColumn("Hadir");
    
    }

}
