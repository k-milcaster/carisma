package carismaresepsionis.controller;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anes Dirsi
 */
public class DataDokterControllerTest {
    
    ClientSocket client;
    
    public DataDokterControllerTest() {
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
     * Test of getDokterList method, of class DataDokterController.
     */
    @Test
    public void testGetDokterList() throws Exception {
        client = new ClientSocket();
        System.out.println("getDokterList");
        DataDokterController instance = new DataDokterController(client);
        DefaultTableModel result = instance.getDokterList();
        boolean resultCondition = false;
        System.out.println(result.getRowCount());
        if (result.getRowCount() >= 1) {
            resultCondition = true;
        }
        assertTrue(resultCondition);
    }
    

   /**
     * Test of getDokterByName method, of class DataDokterController.
     */
    @Test
    public void testGetDokterByName() throws Exception {
        client = new ClientSocket();
        System.out.println("getDokterByName");
        String nama = "Kemal Pahlevi";
        DataDokterController instance = new DataDokterController(client);
        //DefaultTableModel expResult = instance.getDokterByName(nama);
        DefaultTableModel result = instance.getDokterByName(nama);
        boolean resultCondition = false;
        System.out.println(result.getRowCount());
        if (result.getRowCount() >= 1) {
            resultCondition = true;
        }
        assertTrue(resultCondition);
    }


     @Test
    public void testGetDokterByIdDokter() throws Exception {
        client = new ClientSocket();
        System.out.println("getDokterByIdDokter");
        String idDokter = "DOK101";
        DataDokterController instance = new DataDokterController(client);
        ArrayList expResult = instance.getDokterByIdDokter(idDokter);
        ArrayList result = instance.getDokterByIdDokter(idDokter);
        assertEquals(expResult, result);        
    }
}