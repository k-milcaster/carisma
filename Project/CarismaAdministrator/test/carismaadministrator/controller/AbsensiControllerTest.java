
package carismaadministrator.controller;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class AbsensiControllerTest {
    
    ClientSocket client ;
    
    public AbsensiControllerTest() {
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
     * Test of insertAbsensiDokter method, of class AbsensiController.
     */
    @Test
    public void testInsertAbsensiDokter() throws Exception {
        client = new ClientSocket();
        System.out.println("insertAbsensiDokter");
        String idDokter = "DOK0404994";
        String kehadiranReguler = "1";
        String kehadiranLembur = "0";
        String tanggalKehadiran = "2015-05-15";
        AbsensiController instance = new AbsensiController(client);
        boolean result = instance.insertAbsensiDokter(idDokter, kehadiranReguler, kehadiranLembur, tanggalKehadiran);
        assertTrue(result);
        //instance.deleteAbsensiDokter(idDokter);
    }

    /**
     * Test of deleteAbsensiDokter method, of class AbsensiController.
     */
    @Test
    public void testDeleteAbsensiDokter() throws Exception {
        client = new ClientSocket();
        System.out.println("deleteAbsensiDokter");
        String idDokter = "DOK0404994";
        AbsensiController instance = new AbsensiController(client);
        boolean result = instance.deleteAbsensiDokter(idDokter);
        assertTrue(result);
    }

    /**
     * Test of insertAbsensiPegawai method, of class AbsensiController.
     */
    @Test
    public void testInsertAbsensiPegawai() throws Exception {
        client = new ClientSocket();
        System.out.println("insertAbsensiPegawai");
        String idPegawai = "EMP19880319001";
        String kehadiranReguler = "1";
        String kehadiranLembur = "0";
        String tanggalKehadiran = "2015-05-15";
        AbsensiController instance = new AbsensiController(client);
        boolean result = instance.insertAbsensiPegawai(idPegawai, kehadiranReguler, kehadiranLembur, tanggalKehadiran);
        assertTrue(result);
    }

    /**
     * Test of deleteAbsensiPegawai method, of class AbsensiController.
     */
    @Test
    public void testDeleteAbsensiPegawai() throws Exception {
        client = new ClientSocket();
        System.out.println("deleteAbsensiPegawai");
        String idPegawai = "EMP19880319001";
        AbsensiController instance = new AbsensiController(client);
        boolean result = instance.deleteAbsensiPegawai(idPegawai);
        assertTrue(result);
    }

    /**
     * Test of getIdDokter method, of class AbsensiController.
     */
    @Test
    public void testGetIdDokter() throws Exception {
        client = new ClientSocket();
        System.out.println("getIdDokter");
        AbsensiController instance = new AbsensiController(client);
        DefaultComboBoxModel result = instance.getIdDokter();
        boolean resultCondition = false;
        if (result.getSize() >= 1) {
            resultCondition = true;
        }
        assertTrue(resultCondition);
    }

    /**
     * Test of getTabelAbsensiDokter method, of class AbsensiController.
     */
    @Test
    public void testGetTabelAbsensiDokter() throws Exception {
        client = new ClientSocket();
        System.out.println("getTabelAbsensiDokter");
        AbsensiController instance = new AbsensiController(client);
        DefaultTableModel result = instance.getTabelAbsensiDokter();
        boolean resultCondition = false;
        if (result.getRowCount() >= 1) {
            resultCondition = true;
        }
        assertTrue(resultCondition);
    }

    /**
     * Test of getIdPegawai method, of class AbsensiController.
     */
    @Test
    public void testGetIdPegawai() throws Exception {
        client = new ClientSocket();
        System.out.println("getIdPegawai");
        AbsensiController instance = new AbsensiController(client);
        DefaultComboBoxModel result = instance.getIdPegawai();
        boolean resultCondition = false;
        if (result.getSize() >= 1) {
            resultCondition = true;
        }
        assertTrue(resultCondition);
    }

    /**
     * Test of getTabelAbsensiPegawai method, of class AbsensiController.
     */
    @Test
    public void testGetTabelAbsensiPegawai() throws Exception {
        client = new ClientSocket();
        System.out.println("getTabelAbsensiPegawai");
        AbsensiController instance = new AbsensiController(client);
        DefaultTableModel result = instance.getTabelAbsensiPegawai();
        boolean resultCondition = false;
        if (result.getRowCount() >= 1) {
            resultCondition = true;
        }
        assertTrue(resultCondition);
    }

    /**
     * Test of getNamaPegawai method, of class AbsensiController.
     */
    @Test
    public void testGetNamaPegawai() throws Exception {
        client = new ClientSocket();
        System.out.println("getNamaPegawai");
        String username = "staff1";
        AbsensiController instance = new AbsensiController(client);
        String[] expResult = new String[2];
        expResult[0] = "Ariana Grande";
        String[] result = instance.getNamaPegawai(username);
        assertArrayEquals(expResult, result);
    }
}
