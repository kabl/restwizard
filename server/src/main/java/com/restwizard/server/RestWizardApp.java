package com.restwizard.server;

import com.restwizard.config.ConfigFileReader;
import com.restwizard.config.RestWizardConfig;

import javax.ws.rs.core.Application;
import java.io.IOException;
import java.util.Set;

public abstract class RestWizardApp<T extends RestWizardConfig> {

    private final ResteasyWeldUndertowServer server;
    private final T config;

    public RestWizardApp(String configFile) throws IOException {
        this(new ConfigFileReader<T>().readConfig(configFile));
    }

    public RestWizardApp(T config){
        this.config = config;
        this.server = new ResteasyWeldUndertowServer(config.getServer().getHttpConnector());
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
