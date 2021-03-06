/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismainterface.server;

import carismainterface.entity.PasienKamar;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author kepoterz
 */
public interface PasienKamarService extends Remote {
    boolean insertPasienKamar(PasienKamar pasienKamar) throws RemoteException;

    boolean updatePasienKamar(PasienKamar pasienKamar) throws RemoteException;

    boolean deletePasienKamar(String idpeminjaman) throws RemoteException;

    PasienKamar getPasienKamar(String idpeminjaman) throws RemoteException;

    List<PasienKamar> getPasienKamar() throws RemoteException;
}
