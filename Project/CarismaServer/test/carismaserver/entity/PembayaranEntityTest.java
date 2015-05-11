package carismaserver.entity;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import carismaserver.boundaries.Main;
import static org.junit.Assert.*;

/**
 *
 * @author K-MiL Caster
 */
public class PembayaranEntityTest {
    Main ui = new Main("carisma");
    public PembayaranEntityTest() {
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
     * Test of getBiayaKamar method, of class PembayaranEntity.
     */
    @Test
    public void testGetBiayaKamar() throws Exception {
        System.out.println("getBiayaKamar");
        
        String idPeminjaman = "KAM1";
        PembayaranEntity instance = new PembayaranEntity(ui);
        ArrayList expResult = new ArrayList();
        expResult.add(350000);
        expResult.add(3);
        expResult.add(1050000);
        ArrayList result = instance.getBiayaKamar(idPeminjaman);
        assertEquals(expResult, result);        
    }

    /**
     * Test of getBiayaObat method, of class PembayaranEntity.
     */
    @Test
    public void testGetBiayaObat() throws Exception {
        System.out.println("getBiayaObat");
        String idTransaksi = "nyobasih";
        PembayaranEntity instance = new PembayaranEntity(ui);
        ArrayList<ArrayList> expResult = new ArrayList();
        ArrayList subList = new ArrayList();
        subList.add("Acetosal");
        subList.add(10000);
        subList.add(2);
        subList.add(20000);
        expResult.add(subList);
        subList = new ArrayList();
        subList.add("As. Mefenamat");
        subList.add(20000);
        subList.add(2);
        subList.add(40000);
        expResult.add(subList);
        ArrayList<ArrayList> result = instance.getBiayaObat(idTransaksi);
        assertEquals(expResult, result);
    }
    
}
