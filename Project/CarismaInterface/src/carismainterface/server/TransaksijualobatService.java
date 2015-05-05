package carismainterface.server;

import carismainterface.entity.Transaksijualobat;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author kepoterz
 */
public interface TransaksijualobatService extends Remote {
    boolean insertTransaksijualobat(Transaksijualobat transaksijualobat) throws RemoteException;

    boolean updateTransaksijualobat(Transaksijualobat transaksijualobat) throws RemoteException;

    boolean deleteTransaksijualobat(String idtransaksijualobat) throws RemoteException;

    Transaksijualobat getTransaksijualobat(String idtransaksijualobat) throws RemoteException;

    List<Transaksijualobat> getTransaksijualobat() throws RemoteException;
}
