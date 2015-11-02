package com.restwizard.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/dto-resource")
@javax.ws.rs.Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class SimpleDtoResource {

    @GET
    public SimpleDto getCall() {
        return new SimpleDto("Hello World");
    }

}