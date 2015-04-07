/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carismainterface.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author K-MiL Caster
 */
@Entity
@Table(name = "transaksijualobat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaksijualobat.findAll", query = "SELECT t FROM Transaksijualobat t"),
    @NamedQuery(name = "Transaksijualobat.findByIdTransaksijual", query = "SELECT t FROM Transaksijualobat t WHERE t.idTransaksijual = :idTransaksijual"),
    @NamedQuery(name = "Transaksijualobat.findByDateTransaksijual", query = "SELECT t FROM Transaksijualobat t WHERE t.dateTransaksijual = :dateTransaksijual"),
    @NamedQuery(name = "Transaksijualobat.findByKeterangan", query = "SELECT t FROM Transaksijualobat t WHERE t.keterangan = :keterangan")})
public class Transaksijualobat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_transaksijual")
    private String idTransaksijual;
    @Column(name = "date_transaksijual")
    @Temporal(TemporalType.DATE)
    private String dateTransaksijual;
    @Column(name = "keterangan")
    private String keterangan;
    @OneToMany(mappedBy = "transaksijualobatIdTransaksijual")
    private String kunjunganCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transaksijualobat")
    private String detailtransaksijualobatCollection;

    public Transaksijualobat() {
    }

    public Transaksijualobat(String idTransaksijual) {
        this.idTransaksijual = idTransaksijual;
    }

    public String getIdTransaksijual() {
        return idTransaksijual;
    }

    public void setIdTransaksijual(String idTransaksijual) {
        this.idTransaksijual = idTransaksijual;
    }

    public String getDateTransaksijual() {
        return dateTransaksijual;
    }

    public void setDateTransaksijual(String dateTransaksijual) {
        this.dateTransaksijual = dateTransaksijual;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @XmlTransient
    public String getKunjunganCollection() {
        return kunjunganCollection;
    }

    public void setKunjunganCollection(String kunjunganCollection) {
        this.kunjunganCollection = kunjunganCollection;
    }

    @XmlTransient
    public String getDetailtransaksijualobatCollection() {
        return detailtransaksijualobatCollection;
    }

    public void setDetailtransaksijualobatCollection(String detailtransaksijualobatCollection) {
        this.detailtransaksijualobatCollection = detailtransaksijualobatCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransaksijual != null ? idTransaksijual.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaksijualobat)) {
            return false;
        }
        Transaksijualobat other = (Transaksijualobat) object;
        if ((this.idTransaksijual == null && other.idTransaksijual != null) || (this.idTransaksijual != null && !this.idTransaksijual.equals(other.idTransaksijual))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Transaksijualobat[ idTransaksijual=" + idTransaksijual + " ]";
    }
    
}
