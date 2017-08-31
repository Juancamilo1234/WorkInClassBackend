package co.edu.events.rest.services;

import co.consulta.de.procesos.jpa.entities.TypeDocument;
import co.consulta.de.procesos.jpa.sessions.TypeDocumentFacade;
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
@Path("tipos_documentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TypeDocumentRest {
    
       
    @EJB
    private TypeDocumentFacade typeDocumentEJB;
    
    @GET
    public List<TypeDocument> findAll(){
    
    return typeDocumentEJB.findAll();   
    }
    
    @GET
    @Path("{id}")
    public TypeDocument findById(@PathParam("id") Integer id){
         
        return typeDocumentEJB.find(id);
     
    }
     
    @POST
    public void create(TypeDocument typeDocument){
        typeDocumentEJB.create(typeDocument);
    }
    
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") String id, TypeDocument typeDocument){
        typeDocumentEJB.edit(typeDocument);
    }
}