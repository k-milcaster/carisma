/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaserver.entity;

import carismainterface.entity.PasienKamar;
import carismainterface.entity.PasienKamar;
import carismainterface.server.PasienKamarService;
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
public class PasienKamarEntity extends UnicastRemoteObject implements PasienKamarService {

    public Main ui;

    public PasienKamarEntity() throws RemoteException {
    }

    public PasienKamarEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }
    
    @Override
    public void insertPasienKamar(PasienKamar pasienKamar) throws RemoteException {
        ui.act.append("Client Execute insertPasienKamar " + pasienKamar.getIdPeminjaman()+ "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO pasien_kamar (id_peminjaman, kamar_id_kamar, datein_pasien_kamar, dateout_pasien_kamar, keterangan) values (?,?,?,?,?)"
            );
            statement.setString(1, pasienKamar.getIdPeminjaman());
            statement.setInt(2, pasienKamar.getKamarIdKamar());
            statement.setString(3, pasienKamar.getDateinPasienKamar());
            statement.setString(4, pasienKamar.getDateoutPasienKamar());
            statement.setString(5, pasienKamar.getKeterangan());
            statement.executeUpdate();
        } catch (SQLException exception) {
            ui.act.append("InsertPasienKamar Error \n");
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
    public void updatePasienKamar(PasienKamar pasienKamar) throws RemoteException {
        ui.act.append("Client Execute updatePasienKamar(" + pasienKamar.toString() + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE pasien_kamar SET kamar_id_kamar = ?, datein_pasien_kamar = ?, dateout_pasien_kamar = ?, keterangan = ? "
                    + "WHERE id_peminjaman = ?"
            );
            statement.setString(5, pasienKamar.getIdPeminjaman());
            statement.setInt(1, pasienKamar.getKamarIdKamar());
            statement.setString(2, pasienKamar.getDateinPasienKamar());
            statement.setString(3, pasienKamar.getDateoutPasienKamar());
            statement.setString(4, pasienKamar.getKeterangan());
            statement.executeUpdate();

        } catch (SQLException e) {
            ui.act.append("UpdatePasienKamar Error \n");
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
    public void deletePasienKamar(String idpeminjaman) throws RemoteException {
        ui.act.append("Client Execute deletePasienKamar (" + idpeminjaman+ ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM pasien_kamar WHERE id_peminjaman = ?");
            statement.setString(1, idpeminjaman);
            statement.executeUpdate();
        } catch (SQLException e) {
            ui.act.append("deletePasienKamar Error \n");
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
    public PasienKamar getPasienKamar(String idpeminjaman) throws RemoteException {
        ui.act.append("Client Execute getPasienKamar (" + idpeminjaman + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM pasien_kamar WHERE id_peminjaman = ?");
            statement.setString(1, idpeminjaman);
            ResultSet result = statement.executeQuery();
            PasienKamar pasienKamar = null;
            if (result.next()) {
                pasienKamar = new PasienKamar();
                pasienKamar.setIdPeminjaman(result.getString("id_peminjaman"));
                pasienKamar.setKamarIdKamar(result.getInt("kamar_id_kamar"));
                pasienKamar.setDateinPasienKamar(result.getString("datein_pasien_kamar"));
                pasienKamar.setDateoutPasienKamar(result.getString("dateout_pasien_kamar"));
                pasienKamar.setKeterangan(result.getString("keterangan"));
            }
            return pasienKamar;
        } catch (SQLException exception) {
            ui.act.append("getPasienKamar Error \n");
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
    public List<PasienKamar> getPasienKamar() throws RemoteException {
        ui.act.append("Client Execute getPasienKamarList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM pasien_kamar");

            List<PasienKamar> list = new ArrayList<PasienKamar>();

            while (result.next()) {
                PasienKamar pasienKamar = new PasienKamar();
                pasienKamar.setIdPeminjaman(result.getString("id_peminjaman"));
                pasienKamar.setKamarIdKamar(result.getInt("kamar_id_kamar"));
                pasienKamar.setDateinPasienKamar(result.getString("datein_pasien_kamar"));
                pasienKamar.setDateoutPasienKamar(result.getString("dateout_pasien_kamar"));
                pasienKamar.setKeterangan(result.getString("keterangan"));
                list.add(pasienKamar);
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getPasienKamarList Error \n");
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
