package carismakasir.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import carismakasir.controller.ClientSocket;
import carismakasir.boundary.Kasir;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static org.junit.Assert.*;

/**
 *
 * @author K-MiL Caster
 */
public class KasirControllerTest {

    ClientSocket client;
    Kasir ui;
    public KasirControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws RemoteException, NotBoundException {
        client = new ClientSocket();

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of showBiaya method, of class KasirController.
     */
    @Test
    public void testShowBiaya() throws Exception {
        System.out.println("showBiayaBerhasil");
        client = new ClientSocket();
        String idKunjungan = "kun1";
        KasirController instance = new KasirController(client, null);
        DefaultTableModel result = instance.showBiaya(idKunjungan);
        boolean resultCondition = false;
        if (result.getRowCount() >= 1) {
            resultCondition = true;
        }
        assertTrue(resultCondition); //ketika ketemu

        System.out.println("showBiayaGagal");
        client = new ClientSocket();
        idKunjungan = "0";        
        result = instance.showBiaya(idKunjungan);
        resultCondition = false;
        if (result.getRowCount() >= 1) {
            resultCondition = true;
        }
        assertFalse(resultCondition); //ketika tidak ketemu        
    }
    /**
     * Test of sumTotal method, of class KasirController.
     */
    @Test
    public void testSumTotal() throws RemoteException {
        System.out.println("sumTotal");
        KasirController instance = new KasirController(client, null);
        TableModel model = instance.showBiaya("kun1");
        int expResult = 1260000;
        int result = instance.sumTotal(model);
        assertEquals(expResult, result);

    }

    /**
     * Test of doBayar method, of class KasirController.
     */
    @Test
    public void testDoBayar() throws Exception {
        System.out.println("doBayarBenar");
        int pembayaran = 1000;
        int biaya = 500;
        KasirController instance = new KasirController(client, null);
        boolean result = instance.doBayar(pembayaran, biaya);
        assertTrue(result);
        
        pembayaran = 100;
        biaya = 500;       
        result = instance.doBayar(pembayaran, biaya);
        assertFalse(result);        
        
    }

}
