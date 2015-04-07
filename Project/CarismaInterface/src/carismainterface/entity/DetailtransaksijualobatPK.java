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
public class DetailtransaksijualobatPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "transaksijualobat_id_transaksijual")
    private String transaksijualobatIdTransaksijual;
    @Basic(optional = false)
    @Column(name = "obat_id_obat")
    private int obatIdObat;

    public DetailtransaksijualobatPK() {
    }

    public DetailtransaksijualobatPK(String transaksijualobatIdTransaksijual, int obatIdObat) {
        this.transaksijualobatIdTransaksijual = transaksijualobatIdTransaksijual;
        this.obatIdObat = obatIdObat;
    }

    public String getTransaksijualobatIdTransaksijual() {
        return transaksijualobatIdTransaksijual;
    }

    public void setTransaksijualobatIdTransaksijual(String transaksijualobatIdTransaksijual) {
        this.transaksijualobatIdTransaksijual = transaksijualobatIdTransaksijual;
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
        hash += (transaksijualobatIdTransaksijual != null ? transaksijualobatIdTransaksijual.hashCode() : 0);
        hash += (int) obatIdObat;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailtransaksijualobatPK)) {
            return false;
        }
        DetailtransaksijualobatPK other = (DetailtransaksijualobatPK) object;
        if ((this.transaksijualobatIdTransaksijual == null && other.transaksijualobatIdTransaksijual != null) || (this.transaksijualobatIdTransaksijual != null && !this.transaksijualobatIdTransaksijual.equals(other.transaksijualobatIdTransaksijual))) {
            return false;
        }
        if (this.obatIdObat != other.obatIdObat) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.DetailtransaksijualobatPK[ transaksijualobatIdTransaksijual=" + transaksijualobatIdTransaksijual + ", obatIdObat=" + obatIdObat + " ]";
    }
    
}
