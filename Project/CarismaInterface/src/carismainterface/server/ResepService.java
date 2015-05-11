package carismainterface.server;

import carismainterface.entity.Resep;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author K-MiL Caster
 */
public interface ResepService extends Remote {

    boolean insertResep(Resep resep) throws RemoteException;
    
    boolean deletedResep(String idResep) throws RemoteException;
    
    String getLastIdResep() throws RemoteException;
}
