package carismainterface.server;

import carismainterface.entity.Kota;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public interface KotaService {

    void insertKota(Kota kota) throws RemoteException;

    void deleteKota(String kota) throws RemoteException;

    Kota getKota(String kota) throws RemoteException;

    List<Kota> getKota() throws RemoteException;
}
