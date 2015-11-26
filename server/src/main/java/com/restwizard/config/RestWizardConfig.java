package com.restwizard.config;

import java.io.InputStream;

public class RestWizardConfig {

    private Server server;

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public static RestWizardConfig createDefault() {
        RestWizardConfig cfg = new RestWizardConfig();

        Server server = new Server();
        cfg.setServer(server);

        HttpConnector httpConnector = new HttpConnector();
        httpConnector.setPort(8080);
        httpConnector.setHost("localhost");
        server.setHttpConnector(httpConnector);

//        HttpsConnector httpsConnector = new HttpsConnector();
//        httpsConnector.setPort(8181);
//        httpsConnector.setHost("localhost");
//        httpsConnector.setKeyStorePassword("secret");
//        httpsConnector.setKeyStorePath(getDefaultKeyStorePath());
//        server.setHttpsConnector(httpsConnector);

        return cfg;
    }

    private static String getDefaultKeyStorePath() {
        return RestWizardConfig.class.getClassLoader().
                getResource("restwizard.jks").getFile();
    }


    private static InputStream getDefaultKeyStoreStream() {
        return RestWizardConfig.class.getResourceAsStream("restwizard.jks");
    }
}
