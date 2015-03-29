package carismainterface.server;
import carismainterface.entity.Kunjungan;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author K-MiL Caster
 */
public interface KunjunganService {
    
    void insertKunjungan(Kunjungan kunjungan) throws RemoteException;

    List<Kunjungan> getKunjunganByPasien(String idPasien) throws RemoteException;
    
    Kunjungan getKunjungan(String kunjungan) throws RemoteException;

    List<Kunjungan> getKunjungan() throws RemoteException;
}
