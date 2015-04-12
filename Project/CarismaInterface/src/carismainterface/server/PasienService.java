package carismainterface.server;

import carismainterface.entity.Pasien;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public interface PasienService extends Remote {

    void insertPasien(Pasien pasien) throws RemoteException;

    void updatePasien(Pasien pasien) throws RemoteException;

    void deletePasien(String pasien) throws RemoteException;

    Pasien getPasien(String pasien) throws RemoteException;

    List<Pasien> getPasien() throws RemoteException;
    
    List<Pasien> getPasienByName(String pasien) throws RemoteException;
}
