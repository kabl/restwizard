package com.restwizard.config;

public enum ConnectorType {
    HTTP("http"),
    HTTPS("https");

    private final String type;

    ConnectorType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
