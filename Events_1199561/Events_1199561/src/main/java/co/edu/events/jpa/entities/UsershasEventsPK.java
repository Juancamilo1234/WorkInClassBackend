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
public class UsershasEventsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Users")
    private int idUsers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Events")
    private int idEvents;

    public UsershasEventsPK() {
    }

    public UsershasEventsPK(int idUsers, int idEvents) {
        this.idUsers = idUsers;
        this.idEvents = idEvents;
    }

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public int getIdEvents() {
        return idEvents;
    }

    public void setIdEvents(int idEvents) {
        this.idEvents = idEvents;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsers;
        hash += (int) idEvents;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsershasEventsPK)) {
            return false;
        }
        UsershasEventsPK other = (UsershasEventsPK) object;
        if (this.idUsers != other.idUsers) {
            return false;
        }
        if (this.idEvents != other.idEvents) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.events.jpa.entities.UsershasEventsPK[ idUsers=" + idUsers + ", idEvents=" + idEvents + " ]";
    }
    
}
