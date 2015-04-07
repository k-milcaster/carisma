package carismaserver.entity;

import carismainterface.server.ResepService;
import carismainterface.entity.Resep;
import carismaserver.boundaries.Main;
import carismaserver.controllers.DatabaseConnection;
import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author K-MiL Caster
 */
public class ResepEntity implements ResepService {

    public Main ui;

    public ResepEntity() {

    }

    public ResepEntity(Main ui) {
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
