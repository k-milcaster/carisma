package carismaapoteker.controller;

import carismainterface.server.*;
import carismaapoteker.boundaries.*;
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
    private TransaksibeliobatService transaksibeliobatService;
    private TransaksijualobatService transaksijualobatService;
    private ObatService obatService;
    private DetailtransaksijualobatService detailtransaksiService;
    private DetailobatService detailobatService;
    private DetailtransaksibeliobatService detailtransaksibeliobatService;
    private PegawaiService pegawaiService;
    private KunjunganService kunjunganService;

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
            transaksibeliobatService = (TransaksibeliobatService) registry.lookup("transaksibeliobatRequest");
            obatService = (ObatService) registry.lookup("obatRequest");
            transaksijualobatService = (TransaksijualobatService) registry.lookup("transaksijualobatRequest");
            detailtransaksiService = (DetailtransaksijualobatService) registry.lookup("detailtransaksijualobatRequest");
            detailobatService = (DetailobatService) registry.lookup("detailobatRequest");
            detailtransaksibeliobatService = (DetailtransaksibeliobatService) registry.lookup("detailtransaksibeliobatRequest");
            pegawaiService = (PegawaiService) registry.lookup("pegawaiRequest");
            kunjunganService = (KunjunganService) registry.lookup("kunjunganRequest");
        } catch (RemoteException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public KunjunganService getKunjunganService() {
        return this.kunjunganService;
    }

    public UserService getUserService() {
        return this.userService;
    }

    public TransaksibeliobatService getTransaksibeliobatService() {
        return this.transaksibeliobatService;
    }

    public ObatService getObatService() {
        return this.obatService;
    }

    public TransaksijualobatService getTransaksijualobatService() {
        return this.transaksijualobatService;
    }

    public DetailtransaksijualobatService getDetailtransaksijualobatService() {
        return this.detailtransaksiService;
    }

    public DetailobatService getDetailonatSerivice() {
        return this.detailobatService;
    }

    public DetailtransaksibeliobatService getDetailtransaksibeliobatService() {
        return this.detailtransaksibeliobatService;
    }

    public PegawaiService getPegawaiService() {
        return this.pegawaiService;
    }
    
}
