/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carismainterface.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author K-MiL Caster
 */
@Entity
@Table(name = "jadwaldokter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jadwaldokter.findAll", query = "SELECT j FROM Jadwaldokter j"),
    @NamedQuery(name = "Jadwaldokter.findByDokterIdDokter", query = "SELECT j FROM Jadwaldokter j WHERE j.dokterIdDokter = :dokterIdDokter"),
    @NamedQuery(name = "Jadwaldokter.findByHariJadwaldokter", query = "SELECT j FROM Jadwaldokter j WHERE j.hariJadwaldokter = :hariJadwaldokter"),
    @NamedQuery(name = "Jadwaldokter.findByShiftJadwaldokter", query = "SELECT j FROM Jadwaldokter j WHERE j.shiftJadwaldokter = :shiftJadwaldokter"),
    @NamedQuery(name = "Jadwaldokter.findByKeterangan", query = "SELECT j FROM Jadwaldokter j WHERE j.keterangan = :keterangan")})
public class Jadwaldokter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dokter_id_dokter")
    private String dokterIdDokter;
    @Basic(optional = false)
    @Column(name = "hari_jadwaldokter")
    private String hariJadwaldokter;
    @Basic(optional = false)
    @Column(name = "shift_jadwaldokter")
    private String shiftJadwaldokter;
    @Column(name = "keterangan")
    private String keterangan;
    @JoinColumn(name = "dokter_id_dokter", referencedColumnName = "id_dokter", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Dokter dokter;

    public Jadwaldokter() {
    }

    public Jadwaldokter(String dokterIdDokter) {
        this.dokterIdDokter = dokterIdDokter;
    }

    public Jadwaldokter(String dokterIdDokter, String hariJadwaldokter, String shiftJadwaldokter) {
        this.dokterIdDokter = dokterIdDokter;
        this.hariJadwaldokter = hariJadwaldokter;
        this.shiftJadwaldokter = shiftJadwaldokter;
    }

    public String getDokterIdDokter() {
        return dokterIdDokter;
    }

    public void setDokterIdDokter(String dokterIdDokter) {
        this.dokterIdDokter = dokterIdDokter;
    }

    public String getHariJadwaldokter() {
        return hariJadwaldokter;
    }

    public void setHariJadwaldokter(String hariJadwaldokter) {
        this.hariJadwaldokter = hariJadwaldokter;
    }

    public String getShiftJadwaldokter() {
        return shiftJadwaldokter;
    }

    public void setShiftJadwaldokter(String shiftJadwaldokter) {
        this.shiftJadwaldokter = shiftJadwaldokter;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dokterIdDokter != null ? dokterIdDokter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jadwaldokter)) {
            return false;
        }
        Jadwaldokter other = (Jadwaldokter) object;
        if ((this.dokterIdDokter == null && other.dokterIdDokter != null) || (this.dokterIdDokter != null && !this.dokterIdDokter.equals(other.dokterIdDokter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Jadwaldokter[ dokterIdDokter=" + dokterIdDokter + " ]";
    }
    
}
