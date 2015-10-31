package com.restwizard.server;

import com.restwizard.config.CustomConfiguration;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConfigFileReaderTest {

    @Test
    public void readConfigCustom() throws Exception {
        ConfigFileReader<CustomConfiguration> cfr = new ConfigFileReader<>();
        CustomConfiguration cfg = cfr.readConfig(CustomConfiguration.class, "./src/test/resources/configuration/SimpleConfig.yml");

        assertEquals("custom", cfg.getCustomProperty());

        assertEquals(8080, cfg.getServer().getHttpConnector().getPort());
        assertEquals("localhost", cfg.getServer().getHttpConnector().getHost());

        assertEquals(8181, cfg.getServer().getHttpsConnector().getPort());
        assertEquals("localhost", cfg.getServer().getHttpsConnector().getHost());

    }
}
