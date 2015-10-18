package com.restwizard.server;

import io.undertow.Undertow;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import org.jboss.resteasy.cdi.CdiInjectorFactory;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.jboss.weld.environment.servlet.Listener;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

public class ResteasyWeldUndertowServer {

    public static final String ROOT_PATH = "/";
    private final UndertowJaxrsServer server;
    private final Undertow.Builder builder;

    public ResteasyWeldUndertowServer(int httpPort) {
        server = new UndertowJaxrsServer();
        builder = Undertow.builder().addHttpListener(httpPort, "localhost");
    }

    public void start() {
        server.start(builder);
    }

    public void stop() {
        server.stop();
    }

    public void deploy(Application appClass) {
        server.deploy(createDeploymentInfo(appClass));
    }

    public DeploymentInfo createDeploymentInfo(Application appClass) {
        DeploymentInfo di = server.undertowDeployment(createDeployment(appClass));
        di.addListener(Servlets.listener(Listener.class));
        di.setClassLoader(appClass.getClass().getClassLoader());
        di.setContextPath(getContextPath(appClass));
        di.setDeploymentName(appClass.getClass().getSimpleName());
        return di;
    }

    private static ResteasyDeployment createDeployment(Application appClass) {
        ResteasyDeployment deployment = new ResteasyDeployment();
        //  deployment.setApplicationClass(appClass.getClass().getName());
        deployment.setApplication(appClass);
        deployment.setInjectorFactoryClass(CdiInjectorFactory.class.getName());
        return deployment;
    }

    private static String getContextPath(Application appClass) {
        ApplicationPath appPath = appClass.getClass().getAnnotation(ApplicationPath.class);
        String path = ROOT_PATH;
        if (appPath != null) {
            path = appPath.value();
        }
        if (!path.startsWith(ROOT_PATH)) {
            path = ROOT_PATH + path;
        }
        return path;
    }


}
