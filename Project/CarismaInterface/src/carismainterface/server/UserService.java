package carismainterface.server;

import carismainterface.entity.User;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author K-MiL Caster
 */
public interface UserService extends Remote {

    void updateLastLogIn(String userName) throws RemoteException;

    Boolean userLogIn(String userName, String password, String role) throws RemoteException;
    
    void userLogOut(String userName, String role) throws RemoteException;

    void insertUser(User user) throws RemoteException;

    void updateUser(User user) throws RemoteException;

    void deleteUser(User user) throws RemoteException;

    User getUser(String user) throws RemoteException;

    List<User> getUser() throws RemoteException;
}
