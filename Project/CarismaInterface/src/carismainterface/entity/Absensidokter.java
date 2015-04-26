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
public class Absensidokter implements Serializable{
    private String dokterIdDokter;
    private String kehadiranregulerDokter;
    private String kehadiranlemburDokter;
    private String dateAbsensidokter;

    public Absensidokter() {
    }

    public Absensidokter(String dokterIdDokter, String kehadiranregulerDokter, String kehadiranlemburDokter, String dateAbsensidokter) {
        this.dokterIdDokter = dokterIdDokter;
        this.kehadiranregulerDokter = kehadiranregulerDokter;
        this.kehadiranlemburDokter = kehadiranlemburDokter;
        this.dateAbsensidokter = dateAbsensidokter;
    }

    public Absensidokter(Absensidokter absensidokter) {
        this.dokterIdDokter = absensidokter.dokterIdDokter;
        this.kehadiranregulerDokter = absensidokter.kehadiranregulerDokter;
        this.kehadiranlemburDokter = absensidokter.kehadiranlemburDokter;
        this.dateAbsensidokter = absensidokter.dateAbsensidokter;
    }

    public String getDokterIdDokter() {
        return dokterIdDokter;
    }

    public void setDokterIdDokter(String dokterIdDokter) {
        this.dokterIdDokter = dokterIdDokter;
    }

    public String getKehadiranregulerDokter() {
        return kehadiranregulerDokter;
    }

    public void setKehadiranregulerDokter(String kehadiranregulerDokter) {
        this.kehadiranregulerDokter = kehadiranregulerDokter;
    }

    public String getKehadiranlemburDokter() {
        return kehadiranlemburDokter;
    }

    public void setKehadiranlemburDokter(String kehadiranlemburDokter) {
        this.kehadiranlemburDokter = kehadiranlemburDokter;
    }

    public String getDateAbsensidokter() {
        return dateAbsensidokter;
    }

    public void setDateAbsensidokter(String dateAbsensidokter) {
        this.dateAbsensidokter = dateAbsensidokter;
    }
    
    
}
