/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaserver.entity;

import carismainterface.entity.PasienKamar;
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
 * @author Vaio Sony
 */
public class PasienKamarEntityTest {
    Main ui = new Main("carisma");
    public PasienKamarEntityTest() {
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
     * Test of insertPasienKamar method, of class PasienKamarEntity.
     */
    /*@Test
    public void testInsertPasienKamar() throws Exception {
        System.out.println("insertPasienKamar");
        PasienKamar pasienKamar = null;
        PasienKamarEntity instance = new PasienKamarEntity();
        instance.insertPasienKamar(pasienKamar);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updatePasienKamar method, of class PasienKamarEntity.
     */
    /*@Test
    public void testUpdatePasienKamar() throws Exception {
        System.out.println("updatePasienKamar");
        PasienKamar pasienKamar = null;
        PasienKamarEntity instance = new PasienKamarEntity();
        instance.updatePasienKamar(pasienKamar);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deletePasienKamar method, of class PasienKamarEntity.
     */
   /* @Test
    public void testDeletePasienKamar() throws Exception {
        System.out.println("deletePasienKamar");
        String idpeminjaman = "";
        PasienKamarEntity instance = new PasienKamarEntity();
        instance.deletePasienKamar(idpeminjaman);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPasienKamar method, of class PasienKamarEntity.
     */
    @Test
    public void testGetPasienKamar_String() throws Exception {
        System.out.println("getPasienKamar");
        
        String idpeminjaman = "KAM1";
        
        PasienKamarEntity instance = new PasienKamarEntity(ui);
        PasienKamar expResult = new PasienKamar();
        expResult.setIdPeminjaman("KAM1");
        expResult.setKamarIdKamar(103);
        expResult.setDateinPasienKamar("2015-05-04 00:00:00");
        expResult.setDateoutPasienKamar("2015-05-08 00:00:00");
        expResult.setKeterangan("Sembuh");
        
        PasienKamar result = instance.getPasienKamar(idpeminjaman);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPasienKamar method, of class PasienKamarEntity.
     */
   /* @Test
    public void testGetPasienKamar_0args() throws Exception {
        System.out.println("getPasienKamar");
        PasienKamarEntity instance = new PasienKamarEntity();
        List<PasienKamar> expResult = new List();
        List result = instance.getPasienKamar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
         
    }*/
}
