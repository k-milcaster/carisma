/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carismainterface.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "detailtransaksijualobat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detailtransaksijualobat.findAll", query = "SELECT d FROM Detailtransaksijualobat d"),
    @NamedQuery(name = "Detailtransaksijualobat.findByTransaksijualobatIdTransaksijual", query = "SELECT d FROM Detailtransaksijualobat d WHERE d.detailtransaksijualobatPK.transaksijualobatIdTransaksijual = :transaksijualobatIdTransaksijual"),
    @NamedQuery(name = "Detailtransaksijualobat.findByObatIdObat", query = "SELECT d FROM Detailtransaksijualobat d WHERE d.detailtransaksijualobatPK.obatIdObat = :obatIdObat"),
    @NamedQuery(name = "Detailtransaksijualobat.findByQty", query = "SELECT d FROM Detailtransaksijualobat d WHERE d.qty = :qty")})
public class Detailtransaksijualobat implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetailtransaksijualobatPK detailtransaksijualobatPK;
    @Basic(optional = false)
    @Column(name = "qty")
    private int qty;
    @JoinColumn(name = "transaksijualobat_id_transaksijual", referencedColumnName = "id_transaksijual", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private String transaksijualobat;
    @JoinColumn(name = "obat_id_obat", referencedColumnName = "id_obat", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Integer obat;

    public Detailtransaksijualobat() {
    }

    public Detailtransaksijualobat(DetailtransaksijualobatPK detailtransaksijualobatPK) {
        this.detailtransaksijualobatPK = detailtransaksijualobatPK;
    }

    public Detailtransaksijualobat(DetailtransaksijualobatPK detailtransaksijualobatPK, int qty) {
        this.detailtransaksijualobatPK = detailtransaksijualobatPK;
        this.qty = qty;
    }

    public Detailtransaksijualobat(String transaksijualobatIdTransaksijual, int obatIdObat) {
        this.detailtransaksijualobatPK = new DetailtransaksijualobatPK(transaksijualobatIdTransaksijual, obatIdObat);
    }

    public DetailtransaksijualobatPK getDetailtransaksijualobatPK() {
        return detailtransaksijualobatPK;
    }

    public void setDetailtransaksijualobatPK(DetailtransaksijualobatPK detailtransaksijualobatPK) {
        this.detailtransaksijualobatPK = detailtransaksijualobatPK;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getTransaksijualobat() {
        return transaksijualobat;
    }

    public void setTransaksijualobat(String transaksijualobat) {
        this.transaksijualobat = transaksijualobat;
    }

    public Integer getObat() {
        return obat;
    }

    public void setObat(Integer obat) {
        this.obat = obat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailtransaksijualobatPK != null ? detailtransaksijualobatPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detailtransaksijualobat)) {
            return false;
        }
        Detailtransaksijualobat other = (Detailtransaksijualobat) object;
        if ((this.detailtransaksijualobatPK == null && other.detailtransaksijualobatPK != null) || (this.detailtransaksijualobatPK != null && !this.detailtransaksijualobatPK.equals(other.detailtransaksijualobatPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Detailtransaksijualobat[ detailtransaksijualobatPK=" + detailtransaksijualobatPK + " ]";
    }
    
}
