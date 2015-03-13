/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carismainterface.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author K-MiL Caster
 */
@Entity
@Table(name = "penyakit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Penyakit.findAll", query = "SELECT p FROM Penyakit p"),
    @NamedQuery(name = "Penyakit.findByIdPenyakit", query = "SELECT p FROM Penyakit p WHERE p.idPenyakit = :idPenyakit"),
    @NamedQuery(name = "Penyakit.findByNamaPenyakit", query = "SELECT p FROM Penyakit p WHERE p.namaPenyakit = :namaPenyakit"),
    @NamedQuery(name = "Penyakit.findByDeskripsiPenyakit", query = "SELECT p FROM Penyakit p WHERE p.deskripsiPenyakit = :deskripsiPenyakit")})
public class Penyakit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_penyakit")
    private String idPenyakit;
    @Basic(optional = false)
    @Column(name = "nama_penyakit")
    private String namaPenyakit;
    @Column(name = "deskripsi_penyakit")
    private String deskripsiPenyakit;
    @JoinTable(name = "rekammedis_penyakit", joinColumns = {
        @JoinColumn(name = "penyakit_id_penyakit", referencedColumnName = "id_penyakit")}, inverseJoinColumns = {
        @JoinColumn(name = "rekammedis_id_rekammedis", referencedColumnName = "id_rekammedis")})
    @ManyToMany
    private Collection<Rekammedik> rekammedisCollection;

    public Penyakit() {
    }

    public Penyakit(String idPenyakit) {
        this.idPenyakit = idPenyakit;
    }

    public Penyakit(String idPenyakit, String namaPenyakit) {
        this.idPenyakit = idPenyakit;
        this.namaPenyakit = namaPenyakit;
    }

    public String getIdPenyakit() {
        return idPenyakit;
    }

    public void setIdPenyakit(String idPenyakit) {
        this.idPenyakit = idPenyakit;
    }

    public String getNamaPenyakit() {
        return namaPenyakit;
    }

    public void setNamaPenyakit(String namaPenyakit) {
        this.namaPenyakit = namaPenyakit;
    }

    public String getDeskripsiPenyakit() {
        return deskripsiPenyakit;
    }

    public void setDeskripsiPenyakit(String deskripsiPenyakit) {
        this.deskripsiPenyakit = deskripsiPenyakit;
    }

    @XmlTransient
    public Collection<Rekammedik> getRekammedisCollection() {
        return rekammedisCollection;
    }

    public void setRekammedisCollection(Collection<Rekammedik> rekammedisCollection) {
        this.rekammedisCollection = rekammedisCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPenyakit != null ? idPenyakit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Penyakit)) {
            return false;
        }
        Penyakit other = (Penyakit) object;
        if ((this.idPenyakit == null && other.idPenyakit != null) || (this.idPenyakit != null && !this.idPenyakit.equals(other.idPenyakit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Penyakit[ idPenyakit=" + idPenyakit + " ]";
    }
    
}
