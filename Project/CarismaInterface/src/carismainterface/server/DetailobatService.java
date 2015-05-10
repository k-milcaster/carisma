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
    boolean insertDetailobat(Detailobat detailobat) throws RemoteException;

    boolean updateDetailobat(Detailobat detailobat) throws RemoteException;

    boolean deleteDetailobat(int iddetailobat) throws RemoteException;

    Detailobat getDetailobat(int iddetailobat) throws RemoteException;
    
    List<Detailobat> getDetailobatbyIdObat(int idobat) throws RemoteException;

    List<Detailobat> getDetailobat() throws RemoteException;
    
    int getLastIdDetailObat() throws RemoteException;
}
