package carismaserver.entity;

import carismainterface.entity.Jadwaldokter;
import carismainterface.server.JadwaldokterService;
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
 * @author kepoterz
 */
public class JadwaldokterEntity extends UnicastRemoteObject implements JadwaldokterService{

    public Main ui;

    public JadwaldokterEntity() throws RemoteException {
    }

    public JadwaldokterEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }
    
    @Override
    public boolean insertJadwaldokter(Jadwaldokter jadwaldokter) throws RemoteException {
        ui.act.append("Client Execute insertJadwaldokter " + jadwaldokter.getId()+ "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO jadwaldokter (id, dokter_id_dokter, jadwal_id) values (?,?,?)"
            );
            statement.setInt(1, jadwaldokter.getId());
            statement.setString(2, jadwaldokter.getDokterIdDokter());
            statement.setInt(3, jadwaldokter.getJadwalId());
            statement.executeUpdate();
            return true;
        } catch (SQLException exception) {
            ui.act.append("InsertJadwaldokter Error \n");
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
    public boolean updateJadwaldokter(Jadwaldokter jadwaldokter) throws RemoteException {
        ui.act.append("Client Execute updateJadwaldokter(" + jadwaldokter.toString() + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE jadwaldokter SET dokter_id_dokter = ?, jadwal_id = ? "
                    + "WHERE id = ?"
            );
            statement.setInt(3, jadwaldokter.getId());
            statement.setString(1, jadwaldokter.getDokterIdDokter());
            statement.setInt(2, jadwaldokter.getJadwalId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("UpdateJadwaldokter Error \n");
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
    public boolean deleteJadwaldokter(String idjadwaldokter) throws RemoteException {
        ui.act.append("Client Execute deleteJadwaldokter (" + idjadwaldokter + ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM jadwaldokter WHERE id = ?");
            statement.setString(1, idjadwaldokter);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("deleteJadwaldokter Error \n");
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
    public List<Jadwaldokter> getJadwaldokter(String idjadwaldokter) throws RemoteException {
        ui.act.append("Client Execute getJadwaldokter (" + idjadwaldokter + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM jadwaldokter WHERE dokter_id_dokter = ?");
            statement.setString(1, idjadwaldokter);
            ResultSet result = statement.executeQuery();
            List<Jadwaldokter> list = new ArrayList<Jadwaldokter>();
            Jadwaldokter jadwaldokter = null;
            while (result.next()) {
                jadwaldokter = new Jadwaldokter();
                jadwaldokter.setId(result.getInt("id"));
                jadwaldokter.setDokterIdDokter(result.getString("dokter_id_dokter"));
                jadwaldokter.setJadwalId(result.getInt("jadwal_id"));
                list.add(jadwaldokter);
            }
            return list;
        } catch (SQLException exception) {
            ui.act.append("getJadwaldokter Error \n");
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
    public List<Jadwaldokter> getJadwaldokter() throws RemoteException {
        ui.act.append("Client Execute getJadwaldokterList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM jadwaldokter");

            List<Jadwaldokter> list = new ArrayList<Jadwaldokter>();

            while (result.next()) {
                Jadwaldokter jadwaldokter = new Jadwaldokter();
                jadwaldokter.setId(result.getInt("id"));
                jadwaldokter.setDokterIdDokter(result.getString("dokter_id_dokter"));
                jadwaldokter.setJadwalId(result.getInt("jadwal_id"));
                list.add(jadwaldokter);
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getJadwaldokterList Error \n");
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
