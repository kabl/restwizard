package com.restwizard.demo.resources;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/demo2")
@javax.ws.rs.Produces({MediaType.TEXT_PLAIN})
public class Demo2Resource {

    @Inject
    private String helloMessage;

    @GET
    public String sayHello() {
        return "cdi test: " + helloMessage;
    }

    @Produces
    private static String produceHelloMessage() {
        return "Hello World my app";
    }

}
