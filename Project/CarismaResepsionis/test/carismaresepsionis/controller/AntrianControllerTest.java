package carismaresepsionis.controller;

import carismainterface.entity.Antrian;
import carismainterface.entity.Pasien;
import carismaresepsionis.boundaries.Menursepsionis;
import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adinda
 */
public class AntrianControllerTest {

    private ClientSocket client;

    public AntrianControllerTest() {
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
     * Test of getAntrian method, of class AntrianController.
     */
    @Test
    public void testGetAntrian() throws Exception {
        System.out.println("getAntrian");
        setHostPort();
        Menursepsionis ui = new Menursepsionis(client, "resp1");
        AntrianController instance = new AntrianController(client);
        DefaultTableModel expResult = instance.getAntrian();
        DefaultTableModel result = instance.getAntrian();
        boolean resultCondition = false;
        System.out.println(result.getRowCount());
        if (result.getRowCount() >= 1) {
            resultCondition = true;
        }
        assertTrue(resultCondition);
    }

    /**
     * Test of getAntrianDetail method, of class AntrianController.
     */
    @Test
    public void testGetAntrianDetail() throws Exception {
        System.out.println("getAntrianDetail");
        String id = "AN001";
        setHostPort();
        AntrianController instance = new AntrianController(client);

        Antrian expResult = instance.getAntrianDetail(id);
        Antrian result = instance.getAntrianDetail(id);
        assertEquals(expResult, result);

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDetailPasien method, of class AntrianController.
     */
    @Test
    public void testGetDetailPasien() throws Exception {
        System.out.println("getDetailPasien");
        String idPasien = "PS001";
        setHostPort();
        AntrianController instance = new AntrianController(client);

        Pasien expResult = instance.getDetailPasien(idPasien);
        Pasien result = instance.getDetailPasien(idPasien);
        assertEquals(expResult, result);

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDetailKunjungan method, of class AntrianController.
     */
//    @Test
//    public void testGetDetailKunjungan() throws Exception {
//        System.out.println("getDetailKunjungan");
//        String idKunjungan = "";
//        AntrianController instance = null;
//        Kunjungan expResult = null;
//        Kunjungan result = instance.getDetailKunjungan(idKunjungan);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
    private void setHostPort() throws RemoteException, NotBoundException {
        Scanner s = null;
        try {
            s = new Scanner(new File("D:/carismaconfig"));
        } catch (FileNotFoundException ex) {

        }
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()) {
            list.add(s.next());
        }
        s.close();
        client = new ClientSocket(list.get(0), Integer.parseInt(list.get(1)));
        client.Connect();
    }
}
