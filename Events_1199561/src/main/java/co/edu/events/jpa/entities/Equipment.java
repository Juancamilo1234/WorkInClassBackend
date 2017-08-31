/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.events.jpa.entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "equipment")
public class Equipment implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EquipmentPK equipmentPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "location")
    private int location;
    @JoinColumn(name = "id_Users", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Equipment() {
    }

    public Equipment(EquipmentPK equipmentPK) {
        this.equipmentPK = equipmentPK;
    }

    public Equipment(EquipmentPK equipmentPK, String description, int location) {
        this.equipmentPK = equipmentPK;
        this.description = description;
        this.location = location;
    }

    public Equipment(int id, int idUsers) {
        this.equipmentPK = new EquipmentPK(id, idUsers);
    }

    public EquipmentPK getEquipmentPK() {
        return equipmentPK;
    }

    public void setEquipmentPK(EquipmentPK equipmentPK) {
        this.equipmentPK = equipmentPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipmentPK != null ? equipmentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipment)) {
            return false;
        }
        Equipment other = (Equipment) object;
        if ((this.equipmentPK == null && other.equipmentPK != null) || (this.equipmentPK != null && !this.equipmentPK.equals(other.equipmentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.events.jpa.entities.Equipment[ equipmentPK=" + equipmentPK + " ]";
    }
    
}
