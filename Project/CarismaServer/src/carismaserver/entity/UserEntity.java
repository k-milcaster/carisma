package carismaserver.entity;

import carismainterface.entity.*;
import carismainterface.server.UserService;
import carismaserver.controllers.DatabaseConnection;
import carismaserver.boundaries.Main;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author K-MiL Caster
 */
public class UserEntity extends UnicastRemoteObject implements UserService {

    public Main ui;

    public UserEntity() throws RemoteException {

    }

    public UserEntity(Main ui) throws RemoteException {
        this.ui = ui;
    }

    @Override
    public Boolean userLogIn(String userName, String password, String role) throws RemoteException {
        ui.act.append("Client Execute userLogIn (" + userName + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM user WHERE username = ? AND password = ? AND role = ?");
            statement.setString(1, userName);
            statement.setString(2, password);
            statement.setString(3, role);
            ResultSet result = statement.executeQuery();
            User users = null;
            int count = 0;
            if (result.next()) {
                users = new User();
                users.setUsername(result.getString("username"));
                users.setPassword(result.getString("password"));
                users.setRole(result.getString("role"));
                count++;
            }
            if (count == 1) {
                DefaultListModel model = new DefaultListModel();
                for (int i = 0; i < ui.loggedInList.getModel().getSize(); i++) {
                    Object item = ui.loggedInList.getModel().getElementAt(i);
                    model.addElement(item.toString());
                }
                model.addElement(userName + " as " + role);
                ui.loggedInList.setModel(model);
                return true;
            } else {
                return false;
            }
        } catch (SQLException exception) {
            ui.act.append("userLogIn Error \n");
            ui.act.append(exception.toString());
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

    @Override
    public void userLogOut(String userName, String role) {
        ui.act.append("Client Execute UserLogOut " + userName + "\n");
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < ui.loggedInList.getModel().getSize(); i++) {
            Object item = ui.loggedInList.getModel().getElementAt(i);
            model.addElement(item.toString());
        }
        model.removeElement(userName + " as " + role);
        ui.loggedInList.setModel(model);        
    }

    @Override
    public boolean insertUser(User user) throws RemoteException {
        //ui.act.append("Client Execute insertUser " + user.toString() + "\n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "INSERT INTO user (id_user, username, password, registered, lastlogin, role) values (?,?,?,?,?,?)"
            );
            statement.setString(1, null);
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRegistered().toString());
            statement.setString(5, user.getRegistered().toString());
            statement.setString(6, user.getRole());
            statement.executeUpdate();
            return true;
        } catch (SQLException exception) {
            ui.act.append("InsertUser Error \n");
            ui.act.append(exception.toString());
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

    @Override
    public boolean updateUser(User user) throws RemoteException {
        //ui.act.append("Client Execute updateCustomers(" + user.toString() + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "UPDATE user SET username = ?, password = ?"
                    + ",role = ? "
                    + "WHERE id_user = ?"
            );
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole());
            statement.setInt(4, user.getIdUser());
            //System.out.println(statement);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("UpdateUser Error \n");
            ui.act.append(e.toString());
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

    @Override
    public boolean deleteUser(User user) throws RemoteException {
        //ui.act.append("Client Execute deleteUser (" + user.toString() + ") \n");
        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "DELETE FROM user WHERE id_user = ?");
            statement.setInt(1, user.getIdUser());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            ui.act.append("deleteUser Error \n");
            ui.act.append(e.toString());
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

    @Override
    public User getUser(String user) throws RemoteException {
        //ui.act.append("Client Execute getUser (" + user + ") \n");

        PreparedStatement statement = null;
        try {
            statement = DatabaseConnection.getConnection().prepareStatement(
                    "SELECT * FROM user WHERE username = ?");
            statement.setString(1, user);
            ResultSet result = statement.executeQuery();
            User users = null;
            if (result.next()) {
                users = new User();
                users.setIdUser(result.getInt("id_user"));
                users.setUsername(result.getString("username"));
                users.setPassword(result.getString("password"));
                users.setRegistered(result.getString("registered"));
                users.setLastlogin(result.getString("lastlogin"));
                users.setRole(result.getString("role"));
            }
            System.out.println("here is");
            return users;
        } catch (SQLException exception) {
            ui.act.append("getUser Error \n");
            ui.act.append(exception.toString());
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
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
            ui.act.append("updateLastLogIn Error \n");
            ui.act.append(exception.toString());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }

    }

    @Override
    public List<User> getUser() throws RemoteException {
        //ui.act.append("Client Execute getUsersList \n");

        Statement statement = null;
        try {
            statement = DatabaseConnection.getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM user");

            List<User> list = new ArrayList<User>();

            while (result.next()) {
                User users = new User();
                users.setIdUser(result.getInt("id_user"));
                users.setUsername(result.getString("username"));
                users.setPassword(result.getString("password"));
                users.setRegistered(result.getString("registered"));
                users.setLastlogin(result.getString("lastlogin"));
                users.setRole(result.getString("role"));
                list.add(users);
            }
            result.close();

            return list;

        } catch (SQLException exception) {
            ui.act.append("getUserList Error \n");
            ui.act.append(exception.toString());
            return null;
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
