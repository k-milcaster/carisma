package carismaresepsionis.controller;
import carismainterface.server.*;
import carismaresepsionis.boundaries.*;
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
    private PasienService pasienService;
    private AntrianService antrianService;
    private KunjunganService kunjunganService;
    private KotaService kotaService;
    private DokterService dokterService;
    
    public ClientSocket() throws RemoteException, NotBoundException{
        this.Connect();
    }
    public void Connect(){
        try {
            Registry registry = null;
            try {
                registry = LocateRegistry.getRegistry(host, port);
            } catch (RemoteException ex) {
                Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
            }            
            userService = (UserService) registry.lookup("userRequest");
            pasienService = (PasienService) registry.lookup("pasienRequest");                                   
            antrianService = (AntrianService) registry.lookup("antrianRequest");
            kunjunganService = (KunjunganService)registry.lookup("kunjunganRequest"); 
            kotaService = (KotaService) registry.lookup("kotaRequest");
            dokterService = (DokterService) registry.lookup("dokterRequest");

        } catch (RemoteException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public UserService getUserService(){
        return this.userService;        
    }
    
    public PasienService getPasienService(){
        return this.pasienService;        
    }
    public AntrianService getAntrianService(){
        return this.antrianService;
    }
    public KunjunganService getKunjunganService(){
        return this.kunjunganService;
    }
    public KotaService getKotaService(){
        return this.kotaService;
    }
    public DokterService getDokterService(){
        return this.dokterService;
    }
}
