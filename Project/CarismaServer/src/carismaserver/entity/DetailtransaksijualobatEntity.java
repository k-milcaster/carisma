/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaserver.entity;

import carismainterface.entity.Detailtransaksijualobat;
import carismainterface.entity.Detailtransaksijualobat;
import carismainterface.server.DetailtransaksijualobatService;
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
public class DetailtransaksijualobatEntity extends UnicastRemoteObject implements DetailtransaksijualobatService {

    public Main ui;

    public DetailtransaksijualobatEntity() throws RemoteException {
    }

    public DetailtransaksijualobatEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }
    
    @Override
    public boolean insertDetailtransaksijualobat(Detailtransaksijualobat detailtransaksijualobat) throws RemoteException {
        ui.act.append("Client Execute insertDetailtransaksijualobat " + detailtransaksijualobat.getTransaksijualobat()+" "+ detailtransaksijualobat.getObat()+ "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO detailtransaksijualobat (transaksijualobat_id_transaksijual, obat_id_obat, qty) values (?,?,?)"
            );
            statement.setString(1, detailtransaksijualobat.getTransaksijualobat());
            statement.setInt(2, detailtransaksijualobat.getObat());
            statement.setInt(3, detailtransaksijualobat.getQty());
            statement.executeUpdate();
            return true;
        } catch (SQLException exception) {
            ui.act.append("InsertDetailtransaksijualobat Error \n");
            ui.act.append(exception.toString());
            exception.printStackTrace();
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
    public boolean updateDetailtransaksijualobat(Detailtransaksijualobat detailtransaksijualobat) throws RemoteException {
        ui.act.append("Client Execute updateDetailtransaksijualobat(" + detailtransaksijualobat.toString() + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE detailtransaksijualobat SET qty = ? "
                    + "WHERE transaksijualobat_id_transaksijual = ? AND obat_id_obat = ?"
            );
            statement.setString(2, detailtransaksijualobat.getTransaksijualobat());
            statement.setInt(3, detailtransaksijualobat.getObat());
            statement.setInt(1, detailtransaksijualobat.getQty());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("UpdateDetailtransaksijualobat Error \n");
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
    public boolean deleteDetailtransaksijualobat(String idtransaksijualobat, int idobat) throws RemoteException {
        ui.act.append("Client Execute deleteDetailtransaksijualobat (" + idtransaksijualobat + " " + idobat + ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM detailtransaksijualobat WHERE transaksijualobat_id_transaksijual = ? AND obat_id_obat =?");
            statement.setString(1, idtransaksijualobat);
            statement.setInt(2, idobat);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("deleteDetailtransaksijualobat Error \n");
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
    public Detailtransaksijualobat getDetailtransaksijualobat(String idtransaksijualobat, int idobat) throws RemoteException {
        ui.act.append("Client Execute getDetailtransaksijualobat (" + idtransaksijualobat + " " + idobat + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM detailtransaksijualobat WHERE transaksijualobat_id_transaksijual = ? AND obat_id_obat = ?");
            statement.setString(1, idtransaksijualobat);
            statement.setInt(2, idobat);
            ResultSet result = statement.executeQuery();
            Detailtransaksijualobat detailtransaksijualobat = null;
            if (result.next()) {
                detailtransaksijualobat = new Detailtransaksijualobat();
                detailtransaksijualobat.setTransaksijualobat(result.getString("transaksijualobat_transaksijual"));
                detailtransaksijualobat.setObat(result.getInt("obat_id_obat"));
                detailtransaksijualobat.setQty(result.getInt("qty"));
            }
            return detailtransaksijualobat;
        } catch (SQLException exception) {
            ui.act.append("getDetailtransaksijualobat Error \n");
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
    public List<Detailtransaksijualobat> getDetailtransaksijualobat() throws RemoteException {
        ui.act.append("Client Execute getDetailtransaksijualobatList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM detailtransaksijualobat");

            List<Detailtransaksijualobat> list = new ArrayList<Detailtransaksijualobat>();

            while (result.next()) {
                Detailtransaksijualobat detailtransaksijualobat = new Detailtransaksijualobat();
                detailtransaksijualobat.setTransaksijualobat(result.getString("transaksijualobat_id_transaksijual"));
                detailtransaksijualobat.setObat(result.getInt("obat_id_obat"));
                detailtransaksijualobat.setQty(result.getInt("qty"));
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getDetailtransaksijualobatList Error \n");
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
