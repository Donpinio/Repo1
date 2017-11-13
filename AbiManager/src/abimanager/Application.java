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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "application", catalog = "abimanager", schema = "")
@NamedQueries({
    @NamedQuery(name = "Application.findAll", query = "SELECT a FROM Application a")
    , @NamedQuery(name = "Application.findByIdApplication", query = "SELECT a FROM Application a WHERE a.idApplication = :idApplication")
    , @NamedQuery(name = "Application.findByAppName", query = "SELECT a FROM Application a WHERE a.appName = :appName")
    , @NamedQuery(name = "Application.findByAppDescription", query = "SELECT a FROM Application a WHERE a.appDescription = :appDescription")
    , @NamedQuery(name = "Application.findByIdSet", query = "SELECT a FROM Application a WHERE a.idSet = :idSet")
    , @NamedQuery(name = "Application.findByIdASI", query = "SELECT a FROM Application a WHERE a.idASI = :idASI")})
public class Application implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idApplication")
    private Integer idApplication;
    @Column(name = "AppName")
    private String appName;
    @Column(name = "AppDescription")
    private String appDescription;
    @Column(name = "idSet")
    private Integer idSet;
    @Column(name = "IdASI")
    private Integer idASI;
    @JoinColumn(name = "idSet", referencedColumnName = "idSet", updatable = false, insertable = false)
    @ManyToOne
    private Set1 idset;
    @JoinColumn(name = "IdASI", referencedColumnName = "idUser", updatable = false, insertable = false)
    @ManyToOne
    private User idasi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idapplication")
    private Collection<Permission> permissionCollection;

    public Application() {
    }

    public Application(Integer idApplication) {
        this.idApplication = idApplication;
    }

    public Integer getIdApplication() {
        return idApplication;
    }

    public void setIdApplication(Integer idApplication) {
        Integer oldIdApplication = this.idApplication;
        this.idApplication = idApplication;
        changeSupport.firePropertyChange("idApplication", oldIdApplication, idApplication);
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        String oldAppName = this.appName;
        this.appName = appName;
        changeSupport.firePropertyChange("appName", oldAppName, appName);
    }

    public String getAppDescription() {
        return appDescription;
    }

    public void setAppDescription(String appDescription) {
        String oldAppDescription = this.appDescription;
        this.appDescription = appDescription;
        changeSupport.firePropertyChange("appDescription", oldAppDescription, appDescription);
    }

    public Integer getIdSet() {
        return idSet;
    }

    public void setIdSet(Integer idSet) {
        Integer oldIdSet = this.idSet;
        this.idSet = idSet;
        changeSupport.firePropertyChange("idSet", oldIdSet, idSet);
    }

    public Integer getIdASI() {
        return idASI;
    }

    public void setIdASI(Integer idASI) {
        Integer oldIdASI = this.idASI;
        this.idASI = idASI;
        changeSupport.firePropertyChange("idASI", oldIdASI, idASI);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApplication != null ? idApplication.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Application)) {
            return false;
        }
        Application other = (Application) object;
        if ((this.idApplication == null && other.idApplication != null) || (this.idApplication != null && !this.idApplication.equals(other.idApplication))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "abimanager.Application[ idApplication=" + idApplication + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public Set1 getIdset() {
        return idset;
    }

    public void setIdset(Set1 idset) {
        Set1 oldIdset = this.idset;
        this.idset = idset;
        changeSupport.firePropertyChange("idset", oldIdset, idset);
    }

    public User getIdasi() {
        return idasi;
    }

    public void setIdasi(User idasi) {
        User oldIdasi = this.idasi;
        this.idasi = idasi;
        changeSupport.firePropertyChange("idasi", oldIdasi, idasi);
    }

    public Collection<Permission> getPermissionCollection() {
        return permissionCollection;
    }

    public void setPermissionCollection(Collection<Permission> permissionCollection) {
        this.permissionCollection = permissionCollection;
    }
    
}
