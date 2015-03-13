package carismainterface.server;

import carismainterface.entity.Pegawai;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public interface PegawaiService {
    
    Pegawai insertPegawai(Pegawai pegawai) throws RemoteException;

    void updatePegawai(Pegawai pegawai) throws RemoteException;

    void deletePegawai(Pegawai pegawai) throws RemoteException;

    Pegawai getPegawai(String pegawai) throws RemoteException;

    List<Pegawai> getPegawai() throws RemoteException;
}
