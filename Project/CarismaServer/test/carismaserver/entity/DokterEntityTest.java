/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaserver.entity;

import carismainterface.entity.Dokter;
import carismaserver.boundaries.Main;
import java.util.List;
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
public class DokterEntityTest {
    Main ui = new Main("carisma");
    public DokterEntityTest() {
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
     * Test of insertDokter method, of class DokterEntity.
     */
//    @Test
//    public void testInsertDokter() throws Exception {
//        System.out.println("insertDokter");
//        Dokter dokter = null;
//        DokterEntity instance = new DokterEntity();
//        instance.insertDokter(dokter);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateDokter method, of class DokterEntity.
//     */
//    @Test
//    public void testUpdateDokter() throws Exception {
//        System.out.println("updateDokter");
//        Dokter dokter = null;
//        DokterEntity instance = new DokterEntity();
//        instance.updateDokter(dokter);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteDokter method, of class DokterEntity.
//     */
//    @Test
//    public void testDeleteDokter() throws Exception {
//        System.out.println("deleteDokter");
//        String dokter = "";
//        DokterEntity instance = new DokterEntity();
//        instance.deleteDokter(dokter);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getDokter method, of class DokterEntity.
     */
    @Test
    public void testGetDokter_String() throws Exception {
        System.out.println("getDokter");
        String dok = "Fitriana Dzulfaidah";
        DokterEntity instance = new DokterEntity(ui);
        Dokter expResult = new Dokter();
        expResult.setIdDokter("DOK0404994");
        expResult.setPoliIdPoli("POL01");
        expResult.setUserIdUser(2);
        expResult.setNamaDokter("Fitriana Dzulfaidah");
        expResult.setAlamatDokter("Perum. Wisma Permai Blok G No 07 - Surabaya");
        expResult.setNokartuidDokter("7249235829582348");
        expResult.setTelpDokter("031-89305589");
        expResult.setHp1Dokter("0823311202208");
        expResult.setHp2Dokter("083847418604");
        expResult.setTempatlahirDokter("Banyuwangi");
        expResult.setTgllahirDokter("1994-04-04");
        expResult.setKelaminDokter("P");
        expResult.setDarahDokter("O");
        expResult.setBankDokter("BCA");
        expResult.setNorekDokter("110283794374");
        expResult.setFotoDokter(null);
        expResult.setGajifixDokter(5000000);
        expResult.setGajilemburDokter(500000);
        expResult.setGajikonsulDokter(250000.0);
        Dokter result = instance.getDokter(dok);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDokter method, of class DokterEntity.
     */
//    @Test
//    public void testGetDokter_0args() throws Exception {
//        System.out.println("getDokter");
//        DokterEntity instance = new DokterEntity();
//        List expResult = null;
//        List result = instance.getDokter();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getIdNamaDokter method, of class DokterEntity.
     */
    @Test
    public void testGetIdNamaDokter() throws Exception {
        System.out.println("getIdNamaDokter");
        String username = "dok1";
        DokterEntity instance = new DokterEntity(ui);
        String[] expResult = new String[2];
        expResult[0] = "DOK0404994";
        expResult[1] = "Fitriana Dzulfaidah";
        String[] result = instance.getIdNamaDokter(username);
        assertArrayEquals(expResult, result);
    }
}
