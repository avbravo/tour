/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.tour;

import com.avbravo.storeejb.entity.Pais;
import com.avbravo.storeejb.repository.PaisRepository;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.bson.Document;

/**
 *
 * @author avbravo
 */
@Stateless
@Path("pais")
public class PaisResources {
    @Inject
    PaisRepository paisRepository;
    @GET
    @Path("{idpais}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Pais find(@PathParam("idpais") String idpais){
        Pais pais = new Pais();
        try {
//            List<Pais> l = paisRepository.findBy(new Document("idpais",idpais));
//            if(!l.isEmpty()){
//             pais =l.get(0);
//            }
pais.setIdpais(idpais);
                        Optional<Pais> optional=paisRepository.findById(pais);
           if(optional.isPresent()){
               pais = optional.get();
           }
            
        } catch (Exception e) {
            System.out.println("Error find() "+e.getLocalizedMessage());
        }
        return pais;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Pais> findAll(){        
        return paisRepository.findAll();
    }
}
