package carismainterface.server;

import carismainterface.entity.Obat;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author kepoterz
 */
public interface ObatService extends Remote {
    void insertObat(Obat obat) throws RemoteException;

    void updateObat(Obat obat) throws RemoteException;

    void deleteObat(String idobat) throws RemoteException;

    Obat getObat(String idobat) throws RemoteException;
    
    Obat getObatbyName(String namaobat) throws RemoteException;

    List<Obat> getObat() throws RemoteException;
}
