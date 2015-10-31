package com.restwizard.server;

import com.restwizard.config.CustomConfiguration;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class RestWizardAppTest {

    @Test
    public void testGetConfigurationClass() throws Exception {

        RestWizardApp<CustomConfiguration> app = new RestWizardApp<CustomConfiguration>() {
            @Override
            public Set<Class<?>> getResources() {
                return null;
            }
        };

        Class clazz = app.getConfigurationClass();
        assertEquals(CustomConfiguration.class.getSimpleName(), clazz.getSimpleName());
    }
}