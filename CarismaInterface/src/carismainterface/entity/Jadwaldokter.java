package carismainterface.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "jadwaldokter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jadwaldokter.findAll", query = "SELECT j FROM Jadwaldokter j"),
    @NamedQuery(name = "Jadwaldokter.findByDokterIdDokter", query = "SELECT j FROM Jadwaldokter j WHERE j.dokterIdDokter = :dokterIdDokter"),
    @NamedQuery(name = "Jadwaldokter.findByHariJadwaldokter", query = "SELECT j FROM Jadwaldokter j WHERE j.hariJadwaldokter = :hariJadwaldokter"),
    @NamedQuery(name = "Jadwaldokter.findByShiftJadwaldokter", query = "SELECT j FROM Jadwaldokter j WHERE j.shiftJadwaldokter = :shiftJadwaldokter"),
    @NamedQuery(name = "Jadwaldokter.findByKeterangan", query = "SELECT j FROM Jadwaldokter j WHERE j.keterangan = :keterangan")})
public class Jadwaldokter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "jadwal_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Integer jadwalId;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dokter_id_dokter")
    private String dokterIdDokter;
    @Basic(optional = false)
    @Column(name = "hari_jadwaldokter")
    private String hariJadwaldokter;
    @Basic(optional = false)
    @Column(name = "shift_jadwaldokter")
    private String shiftJadwaldokter;
    @Column(name = "keterangan")
    private String keterangan;
    @JoinColumn(name = "dokter_id_dokter", referencedColumnName = "id_dokter", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private String dokter;

    public Jadwaldokter() {
    }

    public Jadwaldokter(String dokterIdDokter) {
        this.dokterIdDokter = dokterIdDokter;
    }

    public Jadwaldokter(String dokterIdDokter, String hariJadwaldokter, String shiftJadwaldokter) {
        this.dokterIdDokter = dokterIdDokter;
        this.hariJadwaldokter = hariJadwaldokter;
        this.shiftJadwaldokter = shiftJadwaldokter;
    }

    public String getDokterIdDokter() {
        return dokterIdDokter;
    }

    public void setDokterIdDokter(String dokterIdDokter) {
        this.dokterIdDokter = dokterIdDokter;
    }

    public String getHariJadwaldokter() {
        return hariJadwaldokter;
    }

    public void setHariJadwaldokter(String hariJadwaldokter) {
        this.hariJadwaldokter = hariJadwaldokter;
    }

    public String getShiftJadwaldokter() {
        return shiftJadwaldokter;
    }

    public void setShiftJadwaldokter(String shiftJadwaldokter) {
        this.shiftJadwaldokter = shiftJadwaldokter;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getDokter() {
        return dokter;
    }

    public void setDokter(String dokter) {
        this.dokter = dokter;
    }

    public Jadwaldokter(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJadwalId() {
        return jadwalId;
    }

    public void setJadwalId(Integer jadwalId) {
        this.jadwalId = jadwalId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jadwaldokter)) {
            return false;
        }
        Jadwaldokter other = (Jadwaldokter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Jadwaldokter[ id=" + id + " ]";
    }
    
}
