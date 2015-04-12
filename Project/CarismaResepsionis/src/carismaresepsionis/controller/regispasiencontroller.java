package carismaresepsionis.controller;

import carismainterface.entity.Kota;
import carismainterface.entity.Pasien;
import carismainterface.server.KotaService;
import carismainterface.server.PasienService;
import carismaresepsionis.boundaries.regispasienform;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Fiqhi Darmawan
 */
public class regispasiencontroller {

    private PasienService pasienService;
    private KotaService kotaService;

    public regispasiencontroller(ClientSocket client) throws RemoteException {
        this.pasienService = client.getPasienService();
        this.kotaService = client.getKotaService();
    }

    public void InsertNamaPasien(String id_pasien, String kota_id_kota, String user_id_user, String nama_pasien, String alamat_pasien, String kartuid_pasien, String nokartuid_pasien, String telp_pasien, String hp_pasien, String tempatlahirpasien, String tgllahir_pasien, String kelamin_pasien, String darah_pasien, int berat_pasien, int tinggi_Pasien, String regdate_pasien) throws RemoteException {
        Pasien pasien = new Pasien();
        System.out.println(generatePasienId(nama_pasien, tgllahir_pasien, nokartuid_pasien));
//        pasien.setIdPasien(id_pasien);
//        pasien.setKotaIdKota(kota_id_kota);
//        pasien.setUserIdUser(user_id_user);
//        pasien.setNamaPasien(nama_pasien);
//        pasien.setAlamatPasien(alamat_pasien);
//        pasien.setKartuidPasien(kartuid_pasien);
//        pasien.setNokartuidPasien(nokartuid_pasien);
//        pasien.setTelpPasien(telp_pasien);
//        pasien.setHpPasien(hp_pasien);
//        pasien.setTempatlahirPasien(tempatlahirpasien);
//        pasien.setTgllahirPasien(tgllahir_pasien);
//        pasien.setKelaminPasien(kelamin_pasien);
//        pasien.setDarahPasien(darah_pasien);
//        pasien.setBeratPasien(berat_pasien);
//        pasien.setTinggiPasien(tinggi_Pasien);
//        pasien.setRegdatePasien(regdate_pasien);
//        pasienService.insertPasien(pasien);
    }

    public String generateUserName(String nama, String tgl) {
        return null;
    }

    public String generatePasienId(String Nama, String tgl, String end) {
        String pasienId = Character.toString(Nama.charAt(0)).toUpperCase() + Character.toString(Nama.charAt(Nama.length() - 1)).toUpperCase() + Character.toString(tgl.charAt(0)) + Character.toString(tgl.charAt(1)) + Character.toString(tgl.charAt(2)) + Character.toString(tgl.charAt(3)) + Character.toString(tgl.charAt(5)) + Character.toString(tgl.charAt(6)) + Character.toString(tgl.charAt(8)) + Character.toString(tgl.charAt(9)) + Character.toString(end.charAt(end.length() - 1)) + Character.toString(end.charAt(end.length() - 2));
        return pasienId;
    }

    public void setComboBoxKota(regispasienform ui) {
        ArrayList<Kota> list = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            ui.Kota.addItem(list.get(i).getNamaKota());
        }        
    }
    
   
}
