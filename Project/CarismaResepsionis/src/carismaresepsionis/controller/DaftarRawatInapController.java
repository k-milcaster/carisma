/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import carismainterface.entity.*;
import carismainterface.server.*;
import java.rmi.RemoteException;

/**
 *
 * @author Vaio Sony
 */
public class DaftarRawatInapController {

    private PasienService pasienService;
    private PasienKamarService pasienKamarService;

    public DaftarRawatInapController(ClientSocket client) {
        this.pasienService = client.getPasienService();
        this.pasienKamarService = client.getPasienKamarService();

    }

    public void insertPasienKamar(String namaPasien, String idPasien, String namaKamar, String kelasKamar, String tarif) throws RemoteException {
        PasienKamar pasienKamar = new PasienKamar();
        pasienKamarService.insertPasienKamar(pasienKamar);
    }

    public void getNamaPasien() throws RemoteException {
        Pasien ambilPasien = new Pasien();
        pasienService.getPasien();
    }
}
