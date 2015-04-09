package carismajadwaldokter.controller;

import carismainterface.server.*;
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

    public ClientSocket() throws RemoteException, NotBoundException {
        this.Connect();
    }

    public void Connect() {
        Registry registry = null;
        try {
            registry = LocateRegistry.getRegistry(host, port);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
