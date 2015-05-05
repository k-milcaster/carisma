package carismainterface.server;

import carismainterface.entity.Rakobat;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author kepoterz
 */
public interface RakobatService extends Remote {
    boolean insertRakobat(Rakobat rakobat) throws RemoteException;

    boolean updateRakobat(Rakobat rakobat) throws RemoteException;

    boolean deleteRakobat(int idrakobat) throws RemoteException;

    Rakobat getRakobat(int idrakobat) throws RemoteException;

    List<Rakobat> getRakobat() throws RemoteException;
}
