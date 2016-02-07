package com.restwizard.server;

import com.restwizard.demo.CustomConfiguration;
import com.restwizard.demo.DemoApp;
import junit.framework.*;
import junit.framework.Assert;
import org.junit.*;
import org.junit.Test;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import static junit.framework.TestCase.assertEquals;

public class ServerTest {

    private static DemoApp SERVER;
    private Client client;

    @BeforeClass
    public static void createAndStartServer() throws IOException {
        SERVER = new DemoApp();
        SERVER.start();
    }

    @AfterClass
    public static void stopServer() throws InterruptedException {
        Thread.sleep(500); //Give some time that the server is able to close the connections
        SERVER.stop();
    }

    @Before
    public void beforeTestCase() throws KeyManagementException, NoSuchAlgorithmException {
        client = createClient();
    }

    @After
    public void afterTestCase(){
        client.close();
    }

    @Test
    public void httpTextResource() throws Exception {

        String dto = client.target("http://localhost:8080/dto-resource")
                .request().accept(MediaType.TEXT_PLAIN).get(String.class);

        assertEquals("SimpleDto.name=Hello World", dto);
    }

    @Test
    public void httpXmlResource() throws Exception {

        String dto = client.target("http://localhost:8080/dto-resource")
                .request().accept(MediaType.APPLICATION_XML).get(String.class);

        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><simpleDto><name>Hello World</name></simpleDto>", dto);
    }

    @Test
    public void httpJsonResource() throws Exception {

        String dto = client.target("http://localhost:8080/dto-resource")
                .request().accept(MediaType.APPLICATION_JSON).get(String.class);

        assertEquals("{\"name\":\"Hello World\"}", dto);
    }

    @Test
    public void httpsJsonResource() throws Exception {

        String dto = client.target("https://localhost:8181/dto-resource")
                .request().accept(MediaType.APPLICATION_JSON).get(String.class);

        assertEquals("{\"name\":\"Hello World\"}", dto);
    }

    @Test
    public void readConfiguratoin(){
        CustomConfiguration cc = SERVER.getConfig();
        assertEquals("custom", cc.getCustomProperty());
    }

    private Client createClient() throws NoSuchAlgorithmException, KeyManagementException {

        TrustManager trustAllServersMngr = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };

        TrustManager[] trustManagers = new TrustManager[1];
        trustManagers[0] = trustAllServersMngr;
        SSLContext sslContext;
        sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustManagers, null);

        return ClientBuilder.newBuilder().sslContext(sslContext).build();
    }
}
