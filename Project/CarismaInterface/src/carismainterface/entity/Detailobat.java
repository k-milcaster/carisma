package carismainterface.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "detailobat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detailobat.findAll", query = "SELECT d FROM Detailobat d"),
    @NamedQuery(name = "Detailobat.findByIdDetail", query = "SELECT d FROM Detailobat d WHERE d.idDetail = :idDetail"),
    @NamedQuery(name = "Detailobat.findByTglkadaluarsaDetail", query = "SELECT d FROM Detailobat d WHERE d.tglkadaluarsaDetail = :tglkadaluarsaDetail")})
public class Detailobat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_detail")
    private Integer idDetail;
    @Column(name = "tglkadaluarsa_detail")
    @Temporal(TemporalType.DATE)
    private String tglkadaluarsaDetail;
    @JoinColumn(name = "obat_id_obat", referencedColumnName = "id_obat")
    @ManyToOne(optional = false)
    private Integer obatIdObat;

    public Detailobat() {
    }

    public Detailobat(Integer idDetail) {
        this.idDetail = idDetail;
    }

    public Integer getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(Integer idDetail) {
        this.idDetail = idDetail;
    }

    public String getTglkadaluarsaDetail() {
        return tglkadaluarsaDetail;
    }

    public void setTglkadaluarsaDetail(String tglkadaluarsaDetail) {
        this.tglkadaluarsaDetail = tglkadaluarsaDetail;
    }

    public Integer getObatIdObat() {
        return obatIdObat;
    }

    public void setObatIdObat(Integer obatIdObat) {
        this.obatIdObat = obatIdObat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetail != null ? idDetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detailobat)) {
            return false;
        }
        Detailobat other = (Detailobat) object;
        if ((this.idDetail == null && other.idDetail != null) || (this.idDetail != null && !this.idDetail.equals(other.idDetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Detailobat[ idDetail=" + idDetail + " ]";
    }
    
}
