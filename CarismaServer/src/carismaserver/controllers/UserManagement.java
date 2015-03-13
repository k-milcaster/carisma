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
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author K-MiL Caster
 */
public class UserManagement {

    public void getUsers(carismaserver.boundaries.UserManagement ui) throws RemoteException {
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
            System.out.println("lewat");
        }
        ui.tableUser.setModel(model);
    }
}
