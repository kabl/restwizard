package com.restwizard.demo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SimpleDto {

    private String name;

    public SimpleDto() {
    }

    public SimpleDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName() + ".name=" + name;
    }
}
