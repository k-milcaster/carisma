/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismainterface.server;

import carismainterface.entity.Poli;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author kepoterz
 */
public interface PoliService extends Remote{
    boolean insertPoli(Poli poli) throws RemoteException;

    boolean updatePoli(Poli poli) throws RemoteException;
    
    boolean deletePoli(Poli poli) throws RemoteException;

    Poli getPoli(String idpoli) throws RemoteException;

    List<Poli> getPoli() throws RemoteException;
}
