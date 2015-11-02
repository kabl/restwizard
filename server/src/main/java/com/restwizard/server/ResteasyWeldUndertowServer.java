package com.restwizard.server;

import com.restwizard.config.HttpConnector;
import com.restwizard.config.HttpsConnector;
import com.restwizard.config.Server;
import io.undertow.Undertow;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import org.jboss.resteasy.cdi.CdiInjectorFactory;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.jboss.weld.environment.servlet.Listener;

import javax.net.ssl.SSLContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.logging.Logger;

public class ResteasyWeldUndertowServer {

    private static final Logger LOG = Logger.getLogger(ResteasyWeldUndertowServer.class.getSimpleName());

    public static final String ROOT_PATH = "/";
    private final UndertowJaxrsServer undertowServer;
    //    private final Undertow.Builder builder;
    private final Server serverCfg;

    public ResteasyWeldUndertowServer(Server serverCfg) {
        this.undertowServer = new UndertowJaxrsServer();
        this.serverCfg = serverCfg;
    }

    public void start() {
        Undertow.Builder builder = Undertow.builder();

        HttpConnector httpConnector = serverCfg.getHttpConnector();
        if (httpConnector != null) {
//        Undertow.builder().
            builder.addHttpListener(httpConnector.getPort(), httpConnector.getHost());
            LOG.info("Init Connector: " + httpConnector);
        }

        HttpsConnector httpsConnector = serverCfg.getHttpsConnector();
        if (httpsConnector != null) {
            SSLContextFactory sslFactory = new SSLContextFactory();
            SSLContext sslContext = sslFactory.createSSLContext(httpsConnector.getKeyStorePath(), httpsConnector.getKeyStorePassword().toCharArray());
            builder.addHttpsListener(httpsConnector.getPort(), httpsConnector.getHost(), sslContext);
            LOG.info("Init Connector: " + httpsConnector);

        }

        if (httpConnector == null && httpsConnector == null) {
            throw new RuntimeException("httpConnector and httpsConnector are null");
        }

        undertowServer.start(builder);
        LOG.info("restwizard server is now running.");

    }

    public void stop() {
        LOG.info("Stop restwizard server");
        undertowServer.stop();
    }

    public void deploy(Application appClass) {
        undertowServer.deploy(createDeploymentInfo(appClass));
    }

    private DeploymentInfo createDeploymentInfo(Application appClass) {
        DeploymentInfo di = undertowServer.undertowDeployment(createDeployment(appClass));
        di.addListener(Servlets.listener(Listener.class));
        di.setClassLoader(appClass.getClass().getClassLoader());
        di.setContextPath(getContextPath(appClass));
        di.setDeploymentName(appClass.getClass().getSimpleName());
        return di;
    }

    private static ResteasyDeployment createDeployment(Application appClass) {
        ResteasyDeployment deployment = new ResteasyDeployment();
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
