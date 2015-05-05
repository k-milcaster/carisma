package carismainterface.server;

import carismainterface.entity.Absensidokter;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author kepoterz
 */
public interface AbsensidokterService extends Remote {
    boolean insertAbsensidokter(Absensidokter absensidokter) throws RemoteException;

    boolean updateAbsensidokter(Absensidokter absensidokter) throws RemoteException;

    boolean deleteAbsensidokter(String idabsensidokter) throws RemoteException;

    Absensidokter getAbsensidokter(String dokteriddokter) throws RemoteException;

    List<Absensidokter> getAbsensidokter() throws RemoteException;
}
