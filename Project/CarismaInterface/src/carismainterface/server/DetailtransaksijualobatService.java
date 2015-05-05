package carismainterface.server;

import carismainterface.entity.Detailtransaksijualobat;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author kepoterz
 */
public interface DetailtransaksijualobatService extends Remote {

    boolean insertDetailtransaksijualobat(Detailtransaksijualobat detailtransaksijualobat) throws RemoteException;

    boolean updateDetailtransaksijualobat(Detailtransaksijualobat detailtransaksijualobat) throws RemoteException;

    boolean deleteDetailtransaksijualobat(String idtransaksijualobat, int idobat) throws RemoteException;

    Detailtransaksijualobat getDetailtransaksijualobat(String idtransaksijualobat, int idobat) throws RemoteException;

    List<Detailtransaksijualobat> getDetailtransaksijualobat() throws RemoteException;
}
