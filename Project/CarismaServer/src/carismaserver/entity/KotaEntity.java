/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaserver.entity;

import carismainterface.entity.Kota;
import carismainterface.entity.Kota;
import carismainterface.server.KotaService;
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
public class KotaEntity extends UnicastRemoteObject implements KotaService{
    public Main ui;

    public KotaEntity() throws RemoteException {
    }

    public KotaEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }

    @Override
    public Kota getKota(String idkota) throws RemoteException {
        ui.act.append("Client Execute getKota (" + idkota + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM kota WHERE id_kota = ?");
            statement.setString(1, idkota);
            ResultSet result = statement.executeQuery();
            Kota kota = null;
            if (result.next()) {
                kota = new Kota();
                kota.setId_kota(result.getString("id_kota"));
                kota.setProvinsi_id_provinsi(result.getString("provinsi_id_provinsi"));
                kota.setNamaKota(result.getString("nama_kota"));
            }
            return kota;
        } catch (SQLException exception) {
            ui.act.append("getKota Error \n");
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
    public List<Kota> getKota() throws RemoteException {
        ui.act.append("Client Execute getKotaList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM kota");

            List<Kota> list = new ArrayList<Kota>();

            while (result.next()) {
                Kota kota = new Kota();
                kota.setId_kota(result.getString("id_kota"));
                kota.setProvinsi_id_provinsi(result.getString("provinsi_id_provinsi"));
                kota.setNamaKota(result.getString("nama_kota"));
                list.add(kota);
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getKotaList Error \n");
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
