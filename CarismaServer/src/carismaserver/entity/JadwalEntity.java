/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaserver.entity;

import carismainterface.entity.Jadwal;
import carismainterface.entity.Jadwal;
import carismainterface.server.JadwalService;
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
public class JadwalEntity extends UnicastRemoteObject implements JadwalService{
    
    public Main ui;

    public JadwalEntity() throws RemoteException {
    }

    public JadwalEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }

    @Override
    public void insertJadwal(Jadwal jadwal) throws RemoteException {
        ui.act.append("Client Execute insertJadwal " + jadwal.getId()+ "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO jadwal (id, hari_jadwalpegawai, shift_jadwalpegawai) values (?,?,?)"
            );
            statement.setInt(1, jadwal.getId());
            statement.setString(2, jadwal.getHariJadwalpegawai());
            statement.setString(3, jadwal.getShiftJadwalpegawai());
            statement.executeUpdate();
        } catch (SQLException exception) {
            ui.act.append("InsertJadwal Error \n");
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
    public void updateJadwal(Jadwal jadwal) throws RemoteException {
        ui.act.append("Client Execute updateJadwal(" + jadwal.toString() + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE jadwal SET hari_jadwalpegawai = ?, shift_jadwalpegawai = ? "
                    + "WHERE id_ = ?"
            );
            statement.setInt(3, jadwal.getId());
            statement.setString(1, jadwal.getHariJadwalpegawai());
            statement.setString(2, jadwal.getShiftJadwalpegawai());
            statement.executeUpdate();

        } catch (SQLException e) {
            ui.act.append("UpdateJadwal Error \n");
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
    public void deleteJadwal(String idjadwal) throws RemoteException {
        ui.act.append("Client Execute deleteJadwal (" + idjadwal + ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM jadwal WHERE id = ?");
            statement.setString(1, idjadwal);
            statement.executeUpdate();
        } catch (SQLException e) {
            ui.act.append("deleteJadwal Error \n");
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
    public Jadwal getJadwal(String idjadwal) throws RemoteException {
        ui.act.append("Client Execute getJadwal (" + idjadwal + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM jadwal WHERE id = ?");
            statement.setString(1, idjadwal);
            ResultSet result = statement.executeQuery();
            Jadwal jadwal = null;
            if (result.next()) {
                jadwal = new Jadwal();
                jadwal.setId(result.getInt("id"));
                jadwal.setHariJadwalpegawai(result.getString("hari_jadwalpegawai"));
                jadwal.setShiftJadwalpegawai(result.getString("shift_jadwalpegawai"));
            }
            return jadwal;
        } catch (SQLException exception) {
            ui.act.append("getJadwal Error \n");
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
    public List<Jadwal> getJadwal() throws RemoteException {
        ui.act.append("Client Execute getJadwalList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM jadwal");

            List<Jadwal> list = new ArrayList<Jadwal>();

            while (result.next()) {
                Jadwal jadwal = new Jadwal();
                jadwal.setId(result.getInt("id_jadwal"));
                jadwal.setHariJadwalpegawai(result.getString("hari_jadwalpegawai"));
                jadwal.setShiftJadwalpegawai(result.getString("shift_jadwalpegawai"));
                list.add(jadwal);
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getJadwalList Error \n");
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