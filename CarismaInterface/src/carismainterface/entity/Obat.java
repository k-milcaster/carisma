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
@Table(name = "obat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Obat.findAll", query = "SELECT o FROM Obat o"),
    @NamedQuery(name = "Obat.findByIdObat", query = "SELECT o FROM Obat o WHERE o.idObat = :idObat"),
    @NamedQuery(name = "Obat.findByNamaObat", query = "SELECT o FROM Obat o WHERE o.namaObat = :namaObat"),
    @NamedQuery(name = "Obat.findByQtyObat", query = "SELECT o FROM Obat o WHERE o.qtyObat = :qtyObat"),
    @NamedQuery(name = "Obat.findByJenisObat", query = "SELECT o FROM Obat o WHERE o.jenisObat = :jenisObat"),
    @NamedQuery(name = "Obat.findByKeterangan", query = "SELECT o FROM Obat o WHERE o.keterangan = :keterangan"),
    @NamedQuery(name = "Obat.findByHargajualObat", query = "SELECT o FROM Obat o WHERE o.hargajualObat = :hargajualObat")})
public class Obat implements Serializable {
    @Column(name = "hargajual_obat")
    private Integer hargajualObat;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_obat")
    private Integer idObat;
    @Column(name = "nama_obat")
    private String namaObat;
    @Column(name = "qty_obat")
    private Integer qtyObat;
    @Column(name = "jenis_obat")
    private String jenisObat;
    @Column(name = "keterangan")
    private String keterangan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "obat")
    private Collection<Detailtransaksijualobat> detailtransaksijualobatCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "obat")
    private Collection<Detailtransaksibeliobat> detailtransaksibeliobatCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "obatIdObat")
    private Collection<Detailobat> detailobatCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "obatIdObat")
    private Collection<Rakobat> rakobatCollection;

    public Obat() {
    }

    public Obat(Integer idObat) {
        this.idObat = idObat;
    }

    public Integer getIdObat() {
        return idObat;
    }

    public void setIdObat(Integer idObat) {
        this.idObat = idObat;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public Integer getQtyObat() {
        return qtyObat;
    }

    public void setQtyObat(Integer qtyObat) {
        this.qtyObat = qtyObat;
    }

    public String getJenisObat() {
        return jenisObat;
    }

    public void setJenisObat(String jenisObat) {
        this.jenisObat = jenisObat;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getHargajualObat() {
        return hargajualObat;
    }

    public void setHargajualObat(int hargajualObat) {
        this.hargajualObat = hargajualObat;
    }

    @XmlTransient
    public Collection<Detailtransaksijualobat> getDetailtransaksijualobatCollection() {
        return detailtransaksijualobatCollection;
    }

    public void setDetailtransaksijualobatCollection(Collection<Detailtransaksijualobat> detailtransaksijualobatCollection) {
        this.detailtransaksijualobatCollection = detailtransaksijualobatCollection;
    }

    @XmlTransient
    public Collection<Detailtransaksibeliobat> getDetailtransaksibeliobatCollection() {
        return detailtransaksibeliobatCollection;
    }

    public void setDetailtransaksibeliobatCollection(Collection<Detailtransaksibeliobat> detailtransaksibeliobatCollection) {
        this.detailtransaksibeliobatCollection = detailtransaksibeliobatCollection;
    }

    @XmlTransient
    public Collection<Detailobat> getDetailobatCollection() {
        return detailobatCollection;
    }

    public void setDetailobatCollection(Collection<Detailobat> detailobatCollection) {
        this.detailobatCollection = detailobatCollection;
    }

    @XmlTransient
    public Collection<Rakobat> getRakobatCollection() {
        return rakobatCollection;
    }

    public void setRakobatCollection(Collection<Rakobat> rakobatCollection) {
        this.rakobatCollection = rakobatCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idObat != null ? idObat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Obat)) {
            return false;
        }
        Obat other = (Obat) object;
        if ((this.idObat == null && other.idObat != null) || (this.idObat != null && !this.idObat.equals(other.idObat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Obat[ idObat=" + idObat + " ]";
    }

    public void setHargajualObat(Integer hargajualObat) {
        this.hargajualObat = hargajualObat;
    }
    
}
