package co.edu.events.rest.services;


import co.edu.events.jpa.entities.Equipment;
import co.edu.events.jpa.sessions.EquipmentFacade;
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
@Path("equipment")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EquipmentRest {
    
       
    @EJB
    private EquipmentFacade equipmentEJB;
    
    @GET
    public List<Equipment> findAll(){
    
    return equipmentEJB.findAll();   
    }
    
    
    @GET
    @Path("{id}")
    public Equipment findById(@PathParam("id") Integer id){
         
        return equipmentEJB.find(id);
     
    }
     
    @POST
    public void create(Equipment equipment){
        equipmentEJB.create(equipment);
    }
    
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") String id, Equipment equipment){
        equipmentEJB.edit(equipment);
    }
}