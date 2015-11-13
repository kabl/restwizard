package com.restwizard.demo;

import com.google.common.collect.Sets;
import com.restwizard.config.RestWizardConfig;
import com.restwizard.demo.resources.Demo1Resource;
import com.restwizard.demo.resources.Demo2Resource;
import com.restwizard.server.RestWizardApp;

import java.io.IOException;
import java.util.Set;

public class DemoRestWizardApp2 extends RestWizardApp<RestWizardConfig> {

    public static void main(String... args) throws IOException {
        new DemoRestWizardApp2().start();
    }

    public DemoRestWizardApp2() throws IOException {
        super(RestWizardConfig.createDefault()); //Intellij

    }

    @Override
    public Set<Class<?>> getResources() {
        Set<Class<?>> classes = Sets.newHashSet();

        classes.add(Demo1Resource.class);
        classes.add(Demo2Resource.class);

        return classes;
    }
}
