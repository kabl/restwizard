package com.restwizard.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.security.KeyStore;

public class SSLContextFactory {

    private static final Logger LOG = LogManager.getLogger(SSLContextFactory.class);

    SSLContext createSSLContext(String keyStorePath, char[] keyStorePassword){

        LOG.info("Try to read keyStore: " + keyStorePath);
        try {
            KeyStore loadedKeystore = KeyStore.getInstance("JKS");
            loadedKeystore.load(new FileInputStream(keyStorePath), keyStorePassword);
            KeyManager[] keyManagers;
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(loadedKeystore, keyStorePassword);
            keyManagers = keyManagerFactory.getKeyManagers();

            SSLContext sslContext;
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagers, null, null);

            return sslContext;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
