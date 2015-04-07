package carismainterface.entity;

import java.io.Serializable;
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
    private String detailtransaksijualobatCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "obat")
    private String detailtransaksibeliobatCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "obatIdObat")
    private String detailobatCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "obatIdObat")
    private String rakobatCollection;

    public Obat() {
    }

    public Obat(Obat obat) {
        this.idObat = obat.idObat;
        this.namaObat = obat.namaObat;
        this.qtyObat = obat.qtyObat;
        this.jenisObat = obat.jenisObat;
        this.keterangan = obat.keterangan;
        this.hargajualObat = obat.hargajualObat;        
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

    public Integer getHargajualObat() {
        return hargajualObat;
    }

    public void setHargajualObat(Integer hargajualObat) {
        this.hargajualObat = hargajualObat;
    }

    @XmlTransient
    public String getDetailtransaksijualobatCollection() {
        return detailtransaksijualobatCollection;
    }

    public void setDetailtransaksijualobatCollection(String detailtransaksijualobatCollection) {
        this.detailtransaksijualobatCollection = detailtransaksijualobatCollection;
    }

    @XmlTransient
    public String getDetailtransaksibeliobatCollection() {
        return detailtransaksibeliobatCollection;
    }

    public void setDetailtransaksibeliobatCollection(String detailtransaksibeliobatCollection) {
        this.detailtransaksibeliobatCollection = detailtransaksibeliobatCollection;
    }

    @XmlTransient
    public String getDetailobatCollection() {
        return detailobatCollection;
    }

    public void setDetailobatCollection(String detailobatCollection) {
        this.detailobatCollection = detailobatCollection;
    }

    @XmlTransient
    public String getRakobatCollection() {
        return rakobatCollection;
    }

    public void setRakobatCollection(String rakobatCollection) {
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


}
