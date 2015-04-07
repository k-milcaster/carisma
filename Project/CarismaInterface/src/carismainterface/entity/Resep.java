/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carismainterface.entity;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "resep")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resep.findAll", query = "SELECT r FROM Resep r"),
    @NamedQuery(name = "Resep.findByIdResep", query = "SELECT r FROM Resep r WHERE r.idResep = :idResep"),
    @NamedQuery(name = "Resep.findByKeterangan", query = "SELECT r FROM Resep r WHERE r.keterangan = :keterangan")})
public class Resep implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resepIdResep")
    private Collection<Rekammedik> rekammedikCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_resep")
    private String idResep;
    @Column(name = "keterangan")
    private String keterangan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resepIdResep")
    private String rekammedisCollection;

    public Resep() {
    }

    public Resep(String idResep) {
        this.idResep = idResep;
    }

    public String getIdResep() {
        return idResep;
    }

    public void setIdResep(String idResep) {
        this.idResep = idResep;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @XmlTransient
    public String getRekammedisCollection() {
        return rekammedisCollection;
    }

    public void setRekammedisCollection(String rekammedisCollection) {
        this.rekammedisCollection = rekammedisCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResep != null ? idResep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resep)) {
            return false;
        }
        Resep other = (Resep) object;
        if ((this.idResep == null && other.idResep != null) || (this.idResep != null && !this.idResep.equals(other.idResep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Resep[ idResep=" + idResep + " ]";
    }

    @XmlTransient
    public Collection<Rekammedik> getRekammedikCollection() {
        return rekammedikCollection;
    }

    public void setRekammedikCollection(Collection<Rekammedik> rekammedikCollection) {
        this.rekammedikCollection = rekammedikCollection;
    }
    
}
