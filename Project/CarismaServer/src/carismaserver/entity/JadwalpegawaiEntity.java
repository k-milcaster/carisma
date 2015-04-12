/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaserver.entity;

import carismainterface.entity.Jadwalpegawai;
import carismainterface.server.JadwalpegawaiService;
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
public class JadwalpegawaiEntity extends UnicastRemoteObject implements JadwalpegawaiService{
    public Main ui;

    public JadwalpegawaiEntity() throws RemoteException {
    }

    public JadwalpegawaiEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }
    
    @Override
    public void insertJadwalpegawai(Jadwalpegawai jadwalpegawai) throws RemoteException {
        ui.act.append("Client Execute insertJadwalpegawai " + jadwalpegawai.getId()+ "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO jadwalpegawai (id, pegawai_id_pegawai, jadwal_id) values (?,?,?)"
            );
            statement.setInt(1, jadwalpegawai.getId());
            statement.setString(2, jadwalpegawai.getPegawaiIdPegawai());
            statement.setInt(3, jadwalpegawai.getJadwalId());
            statement.executeUpdate();
        } catch (SQLException exception) {
            ui.act.append("InsertJadwalpegawai Error \n");
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
    public void updateJadwalpegawai(Jadwalpegawai jadwalpegawai) throws RemoteException {
        ui.act.append("Client Execute updateJadwalpegawai(" + jadwalpegawai.toString() + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE jadwalpegawai SET pegawai_id_pegawai = ?, jadwal_id = ? "
                    + "WHERE id = ?"
            );
            statement.setInt(3, jadwalpegawai.getId());
            statement.setString(1, jadwalpegawai.getPegawaiIdPegawai());
            statement.setInt(2, jadwalpegawai.getJadwalId());
            statement.executeUpdate();

        } catch (SQLException e) {
            ui.act.append("UpdateJadwalpegawai Error \n");
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
    public void deleteJadwalpegawai(String idjadwalpegawai) throws RemoteException {
        ui.act.append("Client Execute deleteJadwalpegawai (" + idjadwalpegawai + ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM jadwalpegawai WHERE id = ?");
            statement.setString(1, idjadwalpegawai);
            statement.executeUpdate();
        } catch (SQLException e) {
            ui.act.append("deleteJadwalpegawai Error \n");
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
    public Jadwalpegawai getJadwalpegawai(String idjadwalpegawai) throws RemoteException {
        ui.act.append("Client Execute getJadwalpegawai (" + idjadwalpegawai + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM jadwalpegawai WHERE id = ?");
            statement.setString(1, idjadwalpegawai);
            ResultSet result = statement.executeQuery();
            Jadwalpegawai jadwalpegawai = null;
            if (result.next()) {
                jadwalpegawai = new Jadwalpegawai();
                jadwalpegawai.setId(result.getInt("id"));
                jadwalpegawai.setPegawaiIdPegawai(result.getString("pegawai_id_pegawai"));
                jadwalpegawai.setJadwalId(result.getInt("jadwal_id"));
            }
            return jadwalpegawai;
        } catch (SQLException exception) {
            ui.act.append("getJadwalpegawai Error \n");
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
    public List<Jadwalpegawai> getJadwalpegawai() throws RemoteException {
        ui.act.append("Client Execute getJadwalpegawaiList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM jadwalpegawai");

            List<Jadwalpegawai> list = new ArrayList<Jadwalpegawai>();

            while (result.next()) {
                Jadwalpegawai jadwalpegawai = new Jadwalpegawai();
                jadwalpegawai.setId(result.getInt("id"));
                jadwalpegawai.setPegawaiIdPegawai(result.getString("pegawai_id_pegawai"));
                jadwalpegawai.setJadwalId(result.getInt("jadwal_id"));
                list.add(jadwalpegawai);
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getJadwalpegawaiList Error \n");
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
