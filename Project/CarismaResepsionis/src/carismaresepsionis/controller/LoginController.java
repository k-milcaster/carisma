package carismaresepsionis.controller;

import carismainterface.server.UserService;
import java.rmi.RemoteException;

/**
 *
 * @author K-MiL Caster
 */
public class LoginController {

    private String userName;
    private String password;
    private UserService user;

    public LoginController(UserService login, String userName, String password) {
        this.user = login;
        this.userName = userName;
        this.password = password;
    }

    public boolean logIn() throws RemoteException {
        boolean success = user.userLogIn(userName, password, "resepsionis");
        if (success) {
            user.updateLastLogIn(userName);
        }
        return success;
    }
}
