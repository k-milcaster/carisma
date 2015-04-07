package carismainterface.server;

import carismainterface.entity.Detailobat;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public interface DetailobatService {
    void insertDetailobat(Detailobat detailobat) throws RemoteException;

    void updateDetailobat(Detailobat detailobat) throws RemoteException;

    void deleteDetailobat(int iddetailobat) throws RemoteException;

    Detailobat getDetailobat(int iddetailobat) throws RemoteException;

    List<Detailobat> getDetailobat() throws RemoteException;
}
