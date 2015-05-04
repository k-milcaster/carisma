/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaserver.entity;

import carismainterface.entity.Kamar;
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
public class KamarEntityTest {
    Main ui = new Main("carisma");
    public KamarEntityTest() {
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
     * Test of insertKamar method, of class KamarEntity.
     */
   /* @Test
    public void testInsertKamar() throws Exception {
        System.out.println("insertKamar");
        Kamar kamar = null;
        KamarEntity instance = new KamarEntity();
        instance.insertKamar(kamar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateKamar method, of class KamarEntity.
     */
    /*@Test
    public void testUpdateKamar() throws Exception {
        System.out.println("updateKamar");
        Kamar kamar = null;
        KamarEntity instance = new KamarEntity();
        instance.updateKamar(kamar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteKamar method, of class KamarEntity.
     */
    /*@Test
    public void testDeleteKamar() throws Exception {
        System.out.println("deleteKamar");
        String idkamar = "";
        KamarEntity instance = new KamarEntity();
        instance.deleteKamar(idkamar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKamar method, of class KamarEntity.
     */
    @Test
    public void testGetKamar_String() throws Exception {
        System.out.println("getKamar");
        String idkamar = "103";
        
        KamarEntity instance = new KamarEntity(ui);
        
        Kamar expResult = new Kamar ();
        expResult.setIdKamar(103);
        expResult.setNamaKamar("TERATAI");
        expResult.setKelas("KELAS I");
        expResult.setIsiKamar(2);
        expResult.setFasilitasKamar("TV, AC, almari pakaian, kamar mandi di dalam");
        expResult.setTarif(150000);
        Kamar result = instance.getKamar(idkamar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       //fail("The test case is a prototype.");
    }

    /**
     * Test of getKamar method, of class KamarEntity.
     */
   /* @Test
    public void testGetKamar_0args() throws Exception {
        System.out.println("getKamar");
        KamarEntity instance = new KamarEntity();
        List expResult = null;
        List result = instance.getKamar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}
