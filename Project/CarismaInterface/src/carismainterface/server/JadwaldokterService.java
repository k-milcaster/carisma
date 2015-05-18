package carismainterface.server;

import carismainterface.entity.Jadwaldokter;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author kepoterz
 */
public interface JadwaldokterService extends Remote {
    boolean insertJadwaldokter(Jadwaldokter jadwaldokter) throws RemoteException;

    boolean updateJadwaldokter(Jadwaldokter jadwaldokter) throws RemoteException;

    boolean deleteJadwaldokter(String idjadwaldokter) throws RemoteException;

    List<Jadwaldokter> getJadwaldokter(String idjadwaldokter) throws RemoteException;

    List<Jadwaldokter> getJadwaldokter() throws RemoteException;
}
