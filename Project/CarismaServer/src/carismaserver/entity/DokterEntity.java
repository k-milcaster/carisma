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
    public boolean insertDokter(Dokter dokter) throws RemoteException {
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
            System.out.println(statement.toString());
            return true;
        } catch (SQLException exception) {
            ui.act.append("InsertDokter Error \n");
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
    public boolean updateDokter(Dokter dokter) throws RemoteException {
        ui.act.append("Client Execute updateDokter(" + dokter.toString() + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE dokter SET poli_id_poli = ?, user_id_user = ?, nama_dokter = ?, alamat_dokter = ?, nokartuid_dokter = ?, telp_dokter = ?,"
                    + "hp1_dokter = ?, hp2_dokter = ?, tempatlahir_dokter = ?, tgllahir_dokter = ?, kelamin_dokter = ?, darah_dokter = ?, "
                    + "bank_dokter = ?, norek_dokter = ?, foto_dokter = ?, gajifix_dokter = ?, gajilembur_dokter = ?, gajikonsul_dokter = ? "
                    + "WHERE id_dokter = ?"
            );
            statement.setString(1, (dokter.getPoliIdPoli()));
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
            return true;
        } catch (SQLException e) {
            ui.act.append("UpdateDokter Error \n");
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
    public boolean deleteDokter(String dokter) throws RemoteException {
        ui.act.append("Client Execute deleteDokter (" + dokter + ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM dokter WHERE id_dokter = ?");
            statement.setString(1, dokter);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("deleteDokter Error \n");
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
                dokter.setPoliIdPoli(result.getString("poli_id_poli"));
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
                dokter.setFotoDokter(result.getBytes("foto_dokter"));
            }
            return dokter;
        } catch (SQLException exception) {
            ui.act.append("getDokter Error \n");
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
                dokter.setFotoDokter(result.getBytes("foto_dokter"));
                list.add(dokter);
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getDokterList Error \n");
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

    
    //tambahan query dari fiqhi
        @Override
        public List<Dokter> getDokterByPoliAsc(String poli) throws RemoteException {
        ui.act.append("Client Execute getDokterList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT d.id_dokter, d.nama_dokter, jad.`hari_jadwalpegawai`, jad.`shift_jadwalpegawai` FROM `jadwaldokter` AS j, dokter AS d, jadwal AS jad, poli AS p WHERE d.`id_dokter`=j.`dokter_id_dokter` AND jad.id=j.`jadwal_id` AND d.poli_id_poli = p.id_poli AND p.nama_poli = '"+poli+"' ORDER BY `jadwal_id` ASC ");

            List<Dokter> list = new ArrayList<Dokter>();

            while (result.next()) {
                Dokter dokter = new Dokter();
                
                dokter.setIdDokter(result.getString(1));
                dokter.setNamaDokter(result.getString(2));
                dokter.setHp1Dokter(result.getString(3));
                dokter.setHp2Dokter(result.getString(4));
                
                list.add(dokter);
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getDokterList Error \n");
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
    public String[] getIdNamaDokter(String username) throws RemoteException {
        ui.act.append("Client Execute getIdNamaDokter(" + username + ") \n");
        String[] dokterInfo = new String[2];
        Statement state = null;
        ResultSet resultSet = null;

        try {
            state = DatabaseConnection.getConnection().createStatement();
            resultSet = state.executeQuery("SELECT D.id_dokter, D.nama_dokter FROM `dokter` AS D, user AS U "
                    + "WHERE U.username = '" + username + "' AND D.user_id_user = (SELECT id_user FROM user WHERE username = '" + username + "')");
            while (resultSet.next()) {
                dokterInfo[0] = resultSet.getString(1);
                dokterInfo[1] = resultSet.getString(2);
            }
            return dokterInfo;
        } catch (SQLException e) {
            ui.act.append("getIdNamaDokter Error\n");
            ui.act.append(e.toString());
            return null;
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public List<Dokter> getDokterByName(String nama) throws RemoteException {
        ui.act.append("Client Execute getPasienListByName  \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM dokter WHERE nama_dokter LIKE('%" + nama + "%')");
            ResultSet result = statement.executeQuery();
            List<Dokter> list = new ArrayList<Dokter>();
            Dokter dok = null;
            if (result.next()) {
                dok = new Dokter();
                dok.setIdDokter(result.getString("id_dokter"));
                dok.setNamaDokter(result.getString("nama_dokter"));
                dok.setAlamatDokter(result.getString("alamat_dokter"));
                dok.setNokartuidDokter(result.getString("nokartuid_dokter"));
                dok.setTelpDokter(result.getString("telp_dokter"));
                dok.setHp1Dokter(result.getString("hp1_dokter"));
                dok.setHp2Dokter(result.getString("hp2_dokter"));
                dok.setTempatlahirDokter(result.getString("tempatlahir_dokter"));
                dok.setTgllahirDokter(result.getString("tgllahir_dokter"));
                dok.setKelaminDokter(result.getString("kelamin_dokter"));
                dok.setDarahDokter(result.getString("darah_dokter"));
                dok.setBankDokter(result.getString("bank_dokter"));
                dok.setNorekDokter(result.getString("norek_dokter"));
                dok.setGajifixDokter(result.getInt("gajifix_dokter"));
                dok.setGajilemburDokter(result.getInt("gajilembur_dokter"));
                dok.setGajikonsulDokter(result.getDouble("gajikonsul_dokter"));
                list.add(dok);
            }
            return list;
        } catch (SQLException exception) {
            ui.act.append("getDokterListByName Error \n");
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
    public ArrayList getDokterById(String idDokter) throws RemoteException {
        ui.act.append("Client Execute getDokterById  \n");

        ArrayList informasiDokter = new ArrayList();
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT d.`id_dokter`, d.`nama_dokter`, p.`nama_poli`, d.`tempatlahir_dokter`, d.`tgllahir_dokter`, d.`kelamin_dokter`, d.`alamat_dokter`, d.`telp_dokter`, d.`hp1_dokter`, d.`hp2_dokter`, d.`foto_dokter` FROM `dokter` AS d, poli AS p WHERE d.`id_dokter` = '" + idDokter + "' AND p.id_poli = d.`poli_id_poli`");
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                informasiDokter.add(result.getString(1));
                informasiDokter.add(result.getString(2));
                informasiDokter.add(result.getString(3));
                informasiDokter.add(result.getString(4));
                informasiDokter.add(result.getString(5));
                informasiDokter.add(result.getString(6));
                informasiDokter.add(result.getString(7));
                informasiDokter.add(result.getString(8));
                informasiDokter.add(result.getString(9));
                informasiDokter.add(result.getString(10));
                informasiDokter.add(result.getBytes(11));
            }
            System.out.println(informasiDokter.get(10));
            return informasiDokter;
        } catch (SQLException exception) {
            ui.act.append("getDokterById Error \n");
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
