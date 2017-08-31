package co.edu.events.rest.services;

import co.edu.events.jpa.entities.Event;
import co.edu.events.jpa.sessions.EventFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author luisOlave
 */
@Path("events")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EventRest {
    
       
    @EJB
    private EventFacade eventEJB;
    
    @GET
    public List<Event> findAll(){
    
    return eventEJB.findAll();   
    }
    
    @GET
    @Path("{id}")
    public Event findById(@PathParam("id") Integer id){
         
        return eventEJB.find(id);
     
    }
     
    @POST
    public void create(Event event){
        eventEJB.create(event);
    }
    
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") String id, Event event){
        eventEJB.edit(event);
    }
}