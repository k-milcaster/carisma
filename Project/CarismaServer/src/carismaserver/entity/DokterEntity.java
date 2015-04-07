package carismaserver.entity;

import carismainterface.entity.Dokter;
import carismainterface.server.DokterService;
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
public class DokterEntity extends UnicastRemoteObject implements DokterService {

    public Main ui;

    public DokterEntity() throws RemoteException {

    }

    public DokterEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }

    @Override
    public void insertDokter(Dokter dokter) throws RemoteException {
        ui.act.append("Client Execute insertDokter " + dokter.getIdDokter() + "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO dokter (poli_id_poli, user_id_user, id_dokter, nama_dokter, alamat_dokter, nokartuid_dokter, telp_dokter, hp1_dokter, hp2_dokter, tempatlahir_dokter, tgllahir_dokter, kelamin_dokter, darah_dokter, bank_dokter, norek_dokter, foto_dokter, gajifix_dokter, gajilembur_dokter, gajikonsul_dokter) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
            );
            statement.setString(1, dokter.getPoliIdPoli());
            statement.setInt(2, dokter.getUserIdUser());
            statement.setString(3, dokter.getIdDokter());
            statement.setString(4, dokter.getNamaDokter());
            statement.setString(5, dokter.getAlamatDokter());
            statement.setString(6, dokter.getNokartuidDokter());
            statement.setString(7, dokter.getTelpDokter());
            statement.setString(8, dokter.getHp1Dokter());
            statement.setString(9, dokter.getHp2Dokter());
            statement.setString(10, dokter.getTempatlahirDokter());
            statement.setString(11, dokter.getTgllahirDokter());
            statement.setString(12, dokter.getKelaminDokter());
            statement.setString(13, dokter.getDarahDokter());
            statement.setString(14, dokter.getBankDokter());
            statement.setString(15, dokter.getNorekDokter());
            statement.setBytes(16, dokter.getFotoDokter());
            statement.setInt(17, dokter.getGajifixDokter());
            statement.setInt(18, dokter.getGajilemburDokter());
            statement.setDouble(19, dokter.getGajikonsulDokter());
            statement.executeUpdate();
        } catch (SQLException exception) {
            ui.act.append("InsertDokter Error \n");
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
    public void updateDokter(Dokter dokter) throws RemoteException {
        ui.act.append("Client Execute updateDokter(" + dokter.toString() + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE dokter SET poli_id_poli = ?, user_id_user = ?, nama_dokter = ?, alamat_dokter = ?, nokartuid_dokter = ?, telp_dokter = ?,"
                    + "hp1_dokter = ?, hp2_dokter = ?, tempatlahir = ?, tgllahir_dokter = ?, kelamin_dokter = ?, darah_dokter = ?, "
                    + "bank_dokter = ?, norek_dokter = ?, foto_dokter = ?, gajifix_dokter = ?, gajilembur_dokter = ?, gajikonsul = ? "
                    + "WHERE id_dokter = ?"
            );
            statement.setString(1, (dokter.getPoliIdPoli()).toString());
            statement.setInt(2, dokter.getUserIdUser());
            statement.setString(19, dokter.getIdDokter());
            statement.setString(3, dokter.getNamaDokter());
            statement.setString(4, dokter.getAlamatDokter());
            statement.setString(5, dokter.getNokartuidDokter());
            statement.setString(6, dokter.getTelpDokter());
            statement.setString(7, dokter.getHp1Dokter());
            statement.setString(8, dokter.getHp2Dokter());
            statement.setString(9, dokter.getTempatlahirDokter());
            statement.setString(10, dokter.getTgllahirDokter());
            statement.setString(11, dokter.getKelaminDokter());
            statement.setString(12, dokter.getDarahDokter());
            statement.setString(13, dokter.getBankDokter());
            statement.setString(14, dokter.getNorekDokter());
            statement.setBytes(15, dokter.getFotoDokter());
            statement.setInt(16, dokter.getGajifixDokter());
            statement.setInt(17, dokter.getGajilemburDokter());
            statement.setDouble(18, dokter.getGajikonsulDokter());
            statement.executeUpdate();

        } catch (SQLException e) {
            ui.act.append("UpdateDokter Error \n");
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
    public void deleteDokter(String dokter) throws RemoteException {
        ui.act.append("Client Execute deleteDokter (" + dokter + ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM dokter WHERE id_dokter = ?");
            statement.setString(1, dokter);
            statement.executeUpdate();
        } catch (SQLException e) {
            ui.act.append("deleteDokter Error \n");
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
    public Dokter getDokter(String dok) throws RemoteException {
        ui.act.append("Client Execute getDokter (" + dok + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM dokter WHERE nama_dokter = ?");
            statement.setString(1, dok);
            ResultSet result = statement.executeQuery();
            Dokter dokter = null;
            if (result.next()) {
                dokter = new Dokter();
                dokter.setIdDokter(result.getString("id_dokter"));
                dokter.setUserIdUser(result.getInt("user_id_user"));
                dokter.setNamaDokter(result.getString("nama_dokter"));
                dokter.setAlamatDokter(result.getString("alamat_dokter"));
                dokter.setNokartuidDokter(result.getString("nokartuid_dokter"));
                dokter.setTelpDokter(result.getString("telp_dokter"));
                dokter.setHp1Dokter(result.getString("hp1_dokter"));
                dokter.setHp2Dokter(result.getString("hp2_dokter"));
                dokter.setTempatlahirDokter(result.getString("tempatlahir_dokter"));
                dokter.setTgllahirDokter(result.getString("tgllahir_dokter"));
                dokter.setKelaminDokter(result.getString("kelamin_dokter"));
                dokter.setDarahDokter(result.getString("darah_dokter"));
                dokter.setBankDokter(result.getString("bank_dokter"));
                dokter.setNorekDokter(result.getString("norek_dokter"));
                dokter.setGajifixDokter(result.getInt("gajifix_dokter"));
                dokter.setGajilemburDokter(result.getInt("gajilembur_dokter"));
                dokter.setGajikonsulDokter(result.getDouble("gajikonsul_dokter"));
            }
            return dokter;
        } catch (SQLException exception) {
            ui.act.append("getDokter Error \n");
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
    public List<Dokter> getDokter() throws RemoteException {
        ui.act.append("Client Execute getDokterList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM dokter");

            List<Dokter> list = new ArrayList<Dokter>();

            while (result.next()) {
                Dokter dokter = new Dokter();
                dokter.setIdDokter(result.getString("id_dokter"));
                dokter.setNamaDokter(result.getString("nama_dokter"));
                dokter.setAlamatDokter(result.getString("alamat_dokter"));
                dokter.setNokartuidDokter(result.getString("nokartuid_dokter"));
                dokter.setTelpDokter(result.getString("telp_dokter"));
                dokter.setHp1Dokter(result.getString("hp1_dokter"));
                dokter.setHp2Dokter(result.getString("hp2_dokter"));
                dokter.setTempatlahirDokter(result.getString("tempatlahir_dokter"));
                dokter.setTgllahirDokter(result.getString("tgllahir_dokter"));
                dokter.setKelaminDokter(result.getString("kelamin_dokter"));
                dokter.setDarahDokter(result.getString("darah_dokter"));
                dokter.setBankDokter(result.getString("bank_dokter"));
                dokter.setNorekDokter(result.getString("norek_dokter"));
                dokter.setGajifixDokter(result.getInt("gajifix_dokter"));
                dokter.setGajilemburDokter(result.getInt("gajilembur_dokter"));
                dokter.setGajikonsulDokter(result.getDouble("gajikonsul_dokter"));
                list.add(dokter);
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getDokterList Error \n");
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
