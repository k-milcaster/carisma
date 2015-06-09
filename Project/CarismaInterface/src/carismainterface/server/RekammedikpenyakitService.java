package carismainterface.server;

import carismainterface.entity.Rekammedikpenyakit;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public interface RekammedikpenyakitService extends Remote {

    boolean insertRekamMedikPenyakit(Rekammedikpenyakit rp) throws RemoteException;

    List<Rekammedikpenyakit> getPenyakitPasien(String idRekammedik) throws RemoteException;
    
    boolean deleteRekammedikPenyakit(String idRm) throws RemoteException;
}
