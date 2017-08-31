/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.events.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "Events")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e")
    , @NamedQuery(name = "Event.findById", query = "SELECT e FROM Event e WHERE e.id = :id")
    , @NamedQuery(name = "Event.findByTypeEvent", query = "SELECT e FROM Event e WHERE e.typeEvent = :typeEvent")
    , @NamedQuery(name = "Event.findByDateStartEvent", query = "SELECT e FROM Event e WHERE e.dateStartEvent = :dateStartEvent")
    , @NamedQuery(name = "Event.findByDateEndEvent", query = "SELECT e FROM Event e WHERE e.dateEndEvent = :dateEndEvent")})
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "type_event")
    private String typeEvent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_start_event")
    @Temporal(TemporalType.DATE)
    private Date dateStartEvent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_end_event")
    @Temporal(TemporalType.DATE)
    private Date dateEndEvent;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvents")
    private List<Asistence> asistenceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private List<UsershasEvent> usershasEventList;

    public Event() {
    }

    public Event(Integer id) {
        this.id = id;
    }

    public Event(Integer id, String typeEvent, Date dateStartEvent, Date dateEndEvent) {
        this.id = id;
        this.typeEvent = typeEvent;
        this.dateStartEvent = dateStartEvent;
        this.dateEndEvent = dateEndEvent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(String typeEvent) {
        this.typeEvent = typeEvent;
    }

    public Date getDateStartEvent() {
        return dateStartEvent;
    }

    public void setDateStartEvent(Date dateStartEvent) {
        this.dateStartEvent = dateStartEvent;
    }

    public Date getDateEndEvent() {
        return dateEndEvent;
    }

    public void setDateEndEvent(Date dateEndEvent) {
        this.dateEndEvent = dateEndEvent;
    }

    @XmlTransient
    public List<Asistence> getAsistenceList() {
        return asistenceList;
    }

    public void setAsistenceList(List<Asistence> asistenceList) {
        this.asistenceList = asistenceList;
    }

    @XmlTransient
    public List<UsershasEvent> getUsershasEventList() {
        return usershasEventList;
    }

    public void setUsershasEventList(List<UsershasEvent> usershasEventList) {
        this.usershasEventList = usershasEventList;
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
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.events.jpa.entities.Event[ id=" + id + " ]";
    }
    
}
