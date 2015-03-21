package carismainterface.server;

import carismainterface.entity.Penyakit;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public interface PenyakitService {
    
    void insertPenyakit(Penyakit penyakit) throws RemoteException;

    void deletePenyakit(String penyakit) throws RemoteException;

    Penyakit getPenyakit(String penyakit) throws RemoteException;

    List<Penyakit> getPenyakit() throws RemoteException;
}
