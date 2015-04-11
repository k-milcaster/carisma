package carismainterface.server;

import carismainterface.entity.Detailobat;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public interface DetailobatService extends Remote {
    void insertDetailobat(Detailobat detailobat) throws RemoteException;

    void updateDetailobat(Detailobat detailobat) throws RemoteException;

    void deleteDetailobat(int iddetailobat) throws RemoteException;

    Detailobat getDetailobat(int iddetailobat) throws RemoteException;
    
    Detailobat getDetailobatbyIdObat(int idobat) throws RemoteException;

    List<Detailobat> getDetailobat() throws RemoteException;
}
