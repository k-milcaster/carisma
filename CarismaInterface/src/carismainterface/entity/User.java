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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByIdUser", query = "SELECT u FROM User u WHERE u.idUser = :idUser"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByRegistered", query = "SELECT u FROM User u WHERE u.registered = :registered"),
    @NamedQuery(name = "User.findByLastlogin", query = "SELECT u FROM User u WHERE u.lastlogin = :lastlogin"),
    @NamedQuery(name = "User.findByRole", query = "SELECT u FROM User u WHERE u.role = :role")})
public class User implements Serializable {
    @Basic(optional = false)
    @Column(name = "registered")
    @Temporal(TemporalType.TIMESTAMP)
    private String registered;
    @Basic(optional = false)
    @Column(name = "lastlogin")
    @Temporal(TemporalType.TIMESTAMP)
    private String lastlogin;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userIdUser")
    private Pegawai pegawai;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userIdUser")
    private Pasien pasien;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userIdUser")
    private Dokter dokter;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user")
    private Integer idUser;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "role")
    private String role;
    @OneToMany(mappedBy = "userIdUser")
    private Collection<Pegawai> pegawaiCollection;
    @OneToMany(mappedBy = "userIdUser")
    private Collection<Pasien> pasienCollection;
    @OneToMany(mappedBy = "userIdUser")
    private Collection<Dokter> dokterCollection;

    public User() {

    }
    
    public User(User user) {
        System.out.println(user.username);
        this.idUser = user.idUser;
        this.username = user.username;
        this.password = user.password;
        this.registered = user.registered;
        this.lastlogin = user.lastlogin;
        this.role = user.role;
    }    

    public User(Integer idUser) {
        this.idUser = idUser;
    }

    public User(Integer idUser, String username, String password, String registered, String lastlogin, String role) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.registered = registered;
        this.lastlogin = lastlogin;
        this.role = role;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient
    public Collection<Pegawai> getPegawaiCollection() {
        return pegawaiCollection;
    }

    public void setPegawaiCollection(Collection<Pegawai> pegawaiCollection) {
        this.pegawaiCollection = pegawaiCollection;
    }

    @XmlTransient
    public Collection<Pasien> getPasienCollection() {
        return pasienCollection;
    }

    public void setPasienCollection(Collection<Pasien> pasienCollection) {
        this.pasienCollection = pasienCollection;
    }

    @XmlTransient
    public Collection<Dokter> getDokterCollection() {
        return dokterCollection;
    }

    public void setDokterCollection(Collection<Dokter> dokterCollection) {
        this.dokterCollection = dokterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carismainterface.entity.User[ idUser=" + idUser + " ]";
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(String lastlogin) {
        this.lastlogin = lastlogin;
    }

    public Pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }
    
}
