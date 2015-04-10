package carismainterface.server;

import carismainterface.entity.Rekammedik;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public interface RekammedikService extends Remote {

    void insertRekamMedik(Rekammedik rekamMedik) throws RemoteException;

    void updateRekamMedik(Rekammedik rekamMedik) throws RemoteException;

    void deleteRekamMedik(String rekamMedik) throws RemoteException;

    Rekammedik getRekamMedik(String rekamMedik) throws RemoteException;
    
    List<Rekammedik> getRekamMedikByPasien(String pasien) throws RemoteException;
    
    List<Rekammedik> getRekamMedikByTahun(String tahun) throws RemoteException;
    
    List<Rekammedik> getRekamMedikByBulan(String bulan, String tahun) throws RemoteException;
    
    List<Rekammedik> getRekamMedikByTahun(String bulan, String tahun, String pasien) throws RemoteException;    

    List<Rekammedik> getRekamMedik() throws RemoteException;
}
