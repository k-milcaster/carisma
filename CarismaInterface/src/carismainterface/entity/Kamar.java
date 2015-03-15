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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "kamar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kamar.findAll", query = "SELECT k FROM Kamar k"),
    @NamedQuery(name = "Kamar.findByIdKamar", query = "SELECT k FROM Kamar k WHERE k.idKamar = :idKamar"),
    @NamedQuery(name = "Kamar.findByNamaKamar", query = "SELECT k FROM Kamar k WHERE k.namaKamar = :namaKamar"),
    @NamedQuery(name = "Kamar.findByKelas", query = "SELECT k FROM Kamar k WHERE k.kelas = :kelas"),
    @NamedQuery(name = "Kamar.findByTarif", query = "SELECT k FROM Kamar k WHERE k.tarif = :tarif")})
public class Kamar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_kamar")
    private Integer idKamar;
    @Basic(optional = false)
    @Column(name = "nama_kamar")
    private String namaKamar;
    @Basic(optional = false)
    @Column(name = "kelas")
    private String kelas;
    @Basic(optional = false)
    @Column(name = "tarif")
    private int tarif;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kamarIdKamar")
    private String pasienKamarCollection;

    public Kamar() {
    }

    public Kamar(Integer idKamar) {
        this.idKamar = idKamar;
    }

    public Kamar(Integer idKamar, String namaKamar, String kelas, int tarif) {
        this.idKamar = idKamar;
        this.namaKamar = namaKamar;
        this.kelas = kelas;
        this.tarif = tarif;
    }

    public Integer getIdKamar() {
        return idKamar;
    }

    public void setIdKamar(Integer idKamar) {
        this.idKamar = idKamar;
    }

    public String getNamaKamar() {
        return namaKamar;
    }

    public void setNamaKamar(String namaKamar) {
        this.namaKamar = namaKamar;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    @XmlTransient
    public String getPasienKamarCollection() {
        return pasienKamarCollection;
    }

    public void setPasienKamarCollection(String pasienKamarCollection) {
        this.pasienKamarCollection = pasienKamarCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKamar != null ? idKamar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kamar)) {
            return false;
        }
        Kamar other = (Kamar) object;
        if ((this.idKamar == null && other.idKamar != null) || (this.idKamar != null && !this.idKamar.equals(other.idKamar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Kamar[ idKamar=" + idKamar + " ]";
    }
    
}
