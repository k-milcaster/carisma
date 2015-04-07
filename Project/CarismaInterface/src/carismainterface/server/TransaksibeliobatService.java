/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismainterface.server;

import carismainterface.entity.Transaksibeliobat;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author kepoterz
 */
public interface TransaksibeliobatService {
    void insertTransaksibelibat(Transaksibeliobat transaksibeliobat) throws RemoteException;

    void updateTransaksibeliobat(Transaksibeliobat transaksibeliobat) throws RemoteException;

    void deleteTransaksibeliobat(String idtransaksibeliobat) throws RemoteException;

    Transaksibeliobat getTransaksibeliobat(String idtransaksibeliobat) throws RemoteException;

    List<Transaksibeliobat> getTransaksibeliobat() throws RemoteException;
}
