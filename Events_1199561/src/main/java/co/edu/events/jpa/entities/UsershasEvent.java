/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.events.jpa.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "Users _has_Events")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsershasEvent.findAll", query = "SELECT u FROM UsershasEvent u")
    , @NamedQuery(name = "UsershasEvent.findByAsistEvent", query = "SELECT u FROM UsershasEvent u WHERE u.asistEvent = :asistEvent")
    , @NamedQuery(name = "UsershasEvent.findByIdEvents", query = "SELECT u FROM UsershasEvent u WHERE u.usershasEventPK.idEvents = :idEvents")
    , @NamedQuery(name = "UsershasEvent.findByIdUsers", query = "SELECT u FROM UsershasEvent u WHERE u.usershasEventPK.idUsers = :idUsers")})
public class UsershasEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsershasEventPK usershasEventPK;
    @Column(name = "asist_event")
    private Boolean asistEvent;
    @JoinColumn(name = "id_Events", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Event event;
    @JoinColumn(name = "id_Users", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public UsershasEvent() {
    }

    public UsershasEvent(UsershasEventPK usershasEventPK) {
        this.usershasEventPK = usershasEventPK;
    }

    public UsershasEvent(int idEvents, int idUsers) {
        this.usershasEventPK = new UsershasEventPK(idEvents, idUsers);
    }

    public UsershasEventPK getUsershasEventPK() {
        return usershasEventPK;
    }

    public void setUsershasEventPK(UsershasEventPK usershasEventPK) {
        this.usershasEventPK = usershasEventPK;
    }

    public Boolean getAsistEvent() {
        return asistEvent;
    }

    public void setAsistEvent(Boolean asistEvent) {
        this.asistEvent = asistEvent;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
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
        hash += (usershasEventPK != null ? usershasEventPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsershasEvent)) {
            return false;
        }
        UsershasEvent other = (UsershasEvent) object;
        if ((this.usershasEventPK == null && other.usershasEventPK != null) || (this.usershasEventPK != null && !this.usershasEventPK.equals(other.usershasEventPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.events.jpa.entities.UsershasEvent[ usershasEventPK=" + usershasEventPK + " ]";
    }
    
}
