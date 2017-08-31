package co.edu.events.rest.services;

import co.consulta.de.procesos.jpa.entities.Evento;
import co.consulta.de.procesos.jpa.sessions.EventoFacade;
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
@Path("eventos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EventoRest {
    
       
    @EJB
    private EventoFacade eventoEJB;
    
    @GET
    public List<Evento> findAll(){
    
    return eventoEJB.findAll();   
    }
    
    @GET
    @Path("{id}")
    public Evento findById(@PathParam("id") Integer id){
         
        return id.find(id);
     
    }
     
    @POST
    public void create(Evento evento){
        eventoEJB.create(evento);
    }
    
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") String id, Evento evento){
        eventoEJB.edit(equipment);
    }
}