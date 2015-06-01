package carismainterface.server;

import carismainterface.entity.Antrian;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public interface AntrianService extends Remote {

    boolean insertAntrian(Antrian antrian) throws RemoteException;

    boolean deleteAntrian(String antrian) throws RemoteException;

    boolean antrianHadir(String antrian) throws RemoteException;

    boolean antrianTidakHadir(String antrian) throws RemoteException;
    
    int generateNomorAntrian(String tanggal) throws RemoteException; //tambah
    
    String generateIDAntrian() throws RemoteException;//tambah

    Antrian getAntrian(String antrian) throws RemoteException;

    List<Antrian> getAntrian() throws RemoteException;
}
