/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaserver.entity;

import carismainterface.entity.Poli;
import carismainterface.server.PoliService;
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
public class PoliEntity extends UnicastRemoteObject implements PoliService{
    public Main ui;

    public PoliEntity() throws RemoteException {
    }

    public PoliEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }

    @Override
    public void insertPoli(Poli poli) throws RemoteException {
        ui.act.append("Client Execute insertPoli " + poli.getIdPoli()+ "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO poli (id_poli, nama_poli, keterangan) values (?,?,?)"
            );
            statement.setString(1, poli.getIdPoli());
            statement.setString(2, poli.getNamaPoli());
            statement.setString(3, poli.getKeterangan());
            statement.executeUpdate();
        } catch (SQLException exception) {
            ui.act.append("InsertPoli Error \n");
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
    public void updatePoli(Poli poli) throws RemoteException {
        ui.act.append("Client Execute updatePoli(" + poli.toString() + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE poli SET nama_poli = ?, keterangan = ? "
                    + "WHERE id_poli = ?"
            );
            statement.setString(3, poli.getIdPoli());
            statement.setString(1, poli.getNamaPoli());
            statement.setString(2, poli.getKeterangan());
            statement.executeUpdate();

        } catch (SQLException e) {
            ui.act.append("UpdatePoli Error \n");
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
    public void deletePoli(String idpoli) throws RemoteException {
        ui.act.append("Client Execute deletePoli (" + idpoli + ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM poli WHERE id_poli = ?");
            statement.setString(1, idpoli);
            statement.executeUpdate();
        } catch (SQLException e) {
            ui.act.append("deletePoli Error \n");
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
    public Poli getPoli(String idpoli) throws RemoteException {
        ui.act.append("Client Execute getPoli (" + idpoli + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM `poli` WHERE id_poli = ?");
            statement.setString(1, idpoli);
            ResultSet result = statement.executeQuery();
            Poli poli = null;
            if (result.next()) {
                poli = new Poli();
                poli.setIdPoli(result.getString("id_poli"));
                poli.setNamaPoli(result.getString("nama_poli"));
                poli.setKeterangan(result.getString("keterangan"));
            }
            return poli;
        } catch (SQLException exception) {
            ui.act.append("getPoli Error \n");
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
    public List<Poli> getPoli() throws RemoteException {
        ui.act.append("Client Execute getPoliList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM `poli`");

            List<Poli> list = new ArrayList<Poli>();

            while (result.next()) {
                Poli poli = new Poli();
                poli.setIdPoli(result.getString("id_poli"));
                poli.setNamaPoli(result.getString("nama_poli"));
                poli.setKeterangan(result.getString("keterangan"));
                list.add(poli);
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getPoliList Error \n");
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
