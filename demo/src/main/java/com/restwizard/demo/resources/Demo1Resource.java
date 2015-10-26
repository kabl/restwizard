package com.restwizard.demo.resources;

import com.restwizard.demo.dto.DemoDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/demo1")
@javax.ws.rs.Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class Demo1Resource {

    @GET
    public DemoDto sayHello() {
        DemoDto demo = new DemoDto("demo1");
        return demo;
    }
}
