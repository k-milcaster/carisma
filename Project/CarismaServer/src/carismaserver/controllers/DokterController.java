/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaserver.controllers;

import carismainterface.entity.Dokter;
import carismainterface.entity.User;
import carismaserver.entity.DokterEntity;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
public class DokterController {

    public DefaultTableModel getDokter(carismaserver.boundaries.DokterManagement ui) throws RemoteException {
        DokterEntity dokterService = new DokterEntity(ui.ui);
        List<Dokter> list = new ArrayList<Dokter>();
        list = dokterService.getDokter();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("Nama");
        model.addColumn("Alamat");
        model.addColumn("No Kartu ID");
        model.addColumn("Telepon");
        model.addColumn("HP1");
        model.addColumn("HP2");
        model.addColumn("Tempat Lahir");
        model.addColumn("Tanggal Lahir");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Gol. Darah");
        model.addColumn("Bank");
        model.addColumn("No Rek");
        model.addColumn("Gaji Fix");
        model.addColumn("Gaji Lembur");
        model.addColumn("Gaji Konsul");
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{i, list.get(i).getNamaDokter(), list.get(i).getAlamatDokter(), list.get(i).getNokartuidDokter(), list.get(i).getTelpDokter(), list.get(i).getHp1Dokter(),
                list.get(i).getHp2Dokter(), list.get(i).getTempatlahirDokter(), list.get(i).getTgllahirDokter(), list.get(i).getKelaminDokter(), list.get(i).getDarahDokter(),
                list.get(i).getBankDokter(), list.get(i).getNorekDokter(), list.get(i).getGajifixDokter(), list.get(i).getGajilemburDokter(), list.get(i).getGajikonsulDokter()});
        }
        return model;
    }

    public boolean insertDokter(carismaserver.boundaries.DokterManagement ui, int userid, String poliid, String id, String nama, String alamat, String nokartu, String telp, String hp1, String hp2, String tempat, String tanggal, String kelamin, String darah, String bank, String norek, int gfix, int glembur, double gkonsul, byte[] foto) throws RemoteException {
        DokterEntity dokterService = new DokterEntity(ui.ui);
        try {
            Dokter dokter = new Dokter();
            dokter.setUserIdUser(userid);
            dokter.setPoliIdPoli(poliid);
            dokter.setIdDokter(id);
            dokter.setNamaDokter(nama);
            dokter.setAlamatDokter(alamat);
            dokter.setNokartuidDokter(nokartu);
            dokter.setTelpDokter(telp);
            dokter.setHp1Dokter(hp1);
            dokter.setHp2Dokter(hp2);
            dokter.setTempatlahirDokter(tempat);
            dokter.setTgllahirDokter(tanggal);
            dokter.setKelaminDokter(kelamin);
            dokter.setDarahDokter(darah);
            dokter.setBankDokter(bank);
            dokter.setNorekDokter(norek);
            dokter.setGajifixDokter(gfix);
            dokter.setGajilemburDokter(glembur);
            dokter.setGajikonsulDokter(gkonsul);
            dokter.setFotoDokter(foto);
            boolean success = dokterService.insertDokter(dokter);
            if(success){
                return true;
            }
            else {
                return false;
            }
        } catch (RemoteException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean updateDokter(carismaserver.boundaries.DokterManagement ui, int userid, String poliid, String id, String nama, String alamat, String nokartu, String telp, String hp1, String hp2, String tempat, String tanggal, String kelamin, String darah, String bank, String norek, int gfix, int glembur, double gkonsul, byte[] foto) throws RemoteException {
        DokterEntity dokterService = new DokterEntity(ui.ui);
        try {
            Dokter dokter = new Dokter();
            dokter.setUserIdUser(userid);
            dokter.setPoliIdPoli(poliid);
            dokter.setIdDokter(id);
            dokter.setNamaDokter(nama);
            dokter.setAlamatDokter(alamat);
            dokter.setNokartuidDokter(nokartu);
            dokter.setTelpDokter(telp);
            dokter.setHp1Dokter(hp1);
            dokter.setHp2Dokter(hp2);
            dokter.setTempatlahirDokter(tempat);
            dokter.setTgllahirDokter(tanggal);
            dokter.setKelaminDokter(kelamin);
            dokter.setDarahDokter(darah);
            dokter.setBankDokter(bank);
            dokter.setNorekDokter(norek);
            dokter.setGajifixDokter(gfix);
            dokter.setGajilemburDokter(glembur);
            dokter.setGajikonsulDokter(gkonsul);
            dokter.setFotoDokter(foto);
            boolean success = dokterService.updateDokter(dokter);
            if(success){
                return true;
            }
            else {
                return false;
            }
        } catch (RemoteException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean deleteDokter(carismaserver.boundaries.DokterManagement ui, String id) throws RemoteException {
        DokterEntity dokterService = new DokterEntity(ui.ui);
        try{
            boolean success = dokterService.deleteDokter(id);
            if(success){
                return true;
            }
            else {
                return false;
            }
        } catch (RemoteException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
}
