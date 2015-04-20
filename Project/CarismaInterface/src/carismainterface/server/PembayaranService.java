package carismainterface.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author K-MiL Caster
 */
public interface PembayaranService extends Remote {

    ArrayList getBiayaKamar(String idPeminjaman) throws RemoteException;

    ArrayList<ArrayList> getBiayaObat(String idTransaksi) throws RemoteException;

}
