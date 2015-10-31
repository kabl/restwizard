package com.restwizard.config;

public class Server {

    private HttpConnector httpConnector;
    private HttpsConnector httpsConnector;

    public HttpConnector getHttpConnector() {
        return httpConnector;
    }

    public void setHttpConnector(HttpConnector httpConnector) {
        this.httpConnector = httpConnector;
    }

    public HttpsConnector getHttpsConnector() {
        return httpsConnector;
    }

    public void setHttpsConnector(HttpsConnector httpsConnector) {
        this.httpsConnector = httpsConnector;
    }
}
