package carismainterface.server;

import carismainterface.entity.Antrian;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public interface AntrianService {

    Antrian insertAntrian(Antrian antrian) throws RemoteException;

    void updateAntrian(Antrian antrian) throws RemoteException;

    void hadirAntrian(String antrian) throws RemoteException;

    void deleteAntrian(Antrian antrian) throws RemoteException;

    Antrian getAntrian(String antrian) throws RemoteException;

    List<Antrian> getAntrian() throws RemoteException;
}
