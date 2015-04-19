/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismainterface.server;

import carismainterface.entity.Provinsi;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author kepoterz
 */
public interface ProvinsiService extends Remote{
    Provinsi getProvinsi(String idprovinsi) throws RemoteException;

    List<Provinsi> getProvinsi() throws RemoteException;
}
