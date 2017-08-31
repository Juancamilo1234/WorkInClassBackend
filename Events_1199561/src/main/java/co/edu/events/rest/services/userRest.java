/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.events.rest.services;

import co.edu.events.jpa.entities.User;
import co.edu.events.jpa.sessions.UserFacade;
import co.edu.events.rest.auth.DigestUtil;
import co.edu.events.rest.utils.SendEmail;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import javax.ws.rs.core.Response;

@Path("usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class userRest {

    @EJB
    private UserFacade usuarioEJB;

    /**
     * Obtiene todos los usuarioes
     *
     * @return lista de usuarios
     */
    @GET
    public List<User> findAll() {
        return usuarioEJB.findAll();
    }

    /**
     * Busca usuario por su id
     *
     * @param id
     * @return usuario
     */
    @GET
    @Path("{id}")
    public User findById(@PathParam("id") Integer id) {
        return usuarioEJB.find(id);
    }

    /**
     * Crear un usuario
     *
     * @param usuario
     * @return 
     */
    @POST
    public Response create(User usuario) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {

            if (usuarioEJB.findByEmail(usuario.getEmail()) == null) {
                if (usuarioEJB.findByNumDocument(usuario
                        .getNumDocument()) == null) {
                    
                    usuario.setPassword(
                            DigestUtil
                            .cifrarPassword(usuario.getPassword()));
                   
                    usuarioEJB.create(usuario);
                    
                    //START ENVIO EMAIL
                    SendEmail enviarEmail = new SendEmail();
                    enviarEmail.sendEmailRegistroUsuario(
                            usuario,"password");
                   
                    //END ENVIO EMAIL
                    
                    return Response.status(Response.Status.CREATED)
                            .entity(gson.toJson("El usuario se registró correctamente"))
                            .build();
                } else {
                    return Response.status(Response.Status.BAD_REQUEST)
                            .entity(gson.toJson("El Número de documento ya éxiste!."))
                            .build();
                }

            } else {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(gson.toJson("El email ya éxiste!."))
                        .build();
            }

        } catch (Exception e) {
            System.out.println("Err: " + e);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(gson.toJson("Error al registrar el usuario!."))
                    .build();
        }

    }

    /**
     * Edita un usuario
     *
     * @param id
     * @param usuario
     */
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, User usuario) {
        usuarioEJB.edit(usuario);
    }
}