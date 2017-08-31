/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.events.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author adsi1261718
 */
@Embeddable
public class UsershasEventPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Events")
    private int idEvents;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Users")
    private int idUsers;

    public UsershasEventPK() {
    }

    public UsershasEventPK(int idEvents, int idUsers) {
        this.idEvents = idEvents;
        this.idUsers = idUsers;
    }

    public int getIdEvents() {
        return idEvents;
    }

    public void setIdEvents(int idEvents) {
        this.idEvents = idEvents;
    }

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEvents;
        hash += (int) idUsers;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsershasEventPK)) {
            return false;
        }
        UsershasEventPK other = (UsershasEventPK) object;
        if (this.idEvents != other.idEvents) {
            return false;
        }
        if (this.idUsers != other.idUsers) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.events.jpa.entities.UsershasEventPK[ idEvents=" + idEvents + ", idUsers=" + idUsers + " ]";
    }
    
}
