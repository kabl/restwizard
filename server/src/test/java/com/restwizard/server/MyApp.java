package com.restwizard.server;

import com.restwizard.resources.CdiResource;
import com.restwizard.resources.SimpleDtoResource;
import com.google.common.collect.Sets;

import java.io.IOException;
import java.util.Set;

public class MyApp extends RestWizardApp {

    public MyApp() throws IOException {
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
