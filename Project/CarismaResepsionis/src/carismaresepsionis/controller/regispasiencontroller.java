package carismaresepsionis.controller;

import carismainterface.entity.Kota;
import carismainterface.entity.Pasien;
import carismainterface.entity.Poli;
import carismainterface.entity.User;
import carismainterface.server.KotaService;
import carismainterface.server.PasienService;
import carismainterface.server.PoliService;
import carismainterface.server.UserService;
import carismaresepsionis.boundaries.Rawatinap;
import carismaresepsionis.boundaries.antrianoffline;
import carismaresepsionis.boundaries.regispasienform;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fiqhi Darmawan
 */
public class regispasiencontroller {

    private PasienService pasienService;
    private KotaService kotaService;
    private UserService userService;
    private PoliService poliService;

    public regispasiencontroller(ClientSocket client) throws RemoteException {
        this.pasienService = client.getPasienService();
        this.kotaService = client.getKotaService();
        this.userService = client.getUserService();
        this.poliService = client.getPoliService();
    }

    public void InsertNamaPasien(String kota_id_kota, String nama_pasien, String alamat_pasien, String kartuid_pasien, String nokartuid_pasien, String telp_pasien, String hp_pasien, String tempatlahirpasien, String tgllahir_pasien, String kelamin_pasien, String darah_pasien, int berat_pasien, int tinggi_Pasien, String regdate_pasien, String username) throws RemoteException {
        Pasien pasien = new Pasien();
        User user = new User();
		String idPasien = generatePasienId(nama_pasien, tgllahir_pasien, nokartuid_pasien);
        System.out.println(generatePasienId(nama_pasien, tgllahir_pasien, nokartuid_pasien));
        pasien.setIdPasien(generatePasienId(nama_pasien, tgllahir_pasien, nokartuid_pasien));
        pasien.setKotaIdKota(kota_id_kota);
        pasien.setNamaPasien(nama_pasien);
        pasien.setAlamatPasien(alamat_pasien);
        pasien.setKartuidPasien(kartuid_pasien);
        pasien.setNokartuidPasien(nokartuid_pasien);
        pasien.setTelpPasien(telp_pasien);
        pasien.setHpPasien(hp_pasien);
        pasien.setTempatlahirPasien(tempatlahirpasien);
        pasien.setTgllahirPasien(tgllahir_pasien);
        pasien.setKelaminPasien(kelamin_pasien);
        pasien.setDarahPasien(darah_pasien);
        pasien.setBeratPasien(berat_pasien);
        pasien.setTinggiPasien(tinggi_Pasien);
        pasien.setRegdatePasien(regdate_pasien);
        user = userService.getUser(username);
        pasien.setUserIdUser(Integer.toString(user.getIdUser()));
        boolean inserted = pasienService.insertPasien(pasien);

        if (inserted == true) {
            String dest = "D:\\Kartu Pasien" + idPasien + ".pdf";
            File file = new File(dest);
            file.getParentFile().mkdirs();
            cetak(idPasien, nama_pasien, alamat_pasien, tgllahir_pasien, kelamin_pasien, dest);
            System.out.println("SUKSES");
        } else {
            System.out.println("FALSE");

        }
    }

    public boolean cekKartuId(String idCard) throws RemoteException{
        return pasienService.isUsedNokartuPasien(idCard);
    }
	
    public void InsertUser(String username, String Password, String role) throws RemoteException {

        User user = new User();
        user.setUsername(username);
        user.setPassword(Password);
        user.setRegistered(generatetanggal());
        user.setRole(role);
        userService.insertUser(user);
    }

    public String generatetanggal() {
        String tanggal;
        String bulan;
        Date date = new Date();
        if (date.getMonth() > 8) {
            bulan = Integer.toString((date.getMonth() + 1));
        } else {
            bulan = "0" + Integer.toString((date.getMonth() + 1));
        }
        tanggal = Integer.toString((date.getYear() + 1900)) + "-" + bulan + "-" + Integer.toString(date.getDate()) + " " + Integer.toString(date.getHours()) + ":" + Integer.toString(date.getMinutes()) + ";" + Integer.toString(date.getSeconds());
        return tanggal;
    }

    public String generateUserName(String nama, String tgl) {

        String[] firstName = nama.split(" ");
        char[] tglLahir = tgl.toCharArray();
        char[] dateOnly = new char[2];
        //2015-01-01
        for (int i = 0; i < 2; i++) {
            dateOnly[i] = tglLahir[i + 8];
        }
        String userName = firstName[0].concat(String.valueOf(dateOnly));
        return userName;

    }

    public String generatePasienId(String Nama, String tgl, String end) {
        String pasienId = Character.toString(Nama.charAt(0)).toUpperCase() + Character.toString(Nama.charAt(Nama.length() - 1)).toUpperCase() + Character.toString(tgl.charAt(2)) + Character.toString(tgl.charAt(3)) + Character.toString(tgl.charAt(5)) + Character.toString(tgl.charAt(6)) + Character.toString(tgl.charAt(8)) + Character.toString(tgl.charAt(9)) + Character.toString(end.charAt(end.length() - 1)) + Character.toString(end.charAt(end.length() - 2));
        return pasienId;
    }

    public void setComboBoxKota(regispasienform ui) {
        List<Kota> list = new ArrayList();
        try {
            list = kotaService.getKota();
        } catch (RemoteException ex) {
            Logger.getLogger(regispasiencontroller.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < list.size(); i++) {
            ui.Kota.addItem(list.get(i).getNamaKota());
        }
    }

    public int ambilidkota(int urutan) {
        List<Kota> list = new ArrayList();
        try {
            list = kotaService.getKota();
        } catch (RemoteException ex) {
            Logger.getLogger(regispasiencontroller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Integer.parseInt(list.get(urutan - 1).getId_kota());
    }

    public void getTabelPasien(regispasienform ui) throws RemoteException {

        List<Pasien> list = new ArrayList<Pasien>();
        list = pasienService.getPasien();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Pasien");
        model.addColumn("Nama Pasien");
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getIdPasien(), list.get(i).getNamaPasien()});
        }
        ui.tabelpasien.setModel(model);

    }

    public Pasien getDataPasien(String id) {
        try {
            return pasienService.getPasien(id);
        } catch (RemoteException ex) {
            Logger.getLogger(regispasiencontroller.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public DefaultTableModel getPasienByName(String nama) throws RemoteException {
        List<Pasien> list = new ArrayList<Pasien>();
        DefaultTableModel model = new DefaultTableModel();
        list = pasienService.getPasienByName(nama);
        model.addColumn("Id Pasien");
        model.addColumn("Nama Pasien");
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getIdPasien(), list.get(i).getNamaPasien()});
        }
        return model;
    }
	
	private void cetak(String idPasien, String namaPasien, String alamat, String tanggalLahir, String jenisKelamin, String dest) throws DocumentException, FileNotFoundException, BadElementException, IOException {
        String IMG1 = "Kartu Pasien.png";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(280);
        table.setLockedWidth(true);
        PdfPCell cell = new PdfPCell();
        Font font = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.RED);
        Font space = new Font(Font.FontFamily.HELVETICA, 25, Font.NORMAL, BaseColor.RED);
        Font space1 = new Font(Font.FontFamily.HELVETICA, 1, Font.NORMAL, BaseColor.RED);
        Paragraph idPasienPar;
        Paragraph namaPasienPar;
        Paragraph alamatPar;
        Paragraph tanggalLahirPar;
        Paragraph jenisKelaminPar;
        Paragraph spasi = new Paragraph(" ", space);
        Paragraph spasi1 = new Paragraph(" ", space1);
        idPasienPar = new Paragraph("                                      " + idPasien, font);
        namaPasienPar = new Paragraph("                                      " + namaPasien, font);
        tanggalLahirPar = new Paragraph("                                      " + tanggalLahir, font);
        jenisKelaminPar = new Paragraph("                                      " + jenisKelamin, font);
        alamatPar = new Paragraph("                                      " + alamat, font);
        idPasienPar.setAlignment(cell.ALIGN_LEFT);
        namaPasienPar.setAlignment(cell.ALIGN_LEFT);
        alamatPar.setAlignment(cell.ALIGN_LEFT);
        tanggalLahirPar.setAlignment(cell.ALIGN_LEFT);
        jenisKelaminPar.setAlignment(cell.ALIGN_LEFT);
        cell.addElement(spasi);
        cell.addElement(idPasienPar);
        cell.addElement(namaPasienPar);
        cell.addElement(spasi1);
        cell.addElement(tanggalLahirPar);
        cell.addElement(jenisKelaminPar);
        cell.addElement(spasi1);
        cell.addElement(alamatPar);
        Image image = Image.getInstance(IMG1);
        cell.setCellEvent(new ImageBackgroundEvent(image));
        cell.setFixedHeight(259 * image.getScaledHeight() / image.getScaledWidth());
        table.addCell(cell);
        document.add(table);
        document.close();
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + dest);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}