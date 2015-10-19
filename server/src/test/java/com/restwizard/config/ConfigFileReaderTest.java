package com.restwizard.config;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConfigFileReaderTest {

    @Test
    public void readJsonFile() throws Exception {
        ConfigFileReader cfr = new ConfigFileReader();
        RestWizardConfig cfg =  cfr.readFile("./src/test/resources/configuration/SimpleConfig.json");
        assertEquals("test json configuration", cfg.getName());
    }

    @Test
    public void readYamlFile() throws Exception {
        ConfigFileReader cfr = new ConfigFileReader();
        RestWizardConfig cfg =  cfr.readFile2("./src/test/resources/configuration/SimpleConfig.yml");
        assertEquals("test yaml configuration", cfg.getName());
//        assertEquals("hallo", cfg.getName());

    }
}