package carismadokter.controller;

import carismainterface.server.*;
import carismadokter.boundaries.*;
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
    private RekammedikService rekamMedik;
    private ResepService resepService;
    private DetailresepService detailResepService;
    private PenyakitService penyakitService;

    public ClientSocket() throws RemoteException, NotBoundException {
        this.Connect();
    }

    public void Connect() {
        try {
            Registry registry = null;
            try {
                registry = LocateRegistry.getRegistry(host, port);
            } catch (RemoteException ex) {
                Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
            userService = (UserService) registry.lookup("userRequest");//objek untuk manggil method
            rekamMedik = (RekammedikService) registry.lookup("rekammedikRequest");
            resepService = (ResepService) registry.lookup("resepRequest");
            detailResepService = (DetailresepService) registry.lookup("detailResepRequest");
            
        } catch (RemoteException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public UserService getUserService() {
        return this.userService;
    }
    
    public RekammedikService getRekamMedikService(){
        return this.rekamMedik;
    }
    
    public ResepService getResepService(){
        return this.resepService;
    }
    
    public DetailresepService getDetailResepService(){
        return detailResepService;
    }
}
