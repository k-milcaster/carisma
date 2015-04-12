/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismainterface.server;

import carismainterface.entity.Jadwaldokter;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author kepoterz
 */
public interface JadwaldokterService extends Remote {
    void insertJadwaldokter(Jadwaldokter jadwaldokter) throws RemoteException;

    void updateJadwaldokter(Jadwaldokter jadwaldokter) throws RemoteException;

    void deleteJadwaldokter(String idjadwaldokter) throws RemoteException;

    Jadwaldokter getJadwaldokter(String idjadwaldokter) throws RemoteException;

    List<Jadwaldokter> getJadwaldokter() throws RemoteException;
}
