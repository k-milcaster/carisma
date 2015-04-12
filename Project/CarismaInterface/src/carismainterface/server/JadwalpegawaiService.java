package carismainterface.server;

import carismainterface.entity.Jadwalpegawai;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public interface JadwalpegawaiService extends Remote {

    void insertJadwalpegawai(Jadwalpegawai jadwalpegawai) throws RemoteException;

    void updateJadwalpegawai(Jadwalpegawai jadwalpegawai) throws RemoteException;

    void deleteJadwalpegawai(String idjadwalpegawai) throws RemoteException;

    Jadwalpegawai getJadwalpegawai(String idjadwalpegawai) throws RemoteException;

    List<Jadwalpegawai> getJadwalpegawai() throws RemoteException;
}
