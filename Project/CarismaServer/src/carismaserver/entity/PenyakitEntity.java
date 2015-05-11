/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaserver.entity;

import carismainterface.entity.Penyakit;
import carismainterface.server.PenyakitService;
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
public class PenyakitEntity extends UnicastRemoteObject implements PenyakitService{
    public Main ui;

    public PenyakitEntity() throws RemoteException {
    }

    public PenyakitEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }

    @Override
    public boolean insertPenyakit(Penyakit penyakit) throws RemoteException {
        ui.act.append("Client Execute insertPenyakit " + penyakit.getIdPenyakit()+ "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO penyakit (id_penyakit, nama_penyakit, deskripsi_penyakit) values (?,?,?)"
            );
            statement.setString(1, penyakit.getIdPenyakit());
            statement.setString(2, penyakit.getNamaPenyakit());
            statement.setString(3, penyakit.getDeskripsiPenyakit());
            statement.executeUpdate();
            return true;
        } catch (SQLException exception) {
            ui.act.append("InsertPenyakit Error \n");
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
    public boolean updatePenyakit(Penyakit penyakit) throws RemoteException {
        ui.act.append("Client Execute updatePenyakit(" + penyakit.toString() + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE penyakit SET nama_penyakit = ?, deskripsi_penyakit = ? "
                    + "WHERE id_penyakit = ?"
            );
            statement.setString(3, penyakit.getIdPenyakit());
            statement.setString(1, penyakit.getNamaPenyakit());
            statement.setString(2, penyakit.getDeskripsiPenyakit());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("UpdatePenyakit Error \n");
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
    public boolean deletePenyakit(String idpenyakit) throws RemoteException {
        ui.act.append("Client Execute deletePenyakit (" + idpenyakit + ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM penyakit WHERE id_penyakit = ?");
            statement.setString(1, idpenyakit);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("deletePenyakit Error \n");
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
    public Penyakit getPenyakit(String idpenyakit) throws RemoteException {
        ui.act.append("Client Execute getPenyakit (" + idpenyakit + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM penyakit WHERE id_penyakit = ?");
            statement.setString(1, idpenyakit);
            ResultSet result = statement.executeQuery();
            Penyakit penyakit = null;
            if (result.next()) {
                penyakit = new Penyakit();
                penyakit.setIdPenyakit(result.getString("id_penyakit"));
                penyakit.setNamaPenyakit(result.getString("nama_penyakit"));
                penyakit.setDeskripsiPenyakit(result.getString("deskripsi_penyakit"));
            }
            return penyakit;
        } catch (SQLException exception) {
            ui.act.append("getPenyakit Error \n");
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
    public List<Penyakit> getPenyakit() throws RemoteException {
        ui.act.append("Client Execute getPenyakitList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM penyakit");

            List<Penyakit> list = new ArrayList<Penyakit>();

            while (result.next()) {
                Penyakit penyakit = new Penyakit();
                penyakit.setIdPenyakit(result.getString("id_penyakit"));
                penyakit.setNamaPenyakit(result.getString("nama_penyakit"));
                penyakit.setDeskripsiPenyakit(result.getString("deskripsi_penyakit"));
                list.add(penyakit);
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getPenyakitList Error \n");
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
