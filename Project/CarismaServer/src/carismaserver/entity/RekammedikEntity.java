package carismaserver.entity;

import carismainterface.entity.Rekammedik;
import carismainterface.server.RekammedikService;
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
public class RekammedikEntity extends UnicastRemoteObject implements RekammedikService {

    public Main ui;

    public RekammedikEntity() throws RemoteException {

    }

    public RekammedikEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }

    @Override
    public void insertRekamMedik(Rekammedik rekamMedik) throws RemoteException {
        ui.act.append("Client Execute insertRekammedik " + rekamMedik.getIdRekammedik() + " \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO rekammedik (id_rekammedik, dokter_id_dokter, pasien_id_pasien, tgl_rekammedik, keluhan_rekammedik, pemeriksaan_rekammedik, terapi_rekammedik, alergiobat_rekammedik, kesimpulan_rekammedis, kondisipasienkeluar_rekammedis, resep_id_resep) values (?,?,?,?,?,?,?,?,?,?,?)"
            );
            statement.setString(1, rekamMedik.getIdRekammedik());
            statement.setString(2, rekamMedik.getDokterIdDokter());
            statement.setString(3, rekamMedik.getPasienIdPasien());
            statement.setString(4, rekamMedik.getTglRekammedik());
            statement.setString(5, rekamMedik.getKeluhanRekammedik());
            statement.setString(6, rekamMedik.getPemeriksaanRekammedik());
            statement.setString(7, rekamMedik.getTerapiRekammedik());
            statement.setString(8, rekamMedik.getAlergiobatRekammedik());
            statement.setString(9, rekamMedik.getKesimpulanRekammedis());
            statement.setString(10, rekamMedik.getKondisipasienkeluarRekammedis());
            statement.setString(11, rekamMedik.getResepIdResep());
            statement.executeUpdate();
        } catch (SQLException exception) {
            ui.act.append("InsertRekammedik Error \n");
            ui.act.append(exception.toString());
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
    public void updateRekamMedik(Rekammedik rekamMedik) throws RemoteException {
        //masak rekammedik di update??
    }

    @Override
    public void deleteRekamMedik(String rekamMedik) throws RemoteException {
        ui.act.append("Client Execute deleteRekamMedik (" + rekamMedik + " \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM rekammedik WHERE id_rekammedik = ?");
            statement.setString(1, rekamMedik);
            statement.executeUpdate();
        } catch (SQLException e) {
            ui.act.append("deleteRekamMedik Error \n");
            ui.act.append(e.toString());
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
    public Rekammedik getRekamMedik(String rekamMedik) throws RemoteException {
        ui.act.append("Client Execute getgetRekamMedik (" + rekamMedik + " \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM rekammedik WHERE id_rekammedik = ?");
            statement.setString(1, rekamMedik);
            ResultSet result = statement.executeQuery();
            Rekammedik rm = new Rekammedik();
            if (result.next()) {
                rm.setIdRekammedik(rekamMedik);
                rm.setDokterIdDokter(result.getString("dokter_id_dokter"));
                rm.setPasienIdPasien(result.getString("pasien_id_pasien"));
                rm.setTglRekammedik(result.getString("tgl_rekammedik"));
                rm.setKeluhanRekammedik(result.getString("keluhan_rekammedik"));
                rm.setPemeriksaanRekammedik(result.getString("pemeriksaan_rekammedik"));
                rm.setTerapiRekammedik(result.getString("terapi_rekammedik"));
                rm.setAlergiobatRekammedik(result.getString("alergiobat_rekammedik"));
                rm.setKesimpulanRekammedis(result.getString("kesimpulan_rekammedis"));
                rm.setKondisipasienkeluarRekammedis(result.getString("kondisipasienkeluar_rekammedis"));
                rm.setResepIdResep(result.getString("resep_id_resep"));
            }
            return rm;
        } catch (SQLException exception) {
            ui.act.append("getgetRekamMedik Error \n");
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
    public List<Rekammedik> getRekamMedikByPasien(String pasien) throws RemoteException {
        ui.act.append("Client Execute getRekamMedikByPasien (" + pasien + " \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM rekammedik WHERE pasien_id_pasien = ?");
            statement.setString(1, pasien);
            ResultSet result = statement.executeQuery();
            List<Rekammedik> rms = new ArrayList<Rekammedik>();
            if (result.next()) {
                Rekammedik rm = new Rekammedik();
                rm.setIdRekammedik(result.getString("id_rekammedik"));
                rm.setDokterIdDokter(result.getString("dokter_id_dokter"));
                rm.setPasienIdPasien(result.getString("pasien_id_pasien"));
                rm.setTglRekammedik(result.getString("tgl_rekammedik"));
                rm.setKeluhanRekammedik(result.getString("keluhan_rekammedik"));
                rm.setPemeriksaanRekammedik(result.getString("pemeriksaan_rekammedik"));
                rm.setTerapiRekammedik(result.getString("terapi_rekammedik"));
                rm.setAlergiobatRekammedik(result.getString("alergiobat_rekammedik"));
                rm.setKesimpulanRekammedis(result.getString("kesimpulan_rekammedis"));
                rm.setKondisipasienkeluarRekammedis(result.getString("kondisipasienkeluar_rekammedis"));
                rm.setResepIdResep(result.getString("resep_id_resep"));
                rms.add(rm);
            }
            return rms;
        } catch (SQLException exception) {
            ui.act.append("getRekamMedikByPasien Error \n");
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
    public List<Rekammedik> getRekamMedikByTahun(String tahun) throws RemoteException {
        ui.act.append("Client Execute getRekamMedikBytahun (" + tahun + " \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM rekammedik WHERE YEAR(tgl_rekammedik) = " + tahun);
            ResultSet result = statement.executeQuery();
            List<Rekammedik> rms = new ArrayList<Rekammedik>();
            if (result.next()) {
                Rekammedik rm = new Rekammedik();
                rm.setIdRekammedik(result.getString("id_rekammedik"));
                rm.setDokterIdDokter(result.getString("dokter_id_dokter"));
                rm.setPasienIdPasien(result.getString("pasien_id_pasien"));
                rm.setTglRekammedik(result.getString("tgl_rekammedik"));
                rm.setKeluhanRekammedik(result.getString("keluhan_rekammedik"));
                rm.setPemeriksaanRekammedik(result.getString("pemeriksaan_rekammedik"));
                rm.setTerapiRekammedik(result.getString("terapi_rekammedik"));
                rm.setAlergiobatRekammedik(result.getString("alergiobat_rekammedik"));
                rm.setKesimpulanRekammedis(result.getString("kesimpulan_rekammedis"));
                rm.setKondisipasienkeluarRekammedis(result.getString("kondisipasienkeluar_rekammedis"));
                rm.setResepIdResep(result.getString("resep_id_resep"));
                rms.add(rm);
            }
            return rms;
        } catch (SQLException exception) {
            ui.act.append("getRekamMedikBytahun Error \n");
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
    public List<Rekammedik> getRekamMedikByBulan(String bulan, String tahun) throws RemoteException {
        ui.act.append("Client Execute getRekamMedikByBulan (" + bulan + " | " + tahun + " \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM rekammedik WHERE YEAR(tgl_rekammedik) = " + tahun + " AND MONTH(tgl_rekammedik) = " + bulan);
            ResultSet result = statement.executeQuery();
            List<Rekammedik> rms = new ArrayList<Rekammedik>();
            if (result.next()) {
                Rekammedik rm = new Rekammedik();
                rm.setIdRekammedik(result.getString("id_rekammedik"));
                rm.setDokterIdDokter(result.getString("dokter_id_dokter"));
                rm.setPasienIdPasien(result.getString("pasien_id_pasien"));
                rm.setTglRekammedik(result.getString("tgl_rekammedik"));
                rm.setKeluhanRekammedik(result.getString("keluhan_rekammedik"));
                rm.setPemeriksaanRekammedik(result.getString("pemeriksaan_rekammedik"));
                rm.setTerapiRekammedik(result.getString("terapi_rekammedik"));
                rm.setAlergiobatRekammedik(result.getString("alergiobat_rekammedik"));
                rm.setKesimpulanRekammedis(result.getString("kesimpulan_rekammedis"));
                rm.setKondisipasienkeluarRekammedis(result.getString("kondisipasienkeluar_rekammedis"));
                rm.setResepIdResep(result.getString("resep_id_resep"));
                rms.add(rm);
            }
            return rms;
        } catch (SQLException exception) {
            ui.act.append("getRekamMedikByBulan Error \n");
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
    public List<Rekammedik> getRekamMedikByTahun(String bulan, String tahun, String pasien) throws RemoteException {
        ui.act.append("Client Execute getRekamMedikByTahun (" + bulan + " | " + tahun + " | " + pasien + " \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM rekammedik WHERE YEAR(tgl_rekammedik) = " + tahun + " AND MONTH(tgl_rekammedik) = " + bulan + " AND pasien_id_pasien = " + pasien);
            ResultSet result = statement.executeQuery();
            List<Rekammedik> rms = new ArrayList<Rekammedik>();
            if (result.next()) {
                Rekammedik rm = new Rekammedik();
                rm.setIdRekammedik(result.getString("id_rekammedik"));
                rm.setDokterIdDokter(result.getString("dokter_id_dokter"));
                rm.setPasienIdPasien(result.getString("pasien_id_pasien"));
                rm.setTglRekammedik(result.getString("tgl_rekammedik"));
                rm.setKeluhanRekammedik(result.getString("keluhan_rekammedik"));
                rm.setPemeriksaanRekammedik(result.getString("pemeriksaan_rekammedik"));
                rm.setTerapiRekammedik(result.getString("terapi_rekammedik"));
                rm.setAlergiobatRekammedik(result.getString("alergiobat_rekammedik"));
                rm.setKesimpulanRekammedis(result.getString("kesimpulan_rekammedis"));
                rm.setKondisipasienkeluarRekammedis(result.getString("kondisipasienkeluar_rekammedis"));
                rm.setResepIdResep(result.getString("resep_id_resep"));
                rms.add(rm);
            }
            return rms;
        } catch (SQLException exception) {
            ui.act.append("getRekamMedikByTahun Error \n");
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
    public List<Rekammedik> getRekamMedik() throws RemoteException {
        ui.act.append("Client Execute getRekamMedikList \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM rekammedik");
            ResultSet result = statement.executeQuery();
            List<Rekammedik> rms = new ArrayList<Rekammedik>();
            if (result.next()) {
                Rekammedik rm = new Rekammedik();
                rm.setIdRekammedik(result.getString("id_rekammedik"));
                rm.setDokterIdDokter(result.getString("dokter_id_dokter"));
                rm.setPasienIdPasien(result.getString("pasien_id_pasien"));
                rm.setTglRekammedik(result.getString("tgl_rekammedik"));
                rm.setKeluhanRekammedik(result.getString("keluhan_rekammedik"));
                rm.setPemeriksaanRekammedik(result.getString("pemeriksaan_rekammedik"));
                rm.setTerapiRekammedik(result.getString("terapi_rekammedik"));
                rm.setAlergiobatRekammedik(result.getString("alergiobat_rekammedik"));
                rm.setKesimpulanRekammedis(result.getString("kesimpulan_rekammedis"));
                rm.setKondisipasienkeluarRekammedis(result.getString("kondisipasienkeluar_rekammedis"));
                rm.setResepIdResep(result.getString("resep_id_resep"));
                rms.add(rm);
            }
            return rms;
        } catch (SQLException exception) {
            ui.act.append("getRekamMedikList Error \n");
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
    public String getlastIdRekamMedik() throws RemoteException {
        ui.act.append("Client Execute getLastIdRekamMedik");
        
        String lastIdRekamMedis = " ";
        PreparedStatement state = null;
        try {
            state = DatabaseConnection.getConnection().prepareStatement("SELECT MAX(`id_rekammedik`) FROM `rekammedik`");
            ResultSet resultSet = state.executeQuery();
            if (resultSet.next()) {
                lastIdRekamMedis = resultSet.getString(1);
            }
            return lastIdRekamMedis;
        } catch (SQLException exception) {
            ui.act.append("getLastIdRekamMedik\n");
            ui.act.append(exception.toString());
            return null;
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException exception) {
                }
            }
        }
    }
}
