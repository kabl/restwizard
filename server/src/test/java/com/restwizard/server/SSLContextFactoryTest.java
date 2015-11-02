package com.restwizard.server;

import org.junit.Test;

import javax.net.ssl.SSLContext;

import static org.junit.Assert.assertEquals;

public class SSLContextFactoryTest {

    @Test
    public void testCreateSSLContext() throws Exception {
        String path = "./src/main/resources/restwizard.jks";
        char[] pass = "secret".toCharArray();
        SSLContext sslContext = new SSLContextFactory().createSSLContext(path, pass);
        String protocol = sslContext.getProtocol();
        assertEquals("TLS", protocol);
    }
}