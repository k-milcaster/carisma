package carismainterface.server;

import carismainterface.entity.Dokter;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public interface DokterService extends Remote {

    boolean insertDokter(Dokter dokter) throws RemoteException;

    boolean updateDokter(Dokter dokter) throws RemoteException;

    boolean deleteDokter(String dokter) throws RemoteException;

    Dokter getDokter(String dokter) throws RemoteException;

    List<Dokter> getDokter() throws RemoteException;
   
    String[] getIdNamaDokter (String username) throws RemoteException;
    
    public List<Dokter> getDokterByName(String nama) throws RemoteException;
    
    ArrayList getDokterById(String idDokter) throws RemoteException;
}
