/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

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
public class DaftarRawatInapControllerTest {
    
    public DaftarRawatInapControllerTest() {
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
     * Test of insertNamaPasien method, of class DaftarRawatInapController.
     */
    @Test
    public void testInsertNamaPasien() throws Exception {
        System.out.println("insertNamaPasien");
        String namaPasien = "";
        String idPasien = "";
        int idKamar = 0;
        String namaKamar = "";
        String kelasKamar = "";
        String tarif = "";
        DaftarRawatInapController instance = null;
        instance.insertNamaPasien(namaPasien, idPasien, idKamar, namaKamar, kelasKamar, tarif);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of generatePeminjamanId method, of class DaftarRawatInapController.
     */
    @Test
    public void testGeneratePeminjamanId() {
        System.out.println("generatePeminjamanId");
        String idPasien = "";
        String namaKamar = "";
        DaftarRawatInapController instance = null;
        String expResult = "";
        String result = instance.generatePeminjamanId(idPasien, namaKamar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
