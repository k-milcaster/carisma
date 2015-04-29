/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismainterface.server;

import carismainterface.entity.Jadwal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author kepoterz
 */
public interface JadwalService extends Remote {
    void insertJadwal(Jadwal jadwal) throws RemoteException;

    void updateJadwal(Jadwal jadwal) throws RemoteException;

    void deleteJadwal(String idjadwal) throws RemoteException;

    Jadwal getJadwal(String idjadwal) throws RemoteException;

    List<Jadwal> getJadwal() throws RemoteException;
    
    List<Jadwal> getJadwalDokterbyIdDokter(String iddokter) throws RemoteException;
}
