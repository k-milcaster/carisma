package carismaresepsionis.controller;

/**
 *
 * @author Fiqhi Darmawan
 */
import carismainterface.entity.Antrian;
import carismainterface.entity.Dokter;
import carismainterface.entity.Pasien;
import carismainterface.entity.Poli;
import carismainterface.server.AntrianService;
import carismainterface.server.DokterService;
import carismainterface.server.PasienService;
import carismainterface.server.PoliService;
import carismaresepsionis.boundaries.antrianoffline;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AntrianOfflineController {

    private PasienService pasienService;
    private AntrianService antrianService;
    private PoliService poliService;
    private DokterService dokterService;

    public AntrianOfflineController(ClientSocket client) throws RemoteException {
        this.pasienService = client.getPasienService();
        this.antrianService = client.getAntrianService();
        this.poliService = client.getPoliService();
        this.dokterService = client.getDokterService();
    }

    public void InsertAntrian(String id_pasien, String id_dokter, String tanggalAntri) throws RemoteException, DocumentException, BadElementException, IOException {

        Pasien pasien = new Pasien();
        Antrian antrian = new Antrian();

        int nomer_antrian = antrianService.generateNomorAntrian(tanggalAntri);
        String id_antrian = antrianService.generateIDAntrian();
        antrian.setIdAntrian(id_antrian);
        antrian.setPasienIdPasien(id_pasien);
        antrian.setDokterIdDokter(id_dokter);
        antrian.setNomorAntrian(nomer_antrian);
        antrian.setJenisAntrian("OFFLINE");
        antrian.setTglAntrian(tanggalAntri);
        antrian.setHadir("-");
        System.out.println("hasil generate ID=" + id_antrian);
        System.out.println("hasil generate nomor=" + nomer_antrian);
//        System.out.println("hasil role=" +role);
        if (antrianService.insertAntrian(antrian) == true) {
            String dest = "D:\\antrean" + id_antrian + ".pdf";
            File file = new File(dest);
            file.getParentFile().mkdirs();
            cetak(id_antrian, dest);
            System.out.println("SUKSES");
        } else {
            System.out.println("FALSE");
        }
    }

    public void setComboBoxPoli(antrianoffline ua) {
        List<Poli> list = new ArrayList();
        try {
            list = poliService.getPoli();
            ua.polidokter.addItem("- Pilih Poli -");
        } catch (RemoteException ex) {
            Logger.getLogger(regispasiencontroller.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < list.size(); i++) {
            ua.polidokter.addItem(list.get(i).getNamaPoli());

        }
    }

    public DefaultTableModel getDokterList() throws RemoteException {
        List<Dokter> list = new ArrayList<Dokter>();
        list = dokterService.getDokter();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Dokter");
        model.addColumn("Nama Dokter");
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getIdDokter(), list.get(i).getNamaDokter()});
        }
        //ui.TabelDokter.setModel(model);
        return model;
    }

    private void cetak(String idAntrean, String dest) throws DocumentException, FileNotFoundException, BadElementException, IOException {

        String IMG1 = "back.jpg";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(400);
        table.setLockedWidth(true);
        PdfPCell cell = new PdfPCell();
        Font font = new Font(FontFamily.HELVETICA, 72, Font.NORMAL, BaseColor.BLACK);
        Paragraph p = new Paragraph(" ", font);
        cell.addElement(p);
        p = new Paragraph(idAntrean, font);
        p.setAlignment(cell.ALIGN_CENTER);
        cell.addElement(p);
        Image image = Image.getInstance(IMG1);
        cell.setCellEvent(new ImageBackgroundEvent(image));
        cell.setFixedHeight(400 * image.getScaledHeight() / image.getScaledWidth());
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
