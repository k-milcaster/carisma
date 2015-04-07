/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carismainterface.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author K-MiL Caster
 */
@Entity
@Table(name = "transaksibeliobat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaksibeliobat.findAll", query = "SELECT t FROM Transaksibeliobat t"),
    @NamedQuery(name = "Transaksibeliobat.findByIdTransaksibeliobat", query = "SELECT t FROM Transaksibeliobat t WHERE t.idTransaksibeliobat = :idTransaksibeliobat"),
    @NamedQuery(name = "Transaksibeliobat.findByDateTransaksibeli", query = "SELECT t FROM Transaksibeliobat t WHERE t.dateTransaksibeli = :dateTransaksibeli"),
    @NamedQuery(name = "Transaksibeliobat.findByKeterangan", query = "SELECT t FROM Transaksibeliobat t WHERE t.keterangan = :keterangan")})
public class Transaksibeliobat implements Serializable {
    @Column(name = "hargabeli_obat")
    private Integer hargabeliObat;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_transaksibeliobat")
    private String idTransaksibeliobat;
    @Column(name = "date_transaksibeli")
    @Temporal(TemporalType.DATE)
    private String dateTransaksibeli;
    @Column(name = "keterangan")
    private String keterangan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transaksibeliobat")
    private String detailtransaksibeliobatCollection;

    public Transaksibeliobat() {
    }

    public Transaksibeliobat(String idTransaksibeliobat) {
        this.idTransaksibeliobat = idTransaksibeliobat;
    }

    public String getIdTransaksibeliobat() {
        return idTransaksibeliobat;
    }

    public void setIdTransaksibeliobat(String idTransaksibeliobat) {
        this.idTransaksibeliobat = idTransaksibeliobat;
    }

    public String getDateTransaksibeli() {
        return dateTransaksibeli;
    }

    public void setDateTransaksibeli(String dateTransaksibeli) {
        this.dateTransaksibeli = dateTransaksibeli;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @XmlTransient
    public String getDetailtransaksibeliobatCollection() {
        return detailtransaksibeliobatCollection;
    }

    public void setDetailtransaksibeliobatCollection(String detailtransaksibeliobatCollection) {
        this.detailtransaksibeliobatCollection = detailtransaksibeliobatCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransaksibeliobat != null ? idTransaksibeliobat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaksibeliobat)) {
            return false;
        }
        Transaksibeliobat other = (Transaksibeliobat) object;
        if ((this.idTransaksibeliobat == null && other.idTransaksibeliobat != null) || (this.idTransaksibeliobat != null && !this.idTransaksibeliobat.equals(other.idTransaksibeliobat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Transaksibeliobat[ idTransaksibeliobat=" + idTransaksibeliobat + " ]";
    }

    public Integer getHargabeliObat() {
        return hargabeliObat;
    }

    public void setHargabeliObat(Integer hargabeliObat) {
        this.hargabeliObat = hargabeliObat;
    }
    
}
