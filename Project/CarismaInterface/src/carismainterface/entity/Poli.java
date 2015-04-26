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
@Table(name = "poli")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Poli.findAll", query = "SELECT p FROM Poli p"),
    @NamedQuery(name = "Poli.findByIdPoli", query = "SELECT p FROM Poli p WHERE p.idPoli = :idPoli"),
    @NamedQuery(name = "Poli.findByNamaPoli", query = "SELECT p FROM Poli p WHERE p.namaPoli = :namaPoli"),
    @NamedQuery(name = "Poli.findByKeterangan", query = "SELECT p FROM Poli p WHERE p.keterangan = :keterangan")})
public class Poli implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_poli")
    private String idPoli;
    @Basic(optional = false)
    @Column(name = "nama_poli")
    private String namaPoli;
    @Column(name = "keterangan")
    private String keterangan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poliIdPoli")
    private String dokterCollection;

    public Poli() {
    }

    public Poli(String idPoli) {
        this.idPoli = idPoli;
    }

    public Poli(String idPoli, String namaPoli, String keterangan) {
        this.idPoli = idPoli;
        this.namaPoli = namaPoli;
        this.keterangan = keterangan;
    }

    public String getIdPoli() {
        return idPoli;
    }

    public void setIdPoli(String idPoli) {
        this.idPoli = idPoli;
    }

    public String getNamaPoli() {
        return namaPoli;
    }

    public void setNamaPoli(String namaPoli) {
        this.namaPoli = namaPoli;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @XmlTransient
    public String getDokterCollection() {
        return dokterCollection;
    }

    public void setDokterCollection(String dokterCollection) {
        this.dokterCollection = dokterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPoli != null ? idPoli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poli)) {
            return false;
        }
        Poli other = (Poli) object;
        if ((this.idPoli == null && other.idPoli != null) || (this.idPoli != null && !this.idPoli.equals(other.idPoli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Poli[ idPoli=" + idPoli + " ]";
    }
    
}
