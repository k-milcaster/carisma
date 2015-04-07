package carismaserver.entity;

import carismainterface.entity.User;
import carismaserver.controllers.DatabaseConnection;
import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author K-MiL Caster
 */
public class AdminEntity {

    public Boolean adminLogIn(String userName, String password) throws RemoteException {
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM user WHERE username = ? AND password = ? AND role = 'administrator'");
            statement.setString(1, userName);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            System.out.println("lewat " + userName + ", " + password);
            
            int count = 0;
            if (result.next()) {
                User users = new User();
                users.setUsername(result.getString("username"));
                users.setPassword(result.getString("password"));
                users.setRole(result.getString("role"));
                count++;
            }
            if (count == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException exception) {
            System.out.println(exception.toString());
            return false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    public void updateLastLogIn(String userName) throws RemoteException {
        PreparedStatement statement = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String now = dateFormat.format(date);
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE user SET lastlogin = ? WHERE username = ?");

            statement.setString(1, now);
            statement.setString(2, userName);
            statement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception.toString());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }

    }
}
