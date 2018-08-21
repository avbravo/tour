/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.tour;

import com.avbravo.storeejb.entity.Tamano;
import com.avbravo.storeejb.repository.TamanoRepository;
import java.net.URI;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author avbravo
 */
@Stateless
@Path("tamano")
public class TamanoResource {

    @Inject
    TamanoRepository tamanoRepository;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response tamano() {
        return Response.ok(tamanoRepository.findAll()).build();
    }

    @GET
    @Path("/{idtamano}")
    public Response get(@PathParam("idtamano") Integer idtamano) {
        Tamano tamano = new Tamano();
        tamano.setIdtamano(idtamano);
        Optional<Tamano> optional = tamanoRepository.findById(tamano);
        if (optional.isPresent()) {
            tamano = optional.get();
        }
        return Response.ok(tamano).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Tamano tamano) {
        Optional<Tamano> optional = tamanoRepository.findById(tamano);
        if (optional.isPresent()) {
            return Response.status(Response.Status.CONFLICT).build();
        }

        tamanoRepository.save(tamano);
        URI location = UriBuilder.fromResource(TamanoResource.class)
                .path("/{idtamano}")
                .resolveTemplate("idtamano", tamano.getIdtamano())
                .build();
        return Response.created(location).build();
    }

    
     @PUT
    @Path("/{idtamano}")
    public Response update(@PathParam("idtamano") Integer idatamano, Tamano tamano) {
        tamanoRepository.update(tamano);
        return Response.ok().build();
    }
    
    
     @DELETE
    @Path("/{idtamano}")
    public Response delete(@PathParam("idtamano") Integer idtamano) {
       tamanoRepository.delete("idtamano",idtamano);
        return Response.ok().build();
    }
    
}
