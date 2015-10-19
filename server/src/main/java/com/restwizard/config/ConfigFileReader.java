package com.restwizard.config;

import org.codehaus.jackson.map.ObjectMapper;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import java.io.FileReader;
import java.io.IOException;

public class ConfigFileReader {


    public RestWizardConfig readFile(String path) throws IOException {
        FileReader fr = new FileReader(path);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(fr, RestWizardConfig.class);
    }

    public RestWizardConfig readFile2(String path) throws IOException {

//        {
//            Yaml yaml = new Yaml();
//            RestWizardConfig foo = new RestWizardConfig();
//            foo.setName("hallo");
//            Server server = new Server();
//            Connector connector = new Connector();
//            connector.setPort(123);
//            List<Connector> connectors = new ArrayList<>();
//            connectors.add(connector);
//            server.setConnectors(connectors);
//            foo.setServer(server);
//            String output = yaml.dump(foo);
////            yaml.
//            System.out.println(output);
//            RestWizardConfig foo2 = (RestWizardConfig) yaml.load(output);
//            System.out.println("ok");
//        }

        //https://code.google.com/p/snakeyaml/wiki/Documentation#Loading_YAML
        Constructor construct = new Constructor(RestWizardConfig.class);
        Yaml yaml = new Yaml(construct);
        FileReader fr = new FileReader(path);
        return (RestWizardConfig)yaml.load(fr);
    }

}
