package carismainterface.server;

import carismainterface.entity.Dokter;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public interface DokterService extends Remote {

    void insertDokter(Dokter dokter) throws RemoteException;

    void updateDokter(Dokter dokter) throws RemoteException;

    void deleteDokter(String dokter) throws RemoteException;

    Dokter getDokter(String dokter) throws RemoteException;

    List<Dokter> getDokter() throws RemoteException;
    
    String[] getIdNamaDokter (String username) throws RemoteException;
}
