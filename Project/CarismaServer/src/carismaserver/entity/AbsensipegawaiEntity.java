/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaserver.entity;

import carismainterface.entity.Absensipegawai;
import carismainterface.server.AbsensipegawaiService;
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
public class AbsensipegawaiEntity extends UnicastRemoteObject implements AbsensipegawaiService{
    
    public Main ui;

    public AbsensipegawaiEntity() throws RemoteException {
    }

    public AbsensipegawaiEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }

    @Override
    public void insertAbsensipegawai(Absensipegawai absensipegawai) throws RemoteException {
        ui.act.append("Client Execute insertAbsensipegawai " + absensipegawai.getPegawaiIdPegawai()+ "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO absensipegawai (pegawai_id_pegawai, kehadiranreguler_pegawai, kehadiranlembur_pegawai, date_absensipegawai) values (?,?,?,?)"
            );
            statement.setString(1, absensipegawai.getPegawaiIdPegawai());
            statement.setString(2, absensipegawai.getKehadiranregulerPegawai());
            statement.setString(3, absensipegawai.getKehadiranlemburPegawai());
            statement.setString(4, absensipegawai.getDateAbsensipegawai());
            statement.executeUpdate();
        } catch (SQLException exception) {
            ui.act.append("InsertAbsensipegawai Error \n");
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
    public void updateAbsensipegawai(Absensipegawai absensipegawai) throws RemoteException {
        ui.act.append("Client Execute updateAbsensipegawai(" + absensipegawai.toString() + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE absensipegawai SET kehadiranreguler_pegawai = ?, kehadiranlembur_pegawai = ?, date_absensipegawai = ? "
                    + "WHERE pegawai_id_pegawai = ?"
            );
            statement.setString(4, absensipegawai.getPegawaiIdPegawai());
            statement.setString(1, absensipegawai.getKehadiranregulerPegawai());
            statement.setString(2, absensipegawai.getKehadiranlemburPegawai());
            statement.setString(3, absensipegawai.getDateAbsensipegawai());
            statement.executeUpdate();

        } catch (SQLException e) {
            ui.act.append("UpdateAbsensipegawai Error \n");
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
    public void deleteAbsensipegawai(String idabsensipegawai) throws RemoteException {
        ui.act.append("Client Execute deleteAbsensipegawai (" + idabsensipegawai + ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM absensipegawai WHERE pegawai_id_pegawai = ?");
            statement.setString(1, idabsensipegawai);
            statement.executeUpdate();
        } catch (SQLException e) {
            ui.act.append("deleteAbsensipegawai Error \n");
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
    public Absensipegawai getAbsensipegawai(String pegawaiidpegawai) throws RemoteException {
        ui.act.append("Client Execute getAbsensipegawai (" + pegawaiidpegawai + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM absensipegawai WHERE pegawai_id_pegawai = ?");
            statement.setString(1, pegawaiidpegawai);
            ResultSet result = statement.executeQuery();
            Absensipegawai absensipegawai = null;
            if (result.next()) {
                absensipegawai = new Absensipegawai();
                absensipegawai.setPegawaiIdPegawai(result.getString("pegawai_id_pegawai"));
                absensipegawai.setKehadiranregulerPegawai(result.getString("kehadiranreguler_pegawai"));
                absensipegawai.setKehadiranlemburPegawai(result.getString("kehadiranlembur_pegawai"));
                absensipegawai.setDateAbsensipegawai(result.getString("date_absensipegawai"));
            }
            return absensipegawai;
        } catch (SQLException exception) {
            ui.act.append("getAbsensipegawai Error \n");
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
    public List<Absensipegawai> getAbsensipegawai() throws RemoteException {
        ui.act.append("Client Execute getAbsensipegawaiList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM absensipegawai");

            List<Absensipegawai> list = new ArrayList<Absensipegawai>();

            while (result.next()) {
                Absensipegawai absensipegawai = new Absensipegawai();
                absensipegawai.setPegawaiIdPegawai(result.getString("pegawai_id_pegawai"));
                absensipegawai.setKehadiranregulerPegawai(result.getString("kehadiranreguler_pegawai"));
                absensipegawai.setKehadiranlemburPegawai(result.getString("kehadiranlembur_pegawai"));
                absensipegawai.setDateAbsensipegawai(result.getString("date_absensipegawai"));
                list.add(absensipegawai);
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getAbsensipegawaiList Error \n");
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
