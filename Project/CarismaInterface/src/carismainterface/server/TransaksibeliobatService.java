/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismainterface.server;

import carismainterface.entity.Transaksibeliobat;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author kepoterz
 */
public interface TransaksibeliobatService extends Remote {
    boolean insertTransaksibeliobat(Transaksibeliobat transaksibeliobat) throws RemoteException;

    boolean updateTransaksibeliobat(Transaksibeliobat transaksibeliobat) throws RemoteException;

    boolean deleteTransaksibeliobat(String idtransaksibeliobat) throws RemoteException;

    Transaksibeliobat getTransaksibeliobat(String idtransaksibeliobat) throws RemoteException;

    List<Transaksibeliobat> getTransaksibeliobat() throws RemoteException;
}
