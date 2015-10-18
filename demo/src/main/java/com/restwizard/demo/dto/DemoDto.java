package com.restwizard.demo.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DemoDto {

    private String name;

    public DemoDto() {
    }

    public DemoDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
