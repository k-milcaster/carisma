package carismaserver.entity;

import carismainterface.entity.Detailresep;
import carismainterface.server.DetailresepService;
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
public class DetailresepEntity implements DetailresepService {

    public Main ui;

    public DetailresepEntity() {

    }

    public DetailresepEntity(Main ui) {
        this.ui = ui;
    }

    @Override
    public void insertDetailresep(Detailresep detailResep) throws RemoteException {
        ui.act.append("Client Execute insertDetailresep " + detailResep.getIdDetailresep() + "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO detailresep (id_detailresep, resep_id_resep, namaobat_resep, qty_resep, aturanpakai_resep) values (?,?,?,?,?)"
            );
            statement.setString(1, detailResep.getIdDetailresep());
            statement.setString(2, detailResep.getResepIdResep());
            statement.setString(3, detailResep.getNamaobatResep());
            statement.setInt(4, detailResep.getQtyResep());
            statement.setString(5, detailResep.getAturanpakaiResep());

            statement.executeUpdate();
        } catch (SQLException exception) {
            ui.act.append("InsertDetailresep Error \n");
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
        ui.act.append("Client Execute getDetailresepList  \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM detailresep WHERE resep_id_resep = " + idResep);
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
            ui.act.append("getDetaiResep Error \n");
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
