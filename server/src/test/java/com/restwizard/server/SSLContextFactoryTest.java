package com.restwizard.server;

import org.junit.Test;

import static org.junit.Assert.*;

public class SSLContextFactoryTest {

    @Test
    public void testCreateSSLContext() throws Exception {
        String path = "./src/main/resources/restwizard.jks";
        char[] pass = "secret".toCharArray();
        new SSLContextFactory().createSSLContext(path, pass);
    }
}