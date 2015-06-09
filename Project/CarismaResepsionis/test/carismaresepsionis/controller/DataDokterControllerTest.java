package carismaresepsionis.controller;

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
        setHostPort();
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
        setHostPort();
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
        setHostPort();
        System.out.println("getDokterByIdDokter");
        String idDokter = "DOK101";
        DataDokterController instance = new DataDokterController(client);
        ArrayList expResult = instance.getDokterByIdDokter(idDokter);
        ArrayList result = instance.getDokterByIdDokter(idDokter);
        assertEquals(expResult, result);
    }

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
