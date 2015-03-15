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
@Table(name = "provinsi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provinsi.findAll", query = "SELECT p FROM Provinsi p"),
    @NamedQuery(name = "Provinsi.findByIdProvinsi", query = "SELECT p FROM Provinsi p WHERE p.idProvinsi = :idProvinsi"),
    @NamedQuery(name = "Provinsi.findByNamaProvinsi", query = "SELECT p FROM Provinsi p WHERE p.namaProvinsi = :namaProvinsi")})
public class Provinsi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_provinsi")
    private String idProvinsi;
    @Basic(optional = false)
    @Column(name = "nama_provinsi")
    private String namaProvinsi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provinsi")
    private String kotaCollection;

    public Provinsi() {
    }

    public Provinsi(String idProvinsi) {
        this.idProvinsi = idProvinsi;
    }

    public Provinsi(String idProvinsi, String namaProvinsi) {
        this.idProvinsi = idProvinsi;
        this.namaProvinsi = namaProvinsi;
    }

    public String getIdProvinsi() {
        return idProvinsi;
    }

    public void setIdProvinsi(String idProvinsi) {
        this.idProvinsi = idProvinsi;
    }

    public String getNamaProvinsi() {
        return namaProvinsi;
    }

    public void setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
    }

    @XmlTransient
    public String getKotaCollection() {
        return kotaCollection;
    }

    public void setKotaCollection(String kotaCollection) {
        this.kotaCollection = kotaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProvinsi != null ? idProvinsi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provinsi)) {
            return false;
        }
        Provinsi other = (Provinsi) object;
        if ((this.idProvinsi == null && other.idProvinsi != null) || (this.idProvinsi != null && !this.idProvinsi.equals(other.idProvinsi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Provinsi[ idProvinsi=" + idProvinsi + " ]";
    }
    
}
