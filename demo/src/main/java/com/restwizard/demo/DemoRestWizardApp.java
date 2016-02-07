package com.restwizard.demo;

import com.google.common.collect.Sets;
import com.restwizard.demo.resources.Demo1Resource;
import com.restwizard.server.RestWizardApp;

import java.io.IOException;
import java.util.Set;

public class DemoRestWizardApp extends RestWizardApp<CustomRestwizardConfig> {

    public static void main(String... args) throws IOException {
        new DemoRestWizardApp().start();
    }

    public DemoRestWizardApp() throws IOException {
//        super("./demo/src/main/resources/restwizard-demo.yml"); //Intellij
        super("./src/main/resources/restwizard-demo.yml");    //Netbeans

    }

    @Override
    public Set<Class<?>> getResources() {
        Set<Class<?>> classes = Sets.newHashSet();
        classes.add(Demo1Resource.class);
        return classes;
    }
}
