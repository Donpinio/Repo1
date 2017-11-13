/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abimanager;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Piotr.Piróg
 */
@Entity
@Table(name = "user", catalog = "abimanager", schema = "")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByIdUser", query = "SELECT u FROM User u WHERE u.idUser = :idUser")
    , @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName")
    , @NamedQuery(name = "User.findByUserPass", query = "SELECT u FROM User u WHERE u.userPass = :userPass")
    , @NamedQuery(name = "User.findByUserSurname", query = "SELECT u FROM User u WHERE u.userSurname = :userSurname")
    , @NamedQuery(name = "User.findByUserEmail", query = "SELECT u FROM User u WHERE u.userEmail = :userEmail")
    , @NamedQuery(name = "User.findByIdRole", query = "SELECT u FROM User u WHERE u.idRole = :idRole")})
public class User implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUser")
    private Integer idUser;
    @Column(name = "UserName")
    private String userName;
    @Column(name = "UserPass")
    private String userPass;
    @Column(name = "UserSurname")
    private String userSurname;
    @Column(name = "UserEmail")
    private String userEmail;
    @Lob
    @Column(name = "UserAddress")
    private String userAddress;
    @Column(name = "idRole")
    private Integer idRole;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idasi")
    private Collection<Application> applicationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private Collection<Permission> permissionCollection;

    public User() {
    }

    public User(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        Integer oldIdUser = this.idUser;
        this.idUser = idUser;
        changeSupport.firePropertyChange("idUser", oldIdUser, idUser);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        String oldUserName = this.userName;
        this.userName = userName;
        changeSupport.firePropertyChange("userName", oldUserName, userName);
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        String oldUserPass = this.userPass;
        this.userPass = userPass;
        changeSupport.firePropertyChange("userPass", oldUserPass, userPass);
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        String oldUserSurname = this.userSurname;
        this.userSurname = userSurname;
        changeSupport.firePropertyChange("userSurname", oldUserSurname, userSurname);
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        String oldUserEmail = this.userEmail;
        this.userEmail = userEmail;
        changeSupport.firePropertyChange("userEmail", oldUserEmail, userEmail);
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        String oldUserAddress = this.userAddress;
        this.userAddress = userAddress;
        changeSupport.firePropertyChange("userAddress", oldUserAddress, userAddress);
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        Integer oldIdRole = this.idRole;
        this.idRole = idRole;
        changeSupport.firePropertyChange("idRole", oldIdRole, idRole);
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
        return "abimanager.User[ idUser=" + idUser + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public Collection<Application> getApplicationCollection() {
        return applicationCollection;
    }

    public void setApplicationCollection(Collection<Application> applicationCollection) {
        this.applicationCollection = applicationCollection;
    }

    public Collection<Permission> getPermissionCollection() {
        return permissionCollection;
    }

    public void setPermissionCollection(Collection<Permission> permissionCollection) {
        this.permissionCollection = permissionCollection;
    }
    
}
