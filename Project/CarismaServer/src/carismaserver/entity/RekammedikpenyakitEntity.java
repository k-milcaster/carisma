package carismaserver.entity;

import carismainterface.entity.Kunjungan;
import carismainterface.server.RekammedikpenyakitService;
import carismainterface.entity.Rekammedikpenyakit;
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
public class RekammedikpenyakitEntity implements RekammedikpenyakitService {

    public Main ui;

    public RekammedikpenyakitEntity() {

    }

    public RekammedikpenyakitEntity(Main ui) {
        this.ui = ui;
    }

    @Override
    public void insertRekamMedikPenyakit(Rekammedikpenyakit rp) throws RemoteException {
        ui.act.append("Client Execute insertRekammedikPenyakit " + rp.getRekammedikIdRekammedik() + " \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO rekammedis_penyakit (rekammedik_id_rekammedik, penyakit_id_penyakit) values (?,?)"
            );
            statement.setString(1, rp.getRekammedikIdRekammedik());
            statement.setString(2, rp.getPenyakitIdPenyakit());
            statement.executeUpdate();
        } catch (SQLException exception) {
            ui.act.append("InsertRekammedikPenyakit Error \n");
            exception.printStackTrace();
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
    public List<Rekammedikpenyakit> getRekamMedikPenyakit(String idRm) throws RemoteException {
        ui.act.append("Client Execute getRekamMedikPenyakit + " + idRm + " \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM rekammedis_penyakit WHERE rekammedik_id_rekammedik = " + idRm);
            ResultSet result = statement.executeQuery();
            List<Rekammedikpenyakit> list = new ArrayList<Rekammedikpenyakit>();
            Rekammedikpenyakit rmP = null;
            if (result.next()) {
                rmP = new Rekammedikpenyakit();
                rmP.setRekammedikIdRekammedik(result.getString("rekammedik_id_rekammedik"));
                rmP.setPenyakitIdPenyakit(result.getString("penyakit_id_penyakit"));
                list.add(rmP);
            }
            return list;
        } catch (SQLException exception) {
            ui.act.append("getRekamMedikPenyakit Error \n");
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
    public void deleteRekammedikPenyakit(String idRm) throws RemoteException {
        ui.act.append("Client Execute deleteRekamMedikPenyakit (" + idRm + " \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM rekammedis_penyakit WHERE rekammedik_id_rekammedik = ?");
            statement.setString(1, idRm);
            statement.executeUpdate();
        } catch (SQLException e) {
            ui.act.append("deleteRekamMedikPenyakit Error \n");
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
