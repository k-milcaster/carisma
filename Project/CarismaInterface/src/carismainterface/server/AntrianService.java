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

    void insertAntrian(Antrian antrian) throws RemoteException;

    void deleteAntrian(String antrian) throws RemoteException;
    
    void antrianHadir(String antrian) throws RemoteException;

    Antrian getAntrian(String antrian) throws RemoteException;

    List<Antrian> getAntrian() throws RemoteException;
}
