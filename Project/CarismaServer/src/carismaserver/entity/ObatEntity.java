package carismaserver.entity;

import carismainterface.entity.Obat;
import carismainterface.server.ObatService;
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
public class ObatEntity extends UnicastRemoteObject implements ObatService {
    
    public Main ui;

    public ObatEntity() throws RemoteException {
    }

    public ObatEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }

    

    @Override
    public void insertObat(Obat obat) throws RemoteException {
        ui.act.append("Client Execute insertObat " + obat.getIdObat()+ "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO obat (id_obat, nama_obat, qty_obat, jenis_obat, keterangan, hargajual_obat) values (?,?,?,?,?,?)"
            );
            statement.setInt(1, obat.getIdObat());
            statement.setString(2, obat.getNamaObat());
            statement.setInt(3, obat.getQtyObat());
            statement.setString(4, obat.getJenisObat());
            statement.setString(5, obat.getKeterangan());
            statement.setInt(6, obat.getHargajualObat());
            statement.executeUpdate();
        } catch (SQLException exception) {
            ui.act.append("InsertObat Error \n");
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
    public void updateObat(Obat obat) throws RemoteException {
        ui.act.append("Client Execute updateObat(" + obat.toString() + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE obat SET nama_obat = ?, qty_obat = ?, jenis_obat = ?, keterangan = ?, hargajual_obat = ? "
                    + "WHERE id_obat = ?"
            );
            statement.setInt(6, obat.getIdObat());
            statement.setString(1, obat.getNamaObat());
            statement.setInt(2, obat.getQtyObat());
            statement.setString(3, obat.getJenisObat());
            statement.setString(4, obat.getKeterangan());
            statement.setInt(5, obat.getHargajualObat());
            statement.executeUpdate();

        } catch (SQLException e) {
            ui.act.append("UpdateObat Error \n");
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
    public void deleteObat(String idobat) throws RemoteException {
        ui.act.append("Client Execute deleteObat (" + idobat + ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM obat WHERE id_obat = ?");
            statement.setString(1, idobat);
            statement.executeUpdate();
        } catch (SQLException e) {
            ui.act.append("deleteObat Error \n");
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
    public Obat getObat(String idobat) throws RemoteException {
        ui.act.append("Client Execute getObat (" + idobat + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM obat WHERE id_obat = ?");
            statement.setString(1, idobat);
            ResultSet result = statement.executeQuery();
            Obat obat = null;
            if (result.next()) {
                obat = new Obat();
                obat.setIdObat(result.getInt("id_obat"));
                obat.setNamaObat(result.getString("nama_obat"));
                obat.setQtyObat(result.getInt("qty_obat"));
                obat.setJenisObat(result.getString("jenis_obat"));
                obat.setKeterangan(result.getString("keterangan"));
                obat.setHargajualObat(result.getInt("hargajual_obat"));
            }
            return obat;
        } catch (SQLException exception) {
            ui.act.append("getObat Error \n");
            System.out.println(exception.toString());
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
    public List<Obat> getObat() throws RemoteException {
        ui.act.append("Client Execute getObatList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM obat");

            List<Obat> list = new ArrayList<Obat>();

            while (result.next()) {
                Obat obat = new Obat();
                obat.setIdObat(result.getInt("id_obat"));
                obat.setNamaObat(result.getString("nama_obat"));
                obat.setQtyObat(result.getInt("qty_obat"));
                obat.setJenisObat(result.getString("jenis_obat"));
                obat.setKeterangan(result.getString("keterangan"));
                obat.setHargajualObat(result.getInt("hp1_obat"));
                list.add(obat);
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getObatList Error \n");
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
