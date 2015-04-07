package carismaserver.entity;

import carismainterface.entity.Detailresep;
import carismainterface.entity.Kunjungan;
import carismainterface.server.KunjunganService;
import carismaserver.boundaries.Main;
import carismaserver.controllers.DatabaseConnection;
import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public class KunjunganEntity implements KunjunganService {

    public Main ui;

    public KunjunganEntity() {

    }

    public KunjunganEntity(Main ui) {
        this.ui = ui;
    }

    @Override
    public void insertKunjungan(Kunjungan kunjungan) throws RemoteException {
        ui.act.append("Client Execute insertKunjungan " + kunjungan.getIdKunjungan() + "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO kunjungan (id_kunjungan, pasien_id_pasien, rekammedik_id_rekammedik, transaksijualobat_id_transaksijual, pasien_kamar_id_peminjaman, tanggaljam_kunjungan, biaya_kunjungan) values (?,?,?,?,?,?,?)"
            );
            statement.setString(1, kunjungan.getIdKunjungan());
            statement.setString(2, kunjungan.getPasienIdPasien());
            statement.setString(3, kunjungan.getRekammedikIdRekammedik());
            statement.setString(4, kunjungan.getTransaksijualobatIdTransaksijual());
            statement.setString(5, kunjungan.getPasienKamarIdPeminjaman());
            statement.setString(6, kunjungan.getTanggaljamKunjungan());
            statement.setInt(6, kunjungan.getBiayaKunjungan());

            statement.executeUpdate();
        } catch (SQLException exception) {
            ui.act.append("InsertKunjungan Error \n");
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
    public List<Kunjungan> getKunjunganByPasien(String idPasien) throws RemoteException {
        ui.act.append("Client Execute getKunjunganByPasien + " + idPasien + " \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM kunjungan WHERE pasien_id_pasien = " + idPasien);
            ResultSet result = statement.executeQuery();
            List<Kunjungan> list = new ArrayList<Kunjungan>();
            Kunjungan kunjungan = null;
            if (result.next()) {
                kunjungan = new Kunjungan();
                kunjungan.setIdKunjungan(result.getString("id_kunjungan"));
                kunjungan.setPasienIdPasien(result.getString("pasien_id_pasien"));
                kunjungan.setRekammedikIdRekammedik(result.getString("rekammedik_id_rekammedik"));
                kunjungan.setTransaksijualobatIdTransaksijual(result.getString("transaksijualobat_id_transaksijual"));
                kunjungan.setPasienKamarIdPeminjaman(result.getString("pasien_kamar_id_peminjaman"));
                kunjungan.setTanggaljamKunjungan(result.getString("tanggaljam_kunjungan"));
                kunjungan.setBiayaKunjungan(result.getInt("biaya_kunjungan"));
                list.add(kunjungan);
            }
            return list;
        } catch (SQLException exception) {
            ui.act.append("getKunjunganByPasien Error \n");
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
    public Kunjungan getKunjungan(String idKunjungan) throws RemoteException {
        ui.act.append("Client Execute getKunjungan + " + idKunjungan + " \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM kunjungan WHERE id_kunjungan = " + idKunjungan);
            ResultSet result = statement.executeQuery();
            Kunjungan kunjungan = null;
            if (result.next()) {
                kunjungan = new Kunjungan();
                kunjungan.setIdKunjungan(result.getString("id_kunjungan"));
                kunjungan.setPasienIdPasien(result.getString("pasien_id_pasien"));
                kunjungan.setRekammedikIdRekammedik(result.getString("rekammedik_id_rekammedik"));
                kunjungan.setTransaksijualobatIdTransaksijual(result.getString("transaksijualobat_id_transaksijual"));
                kunjungan.setPasienKamarIdPeminjaman(result.getString("pasien_kamar_id_peminjaman"));
                kunjungan.setTanggaljamKunjungan(result.getString("tanggaljam_kunjungan"));
                kunjungan.setBiayaKunjungan(result.getInt("biaya_kunjungan"));
            }
            return kunjungan;
        } catch (SQLException exception) {
            ui.act.append("getKunjungan Error \n");
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
    public List<Kunjungan> getKunjungan() throws RemoteException {
        ui.act.append("Client Execute getKunjunganByPasienList \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM kunjungan");
            ResultSet result = statement.executeQuery();
            List<Kunjungan> list = new ArrayList<Kunjungan>();
            Kunjungan kunjungan = null;
            if (result.next()) {
                kunjungan = new Kunjungan();
                kunjungan.setIdKunjungan(result.getString("id_kunjungan"));
                kunjungan.setPasienIdPasien(result.getString("pasien_id_pasien"));
                kunjungan.setRekammedikIdRekammedik(result.getString("rekammedik_id_rekammedik"));
                kunjungan.setTransaksijualobatIdTransaksijual(result.getString("transaksijualobat_id_transaksijual"));
                kunjungan.setPasienKamarIdPeminjaman(result.getString("pasien_kamar_id_peminjaman"));
                kunjungan.setTanggaljamKunjungan(result.getString("tanggaljam_kunjungan"));
                kunjungan.setBiayaKunjungan(result.getInt("biaya_kunjungan"));
                list.add(kunjungan);
            }
            return list;
        } catch (SQLException exception) {
            ui.act.append("getKunjunganByPasien Error \n");
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
