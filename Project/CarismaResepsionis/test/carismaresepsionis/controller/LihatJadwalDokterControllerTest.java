/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import carismainterface.entity.Jadwaldokter;
import carismainterface.server.JadwaldokterService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anes Dirsi
 */
public class LihatJadwalDokterControllerTest {
    
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
     * Test of getJadwaldokter method, of class LihatJadwalDokterController.
     */
    @Test
    public void testGetJadwaldokter() {
        System.out.println("getJadwaldokter");
        LihatJadwalDokterController instance = null;
        JadwaldokterService expResult = null;
        JadwaldokterService result = instance.getJadwaldokter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdDokter method, of class LihatJadwalDokterController.
     */
    @Test
    public void testGetIdDokter() {
        System.out.println("getIdDokter");
        LihatJadwalDokterController instance = null;
        String expResult = "";
        String result = instance.getIdDokter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdJadwalDokter method, of class LihatJadwalDokterController.
     */
    @Test
    public void testGetIdJadwalDokter() {
        System.out.println("getIdJadwalDokter");
        LihatJadwalDokterController instance = null;
        Integer expResult = null;
        Integer result = instance.getIdJadwalDokter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJadwalDokterDetail method, of class LihatJadwalDokterController.
     */
    @Test
    public void testGetJadwalDokterDetail() throws Exception {
        System.out.println("getJadwalDokterDetail");
        String id = "";
        LihatJadwalDokterController instance = null;
        Jadwaldokter expResult = null;
        Jadwaldokter result = instance.getJadwalDokterDetail(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
