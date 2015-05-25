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

    boolean insertPasien(Pasien pasien) throws RemoteException;

    boolean updatePasien(Pasien pasien) throws RemoteException;

    boolean deletePasien(String pasien) throws RemoteException;

    Pasien getPasien(String pasien) throws RemoteException;

    List<Pasien> getPasien() throws RemoteException;
    
    List<Pasien> getPasienByName(String pasien) throws RemoteException;
    
    List<Pasien> getPasienRawatinap() throws RemoteException;
    
    boolean isUsedNokartuPasien(String nokartuidpasien) throws RemoteException;
    
    List<Pasien> getPasienRawatinapByName(String pasien) throws RemoteException;
}
