package carismaserver.entity;

import carismainterface.entity.Pasien;
import carismainterface.server.PasienService;
import carismaserver.boundaries.Main;
import carismaserver.controllers.DatabaseConnection;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public class PasienEntity extends UnicastRemoteObject implements PasienService {

    public Main ui;

    public PasienEntity() throws RemoteException {

    }

    public PasienEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }

    @Override
    public boolean insertPasien(Pasien pasien) throws RemoteException {
        ui.act.append("Client Execute insertPasien " + pasien + "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO pasien (id_pasien, kota_id_kota, user_id_user, nama_pasien, alamat_pasien, kartuid_pasien, nokartuid_pasien, telp_pasien, hp_pasien, tempatlahir_pasien, tgllahir_pasien, kelamin_pasien, darah_pasien, berat_pasien, tinggi_pasien, regdate_pasien) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
            );
            statement.setString(1, pasien.getIdPasien());
            statement.setString(2, pasien.getKotaIdKota());
            statement.setString(3, pasien.getUserIdUser());
            statement.setString(4, pasien.getNamaPasien());
            statement.setString(5, pasien.getAlamatPasien());
            statement.setString(6, pasien.getKartuidPasien());
            statement.setString(7, pasien.getNokartuidPasien());
            statement.setString(8, pasien.getTelpPasien());
            statement.setString(9, pasien.getHpPasien());
            statement.setString(10, pasien.getTempatlahirPasien());
            statement.setString(11, pasien.getTgllahirPasien());
            statement.setString(12, pasien.getKelaminPasien());
            statement.setString(13, pasien.getDarahPasien());
            statement.setInt(14, pasien.getBeratPasien());
            statement.setInt(15, pasien.getTinggiPasien());
            statement.setString(16, pasien.getRegdatePasien());
            statement.executeUpdate();
            return true;
        } catch (SQLException exception) {
            ui.act.append("InsertPasien Error \n");
            ui.act.append(exception.toString());
            return false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {

                }
            }
        }
    }

    @Override
    public boolean updatePasien(Pasien pasien) throws RemoteException {
        ui.act.append("Client Execute updatePasien " + pasien + "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE pasien SET kota_id_kota = ?, user_id_user = ?, nama_pasien = ?, alamat_pasien = ?, kartuid_pasien = ?, nokartuid_pasien = ?, telp_pasien = ?, hp_pasien = ?, tempatlahir_pasien = ?, tgllahir_pasien = ?, kelamin_pasien = ?, darah_pasien = ?, berat_pasien = ?, tinggi_pasien = ?, regdate_pasien = ? WHERE id_pasien = ?"
            );
            statement.setString(1, pasien.getKotaIdKota());
            statement.setString(2, pasien.getUserIdUser());
            statement.setString(3, pasien.getNamaPasien());
            statement.setString(4, pasien.getAlamatPasien());
            statement.setString(5, pasien.getKartuidPasien());
            statement.setString(6, pasien.getNokartuidPasien());
            statement.setString(7, pasien.getTelpPasien());
            statement.setString(8, pasien.getHpPasien());
            statement.setString(9, pasien.getTempatlahirPasien());
            statement.setString(10, pasien.getTgllahirPasien());
            statement.setString(11, pasien.getKelaminPasien());
            statement.setString(12, pasien.getDarahPasien());
            statement.setInt(13, pasien.getBeratPasien());
            statement.setInt(14, pasien.getTinggiPasien());
            statement.setString(15, pasien.getRegdatePasien());
            statement.setString(16, pasien.getIdPasien());
            statement.executeUpdate();
            return true;
        } catch (SQLException exception) {
            ui.act.append("UpdatePasien Error \n");
            ui.act.append(exception.toString());
            return false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {

                }
            }
        }
    }

    @Override
    public boolean deletePasien(String pasien) throws RemoteException {
        ui.act.append("Client Execute deletePasien (" + pasien + ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM pasien WHERE id_pasien = ?");
            statement.setString(1, pasien);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("deletePasien Error \n");
            ui.act.append(e.toString());
            return false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public Pasien getPasien(String pasien) throws RemoteException {
        ui.act.append("Client Execute getPasien (" + pasien + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM pasien WHERE id_pasien = ?");
            statement.setString(1, pasien);
            ResultSet result = statement.executeQuery();
            Pasien pasi = null;
            if (result.next()) {
                pasi = new Pasien();
                pasi.setIdPasien(result.getString("id_pasien"));
                pasi.setKotaIdKota(result.getString("kota_id_kota"));
                pasi.setUserIdUser(result.getString("user_id_user"));
                pasi.setNamaPasien((result.getString("nama_pasien")));
                pasi.setAlamatPasien(result.getString("alamat_pasien"));
                pasi.setKartuidPasien(result.getString("kartuid_pasien"));
                pasi.setNokartuidPasien(result.getString("nokartuid_pasien"));
                pasi.setTelpPasien(result.getString("telp_pasien"));
                pasi.setHpPasien(result.getString("hp_pasien"));
                pasi.setTempatlahirPasien(result.getString("tempatlahir_pasien"));
                pasi.setTgllahirPasien(result.getString("tgllahir_pasien"));
                pasi.setKelaminPasien(result.getString("kelamin_pasien"));
                pasi.setDarahPasien(result.getString("darah_pasien"));
                pasi.setBeratPasien(result.getInt("berat_pasien"));
                pasi.setTinggiPasien(result.getInt("tinggi_pasien"));
                pasi.setRegdatePasien(result.getString("regdate_pasien"));
            }
            return pasi;
        } catch (SQLException exception) {
            ui.act.append("getPasien Error \n");
            ui.act.append(exception.toString());
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public List<Pasien> getPasien() throws RemoteException {
        ui.act.append("Client Execute getPasienList  \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM pasien");
            ResultSet result = statement.executeQuery();
            List<Pasien> list = new ArrayList<Pasien>();
            Pasien pasi = null;
            while (result.next()) {
                pasi = new Pasien();
                pasi.setIdPasien(result.getString("id_pasien"));
                pasi.setKotaIdKota(result.getString("kota_id_kota"));
                pasi.setUserIdUser(result.getString("user_id_user"));
                pasi.setNamaPasien((result.getString("nama_pasien")));
                pasi.setAlamatPasien(result.getString("alamat_pasien"));
                pasi.setKartuidPasien(result.getString("kartuid_pasien"));
                pasi.setNokartuidPasien(result.getString("nokartuid_pasien"));
                pasi.setTelpPasien(result.getString("telp_pasien"));
                pasi.setHpPasien(result.getString("hp_pasien"));
                pasi.setTempatlahirPasien(result.getString("tempatlahir_pasien"));
                pasi.setTgllahirPasien(result.getString("tgllahir_pasien"));
                pasi.setKelaminPasien(result.getString("kelamin_pasien"));
                pasi.setDarahPasien(result.getString("darah_pasien"));
                pasi.setBeratPasien(result.getInt("berat_pasien"));
                pasi.setTinggiPasien(result.getInt("tinggi_pasien"));
                pasi.setRegdatePasien(result.getString("regdate_pasien"));
                list.add(pasi);
            }
            return list;
        } catch (SQLException exception) {
            ui.act.append("getPasienList Error \n");
            ui.act.append(exception.toString());
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public List<Pasien> getPasienByName(String pasien) throws RemoteException {
        ui.act.append("Client Execute getPasienListByName  \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM pasien WHERE nama_pasien LIKE('%" + pasien + "%')");
            ResultSet result = statement.executeQuery();
            List<Pasien> list = new ArrayList<Pasien>();
            Pasien pasi = null;
            if (result.next()) {
                pasi = new Pasien();
                pasi.setIdPasien(result.getString("id_pasien"));
                pasi.setKotaIdKota(result.getString("kota_id_kota"));
                pasi.setUserIdUser(result.getString("user_id_user"));
                pasi.setNamaPasien((result.getString("nama_pasien")));
                pasi.setAlamatPasien(result.getString("alamat_pasien"));
                pasi.setKartuidPasien(result.getString("kartuid_pasien"));
                pasi.setNokartuidPasien(result.getString("nokartuid_pasien"));
                pasi.setTelpPasien(result.getString("telp_pasien"));
                pasi.setHpPasien(result.getString("hp_pasien"));
                pasi.setTempatlahirPasien(result.getString("tempatlahir_pasien"));
                pasi.setTgllahirPasien(result.getString("tgllahir_pasien"));
                pasi.setKelaminPasien(result.getString("kelamin_pasien"));
                pasi.setDarahPasien(result.getString("darah_pasien"));
                pasi.setBeratPasien(result.getInt("berat_pasien"));
                pasi.setTinggiPasien(result.getInt("tinggi_pasien"));
                pasi.setRegdatePasien(result.getString("regdate_pasien"));
                list.add(pasi);
            }
            return list;
        } catch (SQLException exception) {
            ui.act.append("getPasienByNameListByName Error \n");
            ui.act.append(exception.toString());
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public List<Pasien> getPasienRawatinap() throws RemoteException {
        ui.act.append("Client Execute getPasienRawatinapList  \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT P.* FROM `pasien` AS P , `kunjungan` AS K , `pasien_kamar` AS PK "
                            + "WHERE P.id_pasien = K.pasien_id_pasien AND K.pasien_kamar_id_peminjaman = PK.id_peminjaman");
            ResultSet result = statement.executeQuery();
            List<Pasien> list = new ArrayList<Pasien>();
            Pasien pasi = null;
            while (result.next()) {
                pasi = new Pasien();
                pasi.setIdPasien(result.getString("id_pasien"));
                pasi.setKotaIdKota(result.getString("kota_id_kota"));
                pasi.setUserIdUser(result.getString("user_id_user"));
                pasi.setNamaPasien((result.getString("nama_pasien")));
                pasi.setAlamatPasien(result.getString("alamat_pasien"));
                pasi.setKartuidPasien(result.getString("kartuid_pasien"));
                pasi.setNokartuidPasien(result.getString("nokartuid_pasien"));
                pasi.setTelpPasien(result.getString("telp_pasien"));
                pasi.setHpPasien(result.getString("hp_pasien"));
                pasi.setTempatlahirPasien(result.getString("tempatlahir_pasien"));
                pasi.setTgllahirPasien(result.getString("tgllahir_pasien"));
                pasi.setKelaminPasien(result.getString("kelamin_pasien"));
                pasi.setDarahPasien(result.getString("darah_pasien"));
                pasi.setBeratPasien(result.getInt("berat_pasien"));
                pasi.setTinggiPasien(result.getInt("tinggi_pasien"));
                pasi.setRegdatePasien(result.getString("regdate_pasien"));
                list.add(pasi);
            }
            return list;
        } catch (SQLException exception) {
            ui.act.append("getPasienRawatinapList Error \n");
            ui.act.append(exception.toString());
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public boolean isUsedNokartuPasien(String nokartuidpasien) throws RemoteException {
        ui.act.append("Client Execute isUsedNokartuPasien (" + nokartuidpasien + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM pasien WHERE nokartuid_pasien = ?");
            statement.setString(1, nokartuidpasien);
            ResultSet result = statement.executeQuery();
            boolean used = false;
            if (result.next()) {
                used = true;
            }
            return used;
        } catch (SQLException exception) {
            ui.act.append("isUsedNokartuPasien Error \n");
            ui.act.append(exception.toString());
            return true;//iki tak gae true soale gak isok null bingung nek method e rusak hasile opo, jadi nek misal e true berarti kan gak isok input pasien
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
        
    }

    @Override
    public List<Pasien> getPasienRawatinapByName(String pasien) throws RemoteException {
        ui.act.append("Client Execute getPasienRawatinapListByName  \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT P.* FROM `pasien` AS P , `kunjungan` AS K , `pasien_kamar` AS PK "
                            + "WHERE P.nama_pasien LIKE('%" + pasien + "%') AND P.id_pasien = K.pasien_id_pasien AND K.pasien_kamar_id_peminjaman = PK.id_peminjaman");
            ResultSet result = statement.executeQuery();
            List<Pasien> list = new ArrayList<Pasien>();
            Pasien pasi = null;
            while (result.next()) {
                pasi = new Pasien();
                pasi.setIdPasien(result.getString("id_pasien"));
                pasi.setKotaIdKota(result.getString("kota_id_kota"));
                pasi.setUserIdUser(result.getString("user_id_user"));
                pasi.setNamaPasien((result.getString("nama_pasien")));
                pasi.setAlamatPasien(result.getString("alamat_pasien"));
                pasi.setKartuidPasien(result.getString("kartuid_pasien"));
                pasi.setNokartuidPasien(result.getString("nokartuid_pasien"));
                pasi.setTelpPasien(result.getString("telp_pasien"));
                pasi.setHpPasien(result.getString("hp_pasien"));
                pasi.setTempatlahirPasien(result.getString("tempatlahir_pasien"));
                pasi.setTgllahirPasien(result.getString("tgllahir_pasien"));
                pasi.setKelaminPasien(result.getString("kelamin_pasien"));
                pasi.setDarahPasien(result.getString("darah_pasien"));
                pasi.setBeratPasien(result.getInt("berat_pasien"));
                pasi.setTinggiPasien(result.getInt("tinggi_pasien"));
                pasi.setRegdatePasien(result.getString("regdate_pasien"));
                list.add(pasi);
            }
            return list;
        } catch (SQLException exception) {
            ui.act.append("getPasienRawatinapListByName Error \n");
            ui.act.append(exception.toString());
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }
    
}
