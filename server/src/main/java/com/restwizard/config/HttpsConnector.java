package com.restwizard.config;

public class HttpsConnector extends HttpConnector{

    private String keyStorePath;
    private String keyStorePassword;

    public String getKeyStorePath() {
        return keyStorePath;
    }

    public void setKeyStorePath(String keyStorePath) {
        this.keyStorePath = keyStorePath;
    }

    public String getKeyStorePassword() {
        return keyStorePassword;
    }

    public void setKeyStorePassword(String keyStorePassword) {
        this.keyStorePassword = keyStorePassword;
    }


    @Override
    public String toString(){
        return "Https Connector: Host: " + getHost() + ", Port: " + getPort();
    }
}
