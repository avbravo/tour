/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.tour;

import static java.util.Collections.singletonMap;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author avbravo
 */
@Path("hola")
public class HolaMundoResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response holaMundo(){
        Map<String,String> response= singletonMap("message",
        "Hola Mundo");
        return Response.ok(response).build();
    }
    
}
