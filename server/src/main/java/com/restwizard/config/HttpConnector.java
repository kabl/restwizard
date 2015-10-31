package com.restwizard.config;

public class HttpConnector {

    private int port;
    private String host;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public String toString(){
        return "Http Connector: Host: " + host + ", Port: " + port;
    }
}
