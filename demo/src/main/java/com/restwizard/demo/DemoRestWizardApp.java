package com.restwizard.demo;

import com.restwizard.demo.resources.Demo1Resource;
import com.restwizard.demo.resources.Demo2Resource;
import com.restwizard.demo.resources.Demo3Resource;
import com.restwizard.server.RestWizardApp;
import com.google.common.collect.Sets;

import java.util.Set;

public class DemoRestWizardApp extends RestWizardApp {

    public static void main(String... args){
        new DemoRestWizardApp().start();
    }

    public DemoRestWizardApp(){
        super(8080);
    }

    @Override
    public Set<Class<?>> getResources() {
        Set<Class<?>> classes = Sets.newHashSet();

        classes.add(Demo1Resource.class);
        classes.add(Demo2Resource.class);
        classes.add(Demo3Resource.class);

        return classes;
    }
}
