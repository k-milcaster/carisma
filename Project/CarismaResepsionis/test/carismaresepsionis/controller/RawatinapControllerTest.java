/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import carismaresepsionis.boundaries.Rawatinap;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vaio Sony
 */
public class RawatinapControllerTest {
    
    public RawatinapControllerTest() {
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
     * Test of getNamaPasien method, of class RawatinapController.
     */
    @Test
    public void testGetNamaPasien() throws Exception {
        System.out.println("getNamaPasien");
        Rawatinap ui = null;
        RawatinapController instance = null;
        DefaultTableModel expResult = null;
        DefaultTableModel result = instance.getNamaPasien(ui);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNamaKamar method, of class RawatinapController.
     */
    @Test
    public void testGetNamaKamar_Rawatinap() throws Exception {
        System.out.println("getNamaKamar");
        Rawatinap ui = null;
        RawatinapController instance = null;
        DefaultTableModel expResult = null;
        DefaultTableModel result = instance.getNamaKamar(ui);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPasienbyName method, of class RawatinapController.
     */
    @Test
    public void testGetPasienbyName() throws Exception {
        System.out.println("getPasienbyName");
        String nama = "";
        RawatinapController instance = null;
        DefaultTableModel expResult = null;
        DefaultTableModel result = instance.getPasienbyName(nama);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNamaKamar method, of class RawatinapController.
     */
    @Test
    public void testGetNamaKamar_0args() {
        System.out.println("getNamaKamar");
        RawatinapController instance = null;
        String expResult = "";
        String result = instance.getNamaKamar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKelasKamar method, of class RawatinapController.
     */
    @Test
    public void testGetKelasKamar() {
        System.out.println("getKelasKamar");
        RawatinapController instance = null;
        String expResult = "";
        String result = instance.getKelasKamar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTarifKamar method, of class RawatinapController.
     */
    @Test
    public void testGetTarifKamar() {
        System.out.println("getTarifKamar");
        RawatinapController instance = null;
        String expResult = "";
        String result = instance.getTarifKamar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of kamarKosong method, of class RawatinapController.
     */
    @Test
    public void testKamarKosong() {
        System.out.println("kamarKosong");
        String parameterA = "";
        RawatinapController instance = null;
        String expResult = "";
        String result = instance.kamarKosong(parameterA);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
