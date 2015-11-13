package com.restwizard.demo.resources;

//import javax.enterprise.inject.Produces;
//import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/demo2")
public class Demo2Resource {

    //    @Inject
    private String helloMessage = "Hello World my app";

    @GET
    @javax.ws.rs.Produces("text/plain")
    public String sayHello() {
        return "cdi test: " + helloMessage;
    }

    //    @Produces
    private static String produceHelloMessage() {
        return "Hello World my app";
    }

}
