/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carismainterface.entity;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author K-MiL Caster
 */
@Entity
@Table(name = "pegawai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pegawai.findAll", query = "SELECT p FROM Pegawai p"),
    @NamedQuery(name = "Pegawai.findByIdPegawai", query = "SELECT p FROM Pegawai p WHERE p.idPegawai = :idPegawai"),
    @NamedQuery(name = "Pegawai.findByNamaPegawai", query = "SELECT p FROM Pegawai p WHERE p.namaPegawai = :namaPegawai"),
    @NamedQuery(name = "Pegawai.findByAlamatPegawai", query = "SELECT p FROM Pegawai p WHERE p.alamatPegawai = :alamatPegawai"),
    @NamedQuery(name = "Pegawai.findByNokartuidPegawai", query = "SELECT p FROM Pegawai p WHERE p.nokartuidPegawai = :nokartuidPegawai"),
    @NamedQuery(name = "Pegawai.findByTelpPegawai", query = "SELECT p FROM Pegawai p WHERE p.telpPegawai = :telpPegawai"),
    @NamedQuery(name = "Pegawai.findByHp1Pegawai", query = "SELECT p FROM Pegawai p WHERE p.hp1Pegawai = :hp1Pegawai"),
    @NamedQuery(name = "Pegawai.findByHp2Pegawai", query = "SELECT p FROM Pegawai p WHERE p.hp2Pegawai = :hp2Pegawai"),
    @NamedQuery(name = "Pegawai.findByTempatlahirPegawai", query = "SELECT p FROM Pegawai p WHERE p.tempatlahirPegawai = :tempatlahirPegawai"),
    @NamedQuery(name = "Pegawai.findByTgllahirPegawai", query = "SELECT p FROM Pegawai p WHERE p.tgllahirPegawai = :tgllahirPegawai"),
    @NamedQuery(name = "Pegawai.findByKelaminPegawai", query = "SELECT p FROM Pegawai p WHERE p.kelaminPegawai = :kelaminPegawai"),
    @NamedQuery(name = "Pegawai.findByDarahPegawai", query = "SELECT p FROM Pegawai p WHERE p.darahPegawai = :darahPegawai"),
    @NamedQuery(name = "Pegawai.findByJabatanPegawai", query = "SELECT p FROM Pegawai p WHERE p.jabatanPegawai = :jabatanPegawai"),
    @NamedQuery(name = "Pegawai.findByBankPegawai", query = "SELECT p FROM Pegawai p WHERE p.bankPegawai = :bankPegawai"),
    @NamedQuery(name = "Pegawai.findByNorekPegawai", query = "SELECT p FROM Pegawai p WHERE p.norekPegawai = :norekPegawai"),
    @NamedQuery(name = "Pegawai.findByGajifixPegawai", query = "SELECT p FROM Pegawai p WHERE p.gajifixPegawai = :gajifixPegawai"),
    @NamedQuery(name = "Pegawai.findByGajilemburPegawai", query = "SELECT p FROM Pegawai p WHERE p.gajilemburPegawai = :gajilemburPegawai")})
public class Pegawai implements Serializable {

    @Lob
    @Column(name = "foto_pegawai")
    private byte[] fotoPegawai;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_pegawai")
    private String idPegawai;
    @Basic(optional = false)
    @Column(name = "nama_pegawai")
    private String namaPegawai;
    @Basic(optional = false)
    @Column(name = "alamat_pegawai")
    private String alamatPegawai;
    @Basic(optional = false)
    @Column(name = "nokartuid_pegawai")
    private String nokartuidPegawai;
    @Column(name = "telp_pegawai")
    private String telpPegawai;
    @Column(name = "hp1_pegawai")
    private String hp1Pegawai;
    @Column(name = "hp2_pegawai")
    private String hp2Pegawai;
    @Basic(optional = false)
    @Column(name = "tempatlahir_pegawai")
    private String tempatlahirPegawai;
    @Basic(optional = false)
    @Column(name = "tgllahir_pegawai")
    private String tgllahirPegawai;
    @Basic(optional = false)
    @Column(name = "kelamin_pegawai")
    private String kelaminPegawai;
    @Basic(optional = false)
    @Column(name = "darah_pegawai")
    private String darahPegawai;
    @Basic(optional = false)
    @Column(name = "jabatan_pegawai")
    private String jabatanPegawai;
    @Column(name = "bank_pegawai")
    private String bankPegawai;
    @Column(name = "norek_pegawai")
    private String norekPegawai;
    @Column(name = "gajifix_pegawai")
    private Integer gajifixPegawai;
    @Column(name = "gajilembur_pegawai")
    private Integer gajilemburPegawai;
    @JoinColumn(name = "user_id_user", referencedColumnName = "id_user")
    @ManyToOne
    private int userIdUser;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pegawai")
    private String jadwalpegawai;

    public Pegawai() {
    }

    public Pegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    public Pegawai(Pegawai pegawai) {
        this.idPegawai = pegawai.idPegawai;
        this.namaPegawai = pegawai.namaPegawai;
        this.alamatPegawai = pegawai.alamatPegawai;
        this.nokartuidPegawai = pegawai.nokartuidPegawai;
        this.telpPegawai = pegawai.telpPegawai;
        this.hp1Pegawai = pegawai.hp1Pegawai;
        this.hp2Pegawai = pegawai.hp2Pegawai;
        this.tempatlahirPegawai = pegawai.tempatlahirPegawai;
        this.tgllahirPegawai = pegawai.tgllahirPegawai;
        this.kelaminPegawai = pegawai.kelaminPegawai;
        this.darahPegawai = pegawai.darahPegawai;
        this.jabatanPegawai = pegawai.jabatanPegawai;
        this.bankPegawai = pegawai.bankPegawai;
        this.norekPegawai = pegawai.norekPegawai;
        this.fotoPegawai = pegawai.fotoPegawai;
        this.gajifixPegawai = pegawai.gajifixPegawai;
        this.gajilemburPegawai = pegawai.gajilemburPegawai;
        this.userIdUser = pegawai.userIdUser;
    }

    public Pegawai(String idPegawai, String namaPegawai, String alamatPegawai, String nokartuidPegawai, String tempatlahirPegawai, String tgllahirPegawai, String kelaminPegawai, String darahPegawai, String jabatanPegawai) {
        this.idPegawai = idPegawai;
        this.namaPegawai = namaPegawai;
        this.alamatPegawai = alamatPegawai;
        this.nokartuidPegawai = nokartuidPegawai;
        this.tempatlahirPegawai = tempatlahirPegawai;
        this.tgllahirPegawai = tgllahirPegawai;
        this.kelaminPegawai = kelaminPegawai;
        this.darahPegawai = darahPegawai;
        this.jabatanPegawai = jabatanPegawai;
    }

    public String getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    public String getNamaPegawai() {
        return namaPegawai;
    }

    public void setNamaPegawai(String namaPegawai) {
        this.namaPegawai = namaPegawai;
    }

    public String getAlamatPegawai() {
        return alamatPegawai;
    }

    public void setAlamatPegawai(String alamatPegawai) {
        this.alamatPegawai = alamatPegawai;
    }

    public String getNokartuidPegawai() {
        return nokartuidPegawai;
    }

    public void setNokartuidPegawai(String nokartuidPegawai) {
        this.nokartuidPegawai = nokartuidPegawai;
    }

    public String getTelpPegawai() {
        return telpPegawai;
    }

    public void setTelpPegawai(String telpPegawai) {
        this.telpPegawai = telpPegawai;
    }

    public String getHp1Pegawai() {
        return hp1Pegawai;
    }

    public void setHp1Pegawai(String hp1Pegawai) {
        this.hp1Pegawai = hp1Pegawai;
    }

    public String getHp2Pegawai() {
        return hp2Pegawai;
    }

    public void setHp2Pegawai(String hp2Pegawai) {
        this.hp2Pegawai = hp2Pegawai;
    }

    public String getTempatlahirPegawai() {
        return tempatlahirPegawai;
    }

    public void setTempatlahirPegawai(String tempatlahirPegawai) {
        this.tempatlahirPegawai = tempatlahirPegawai;
    }

    public String getTgllahirPegawai() {
        return tgllahirPegawai;
    }

    public void setTgllahirPegawai(String tgllahirPegawai) {
        this.tgllahirPegawai = tgllahirPegawai;
    }

    public String getKelaminPegawai() {
        return kelaminPegawai;
    }

    public void setKelaminPegawai(String kelaminPegawai) {
        this.kelaminPegawai = kelaminPegawai;
    }

    public String getDarahPegawai() {
        return darahPegawai;
    }

    public void setDarahPegawai(String darahPegawai) {
        this.darahPegawai = darahPegawai;
    }

    public String getJabatanPegawai() {
        return jabatanPegawai;
    }

    public void setJabatanPegawai(String jabatanPegawai) {
        this.jabatanPegawai = jabatanPegawai;
    }

    public String getBankPegawai() {
        return bankPegawai;
    }

    public void setBankPegawai(String bankPegawai) {
        this.bankPegawai = bankPegawai;
    }

    public String getNorekPegawai() {
        return norekPegawai;
    }

    public void setNorekPegawai(String norekPegawai) {
        this.norekPegawai = norekPegawai;
    }

    public byte[] getFotoPegawai() {
        return fotoPegawai;
    }

    public void setFotoPegawai(byte[] fotoPegawai) {
        this.fotoPegawai = fotoPegawai;
    }

    public Integer getGajifixPegawai() {
        return gajifixPegawai;
    }

    public void setGajifixPegawai(Integer gajifixPegawai) {
        this.gajifixPegawai = gajifixPegawai;
    }

    public Integer getGajilemburPegawai() {
        return gajilemburPegawai;
    }

    public void setGajilemburPegawai(Integer gajilemburPegawai) {
        this.gajilemburPegawai = gajilemburPegawai;
    }

    public int getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(int userIdUser) {
        this.userIdUser = userIdUser;
    }

    public String getJadwalpegawai() {
        return jadwalpegawai;
    }

    public void setJadwalpegawai(String jadwalpegawai) {
        this.jadwalpegawai = jadwalpegawai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPegawai != null ? idPegawai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pegawai)) {
            return false;
        }
        Pegawai other = (Pegawai) object;
        if ((this.idPegawai == null && other.idPegawai != null) || (this.idPegawai != null && !this.idPegawai.equals(other.idPegawai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Pegawai[ idPegawai=" + idPegawai + " ]";
    }

}
