/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carismainterface.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author K-MiL Caster
 */
@Embeddable
public class DetailtransaksibeliobatPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "transaksibeliobat_id_transaksibeliobat")
    private String transaksibeliobatIdTransaksibeliobat;
    @Basic(optional = false)
    @Column(name = "obat_id_obat")
    private int obatIdObat;

    public DetailtransaksibeliobatPK() {
    }

    public DetailtransaksibeliobatPK(String transaksibeliobatIdTransaksibeliobat, int obatIdObat) {
        this.transaksibeliobatIdTransaksibeliobat = transaksibeliobatIdTransaksibeliobat;
        this.obatIdObat = obatIdObat;
    }

    public String getTransaksibeliobatIdTransaksibeliobat() {
        return transaksibeliobatIdTransaksibeliobat;
    }

    public void setTransaksibeliobatIdTransaksibeliobat(String transaksibeliobatIdTransaksibeliobat) {
        this.transaksibeliobatIdTransaksibeliobat = transaksibeliobatIdTransaksibeliobat;
    }

    public int getObatIdObat() {
        return obatIdObat;
    }

    public void setObatIdObat(int obatIdObat) {
        this.obatIdObat = obatIdObat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transaksibeliobatIdTransaksibeliobat != null ? transaksibeliobatIdTransaksibeliobat.hashCode() : 0);
        hash += (int) obatIdObat;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailtransaksibeliobatPK)) {
            return false;
        }
        DetailtransaksibeliobatPK other = (DetailtransaksibeliobatPK) object;
        if ((this.transaksibeliobatIdTransaksibeliobat == null && other.transaksibeliobatIdTransaksibeliobat != null) || (this.transaksibeliobatIdTransaksibeliobat != null && !this.transaksibeliobatIdTransaksibeliobat.equals(other.transaksibeliobatIdTransaksibeliobat))) {
            return false;
        }
        if (this.obatIdObat != other.obatIdObat) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.DetailtransaksibeliobatPK[ transaksibeliobatIdTransaksibeliobat=" + transaksibeliobatIdTransaksibeliobat + ", obatIdObat=" + obatIdObat + " ]";
    }
    
}
