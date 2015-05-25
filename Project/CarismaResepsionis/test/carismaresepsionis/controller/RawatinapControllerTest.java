/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import carismainterface.entity.*;
import carismainterface.server.KamarService;
import carismainterface.server.PasienService;
import carismaresepsionis.boundaries.Rawatinap;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
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
    //private ClientSocket cient;
    //Rawatinap ui = new Rawatinap ();
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
        String namaPasien = "Raisa Andriana";
        String idPasien = "PAS000001";
        ClientSocket client = new ClientSocket ();
        //List<Pasien> list = new ArrayList<Pasien>();
        RawatinapController instance = new RawatinapController (client);
        Rawatinap ui = new Rawatinap (client, "resp1");
        DefaultTableModel expresult = new DefaultTableModel ();
        List<Pasien> list = new ArrayList<Pasien>();
        DefaultTableModel subList = new DefaultTableModel();
        list = pasienService.getPasien();
        for (int i = 0; i < list.size(); i++) {
            subList.addRow(new Object[]{list.get(i).getIdPasien(), list.get(i).getNamaPasien()});
        DefaultTableModel result = instance.getNamaPasien(ui);
        assertEquals(expresult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    }

    /**
     * Test of getNamaKamar method, of class RawatinapController.
     */
    @Test
    public void testGetNamaKamar_Rawatinap() throws Exception {
        System.out.println("getNamaKamar");
        
        ClientSocket client= new ClientSocket ();
        RawatinapController instance = new RawatinapController (client);
        Rawatinap ui = new Rawatinap (client, "resp1");
        DefaultTableModel expresult = new DefaultTableModel ();
        List<Kamar> list = new ArrayList<Kamar>();
        DefaultTableModel subList = new DefaultTableModel();
         list = kamarService.getKamar();
         for (int i = 0; i < list.size(); i++) {

            

            subList.addRow(new Object[]{list.get(i).getIdKamar(), list.get(i).getNamaKamar(), list.get(i).getKelas(), 
                list.get(i).getTarif()});

        DefaultTableModel result = instance.getKamar(ui);
        assertEquals(expresult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
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
  /*  @Test
    public void testKamarKosong() throws RemoteException, NotBoundException {
        System.out.println("kamarKosong");
        String parameterA = "coba";
        ClientSocket client= new ClientSocket ();
        RawatinapController instance = new RawatinapController (client);
        String expResult = "kosong";
        String result = instance.kamarKosong(parameterA);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    */
   
    
}
