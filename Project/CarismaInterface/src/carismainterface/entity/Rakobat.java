/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author K-MiL Caster
 */
@Entity
@Table(name = "rakobat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rakobat.findAll", query = "SELECT r FROM Rakobat r"),
    @NamedQuery(name = "Rakobat.findByIdRak", query = "SELECT r FROM Rakobat r WHERE r.idRak = :idRak"),
    @NamedQuery(name = "Rakobat.findByNamaRak", query = "SELECT r FROM Rakobat r WHERE r.namaRak = :namaRak")})
public class Rakobat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_rak")
    private Integer idRak;
    @Column(name = "nama_rak")
    private String namaRak;
    @JoinColumn(name = "obat_id_obat", referencedColumnName = "id_obat")
    @ManyToOne(optional = false)
    private Integer obatIdObat;

    public Rakobat() {
    }

    public Rakobat(Integer idRak) {
        this.idRak = idRak;
    }

    public Integer getIdRak() {
        return idRak;
    }

    public void setIdRak(Integer idRak) {
        this.idRak = idRak;
    }

    public String getNamaRak() {
        return namaRak;
    }

    public void setNamaRak(String namaRak) {
        this.namaRak = namaRak;
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
        hash += (idRak != null ? idRak.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rakobat)) {
            return false;
        }
        Rakobat other = (Rakobat) object;
        if ((this.idRak == null && other.idRak != null) || (this.idRak != null && !this.idRak.equals(other.idRak))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Rakobat[ idRak=" + idRak + " ]";
    }
    
}
