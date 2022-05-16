package com.ipme.poec.accsetup.service.dto;

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
