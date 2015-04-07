/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaserver.entity;

import carismainterface.entity.Kamar;
import carismainterface.entity.Kamar;
import carismainterface.server.KamarService;
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
public class KamarEntity extends UnicastRemoteObject implements KamarService{

    public Main ui;

    public KamarEntity() throws RemoteException {
    }

    public KamarEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }
    
    @Override
    public void insertKamar(Kamar kamar) throws RemoteException {
         ui.act.append("Client Execute insertKamar " + kamar.getIdKamar()+ "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO kamar (id_kamar, nama_kamar, kelas, tarif) values (?,?,?,?)"
            );
            statement.setInt(1, kamar.getIdKamar());
            statement.setString(2, kamar.getNamaKamar());
            statement.setString(3, kamar.getKelas());
            statement.setInt(4, kamar.getTarif());
            statement.executeUpdate();
        } catch (SQLException exception) {
            ui.act.append("InsertKamar Error \n");
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
    public void updateKamar(Kamar kamar) throws RemoteException {
        ui.act.append("Client Execute updateKamar(" + kamar.toString() + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE kamar SET nama_kamar = ?, kelas = ?, tarif = ? "
                    + "WHERE id_kamar = ?"
            );
            statement.setInt(4, kamar.getIdKamar());
            statement.setString(1, kamar.getNamaKamar());
            statement.setString(2, kamar.getKelas());
            statement.setInt(3, kamar.getTarif());
            statement.executeUpdate();

        } catch (SQLException e) {
            ui.act.append("UpdateKamar Error \n");
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
    public void deleteKamar(String idkamar) throws RemoteException {
        ui.act.append("Client Execute deleteKamar (" + idkamar + ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM kamar WHERE id_kamar = ?");
            statement.setString(1, idkamar);
            statement.executeUpdate();
        } catch (SQLException e) {
            ui.act.append("deleteKamar Error \n");
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
    public Kamar getKamar(String idkamar) throws RemoteException {
        ui.act.append("Client Execute getKamar (" + idkamar + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM kamar WHERE id_kamar = ?");
            statement.setString(1, idkamar);
            ResultSet result = statement.executeQuery();
            Kamar kamar = null;
            if (result.next()) {
                kamar = new Kamar();
                kamar.setIdKamar(result.getInt("id_kamar"));
                kamar.setNamaKamar(result.getString("nama_kamar"));
                kamar.setKelas(result.getString("kelas"));
                kamar.setTarif(result.getInt("tarif"));
            }
            return kamar;
        } catch (SQLException exception) {
            ui.act.append("getKamar Error \n");
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
    public List<Kamar> getKamar() throws RemoteException {
        ui.act.append("Client Execute getKamarList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM kamar");

            List<Kamar> list = new ArrayList<Kamar>();

            while (result.next()) {
                Kamar kamar = new Kamar();
                kamar.setIdKamar(result.getInt("id_kamar"));
                kamar.setNamaKamar(result.getString("nama_kamar"));
                kamar.setKelas(result.getString("kelas"));
                kamar.setTarif(result.getInt("tarif"));
                list.add(kamar);
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getKamarList Error \n");
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
