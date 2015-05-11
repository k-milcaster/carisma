/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaserver.entity;

import carismainterface.entity.Transaksijualobat;
import carismainterface.server.TransaksijualobatService;
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
public class TransaksijualobatEntity extends UnicastRemoteObject implements TransaksijualobatService{
    
    public Main ui;

    public TransaksijualobatEntity() throws RemoteException {
    }

    public TransaksijualobatEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }

    @Override
    public boolean insertTransaksijualobat(Transaksijualobat transaksijualobat) throws RemoteException {
        ui.act.append("Client Execute insertTransaksijualobat " + transaksijualobat.getIdTransaksijual()+ "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO transaksijualobat (id_transaksijual, date_transaksijual, keterangan) values (?,?,?)"
            );
            statement.setString(1, transaksijualobat.getIdTransaksijual());
            statement.setString(2, transaksijualobat.getDateTransaksijual());
            statement.setString(3, transaksijualobat.getKeterangan());
            statement.executeUpdate();
            return true;
        } catch (SQLException exception) {
            ui.act.append("InsertTransaksijualobat Error \n");
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
    public boolean updateTransaksijualobat(Transaksijualobat transaksijualobat) throws RemoteException {
        ui.act.append("Client Execute updateTransaksijualbat(" + transaksijualobat.toString() + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE transaksijualobat SET date_transaksijual = ?, keterangan = ? "
                    + "WHERE id_transaksijual = ?"
            );
            statement.setString(4, transaksijualobat.getIdTransaksijual());
            statement.setString(1, transaksijualobat.getDateTransaksijual());
            statement.setString(2, transaksijualobat.getKeterangan());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("UpdateTransaksijualbat Error \n");
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
    public boolean deleteTransaksijualobat(String idtransaksijualobat) throws RemoteException {
        ui.act.append("Client Execute deleteTransaksijualobat (" + idtransaksijualobat + ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM transaksijualobat WHERE id_transaksijual = ?");
            statement.setString(1, idtransaksijualobat);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("deleteTansaksijualobat Error \n");
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
    public Transaksijualobat getTransaksijualobat(String idtransaksijualobat) throws RemoteException {
        ui.act.append("Client Execute getTransaksijualobat (" + idtransaksijualobat + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM transaksijualobat WHERE id_transaksijual = ?");
            statement.setString(1, idtransaksijualobat);
            ResultSet result = statement.executeQuery();
            Transaksijualobat transaksijualobat = null;
            if (result.next()) {
                transaksijualobat = new Transaksijualobat();
                transaksijualobat.setIdTransaksijual(result.getString("id_transaksijualobat"));
                transaksijualobat.setDateTransaksijual(result.getString("date_transaksijual"));
                transaksijualobat.setKeterangan(result.getString("keterangan"));
            }
            return transaksijualobat;
        } catch (SQLException exception) {
            ui.act.append("getTransaksijualbat Error \n");
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
    public List<Transaksijualobat> getTransaksijualobat() throws RemoteException {
        ui.act.append("Client Execute getTransaksijualobatList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM transaksijualobat");

            List<Transaksijualobat> list = new ArrayList<Transaksijualobat>();

            while (result.next()) {
                Transaksijualobat transaksijualobat = new Transaksijualobat();
                transaksijualobat.setIdTransaksijual(result.getString("id_transaksijua"));
                transaksijualobat.setDateTransaksijual(result.getString("date_transaksijual"));
                transaksijualobat.setKeterangan(result.getString("keterangan"));
                list.add(transaksijualobat);
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getTransaksijualobatList Error \n");
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
