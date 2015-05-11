/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismadokter.controller;

import carismainterface.server.RekammedikService;
import javax.swing.DefaultComboBoxModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class IsiRekamMedisControllerTest {

    ClientSocket client;

    public IsiRekamMedisControllerTest() {
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
     * Test of getIdNamaDokter method, of class IsiRekamMedisController.
     */
    @Test
    public void testGetIdNamaDokter() throws Exception {
        client = new ClientSocket();
        System.out.println("getIdNamaDokter");
        IsiRekamMedisController instance = new IsiRekamMedisController(client);
        String userName = "dok1";
        String[] expResult = new String[2];
        expResult[0] = "DOK0404994";
        expResult[1] = "Fitriana Dzulfaidah";
        String[] result = instance.getIdNamaDokter(userName);
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of getIdRekamMedis method, of class IsiRekamMedisController.
     */
    @Test
    public void testGetIdRekamMedis() throws Exception {
        client = new ClientSocket();
        System.out.println("getIdRekamMedis");
        IsiRekamMedisController instance = new IsiRekamMedisController(client);
        String expResult = "REKMED-20150511-001";
        String result = instance.getIdRekamMedis();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdResep method, of class IsiRekamMedisController.
     */
    @Test
    public void testGetIdResep() throws Exception {
        client = new ClientSocket();
        System.out.println("getIdResep");
        IsiRekamMedisController instance = new IsiRekamMedisController(client);
        String expResult = "RES-2015-05-11-001";
        String result = instance.getIdResep();
        assertEquals(expResult, result);
    }

    /**
     * Test of insertResep method, of class IsiRekamMedisController.
     */
    @Test
    public void testInsertResep() throws Exception {
        client = new ClientSocket();
        System.out.println("insertResep");
        String idResep = "RES-2015-05-11-001";
        String keterangan = "ada deh";
        IsiRekamMedisController instance = new IsiRekamMedisController(client);
        boolean result = instance.insertResep(idResep, keterangan);
        assertTrue(result);
    }

    /**
     * Test of getIdDetailResep method, of class IsiRekamMedisController.
     */
    @Test
    public void testGetIdDetailResep() throws Exception {
        client = new ClientSocket();
        System.out.println("getIdDetailResep");
        IsiRekamMedisController instance = new IsiRekamMedisController(client);
        String expResult = "DETRES-2015-05-11-001";
        String result = instance.getIdDetailResep();
        assertEquals(expResult, result);
    }

    /**
     * Test of insertDetailResep method, of class IsiRekamMedisController.
     */
    @Test
    public void testInsertDetailResep() throws Exception {
        client = new ClientSocket();
        System.out.println("insertDetailResep");
        String idDetailResep = "DETRES-2015-05-11-001";
        String idResep = "RES-2015-05-11-001";
        String namaObat = "Aspirin";
        int quantity = 10;
        String aturanPakai = "rahasia dong";
        IsiRekamMedisController instance = new IsiRekamMedisController(client);
        boolean result = instance.insertDetailResep(idDetailResep, idResep, namaObat, quantity, aturanPakai);
        assertTrue(result);
        instance.deleteDetailResep("DETRES-2015-05-11-001");
        instance.deleteResep("RES-2015-05-11-001");
    }

    /**
     * Test of insertRekamMedis method, of class IsiRekamMedisController.
     */
    @Test
    public void testInsertRekamMedis() throws Exception {
        client = new ClientSocket();
        System.out.println("insertRekamMedis");
        String idRekammedik = "REKMED-20150511-001";
        String idDokter = "DOK0304980";
        String idPasien = "0011445423";
        String tglRekamMedis = "2015-05-11";
        String keluhan = "jkdk";
        String pemeriksaan = "dsfs";
        String terapi = "gendeng";
        String alergiObat = "edan";
        String kesimpulanPemeriksaan = "gila";
        String kondisiPasien = "epilepsi";
        String idResep = "RES-2015-04-20-003";
        IsiRekamMedisController instance = new IsiRekamMedisController(client);
        boolean result = instance.insertRekamMedis(idRekammedik, idDokter, idPasien, tglRekamMedis, keluhan, pemeriksaan, terapi, alergiObat, kesimpulanPemeriksaan, kondisiPasien, idResep);
        assertTrue(result);
    }

    /**
     * Test of insertRekamMedisPenyakit method, of class
     * IsiRekamMedisController.
     */
    @Test
    public void testInsertRekamMedisPenyakit() throws Exception {
        client = new ClientSocket();
        System.out.println("insertRekamMedisPenyakit");
        String idRekamMedis = "REKMED-20150511-001";
        String idPenyakit = "A001";
        IsiRekamMedisController instance = new IsiRekamMedisController(client);
        boolean result = instance.insertRekamMedisPenyakit(idRekamMedis, idPenyakit);
        assertTrue(result);
        instance.deleteRekamMedikPenyakit("REKMED-20150511-001");
    }

    /**
     * Test of getIdKunjungan method, of class IsiRekamMedisController.
     */
    @Test
    public void testGetIdKunjungan() throws Exception {
        client = new ClientSocket();
        System.out.println("getIdKunjungan");
        IsiRekamMedisController instance = new IsiRekamMedisController(client);
        String expResult = "VIS-20150511-001";
        String result = instance.getIdKunjungan();
        assertEquals(expResult, result);
    }

    /**
     * Test of insertKunjungan method, of class IsiRekamMedisController.
     */
    @Test
    public void testInsertKunjungan() throws Exception {
        client = new ClientSocket();
        System.out.println("insertKunjungan");
        String idKunjungan = "VIS-20150511-001";
        String idPasien = "0011445423";
        String idRekamMedik = "REKMED-20150511-001";
        String tglKunjungan = "2015-05-11";
        int biaya = 25000;
        IsiRekamMedisController instance = new IsiRekamMedisController(client);
        boolean result = instance.insertKunjungan(idKunjungan, idPasien, idRekamMedik, tglKunjungan, biaya);
        assertTrue(result);
        instance.deleteKunjungan("VIS-20150511-001");
        instance.deleteRekamMedik("REKMED-20150511-001");
    }

    /**
     * Test of getNamaObat method, of class IsiRekamMedisController.
     */
    @Test
    public void testGetNamaObat() throws Exception {
        client = new ClientSocket();
        System.out.println("getNamaObat");
        IsiRekamMedisController instance = new IsiRekamMedisController(client);
        DefaultComboBoxModel result = instance.getNamaObat();
        boolean resultCondition = false;
        if (result.getSize() >= 1) {
            resultCondition = true;
        }
        assertTrue(resultCondition);
    }

    /**
     * Test of getNamaPenyakit method, of class IsiRekamMedisController.
     */
    @Test
    public void testGetNamaPenyakit() throws Exception {
        client = new ClientSocket();
        System.out.println("getNamaPenyakit");
        IsiRekamMedisController instance = new IsiRekamMedisController(client);
        DefaultComboBoxModel result = instance.getNamaPenyakit();
        boolean resultCondition = false;
        if (result.getSize() >= 1) {
            resultCondition = true;
        }
        assertTrue(resultCondition);
    }

    /**
     * Test of cekIdPasien method, of class IsiRekamMedisController.
     */
    @Test
    public void testCekIdPasien() throws Exception {
        client = new ClientSocket();
        System.out.println("cekIdPasien");
        String idPasien = "0011445423";
        IsiRekamMedisController instance = new IsiRekamMedisController(client);
        boolean result = instance.cekIdPasien(idPasien);
        assertTrue(result);
    }

    /**
     * Test of getDateNow method, of class IsiRekamMedisController.
     */
    @Test
    public void testGetDateNow() throws Exception {
        client = new ClientSocket();
        System.out.println("getDateNow");
        IsiRekamMedisController instance = new IsiRekamMedisController(client);
        String expResult = "2015-05-11";
        String result = instance.getDateNow();
        assertEquals(expResult, result);
    }
}
