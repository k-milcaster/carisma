/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import carismainterface.server.DokterService;
import carismaresepsionis.boundaries.dokterform;
import javax.swing.table.DefaultTableModel;
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
public class DataDokterControllerTest {
    ClientSocket client;
    
    public DataDokterControllerTest() {
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
     * Test of getDokter method, of class DataDokterController.
     */
//    @Test
//    public void testGetDokter_0args() {
//        System.out.println("getDokter");
//        DataDokterController instance = null;
//        DokterService expResult = null;
//        DokterService result = instance.getDokter();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getNamaDokter method, of class DataDokterController.
//     */
//    @Test
//    public void testGetNamaDokter() {
//        System.out.println("getNamaDokter");
//        DataDokterController instance = null;
//        String expResult = "";
//        String result = instance.getNamaDokter();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getIdDokter method, of class DataDokterController.
//     */
//    @Test
//    public void testGetIdDokter() {
//        System.out.println("getIdDokter");
//        DataDokterController instance = null;
//        String expResult = "";
//        String result = instance.getIdDokter();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getNamaPoli method, of class DataDokterController.
//     */
//    @Test
//    public void testGetNamaPoli() {
//        System.out.println("getNamaPoli");
//        DataDokterController instance = null;
//        String expResult = "";
//        String result = instance.getNamaPoli();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTempatlahirDokter method, of class DataDokterController.
//     */
//    @Test
//    public void testGetTempatlahirDokter() {
//        System.out.println("getTempatlahirDokter");
//        DataDokterController instance = null;
//        String expResult = "";
//        String result = instance.getTempatlahirDokter();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTgllahirDokter method, of class DataDokterController.
//     */
//    @Test
//    public void testGetTgllahirDokter() {
//        System.out.println("getTgllahirDokter");
//        DataDokterController instance = null;
//        String expResult = "";
//        String result = instance.getTgllahirDokter();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getKelaminDokter method, of class DataDokterController.
//     */
//    @Test
//    public void testGetKelaminDokter() {
//        System.out.println("getKelaminDokter");
//        DataDokterController instance = null;
//        String expResult = "";
//        String result = instance.getKelaminDokter();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAlamatDokter method, of class DataDokterController.
//     */
//    @Test
//    public void testGetAlamatDokter() {
//        System.out.println("getAlamatDokter");
//        DataDokterController instance = null;
//        String expResult = "";
//        String result = instance.getAlamatDokter();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTelpDokter method, of class DataDokterController.
//     */
//    @Test
//    public void testGetTelpDokter() {
//        System.out.println("getTelpDokter");
//        DataDokterController instance = null;
//        String expResult = "";
//        String result = instance.getTelpDokter();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getHp1Dokter method, of class DataDokterController.
//     */
//    @Test
//    public void testGetHp1Dokter() {
//        System.out.println("getHp1Dokter");
//        DataDokterController instance = null;
//        String expResult = "";
//        String result = instance.getHp1Dokter();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getHp2Dokter method, of class DataDokterController.
//     */
//    @Test
//    public void testGetHp2Dokter() {
//        System.out.println("getHp2Dokter");
//        DataDokterController instance = null;
//        String expResult = "";
//        String result = instance.getHp2Dokter();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFotoDokter method, of class DataDokterController.
//     */
//    @Test
//    public void testGetFotoDokter() {
//        System.out.println("getFotoDokter");
//        DataDokterController instance = null;
//        byte[] expResult = null;
//        byte[] result = instance.getFotoDokter();
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getDokter method, of class DataDokterController.
     */
    @Test
    public void testGetDokter_dokterform() throws Exception {
        System.out.println("getDokter");
        dokterform ui = new dokterform(client, "resp1");
        DataDokterController instance = new DataDokterController(client);
        DefaultTableModel expResult = instance.getDokter(ui);
        DefaultTableModel result = instance.getDokter(ui);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDokterByName method, of class DataDokterController.
     */
    @Test
    public void testGetDokterByName() throws Exception {
        client = new ClientSocket();
        System.out.println("getDokterByName");
        String nama = "IMAM SUSILO, SP, PA, RF";
        DataDokterController instance = new DataDokterController(client);
        DefaultTableModel expResult = instance.getDokterByName(nama);
        DefaultTableModel result = instance.getDokterByName(nama);
        boolean resultCondition = false;
        System.out.println(result.getRowCount());
        if (result.getRowCount()>=1){
            resultCondition = true;
        }
        assertTrue(resultCondition);
    }

    /**
     * Test of getDokterByIdDokter method, of class DataDokterController.
     */
    @Test
    public void testGetDokterByIdDokter() throws Exception {
        System.out.println("getDokterByIdDokter");
        String idDokter = "DOK101";
        DataDokterController instance = new DataDokterController(client);
        String[] expResult = instance.getDokterByIdDokter(idDokter);
        String[] result = instance.getDokterByIdDokter(idDokter);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
