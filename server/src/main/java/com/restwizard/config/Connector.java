package com.restwizard.config;

public class Connector {

    private ConnectorType type;
    private int port;

    private String keyStorePath;
    private String keyStorePassword;
    private boolean validateCerts;

    public ConnectorType getType() {
        return type;
    }

    public void setType(ConnectorType type) {
        this.type = type;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

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

    public boolean isValidateCerts() {
        return validateCerts;
    }

    public void setValidateCerts(boolean validateCerts) {
        this.validateCerts = validateCerts;
    }
}
