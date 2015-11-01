package com.restwizard.server;

import com.restwizard.config.RestWizardConfig;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

class ConfigFileReader<T extends RestWizardConfig> {

    private static final Logger LOG = Logger.getLogger(ConfigFileReader.class.getSimpleName());

    public T readConfig(Class t, String path) throws IOException {
        LOG.info("Try to read file: " + path + ", into class: " + t.getSimpleName());

        //https://code.google.com/p/snakeyaml/wiki/Documentation#Loading_YAML
        Constructor construct = new Constructor(t);
        Yaml yaml = new Yaml(construct);
        FileReader fr = new FileReader(path);
        return (T)yaml.load(fr);
    }
}
