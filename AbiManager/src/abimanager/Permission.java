/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abimanager;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Piotr.Piróg
 */
@Entity
@Table(name = "permission", catalog = "abimanager", schema = "")
@NamedQueries({
    @NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p")
    , @NamedQuery(name = "Permission.findByIdPermission", query = "SELECT p FROM Permission p WHERE p.idPermission = :idPermission")
    , @NamedQuery(name = "Permission.findByIdApplication", query = "SELECT p FROM Permission p WHERE p.idApplication = :idApplication")
    , @NamedQuery(name = "Permission.findByIdUser", query = "SELECT p FROM Permission p WHERE p.idUser = :idUser")
    , @NamedQuery(name = "Permission.findByStartDate", query = "SELECT p FROM Permission p WHERE p.startDate = :startDate")
    , @NamedQuery(name = "Permission.findByEndDate", query = "SELECT p FROM Permission p WHERE p.endDate = :endDate")
    , @NamedQuery(name = "Permission.findByCanSee", query = "SELECT p FROM Permission p WHERE p.canSee = :canSee")
    , @NamedQuery(name = "Permission.findByCanAdd", query = "SELECT p FROM Permission p WHERE p.canAdd = :canAdd")
    , @NamedQuery(name = "Permission.findByCanArchive", query = "SELECT p FROM Permission p WHERE p.canArchive = :canArchive")
    , @NamedQuery(name = "Permission.findByCanModify", query = "SELECT p FROM Permission p WHERE p.canModify = :canModify")
    , @NamedQuery(name = "Permission.findByCanRemove", query = "SELECT p FROM Permission p WHERE p.canRemove = :canRemove")})
public class Permission implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPermission")
    private Integer idPermission;
    @Column(name = "idApplication")
    private Integer idApplication;
    @Column(name = "idUser")
    private Integer idUser;
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "CanSee")
    private Boolean canSee;
    @Column(name = "CanAdd")
    private Boolean canAdd;
    @Column(name = "CanArchive")
    private Boolean canArchive;
    @Column(name = "CanModify")
    private Boolean canModify;
    @Column(name = "CanRemove")
    private Boolean canRemove;
    @JoinColumn(name = "idApplication", referencedColumnName = "idApplication", updatable = false, insertable = false)
    @ManyToOne
    private Application idapplication;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser", updatable = false, insertable = false)
    @ManyToOne
    private User iduser;

    public Permission() {
    }

    public Permission(Integer idPermission) {
        this.idPermission = idPermission;
    }

    public Integer getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(Integer idPermission) {
        Integer oldIdPermission = this.idPermission;
        this.idPermission = idPermission;
        changeSupport.firePropertyChange("idPermission", oldIdPermission, idPermission);
    }

    public Integer getIdApplication() {
        return idApplication;
    }

    public void setIdApplication(Integer idApplication) {
        Integer oldIdApplication = this.idApplication;
        this.idApplication = idApplication;
        changeSupport.firePropertyChange("idApplication", oldIdApplication, idApplication);
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        Integer oldIdUser = this.idUser;
        this.idUser = idUser;
        changeSupport.firePropertyChange("idUser", oldIdUser, idUser);
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        Date oldStartDate = this.startDate;
        this.startDate = startDate;
        changeSupport.firePropertyChange("startDate", oldStartDate, startDate);
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        Date oldEndDate = this.endDate;
        this.endDate = endDate;
        changeSupport.firePropertyChange("endDate", oldEndDate, endDate);
    }

    public Boolean getCanSee() {
        return canSee;
    }

    public void setCanSee(Boolean canSee) {
        Boolean oldCanSee = this.canSee;
        this.canSee = canSee;
        changeSupport.firePropertyChange("canSee", oldCanSee, canSee);
    }

    public Boolean getCanAdd() {
        return canAdd;
    }

    public void setCanAdd(Boolean canAdd) {
        Boolean oldCanAdd = this.canAdd;
        this.canAdd = canAdd;
        changeSupport.firePropertyChange("canAdd", oldCanAdd, canAdd);
    }

    public Boolean getCanArchive() {
        return canArchive;
    }

    public void setCanArchive(Boolean canArchive) {
        Boolean oldCanArchive = this.canArchive;
        this.canArchive = canArchive;
        changeSupport.firePropertyChange("canArchive", oldCanArchive, canArchive);
    }

    public Boolean getCanModify() {
        return canModify;
    }

    public void setCanModify(Boolean canModify) {
        Boolean oldCanModify = this.canModify;
        this.canModify = canModify;
        changeSupport.firePropertyChange("canModify", oldCanModify, canModify);
    }

    public Boolean getCanRemove() {
        return canRemove;
    }

    public void setCanRemove(Boolean canRemove) {
        Boolean oldCanRemove = this.canRemove;
        this.canRemove = canRemove;
        changeSupport.firePropertyChange("canRemove", oldCanRemove, canRemove);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermission != null ? idPermission.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permission)) {
            return false;
        }
        Permission other = (Permission) object;
        if ((this.idPermission == null && other.idPermission != null) || (this.idPermission != null && !this.idPermission.equals(other.idPermission))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "abimanager.Permission[ idPermission=" + idPermission + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public Application getIdapplication() {
        return idapplication;
    }

    public void setIdapplication(Application idapplication) {
        Application oldIdapplication = this.idapplication;
        this.idapplication = idapplication;
        changeSupport.firePropertyChange("idapplication", oldIdapplication, idapplication);
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        User oldIduser = this.iduser;
        this.iduser = iduser;
        changeSupport.firePropertyChange("iduser", oldIduser, iduser);
    }
    
}
