/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaapoteker.controller;

import carismaapoteker.boundaries.TabelObat;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS
 */
public class TransaksiJualObatControllerTest {
    
    public TransaksiJualObatControllerTest() {
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
     * Test of insertTransaksijualobat method, of class TransaksiJualObatController.
     */
    @Test
    public void testInsertTransaksijualobat() throws Exception {
        System.out.println("insertTransaksijualobat");
        String idTransaksijual = "";
        String dateTransaksijual = "";
        String keterangan = "";
        TransaksiJualObatController instance = null;
        instance.insertTransaksijualobat(idTransaksijual, dateTransaksijual, keterangan);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertDetailtransaksijualobat method, of class TransaksiJualObatController.
     */
    @Test
    public void testInsertDetailtransaksijualobat() throws Exception {
        System.out.println("insertDetailtransaksijualobat");
        String idTransaksi = "";
        int idObat = 0;
        int qty = 0;
        TransaksiJualObatController instance = null;
        instance.insertDetailtransaksijualobat(idTransaksi, idObat, qty);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTableObat method, of class TransaksiJualObatController.
     */
    @Test
    public void testGetTableObat() throws Exception {
        System.out.println("getTableObat");
        TabelObat b = null;
        TransaksiJualObatController instance = null;
        DefaultTableModel expResult = null;
        DefaultTableModel result = instance.getTableObat(b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
