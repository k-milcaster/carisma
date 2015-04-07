package carismainterface.server;

import carismainterface.entity.Obat;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author kepoterz
 */
public interface ObatService {
    void insertObat(Obat obat) throws RemoteException;

    void updateObat(Obat obat) throws RemoteException;

    void deleteObat(String idobat) throws RemoteException;

    Obat getObat(String idobat) throws RemoteException;

    List<Obat> getObat() throws RemoteException;
}
