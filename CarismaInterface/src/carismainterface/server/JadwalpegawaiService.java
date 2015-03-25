package carismainterface.server;

import carismainterface.entity.Jadwalpegawai;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public interface JadwalpegawaiService {

    void insertJadwalPegawai(Jadwalpegawai jp) throws RemoteException;

    void deleteJadwalPegawai(String jp) throws RemoteException;

    void updateJadwalPegawai(String jp) throws RemoteException;

    List<Jadwalpegawai> getJadwalPegawai(String jp) throws RemoteException;

    List<Jadwalpegawai> getJadwalPegawai() throws RemoteException;
}
