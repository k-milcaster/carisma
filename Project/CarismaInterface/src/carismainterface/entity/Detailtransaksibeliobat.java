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
@Table(name = "detailtransaksibeliobat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detailtransaksibeliobat.findAll", query = "SELECT d FROM Detailtransaksibeliobat d"),
    @NamedQuery(name = "Detailtransaksibeliobat.findByTransaksibeliobatIdTransaksibeliobat", query = "SELECT d FROM Detailtransaksibeliobat d WHERE d.detailtransaksibeliobatPK.transaksibeliobatIdTransaksibeliobat = :transaksibeliobatIdTransaksibeliobat"),
    @NamedQuery(name = "Detailtransaksibeliobat.findByObatIdObat", query = "SELECT d FROM Detailtransaksibeliobat d WHERE d.detailtransaksibeliobatPK.obatIdObat = :obatIdObat"),
    @NamedQuery(name = "Detailtransaksibeliobat.findByQty", query = "SELECT d FROM Detailtransaksibeliobat d WHERE d.qty = :qty")})
public class Detailtransaksibeliobat implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetailtransaksibeliobatPK detailtransaksibeliobatPK;
    @Basic(optional = false)
    @Column(name = "qty")
    private int qty;
    @JoinColumn(name = "obat_id_obat", referencedColumnName = "id_obat", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Integer obat;
    @JoinColumn(name = "transaksibeliobat_id_transaksibeliobat", referencedColumnName = "id_transaksibeliobat", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private String transaksibeliobat;

    public Detailtransaksibeliobat() {
    }

    public Detailtransaksibeliobat(DetailtransaksibeliobatPK detailtransaksibeliobatPK) {
        this.detailtransaksibeliobatPK = detailtransaksibeliobatPK;
    }

    public Detailtransaksibeliobat(DetailtransaksibeliobatPK detailtransaksibeliobatPK, int qty) {
        this.detailtransaksibeliobatPK = detailtransaksibeliobatPK;
        this.qty = qty;
    }

    public Detailtransaksibeliobat(String transaksibeliobatIdTransaksibeliobat, int obatIdObat) {
        this.detailtransaksibeliobatPK = new DetailtransaksibeliobatPK(transaksibeliobatIdTransaksibeliobat, obatIdObat);
    }

    public DetailtransaksibeliobatPK getDetailtransaksibeliobatPK() {
        return detailtransaksibeliobatPK;
    }

    public void setDetailtransaksibeliobatPK(DetailtransaksibeliobatPK detailtransaksibeliobatPK) {
        this.detailtransaksibeliobatPK = detailtransaksibeliobatPK;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Integer getObat() {
        return obat;
    }

    public void setObat(Integer obat) {
        this.obat = obat;
    }

    public String getTransaksibeliobat() {
        return transaksibeliobat;
    }

    public void setTransaksibeliobat(String transaksibeliobat) {
        this.transaksibeliobat = transaksibeliobat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailtransaksibeliobatPK != null ? detailtransaksibeliobatPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detailtransaksibeliobat)) {
            return false;
        }
        Detailtransaksibeliobat other = (Detailtransaksibeliobat) object;
        if ((this.detailtransaksibeliobatPK == null && other.detailtransaksibeliobatPK != null) || (this.detailtransaksibeliobatPK != null && !this.detailtransaksibeliobatPK.equals(other.detailtransaksibeliobatPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Detailtransaksibeliobat[ detailtransaksibeliobatPK=" + detailtransaksibeliobatPK + " ]";
    }
    
}
