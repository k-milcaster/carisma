/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import carismainterface.entity.Pasien;
import carismainterface.server.KamarService;
import carismainterface.server.PasienService;
import carismaresepsionis.boundaries.Rawatinap;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
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
    private PasienService pasienService;
    private KamarService kamarService;
    
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
        ClientSocket client = new ClientSocket ();
        this.pasienService = client.getPasienService();
        Rawatinap ui = null;
        RawatinapController instance = null;
        DefaultTableModel expResult = null;
        DefaultTableModel result = instance.getNamaPasien(ui);
        assertEquals(ui.tablelistpasien, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNamaKamar method, of class RawatinapController.
     */
    @Test
    public void testGetNamaKamar_Rawatinap() throws Exception {
        System.out.println("getNamaKamar");
        ClientSocket client= new ClientSocket ();
        this.kamarService = client.getKamarService();
        Rawatinap ui = null;
        RawatinapController instance = null;
        DefaultTableModel expResult = null;
        DefaultTableModel result = instance.getNamaKamar(ui);
        assertEquals(ui.tablelistkamarpasien, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPasienbyName method, of class RawatinapController.
     */
    @Test
    public void testGetPasienbyName() throws Exception {
        System.out.println("getPasienbyName");
        String nama = "";
        Rawatinap ui = null;
        RawatinapController instance = null;
        DefaultTableModel expResult = null;
        DefaultTableModel result = instance.getPasienbyName(nama);
        assertEquals(ui.tablelistpasien, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

   
    /**
     * Test of kamarKosong method, of class RawatinapController.
     */
    @Test
    public void testKamarKosong() {
        System.out.println("kamarKosong");
        String parameterA = "";
        RawatinapController instance = null;
        String expResult = "kosong";
        String result = instance.kamarKosong(parameterA);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
   
    
}
