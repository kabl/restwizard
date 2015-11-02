package com.restwizard.demo;

import com.google.common.collect.Sets;
import com.restwizard.server.RestWizardApp;

import java.io.IOException;
import java.util.Set;

public class DemoApp extends RestWizardApp<CustomConfiguration> {

    public DemoApp() throws IOException {
        super("./src/test/resources/configuration/SimpleConfig.yml");
    }

    @Override
    public Set<Class<?>> getResources() {

        Set<Class<?>> classes = Sets.newHashSet();

        classes.add(CdiResource.class);
        classes.add(SimpleDtoResource.class);

        return classes;
    }
}