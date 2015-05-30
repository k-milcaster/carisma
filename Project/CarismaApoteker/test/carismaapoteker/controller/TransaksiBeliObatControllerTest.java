/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaapoteker.controller;

import javax.swing.DefaultComboBoxModel;
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
public class TransaksiBeliObatControllerTest {

    ClientSocket client;

    public TransaksiBeliObatControllerTest() {
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
     * Test of getIdObat method, of class TransaksiBeliObatController.
     */
    @Test
    public void testGetIdObat() throws Exception {
        System.out.println("getIdObat");
        client = new ClientSocket();
        TransaksiBeliObatController instance = new TransaksiBeliObatController(client);
        DefaultComboBoxModel result = instance.getIdObat();
         boolean resultCondition = false;
        if (result.getSize() >= 1) {
            resultCondition = true;
        }
        assertTrue(resultCondition);
    }

    /**
     * Test of insertBeliObat method, of class TransaksiBeliObatController.
     */
    @Test
    public void testInsertBeliObat() throws Exception {
        System.out.println("insertBeliObat");
        client = new ClientSocket();
        String idTransaksiBeliObat = "TRANSBUY-20150424-001";
        String tglTransaksiBeliObat = "2015-05-24";
        String keterangan = "-";
        int hargaBeliObat = 2000;
        TransaksiBeliObatController instance = new TransaksiBeliObatController(client);
        boolean result = instance.insertBeliObat(idTransaksiBeliObat, tglTransaksiBeliObat, keterangan, hargaBeliObat);
        assertTrue(result);
        instance.deleteBeliObat("TRANSBUY-20150424-001");
    }

    /**
     * Test of insertStokObatLama method, of class TransaksiBeliObatController.
     */
    @Test
    public void testInsertStokObat() throws Exception {
        System.out.println("insertStokObat");
        client = new ClientSocket();
        int idObat = 302;
        String namaObat = "Puyer 18";
        int qtyObat = 0;
        String jenisObat = "Demam";
        String keterangan = "-";
        int hargaJualObat = 20000;
        int stokKritis = 30;
        TransaksiBeliObatController instance = new TransaksiBeliObatController(client);
        boolean result = instance.insertStokObat(idObat, namaObat, qtyObat, jenisObat, keterangan, hargaJualObat, stokKritis);
        assertTrue(result);
        instance.deleteStokObat(302);
    }

    /**
     * Test of insertDetailTransaksiBeliObat method, of class
     * TransaksiBeliObatController.
     */
    @Test
    public void testInsertDetailTransaksiBeliObat() throws Exception {
        System.out.println("insertDetailTransaksiBeliObat");
        client = new ClientSocket();
        String idTransaksi = "TRANSBUY-20150523-005";
        int idObat = 1;
        int qtyObat = 201;
        TransaksiBeliObatController instance = new TransaksiBeliObatController(client);
        boolean result = instance.insertDetailTransaksiBeliObat(idTransaksi, idObat, qtyObat);
        assertTrue(result);
        instance.deleteDetailTransaksiBeliObat("TRANSBUY-20150523-005", 1);
    }

    /**
     * Test of insertDetailObat method, of class TransaksiBeliObatController.
     */
    @Test
    public void testInsertDetailObat() throws Exception {
        System.out.println("insertDetailObat");
        client = new ClientSocket();
        int idDetail = 100;
        int idObat = 9;
        String TglKadaluarsa = "2017-05-13";
        TransaksiBeliObatController instance = new TransaksiBeliObatController(client);
        boolean result = instance.insertDetailObat(idDetail, idObat, TglKadaluarsa);
        assertTrue(result);
        instance.deleteDetailObat(100);
        instance.deleteStokObat(9);
    }

    /**
     * Test of updateStokObat method, of class TransaksiBeliObatController.
     */
    @Test
    public void testUpdateStokObat() throws Exception {
        System.out.println("updateStokObat");
        client = new ClientSocket();
        int id = 302;
        int qty = 201;
        TransaksiBeliObatController instance = new TransaksiBeliObatController(client);
        boolean result = instance.updateStokObat(id, qty);
        assertTrue(result);
    }

    /**
     * Test of getidDetailObat method, of class TransaksiBeliObatController.
     */
    @Test
    public void testGetidDetailObat() throws Exception {
        System.out.println("getidDetailObat");
        client = new ClientSocket();
        TransaksiBeliObatController instance = new TransaksiBeliObatController(client);
        int expResult = 41;
        int result = instance.getidDetailObat();
        assertEquals(expResult, result);
    }

    /**
     * Test of getidObat method, of class TransaksiBeliObatController.
     */
    @Test
    public void testGetidObat() throws Exception {
        System.out.println("getidObat");
        client = new ClientSocket();
        TransaksiBeliObatController instance = new TransaksiBeliObatController(client);
        int expResult =218;
        int result = instance.getidObat();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNamaPegawai method, of class TransaksiBeliObatController.
     */
    @Test
    public void testGetNamaPegawai() throws Exception {
        System.out.println("getNamaPegawai");
        client = new ClientSocket();
        String username = "apotek1";
        StokObatController instance = new StokObatController(client);
        String[] expResult = new String[2];
        expResult[0] = "Hana";
        String[] result = instance.getNamaPegawai(username);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getIdTransaksiBeliObat method, of class
     * TransaksiBeliObatController.
     */
    @Test
    public void testGetIdTransaksiBeliObat() throws Exception {
        client = new ClientSocket();
        System.out.println("getIdTransaksiBeliObat");
        TransaksiBeliObatController instance = new TransaksiBeliObatController(client);
        String expResult = "TRANSBUY-20150530-002";
        String result = instance.getIdTransaksiBeliObat();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateNow method, of class TransaksiBeliObatController.
     */
    @Test
    public void testGetDateNow() throws Exception {
        client = new ClientSocket();
        System.out.println("getDateNow");
        TransaksiBeliObatController instance = new TransaksiBeliObatController(client);
        String expResult = "2015-05-30";
        String result = instance.getDateNow();
        assertEquals(expResult, result);
    }

}
