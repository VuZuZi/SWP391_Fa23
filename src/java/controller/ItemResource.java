/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericItemResource.java to edit this template
 */
package controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author dinhv
 */
public class ItemResource {

    private String name;

    /**
     * Creates a new instance of ItemResource
     */
    private ItemResource(String name) {
        this.name = name;
    }

    /**
     * Get instance of the ItemResource
     */
    public static ItemResource getInstance(String name) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of ItemResource class.
        return new ItemResource(name);
    }

    /**
     * Retrieves representation of an instance of controller.ItemResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ItemResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }

    /**
     * DELETE method for resource ItemResource
     */
    @DELETE
    public void delete() {
    }
}