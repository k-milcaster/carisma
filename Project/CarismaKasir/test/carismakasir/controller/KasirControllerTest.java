package carismakasir.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author K-MiL Caster
 */
public class KasirControllerTest {
    
    public KasirControllerTest() {
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
     * Test of showBiaya method, of class KasirController.
     */
    @Test
    public void testShowBiaya() throws Exception {
        System.out.println("showBiaya");
        String idKunjungan = "";
        KasirController instance = null;
        instance.showBiaya(idKunjungan);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cetak method, of class KasirController.
     */
    @Test
    public void testCetak() throws Exception {
        System.out.println("cetak");
        KasirController instance = null;
        instance.cetak();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
