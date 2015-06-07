package carismaadministrator.controller;

import carismainterface.server.*;
import carismaadministrator.boundary.*;
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
    private AbsensidokterService absensiDokterService;
    private AbsensipegawaiService absensiPegawaiService;
    private DokterService dokterService;
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
            absensiDokterService = (AbsensidokterService) registry.lookup("absensiDokterRequest");
            absensiPegawaiService = (AbsensipegawaiService) registry.lookup("absensiPegawaiRequest");
            dokterService = (DokterService) registry.lookup("dokterRequest");
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

    public AbsensidokterService getAbsensiDokterService() {
        return absensiDokterService;
    }

    public AbsensipegawaiService getAbsensiPegawaiService() {
        return absensiPegawaiService;
    }

    public DokterService getDokterService() {
        return dokterService;
    }

    public PegawaiService getPegawaiService() {
        return pegawaiService;
    }
}
