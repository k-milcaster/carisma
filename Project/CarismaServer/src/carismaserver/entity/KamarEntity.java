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
    public boolean insertKamar(Kamar kamar) throws RemoteException {
        ui.act.append("Client Execute insertKamar " + kamar.getIdKamar()+ "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO kamar (id_kamar, nama_kamar, kelas, isi_kamar, fasilitas_kamar, tarif) values (?,?,?,?,?,?)"
            );
            statement.setInt(1, kamar.getIdKamar());
            statement.setString(2, kamar.getNamaKamar());
            statement.setString(3, kamar.getKelas());
            statement.setInt(4, kamar.getIsiKamar());
            statement.setString(5, kamar.getFasilitasKamar());
            statement.setInt(6, kamar.getTarif());
            statement.executeUpdate();
            return true;
        } catch (SQLException exception) {
            ui.act.append("InsertKamar Error \n");
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
    public boolean updateKamar(Kamar kamar) throws RemoteException {
        ui.act.append("Client Execute updateKamar(" + kamar.toString() + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE kamar SET nama_kamar = ?, kelas = ?, isi_kamar = ?, fasilitas_kamar = ?, tarif = ? "
                    + "WHERE id_kamar = ?"
            );
            statement.setInt(6, kamar.getIdKamar());
            statement.setString(1, kamar.getNamaKamar());
            statement.setString(2, kamar.getKelas());
            statement.setInt(3, kamar.getIsiKamar());
            statement.setString(4, kamar.getFasilitasKamar());
            statement.setInt(5, kamar.getTarif());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("UpdateKamar Error \n");
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
    public boolean deleteKamar(String idkamar) throws RemoteException {
        ui.act.append("Client Execute deleteKamar (" + idkamar + ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM kamar WHERE id_kamar = ?");
            statement.setString(1, idkamar);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("deleteKamar Error \n");
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
                kamar.setIsiKamar(result.getInt("isi_kamar"));
                kamar.setFasilitasKamar(result.getString("fasilitas_kamar"));
                kamar.setTarif(result.getInt("tarif"));
            }
            return kamar;
        } catch (SQLException exception) {
            ui.act.append("getKamar Error \n");
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
    public List<Kamar> getKamar() throws RemoteException {
        ui.act.append("Client Execute getKamarList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT K.* FROM kamar AS K LEFT JOIN pasien_kamar AS PK on K.id_kamar = PK.kamar_id_kamar "
                    + "WHERE PK .kamar_id_kamar IS null");

            List<Kamar> list = new ArrayList<Kamar>();

            while (result.next()) {
                Kamar kamar = new Kamar();
                kamar.setIdKamar(result.getInt("id_kamar"));
                kamar.setNamaKamar(result.getString("nama_kamar"));
                kamar.setKelas(result.getString("kelas"));
                kamar.setIsiKamar(result.getInt("isi_kamar"));
                kamar.setFasilitasKamar(result.getString("fasilitas_kamar"));
                kamar.setTarif(result.getInt("tarif"));
                list.add(kamar);
            }
            result.close();
            return list;

        } catch (SQLException exception) {
            ui.act.append("getKamarList Error \n");
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
    
    //buundo kalo menurutku harusnya per pasien di klik baru query jalan, kalo salah bilang ya
    @Override
    public String[] getNamaKelasKamarbyIdpasien(String idpasien) {
        ui.act.append("Client Execute getNamaKelasKamarList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT PK.id_peminjaman , KA.nama_kamar , KA.kelas FROM `kamar` AS KA, `pasien_kamar` AS PK, `kunjungan` AS K "
                    + "WHERE KA.id_kamar = PK.kamar_id_kamar AND K.pasien_kamar_id_peminjaman = PK.id_peminjaman AND K.pasien_id_pasien = '"+idpasien+"'");

            String[] kamarInfo = new String[3];

            while (result.next()) {
                kamarInfo[0] = result.getString(1);
                kamarInfo[1] = result.getString(2);
                kamarInfo[2] = result.getString(3);
            }
            result.close();
            return kamarInfo;

        } catch (SQLException exception) {
            ui.act.append("getNamaKelasKamarList Error \n");
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
    public int getJumlahKamarTerisi() throws RemoteException {
        ui.act.append("Client Execute getJumlahKamarTerisi \n");
        int jumlahkamarterisi = 0;
        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT count(kamar_id_kamar) from `pasien_kamar` ");

            

            while (result.next()) {
                jumlahkamarterisi = result.getInt(1);
                //list.add(kamar);
            }
            result.close();
            return jumlahkamarterisi;

        } catch (SQLException exception) {
            ui.act.append("getJumlahKamarTerisi Error \n");
            ui.act.append(exception.toString());
            return jumlahkamarterisi;
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
    public int getJumlahKamarKeseluruhan() throws RemoteException {
        ui.act.append("Client Execute getJumlahKamarKeseluruhan \n");
        int jumlahkamarkeseluruhan = 0;
        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT count(id_kamar) from `kamar` ");

            

            while (result.next()) {
                jumlahkamarkeseluruhan= result.getInt(1);
                //list.add(kamar);
            }
            result.close();
            return jumlahkamarkeseluruhan;

        } catch (SQLException exception) {
            ui.act.append("getJumlahKamarKeseluruhan Error \n");
            ui.act.append(exception.toString());
            return jumlahkamarkeseluruhan;
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
