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
@Table(name = "rekammedik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rekammedik_1.findAll", query = "SELECT r FROM Rekammedik_1 r"),
    @NamedQuery(name = "Rekammedik_1.findByIdRekammedik", query = "SELECT r FROM Rekammedik_1 r WHERE r.idRekammedik = :idRekammedik"),
    @NamedQuery(name = "Rekammedik_1.findByTglRekammedik", query = "SELECT r FROM Rekammedik_1 r WHERE r.tglRekammedik = :tglRekammedik"),
    @NamedQuery(name = "Rekammedik_1.findByKeluhanRekammedik", query = "SELECT r FROM Rekammedik_1 r WHERE r.keluhanRekammedik = :keluhanRekammedik"),
    @NamedQuery(name = "Rekammedik_1.findByPemeriksaanRekammedik", query = "SELECT r FROM Rekammedik_1 r WHERE r.pemeriksaanRekammedik = :pemeriksaanRekammedik"),
    @NamedQuery(name = "Rekammedik_1.findByTerapiRekammedik", query = "SELECT r FROM Rekammedik_1 r WHERE r.terapiRekammedik = :terapiRekammedik"),
    @NamedQuery(name = "Rekammedik_1.findByAlergiobatRekammedik", query = "SELECT r FROM Rekammedik_1 r WHERE r.alergiobatRekammedik = :alergiobatRekammedik"),
    @NamedQuery(name = "Rekammedik_1.findByKesimpulanRekammedis", query = "SELECT r FROM Rekammedik_1 r WHERE r.kesimpulanRekammedis = :kesimpulanRekammedis"),
    @NamedQuery(name = "Rekammedik_1.findByKondisipasienkeluarRekammedis", query = "SELECT r FROM Rekammedik_1 r WHERE r.kondisipasienkeluarRekammedis = :kondisipasienkeluarRekammedis")})
public class Rekammedik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_rekammedik")
    private String idRekammedik;
    @Basic(optional = false)
    @Column(name = "tgl_rekammedik")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglRekammedik;
    @Column(name = "keluhan_rekammedik")
    private String keluhanRekammedik;
    @Column(name = "pemeriksaan_rekammedik")
    private String pemeriksaanRekammedik;
    @Column(name = "terapi_rekammedik")
    private String terapiRekammedik;
    @Column(name = "alergiobat_rekammedik")
    private String alergiobatRekammedik;
    @Column(name = "kesimpulan_rekammedis")
    private String kesimpulanRekammedis;
    @Basic(optional = false)
    @Column(name = "kondisipasienkeluar_rekammedis")
    private String kondisipasienkeluarRekammedis;
    @ManyToMany(mappedBy = "rekammedikCollection")
    private Collection<Penyakit> penyakitCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rekammedikIdRekammedik")
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

    public Rekammedik(String idRekammedik) {
        this.idRekammedik = idRekammedik;
    }

    public Rekammedik(String idRekammedik, Date tglRekammedik, String kondisipasienkeluarRekammedis) {
        this.idRekammedik = idRekammedik;
        this.tglRekammedik = tglRekammedik;
        this.kondisipasienkeluarRekammedis = kondisipasienkeluarRekammedis;
    }

    public String getIdRekammedik() {
        return idRekammedik;
    }

    public void setIdRekammedik(String idRekammedik) {
        this.idRekammedik = idRekammedik;
    }

    public Date getTglRekammedik() {
        return tglRekammedik;
    }

    public void setTglRekammedik(Date tglRekammedik) {
        this.tglRekammedik = tglRekammedik;
    }

    public String getKeluhanRekammedik() {
        return keluhanRekammedik;
    }

    public void setKeluhanRekammedik(String keluhanRekammedik) {
        this.keluhanRekammedik = keluhanRekammedik;
    }

    public String getPemeriksaanRekammedik() {
        return pemeriksaanRekammedik;
    }

    public void setPemeriksaanRekammedik(String pemeriksaanRekammedik) {
        this.pemeriksaanRekammedik = pemeriksaanRekammedik;
    }

    public String getTerapiRekammedik() {
        return terapiRekammedik;
    }

    public void setTerapiRekammedik(String terapiRekammedik) {
        this.terapiRekammedik = terapiRekammedik;
    }

    public String getAlergiobatRekammedik() {
        return alergiobatRekammedik;
    }

    public void setAlergiobatRekammedik(String alergiobatRekammedik) {
        this.alergiobatRekammedik = alergiobatRekammedik;
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
        hash += (idRekammedik != null ? idRekammedik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rekammedik)) {
            return false;
        }
        Rekammedik other = (Rekammedik) object;
        if ((this.idRekammedik == null && other.idRekammedik != null) || (this.idRekammedik != null && !this.idRekammedik.equals(other.idRekammedik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Rekammedik_1[ idRekammedik=" + idRekammedik + " ]";
    }
    
}
