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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "pasien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pasien.findAll", query = "SELECT p FROM Pasien p"),
    @NamedQuery(name = "Pasien.findByIdPasien", query = "SELECT p FROM Pasien p WHERE p.idPasien = :idPasien"),
    @NamedQuery(name = "Pasien.findByNamaPasien", query = "SELECT p FROM Pasien p WHERE p.namaPasien = :namaPasien"),
    @NamedQuery(name = "Pasien.findByAlamatPasien", query = "SELECT p FROM Pasien p WHERE p.alamatPasien = :alamatPasien"),
    @NamedQuery(name = "Pasien.findByKartuidPasien", query = "SELECT p FROM Pasien p WHERE p.kartuidPasien = :kartuidPasien"),
    @NamedQuery(name = "Pasien.findByNokartuidPasien", query = "SELECT p FROM Pasien p WHERE p.nokartuidPasien = :nokartuidPasien"),
    @NamedQuery(name = "Pasien.findByTelpPasien", query = "SELECT p FROM Pasien p WHERE p.telpPasien = :telpPasien"),
    @NamedQuery(name = "Pasien.findByHpPasien", query = "SELECT p FROM Pasien p WHERE p.hpPasien = :hpPasien"),
    @NamedQuery(name = "Pasien.findByTempatlahirPasien", query = "SELECT p FROM Pasien p WHERE p.tempatlahirPasien = :tempatlahirPasien"),
    @NamedQuery(name = "Pasien.findByTgllahirPasien", query = "SELECT p FROM Pasien p WHERE p.tgllahirPasien = :tgllahirPasien"),
    @NamedQuery(name = "Pasien.findByKelaminPasien", query = "SELECT p FROM Pasien p WHERE p.kelaminPasien = :kelaminPasien"),
    @NamedQuery(name = "Pasien.findByDarahPasien", query = "SELECT p FROM Pasien p WHERE p.darahPasien = :darahPasien"),
    @NamedQuery(name = "Pasien.findByRegdatePasien", query = "SELECT p FROM Pasien p WHERE p.regdatePasien = :regdatePasien")})
public class Pasien implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_pasien")
    private String idPasien;
    @Basic(optional = false)
    @Column(name = "nama_pasien")
    private String namaPasien;
    @Basic(optional = false)
    @Column(name = "alamat_pasien")
    private String alamatPasien;
    @Basic(optional = false)
    @Column(name = "kartuid_pasien")
    private String kartuidPasien;
    @Basic(optional = false)
    @Column(name = "nokartuid_pasien")
    private String nokartuidPasien;
    @Column(name = "telp_pasien")
    private String telpPasien;
    @Column(name = "hp_pasien")
    private String hpPasien;
    @Basic(optional = false)
    @Column(name = "tempatlahir_pasien")
    private String tempatlahirPasien;
    @Basic(optional = false)
    @Column(name = "tgllahir_pasien")
    @Temporal(TemporalType.DATE)
    private Date tgllahirPasien;
    @Basic(optional = false)
    @Column(name = "kelamin_pasien")
    private String kelaminPasien;
    @Basic(optional = false)
    @Column(name = "darah_pasien")
    private String darahPasien;
    @Basic(optional = false)
    @Column(name = "regdate_pasien")
    @Temporal(TemporalType.DATE)
    private Date regdatePasien;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pasienIdPasien")
    private Collection<Kunjungan> kunjunganCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pasienIdPasien")
    private Collection<Rekammedik> rekammedisCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pasienIdPasien")
    private Collection<Antrian> antrianCollection;
    @JoinColumn(name = "user_id_user", referencedColumnName = "id_user")
    @ManyToOne
    private User userIdUser;
    @JoinColumn(name = "kota_id_kota", referencedColumnName = "id_kota")
    @ManyToOne(optional = false)
    private Kota kotaIdKota;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pasien")
    private Kartupasien kartupasien;

    public Pasien() {
    }

    public Pasien(String idPasien) {
        this.idPasien = idPasien;
    }

    public Pasien(String idPasien, String namaPasien, String alamatPasien, String kartuidPasien, String nokartuidPasien, String tempatlahirPasien, Date tgllahirPasien, String kelaminPasien, String darahPasien, Date regdatePasien) {
        this.idPasien = idPasien;
        this.namaPasien = namaPasien;
        this.alamatPasien = alamatPasien;
        this.kartuidPasien = kartuidPasien;
        this.nokartuidPasien = nokartuidPasien;
        this.tempatlahirPasien = tempatlahirPasien;
        this.tgllahirPasien = tgllahirPasien;
        this.kelaminPasien = kelaminPasien;
        this.darahPasien = darahPasien;
        this.regdatePasien = regdatePasien;
    }

    public String getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(String idPasien) {
        this.idPasien = idPasien;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }

    public String getAlamatPasien() {
        return alamatPasien;
    }

    public void setAlamatPasien(String alamatPasien) {
        this.alamatPasien = alamatPasien;
    }

    public String getKartuidPasien() {
        return kartuidPasien;
    }

    public void setKartuidPasien(String kartuidPasien) {
        this.kartuidPasien = kartuidPasien;
    }

    public String getNokartuidPasien() {
        return nokartuidPasien;
    }

    public void setNokartuidPasien(String nokartuidPasien) {
        this.nokartuidPasien = nokartuidPasien;
    }

    public String getTelpPasien() {
        return telpPasien;
    }

    public void setTelpPasien(String telpPasien) {
        this.telpPasien = telpPasien;
    }

    public String getHpPasien() {
        return hpPasien;
    }

    public void setHpPasien(String hpPasien) {
        this.hpPasien = hpPasien;
    }

    public String getTempatlahirPasien() {
        return tempatlahirPasien;
    }

    public void setTempatlahirPasien(String tempatlahirPasien) {
        this.tempatlahirPasien = tempatlahirPasien;
    }

    public Date getTgllahirPasien() {
        return tgllahirPasien;
    }

    public void setTgllahirPasien(Date tgllahirPasien) {
        this.tgllahirPasien = tgllahirPasien;
    }

    public String getKelaminPasien() {
        return kelaminPasien;
    }

    public void setKelaminPasien(String kelaminPasien) {
        this.kelaminPasien = kelaminPasien;
    }

    public String getDarahPasien() {
        return darahPasien;
    }

    public void setDarahPasien(String darahPasien) {
        this.darahPasien = darahPasien;
    }

    public Date getRegdatePasien() {
        return regdatePasien;
    }

    public void setRegdatePasien(Date regdatePasien) {
        this.regdatePasien = regdatePasien;
    }

    @XmlTransient
    public Collection<Kunjungan> getKunjunganCollection() {
        return kunjunganCollection;
    }

    public void setKunjunganCollection(Collection<Kunjungan> kunjunganCollection) {
        this.kunjunganCollection = kunjunganCollection;
    }

    @XmlTransient
    public Collection<Rekammedik> getRekammedisCollection() {
        return rekammedisCollection;
    }

    public void setRekammedisCollection(Collection<Rekammedik> rekammedisCollection) {
        this.rekammedisCollection = rekammedisCollection;
    }

    @XmlTransient
    public Collection<Antrian> getAntrianCollection() {
        return antrianCollection;
    }

    public void setAntrianCollection(Collection<Antrian> antrianCollection) {
        this.antrianCollection = antrianCollection;
    }

    public User getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(User userIdUser) {
        this.userIdUser = userIdUser;
    }

    public Kota getKotaIdKota() {
        return kotaIdKota;
    }

    public void setKotaIdKota(Kota kotaIdKota) {
        this.kotaIdKota = kotaIdKota;
    }

    public Kartupasien getKartupasien() {
        return kartupasien;
    }

    public void setKartupasien(Kartupasien kartupasien) {
        this.kartupasien = kartupasien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPasien != null ? idPasien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pasien)) {
            return false;
        }
        Pasien other = (Pasien) object;
        if ((this.idPasien == null && other.idPasien != null) || (this.idPasien != null && !this.idPasien.equals(other.idPasien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Pasien[ idPasien=" + idPasien + " ]";
    }
    
}
