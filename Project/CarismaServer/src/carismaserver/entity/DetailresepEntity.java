package carismaserver.entity;

import carismainterface.entity.Detailresep;
import carismainterface.server.DetailresepService;
import carismaserver.boundaries.Main;
import carismaserver.controllers.DatabaseConnection;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public class DetailresepEntity extends UnicastRemoteObject implements DetailresepService {

    public Main ui;

    public DetailresepEntity() throws RemoteException {
    }

    public DetailresepEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }

    @Override
    public boolean insertDetailresep(Detailresep detailResep) throws RemoteException {
        ui.act.append("Client Execute insertDetailresep " + detailResep.getIdDetailresep() + "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO detailresep (id_detailresep, resep_id_resep, namaobat_resep, qty_resep, aturanpakai_resep) values (?,?,?,?,?)");
            statement.setString(1, detailResep.getIdDetailresep());
            statement.setString(2, detailResep.getResepIdResep());
            statement.setString(3, detailResep.getNamaobatResep());
            statement.setInt(4, detailResep.getQtyResep());
            statement.setString(5, detailResep.getAturanpakaiResep());
            statement.executeUpdate();
            return true;
        } catch (SQLException exception) {
            ui.act.append("InsertDetailresep Error \n");
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
    public List<Detailresep> getDetailresep(String idResep) throws RemoteException {
        ui.act.append("Client Execute getResepObat  \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT dr.`namaobat_resep` "
                    + "FROM resep AS r, detailresep AS dr "
                    + "WHERE dr.`resep_id_resep` = r.id_resep AND r.id_resep = '" + idResep + "'");
            ResultSet result = statement.executeQuery();
            List<Detailresep> list = new ArrayList<Detailresep>();
            Detailresep dR = null;
            while (result.next()) {
                dR = new Detailresep();
                dR.setNamaobatResep(result.getString("namaobat_resep"));
                list.add(dR);
            }
            return list;
        } catch (SQLException exception) {
            ui.act.append("getResepObat Error \n");
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
    public List<Detailresep> getDetailresepByPasien(String idPasien) throws RemoteException {
        ui.act.append("Client Execute getDetailresepByPasien \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT d.id_detailresep, d.resep_id_resep, d.namaobat_resep, d.qty_resep, d.aturanpakai_resep "
                    + "FROM detailresep d, resep r, rekammedik m, pasien p "
                    + "WHERE r.id_resep = d.resep_id_resep AND r.id_resep = m.resep_id_resep AND m.pasien_id_pasien = p.id_pasien AND p.id_pasien = " + idPasien);
            ResultSet result = statement.executeQuery();
            List<Detailresep> list = new ArrayList<Detailresep>();
            Detailresep dR = null;
            if (result.next()) {
                dR = new Detailresep();
                dR.setIdDetailresep(result.getString("id_detailresep"));
                dR.setResepIdResep(result.getString("resep_id_resep"));
                dR.setNamaobatResep(result.getString("namaobat_resep"));
                dR.setQtyResep(result.getInt("qty_resep"));
                dR.setAturanpakaiResep(result.getString("aturanpakai_resep"));
                list.add(dR);
            }
            return list;
        } catch (SQLException exception) {
            ui.act.append("getDetailresepByPasien \n");
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
    public String getLastIdDetailResep() throws RemoteException {
        ui.act.append("Client Execute getLastIdDetailResep");
        String idDetailResep = " ";
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement("SELECT MAX(`id_detailresep`) FROM `detailresep`");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                idDetailResep = resultSet.getString(1);
            }
            return idDetailResep;
        } catch (SQLException exception) {
            ui.act.append("getLastIdDetailResep Error\n");
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
    public boolean deleteDetailResep(String idDetailResep) throws RemoteException {
        ui.act.append("Client Execute deleteDetailResep (" + idDetailResep + " \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM detailresep WHERE id_detailresep = ?");
            statement.setString(1, idDetailResep);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("deleteDetailResep Error \n");
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
    public List<Detailresep> getNamaObatQtyByIdKunjungan(String idKunjungan) throws RemoteException {
        ui.act.append("Client Execute getNamaObatQtyByIdKunjungan\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT dr.`namaobat_resep`, dr.`qty_resep` FROM rekammedik AS rm, resep AS r, detailresep AS dr, kunjungan AS k "
                    + "WHERE r.id_resep = dr.`resep_id_resep` AND r.id_resep = rm.`resep_id_resep` AND rm.id_rekammedik = k.rekammedik_id_rekammedik AND k.id_kunjungan = '"+idKunjungan+"'");
            ResultSet result = statement.executeQuery();
            List<Detailresep> list = new ArrayList<Detailresep>();
            Detailresep dR = null;
            if (result.next()) {
                dR = new Detailresep();
                dR.setNamaobatResep(result.getString("namaobat_resep"));
                dR.setQtyResep(result.getInt("qty_resep"));
                list.add(dR);
            }
            return list;
        } catch (SQLException exception) {
            ui.act.append("getNamaObatQtyByIdKunjungan\n");
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
