/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaserver.entity;

import carismainterface.entity.Absensidokter;
import carismainterface.server.AbsensidokterService;
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
public class AbsensidokterEntity extends UnicastRemoteObject implements AbsensidokterService{
    
    public Main ui;

    public AbsensidokterEntity() throws RemoteException {
    }

    public AbsensidokterEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }

    @Override
    public void insertAbsensidokter(Absensidokter absensidokter) throws RemoteException {
        ui.act.append("Client Execute insertAbsensidokter " + absensidokter.getDokterIdDokter()+ "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO absensidokter (dokter_id_dokter, kehadiranreguler_dokter, kehadiranlembur_dokter, date_absensidokter) values (?,?,?,?)"
            );
            statement.setString(1, absensidokter.getDokterIdDokter());
            statement.setString(2, absensidokter.getKehadiranregulerDokter());
            statement.setString(3, absensidokter.getKehadiranlemburDokter());
            statement.setString(4, absensidokter.getDateAbsensidokter());
            statement.executeUpdate();
        } catch (SQLException exception) {
            ui.act.append("InsertAbsensidokter Error \n");
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
    public void updateAbsensidokter(Absensidokter absensidokter) throws RemoteException {
        ui.act.append("Client Execute updateAbsensidokter(" + absensidokter.toString() + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE absensidokter SET kehadiranreguler_dokter = ?, kehadiranlembur_dokter = ?, date_absensidokter = ? "
                    + "WHERE dokter_id_dokter = ?"
            );
            statement.setString(4, absensidokter.getDokterIdDokter());
            statement.setString(1, absensidokter.getKehadiranregulerDokter());
            statement.setString(2, absensidokter.getKehadiranlemburDokter());
            statement.setString(3, absensidokter.getDateAbsensidokter());
            statement.executeUpdate();

        } catch (SQLException e) {
            ui.act.append("UpdateAbsensidokter Error \n");
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
    public void deleteAbsensidokter(String idabsensidokter) throws RemoteException {
        ui.act.append("Client Execute deleteAbsensidokter (" + idabsensidokter + ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM absensidokter WHERE dokter_id_dokter = ?");
            statement.setString(1, idabsensidokter);
            statement.executeUpdate();
        } catch (SQLException e) {
            ui.act.append("deleteAbsensidokter Error \n");
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
    public Absensidokter getAbsensidokter(String dokteriddokter) throws RemoteException {
        ui.act.append("Client Execute getAbsensidokter (" + dokteriddokter + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM absensidokter WHERE dokter_id_dokter = ?");
            statement.setString(1, dokteriddokter);
            ResultSet result = statement.executeQuery();
            Absensidokter absensidokter = null;
            if (result.next()) {
                absensidokter = new Absensidokter();
                absensidokter.setDokterIdDokter(result.getString("dokter_id_dokter"));
                absensidokter.setKehadiranregulerDokter(result.getString("kehadiranreguler_dokter"));
                absensidokter.setKehadiranlemburDokter(result.getString("kehadiranlembur_dokter"));
                absensidokter.setDateAbsensidokter(result.getString("date_absensidokter"));
            }
            return absensidokter;
        } catch (SQLException exception) {
            ui.act.append("getAbsensidokter Error \n");
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
    public List<Absensidokter> getAbsensidokter() throws RemoteException {
        ui.act.append("Client Execute getAbsensidokterList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM absensidokter");

            List<Absensidokter> list = new ArrayList<Absensidokter>();

            while (result.next()) {
                Absensidokter absensidokter = new Absensidokter();
                absensidokter.setDokterIdDokter(result.getString("dokter_id_dokter"));
                absensidokter.setKehadiranregulerDokter(result.getString("kehadiranreguler_dokter"));
                absensidokter.setKehadiranlemburDokter(result.getString("kehadiranlembur_dokter"));
                absensidokter.setDateAbsensidokter(result.getString("date_absensidokter"));
                list.add(absensidokter);
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getAbsensidokterList Error \n");
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
