/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismainterface.server;

import carismainterface.entity.Rakobat;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author kepoterz
 */
public interface RakobatService extends Remote {
    void insertRakobat(Rakobat rakobat) throws RemoteException;

    void updateRakobat(Rakobat rakobat) throws RemoteException;

    void deleteRakobat(int idrakobat) throws RemoteException;

    Rakobat getRakobat(int idrakobat) throws RemoteException;

    List<Rakobat> getRakobat() throws RemoteException;
}
