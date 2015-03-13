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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "pasien_kamar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PasienKamar.findAll", query = "SELECT p FROM PasienKamar p"),
    @NamedQuery(name = "PasienKamar.findByIdPeminjaman", query = "SELECT p FROM PasienKamar p WHERE p.idPeminjaman = :idPeminjaman"),
    @NamedQuery(name = "PasienKamar.findByDateinPasienKamar", query = "SELECT p FROM PasienKamar p WHERE p.dateinPasienKamar = :dateinPasienKamar"),
    @NamedQuery(name = "PasienKamar.findByDateoutPasienKamar", query = "SELECT p FROM PasienKamar p WHERE p.dateoutPasienKamar = :dateoutPasienKamar"),
    @NamedQuery(name = "PasienKamar.findByKeterangan", query = "SELECT p FROM PasienKamar p WHERE p.keterangan = :keterangan")})
public class PasienKamar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_peminjaman")
    private String idPeminjaman;
    @Basic(optional = false)
    @Column(name = "datein_pasien_kamar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateinPasienKamar;
    @Basic(optional = false)
    @Column(name = "dateout_pasien_kamar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateoutPasienKamar;
    @Column(name = "keterangan")
    private String keterangan;
    @OneToMany(mappedBy = "pasienKamarIdPeminjaman")
    private Collection<Kunjungan> kunjunganCollection;
    @JoinColumn(name = "kamar_id_kamar", referencedColumnName = "id_kamar")
    @ManyToOne(optional = false)
    private Kamar kamarIdKamar;

    public PasienKamar() {
    }

    public PasienKamar(String idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public PasienKamar(String idPeminjaman, Date dateinPasienKamar, Date dateoutPasienKamar) {
        this.idPeminjaman = idPeminjaman;
        this.dateinPasienKamar = dateinPasienKamar;
        this.dateoutPasienKamar = dateoutPasienKamar;
    }

    public String getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(String idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public Date getDateinPasienKamar() {
        return dateinPasienKamar;
    }

    public void setDateinPasienKamar(Date dateinPasienKamar) {
        this.dateinPasienKamar = dateinPasienKamar;
    }

    public Date getDateoutPasienKamar() {
        return dateoutPasienKamar;
    }

    public void setDateoutPasienKamar(Date dateoutPasienKamar) {
        this.dateoutPasienKamar = dateoutPasienKamar;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @XmlTransient
    public Collection<Kunjungan> getKunjunganCollection() {
        return kunjunganCollection;
    }

    public void setKunjunganCollection(Collection<Kunjungan> kunjunganCollection) {
        this.kunjunganCollection = kunjunganCollection;
    }

    public Kamar getKamarIdKamar() {
        return kamarIdKamar;
    }

    public void setKamarIdKamar(Kamar kamarIdKamar) {
        this.kamarIdKamar = kamarIdKamar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeminjaman != null ? idPeminjaman.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PasienKamar)) {
            return false;
        }
        PasienKamar other = (PasienKamar) object;
        if ((this.idPeminjaman == null && other.idPeminjaman != null) || (this.idPeminjaman != null && !this.idPeminjaman.equals(other.idPeminjaman))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.PasienKamar[ idPeminjaman=" + idPeminjaman + " ]";
    }
    
}
