package carismaapoteker.controller;

import carismainterface.entity.Detailresep;
import carismainterface.entity.Detailtransaksijualobat;
import carismainterface.entity.Kunjungan;
import carismainterface.entity.Obat;
import carismainterface.entity.Transaksijualobat;
import carismainterface.server.DetailresepService;
import carismainterface.server.DetailtransaksijualobatService;
import carismainterface.server.KunjunganService;
import carismainterface.server.ObatService;
import carismainterface.server.TransaksijualobatService;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import carismainterface.server.PegawaiService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sinta Eka Lestari
 */
public class TransaksiJualObatController {

    private TransaksijualobatService transaksijualobat;
    private DetailtransaksijualobatService detailtransaksijual;
    private ObatService obatService;
    private PegawaiService pegawaiService;
    private KunjunganService kunjunganService;

    public TransaksiJualObatController(ClientSocket client) throws RemoteException {

        this.transaksijualobat = client.getTransaksijualobatService();
        obatService = client.getObatService();
        pegawaiService = client.getPegawaiService();
        detailtransaksijual = client.getDetailtransaksijualobatService();
        kunjunganService = client.getKunjunganService();
    }

    public boolean insertTransaksijualobat(String idTransaksijual, String dateTransaksijual, String keterangan) throws RemoteException {
        boolean insert = false;
        Transaksijualobat transaksijual = new Transaksijualobat();
        transaksijual.setIdTransaksijual(idTransaksijual);
        transaksijual.setDateTransaksijual(dateTransaksijual);
        transaksijual.setKeterangan(keterangan);
        insert = transaksijualobat.insertTransaksijualobat(transaksijual);
        return insert;
    }

    public boolean updateKunjungan(String idTransaksi, String idKunjungan) throws RemoteException {
        Kunjungan kun = new Kunjungan();
        kun = kunjunganService.getKunjungan(idKunjungan);
        if (kun != null) {
            kun.setTransaksijualobatIdTransaksijual(idTransaksi);
            return kunjunganService.updateKunjungan(kun);
        } else {
            return false;
        }
    }

    public boolean cekKunjungan(String idKunjungan) throws RemoteException {
        Kunjungan kun = new Kunjungan();
        kun = kunjunganService.getKunjungan(idKunjungan);
        if (kun != null) {         
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteTransaksiJualObat(String idTransaksi) throws RemoteException {
        return transaksijualobat.deleteTransaksijualobat(idTransaksi);
    }

    public boolean insertDetailtransaksijualobat(String idTransaksi, int idObat, int qty) throws RemoteException {
        boolean insertDetail = false;
        System.out.println("Masuk Insert Detail");
        Detailtransaksijualobat detailtransaksi = new Detailtransaksijualobat();
        detailtransaksi.setTransaksijualobat(idTransaksi);
        detailtransaksi.setObat(idObat);
        detailtransaksi.setQty(qty);
        insertDetail = detailtransaksijual.insertDetailtransaksijualobat(detailtransaksi);

        return insertDetail;

    }

    public boolean deleteDetailTransaksiJualObat(String idTransaksi, int idobat) throws RemoteException {
        return detailtransaksijual.deleteDetailtransaksijualobat(idTransaksi, idobat);
    }

    public DefaultTableModel getTableObat() throws RemoteException {
        List<Obat> list = new ArrayList<Obat>();
        list = obatService.getObat();
        //for (int i = 0; i < list.size(); i++){
        //b.comboBoxObat.addItem(list.get(i).getNamaObat());
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Obat");
        model.addColumn("Nama Obat");
        model.addColumn("Quantity");
        model.addColumn("Jenis");
        model.addColumn("Keterangan");
        model.addColumn("Harga Jual");
        model.addColumn("Stok Kritis");
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getIdObat(), list.get(i).getNamaObat(), list.get(i).getQtyObat(), list.get(i).getJenisObat(), list.get(i).getKeterangan(), list.get(i).getHargajualObat(), list.get(i).getStokkritisObat()});
        }
        return model;
    }
    
    public Obat cekStok(int idObat) throws RemoteException {
        Obat obat = obatService.getObat(idObat);
        return obat;
    }
    
    public boolean updateStokObat(int idObat, int qty) throws RemoteException{
        return obatService.updateStokJualObat(idObat, qty);
    }

    public String[] namaPegawai(String username) throws RemoteException {
        String[] namaApoteker = pegawaiService.getIdNamaPegawai(username);
        return namaApoteker;
    }

    public DefaultTableModel getObatbyName(String nama) throws RemoteException {
        List<Obat> list = new ArrayList<Obat>();
        list = obatService.getObatbyName(nama);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Obat");
        model.addColumn("Nama Obat");
        model.addColumn("Quantity");
        model.addColumn("Jenis");
        model.addColumn("Keterangan");
        model.addColumn("Harga Jual");
        model.addColumn("Stok Kritis");
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getIdObat(), list.get(i).getNamaObat(), list.get(i).getQtyObat(), list.get(i).getJenisObat(), list.get(i).getKeterangan(), list.get(i).getHargajualObat(), list.get(i).getStokkritisObat()});
            System.out.println(model);
        }
        return model;
    }

    public String getIdTransaksiJualObat() throws RemoteException {
        String lastIdTransaksiJualObat = transaksijualobat.getLastIdTransaksiJualObat();
        String[] splitDateNow = getDateNow().split("-");
        String dateNow = splitDateNow[0].concat(splitDateNow[1]).concat(splitDateNow[2]);
        String awalan = "TRANSSELL-".concat(dateNow).concat("-");
        String idTransaksiJualObatFix = " ";
        String getDateOnly = " ";
        System.out.println(lastIdTransaksiJualObat);
        //TRANSSELL-20150528-001
        if (lastIdTransaksiJualObat != null && !"kosong".equals(lastIdTransaksiJualObat)) {
            char[] charDate = lastIdTransaksiJualObat.toCharArray();
            char[] newCharDate = new char[8];
            for (int i = 0; i < 8; i++) {
                newCharDate[i] = charDate[i + 10];
            }
            getDateOnly = String.valueOf(newCharDate);
        }
        if ((lastIdTransaksiJualObat == null && lastIdTransaksiJualObat != "kosong") || (!dateNow.equals(getDateOnly))) {
            idTransaksiJualObatFix = awalan.concat("001");
        } else {
            char[] lastDigit = lastIdTransaksiJualObat.toCharArray();
            char[] newLastDigit = new char[3];
            for (int i = 0; i < 3; i++) {
                newLastDigit[i] = lastDigit[i + 19];
            }
            int lastDigitIdDetail = Integer.parseInt(String.valueOf(newLastDigit)) + 1;
            if (lastDigitIdDetail < 10) {
                idTransaksiJualObatFix = awalan.concat("00").concat(String.valueOf(lastDigitIdDetail));
            } else if (lastDigitIdDetail >= 10 && lastDigitIdDetail < 100) {
                idTransaksiJualObatFix = awalan.concat("0").concat(String.valueOf(lastDigitIdDetail));
            } else if (lastDigitIdDetail >= 100) {
                idTransaksiJualObatFix = awalan.concat(String.valueOf(lastDigitIdDetail));
            }
        }
        return idTransaksiJualObatFix;
    }

    public String getDateNow() throws RemoteException {
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        String date = df.format(new java.util.Date());
        return date;
    }

}
