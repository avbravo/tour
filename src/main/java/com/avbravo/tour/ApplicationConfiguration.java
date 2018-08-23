/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.tour;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author avbravo
 */
@ApplicationPath("rest")
public class ApplicationConfiguration extends Application{
     @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(com.avbravo.tour.PaisResources.class);
        resources.add(com.avbravo.tour.HolaMundoResource.class);
        resources.add(com.avbravo.tour.TamanoResource.class);
        //addRestResourceClasses(resources);
        return resources;
    }
}
