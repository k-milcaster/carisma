package carismaserver.controllers;

import carismainterface.entity.Pegawai;
import carismainterface.entity.User;
import carismaserver.entity.PegawaiEntity;
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
public class PegawaiController {

    public DefaultTableModel getPegawai(carismaserver.boundaries.PegawaiManagement ui) throws RemoteException {
        PegawaiEntity pegawaiService = new PegawaiEntity(ui.ui);
        List<Pegawai> list = new ArrayList<Pegawai>();
        list = pegawaiService.getPegawai();
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
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
        return model;
    }

    public boolean insertPegawai(carismaserver.boundaries.PegawaiManagement ui, int username, String id, String nama, String alamat, String nokartu, String telp, String hp1, String hp2, String tempat, String tanggal, String kelamin, String darah, String jabatan, String bank, String norek, int gfix, int glembur, byte[] foto) throws RemoteException {
        PegawaiEntity pegawaiService = new PegawaiEntity(ui.ui);
        try {
            User user = new User();
            Pegawai pegawai = new Pegawai();
            pegawai.setJabatanPegawai(jabatan);
            pegawai.setUserIdUser(username);
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
            boolean success = pegawaiService.insertPegawai(pegawai);
            if (success) {
                return true;
            } else {
                return false;
            }
        } catch (RemoteException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updatePegawai(carismaserver.boundaries.PegawaiManagement ui, int username, String id, String nama, String alamat, String nokartu, String telp, String hp1, String hp2, String tempat, String tanggal, String kelamin, String darah, String jabatan, String bank, String norek, int gfix, int glembur, byte[] foto) throws RemoteException {
        PegawaiEntity pegawaiService = new PegawaiEntity(ui.ui);
        try {
            User user = new User();
            Pegawai pegawai = new Pegawai();
            pegawai.setJabatanPegawai(jabatan);
            pegawai.setUserIdUser(username);
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
            boolean success = pegawaiService.updatePegawai(pegawai);
            if (success) {
                return true;
            } else {
                return false;
            }
        } catch (RemoteException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deletePegawai(carismaserver.boundaries.PegawaiManagement ui, String id) throws RemoteException {
        PegawaiEntity dokterService = new PegawaiEntity(ui.ui);
        try {
            boolean success = dokterService.deletePegawai(id);
            if (success) {
                return true;
            } else {
                return false;
            }
        } catch (RemoteException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
