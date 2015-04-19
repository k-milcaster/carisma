package carismaserver.entity;

import carismainterface.entity.Resep;
import carismainterface.server.ResepService;
import carismaserver.boundaries.Main;
import carismaserver.controllers.DatabaseConnection;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author K-MiL Caster
 */
public class ResepEntity extends UnicastRemoteObject implements ResepService {

    public Main ui;

    public ResepEntity() throws RemoteException {

    }

    public ResepEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }

    @Override
    public void insertResep(Resep resep) throws RemoteException {
        ui.act.append("Client Execute insertResep " + resep.getIdResep() + "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO resep (id_resep, keterangan) values (?,?)"
            );
            statement.setString(1, resep.getIdResep());
            statement.setString(2, resep.getKeterangan());
            statement.executeUpdate();
        } catch (SQLException exception) {
            ui.act.append("InsertResep Error \n");
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
    public String getLastIdResep() throws RemoteException {
         ui.act.append("Client Execute getLastIdResep");
        String idResep = " ";
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement("SELECT MAX(`id_detailresep`) FROM `detailresep`");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                idResep = resultSet.getString(1);
            }
            return idResep;
        } catch (SQLException exception) {
            ui.act.append("getLastIdResep Error\n");
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
