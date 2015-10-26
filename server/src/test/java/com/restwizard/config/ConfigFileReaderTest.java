package com.restwizard.config;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConfigFileReaderTest {

//    @Test
//    public void readJsonFile() throws Exception {
//        ConfigFileReader cfr = new ConfigFileReader();
//        RestWizardConfig cfg =  cfr.readFile("./src/test/resources/configuration/SimpleConfig.json");
//        assertEquals("test json configuration", cfg.getName());
//    }

    @Test
    public void readConfig() throws Exception {
        ConfigFileReader<RestWizardConfig> cfr = new ConfigFileReader<>();
        RestWizardConfig cfg =  cfr.readConfig("./src/test/resources/configuration/SimpleConfig.yml");
        assertEquals("test yaml configuration", cfg.getName());
        assertEquals(8080, cfg.getServer().getHttpConnector().getPort());
//        assertEquals("hallo", cfg.getName());

    }
}