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
import java.sql.Statement;
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
    public boolean insertRekamMedik(Rekammedik rekamMedik) throws RemoteException {
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
            return true;
        } catch (SQLException exception) {
            ui.act.append("InsertRekammedik Error \n");
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
    public boolean updateRekamMedik(Rekammedik rekamMedik) throws RemoteException {
        //masak rekammedik di update??
        return false;
    }

    @Override
    public boolean deleteRekamMedik(String rekamMedik) throws RemoteException {
        ui.act.append("Client Execute deleteRekamMedik (" + rekamMedik + " \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM rekammedik WHERE id_rekammedik = ?");
            statement.setString(1, rekamMedik);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("deleteRekamMedik Error \n");
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
                    "SELECT rm.`id_rekammedik`, rm.`dokter_id_dokter`, d.nama_dokter, rm.`pasien_id_pasien`, "
                    + "p.nama_pasien, rm.`tgl_rekammedik`, "
                    + "rm.`resep_id_resep` FROM rekammedik AS rm, pasien AS p, dokter AS d WHERE rm.`pasien_id_pasien` = p.id_pasien "
                    + "AND p.id_pasien = '"+pasien+"' GROUP BY rm.id_rekammedik");
            ResultSet result = statement.executeQuery();
            List<Rekammedik> rms = new ArrayList<Rekammedik>();
            while (result.next()) {
                Rekammedik rm = new Rekammedik();
                rm.setIdRekammedik(result.getString("id_rekammedik"));
                rm.setDokterIdDokter(result.getString("dokter_id_dokter"));
                rm.setPasienIdPasien(result.getString("pasien_id_pasien"));
                rm.setTglRekammedik(result.getString("tgl_rekammedik"));
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

    @Override
    public ArrayList<ArrayList> getRekamMedikDetail(String idpasien) throws RemoteException {
        ui.act.append("Client Execute getRekamMedikDetail " + idpasien + " \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT r.id_rekammedik, p.nama_pasien, p.tempatlahir_pasien, p.tgllahir_pasien, po.nama_poli, d.nama_dokter "
                    + "FROM rekammedik AS r, pasien as p, poli as po, dokter as d "
                    + "WHERE r.pasien_id_pasien = p.id_pasien AND r.dokter_id_dokter = d.id_dokter AND d.poli_id_poli = po.id_poli AND r.pasien_id_pasien = '"+idpasien+"'");

            ArrayList<ArrayList> list = new ArrayList<ArrayList>();
            ArrayList subList;

            while (result.next()) {
                subList = new ArrayList();
                subList.add(result.getString(1));
                subList.add(result.getString(2));
                subList.add(result.getString(3));
                subList.add(result.getString(4));
                subList.add(result.getString(5));
                subList.add(result.getString(6));
                list.add(subList);
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getBiayaObat Error \n");
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
