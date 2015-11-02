package com.restwizard.config;

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

        return cfg;
    }
}
