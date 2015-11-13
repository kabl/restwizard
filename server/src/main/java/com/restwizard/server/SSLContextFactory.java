package com.restwizard.server;

import com.restwizard.config.HttpsConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.KeyStore;

public class SSLContextFactory {

    private static final Logger LOG = LogManager.getLogger(SSLContextFactory.class);

    SSLContext createSSLContext(HttpsConnector httpsConnector) {
        if (httpsConnector.getKeyStorePath() != null) {
            return createSSLContext(httpsConnector.getKeyStorePath(), httpsConnector.getKeyStorePassword().toCharArray());
        } else {
            return createSSLContext(httpsConnector.getKeyStoreStream(), httpsConnector.getKeyStorePassword().toCharArray());
        }
    }

    SSLContext createSSLContext(String keyStorePath, char[] keyStorePassword) {

        LOG.info("Try to read keyStore: " + keyStorePath);

        try {
            return createSSLContext(new FileInputStream(keyStorePath), keyStorePassword);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    SSLContext createSSLContext(InputStream keyStoreStream, char[] keyStorePassword) {
        try {
            KeyStore loadedKeystore = KeyStore.getInstance("JKS");
            loadedKeystore.load(keyStoreStream, keyStorePassword);
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
