package com.restwizard.server;

import com.restwizard.config.RestWizardConfig;
import com.restwizard.util.Generics;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.core.Application;
import java.io.IOException;
import java.util.Set;

public abstract class RestWizardApp<T extends RestWizardConfig> {

    private static final Logger LOG = LogManager.getLogger(ConfigFileReader.class);

    private final ResteasyWeldUndertowServer server;
    private final T config;


    public RestWizardApp(String configFile) throws IOException {
        LOG.info("Init RestWizardApp. Config: " + configFile);

        this.config = new ConfigFileReader<T>().readConfig(getConfigurationClass(), configFile);
        this.server = new ResteasyWeldUndertowServer(config.getServer());
    }

    public RestWizardApp(T config) {
        LOG.info("Init RestWizardApp");

        this.config = config;
        this.server = new ResteasyWeldUndertowServer(config.getServer());
    }

    public void start() {
        server.start();
        server.deploy(new Application() {
            @Override
            public Set<Class<?>> getClasses() {
                Set<Class<?>> classes = getResources();

                if(classes == null || classes.isEmpty()){
                    throw new RuntimeException("No Resource classes available! Nothing to deploy");
                }

                classes.stream().forEach(aClass -> LOG.info("Add resource class: " + aClass.getSimpleName()));
                return classes;
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
