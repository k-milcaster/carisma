package carismainterface.server;

import carismainterface.entity.Detailresep;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public interface DetailresepService {

    void insertDetailresep(Detailresep detailResep) throws RemoteException;

    List<Detailresep> getDetailresep(String idResep) throws RemoteException;

    List<Detailresep> getDetailresepByPasien(String idPasien) throws RemoteException;
}
