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
@Table(name = "set", catalog = "abimanager", schema = "")
@NamedQueries({
    @NamedQuery(name = "Set1.findAll", query = "SELECT s FROM Set1 s")
    , @NamedQuery(name = "Set1.findByIdSet", query = "SELECT s FROM Set1 s WHERE s.idSet = :idSet")
    , @NamedQuery(name = "Set1.findBySetName", query = "SELECT s FROM Set1 s WHERE s.setName = :setName")
    , @NamedQuery(name = "Set1.findBySetDescription", query = "SELECT s FROM Set1 s WHERE s.setDescription = :setDescription")})
public class Set1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idSet")
    private Integer idSet;
    @Column(name = "SetName")
    private String setName;
    @Column(name = "SetDescription")
    private String setDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idset")
    private Collection<Application> applicationCollection;

    public Set1() {
    }

    public Set1(Integer idSet) {
        this.idSet = idSet;
    }

    public Integer getIdSet() {
        return idSet;
    }

    public void setIdSet(Integer idSet) {
        Integer oldIdSet = this.idSet;
        this.idSet = idSet;
        changeSupport.firePropertyChange("idSet", oldIdSet, idSet);
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        String oldSetName = this.setName;
        this.setName = setName;
        changeSupport.firePropertyChange("setName", oldSetName, setName);
    }

    public String getSetDescription() {
        return setDescription;
    }

    public void setSetDescription(String setDescription) {
        String oldSetDescription = this.setDescription;
        this.setDescription = setDescription;
        changeSupport.firePropertyChange("setDescription", oldSetDescription, setDescription);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSet != null ? idSet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Set1)) {
            return false;
        }
        Set1 other = (Set1) object;
        if ((this.idSet == null && other.idSet != null) || (this.idSet != null && !this.idSet.equals(other.idSet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "abimanager.Set1[ idSet=" + idSet + " ]";
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
    
}
