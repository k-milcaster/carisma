package carismaadministrator.controller;

import carismaadministrator.boundary.*;
import carismainterface.entity.*;
import carismainterface.server.*;
import java.util.*;
import java.rmi.RemoteException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AbsensiController {

    private AbsensidokterService absensiDokterService;
    private AbsensipegawaiService absensiPegawaiService;
    private DokterService dokterService;
    private PegawaiService pegawaiService;

    public AbsensiController(ClientSocket client) throws RemoteException {
        absensiDokterService = client.getAbsensiDokterService();
        absensiPegawaiService = client.getAbsensiPegawaiService();
        dokterService = client.getDokterService();
        pegawaiService = client.getPegawaiService();
    }

    public boolean insertAbsensiDokter(String idDokter, String kehadiranReguler, String kehadiranLembur, String tanggalKehadiran) throws RemoteException {
        Absensidokter absensiDokter = new Absensidokter();
        absensiDokter.setDokterIdDokter(idDokter);
        absensiDokter.setKehadiranregulerDokter(kehadiranReguler);
        absensiDokter.setKehadiranlemburDokter(kehadiranLembur);
        absensiDokter.setDateAbsensidokter(tanggalKehadiran);
        return absensiDokterService.insertAbsensidokter(absensiDokter);
    }

    public boolean deleteAbsensiDokter(String idDokter) throws RemoteException{
        return absensiDokterService.deleteAbsensidokter(idDokter);
    }

    public boolean insertAbsensiPegawai(String idPegawai, String kehadiranReguler, String kehadiranLembur, String tanggalKehadiran) throws RemoteException {
        Absensipegawai absensiPegawai = new Absensipegawai();
        absensiPegawai.setPegawaiIdPegawai(idPegawai);
        absensiPegawai.setKehadiranregulerPegawai(kehadiranReguler);
        absensiPegawai.setKehadiranlemburPegawai(kehadiranLembur);
        absensiPegawai.setDateAbsensipegawai(tanggalKehadiran);
        return absensiPegawaiService.insertAbsensipegawai(absensiPegawai);
    }
    
    public boolean deleteAbsensiPegawai(String idPegawai) throws RemoteException{
        return absensiPegawaiService.deleteAbsensipegawai(idPegawai);
    }
    
    public DefaultComboBoxModel getIdDokter() throws RemoteException {
        DefaultComboBoxModel idDokter = new DefaultComboBoxModel();
        List<Dokter> listIdDokter = new ArrayList<Dokter>();
        listIdDokter = dokterService.getDokter();
        for (int i = 0; i < listIdDokter.size(); i++) {
            idDokter.addElement(listIdDokter.get(i).getIdDokter() + " " + listIdDokter.get(i).getNamaDokter());
        }
        return idDokter;
    }

    public DefaultTableModel getTabelAbsensiDokter() throws RemoteException {
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("Id Dokter");
        tabel.addColumn("Kehadiran Reguler");
        tabel.addColumn("Kehadiran Lembur");
        List<Absensidokter> listAbsensiDokter = new ArrayList<Absensidokter>();
        listAbsensiDokter = absensiDokterService.getAbsensidokter();
        for (int i = 0; i < listAbsensiDokter.size(); i++) {
            tabel.addRow(new Object[]{listAbsensiDokter.get(i).getDokterIdDokter(), listAbsensiDokter.get(i).getKehadiranregulerDokter(), listAbsensiDokter.get(i).getKehadiranlemburDokter()});
        }
        return tabel;
    }

    public DefaultComboBoxModel getIdPegawai() throws RemoteException {
        DefaultComboBoxModel idPegawai = new DefaultComboBoxModel();
        List<Pegawai> listIdPegawai = new ArrayList<Pegawai>();
        listIdPegawai = pegawaiService.getPegawai();
        for (int i = 0; i < listIdPegawai.size(); i++) {
            idPegawai.addElement(listIdPegawai.get(i).getIdPegawai() + " " + listIdPegawai.get(i).getNamaPegawai());
        }
        return idPegawai;
    }
    
    public DefaultTableModel getTabelAbsensiPegawai() throws RemoteException {
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("Id Pegawai");
        tabel.addColumn("Kehadiran Reguler");
        tabel.addColumn("Kehadiran Lembur");
        List<Absensipegawai> listAbsensiDokter = new ArrayList<Absensipegawai>();
        listAbsensiDokter = absensiPegawaiService.getAbsensipegawai();
        for (int i = 0; i < listAbsensiDokter.size(); i++) {
            tabel.addRow(new Object[]{listAbsensiDokter.get(i).getPegawaiIdPegawai(), listAbsensiDokter.get(i).getKehadiranregulerPegawai(), listAbsensiDokter.get(i).getKehadiranlemburPegawai()});
        }
        return tabel;
    }

    public String[] getNamaPegawai(String username) throws RemoteException {
        String[] namaPegawai = pegawaiService.getIdNamaPegawai(username);
        return namaPegawai;
    }
}
