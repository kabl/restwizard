package com.restwizard.demo;

import com.restwizard.server.RestWizardApp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DemoApp extends RestWizardApp<CustomConfiguration> {

    private static final Logger LOG = LogManager.getLogger(DemoApp.class);


    public DemoApp() throws IOException {
        super("./src/test/resources/configuration/SimpleConfig.yml");
        LOG.info("Start DemoApp");
    }

    @Override
    public Set<Class<?>> getResources() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(SimpleDtoResource.class);
        return classes;
    }
}
