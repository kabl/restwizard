package com.restwizard.server;

import javax.ws.rs.core.Application;
import java.util.Set;

public abstract class HelloWorldApp {

    private final ResteasyWeldUndertowServer server;

    public HelloWorldApp(){
        System.out.println("constructore");
        server = new ResteasyWeldUndertowServer();
    }


    public abstract Set<Class<?>> getResources();

    public void start(){
        server.start();
        server.deploy(new Application(){
            @Override
            public Set<Class<?>> getClasses() {
                return getResources();
            }
        });
    }

    public void stop() {
        server.stop();
    }
}
