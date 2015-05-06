/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismaserver.entity;

import carismainterface.entity.Obat;
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
 * @author Hana Mahrifah
 */
public class ObatEntityTest {
    Main ui = new Main ("carisma");
    
    public ObatEntityTest() {
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
     * Test of insertObat method, of class ObatEntity.
//     */
//    @Test
//    public void testInsertObat() throws Exception {
//        System.out.println("insertObat");
//        Obat obat = null;
//        ObatEntity instance = new ObatEntity();
//        instance.insertObat(obat);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateObat method, of class ObatEntity.
//     */
//    @Test
//    public void testUpdateObat() throws Exception {
//        System.out.println("updateObat");
//        Obat obat = null;
//        ObatEntity instance = new ObatEntity();
//        instance.updateObat(obat);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteObat method, of class ObatEntity.
//     */
//    @Test
//    public void testDeleteObat() throws Exception {
//        System.out.println("deleteObat");
//        String idobat = "";
//        ObatEntity instance = new ObatEntity();
//        instance.deleteObat(idobat);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getObat method, of class ObatEntity.
     */
    @Test
    public void testGetObat_String() throws Exception {
        System.out.println("getObat");
        String idobat = "1";
        ObatEntity instance = new ObatEntity(ui);
        Obat expResult = new Obat();
        expResult.setIdObat(1);
//        expResult.setNamaObat("Acetosala");
//        expResult.setQtyObat(23);
//        expResult.setJenisObat("Analgesika");
//        expResult.setKeterangan("");
//        expResult.setHargajualObat(100000);
//        expResult.setStokkritisObat(23);
        Obat result = instance.getObat(idobat);
        assertEquals(expResult, result);
    }

    /**
     * Test of getObat method, of class ObatEntity.
     */
//    @Test
//    public void testGetObat_0args() throws Exception {
//        System.out.println("getObat");
//        ObatEntity instance = new ObatEntity();
//        List<Obat> expResult = null;
//        List<Obat> result = instance.getObat();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getObatbyName method, of class ObatEntity.
//     */
//    @Test
//    public void testGetObatbyName() throws Exception {
//        System.out.println("getObatbyName");
//        String namaobat = "";
//        ObatEntity instance = new ObatEntity();
//        List<Obat> expResult = null;
//        List<Obat> result = instance.getObatbyName(namaobat);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
