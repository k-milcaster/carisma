package carismaserver.entity;

import carismainterface.entity.Antrian;
import carismainterface.server.AntrianService;
import carismaserver.boundaries.Main;
import carismaserver.controllers.DatabaseConnection;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public class AntrianEntity extends UnicastRemoteObject implements AntrianService {

    public Main ui;

    public AntrianEntity() throws RemoteException {

    }

    public AntrianEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }

    //tambahan
    @Override
    public boolean insertAntrian(Antrian antrian) throws RemoteException {
        ui.act.append("Client Execute insertAntrian " + antrian.getIdAntrian() + "\n");
        PreparedStatement statement = null;
        try {
            
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO `antrian`(`id_antrian`, `pasien_id_pasien`, `dokter_id_dokter`, `nomor_antrian`, `jenis_antrian`, `tgl_antrian`, `hadir`) VALUES (?,?,?,?,?,?,?)"
            );
            statement.setString(1, antrian.getIdAntrian());
            statement.setString(2, antrian.getPasienIdPasien());
            statement.setString(3, antrian.getDokterIdDokter());
            statement.setInt(4, antrian.getNomorAntrian());
            statement.setString(5, antrian.getJenisAntrian());
            statement.setString(6, antrian.getTglAntrian());
            statement.setString(7, antrian.getHadir());

//            System.out.println(statement);
            statement.executeUpdate();
            return true;
        } catch (Exception exception) {
            ui.act.append("InsertUser Error \n");
            ui.act.append(exception.toString());
            exception.printStackTrace();
            return false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception exception) {
                }
            }
        }
    }

    @Override
    public boolean deleteAntrian(String antrian) throws RemoteException {
        ui.act.append("Client Execute deleteAntrian (" + antrian + ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM antrian WHERE id_antrian = ?");
            statement.setString(1, antrian);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("deleteAntrian Error \n");
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
    public Antrian getAntrian(String antrian) throws RemoteException {
        ui.act.append("Client Execute getAntrian (" + antrian + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM antrian WHERE id_antrian = ?");
            statement.setString(1, antrian);
            ResultSet result = statement.executeQuery();
            Antrian antri = null;
            if (result.next()) {
                antri = new Antrian();
                antri.setIdAntrian(result.getString("id_antrian"));
                antri.setPasienIdPasien(result.getString("pasien_id_pasien"));
                antri.setDokterIdDokter(result.getString("dokter_id_dokter"));
                antri.setJenisAntrian(result.getString("jenis_antrian"));
                antri.setNomorAntrian(result.getInt("nomor_antrian"));
                antri.setTglAntrian(result.getString("tgl_antrian"));
                antri.setHadir(result.getString("hadir"));

            }
            return antri;
        } catch (SQLException exception) {
            ui.act.append("getAntrian Error \n");
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
    public List<Antrian> getAntrian() throws RemoteException {
        ui.act.append("Client Execute getAntrianList \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM antrian WHERE hadir = '-'");
            ResultSet result = statement.executeQuery();
            List<Antrian> list = new ArrayList<Antrian>();
            Antrian antri = null;
            while (result.next()) {
                antri = new Antrian();
                antri.setIdAntrian(result.getString("id_antrian"));
                antri.setPasienIdPasien(result.getString("pasien_id_pasien"));
                antri.setDokterIdDokter(result.getString("dokter_id_dokter"));
                antri.setJenisAntrian(result.getString("jenis_antrian"));
                antri.setNomorAntrian(result.getInt("nomor_antrian"));
                antri.setTglAntrian(result.getString("tgl_antrian"));
                antri.setHadir(result.getString("hadir"));
                list.add(antri);
            }
            return list;
        } catch (SQLException exception) {
            ui.act.append("getAntrianList Error \n");
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
    public boolean antrianHadir(String antrian) throws RemoteException {
        ui.act.append("Client Execute antrianHadir(" + antrian + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE antrian SET hadir = ? WHERE id_antrian = ?"
            );
            statement.setInt(1, 1);
            statement.setString(2, antrian);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("antrianHadir Error \n");
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

        //tambahan query
    @Override
     public String generateIDAntrian() throws RemoteException {
        ui.act.append("Client Execute getAntrianList \n");
        
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT COUNT(`id_antrian`) AS hasil FROM `antrian` WHERE `id_antrian` LIKE '%A%' ");
            ResultSet result = statement.executeQuery();
            List<Antrian> list = new ArrayList<Antrian>();
            Antrian antri = null;
            int hasil = 0;
            String kode="A00";
            while (result.next()) {
                
                hasil = result.getInt("hasil")+1;
                
                
            }
            kode=kode+String.valueOf(hasil);
            return kode;
            
        } catch (SQLException exception) {
            ui.act.append("getAntrianList Error \n");
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
     
    //tambahan query
     @Override
      public int generateNomorAntrian(String tanggal) throws RemoteException {
        ui.act.append("Client Execute getAntrianList \n");
        
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT COUNT(`nomor_antrian`) AS hasil FROM `antrian` WHERE `tgl_antrian`='"+tanggal+"' ");
            ResultSet result = statement.executeQuery();
            List<Antrian> list = new ArrayList<Antrian>();
            Antrian antri = null;
            int hasil = 0;
//            String kode="A00";
            while (result.next()) {
                
                hasil = result.getInt("hasil")+1;
                
                
            }
//            kode=kode+String.valueOf(hasil);
            return hasil;
            
        } catch (SQLException exception) {
            ui.act.append("getAntrianList Error \n");
            ui.act.append(exception.toString());
            return 0;
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
    public boolean antrianTidakHadir(String antrian) throws RemoteException {
        ui.act.append("Client Execute antrianHadir(" + antrian + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE antrian SET hadir = ? WHERE id_antrian = ?"
            );
            statement.setInt(1, 0);
            statement.setString(2, antrian);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("antrianTidakHadir Error \n");
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

}
