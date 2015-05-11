/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaapoteker.controller;

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
    ClientSocket client;
    
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
        client = new ClientSocket();
        System.out.println("insertTransaksijualobat");
        String idTransaksijual = "oooooo";
        String dateTransaksijual = "2015-05-11";
        String keterangan = "lalalala";
        TransaksiJualObatController instance = new TransaksiJualObatController(client);
        boolean result = instance.insertTransaksijualobat(idTransaksijual, dateTransaksijual, keterangan);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of insertDetailtransaksijualobat method, of class TransaksiJualObatController.
     */
    @Test
    public void testInsertDetailtransaksijualobat() throws Exception {
        client = new ClientSocket();
        System.out.println("insertDetailtransaksijualobat");
        String idTransaksi = "trans01";
        int idObat = 1;
        int qty = 50;
        TransaksiJualObatController instance = new TransaksiJualObatController(client) ;
        boolean result = instance.insertDetailtransaksijualobat(idTransaksi, idObat, qty);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
   
    }

    /**
     * Test of getTableObat method, of class TransaksiJualObatController.
     */
    @Test
    public void testGetTableObat() throws Exception {
        client = new ClientSocket();
        System.out.println("getTableObat");
        TransaksiJualObatController instance = new TransaksiJualObatController(client);
        DefaultTableModel result = instance.getTableObat();
        boolean resultCondition = false;
        System.out.println(result.getRowCount());
        if (result.getRowCount() >= 1){
            resultCondition = true;
        }
        assertTrue(resultCondition);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of cekStok method, of class TransaksiJualObatController.
     */
    @Test
    public void testCekStok() throws Exception {
        client = new ClientSocket();
        System.out.println("cekStok");
        int idObat = 15;
        TransaksiJualObatController instance = new TransaksiJualObatController(client);
        int expResult = 50;
        int result = instance.cekStok(idObat);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of namaPegawai method, of class TransaksiJualObatController.
     */
    @Test
    public void testNamaPegawai() throws Exception {
        client = new ClientSocket();
        System.out.println("namaPegawai");
        String username = "apotek1";
        TransaksiJualObatController instance = new TransaksiJualObatController(client);
        String[] expResult = new String [2];
        expResult[0] = "Sinta";
        expResult[1] = null;
        String[] result = instance.namaPegawai(username);
        assertArrayEquals(expResult, result);
       
    }

    /**
     * Test of getObatbyName method, of class TransaksiJualObatController.
     */
    @Test
    public void testGetObatbyName() throws Exception {
        client = new ClientSocket();
        System.out.println("getObatbyName");
        String nama = "Ibuprofen";
        TransaksiJualObatController instance = new TransaksiJualObatController(client);
        DefaultTableModel result = instance.getObatbyName(nama);
        boolean resultCondition = false;
        System.out.println(result.getRowCount());
        if (result.getRowCount()>=1){
            resultCondition = true;
        }
        assertTrue(resultCondition);
        
    }
}
