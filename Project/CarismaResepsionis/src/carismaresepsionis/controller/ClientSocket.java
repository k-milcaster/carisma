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

    private String host = "";
    private int port = 0;
    public Login login;
    private UserService userService;
    private PasienService pasienService;
    private AntrianService antrianService;
    private KunjunganService kunjunganService;
    private KotaService kotaService;
    private DokterService dokterService;
    private JadwalService jadwalService;
    private JadwaldokterService jadwaldokterService;
    private PoliService poliService;
    private KamarService kamarService;
    private PasienKamarService pasienkamarService;
    private PegawaiService pegawaiService;
    //private KunjunganService kunjunganService;

    public ClientSocket(String host, int port) throws RemoteException, NotBoundException {
        this.host = host;
        this.port = port;
    }
    
    public ClientSocket() throws RemoteException{
        this.Connect();
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
            pasienService = (PasienService) registry.lookup("pasienRequest");
            antrianService = (AntrianService) registry.lookup("antrianRequest");
            kunjunganService = (KunjunganService) registry.lookup("kunjunganRequest");
            kotaService = (KotaService) registry.lookup("kotaRequest");
            dokterService = (DokterService) registry.lookup("dokterRequest");
            jadwalService = (JadwalService) registry.lookup("jadwalRequest");
            jadwaldokterService = (JadwaldokterService) registry.lookup("jadwaldokterRequest");
            poliService = (PoliService) registry.lookup("poliRequest");
            kamarService = (KamarService) registry.lookup("kamarRequest");
            pasienkamarService = (PasienKamarService) registry.lookup("pasienkamarRequest");
            pegawaiService = (PegawaiService) registry.lookup("pegawaiRequest");
            //kunjunganService = (KunjunganService) registry.lookup("kunjunganRequest");
        } catch (RemoteException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public UserService getUserService() {
        return this.userService;
    }

    public PasienService getPasienService() {
        return this.pasienService;
    }

    public AntrianService getAntrianService() {
        return this.antrianService;
    }

    public KunjunganService getKunjunganService() {
        return this.kunjunganService;
    }

    public KotaService getKotaService() {
        return this.kotaService;
    }

    public DokterService getDokterService() {
        return this.dokterService;
    }

    public JadwalService getJadwalService() {
        return this.jadwalService;
    }

    public JadwaldokterService getJadwaldokterService() {
        return this.jadwaldokterService;
    }

    public PoliService getPoliService() {
        return this.poliService;
    }

    public KamarService getKamarService() {
        return this.kamarService;
    }

    public PasienKamarService getPasienKamarService() {
        return this.pasienkamarService;
    }

    public PegawaiService getPegawaiService() {
        return this.pegawaiService;
    }
    
    
}
