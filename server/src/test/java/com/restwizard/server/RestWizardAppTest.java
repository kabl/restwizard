package com.restwizard.server;

import com.restwizard.config.RestWizardConfig;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class RestWizardAppTest {

    @Test
    public void testGetConfigurationClass() throws Exception {

        final RestWizardConfig cfg = RestWizardConfig.createDefault();

        RestWizardApp<RestWizardConfig> app = new RestWizardApp<RestWizardConfig>(cfg) {
            @Override
            public Set<Class<?>> getResources() {
                return null;
            }
        };

        Class clazz = app.getConfigurationClass();
        assertEquals(RestWizardConfig.class.getSimpleName(), clazz.getSimpleName());
    }
}