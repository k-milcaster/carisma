package carismainterface.server;

import carismainterface.entity.Penyakit;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public interface PenyakitService extends Remote {
    
    boolean insertPenyakit(Penyakit penyakit) throws RemoteException;

    boolean updatePenyakit(Penyakit penyakit) throws RemoteException;
    
    boolean deletePenyakit(String idpenyakit) throws RemoteException;

    Penyakit getPenyakit(String idpenyakit) throws RemoteException;

    List<Penyakit> getPenyakit() throws RemoteException;
}
