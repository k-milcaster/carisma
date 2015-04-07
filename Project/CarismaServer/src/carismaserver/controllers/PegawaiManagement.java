package carismaserver.controllers;

import carismainterface.entity.Pegawai;
import carismainterface.entity.User;
import carismaserver.entity.StaffEntity;
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
public class PegawaiManagement {
    public void getPegawai(carismaserver.boundaries.StaffManagement ui) throws RemoteException {
        StaffEntity pegawaiService = new StaffEntity(ui.ui);
        List<Pegawai> list = new ArrayList<Pegawai>();
        list = pegawaiService.getPegawai();
        DefaultTableModel model = new DefaultTableModel();      
        model.addColumn("No."); 
        model.addColumn("Nama"); 
        model.addColumn("Jabatan");
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
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{i, list.get(i).getNamaPegawai(), list.get(i).getJabatanPegawai(), list.get(i).getAlamatPegawai(), list.get(i).getNokartuidPegawai(), list.get(i).getTelpPegawai(), list.get(i).getHp1Pegawai(),
            list.get(i).getHp2Pegawai(), list.get(i).getTempatlahirPegawai(), list.get(i).getTgllahirPegawai(), list.get(i).getKelaminPegawai(), list.get(i).getDarahPegawai(),
            list.get(i).getBankPegawai(), list.get(i).getNorekPegawai(), list.get(i).getGajifixPegawai(), list.get(i).getGajilemburPegawai()});
            System.out.println("lewat");
        }
        ui.tablePegawai.setModel(model);
    }
    
    public void insertPegawai(carismaserver.boundaries.StaffManagement ui, String username, String id, String nama, String alamat, String nokartu, String telp, String hp1, String hp2, String tempat, String tanggal, String kelamin, String darah, String jabatan, String bank, String norek, int gfix, int glembur, byte[] foto) throws RemoteException {
        StaffEntity pegawaiService = new StaffEntity(ui.ui);        
        try {
            User user = new User();
            Pegawai pegawai = new Pegawai();
            user.setIdUser(Integer.parseInt(username));
            pegawai.setIdPegawai(id);
            pegawai.setNamaPegawai(nama);
            pegawai.setAlamatPegawai(alamat);
            pegawai.setNokartuidPegawai(nokartu);
            pegawai.setTelpPegawai(telp);
            pegawai.setHp1Pegawai(hp1);
            pegawai.setHp2Pegawai(hp2);
            pegawai.setTempatlahirPegawai(tempat);
            pegawai.setTgllahirPegawai(tanggal);
            pegawai.setKelaminPegawai(kelamin);
            pegawai.setDarahPegawai(darah);
            pegawai.setJabatanPegawai(jabatan);
            pegawai.setBankPegawai(bank);
            pegawai.setNorekPegawai(norek);
            pegawai.setGajifixPegawai(gfix);
            pegawai.setGajilemburPegawai(glembur);
            pegawai.setFotoPegawai(foto);
            pegawaiService.insertPegawai(pegawai);
        } catch (RemoteException ex) {
            Logger.getLogger(UserManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
