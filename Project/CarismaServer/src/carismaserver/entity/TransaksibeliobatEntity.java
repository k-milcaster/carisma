/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaserver.entity;

import carismainterface.entity.Transaksibeliobat;
import carismainterface.server.TransaksibeliobatService;
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
public class TransaksibeliobatEntity extends UnicastRemoteObject implements TransaksibeliobatService {

    public Main ui;

    public TransaksibeliobatEntity() throws RemoteException {
    }

    public TransaksibeliobatEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }
    
    
    @Override
    public void insertTransaksibelibat(Transaksibeliobat transaksibeliobat) throws RemoteException {
        ui.act.append("Client Execute insertTransaksibeliobat " + transaksibeliobat.getIdTransaksibeliobat()+ "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO transaksibeliobat (id_transaksibeliobat, date_transaksibeli, keterangan, hargabeli_obat) values (?,?,?,?)"
            );
            statement.setString(1, transaksibeliobat.getIdTransaksibeliobat());
            statement.setString(2, transaksibeliobat.getDateTransaksibeli());
            statement.setString(3, transaksibeliobat.getKeterangan());
            statement.setInt(4, transaksibeliobat.getHargabeliObat());
            statement.executeUpdate();
        } catch (SQLException exception) {
            ui.act.append("InsertTransaksibeliobat Error \n");
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
    public void updateTransaksibeliobat(Transaksibeliobat transaksibeliobat) throws RemoteException {
        ui.act.append("Client Execute updateTransaksibelibat(" + transaksibeliobat.toString() + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE transaksibeliobat SET date_transaksibeli = ?, keterangan = ?, hargabeli_obat = ? "
                    + "WHERE id_transaksibeliobat = ?"
            );
            statement.setString(4, transaksibeliobat.getIdTransaksibeliobat());
            statement.setString(1, transaksibeliobat.getDateTransaksibeli());
            statement.setString(2, transaksibeliobat.getKeterangan());
            statement.setInt(3, transaksibeliobat.getHargabeliObat());
            statement.executeUpdate();

        } catch (SQLException e) {
            ui.act.append("UpdateTransaksibelibat Error \n");
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
    public void deleteTransaksibeliobat(String idtransaksibeliobat) throws RemoteException {
        ui.act.append("Client Execute deleteTransaksibeliobat (" + idtransaksibeliobat + ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM transaksibeliobat WHERE id_transaksibeliobat = ?");
            statement.setString(1, idtransaksibeliobat);
            statement.executeUpdate();
        } catch (SQLException e) {
            ui.act.append("deleteTansaksibeliobat Error \n");
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
    public Transaksibeliobat getTransaksibeliobat(String idtransaksibeliobat) throws RemoteException {
        ui.act.append("Client Execute getTransaksibeliobat (" + idtransaksibeliobat + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM transaksibeliobat WHERE id_transaksibeliobat = ?");
            statement.setString(1, idtransaksibeliobat);
            ResultSet result = statement.executeQuery();
            Transaksibeliobat transaksibeliobat = null;
            if (result.next()) {
                transaksibeliobat = new Transaksibeliobat();
                transaksibeliobat.setIdTransaksibeliobat(result.getString("id_transaksibeliobat"));
                transaksibeliobat.setDateTransaksibeli(result.getString("date_transaksibeli"));
                transaksibeliobat.setKeterangan(result.getString("keterangan"));
                transaksibeliobat.setHargabeliObat(result.getInt("hargabeli_obat"));
            }
            return transaksibeliobat;
        } catch (SQLException exception) {
            ui.act.append("getTransaksibelibat Error \n");
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
    public List<Transaksibeliobat> getTransaksibeliobat() throws RemoteException {
        ui.act.append("Client Execute getTransaksibeliobatList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM transaksibeliobat");

            List<Transaksibeliobat> list = new ArrayList<Transaksibeliobat>();

            while (result.next()) {
                Transaksibeliobat transaksibeliobat = new Transaksibeliobat();
                transaksibeliobat.setIdTransaksibeliobat(result.getString("id_transaksibeliobat"));
                transaksibeliobat.setDateTransaksibeli(result.getString("date_transaksibeli"));
                transaksibeliobat.setKeterangan(result.getString("keterangan"));
                transaksibeliobat.setHargabeliObat(result.getInt("hargabeli_obat"));
                list.add(transaksibeliobat);
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getTransaksibeliobatList Error \n");
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
