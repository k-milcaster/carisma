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

    boolean updateLastLogIn(String userName) throws RemoteException;

    Boolean userLogIn(String userName, String password, String role) throws RemoteException;
    
    boolean userLogOut(String userName, String role) throws RemoteException;

    boolean insertUser(User user) throws RemoteException;

    boolean updateUser(User user) throws RemoteException;

    boolean deleteUser(User user) throws RemoteException;

    User getUser(String user) throws RemoteException;

    List<User> getUser() throws RemoteException;
}
