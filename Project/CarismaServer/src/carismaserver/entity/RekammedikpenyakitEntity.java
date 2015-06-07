package carismaserver.entity;

import carismainterface.entity.Kunjungan;
import carismainterface.entity.Rekammedik;
import carismainterface.server.RekammedikpenyakitService;
import carismainterface.entity.Rekammedikpenyakit;
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
public class RekammedikpenyakitEntity extends UnicastRemoteObject implements RekammedikpenyakitService {

    public Main ui;

    public RekammedikpenyakitEntity() throws RemoteException {

    }

    public RekammedikpenyakitEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }

    @Override
    public boolean insertRekamMedikPenyakit(Rekammedikpenyakit rp) throws RemoteException {
        ui.act.append("Client Execute insertRekammedikPenyakit " + rp.getRekammedikIdRekammedik() + " \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO rekammedis_penyakit (rekammedik_id_rekammedik, penyakit_id_penyakit) values (?,?)"
            );
            statement.setString(1, rp.getRekammedikIdRekammedik());
            statement.setString(2, rp.getPenyakitIdPenyakit());
            statement.executeUpdate();
            return true;
        } catch (SQLException exception) {
            ui.act.append("InsertRekammedikPenyakit Error \n");
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
    public List<Rekammedikpenyakit> getPenyakitPasien(String idRm) throws RemoteException {
        ui.act.append("Client Execute getPenyakitPasien + " + idRm + " \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT rm.`penyakit_id_penyakit` FROM `rekammedis_penyakit` AS rm, penyakit AS p "
                    + "WHERE rm.`penyakit_id_penyakit` = p.id_penyakit AND rm.`rekammedik_id_rekammedik` = '"+idRm+"'");
            ResultSet result = statement.executeQuery();
            List<Rekammedikpenyakit> list = new ArrayList<Rekammedikpenyakit>();
            Rekammedikpenyakit rmP = null;
            if (result.next()) {
                rmP = new Rekammedikpenyakit();
                rmP.setPenyakitIdPenyakit(result.getString("penyakit_id_penyakit"));
                list.add(rmP);
            }
            return list;
        } catch (SQLException exception) {
            ui.act.append("getPenyakitPasien Error \n");
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
    public boolean deleteRekammedikPenyakit(String idRm) throws RemoteException {
        ui.act.append("Client Execute deleteRekamMedikPenyakit (" + idRm + " \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM rekammedis_penyakit WHERE rekammedik_id_rekammedik = ?");
            statement.setString(1, idRm);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("deleteRekamMedikPenyakit Error \n");
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

}
