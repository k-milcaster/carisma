/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismainterface.server;

import carismainterface.entity.Transaksijualobat;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author kepoterz
 */
public interface TransaksijualobatService extends Remote {
    void insertTransaksijualbat(Transaksijualobat transaksijualobat) throws RemoteException;

    void updateTransaksijualobat(Transaksijualobat transaksijualobat) throws RemoteException;

    void deleteTransaksijualobat(String idtransaksijualobat) throws RemoteException;

    Transaksijualobat getTransaksijualobat(String idtransaksijualobat) throws RemoteException;

    List<Transaksijualobat> getTransaksijualobat() throws RemoteException;
}
