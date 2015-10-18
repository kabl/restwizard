package com.restwizard.demo.resources;

import com.restwizard.demo.dto.DemoDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/demo3")
@Produces("application/json")
public class Demo3Resource {

    @GET
//    Produces("application/json")
    public DemoDto sayHello() {
        DemoDto demo = new DemoDto("demo1");
        return demo;
    }
}
