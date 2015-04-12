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

    Kota getKota(String idkota) throws RemoteException;

    List<Kota> getKota() throws RemoteException;
}
