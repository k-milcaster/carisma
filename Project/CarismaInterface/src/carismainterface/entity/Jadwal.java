package carismainterface.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "jadwal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jadwal.findAll", query = "SELECT j FROM Jadwal j"),
    @NamedQuery(name = "Jadwal.findById", query = "SELECT j FROM Jadwal j WHERE j.id = :id"),
    @NamedQuery(name = "Jadwal.findByHariJadwalpegawai", query = "SELECT j FROM Jadwal j WHERE j.hariJadwalpegawai = :hariJadwalpegawai"),
    @NamedQuery(name = "Jadwal.findByShiftJadwalpegawai", query = "SELECT j FROM Jadwal j WHERE j.shiftJadwalpegawai = :shiftJadwalpegawai")})
public class Jadwal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "hari_jadwalpegawai")
    private String hariJadwalpegawai;
    @Basic(optional = false)
    @Column(name = "shift_jadwalpegawai")
    private String shiftJadwalpegawai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jadwalId")
    private Collection<Jadwaldokter> jadwaldokterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jadwalId")
    private Collection<Jadwalpegawai> jadwalpegawaiCollection;

    public Jadwal() {
    }

    public Jadwal(Integer id) {
        this.id = id;
    }

    public Jadwal(Integer id, String hariJadwalpegawai, String shiftJadwalpegawai) {
        this.id = id;
        this.hariJadwalpegawai = hariJadwalpegawai;
        this.shiftJadwalpegawai = shiftJadwalpegawai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHariJadwalpegawai() {
        return hariJadwalpegawai;
    }

    public void setHariJadwalpegawai(String hariJadwalpegawai) {
        this.hariJadwalpegawai = hariJadwalpegawai;
    }

    public String getShiftJadwalpegawai() {
        return shiftJadwalpegawai;
    }

    public void setShiftJadwalpegawai(String shiftJadwalpegawai) {
        this.shiftJadwalpegawai = shiftJadwalpegawai;
    }

    @XmlTransient
    public Collection<Jadwaldokter> getJadwaldokterCollection() {
        return jadwaldokterCollection;
    }

    public void setJadwaldokterCollection(Collection<Jadwaldokter> jadwaldokterCollection) {
        this.jadwaldokterCollection = jadwaldokterCollection;
    }

    @XmlTransient
    public Collection<Jadwalpegawai> getJadwalpegawaiCollection() {
        return jadwalpegawaiCollection;
    }

    public void setJadwalpegawaiCollection(Collection<Jadwalpegawai> jadwalpegawaiCollection) {
        this.jadwalpegawaiCollection = jadwalpegawaiCollection;
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
        if (!(object instanceof Jadwal)) {
            return false;
        }
        Jadwal other = (Jadwal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Jadwal[ id=" + id + " ]";
    }
    
}
