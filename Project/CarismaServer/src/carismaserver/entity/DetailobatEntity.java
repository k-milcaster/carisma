package carismaserver.entity;

import carismainterface.entity.Detailobat;
import carismainterface.server.DetailobatService;
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
public class DetailobatEntity extends UnicastRemoteObject implements DetailobatService {
    
    public Main ui;

    public DetailobatEntity() throws RemoteException {
    }

    public DetailobatEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }

    @Override
    public boolean insertDetailobat(Detailobat detailobat) throws RemoteException {
        ui.act.append("Client Execute insertDetailobat " + detailobat.getIdDetail()+ "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO detailobat (id_detail, obat_id_obat, tglkadaluarsa_detail) values (?,?,?)"
            );
            statement.setInt(1, detailobat.getIdDetail());
            statement.setInt(2, detailobat.getObatIdObat());
            statement.setString(3, detailobat.getTglkadaluarsaDetail());
            statement.executeUpdate();
            return true;
        } catch (SQLException exception) {
            ui.act.append("InsertDetailobat Error \n");
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
    public boolean updateDetailobat(Detailobat detailobat) throws RemoteException {
        ui.act.append("Client Execute updateDetailobat(" + detailobat.toString() + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE obat SET obat_id_obat = ?, tglkadaluarsa_detail = ? "
                    + "WHERE id_detail = ?"
            );
            statement.setInt(6, detailobat.getIdDetail());
            statement.setInt(1, detailobat.getObatIdObat());
            statement.setString(2, detailobat.getTglkadaluarsaDetail());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("UpdateDetailobat Error \n");
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
    public boolean deleteDetailobat(int iddetailobat) throws RemoteException {
        ui.act.append("Client Execute deleteDetailobat (" + iddetailobat + ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM detailobat WHERE id_detail = ?");
            statement.setInt(1, iddetailobat);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("deleteDetailobat Error \n");
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
    public Detailobat getDetailobat(int iddetailobat) throws RemoteException {
        ui.act.append("Client Execute getDetailobat (" + iddetailobat + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM detailobat WHERE id_detail = ?");
            statement.setInt(1, iddetailobat);
            ResultSet result = statement.executeQuery();
            Detailobat detailobat = null;
            if (result.next()) {
                detailobat = new Detailobat();
                detailobat.setIdDetail(result.getInt("id_detail"));
                detailobat.setObatIdObat(result.getInt("obat_id_obat"));
                detailobat.setTglkadaluarsaDetail(result.getString("tglkadaluarsa_detail"));
            }
            return detailobat;
        } catch (SQLException exception) {
            ui.act.append("getDetailobat Error \n");
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
    public List<Detailobat> getDetailobat() throws RemoteException {
        ui.act.append("Client Execute getDetailobatList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM detailobat");

            List<Detailobat> list = new ArrayList<Detailobat>();

            while (result.next()) {
                Detailobat obat = new Detailobat();
                obat.setIdDetail(result.getInt("id_detail"));
                obat.setObatIdObat(result.getInt("obat_id_obat"));
                obat.setTglkadaluarsaDetail(result.getString("tglkadaluarsa_detail"));
                list.add(obat);
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getDetailobatList Error \n");
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
    public List<Detailobat> getDetailobatbyIdObat(int idobat) throws RemoteException {
        ui.act.append("Client Execute getDetailobatbyIdObat (" + idobat + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM detailobat WHERE obat_id_obat = ?");
            statement.setInt(1, idobat);
            ResultSet result = statement.executeQuery();
            List<Detailobat> list = new ArrayList<Detailobat>();
            while (result.next()) {
                Detailobat detailobat = new Detailobat();
                detailobat.setIdDetail(result.getInt("id_detail"));
                detailobat.setObatIdObat(result.getInt("obat_id_obat"));
                detailobat.setTglkadaluarsaDetail(result.getString("tglkadaluarsa_detail"));
                list.add(detailobat);
            }
            return list;
        } catch (SQLException exception) {
            ui.act.append("getDetailobat Error \n");
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
    public int getLastIdDetailObat() throws RemoteException {
        ui.act.append("Client Execute getLastIdDetailObat");
        
        int lastIdDetailObat = 0;
        PreparedStatement state = null;
        try {
            state = DatabaseConnection.getConnection().prepareStatement("SELECT MAX(`id_detail`) FROM detailobat");
            ResultSet resultSet = state.executeQuery();
            if (resultSet.next()) {
                lastIdDetailObat = resultSet.getInt(1);
            }
            return lastIdDetailObat;
        } catch (SQLException exception) {
            ui.act.append("getLastIdDetailObat\n");
            ui.act.append(exception.toString());
            return lastIdDetailObat;
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
