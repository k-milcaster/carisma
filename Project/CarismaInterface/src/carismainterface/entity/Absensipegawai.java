/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package carismainterface.entity;

import java.io.Serializable;

/**
 *
 * @author kepoterz
 */
public class Absensipegawai implements Serializable {
    private String pegawaiIdPegawai;
    private String kehadiranregulerPegawai;
    private String kehadiranlemburPegawai;
    private String dateAbsensipegawai;

    public Absensipegawai() {
    }

    public Absensipegawai(String pegawaiIdPegawai, String kehadiranregulerPegawai, String kehadiranlemburPegawai, String dateabsensiPegawai) {
        this.pegawaiIdPegawai = pegawaiIdPegawai;
        this.kehadiranregulerPegawai = kehadiranregulerPegawai;
        this.kehadiranlemburPegawai = kehadiranlemburPegawai;
        this.dateAbsensipegawai = dateabsensiPegawai;
    }

    public Absensipegawai(Absensipegawai absensipegawai) {
        this.pegawaiIdPegawai = absensipegawai.pegawaiIdPegawai;
        this.kehadiranregulerPegawai = absensipegawai.kehadiranregulerPegawai;
        this.kehadiranlemburPegawai = absensipegawai.kehadiranlemburPegawai;
        this.dateAbsensipegawai = absensipegawai.dateAbsensipegawai;
    }

    public String getPegawaiIdPegawai() {
        return pegawaiIdPegawai;
    }

    public void setPegawaiIdPegawai(String pegawaiIdPegawai) {
        this.pegawaiIdPegawai = pegawaiIdPegawai;
    }

    public String getKehadiranregulerPegawai() {
        return kehadiranregulerPegawai;
    }

    public void setKehadiranregulerPegawai(String kehadiranregulerPegawai) {
        this.kehadiranregulerPegawai = kehadiranregulerPegawai;
    }

    public String getKehadiranlemburPegawai() {
        return kehadiranlemburPegawai;
    }

    public void setKehadiranlemburPegawai(String kehadiranlemburPegawai) {
        this.kehadiranlemburPegawai = kehadiranlemburPegawai;
    }

    public String getDateAbsensipegawai() {
        return dateAbsensipegawai;
    }

    public void setDateAbsensipegawai(String dateAbsensipegawai) {
        this.dateAbsensipegawai = dateAbsensipegawai;
    }
    
}
