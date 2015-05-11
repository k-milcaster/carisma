/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaserver.controllers;

import carismainterface.entity.User;
import java.util.ArrayList;
import java.util.List;
import carismaserver.entity.UserEntity;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author K-MiL Caster
 */
public class UserController {

    public boolean insertUser(carismaserver.boundaries.UserManagement ui,String username,String password,String now, String role) throws RemoteException {
        UserEntity userService = new UserEntity(ui.ui);
        try {
            User user = new User();
            user.setIdUser(null);
            user.setUsername(username);
            user.setPassword(password);
            user.setRegistered(now);
            user.setRole(role);
            userService.insertUser(user);
            return true;
        } catch (RemoteException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean updateUser(carismaserver.boundaries.UserManagement ui,int id, String username, String password, String role) throws RemoteException{
        UserEntity userService = new UserEntity(ui.ui);
        try{
            User user = new User();
            user.setIdUser(id);
            user.setUsername(username);
            user.setPassword(password);
            user.setRole(role);
            userService.updateUser(user);
            return true;
        } catch (RemoteException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean deleteUser(carismaserver.boundaries.UserManagement ui,int id) throws RemoteException{
        UserEntity userService = new UserEntity(ui.ui);
        try{
            User user = new User(id);
            userService.deleteUser(user);
            return true;
        } catch (RemoteException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public DefaultTableModel getUsers(carismaserver.boundaries.UserManagement ui) throws RemoteException {
        UserEntity userService = new UserEntity(ui.ui);
        List<User> list = new ArrayList<User>();
        list = userService.getUser();
        DefaultTableModel model = new DefaultTableModel();      
        model.addColumn("No. "); 
        model.addColumn("UserName"); 
        model.addColumn("Password"); 
        model.addColumn("Registered"); 
        model.addColumn("LastLogin"); 
        model.addColumn("Role"); 
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{i, list.get(i).getUsername(), list.get(i).getPassword(), list.get(i).getRegistered(), list.get(i).getLastlogin(), list.get(i).getRole()});
            //System.out.println("lewat");
        }
        //ui.tableUser.setModel(model);
        return model;
    }
}
