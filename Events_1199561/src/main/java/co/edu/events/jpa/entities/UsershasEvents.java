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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "Users _has_Events")

public class UsershasEvents implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsershasEventsPK usershasEventsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asist_event")
    private boolean asistEvent;
    @JoinColumn(name = "id_Events", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Eventos event;
    @JoinColumn(name = "id_Users", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public UsershasEvents() {
    }

    public UsershasEvents(UsershasEventsPK usershasEventsPK) {
        this.usershasEventsPK = usershasEventsPK;
    }

    public UsershasEvents(UsershasEventsPK usershasEventsPK, boolean asistEvent) {
        this.usershasEventsPK = usershasEventsPK;
        this.asistEvent = asistEvent;
    }

    public UsershasEvents(int idUsers, int idEvents) {
        this.usershasEventsPK = new UsershasEventsPK(idUsers, idEvents);
    }

    public UsershasEventsPK getUsershasEventsPK() {
        return usershasEventsPK;
    }

    public void setUsershasEventsPK(UsershasEventsPK usershasEventsPK) {
        this.usershasEventsPK = usershasEventsPK;
    }

    public boolean getAsistEvent() {
        return asistEvent;
    }

    public void setAsistEvent(boolean asistEvent) {
        this.asistEvent = asistEvent;
    }

    public Eventos getEvent() {
        return event;
    }

    public void setEvent(Eventos event) {
        this.event = event;
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
        hash += (usershasEventsPK != null ? usershasEventsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsershasEvents)) {
            return false;
        }
        UsershasEvents other = (UsershasEvents) object;
        if ((this.usershasEventsPK == null && other.usershasEventsPK != null) || (this.usershasEventsPK != null && !this.usershasEventsPK.equals(other.usershasEventsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.events.jpa.entities.UsershasEvents[ usershasEventsPK=" + usershasEventsPK + " ]";
    }
    
}
