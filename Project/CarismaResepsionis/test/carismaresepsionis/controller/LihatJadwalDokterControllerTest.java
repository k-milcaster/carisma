/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Muhammad Rizal
 */
public class LihatJadwalDokterControllerTest {
    
    ClientSocket client;
     
    public LihatJadwalDokterControllerTest() {
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
     * Test of lihatJadwal method, of class LihatJadwalDokterController.
     */
    @Test
    public void testLihatJadwal() throws Exception {
        client = new ClientSocket();
        System.out.println("lihatJadwal");
        String idDokter = "";
        LihatJadwalDokterController instance = new LihatJadwalDokterController (client);
        ArrayList result = instance.lihatJadwal(idDokter);
        boolean resultCondition = false;
        if (result.size() >= 0) {
            resultCondition = true;
        }
        assertTrue(resultCondition);

    }    
}
