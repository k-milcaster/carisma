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
    private RekammedikpenyakitService rekamMedisPenyakit;
    private ObatService obatService;
    private PenyakitService penyakitService;
    private DokterService dokterService;
    private PasienService pasienService;
    private KunjunganService kunjunganService;
    private AntrianService antrianService;

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
            detailResepService = (DetailresepService) registry.lookup("detailresepRequest");
            rekamMedisPenyakit = (RekammedikpenyakitService) registry.lookup("rekammedikpenyakitRequest");
            obatService = (ObatService) registry.lookup("obatRequest");
            penyakitService = (PenyakitService) registry.lookup("penyakitRequest");
            dokterService = (DokterService) registry.lookup("dokterRequest");
            pasienService = (PasienService) registry.lookup("pasienRequest");
            kunjunganService = (KunjunganService) registry.lookup("kunjunganRequest");
            antrianService = (AntrianService) registry.lookup("antrianRequest");
        } catch (RemoteException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public UserService getUserService() {
        return this.userService;
    }

    public RekammedikService getRekamMedikService() {
        return this.rekamMedik;
    }

    public ResepService getResepService() {
        return this.resepService;
    }

    public DetailresepService getDetailResepService() {
        return detailResepService;
    }

    public RekammedikpenyakitService getRekamMedisPenyakitService() {
        return rekamMedisPenyakit;
    }

    public ObatService getObatService() {
        return obatService;
    }

    public PenyakitService getPenyakitService() {
        return penyakitService;
    }

    public DokterService getDokterService() {
        return dokterService;
    }

    public PasienService getPasienService() {
        return pasienService;
    }

    public KunjunganService getKunjunganService() {
        return kunjunganService;
    }

    public AntrianService getAntrianService() {
        return antrianService;
    }
}
