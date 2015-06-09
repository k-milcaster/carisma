package carismaserver.entity;

import carismainterface.server.PembayaranService;
import carismaserver.boundaries.Main;
import carismaserver.controllers.DatabaseConnection;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author K-MiL Caster
 */
public class PembayaranEntity extends UnicastRemoteObject implements PembayaranService {

    private Main ui;

    public PembayaranEntity() throws RemoteException {

    }

    public PembayaranEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }

    @Override
    public ArrayList getBiayaKamar(String idPeminjaman) throws RemoteException {
        ui.act.append("Client Execute getBiayaKamar " + idPeminjaman + " \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT r.tarif, (DATE(dateout_pasien_kamar) - DATE(datein_pasien_kamar)) as lama_menginap, (DATE(dateout_pasien_kamar) - DATE(datein_pasien_kamar)) * (SELECT r.tarif from kamar r, pasien_kamar p where p.kamar_id_kamar = r.id_kamar AND p.id_peminjaman = '" + idPeminjaman + "') as total "
                    + "FROM pasien_kamar p, kamar r "
                    + "WHERE r.id_kamar = p.kamar_id_kamar AND p.id_peminjaman = \"" + idPeminjaman + "\";");
            ArrayList list = new ArrayList();
            while (result.next()) {
                list.add(result.getInt(1));
                list.add(result.getInt(2));
                list.add(result.getInt(3));
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getBiayaKamar Error \n");
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
    public ArrayList<ArrayList> getBiayaObat(String idTransaksi) throws RemoteException {
        ui.act.append("Client Execute getBiayaObat " + idTransaksi + " \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT h.nama_obat, h.hargajual_obat, dt.qty, h.hargajual_obat * dt.qty as harga "
                    + "FROM obat h, detailtransaksijualobat dt, transaksijualobat t "
                    + "WHERE t.id_transaksijual = dt.transaksijualobat_id_transaksijual AND dt.obat_id_obat = h.id_obat AND t.id_transaksijual = \"" + idTransaksi + "\";");

            ArrayList<ArrayList> list = new ArrayList<ArrayList>();
            ArrayList subList;

            while (result.next()) {
                subList = new ArrayList();
                subList.add(result.getString(1));
                subList.add(result.getInt(2));
                subList.add(result.getInt(3));
                subList.add(result.getInt(4));
                list.add(subList);
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getBiayaObat Error \n");
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
