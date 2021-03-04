package com.haui.realestatebusiness.models.requests;

import javax.validation.constraints.NotBlank;

public class ImageRq {
    @NotBlank
    private String name;
    @NotBlank
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}