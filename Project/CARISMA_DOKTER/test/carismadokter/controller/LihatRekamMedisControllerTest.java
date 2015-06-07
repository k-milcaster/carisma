/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismadokter.controller;

import carismainterface.entity.Pasien;
import carismainterface.entity.Rekammedik;
import javax.swing.DefaultListModel;
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
public class LihatRekamMedisControllerTest {
    
    ClientSocket client;
     
    public LihatRekamMedisControllerTest() {
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
     * Test of getPasien method, of class LihatRekamMedisController.
     */
    @Test
    public void testGetPasien() throws Exception {
        client = new ClientSocket();
        System.out.println("getPasien");
        String idPasien = "1";
        LihatRekamMedisController instance = new LihatRekamMedisController(client);
        String expResult = null;
        Pasien result = instance.getPasien(idPasien);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getRekamMedik method, of class LihatRekamMedisController.
     */
    @Test
    public void testGetRekamMedik() throws Exception {
        client = new ClientSocket();
        System.out.println("getRekamMedik");
        String idPasien = "1";
        LihatRekamMedisController instance = new LihatRekamMedisController(client);
        DefaultTableModel result = instance.getRekamMedik(idPasien);
        boolean resultCondition = false;
        System.out.println(result.getRowCount());
        if (result.getRowCount() >= 1) {
            resultCondition = true;
        }
        assertTrue(resultCondition);
    }
    

    /**
     * Test of getDetailRekamMedik method, of class LihatRekamMedisController.
     */
    @Test
    public void testGetDetailRekamMedik() throws Exception {
        client = new ClientSocket();
        System.out.println("getDetailRekamMedik");
        String idRekamMedik = "RM1";
        LihatRekamMedisController instance = new LihatRekamMedisController(client);
        String expResult = "DETRM1";
        Rekammedik result = instance.getDetailRekamMedik(idRekamMedik);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }


    /**
     * Test of getNamaObat method, of class LihatRekamMedisController.
     */
    @Test
    public void testGetNamaObat() throws Exception {
        client = new ClientSocket();
        System.out.println("getNamaObat");
        String idResep = "res-1";
        LihatRekamMedisController instance = new LihatRekamMedisController(client);
        DefaultListModel expResult = instance.getNamaObat(idResep);
        DefaultListModel result = instance.getNamaObat(idResep);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }
}