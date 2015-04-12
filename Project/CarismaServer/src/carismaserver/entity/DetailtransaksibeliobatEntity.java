/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaserver.entity;

import carismainterface.entity.Detailtransaksibeliobat;
import carismainterface.server.DetailtransaksibeliobatService;
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
public class DetailtransaksibeliobatEntity extends UnicastRemoteObject implements DetailtransaksibeliobatService {
    
    public Main ui;

    public DetailtransaksibeliobatEntity() throws RemoteException {
    }

    public DetailtransaksibeliobatEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }

    @Override
    public void insertDetailtransaksibeliobat(Detailtransaksibeliobat detailtransaksibeliobat) throws RemoteException {
        ui.act.append("Client Execute insertDetailtransaksibeliobat " + detailtransaksibeliobat.getTransaksibeliobat()+" "+ detailtransaksibeliobat.getObat()+ "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO detailtransaksibeliobat (transaksibeliobat_id_transaksibeliobat, obat_id_obat, qty) values (?,?,?)"
            );
            statement.setString(1, detailtransaksibeliobat.getTransaksibeliobat());
            statement.setInt(2, detailtransaksibeliobat.getObat());
            statement.setInt(3, detailtransaksibeliobat.getQty());
            statement.executeUpdate();
        } catch (SQLException exception) {
            ui.act.append("InsertDetailtransaksibeliobat Error \n");
            ui.act.append(exception.toString());
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
    public void updateDetailtransaksibeliobat(Detailtransaksibeliobat detailtransaksibeliobat) throws RemoteException {
        ui.act.append("Client Execute updateDetailtransaksibeliobat(" + detailtransaksibeliobat.toString() + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE detailtransaksibeliobat SET qty = ? "
                    + "WHERE transaksibeliobat_id_transaksibeliobat = ? AND obat_id_obat = ?"
            );
            statement.setString(2, detailtransaksibeliobat.getTransaksibeliobat());
            statement.setInt(3, detailtransaksibeliobat.getObat());
            statement.setInt(1, detailtransaksibeliobat.getQty());
            statement.executeUpdate();

        } catch (SQLException e) {
            ui.act.append("UpdateDetailtransaksibeliobat Error \n");
            ui.act.append(e.toString());
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
    public void deleteDetailtransaksibeliobat(String idtransaksibeliobat, int idobat) throws RemoteException {
        ui.act.append("Client Execute deleteDetailtransaksibeliobat (" + idtransaksibeliobat + " " + idobat + ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM detailtransaksibeliobat WHERE transaksibeliobat_id_transaksibeliobat = ? AND obat_id_obat =?");
            statement.setString(1, idtransaksibeliobat);
            statement.setInt(2, idobat);
            statement.executeUpdate();
        } catch (SQLException e) {
            ui.act.append("deleteDetailtransaksibeliobat Error \n");
            ui.act.append(e.toString());
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
    public Detailtransaksibeliobat getDetailtransaksibeliobat(String idtransaksibeliobat, int idobat) throws RemoteException {
        ui.act.append("Client Execute getDetailtransaksibeliobat (" + idtransaksibeliobat + " " + idobat + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM detailtransaksibeliobat WHERE transaksibeliobat_id_transaksibeliobat = ? AND obat_id_obat = ?");
            statement.setString(1, idtransaksibeliobat);
            statement.setInt(2, idobat);
            ResultSet result = statement.executeQuery();
            Detailtransaksibeliobat detailtransaksibeliobat = null;
            if (result.next()) {
                detailtransaksibeliobat = new Detailtransaksibeliobat();
                detailtransaksibeliobat.setTransaksibeliobat(result.getString("transaksibeliobat_transaksibeliobat"));
                detailtransaksibeliobat.setObat(result.getInt("obat_id_obat"));
                detailtransaksibeliobat.setQty(result.getInt("qty"));
            }
            return detailtransaksibeliobat;
        } catch (SQLException exception) {
            ui.act.append("getDetailtransaksibeliobat Error \n");
            ui.act.append(exception.toString());
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
    public List<Detailtransaksibeliobat> getDetailtransaksibeliobat() throws RemoteException {
        ui.act.append("Client Execute getDetailtransaksibeliobatList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM detailtransaksibeliobat");

            List<Detailtransaksibeliobat> list = new ArrayList<Detailtransaksibeliobat>();

            while (result.next()) {
                Detailtransaksibeliobat detailtransaksibeliobat = new Detailtransaksibeliobat();
                detailtransaksibeliobat.setTransaksibeliobat(result.getString("transaksibeliobat_id_transaksibeliobat"));
                detailtransaksibeliobat.setObat(result.getInt("obat_id_obat"));
                detailtransaksibeliobat.setQty(result.getInt("qty"));
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getDetailtransaksibeliobatList Error \n");
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
