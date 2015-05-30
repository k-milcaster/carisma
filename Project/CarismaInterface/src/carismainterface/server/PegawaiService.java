package carismainterface.server;

import carismainterface.entity.Pegawai;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public interface PegawaiService extends Remote {
    
    boolean insertPegawai(Pegawai pegawai) throws RemoteException;

    boolean updatePegawai(Pegawai pegawai) throws RemoteException;

    boolean deletePegawai(String pegawai) throws RemoteException;

    Pegawai getPegawai(String pegawai) throws RemoteException;

    List<Pegawai> getPegawai() throws RemoteException;
    
    String[] getIdNamaPegawai (String username) throws RemoteException;
}
