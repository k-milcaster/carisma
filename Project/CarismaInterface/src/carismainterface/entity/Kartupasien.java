/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carismainterface.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author K-MiL Caster
 */
@Entity
@Table(name = "kartupasien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kartupasien.findAll", query = "SELECT k FROM Kartupasien k"),
    @NamedQuery(name = "Kartupasien.findByPasienIdPasien", query = "SELECT k FROM Kartupasien k WHERE k.pasienIdPasien = :pasienIdPasien"),
    @NamedQuery(name = "Kartupasien.findByCetakKartupasien", query = "SELECT k FROM Kartupasien k WHERE k.cetakKartupasien = :cetakKartupasien"),
    @NamedQuery(name = "Kartupasien.findByBerlakusampaiKartupasien", query = "SELECT k FROM Kartupasien k WHERE k.berlakusampaiKartupasien = :berlakusampaiKartupasien")})
public class Kartupasien implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pasien_id_pasien")
    private String pasienIdPasien;
    @Basic(optional = false)
    @Column(name = "cetak_kartupasien")
    @Temporal(TemporalType.DATE)
    private Date cetakKartupasien;
    @Basic(optional = false)
    @Column(name = "berlakusampai_kartupasien")
    @Temporal(TemporalType.DATE)
    private Date berlakusampaiKartupasien;
    @JoinColumn(name = "pasien_id_pasien", referencedColumnName = "id_pasien", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private String pasien;

    public Kartupasien() {
    }

    public Kartupasien(String pasienIdPasien) {
        this.pasienIdPasien = pasienIdPasien;
    }

    public Kartupasien(String pasienIdPasien, Date cetakKartupasien, Date berlakusampaiKartupasien) {
        this.pasienIdPasien = pasienIdPasien;
        this.cetakKartupasien = cetakKartupasien;
        this.berlakusampaiKartupasien = berlakusampaiKartupasien;
    }

    public String getPasienIdPasien() {
        return pasienIdPasien;
    }

    public void setPasienIdPasien(String pasienIdPasien) {
        this.pasienIdPasien = pasienIdPasien;
    }

    public Date getCetakKartupasien() {
        return cetakKartupasien;
    }

    public void setCetakKartupasien(Date cetakKartupasien) {
        this.cetakKartupasien = cetakKartupasien;
    }

    public Date getBerlakusampaiKartupasien() {
        return berlakusampaiKartupasien;
    }

    public void setBerlakusampaiKartupasien(Date berlakusampaiKartupasien) {
        this.berlakusampaiKartupasien = berlakusampaiKartupasien;
    }

    public String getPasien() {
        return pasien;
    }

    public void setPasien(String pasien) {
        this.pasien = pasien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pasienIdPasien != null ? pasienIdPasien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kartupasien)) {
            return false;
        }
        Kartupasien other = (Kartupasien) object;
        if ((this.pasienIdPasien == null && other.pasienIdPasien != null) || (this.pasienIdPasien != null && !this.pasienIdPasien.equals(other.pasienIdPasien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Kartupasien[ pasienIdPasien=" + pasienIdPasien + " ]";
    }
    
}
