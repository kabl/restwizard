package com.restwizard.server;

import com.restwizard.config.CustomConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class ServerTest {

    private static MyApp SERVER;

    @BeforeClass
    public static void createAndStartServer() throws IOException {
        SERVER = new MyApp();
        SERVER.start();
    }

    @AfterClass
    public static void stopServer() {
        SERVER.stop();
    }

    @Test
    public void testCdiResource() throws Exception {
//         Thread.sleep(100000);
        Client client = ClientBuilder.newClient();
        String result = client.target("http://localhost:8080/cdi-resource")
                .request().get(String.class);
        client.close();

        assertEquals("inject: Hello World", result);
    }

    @Test
    public void testTextResource() throws Exception {
        Client client = ClientBuilder.newClient();
        String dto = client.target("http://localhost:8080/dto-resource")
                .request().accept(MediaType.TEXT_PLAIN).get(String.class);
        client.close();

        assertEquals("SimpleDto.name=Hello World", dto);
    }

    @Test
    public void testXmlResource() throws Exception {
        Client client = ClientBuilder.newClient();
        String dto = client.target("http://localhost:8080/dto-resource")
                .request().accept(MediaType.APPLICATION_XML).get(String.class);
        client.close();

        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><simpleDto><name>Hello World</name></simpleDto>", dto);
    }

    @Test
    public void testJsonResource() throws Exception {
        Client client = ClientBuilder.newClient();
        String dto = client.target("http://localhost:8080/dto-resource")
                .request().accept(MediaType.APPLICATION_JSON).get(String.class);
        client.close();

        assertEquals("{\"name\":\"Hello World\"}", dto);
    }
}
