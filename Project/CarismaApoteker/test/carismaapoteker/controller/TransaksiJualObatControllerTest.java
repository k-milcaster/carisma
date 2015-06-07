/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaapoteker.controller;

import carismainterface.entity.Obat;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sinta Eka Lestari
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
        String idTransaksijual = "cccc";
        String dateTransaksijual = "2015-05-11";
        String keterangan = "rrr";
        TransaksiJualObatController instance = new TransaksiJualObatController(client);
        boolean result = instance.insertTransaksijualobat(idTransaksijual, dateTransaksijual, keterangan);
        assertTrue(result);
        
    }

    /**
     * Test of insertDetailtransaksijualobat method, of class TransaksiJualObatController.
     */
    @Test
    public void testInsertDetailtransaksijualobat() throws Exception {
        client = new ClientSocket();
        System.out.println("insertDetailtransaksijualobat");
        String idTransaksi = "cccc";
        int idObat = 7;
        int qty = 5;
        TransaksiJualObatController instance = new TransaksiJualObatController(client) ;
        boolean result = instance.insertDetailtransaksijualobat(idTransaksi, idObat, qty);
        assertTrue(result);
        instance.deleteDetailTransaksiJualObat(idTransaksi, idObat);
        instance.deleteTransaksiJualObat(idTransaksi);
        
   
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
       
    }

    /**
     * Test of cekStok method, of class TransaksiJualObatController.
     */
    @Test
    public void testCekStok() throws Exception {
        client = new ClientSocket();
        System.out.println("cekStok");
        int idObat = 2;
        TransaksiJualObatController instance = new TransaksiJualObatController(client);
        int expResult = 50;
        int result = instance.cekStok(idObat).getQtyObat();
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
    /**
     * Test of getIdTransaksiJualObat method, of class TransaksiJualObatController.
     */
    @Test
    public void testGetIdTransaksiJualObat() throws Exception {
        client = new ClientSocket();
        System.out.println("getIdTransaksiJualObat");
        TransaksiJualObatController instance = new TransaksiJualObatController(client);
        String expResult = "TRANSSELL-20150529-002";
        String result = instance.getIdTransaksiJualObat();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateNow method, of class TransaksiJualObatController.
     */
    @Test
    public void testGetDateNow() throws Exception {
        client = new ClientSocket();
        System.out.println("getDateNow");
        TransaksiJualObatController instance = new TransaksiJualObatController(client);
        String expResult = "2015-05-29";
        String result = instance.getDateNow();
        assertEquals(expResult, result);
    }
}
