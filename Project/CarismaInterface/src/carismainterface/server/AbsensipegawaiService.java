/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismainterface.server;

import carismainterface.entity.Absensipegawai;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author kepoterz
 */
public interface AbsensipegawaiService extends Remote {
    void insertAbsensipegawai(Absensipegawai absensipegawai) throws RemoteException;

    void updateAbsensipegawai(Absensipegawai absensipegawai) throws RemoteException;

    void deleteAbsensipegawai(String idabsensipegawai) throws RemoteException;

    Absensipegawai getAbsensipegawai(String pegawaiidpegawai) throws RemoteException;

    List<Absensipegawai> getAbsensipegawai() throws RemoteException;
}
