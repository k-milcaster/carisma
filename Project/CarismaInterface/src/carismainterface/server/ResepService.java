package carismainterface.server;

import carismainterface.entity.Resep;
import java.rmi.RemoteException;

/**
 *
 * @author K-MiL Caster
 */
public interface ResepService {

    void insertResep(Resep resep) throws RemoteException;
    
}
