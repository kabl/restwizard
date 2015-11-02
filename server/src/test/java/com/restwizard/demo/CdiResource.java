package com.restwizard.demo;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/cdi-resource")
public class CdiResource {

    @Inject
    private String helloMessage;

    @GET
    @javax.ws.rs.Produces("text/plain")
    public String getCall() {
        return "inject: " + helloMessage;
    }

    @Produces
    private static String produceHelloMessage() {
        return "Hello World";
    }
}
