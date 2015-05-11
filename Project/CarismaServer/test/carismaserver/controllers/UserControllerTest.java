/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaserver.controllers;

import carismaserver.boundaries.UserManagement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kepoterz
 */
public class UserControllerTest {
    
    public UserControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertUser method, of class UserController.
     */
    @Test
    public void testInsertUser() throws Exception {
        System.out.println("insertUser");
        UserManagement ui = new UserManagement(new carismaserver.boundaries.Main("Franzvilosya"));
        String username = "server";
        String password = "server";
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String role = "server";
        UserController instance = new UserController();
        boolean expResult = true;
        boolean result = instance.insertUser(ui, username, password, now, role);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateUser method, of class UserController.
     */
    @Test
    public void testUpdateUser() throws Exception {
        System.out.println("updateUser");
        UserManagement ui = new UserManagement(new carismaserver.boundaries.Main("Franzvilosya"));
        int id = 7;
        String username = "server";
        String password = "server";
        String role = "server";
        UserController instance = new UserController();
        boolean expResult = true;
        boolean result = instance.updateUser(ui, id, username, password, role);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteUser method, of class UserController.
     */
    @Test
    public void testDeleteUser() throws Exception {
        System.out.println("deleteUser");
        UserManagement ui = new UserManagement(new carismaserver.boundaries.Main("Franzvilosya"));
        int id = 7;
        UserController instance = new UserController();
        boolean expResult = true;
        boolean result = instance.deleteUser(ui, id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsers method, of class UserController.
     */
    @Test
    public void testGetUsers() throws Exception {
        System.out.println("getUsers");
        UserManagement ui = new UserManagement(new carismaserver.boundaries.Main("Franzvilosya"));
        UserController instance = new UserController();
        DefaultTableModel expResult = null;
        DefaultTableModel result = instance.getUsers(ui);
        boolean resultCondition = false;
        if(result!=null){
            resultCondition = true;
        }
        assertTrue(resultCondition);
    }
    
}
