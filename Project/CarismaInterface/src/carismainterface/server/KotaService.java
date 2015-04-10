package carismainterface.server;

import carismainterface.entity.Kota;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public interface KotaService extends Remote {

    void insertKota(Kota kota) throws RemoteException;

    void deleteKota(String kota) throws RemoteException;

    Kota getKota(String kota) throws RemoteException;

    List<Kota> getKota() throws RemoteException;
}
