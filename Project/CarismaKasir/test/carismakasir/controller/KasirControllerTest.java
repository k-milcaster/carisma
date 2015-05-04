package carismakasir.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import carismakasir.controller.ClientSocket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import static org.junit.Assert.*;

/**
 *
 * @author K-MiL Caster
 */
public class KasirControllerTest {

    ClientSocket client;

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
        System.out.println("showBiaya");
        client = new ClientSocket();
        String idKunjungan = "kun1";
        KasirController instance = new KasirController(client, null);
        instance.showBiaya(idKunjungan);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of cetak method, of class KasirController.
     */
    @Test
    public void testCetak() throws Exception {
        System.out.println("cetak");
        KasirController instance = null;
        instance.cetak();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
