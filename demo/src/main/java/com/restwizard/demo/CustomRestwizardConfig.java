package com.restwizard.demo;

import com.restwizard.config.RestWizardConfig;

public class CustomRestwizardConfig extends RestWizardConfig {

    private String customProperty;

    public String getCustomProperty() {
        return customProperty;
    }

    public void setCustomProperty(String customProperty) {
        this.customProperty = customProperty;
    }
}
