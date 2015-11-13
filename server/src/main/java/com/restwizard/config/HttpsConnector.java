package com.restwizard.config;

import java.io.InputStream;

public class HttpsConnector extends HttpConnector{

    private String keyStorePath;
    private String keyStorePassword;
    private InputStream keyStoreStream;

    public String getKeyStorePath() {
        return keyStorePath;
    }

    public InputStream getKeyStoreStream() {
        return keyStoreStream;
    }

    public void setKeyStorePath(String keyStorePath) {
        this.keyStorePath = keyStorePath;
    }

    public String getKeyStorePassword() {
        return keyStorePassword;
    }

    public void setKeyStoreStream(InputStream keyStoreStream) {
        this.keyStoreStream = keyStoreStream;
    }

    public void setKeyStorePassword(String keyStorePassword) {
        this.keyStorePassword = keyStorePassword;
    }


    @Override
    public String toString(){
        return "Https Connector: Host: " + getHost() + ", Port: " + getPort();
    }
}
