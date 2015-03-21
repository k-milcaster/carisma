/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaserver.entity;

import carismainterface.entity.Rakobat;
import carismainterface.server.RakobatService;
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
public class RakobatEntity extends UnicastRemoteObject implements RakobatService {

    public Main ui;

    public RakobatEntity() throws RemoteException {
    }

    public RakobatEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }
    
    
    @Override
    public void insertRakobat(Rakobat rakobat) throws RemoteException {
        ui.act.append("Client Execute insertRakobat " + rakobat.getIdRak()+ "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO rakobat (id_rakobat, obat_id_obat, nama_rak) values (?,?,?)"
            );
            statement.setInt(1, rakobat.getIdRak());
            statement.setInt(2, rakobat.getObatIdObat());
            statement.setString(3, rakobat.getNamaRak());
            statement.executeUpdate();
        } catch (SQLException exception) {
            ui.act.append("InsertRakobat Error \n");
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
    public void updateRakobat(Rakobat rakobat) throws RemoteException {
        ui.act.append("Client Execute updateRakobat(" + rakobat.toString() + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE rakobat SET obat_id_obat = ?, nama_rak = ? "
                    + "WHERE id_rak = ?"
            );
            statement.setInt(3, rakobat.getIdRak());
            statement.setInt(1, rakobat.getObatIdObat());
            statement.setString(2, rakobat.getNamaRak());
            statement.executeUpdate();

        } catch (SQLException e) {
            ui.act.append("UpdateRakobat Error \n");
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
    public void deleteRakobat(int idrakobat) throws RemoteException {
        ui.act.append("Client Execute deleteRakobat (" + idrakobat + ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM rakobat WHERE id_rak = ?");
            statement.setInt(1, idrakobat);
            statement.executeUpdate();
        } catch (SQLException e) {
            ui.act.append("deleteRakobat Error \n");
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
    public Rakobat getRakobat(int idrakobat) throws RemoteException {
        ui.act.append("Client Execute getRakobat (" + idrakobat + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM rakobat WHERE id_rak = ?");
            statement.setInt(1, idrakobat);
            ResultSet result = statement.executeQuery();
            Rakobat rakobat = null;
            if (result.next()) {
                rakobat = new Rakobat();
                rakobat.setIdRak(result.getInt("id_rak"));
                rakobat.setObatIdObat(result.getInt("obat_id_obat"));
                rakobat.setNamaRak(result.getString("qty_rakobat"));
            }
            return rakobat;
        } catch (SQLException exception) {
            ui.act.append("getRakobat Error \n");
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
    public List<Rakobat> getRakobat() throws RemoteException {
        ui.act.append("Client Execute getRakobatList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM rakobat");

            List<Rakobat> list = new ArrayList<Rakobat>();

            while (result.next()) {
                Rakobat rakobat = new Rakobat();
                rakobat.setIdRak(result.getInt("id_rak"));
                rakobat.setObatIdObat(result.getInt("obat_id_obat"));
                rakobat.setNamaRak(result.getString("nama_rak"));;
                list.add(rakobat);
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getRakobatList Error \n");
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
