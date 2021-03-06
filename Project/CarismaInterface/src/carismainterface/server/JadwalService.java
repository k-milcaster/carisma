package carismainterface.server;

import carismainterface.entity.Jadwal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author kepoterz
 */
public interface JadwalService extends Remote {
    boolean insertJadwal(Jadwal jadwal) throws RemoteException;

    boolean updateJadwal(Jadwal jadwal) throws RemoteException;

    boolean deleteJadwal(String idjadwal) throws RemoteException;

    Jadwal getJadwal(String idjadwal) throws RemoteException;

    List<Jadwal> getJadwal() throws RemoteException;
    
    List<Jadwal> getJadwalDokterbyIdDokter(String iddokter) throws RemoteException;
}
