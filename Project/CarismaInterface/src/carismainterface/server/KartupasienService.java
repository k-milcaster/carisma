package carismainterface.server;

import carismainterface.entity.Kartupasien;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public interface KartupasienService extends Remote {

    boolean insertKartuPasien(Kartupasien kp) throws RemoteException;

    boolean deleteKartuPasien(String kp) throws RemoteException;

    Kartupasien getKartuPasien(String kp) throws RemoteException;

    List<Kartupasien> getKartuPasien() throws RemoteException;
}
