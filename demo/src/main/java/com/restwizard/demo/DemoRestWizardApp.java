package com.restwizard.demo;

import com.restwizard.demo.resources.Demo1Resource;
import com.restwizard.demo.resources.Demo2Resource;
import com.restwizard.server.RestWizardApp;
import com.google.common.collect.Sets;

import java.io.IOException;
import java.util.Set;

public class DemoRestWizardApp extends RestWizardApp<CustomRestwizardConfig> {

    public static void main(String... args) throws IOException {
        new DemoRestWizardApp().start();
    }

    public DemoRestWizardApp() throws IOException {
//        super("./demo/src/main/resources/restwizard-demo.yml");
        super("./src/main/resources/restwizard-demo.yml");

    }

    @Override
    public Set<Class<?>> getResources() {
        Set<Class<?>> classes = Sets.newHashSet();

        classes.add(Demo1Resource.class);
        classes.add(Demo2Resource.class);

        return classes;
    }
}
