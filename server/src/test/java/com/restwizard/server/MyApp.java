package com.restwizard.server;

import com.restwizard.resources.CdiResource;
import com.restwizard.resources.SimpleDtoResource;
import com.google.common.collect.Sets;

import java.util.Set;

public class MyApp extends HelloWorldApp {

    @Override
    public Set<Class<?>> getResources() {
        Set<Class<?>> classes = Sets.newHashSet();

        classes.add(CdiResource.class);
        classes.add(SimpleDtoResource.class);

        return classes;
    }
}
