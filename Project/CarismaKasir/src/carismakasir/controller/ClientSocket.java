package carismakasir.controller;

import carismainterface.server.*;
import carismakasir.boundary.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author K-MiL Caster
 */
public class ClientSocket {

    private String host = "localhost";
    private int port = 2015;
    public Login login;
    private UserService userService;
    private PembayaranService pembayaranService;
    private KunjunganService kunjunganService;
    private PegawaiService pegawaiService;

    public ClientSocket() throws RemoteException, NotBoundException {
        this.Connect();
    }

    public ClientSocket(String host, int port) throws RemoteException, NotBoundException {
        this.host = host;
        this.port = port;
    }

    public boolean testConnection() {
        try {
            Registry registry = null;
            try {
                registry = LocateRegistry.getRegistry(host, port);
            } catch (RemoteException ex) {
                Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
            userService = (UserService) registry.lookup("userRequest");
            return true;
        } catch (RemoteException ex) {

            return false;
        } catch (NotBoundException ex) {

            return false;
        }
    }

    public void Connect() {
        try {
            Registry registry = null;
            try {
                registry = LocateRegistry.getRegistry(host, port);
            } catch (RemoteException ex) {
                Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
            userService = (UserService) registry.lookup("userRequest");
            pembayaranService = (PembayaranService) registry.lookup("pembayaranRequest");
            kunjunganService = (KunjunganService) registry.lookup("kunjunganRequest");
            pegawaiService = (PegawaiService) registry.lookup("pegawaiRequest");

        } catch (RemoteException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public UserService getUserService() {
        return this.userService;
    }

    public PembayaranService getPembayaranService() {
        return this.pembayaranService;
    }

    public KunjunganService getKunjunganService() {
        return this.kunjunganService;
    }

    public PegawaiService getPegawaiService() {
        return this.pegawaiService;
    }
}
