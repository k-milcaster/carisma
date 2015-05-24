/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carismaapoteker.controller;

import carismaapoteker.boundaries.TransaksiBeliObat;
import carismainterface.entity.Detailobat;
import carismainterface.entity.Detailtransaksibeliobat;
import carismainterface.entity.Obat;
import carismainterface.entity.Transaksibeliobat;
import carismainterface.server.DetailobatService;
import carismainterface.server.DetailtransaksibeliobatService;
import carismainterface.server.ObatService;
import carismainterface.server.PegawaiService;
import carismainterface.server.TransaksibeliobatService;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hana Mahrifah
 */
public class TransaksiBeliObatController {

    private TransaksibeliobatService transaksibeliobat;
    private DetailtransaksibeliobatService detailtransaksibeliobat;
    private ObatService obatService;
    private DetailobatService detailobatService;
    private PegawaiService pegawaiService;

    public TransaksiBeliObatController(ClientSocket client) throws RemoteException {
        transaksibeliobat = client.getTransaksibeliobatService();
        detailtransaksibeliobat = client.getDetailtransaksibeliobatService();
        obatService = client.getObatService();
        detailobatService = client.getDetailonatSerivice();
        pegawaiService = client.getPegawaiService();
    }

    public DefaultComboBoxModel getIdObat() throws RemoteException {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        List<Obat> list = new ArrayList<Obat>();
        list = obatService.getObat();
        for (int i = 0; i < list.size(); i++) {
            combo.addElement(list.get(i).getIdObat() + " " + list.get(i).getNamaObat());
        }
        return combo;

    }

    public boolean insertBeliObat(String idTransaksiBeliObat, String tglTransaksiBeliObat, String keterangan, int hargaBeliObat) throws RemoteException {
        boolean inserted = false;
        Transaksibeliobat trans = new Transaksibeliobat();
        trans.setIdTransaksibeliobat(idTransaksiBeliObat);
        trans.setDateTransaksibeli(tglTransaksiBeliObat);
        trans.setKeterangan(keterangan);
        trans.setHargabeliObat(hargaBeliObat);
        inserted = transaksibeliobat.insertTransaksibeliobat(trans);
        return inserted;
    }

    public boolean insertStokObat(int idObat, String namaObat, int qtyObat, String jenisObat, String keterangan, int hargaJualObat, int stokKritis) throws RemoteException {
        boolean inserted = false;
        Obat obat = new Obat();
        obat.setIdObat(idObat);
        obat.setNamaObat(namaObat);
        obat.setQtyObat(qtyObat);
        obat.setJenisObat(jenisObat);
        obat.setKeterangan(keterangan);
        obat.setHargajualObat(hargaJualObat);
        obat.setStokkritisObat(stokKritis);
        inserted = obatService.insertObat(obat);
        return inserted;
    }

    public boolean insertDetailTransaksiBeliObat(String idTransaksi, int idObat, int qtyObat) throws RemoteException {
        boolean inserted = false;
        Detailtransaksibeliobat trans1 = new Detailtransaksibeliobat();
        trans1.setTransaksibeliobat(idTransaksi);
        trans1.setObat(idObat);
        trans1.setQty(qtyObat);
        inserted = detailtransaksibeliobat.insertDetailtransaksibeliobat(trans1);
        return inserted;
    }

    public boolean insertDetailObat(int idDetail, int idObat, String TglKadaluarsa) throws RemoteException {
        boolean inserted = false;
        Detailobat det = new Detailobat();
        det.setIdDetail(idDetail);
        det.setObatIdObat(idObat);
        det.setTglkadaluarsaDetail(TglKadaluarsa);
        inserted = detailobatService.insertDetailobat(det);
        return inserted;
    }
    public boolean updateStokObat(int id, int qty) throws RemoteException{
        boolean updated = false;
        Obat obat = new Obat();
        obat.setIdObat(id);
        obat.setQtyObat(qty);
        updated = obatService.updateQtyObat(id,qty);
        return updated;
    }
    
    public int getidDetailObat() throws RemoteException{
        int lastIdDetailObat = detailobatService.getLastIdDetailObat() + 1;
        return lastIdDetailObat;
    }
    
    public int getidObat() throws RemoteException{
        int lastIdObat = obatService.getLastIdObat() +1;
        return lastIdObat;    
    }
    
    public String[] getNamaPegawai (String username) throws RemoteException{
        String[] namaApoteker = pegawaiService.getIdNamaPegawai(username);
        return namaApoteker;
    }
    
    public boolean deleteDetailObat(int idDetail) throws RemoteException{
        return detailobatService.deleteDetailobat(idDetail);
    }
    
    public boolean deleteDetailTransaksiBeliObat(String idTransaksi, int idObat) throws RemoteException{
        return detailtransaksibeliobat.deleteDetailtransaksibeliobat(idTransaksi, idObat);
    }
    
    public boolean deleteStokObat(int idObat) throws RemoteException{
        return obatService.deleteObat(idObat);
    }
    
    public boolean deleteBeliObat(String idTransaksi) throws RemoteException{
        return transaksibeliobat.deleteTransaksibeliobat(idTransaksi);
    }
    
    public String getIdTransaksiBeliObat() throws RemoteException {
        String lastIdTransaksiBeliObat = transaksibeliobat.getLastIdTransaksiBeliObat();
        String[] splitDateNow = getDateNow().split("-");
        String dateNow = splitDateNow[0].concat(splitDateNow[1]).concat(splitDateNow[2]);
        String awalan = "TRANSBUY-".concat(dateNow).concat("-");
        String idTransaksiBeliObatFix = " ";
        String getDateOnly = " ";
        // TRANSBUY-20150520-001
        if (lastIdTransaksiBeliObat != null) {
            char[] charDate = lastIdTransaksiBeliObat.toCharArray();
            char[] newCharDate = new char[8];
            for (int i = 0; i < 8; i++) {
                newCharDate[i] = charDate[i + 9];
            }
            getDateOnly = String.valueOf(newCharDate);
        }
        if (lastIdTransaksiBeliObat == null || (!dateNow.equals(getDateOnly))) {
            idTransaksiBeliObatFix = awalan.concat("001");
        } else {
            char[] lastDigit = lastIdTransaksiBeliObat.toCharArray();
            char[] newLastDigit = new char[3];
            for (int i = 0; i < 3; i++) {
                newLastDigit[i] = lastDigit[i + 18];
            }
            int lastDigitIdDetail = Integer.parseInt(String.valueOf(newLastDigit)) + 1;
            if (lastDigitIdDetail < 10) {
                idTransaksiBeliObatFix = awalan.concat("00").concat(String.valueOf(lastDigitIdDetail));
            } else if (lastDigitIdDetail >= 10 && lastDigitIdDetail < 100) {
                idTransaksiBeliObatFix = awalan.concat("0").concat(String.valueOf(lastDigitIdDetail));
            } else if (lastDigitIdDetail >= 100) {
                idTransaksiBeliObatFix = awalan.concat(String.valueOf(lastDigitIdDetail));
            }
        }
        return idTransaksiBeliObatFix;
    }

   
    public String getDateNow() throws RemoteException {
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        String date = df.format(new java.util.Date());
        return date;
    }
      

}
