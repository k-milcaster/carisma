package carismaserver.entity;

import carismainterface.entity.Detailresep;
import carismainterface.entity.Kunjungan;
import carismainterface.server.KunjunganService;
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
public class KunjunganEntity extends UnicastRemoteObject implements KunjunganService {

    public Main ui;

    public KunjunganEntity() throws RemoteException {
    }

    public KunjunganEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }

    @Override
    public boolean insertKunjungan(Kunjungan kunjungan) throws RemoteException {
        ui.act.append("Client Execute insertKunjungan " + kunjungan.getIdKunjungan() + "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO kunjungan (id_kunjungan, pasien_id_pasien, rekammedik_id_rekammedik, transaksijualobat_id_transaksijual, pasien_kamar_id_peminjaman, tanggaljam_kunjungan, biaya_kunjungan) values (?,?,?,?,?,?,?)");
            statement.setString(1, kunjungan.getIdKunjungan());
            statement.setString(2, kunjungan.getPasienIdPasien());
            statement.setString(3, kunjungan.getRekammedikIdRekammedik());
            statement.setString(4, kunjungan.getTransaksijualobatIdTransaksijual());
            statement.setString(5, kunjungan.getPasienKamarIdPeminjaman());
            statement.setString(6, kunjungan.getTanggaljamKunjungan());
            statement.setInt(7, kunjungan.getBiayaKunjungan());

            statement.executeUpdate();
            return true;
        } catch (SQLException exception) {
            ui.act.append("InsertKunjungan Error \n");
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
    public boolean updateKunjungan(Kunjungan kunjungan) {
        ui.act.append("Client Execute updateKunjungan (" + kunjungan.getIdKunjungan() + " \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE kunjungan SET transaksijualobat_id_transaksijual = ?, pasien_kamar_id_peminjaman = ? WHERE id_kunjungan = ?");
            statement.setString(1, kunjungan.getTransaksijualobatIdTransaksijual());
            statement.setString(2, kunjungan.getPasienKamarIdPeminjaman());
            statement.setString(3, kunjungan.getIdKunjungan());
            statement.executeUpdate();
            return true;
        } catch (SQLException exception) {
            ui.act.append("UpdateKunjungan Error \n");
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
    public boolean deleteKunjungan(String idKunjungan) throws RemoteException {
        ui.act.append("Client Execute deleteKunjungan (" + idKunjungan + " \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM kunjungan WHERE id_kunjungan = ?");
            statement.setString(1, idKunjungan);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("deleteKunjungan Error \n");
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
    public Kunjungan getKunjungan(String idKunjungan) throws RemoteException {
        ui.act.append("Client Execute getKunjungan " + idKunjungan + " \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM kunjungan WHERE id_kunjungan = ?");
            statement.setString(1, idKunjungan);
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
    public String getLastIdKunjungan() throws RemoteException {
        ui.act.append("Client Execute getLastKunjungan");
        String idKunjungan = " ";
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement("SELECT MAX(`id_kunjungan`) FROM `kunjungan`");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                idKunjungan = resultSet.getString(1);
            }
            return idKunjungan;
        } catch (SQLException exception) {
            ui.act.append("getLastIdKunjungan Error\n");
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
