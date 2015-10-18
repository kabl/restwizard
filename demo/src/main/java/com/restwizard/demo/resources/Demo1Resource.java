package com.restwizard.demo.resources;

import com.restwizard.demo.dto.DemoDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/demo1")
@Produces("application/xml")
public class Demo1Resource {

    @GET
//    Produces("application/json")
    public DemoDto sayHello() {
        DemoDto demo = new DemoDto("demo1");
        return demo;
    }
}
