package carismainterface.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author K-MiL Caster
 */
@Entity
@Table(name = "antrian")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Antrian.findAll", query = "SELECT a FROM Antrian a"),
    @NamedQuery(name = "Antrian.findByIdAntrian", query = "SELECT a FROM Antrian a WHERE a.idAntrian = :idAntrian"),
    @NamedQuery(name = "Antrian.findByNomorAntrian", query = "SELECT a FROM Antrian a WHERE a.nomorAntrian = :nomorAntrian"),
    @NamedQuery(name = "Antrian.findByJenisAntrian", query = "SELECT a FROM Antrian a WHERE a.jenisAntrian = :jenisAntrian"),
    @NamedQuery(name = "Antrian.findByTglAntrian", query = "SELECT a FROM Antrian a WHERE a.tglAntrian = :tglAntrian")})
public class Antrian implements Serializable {
    @Column(name = "hadir")
    private String hadir;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_antrian")
    private String idAntrian;
    @Basic(optional = false)
    @Column(name = "nomor_antrian")
    private int nomorAntrian;
    @Basic(optional = false)
    @Column(name = "jenis_antrian")
    private String jenisAntrian;
    @Basic(optional = false)
    @Column(name = "tgl_antrian")
    @Temporal(TemporalType.DATE)
    private String tglAntrian;
    @JoinColumn(name = "dokter_id_dokter", referencedColumnName = "id_dokter")
    @ManyToOne(optional = false)
    private String dokterIdDokter;
    @JoinColumn(name = "pasien_id_pasien", referencedColumnName = "id_pasien")
    @ManyToOne(optional = false)
    private String pasienIdPasien;

    public Antrian() {
    }

    public Antrian(String idAntrian) {
        this.idAntrian = idAntrian;
    }

    public Antrian(String idAntrian, int nomorAntrian, String jenisAntrian, String tglAntrian) {
        this.idAntrian = idAntrian;
        this.nomorAntrian = nomorAntrian;
        this.jenisAntrian = jenisAntrian;
        this.tglAntrian = tglAntrian;
    }

    public String getIdAntrian() {
        return idAntrian;
    }

    public void setIdAntrian(String idAntrian) {
        this.idAntrian = idAntrian;
    }

    public int getNomorAntrian() {
        return nomorAntrian;
    }

    public void setNomorAntrian(int nomorAntrian) {
        this.nomorAntrian = nomorAntrian;
    }

    public String getJenisAntrian() {
        return jenisAntrian;
    }

    public void setJenisAntrian(String jenisAntrian) {
        this.jenisAntrian = jenisAntrian;
    }

    public String getTglAntrian() {
        return tglAntrian;
    }

    public void setTglAntrian(String tglAntrian) {
        this.tglAntrian = tglAntrian;
    }

    public String getDokterIdDokter() {
        return dokterIdDokter;
    }

    public void setDokterIdDokter(String dokterIdDokter) {
        this.dokterIdDokter = dokterIdDokter;
    }

    public String getPasienIdPasien() {
        return pasienIdPasien;
    }

    public void setPasienIdPasien(String pasienIdPasien) {
        this.pasienIdPasien = pasienIdPasien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAntrian != null ? idAntrian.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Antrian)) {
            return false;
        }
        Antrian other = (Antrian) object;
        if ((this.idAntrian == null && other.idAntrian != null) || (this.idAntrian != null && !this.idAntrian.equals(other.idAntrian))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Antrian[ idAntrian=" + idAntrian + " ]";
    }

    public String getHadir() {
        return hadir;
    }

    public void setHadir(String hadir) {
        this.hadir = hadir;
    }
    
}
