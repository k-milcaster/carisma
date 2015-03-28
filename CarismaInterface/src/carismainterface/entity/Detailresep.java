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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author K-MiL Caster
 */
@Entity
@Table(name = "detailresep")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detailresep.findAll", query = "SELECT d FROM Detailresep d"),
    @NamedQuery(name = "Detailresep.findByIdDetailresep", query = "SELECT d FROM Detailresep d WHERE d.idDetailresep = :idDetailresep"),
    @NamedQuery(name = "Detailresep.findByNamaobatResep", query = "SELECT d FROM Detailresep d WHERE d.namaobatResep = :namaobatResep"),
    @NamedQuery(name = "Detailresep.findByQtyResep", query = "SELECT d FROM Detailresep d WHERE d.qtyResep = :qtyResep"),
    @NamedQuery(name = "Detailresep.findByAturanpakaiResep", query = "SELECT d FROM Detailresep d WHERE d.aturanpakaiResep = :aturanpakaiResep")})
public class Detailresep implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_detailresep")
    private String idDetailresep;
    @Column(name = "resep_id_resep")
    private String resepIdResep;
    @Column(name = "namaobat_resep")
    private String namaobatResep;
    @Column(name = "qty_resep")
    private Integer qtyResep;
    @Column(name = "aturanpakai_resep")
    private String aturanpakaiResep;

    public Detailresep() {
    }

    public Detailresep(String idDetailresep) {
        this.idDetailresep = idDetailresep;
    }

    public String getIdDetailresep() {
        return idDetailresep;
    }

    public void setIdDetailresep(String idDetailresep) {
        this.idDetailresep = idDetailresep;
    }

    public String getResepIdResep() {
        return resepIdResep;
    }

    public void setResepIdResep(String resepIdResep) {
        this.resepIdResep = resepIdResep;
    }

    public String getNamaobatResep() {
        return namaobatResep;
    }

    public void setNamaobatResep(String namaobatResep) {
        this.namaobatResep = namaobatResep;
    }

    public Integer getQtyResep() {
        return qtyResep;
    }

    public void setQtyResep(Integer qtyResep) {
        this.qtyResep = qtyResep;
    }

    public String getAturanpakaiResep() {
        return aturanpakaiResep;
    }

    public void setAturanpakaiResep(String aturanpakaiResep) {
        this.aturanpakaiResep = aturanpakaiResep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetailresep != null ? idDetailresep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detailresep)) {
            return false;
        }
        Detailresep other = (Detailresep) object;
        if ((this.idDetailresep == null && other.idDetailresep != null) || (this.idDetailresep != null && !this.idDetailresep.equals(other.idDetailresep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.Detailresep[ idDetailresep=" + idDetailresep + " ]";
    }

}
