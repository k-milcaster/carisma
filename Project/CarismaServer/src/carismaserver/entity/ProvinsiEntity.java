/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaserver.entity;

import carismainterface.entity.Provinsi;
import carismainterface.entity.Provinsi;
import carismainterface.server.ProvinsiService;
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
public class ProvinsiEntity  extends UnicastRemoteObject implements ProvinsiService{
    public Main ui;

    public ProvinsiEntity() throws RemoteException {
    }

    public ProvinsiEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }

    @Override
    public Provinsi getProvinsi(String idprovinsi) throws RemoteException {
        ui.act.append("Client Execute getProvinsi (" + idprovinsi + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM provinsi WHERE id_provinsi = ?");
            statement.setString(1, idprovinsi);
            ResultSet result = statement.executeQuery();
            Provinsi provinsi = null;
            if (result.next()) {
                provinsi = new Provinsi();
                provinsi.setIdProvinsi(result.getString("id_provinsi"));
                provinsi.setNamaProvinsi(result.getString("nama_provinsi"));
            }
            return provinsi;
        } catch (SQLException exception) {
            ui.act.append("getProvinsi Error \n");
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
    public List<Provinsi> getProvinsi() throws RemoteException {
        ui.act.append("Client Execute getProvinsiList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM provinsi");

            List<Provinsi> list = new ArrayList<Provinsi>();

            while (result.next()) {
                Provinsi provinsi = new Provinsi();
                provinsi.setIdProvinsi(result.getString("id_provinsi"));
                provinsi.setNamaProvinsi(result.getString("nama_provinsi"));
                list.add(provinsi);
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getProvinsiList Error \n");
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
