package com.restwizard.server;

import com.restwizard.config.RestWizardConfig;
import com.restwizard.util.Generics;

import javax.ws.rs.core.Application;
import java.io.IOException;
import java.util.Set;

public abstract class RestWizardApp<T extends RestWizardConfig> {

    private final ResteasyWeldUndertowServer server;
    private final T config;

    public RestWizardApp(String configFile) throws IOException {
        this.config = new ConfigFileReader<T>().readConfig(getConfigurationClass(), configFile);
        this.server = new ResteasyWeldUndertowServer(config.getServer().getHttpConnector());
    }

    public RestWizardApp(T config) {
        this.config = config;
        this.server = new ResteasyWeldUndertowServer(config.getServer().getHttpConnector());
    }

    RestWizardApp() {
        server = null;
        config = null;
    }

    public void start() {
        server.start();
        server.deploy(new Application() {
            @Override
            public Set<Class<?>> getClasses() {
                return getResources();
            }
        });
    }

    final Class<T> getConfigurationClass() {
        return Generics.getTypeParameter(getClass(), RestWizardConfig.class);
    }

    public void stop() {
        server.stop();
    }

    public T getConfig() {
        return config;
    }

    public abstract Set<Class<?>> getResources();
}
