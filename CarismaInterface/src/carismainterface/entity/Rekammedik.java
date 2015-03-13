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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "rekammedis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rekammedis.findAll", query = "SELECT r FROM Rekammedis r"),
    @NamedQuery(name = "Rekammedis.findByIdRekammedis", query = "SELECT r FROM Rekammedis r WHERE r.idRekammedis = :idRekammedis"),
    @NamedQuery(name = "Rekammedis.findByTglRekammedis", query = "SELECT r FROM Rekammedis r WHERE r.tglRekammedis = :tglRekammedis"),
    @NamedQuery(name = "Rekammedis.findByKeluhanRekammedis", query = "SELECT r FROM Rekammedis r WHERE r.keluhanRekammedis = :keluhanRekammedis"),
    @NamedQuery(name = "Rekammedis.findByPemeriksaanRekammedis", query = "SELECT r FROM Rekammedis r WHERE r.pemeriksaanRekammedis = :pemeriksaanRekammedis"),
    @NamedQuery(name = "Rekammedis.findByTerapiRekammedis", query = "SELECT r FROM Rekammedis r WHERE r.terapiRekammedis = :terapiRekammedis"),
    @NamedQuery(name = "Rekammedis.findByAlergiobatRekammedis", query = "SELECT r FROM Rekammedis r WHERE r.alergiobatRekammedis = :alergiobatRekammedis"),
    @NamedQuery(name = "Rekammedis.findByKesimpulanRekammedis", query = "SELECT r FROM Rekammedis r WHERE r.kesimpulanRekammedis = :kesimpulanRekammedis"),
    @NamedQuery(name = "Rekammedis.findByKondisipasienkeluarRekammedis", query = "SELECT r FROM Rekammedis r WHERE r.kondisipasienkeluarRekammedis = :kondisipasienkeluarRekammedis")})
public class Rekammedik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_rekammedis")
    private String idRekammedis;
    @Basic(optional = false)
    @Column(name = "tgl_rekammedis")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglRekammedis;
    @Column(name = "keluhan_rekammedis")
    private String keluhanRekammedis;
    @Column(name = "pemeriksaan_rekammedis")
    private String pemeriksaanRekammedis;
    @Column(name = "terapi_rekammedis")
    private String terapiRekammedis;
    @Column(name = "alergiobat_rekammedis")
    private String alergiobatRekammedis;
    @Column(name = "kesimpulan_rekammedis")
    private String kesimpulanRekammedis;
    @Basic(optional = false)
    @Column(name = "kondisipasienkeluar_rekammedis")
    private String kondisipasienkeluarRekammedis;
    @ManyToMany(mappedBy = "rekammedisCollection")
    private Collection<Penyakit> penyakitCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rekammedisIdRekammedis")
    private Collection<Kunjungan> kunjunganCollection;
    @JoinColumn(name = "resep_id_resep", referencedColumnName = "id_resep")
    @ManyToOne(optional = false)
    private Resep resepIdResep;
    @JoinColumn(name = "pasien_id_pasien", referencedColumnName = "id_pasien")
    @ManyToOne(optional = false)
    private Pasien pasienIdPasien;
    @JoinColumn(name = "dokter_id_dokter", referencedColumnName = "id_dokter")
    @ManyToOne(optional = false)
    private Dokter dokterIdDokter;

    public Rekammedik() {
    }

    public Rekammedik(String idRekammedis) {
        this.idRekammedis = idRekammedis;
    }

    public Rekammedik(String idRekammedis, Date tglRekammedis, String kondisipasienkeluarRekammedis) {
        this.idRekammedis = idRekammedis;
        this.tglRekammedis = tglRekammedis;
        this.kondisipasienkeluarRekammedis = kondisipasienkeluarRekammedis;
    }

    public String getIdRekammedis() {
        return idRekammedis;
    }

    public void setIdRekammedis(String idRekammedis) {
        this.idRekammedis = idRekammedis;
    }

    public Date getTglRekammedis() {
        return tglRekammedis;
    }

    public void setTglRekammedis(Date tglRekammedis) {
        this.tglRekammedis = tglRekammedis;
    }

    public String getKeluhanRekammedis() {
        return keluhanRekammedis;
    }

    public void setKeluhanRekammedis(String keluhanRekammedis) {
        this.keluhanRekammedis = keluhanRekammedis;
    }

    public String getPemeriksaanRekammedis() {
        return pemeriksaanRekammedis;
    }

    public void setPemeriksaanRekammedis(String pemeriksaanRekammedis) {
        this.pemeriksaanRekammedis = pemeriksaanRekammedis;
    }

    public String getTerapiRekammedis() {
        return terapiRekammedis;
    }

    public void setTerapiRekammedis(String terapiRekammedis) {
        this.terapiRekammedis = terapiRekammedis;
    }

    public String getAlergiobatRekammedis() {
        return alergiobatRekammedis;
    }

    public void setAlergiobatRekammedis(String alergiobatRekammedis) {
        this.alergiobatRekammedis = alergiobatRekammedis;
    }

    public String getKesimpulanRekammedis() {
        return kesimpulanRekammedis;
    }

    public void setKesimpulanRekammedis(String kesimpulanRekammedis) {
        this.kesimpulanRekammedis = kesimpulanRekammedis;
    }

    public String getKondisipasienkeluarRekammedis() {
        return kondisipasienkeluarRekammedis;
    }

    public void setKondisipasienkeluarRekammedis(String kondisipasienkeluarRekammedis) {
        this.kondisipasienkeluarRekammedis = kondisipasienkeluarRekammedis;
    }

    @XmlTransient
    public Collection<Penyakit> getPenyakitCollection() {
        return penyakitCollection;
    }

    public void setPenyakitCollection(Collection<Penyakit> penyakitCollection) {
        this.penyakitCollection = penyakitCollection;
    }

    @XmlTransient
    public Collection<Kunjungan> getKunjunganCollection() {
        return kunjunganCollection;
    }

    public void setKunjunganCollection(Collection<Kunjungan> kunjunganCollection) {
        this.kunjunganCollection = kunjunganCollection;
    }

    public Resep getResepIdResep() {
        return resepIdResep;
    }

    public void setResepIdResep(Resep resepIdResep) {
        this.resepIdResep = resepIdResep;
    }

    public Pasien getPasienIdPasien() {
        return pasienIdPasien;
    }

    public void setPasienIdPasien(Pasien pasienIdPasien) {
        this.pasienIdPasien = pasienIdPasien;
    }

    public Dokter getDokterIdDokter() {
        return dokterIdDokter;
    }

    public void setDokterIdDokter(Dokter dokterIdDokter) {
        this.dokterIdDokter = dokterIdDokter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRekammedis != null ? idRekammedis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rekammedik)) {
            return false;
        }
        Rekammedik other = (Rekammedik) object;
        if ((this.idRekammedis == null && other.idRekammedis != null) || (this.idRekammedis != null && !this.idRekammedis.equals(other.idRekammedis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Rekammedis[ idRekammedis=" + idRekammedis + " ]";
    }
    
}
