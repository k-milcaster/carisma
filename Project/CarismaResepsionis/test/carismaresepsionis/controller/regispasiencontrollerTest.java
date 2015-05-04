/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaresepsionis.controller;

import carismainterface.server.AntrianService;
import carismainterface.server.KotaService;
import carismainterface.server.KunjunganService;
import carismainterface.server.PasienService;
import carismainterface.server.UserService;
import carismaresepsionis.boundaries.regispasienform;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fiqhi Darmawan
 */
public class regispasiencontrollerTest {
    
    public regispasiencontrollerTest() {
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
     * Test of InsertNamaPasien method, of class regispasiencontroller.
     */
    @Test
    public void testInsertNamaPasien() throws Exception {
        System.out.println("InsertNamaPasien");
        String id_pasien = "EO15040698";
        String kota_id_kota = "10020";
        String nama_pasien = "Muhammad Fiqhi Darmawan";
        String alamat_pasien = "Jln. Wisma Permai Tengah No.10 Blok AA";
        String kartuid_pasien = "123456789";
        String nokartuid_pasien = "987654321";
        String telp_pasien = "031332546";
        String hp_pasien = "081211631007";
        String tempatlahirpasien = "Surabaya";
        String tgllahir_pasien = "2015-04-06";
        String kelamin_pasien = "L";
        String darah_pasien = "O";
        int berat_pasien = 80;
        int tinggi_Pasien = 178;
        String regdate_pasien = "2015-04-28";
        String username = "muhammad06";
        ClientSocket client = new ClientSocket();
        regispasiencontroller instance = new regispasiencontroller(client);
        instance.InsertNamaPasien(id_pasien, kota_id_kota, nama_pasien, alamat_pasien, kartuid_pasien, nokartuid_pasien, telp_pasien, hp_pasien, tempatlahirpasien, tgllahir_pasien, kelamin_pasien, darah_pasien, berat_pasien, tinggi_Pasien, regdate_pasien, username);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of InsertUser method, of class regispasiencontroller.
     */
    @Test
    public void testInsertUser() throws Exception {
        System.out.println("InsertUser");
        String username = "muhammad06";
        String Password = "muhammad06";
        String role = "pasien";
        ClientSocket client = new ClientSocket();
        regispasiencontroller instance = new regispasiencontroller(client);
        instance.InsertUser(username, Password, role);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of generatetanggal method, of class regispasiencontroller.
     */
    @Test
    public void testGeneratetanggal() throws RemoteException, NotBoundException {
        System.out.println("generatetanggal");
        ClientSocket client = new ClientSocket();
        regispasiencontroller instance = new regispasiencontroller(client);
        String tanggal;
        String bulan;
        Date date = new Date ();
        if (date.getMonth() > 8) {
            bulan = Integer.toString((date.getMonth()+1));
        }
        else {
            bulan = "0"+ Integer.toString((date.getMonth()+1));
        }
        tanggal = Integer.toString((date.getYear()+1900))+"-"+bulan+"-"+Integer.toString(date.getDate())+" "+Integer.toString(date.getHours())+":"+Integer.toString(date.getMinutes())+";"+Integer.toString(date.getSeconds());
        String expResult = tanggal;
        String result = instance.generatetanggal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of generateUserName method, of class regispasiencontroller.
     */
    @Test
    public void testGenerateUserName() throws RemoteException, NotBoundException {
        System.out.println("generateUserName");
        String nama = "Muhammad Fiqhi Darmawan";
        String tgl = "2015-04-01";
        ClientSocket client = new ClientSocket();
        regispasiencontroller instance = new regispasiencontroller(client);
        String expResult = "Muhammad01";
        String result = instance.generateUserName(nama, tgl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of generatePasienId method, of class regispasiencontroller.
     */
    @Test
    public void testGeneratePasienId() throws RemoteException, NotBoundException {
        System.out.println("generatePasienId");
        String Nama = "Muhammad Fiqhi Darmawan";
        String tgl = "1994-10-10";
        String end = "6789";
        ClientSocket client = new ClientSocket();
        regispasiencontroller instance = new regispasiencontroller(client);
        String expResult = "MN94101098";
        String result = instance.generatePasienId(Nama, tgl, end);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setComboBoxKota method, of class regispasiencontroller.
     */
    @Test
    public void testSetComboBoxKota() throws RemoteException, NotBoundException {
        System.out.println("setComboBoxKota");
        ClientSocket client = new ClientSocket();
        regispasienform ui = new regispasienform(client, "resp1");
        regispasiencontroller instance = new regispasiencontroller(client);
        instance.setComboBoxKota(ui);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ambilidkota method, of class regispasiencontroller.
     */
    @Test
    public void testAmbilidkota() throws RemoteException, NotBoundException {
        System.out.println("ambilidkota");
        int urutan = 5;
        ClientSocket client = new ClientSocket();
        regispasiencontroller instance = new regispasiencontroller(client);
        int expResult = 4;
        int result = instance.ambilidkota(urutan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getTabelPasien method, of class regispasiencontroller.
     */
    @Test
    public void testGetTabelPasien() throws Exception {
        System.out.println("getTabelPasien");
        ClientSocket client = new ClientSocket();
        regispasienform ui = new regispasienform(client, "resp1");
        regispasiencontroller instance = new regispasiencontroller(client);
        instance.getTabelPasien(ui);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
