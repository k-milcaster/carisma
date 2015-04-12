
package carismaresepsionis.controller;

import carismainterface.entity.Pasien;
import carismainterface.server.PasienService;
import java.rmi.RemoteException;
/**
 *
 * @author Fiqhi Darmawan
 */
public class regispasiencontroller {

    private PasienService pasienService;
     
  
    public regispasiencontroller( ClientSocket client ) throws RemoteException {    
    this.pasienService = client.getPasienService();
    }
    
    public void InsertNamaPasien(String id_pasien, String kota_id_kota, String user_id_user, String nama_pasien, String alamat_pasien, String kartuid_pasien, String nokartuid_pasien, String telp_pasien, String hp_pasien, String tempatlahirpasien, String tgllahir_pasien, String kelamin_pasien, String darah_pasien, int berat_pasien, int tinggi_Pasien, String regdate_pasien   ) throws RemoteException{
        Pasien pasien = new Pasien();
        pasien.setIdPasien(id_pasien);
        pasien.setKotaIdKota(kota_id_kota);
        pasien.setUserIdUser(user_id_user);
        pasien.setNamaPasien(nama_pasien);
        pasien.setAlamatPasien(alamat_pasien);
        pasien.setKartuidPasien(kartuid_pasien);
        pasien.setNokartuidPasien(nokartuid_pasien);
        pasien.setTelpPasien(telp_pasien);
        pasien.setHpPasien(hp_pasien);
        pasien.setTempatlahirPasien(tempatlahirpasien);
        pasien.setTgllahirPasien(tgllahir_pasien);
        pasien.setKelaminPasien(kelamin_pasien);
        pasien.setDarahPasien(darah_pasien);
        pasien.setBeratPasien(berat_pasien);
        pasien.setTinggiPasien(tinggi_Pasien);
        pasien.setRegdatePasien(regdate_pasien);
        pasienService.insertPasien(pasien);
    }

}
