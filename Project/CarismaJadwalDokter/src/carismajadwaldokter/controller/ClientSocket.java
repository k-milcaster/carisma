package carismajadwaldokter.controller;

import carismainterface.server.*;
import java.rmi.AccessException;
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
    private JadwaldokterService melihatjadwaldokterService;
    
    public ClientSocket() throws RemoteException, NotBoundException {
        this.Connect();
    }

    public void Connect() throws AccessException {
        Registry registry = null;
        try {
            registry = LocateRegistry.getRegistry(host, port);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            melihatjadwaldokterService = (JadwaldokterService) registry.lookup("melihatjadwaldokterRequest");
            
        } catch (RemoteException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public JadwaldokterService getJadwaldokterService(){
        return this.melihatjadwaldokterService;
    }
}
