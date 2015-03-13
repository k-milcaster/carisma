package carismainterface.server;

import carismainterface.entity.Rekammedik;
import carismainterface.entity.User;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public interface RekammedikService {

    User insertRekamMedik(Rekammedik rekamMedik) throws RemoteException;

    void updateRekamMedik(Rekammedik rekamMedik) throws RemoteException;

    void deleteRekamMedik(String rekamMedik) throws RemoteException;

    Rekammedik getRekamMedik(String rekamMedik) throws RemoteException;
    
    List<Rekammedik> getRekamMedikByPasien(String pasien) throws RemoteException;
    
    List<Rekammedik> getRekamMedikByTahun(String tahun) throws RemoteException;
    
    List<Rekammedik> getRekamMedikByBulan(String bulan) throws RemoteException;
    
    List<Rekammedik> getRekamMedikByTahun(String pasien, String tahun) throws RemoteException;
    
    List<Rekammedik> getRekamMedikByBulan(String pasien, String bulan) throws RemoteException;    

    List<Rekammedik> getRekamMedik() throws RemoteException;
}
