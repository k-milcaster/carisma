/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
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
        String namaPasien = "Pevita";
        String idPasien = "PAS004";
        int idKamar = 202;
        String namaKamar = "EDELWEIS";
        String kelasKamar = "UTAMA";
        String tarif = "245000";
        ClientSocket client = new ClientSocket();
        DaftarRawatInapController instance = new DaftarRawatInapController(client);
        boolean expResult = true;
        boolean result = instance.insertNamaPasien(namaPasien, idPasien, idKamar, namaKamar, kelasKamar, tarif);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of generatePeminjamanId method, of class DaftarRawatInapController.
     */
    @Test
    public void testGeneratePeminjamanId() throws RemoteException, NotBoundException {
        System.out.println("generatePeminjamanId");
        String idPasien = "PAS004";
        String namaKamar = "EDELWEIS";
        ClientSocket client = new ClientSocket();
        DaftarRawatInapController instance = new DaftarRawatInapController(client);
        String expResult = "PAS004";
        String result = instance.generatePeminjamanId(idPasien, namaKamar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
