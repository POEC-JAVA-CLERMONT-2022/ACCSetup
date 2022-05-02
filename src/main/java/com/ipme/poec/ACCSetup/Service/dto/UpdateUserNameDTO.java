package com.ipme.poec.ACCSetup.Service.dto;

public class UpdateUserNameDTO {

    String name;

    public UpdateUserNameDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
