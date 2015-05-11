/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaserver.entity;

import carismainterface.entity.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
public class UserEntityTest {
    
    public UserEntityTest() {
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
     * Test of userLogIn method, of class UserEntity.
     */
//    @Test
//    public void testUserLogIn() throws Exception {
//        System.out.println("userLogIn");
//        String userName = "";
//        String password = "";
//        String role = "";
//        UserEntity instance = new UserEntity();
//        Boolean expResult = null;
//        Boolean result = instance.userLogIn(userName, password, role);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of userLogOut method, of class UserEntity.
     */
//    @Test
//    public void testUserLogOut() throws Exception {
//        System.out.println("userLogOut");
//        String userName = "";
//        String role = "";
//        UserEntity instance = new UserEntity();
//        instance.userLogOut(userName, role);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of insertUser method, of class UserEntity.
     */
    @Test
    public void testInsertUser() throws Exception {
        System.out.println("insertUser");
        User user = new User();
        user.setIdUser(null);
        user.setUsername("server");
        user.setPassword("server");
        user.setRegistered(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        user.setLastlogin(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        user.setRole("administrator");
        UserEntity instance = new UserEntity();
        boolean expectedCondition = true;
        boolean resultCondition = instance.insertUser(user);
        assertEquals(expectedCondition, resultCondition);
    }

    /**
     * Test of updateUser method, of class UserEntity.
     */
    @Test
    public void testUpdateUser() throws Exception {
        System.out.println("updateUser");
        User user = new User();
        user.setIdUser(7);
        user.setUsername("server");
        user.setPassword("server");
        user.setRole("administrator");
        UserEntity instance = new UserEntity();
        boolean expectedCondition = true;
        boolean resultCondition = instance.updateUser(user);
        assertEquals(expectedCondition, resultCondition);
    }

    /**
     * Test of deleteUser method, of class UserEntity.
     */
    @Test
    public void testDeleteUser() throws Exception {
        System.out.println("deleteUser");
        User user = new User(7);
        UserEntity instance = new UserEntity();
        boolean expectedCondition = true;
        boolean resultCondition = instance.deleteUser(user);
        assertEquals(expectedCondition, resultCondition);
    }

    /**
     * Test of getUser method, of class UserEntity.
     */
    @Test
    public void testGetUser_String() throws Exception {
        System.out.println("getUser");
        String user = "carisma";
        UserEntity instance = new UserEntity();
        User expResult = new User();
        expResult.setIdUser(1);
        expResult.setUsername("carisma");
        expResult.setPassword("carisma");
        expResult.setRegistered("2015-03-13 00:00:00");
        expResult.setLastlogin("2015-04-26 10:00:29");
        expResult.setRole("administrator");
        User result = instance.getUser(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateLastLogIn method, of class UserEntity.
     */
//    @Test
//    public void testUpdateLastLogIn() throws Exception {
//        System.out.println("updateLastLogIn");
//        String userName = "";
//        UserEntity instance = new UserEntity();
//        instance.updateLastLogIn(userName);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getUser method, of class UserEntity.
     */
    @Test
    public void testGetUser_0args() throws Exception {
        System.out.println("getUser");
        UserEntity instance = new UserEntity();
//        List<User> expResult = new ArrayList<User>();
//        User user = new User();
//        user.setIdUser(1);
//        user.setUsername("carisma");
//        user.setPassword("carisma");
//        user.setRegistered("2015-03-13 00:00:00");
//        user.setLastlogin("2015-04-26 10:00:29");
//        user.setRole("administrator");
//        expResult.add(user);
//        user = new User();
//        user.setIdUser(2);
//        user.setUsername("dok1");
//        user.setPassword("dok1");
//        user.setRegistered("2015-04-07 00:00:00");
//        user.setLastlogin("2015-04-08 23:29:13");
//        user.setRole("dokter");
//        expResult.add(user);
//        user = new User();
//        user.setIdUser(3);
//        user.setUsername("kasir1");
//        user.setPassword("kasir1");
//        user.setRegistered("2015-04-07 00:00:00");
//        user.setLastlogin("2015-04-20 10:32:50");
//        user.setRole("kasir");
//        expResult.add(user);
//        user = new User();
//        user.setIdUser(4);
//        user.setUsername("apotek1");
//        user.setPassword("apotek1");
//        user.setRegistered("2015-04-07 00:00:00");
//        user.setLastlogin("2015-04-07 00:00:00");
//        user.setRole("apotek");
//        expResult.add(user);
//        user = new User();
//        user.setIdUser(5);
//        user.setUsername("staff1");
//        user.setPassword("staff1");
//        user.setRegistered("2015-04-07 00:00:00");
//        user.setLastlogin("2015-04-07 00:00:00");
//        user.setRole("staff");
//        expResult.add(user);
//        user = new User();
//        user.setIdUser(6);
//        user.setUsername("resp1");
//        user.setPassword("resp1");
//        user.setRegistered("2015-04-07 00:00:00");
//        user.setLastlogin("2015-04-20 11:03:31");
//        user.setRole("resepsionis");
//        expResult.add(user);
        List<User> result = instance.getUser();
        boolean resultCondition = false;
        if(result!=null){
            resultCondition = true;
        }
        assertTrue(resultCondition);
    }
    
}
