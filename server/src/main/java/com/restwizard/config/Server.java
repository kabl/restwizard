package com.restwizard.config;

import java.util.List;

public class Server {

    private List<Connector> connectors;

    public List<Connector> getConnectors() {
        return connectors;
    }

    public void setConnectors(List<Connector> connectors) {
        this.connectors = connectors;
    }
}
