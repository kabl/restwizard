package com.restwizard.server;

import com.restwizard.config.RestWizardConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileReader;
import java.io.IOException;

class ConfigFileReader<T extends RestWizardConfig> {

    private static final Logger LOG = LogManager.getLogger(ConfigFileReader.class);

    public T readConfig(Class t, String path) throws IOException {
        LOG.info("Try to read file: " + path + ", into class: " + t.getSimpleName());

        //https://code.google.com/p/snakeyaml/wiki/Documentation#Loading_YAML
        Constructor construct = new Constructor(t);
        Yaml yaml = new Yaml(construct);
        FileReader fr = new FileReader(path);
        return (T)yaml.load(fr);
    }
}
