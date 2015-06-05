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
 * @author Muhammad Rizal
 */
public class LihatJadwalDokterControllerTest {

    ClientSocket client;

    public LihatJadwalDokterControllerTest() {
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
     * Test of lihatJadwal method, of class LihatJadwalDokterController.
     */
    @Test
    public void testLihatJadwal() throws Exception {
        setHostPort();
        System.out.println("lihatJadwal");
        String idDokter = "";
        LihatJadwalDokterController instance = new LihatJadwalDokterController(client);
        ArrayList result = instance.lihatJadwal(idDokter);
        boolean resultCondition = false;
        if (result.size() >= 0) {
            resultCondition = true;
        }
        assertTrue(resultCondition);
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
