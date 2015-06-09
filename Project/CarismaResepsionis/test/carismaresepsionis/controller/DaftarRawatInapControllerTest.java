package carismaresepsionis.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
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
public class DaftarRawatInapControllerTest {

    private ClientSocket client;

    public DaftarRawatInapControllerTest() {
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
     * Test of insertNamaPasien method, of class DaftarRawatInapController.
     */
    @Test
    public void testInsertNamaPasien() throws Exception {
        System.out.println("insertNamaPasien");
        String namaPasien = "Pevita";
        String idPasien = "PAS004";
        int idKamar = 202;
        String namaKamar = "EDELWEIS";
        String kelasKamar = "UTAMA";
        String tarif = "245000";
        String tanggal = "2015-05-04";
        setHostPort();
        DaftarRawatInapController instance = new DaftarRawatInapController(client);
        boolean expResult = true;
        boolean result = instance.insertNamaPasien( idPasien, idKamar, namaKamar,  tanggal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of generatePeminjamanId method, of class DaftarRawatInapController.
     */
    @Test
    public void testGeneratePeminjamanId() throws RemoteException, NotBoundException {
        System.out.println("generatePeminjamanId");
        String idPasien = "PAS004";
        String namaKamar = "EDELWEIS";
        setHostPort();
        DaftarRawatInapController instance = new DaftarRawatInapController(client);
        String expResult = "PAS004";
        String result = instance.generatePeminjamanId(idPasien, namaKamar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
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
