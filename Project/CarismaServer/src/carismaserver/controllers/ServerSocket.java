package carismaserver.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import carismaserver.boundaries.Main;
import carismaserver.entity.*;

/**
 *
 * @author K-MiL Caster
 */
public class ServerSocket {

    private final int port = 2015;
    public Main ui;
    private Registry server = null;

    public ServerSocket(Main ui) {
        this.ui = ui;
    }

    public void Start() throws UnknownHostException {
        ui.portLabel.setText("" + port);
        ui.iPLabel.setText("" + InetAddress.getLocalHost());
        try {
            server = LocateRegistry.createRegistry(port);

            AntrianEntity antrian = new AntrianEntity(ui);
            DetailobatEntity detailobat = new DetailobatEntity(ui);
            DetailresepEntity detailresep = new DetailresepEntity(ui);
            DetailtransaksijualobatEntity detailtransaksijualobat = new DetailtransaksijualobatEntity(ui);
            DetailtransaksibeliobatEntity detailtransaksibeliobat = new DetailtransaksibeliobatEntity(ui);
            DokterEntity dokter = new DokterEntity(ui);
            JadwalEntity jadwal = new JadwalEntity(ui);
            JadwaldokterEntity jadwaldokter = new JadwaldokterEntity(ui);
            JadwalpegawaiEntity jadwalpegawai = new JadwalpegawaiEntity(ui);
            KamarEntity kamar = new KamarEntity(ui);
            KunjunganEntity kunjungan = new KunjunganEntity(ui);
            ObatEntity obat = new ObatEntity(ui);
            PasienEntity pasien = new PasienEntity(ui);
            PasienKamarEntity pasienkamar = new PasienKamarEntity(ui);
            RakobatEntity rakobat = new RakobatEntity(ui);
            RekammedikEntity rekammedik = new RekammedikEntity(ui);
            RekammedikpenyakitEntity rekammedikpenyakit = new RekammedikpenyakitEntity(ui);
            ResepEntity resep = new ResepEntity(ui);
            PegawaiEntity staff = new PegawaiEntity(ui);
            TransaksibeliobatEntity transaksibeliobat = new TransaksibeliobatEntity(ui);
            TransaksijualobatEntity transaksijualobat = new TransaksijualobatEntity(ui);
            UserEntity user = new UserEntity(ui);
            PenyakitEntity penyakit = new PenyakitEntity(ui);
            KotaEntity kota = new KotaEntity(ui);
            ProvinsiEntity provinsi = new ProvinsiEntity(ui);
            PoliEntity poli = new PoliEntity(ui);

            server.rebind("userRequest", user);
            server.rebind("antrianRequest", antrian);
            server.rebind("detailobatRequest", detailobat);
            server.rebind("detailresepRequest", detailresep);
            server.rebind("detailtransaksijualobatRequest", detailtransaksijualobat);
            server.rebind("detailtransaksibeliobatRequest", detailtransaksibeliobat);
            server.rebind("dokterRequest", dokter);
            server.rebind("jadwalRequest", jadwal);
            server.rebind("jadwaldokterRequest", jadwaldokter);
            server.rebind("jadwalpegawaiRequest", jadwalpegawai);
            server.rebind("kamarRequest", kamar);
            server.rebind("kunjunganRequest", kunjungan);
            server.rebind("obatRequest", obat);
            server.rebind("pasienRequest", pasien);
            server.rebind("pasienkamarRequest", pasienkamar);
            server.rebind("rakobatRequest", rakobat);
            server.rebind("rekammedikRequest", rekammedik);
            server.rebind("rekammedikpenyakitRequest", rekammedikpenyakit);
            server.rebind("resepRequest", resep);
            server.rebind("staffRequest", staff);
            server.rebind("transaksibeliobatRequest", transaksibeliobat);
            server.rebind("transaksijualobatRequest", transaksijualobat);
            server.rebind("penyakitRequest", penyakit);
            server.rebind("kotaRequest", kota);
            server.rebind("provinsiRequest", provinsi);
            server.rebind("poliRequest", poli);
                    
            ui.act.append("Server Started \n");
        } catch (RemoteException ex) {
            Logger.getLogger(ServerSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Close() throws RemoteException, NotBoundException {
        server.unbind("userRequest");
        server.unbind("antrianRequest");
        server.unbind("detailobatRequest");
        server.unbind("detailresepRequest");
        server.unbind("detailtransaksijualobatRequest");
        server.unbind("detailtransaksibeliobatRequest");
        server.unbind("dokterRequest");
        server.unbind("jadwalRequest");
        server.unbind("jadwaldokterRequest");
        server.unbind("jadwalpegawaiRequest");
        server.unbind("kamarRequest");
        server.unbind("kunjunganRequest");
        server.unbind("obatRequest");
        server.unbind("pasienRequest");
        server.unbind("pasienkamarRequest");
        server.unbind("rakobatRequest");
        server.unbind("rekammedikRequest");
        server.unbind("rekammedikpenyakitRequest");
        server.unbind("resepRequest");
        server.unbind("staffRequest");
        server.unbind("transaksibeliobatRequest");
        server.unbind("transaksijualobatRequest");
        server.unbind("penyakitRequest");
        server.unbind("kotaRequest");
        server.unbind("provinsiRequest");
        server.unbind("poliRequest");
        
        ui.act.append("Server Stopped \n");
    }
}
