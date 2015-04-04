package carismainterface.server;

import carismainterface.entity.Rekammedikpenyakit;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public interface RekammedikpenyakitService {

    void insertRekamMedikPenyakit(Rekammedikpenyakit rp) throws RemoteException;

    List<Rekammedikpenyakit> getRekamMedikPenyakit(String idRm) throws RemoteException;
    
    void deleteRekammedikPenyakit(String idRm) throws RemoteException;
}