/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaserver.entity;

import carismainterface.entity.Pegawai;
import carismainterface.server.PegawaiService;
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
public class PegawaiEntity extends UnicastRemoteObject implements PegawaiService{

     public Main ui;

    public PegawaiEntity() throws RemoteException {
    }

    public PegawaiEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }
     
    
    @Override
    public void insertPegawai(Pegawai pegawai) throws RemoteException {
        ui.act.append("Client Execute insertPegawai " + pegawai.getIdPegawai() + "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO pegawai (jabatan_pegawai, user_id_user, id_pegawai, nama_pegawai, alamat_pegawai, nokartuid_pegawai, telp_pegawai, hp1_pegawai, hp2_pegawai, tempatlahir_pegawai, tgllahir_pegawai, kelamin_pegawai, darah_pegawai, bank_pegawai, norek_pegawai, foto_pegawai, gajifix_pegawai, gajilembur_pegawai) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
            );
            statement.setString(1, pegawai.getJabatanPegawai());
            //statement.setInt(2, Integer.parseInt((pegawai.getUserIdUser()).toString()));
            statement.setInt(2, pegawai.getUserIdUser());
            statement.setString(3, pegawai.getIdPegawai());
            statement.setString(4, pegawai.getNamaPegawai());
            statement.setString(5, pegawai.getAlamatPegawai());
            statement.setString(6, pegawai.getNokartuidPegawai());
            statement.setString(7, pegawai.getTelpPegawai());
            statement.setString(8, pegawai.getHp1Pegawai());
            statement.setString(9, pegawai.getHp2Pegawai());
            statement.setString(10, pegawai.getTempatlahirPegawai());
            statement.setString(11, pegawai.getTgllahirPegawai());
            statement.setString(12, pegawai.getKelaminPegawai());
            statement.setString(13, pegawai.getDarahPegawai());
            statement.setString(14, pegawai.getBankPegawai());
            statement.setString(15, pegawai.getNorekPegawai());
            statement.setBytes(16, pegawai.getFotoPegawai());
            statement.setInt(17, pegawai.getGajifixPegawai());
            statement.setInt(18, pegawai.getGajilemburPegawai());
            statement.executeUpdate();
        } catch (SQLException exception) {
            ui.act.append("InsertUser Error \n");
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
    public void updatePegawai(Pegawai pegawai) throws RemoteException {
        ui.act.append("Client Execute updateCustomers(" + pegawai.toString() + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE pegawai SET jabatan_pegawai = ?, user_id_user = ?, nama_pegawai = ?, alamat_pegawai = ?, nokartuid_pegawai = ?, telp_pegawai = ?,"
                    + "hp1_pegawai = ?, hp2_pegawai = ?, tempatlahir = ?, tgllahir_pegawai = ?, kelamin_pegawai = ?, darah_pegawai = ?, "
                    + "bank_pegawai = ?, norek_pegawai = ?, foto_pegawai = ?, gajifix_pegawai = ?, gajilembur_pegawai = ?, gajikonsul = ? "
                    + "WHERE id_pegawai = ?"
            );
            statement.setString(1, (pegawai.getJabatanPegawai()).toString());
            statement.setInt(2, pegawai.getUserIdUser());
            statement.setString(19, pegawai.getIdPegawai());
            statement.setString(3, pegawai.getNamaPegawai());
            statement.setString(4, pegawai.getAlamatPegawai());
            statement.setString(5, pegawai.getNokartuidPegawai());
            statement.setString(6, pegawai.getTelpPegawai());
            statement.setString(7, pegawai.getHp1Pegawai());
            statement.setString(8, pegawai.getHp2Pegawai());
            statement.setString(9, pegawai.getTempatlahirPegawai());
            statement.setString(10, pegawai.getTgllahirPegawai());
            statement.setString(11, pegawai.getKelaminPegawai());
            statement.setString(12, pegawai.getDarahPegawai());
            statement.setString(13, pegawai.getBankPegawai());
            statement.setString(14, pegawai.getNorekPegawai());
            statement.setBytes(15, pegawai.getFotoPegawai());
            statement.setInt(16, pegawai.getGajifixPegawai());
            statement.setInt(17, pegawai.getGajilemburPegawai());
            //System.out.println(statement);
            statement.executeUpdate();

        } catch (SQLException e) {
            ui.act.append("UpdatePegawai Error \n");
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
    public void deletePegawai(String pegawai) throws RemoteException {
        ui.act.append("Client Execute deleteUser (" + pegawai+ ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM pegawai WHERE id_pegawai = ?");
            statement.setString(1, pegawai);
            statement.executeUpdate();
        } catch (SQLException e) {
            ui.act.append("deletePegawai Error \n");
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
    public Pegawai getPegawai(String staff) throws RemoteException {
        ui.act.append("Client Execute getPegawai (" + staff + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM pegawai WHERE nama_pegawai = ?");
            statement.setString(1, staff);
            ResultSet result = statement.executeQuery();
            Pegawai pegawai = null;
            if (result.next()) {
                pegawai = new Pegawai();                                
                pegawai.setIdPegawai(result.getString("id_pegawai"));                
                pegawai.setUserIdUser(result.getInt("user_id_user"));
                pegawai.setNamaPegawai(result.getString("nama_pegawai"));
                pegawai.setJabatanPegawai(result.getString("jabatan_pegawai"));
                pegawai.setAlamatPegawai(result.getString("alamat_pegawai"));
                pegawai.setNokartuidPegawai(result.getString("nokartuid_pegawai"));
                pegawai.setTelpPegawai(result.getString("telp_pegawai"));
                pegawai.setHp1Pegawai(result.getString("hp1_pegawai"));
                pegawai.setHp2Pegawai(result.getString("hp2_pegawai"));
                pegawai.setTempatlahirPegawai(result.getString("tempatlahir_pegawai"));
                pegawai.setTgllahirPegawai(result.getString("tgllahir_pegawai"));
                pegawai.setKelaminPegawai(result.getString("kelamin_pegawai"));
                pegawai.setDarahPegawai(result.getString("darah_pegawai"));
                pegawai.setBankPegawai(result.getString("bank_pegawai"));
                pegawai.setNorekPegawai(result.getString("norek_pegawai"));
                pegawai.setGajifixPegawai(result.getInt("gajifix_pegawai"));
                pegawai.setGajilemburPegawai(result.getInt("gajilembur_pegawai"));
            }
            System.out.println("here is getPegawai");
            return pegawai;
        } catch (SQLException exception) {
            ui.act.append("getPegawai Error \n");
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
    public List<Pegawai> getPegawai() throws RemoteException {
        ui.act.append("Client Execute getPegawaiList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM pegawai");

            List<Pegawai> list = new ArrayList<Pegawai>();

            while (result.next()) {
                Pegawai pegawai = new Pegawai();
                pegawai.setIdPegawai(result.getString("id_pegawai"));
                pegawai.setNamaPegawai(result.getString("nama_pegawai"));
                pegawai.setJabatanPegawai(result.getString("jabatan_pegawai"));
                pegawai.setAlamatPegawai(result.getString("alamat_pegawai"));
                pegawai.setNokartuidPegawai(result.getString("nokartuid_pegawai"));
                pegawai.setTelpPegawai(result.getString("telp_pegawai"));
                pegawai.setHp1Pegawai(result.getString("hp1_pegawai"));
                pegawai.setHp2Pegawai(result.getString("hp2_pegawai"));
                pegawai.setTempatlahirPegawai(result.getString("tempatlahir_pegawai"));
                pegawai.setTgllahirPegawai(result.getString("tgllahir_pegawai"));
                pegawai.setKelaminPegawai(result.getString("kelamin_pegawai"));
                pegawai.setDarahPegawai(result.getString("darah_pegawai"));
                pegawai.setBankPegawai(result.getString("bank_pegawai"));
                pegawai.setNorekPegawai(result.getString("norek_pegawai"));
                pegawai.setGajifixPegawai(result.getInt("gajifix_pegawai"));
                pegawai.setGajilemburPegawai(result.getInt("gajilembur_pegawai"));

                list.add(pegawai);
            }
            result.close();

            return list;

        } catch (SQLException exception) {
            ui.act.append("getPegawai List Error \n");
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
    public String[] getIdNamaPegawai(String username) throws RemoteException {
        ui.act.append("Client Execute getIdNamaPegawai(" + username + ") \n");
        String[] pegawaiInfo = new String[2];
        Statement state = null;
        ResultSet resultSet = null;
        
        try {
            state = DatabaseConnection.getConnection().createStatement();
            resultSet = state.executeQuery("SELECT P.nama_pegawai FROM pegawai AS P, user AS U "
                    + "WHERE U.username = '" + username + "' AND P.user_id_user = (SELECT id_user FROM user WHERE username = '" + username + "')");
            while (resultSet.next()) {
                pegawaiInfo[0] = resultSet.getString(1);
                //pegawaiInfo[1] = resultSet.getString(2);
            }
            return pegawaiInfo;
        } catch (SQLException e) {
            ui.act.append("getIdNamaPegawai Error\n");
            ui.act.append(e.toString());
            return null;
        }finally{
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
}
