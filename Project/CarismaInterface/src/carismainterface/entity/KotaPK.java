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
public class KotaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_kota")
    private String idKota;
    @Basic(optional = false)
    @Column(name = "provinsi_id_provinsi")
    private String provinsiIdProvinsi;

    public KotaPK() {
    }

    public KotaPK(String idKota, String provinsiIdProvinsi) {
        this.idKota = idKota;
        this.provinsiIdProvinsi = provinsiIdProvinsi;
    }

    public String getIdKota() {
        return idKota;
    }

    public void setIdKota(String idKota) {
        this.idKota = idKota;
    }

    public String getProvinsiIdProvinsi() {
        return provinsiIdProvinsi;
    }

    public void setProvinsiIdProvinsi(String provinsiIdProvinsi) {
        this.provinsiIdProvinsi = provinsiIdProvinsi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKota != null ? idKota.hashCode() : 0);
        hash += (provinsiIdProvinsi != null ? provinsiIdProvinsi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KotaPK)) {
            return false;
        }
        KotaPK other = (KotaPK) object;
        if ((this.idKota == null && other.idKota != null) || (this.idKota != null && !this.idKota.equals(other.idKota))) {
            return false;
        }
        if ((this.provinsiIdProvinsi == null && other.provinsiIdProvinsi != null) || (this.provinsiIdProvinsi != null && !this.provinsiIdProvinsi.equals(other.provinsiIdProvinsi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.KotaPK[ idKota=" + idKota + ", provinsiIdProvinsi=" + provinsiIdProvinsi + " ]";
    }
    
}
