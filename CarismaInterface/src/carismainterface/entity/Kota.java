/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carismainterface.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author K-MiL Caster
 */
@Entity
@Table(name = "kota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kota.findAll", query = "SELECT k FROM Kota k"),
    @NamedQuery(name = "Kota.findByIdKota", query = "SELECT k FROM Kota k WHERE k.kotaPK.idKota = :idKota"),
    @NamedQuery(name = "Kota.findByProvinsiIdProvinsi", query = "SELECT k FROM Kota k WHERE k.kotaPK.provinsiIdProvinsi = :provinsiIdProvinsi"),
    @NamedQuery(name = "Kota.findByNamaKota", query = "SELECT k FROM Kota k WHERE k.namaKota = :namaKota")})
public class Kota implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KotaPK kotaPK;
    @Basic(optional = false)
    @Column(name = "nama_kota")
    private String namaKota;
    @JoinColumn(name = "provinsi_id_provinsi", referencedColumnName = "id_provinsi", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Provinsi provinsi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kotaIdKota")
    private String pasienCollection;

    public Kota() {
    }

    public Kota(KotaPK kotaPK) {
        this.kotaPK = kotaPK;
    }

    public Kota(KotaPK kotaPK, String namaKota) {
        this.kotaPK = kotaPK;
        this.namaKota = namaKota;
    }

    public Kota(String idKota, String provinsiIdProvinsi) {
        this.kotaPK = new KotaPK(idKota, provinsiIdProvinsi);
    }

    public KotaPK getKotaPK() {
        return kotaPK;
    }

    public void setKotaPK(KotaPK kotaPK) {
        this.kotaPK = kotaPK;
    }

    public String getNamaKota() {
        return namaKota;
    }

    public void setNamaKota(String namaKota) {
        this.namaKota = namaKota;
    }

    public Provinsi getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(Provinsi provinsi) {
        this.provinsi = provinsi;
    }

    @XmlTransient
    public String getPasienCollection() {
        return pasienCollection;
    }

    public void setPasienCollection(String pasienCollection) {
        this.pasienCollection = pasienCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kotaPK != null ? kotaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kota)) {
            return false;
        }
        Kota other = (Kota) object;
        if ((this.kotaPK == null && other.kotaPK != null) || (this.kotaPK != null && !this.kotaPK.equals(other.kotaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Kota[ kotaPK=" + kotaPK + " ]";
    }
    
}
