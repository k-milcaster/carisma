/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import carismainterface.entity.Antrian;
import carismainterface.entity.Kunjungan;
import carismainterface.entity.Pasien;
import carismaresepsionis.boundaries.Menursepsionis;
import javax.swing.table.DefaultTableModel;
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
public class AntrianControllerTest {
    private ClientSocket client;
    
    public AntrianControllerTest() {
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
     * Test of getAntrian method, of class AntrianController.
     */
    @Test
    public void testGetAntrian() throws Exception {
        System.out.println("getAntrian");
<<<<<<< HEAD
        ClientSocket client = new ClientSocket();
        Menursepsionis ui = new Menursepsionis(client, "resp1");
        AntrianController instance = new AntrianController(client);
        instance.getAntrian(ui);
=======
        Menursepsionis ui = new Menursepsionis(client, "resp1");       
        AntrianController instance = new AntrianController(client);
        DefaultTableModel expResult = instance.getAntrian(ui);
        DefaultTableModel result = instance.getAntrian(ui);
        boolean resultCondition = false;
        System.out.println(result.getRowCount());
        if (result.getRowCount()>=1){
            resultCondition = true;
        }
        assertTrue(resultCondition);
        
               
>>>>>>> 01d21a6da2e3c2e4ce44b8098973990323c46589
    }

    /**
     * Test of getAntrianDetail method, of class AntrianController.
     */
    @Test
    public void testGetAntrianDetail() throws Exception {
        System.out.println("getAntrianDetail");
        String id = "AN001";
        ClientSocket client = new ClientSocket();
        AntrianController instance = new AntrianController(client);
        instance.getAntrianDetail(id);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getDetailPasien method, of class AntrianController.
     */
    @Test
    public void testGetDetailPasien() throws Exception {
        System.out.println("getDetailPasien");
        String idPasien = "PS001";
        ClientSocket client = new ClientSocket();
        AntrianController instance = new AntrianController(client);
        instance.getDetailPasien(idPasien);
<<<<<<< HEAD
=======
        
>>>>>>> 01d21a6da2e3c2e4ce44b8098973990323c46589
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getDetailKunjungan method, of class AntrianController.
     */
//    @Test
//    public void testGetDetailKunjungan() throws Exception {
//        System.out.println("getDetailKunjungan");
//        String idKunjungan = "";
//        AntrianController instance = null;
//        Kunjungan expResult = null;
//        Kunjungan result = instance.getDetailKunjungan(idKunjungan);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
}
