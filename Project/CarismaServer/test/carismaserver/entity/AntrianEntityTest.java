/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaserver.entity;

import carismainterface.entity.Antrian;
import carismaserver.boundaries.Main;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adinda
 */
public class AntrianEntityTest {
    private Main ui;
    
    public AntrianEntityTest() {
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

//    /**
//     * Test of insertAntrian method, of class AntrianEntity.
//     */
//    @Test
//    public void testInsertAntrian() throws Exception {
//        System.out.println("insertAntrian");
//        Antrian antrian = null;
//        AntrianEntity instance = new AntrianEntity();
//        instance.insertAntrian(antrian);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteAntrian method, of class AntrianEntity.
//     */
//    @Test
//    public void testDeleteAntrian() throws Exception {
//        System.out.println("deleteAntrian");
//        String antrian = "";
//        AntrianEntity instance = new AntrianEntity();
//        instance.deleteAntrian(antrian);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getAntrian method, of class AntrianEntity.
     */
    @Test
    public void testGetAntrian_String() throws Exception {
        System.out.println("getAntrian");
        String antri = "AN001";        
        AntrianEntity instance = new AntrianEntity(ui);
        Antrian expResult = new Antrian();
        expResult.setIdAntrian("AN001");
        expResult.setPasienIdPasien("PS001");
        expResult.setDokterIdDokter("DR001");
        expResult.setNomorAntrian(1);
        expResult.setJenisAntrian("Periksa");
        expResult.setTglAntrian("2015-05-10");
        expResult.setHadir("H");
        Antrian result = instance.getAntrian(antri);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getAntrian method, of class AntrianEntity.
     */
//    @Test
//    public void testGetAntrian_0args() throws Exception {
//        System.out.println("getAntrian");
//        AntrianEntity instance = new AntrianEntity();
//        List expResult = null;
//        List result = instance.getAntrian();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of antrianHadir method, of class AntrianEntity.
//     */
        @Test
        public void testAntrianHadir() throws Exception {
            System.out.println("antrianHadir");
            String antrian = "AN001";
            AntrianEntity instance = new AntrianEntity(ui);
            Antrian expResult = new Antrian();
            expResult.setHadir("H");             
            boolean result = instance.antrianHadir(antrian);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            //fail("The test case is a prototype.");
        }
}
