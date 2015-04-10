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

    void insertKartuPasien(Kartupasien kp) throws RemoteException;

    void deleteKartuPasien(String kp) throws RemoteException;

    Kartupasien getKartuPasien(String kp) throws RemoteException;

    List<Kartupasien> getKartuPasien() throws RemoteException;
}
