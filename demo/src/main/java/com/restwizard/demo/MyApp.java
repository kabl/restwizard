package com.restwizard.demo;

import com.restwizard.demo.resources.Demo1Resource;
import com.restwizard.demo.resources.Demo2Resource;
import com.restwizard.demo.resources.Demo3Resource;
import com.restwizard.server.HelloWorldApp;
import com.google.common.collect.Sets;

import java.util.Set;

public class MyApp extends HelloWorldApp {

    public static void main(String... args){
        new MyApp().start();
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
