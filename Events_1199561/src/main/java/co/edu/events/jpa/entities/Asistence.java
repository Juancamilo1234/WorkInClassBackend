/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.events.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "asistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistence.findAll", query = "SELECT a FROM Asistence a")
    , @NamedQuery(name = "Asistence.findByAsistEvent", query = "SELECT a FROM Asistence a WHERE a.asistEvent = :asistEvent")
    , @NamedQuery(name = "Asistence.findById", query = "SELECT a FROM Asistence a WHERE a.id = :id")})
public class Asistence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asist_event")
    private boolean asistEvent;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_Events", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Event idEvents;
    @JoinColumn(name = "id_Users", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User idUsers;

    public Asistence() {
    }

    public Asistence(Integer id) {
        this.id = id;
    }

    public Asistence(Integer id, boolean asistEvent) {
        this.id = id;
        this.asistEvent = asistEvent;
    }

    public boolean getAsistEvent() {
        return asistEvent;
    }

    public void setAsistEvent(boolean asistEvent) {
        this.asistEvent = asistEvent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Event getIdEvents() {
        return idEvents;
    }

    public void setIdEvents(Event idEvents) {
        this.idEvents = idEvents;
    }

    public User getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(User idUsers) {
        this.idUsers = idUsers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistence)) {
            return false;
        }
        Asistence other = (Asistence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.events.jpa.entities.Asistence[ id=" + id + " ]";
    }
    
}
