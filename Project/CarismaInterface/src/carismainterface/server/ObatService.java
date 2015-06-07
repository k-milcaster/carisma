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
    boolean insertObat(Obat obat) throws RemoteException;

    boolean updateObat(Obat obat) throws RemoteException;

    boolean deleteObat(int idobat) throws RemoteException;

    Obat getObat(int idobat) throws RemoteException;
    
    Obat getIdObat(String namaObat) throws RemoteException;
    
    List<Obat> getObatbyName(String namaobat) throws RemoteException;

    List<Obat> getObat() throws RemoteException;
    
    int getLastIdObat() throws RemoteException;
    
    boolean updateQtyObat(int id, int qty) throws RemoteException;
    
    boolean updateStokJualObat(int idObat, int qty) throws RemoteException;
  
}
