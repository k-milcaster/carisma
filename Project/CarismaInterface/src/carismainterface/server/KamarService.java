package carismainterface.server;

import carismainterface.entity.Kamar;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author kepoterz
 */
public interface KamarService extends Remote {
    boolean insertKamar(Kamar kamar) throws RemoteException;

    boolean updateKamar(Kamar kamar) throws RemoteException;

    boolean deleteKamar(String idkamar) throws RemoteException;

    Kamar getKamar(String idkamar) throws RemoteException;

    List<Kamar> getKamar() throws RemoteException;
}
