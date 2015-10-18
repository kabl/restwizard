package com.restwizard.server;

import javax.ws.rs.core.Application;
import java.util.Set;

public abstract class RestWizardApp {

    private final ResteasyWeldUndertowServer server;

    public RestWizardApp(int httpPort){
        server = new ResteasyWeldUndertowServer(httpPort);
    }

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

    public abstract Set<Class<?>> getResources();
}
