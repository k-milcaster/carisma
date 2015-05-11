/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaapoteker.controller;

import carismaapoteker.boundaries.StokObat;
import carismaapoteker.controller.ClientSocket;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hana Mahrifah
 */
public class StokObatControllerTest {
    ClientSocket client;
    public StokObatControllerTest() {
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
     * Test of getObats method, of class StokObatController.
     */
    @Test
    public void testGetObats() throws Exception {
        System.out.println("getObats");
        client = new ClientSocket();
        //StokObat ui = null;
        StokObatController instance = new StokObatController(client);
        DefaultTableModel result = instance.getObats();
        boolean resultCondition = false;
        System.out.println(result.getRowCount());
        if (result.getRowCount() >= 1) {
            resultCondition = true;
        }
        assertTrue(resultCondition);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDetailObat method, of class StokObatController.
     */
    @Test
    public void testGetDetailObat() throws Exception {
        System.out.println("getDetailObat");
        client = new ClientSocket();
        int id = 1;
        StokObatController instance = new StokObatController(client);
        DefaultTableModel result = instance.getDetailObat(id);
        boolean resultCondition = false;
        System.out.println(result.getRowCount());
        if (result.getRowCount()>=1){
            resultCondition = true;
        }
        assertTrue(resultCondition);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of updateStokObat method, of class StokObatController.
     */
    @Test
    public void testUpdateStokObat() throws Exception {
        System.out.println("updateStokObat");
        client = new ClientSocket();
        int idObat = 1;
        String namaObat = "Acetosala";
        int qtyObat = 200;
        String jenisObat = "Analgesika";
        String keterangan = "huhuh";
        int hargaJualObat = 100000;
        int stokKritis = 23;
        StokObatController instance = new StokObatController(client);
        boolean result = instance.updateStokObat(idObat, namaObat, qtyObat, jenisObat, keterangan, hargaJualObat, stokKritis);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getObatbyName method, of class StokObatController.
     */
    @Test
    public void testGetObatbyName() throws Exception {
        System.out.println("getObatbyName");
        client = new ClientSocket();
        String nama = "Ace";
        StokObatController instance = new StokObatController(client);
        DefaultTableModel result = instance.getObatbyName(nama);
        boolean resultCondition = false;
        System.out.println(result.getRowCount());
        if (result.getRowCount()>=1){
            resultCondition = true;
        }
        assertTrue(resultCondition);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNamaPegawai method, of class StokObatController.
     */
    @Test
    public void testGetNamaPegawai() throws Exception {
        System.out.println("getNamaPegawai");
         client = new ClientSocket();
        String username = "apotek1";
        StokObatController instance =  new StokObatController(client);
        String[] expResult = new String[2];
        expResult[0] = "Hana";
        //expResult[1] = null;
        String[] result = instance.getNamaPegawai(username);
        assertArrayEquals(expResult, result);
    }
    
}
