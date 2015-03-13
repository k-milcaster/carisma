package carismaserver.controllers;
import carismaserver.entity.AdminEntity;
import java.rmi.RemoteException;
/**
 *
 * @author K-MiL Caster
 */
public class LogIn {
    private String userName;
    private String password;   
    public LogIn(String userName, String password) {
        this.userName = userName;
        this.password = password;        
    }
    
    public boolean logIn() throws RemoteException{
        AdminEntity admin = new AdminEntity();
        boolean success = admin.adminLogIn(userName, password);
        if (success) {
            admin.updateLastLogIn(userName);
        }
        return success;
    }
    
}
