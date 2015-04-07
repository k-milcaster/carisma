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
import javax.persistence.Lob;
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
@Table(name = "dokter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dokter.findAll", query = "SELECT d FROM Dokter d"),
    @NamedQuery(name = "Dokter.findByIdDokter", query = "SELECT d FROM Dokter d WHERE d.idDokter = :idDokter"),
    @NamedQuery(name = "Dokter.findByNamaDokter", query = "SELECT d FROM Dokter d WHERE d.namaDokter = :namaDokter"),
    @NamedQuery(name = "Dokter.findByAlamatDokter", query = "SELECT d FROM Dokter d WHERE d.alamatDokter = :alamatDokter"),
    @NamedQuery(name = "Dokter.findByNokartuidDokter", query = "SELECT d FROM Dokter d WHERE d.nokartuidDokter = :nokartuidDokter"),
    @NamedQuery(name = "Dokter.findByTelpDokter", query = "SELECT d FROM Dokter d WHERE d.telpDokter = :telpDokter"),
    @NamedQuery(name = "Dokter.findByHp1Dokter", query = "SELECT d FROM Dokter d WHERE d.hp1Dokter = :hp1Dokter"),
    @NamedQuery(name = "Dokter.findByHp2Dokter", query = "SELECT d FROM Dokter d WHERE d.hp2Dokter = :hp2Dokter"),
    @NamedQuery(name = "Dokter.findByTempatlahirDokter", query = "SELECT d FROM Dokter d WHERE d.tempatlahirDokter = :tempatlahirDokter"),
    @NamedQuery(name = "Dokter.findByTgllahirDokter", query = "SELECT d FROM Dokter d WHERE d.tgllahirDokter = :tgllahirDokter"),
    @NamedQuery(name = "Dokter.findByKelaminDokter", query = "SELECT d FROM Dokter d WHERE d.kelaminDokter = :kelaminDokter"),
    @NamedQuery(name = "Dokter.findByDarahDokter", query = "SELECT d FROM Dokter d WHERE d.darahDokter = :darahDokter"),
    @NamedQuery(name = "Dokter.findByBankDokter", query = "SELECT d FROM Dokter d WHERE d.bankDokter = :bankDokter"),
    @NamedQuery(name = "Dokter.findByNorekDokter", query = "SELECT d FROM Dokter d WHERE d.norekDokter = :norekDokter"),
    @NamedQuery(name = "Dokter.findByGajifixDokter", query = "SELECT d FROM Dokter d WHERE d.gajifixDokter = :gajifixDokter"),
    @NamedQuery(name = "Dokter.findByGajilemburDokter", query = "SELECT d FROM Dokter d WHERE d.gajilemburDokter = :gajilemburDokter"),
    @NamedQuery(name = "Dokter.findByGajikonsulDokter", query = "SELECT d FROM Dokter d WHERE d.gajikonsulDokter = :gajikonsulDokter")})
public class Dokter implements Serializable {
    @Basic(optional = false)
    @Column(name = "tgllahir_dokter")
    @Temporal(TemporalType.DATE)
    private String tgllahirDokter;
    @Lob
    @Column(name = "foto_dokter")
    private byte[] fotoDokter;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dokterIdDokter")
    private Collection<Rekammedik> rekammedikCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_dokter")
    private String idDokter;
    @Basic(optional = false)
    @Column(name = "nama_dokter")
    private String namaDokter;
    @Basic(optional = false)
    @Column(name = "alamat_dokter")
    private String alamatDokter;
    @Basic(optional = false)
    @Column(name = "nokartuid_dokter")
    private String nokartuidDokter;
    @Column(name = "telp_dokter")
    private String telpDokter;
    @Column(name = "hp1_dokter")
    private String hp1Dokter;
    @Column(name = "hp2_dokter")
    private String hp2Dokter;
    @Basic(optional = false)
    @Column(name = "tempatlahir_dokter")
    private String tempatlahirDokter;
    @Basic(optional = false)
    @Column(name = "kelamin_dokter")
    private String kelaminDokter;
    @Basic(optional = false)
    @Column(name = "darah_dokter")
    private String darahDokter;
    @Column(name = "bank_dokter")
    private String bankDokter;
    @Column(name = "norek_dokter")
    private String norekDokter;
    @Column(name = "gajifix_dokter")
    private Integer gajifixDokter;
    @Column(name = "gajilembur_dokter")
    private Integer gajilemburDokter;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "gajikonsul_dokter")
    private Double gajikonsulDokter;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "dokter")
    private Jadwaldokter jadwaldokter;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dokterIdDokter")
    private Collection<Rekammedik> rekammedisCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dokterIdDokter")
    private Collection<Antrian> antrianCollection;
    @JoinColumn(name = "user_id_user", referencedColumnName = "id_user")
    @ManyToOne
    private Integer userIdUser;
    @JoinColumn(name = "poli_id_poli", referencedColumnName = "id_poli")
    @ManyToOne(optional = false)
    private String poliIdPoli;

    public Dokter() {
    }
    
    public Dokter(Dokter dokter) {
        this.idDokter = dokter.idDokter;
        this.namaDokter = dokter.namaDokter;
        this.alamatDokter = dokter.alamatDokter;
        this.nokartuidDokter = dokter.nokartuidDokter;
        this.telpDokter = dokter.telpDokter;
        this.hp1Dokter = dokter.hp1Dokter;
        this.hp2Dokter = dokter.hp2Dokter;
        this.tempatlahirDokter = dokter.tempatlahirDokter;
        this.tgllahirDokter = dokter.tgllahirDokter;
        this.kelaminDokter = dokter.kelaminDokter;
        this.darahDokter = dokter.darahDokter;
        this.bankDokter = dokter.bankDokter;
        this.norekDokter = dokter.norekDokter;
        this.gajifixDokter = dokter.gajifixDokter;
        this.gajilemburDokter = dokter.gajilemburDokter;
        this.gajikonsulDokter = dokter.gajikonsulDokter;
        this.userIdUser = dokter.userIdUser;
    }
    
    public Dokter(String idDokter) {
        this.idDokter = idDokter;
    }

    public Dokter(String idDokter, String namaDokter, String alamatDokter, String nokartuidDokter, String tempatlahirDokter, String tgllahirDokter, String kelaminDokter, String darahDokter) {
        this.idDokter = idDokter;
        this.namaDokter = namaDokter;
        this.alamatDokter = alamatDokter;
        this.nokartuidDokter = nokartuidDokter;
        this.tempatlahirDokter = tempatlahirDokter;
        this.tgllahirDokter = tgllahirDokter;
        this.kelaminDokter = kelaminDokter;
        this.darahDokter = darahDokter;
    }

    public String getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public void setNamaDokter(String namaDokter) {
        this.namaDokter = namaDokter;
    }

    public String getAlamatDokter() {
        return alamatDokter;
    }

    public void setAlamatDokter(String alamatDokter) {
        this.alamatDokter = alamatDokter;
    }

    public String getNokartuidDokter() {
        return nokartuidDokter;
    }

    public void setNokartuidDokter(String nokartuidDokter) {
        this.nokartuidDokter = nokartuidDokter;
    }

    public String getTelpDokter() {
        return telpDokter;
    }

    public void setTelpDokter(String telpDokter) {
        this.telpDokter = telpDokter;
    }

    public String getHp1Dokter() {
        return hp1Dokter;
    }

    public void setHp1Dokter(String hp1Dokter) {
        this.hp1Dokter = hp1Dokter;
    }

    public String getHp2Dokter() {
        return hp2Dokter;
    }

    public void setHp2Dokter(String hp2Dokter) {
        this.hp2Dokter = hp2Dokter;
    }

    public String getTempatlahirDokter() {
        return tempatlahirDokter;
    }

    public void setTempatlahirDokter(String tempatlahirDokter) {
        this.tempatlahirDokter = tempatlahirDokter;
    }

    public String getTgllahirDokter() {
        return tgllahirDokter;
    }

    public void setTgllahirDokter(String tgllahirDokter) {
        this.tgllahirDokter = tgllahirDokter;
    }

    public String getKelaminDokter() {
        return kelaminDokter;
    }

    public void setKelaminDokter(String kelaminDokter) {
        this.kelaminDokter = kelaminDokter;
    }

    public String getDarahDokter() {
        return darahDokter;
    }

    public void setDarahDokter(String darahDokter) {
        this.darahDokter = darahDokter;
    }

    public String getBankDokter() {
        return bankDokter;
    }

    public void setBankDokter(String bankDokter) {
        this.bankDokter = bankDokter;
    }

    public String getNorekDokter() {
        return norekDokter;
    }

    public void setNorekDokter(String norekDokter) {
        this.norekDokter = norekDokter;
    }

    public byte[] getFotoDokter() {
        return fotoDokter;
    }

    public void setFotoDokter(byte[] fotoDokter) {
        this.fotoDokter = fotoDokter;
    }

    public Integer getGajifixDokter() {
        return gajifixDokter;
    }

    public void setGajifixDokter(Integer gajifixDokter) {
        this.gajifixDokter = gajifixDokter;
    }

    public Integer getGajilemburDokter() {
        return gajilemburDokter;
    }

    public void setGajilemburDokter(Integer gajilemburDokter) {
        this.gajilemburDokter = gajilemburDokter;
    }

    public Double getGajikonsulDokter() {
        return gajikonsulDokter;
    }

    public void setGajikonsulDokter(Double gajikonsulDokter) {
        this.gajikonsulDokter = gajikonsulDokter;
    }

    public Jadwaldokter getJadwaldokter() {
        return jadwaldokter;
    }

    public void setJadwaldokter(Jadwaldokter jadwaldokter) {
        this.jadwaldokter = jadwaldokter;
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

    public Integer getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(Integer userIdUser) {
        this.userIdUser = userIdUser;
    }

    public String getPoliIdPoli() {
        return poliIdPoli;
    }

    public void setPoliIdPoli(String poliIdPoli) {
        this.poliIdPoli = poliIdPoli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDokter != null ? idDokter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dokter)) {
            return false;
        }
        Dokter other = (Dokter) object;
        if ((this.idDokter == null && other.idDokter != null) || (this.idDokter != null && !this.idDokter.equals(other.idDokter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Dokter[ idDokter=" + idDokter + " ]";
    }

    @XmlTransient
    public Collection<Rekammedik> getRekammedikCollection() {
        return rekammedikCollection;
    }

    public void setRekammedikCollection(Collection<Rekammedik> rekammedikCollection) {
        this.rekammedikCollection = rekammedikCollection;
    }
    
}
