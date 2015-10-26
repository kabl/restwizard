package com.restwizard.config;

import org.codehaus.jackson.map.ObjectMapper;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import java.io.FileReader;
import java.io.IOException;

public class ConfigFileReader<T extends RestWizardConfig> {


//    public RestWizardConfig readFile(String path) throws IOException {
//        FileReader fr = new FileReader(path);
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.readValue(fr, RestWizardConfig.class);
//    }

    public T readConfig(String path) throws IOException {
        //https://code.google.com/p/snakeyaml/wiki/Documentation#Loading_YAML
        Constructor construct = new Constructor(RestWizardConfig.class);
        Yaml yaml = new Yaml(construct);
        FileReader fr = new FileReader(path);
        return (T)yaml.load(fr);
    }
}
