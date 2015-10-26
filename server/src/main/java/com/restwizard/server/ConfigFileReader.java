package com.restwizard.server;

import com.restwizard.config.RestWizardConfig;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileReader;
import java.io.IOException;

class ConfigFileReader<T extends RestWizardConfig> {

    public T readConfig(Class t, String path) throws IOException {
        //https://code.google.com/p/snakeyaml/wiki/Documentation#Loading_YAML
        Constructor construct = new Constructor(t);
        Yaml yaml = new Yaml(construct);
        FileReader fr = new FileReader(path);
        T config = (T)yaml.load(fr);
        return config;
    }
}
