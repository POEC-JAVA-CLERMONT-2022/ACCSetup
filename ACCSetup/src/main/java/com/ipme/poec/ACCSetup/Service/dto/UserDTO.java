package com.ipme.poec.ACCSetup.Service.dto;


import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private int id;

    private String name;

    private String password;

    private List<SessionDTO> sessions;

    public UserDTO(int id, String name, String password, List<SessionDTO> sessions) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sessions = sessions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SessionDTO> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionDTO> sessions) {
        this.sessions = sessions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO userDTO = (UserDTO) o;

        if (name != null ? !name.equals(userDTO.name) : userDTO.name != null) return false;
        return password != null ? password.equals(userDTO.password) : userDTO.password == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
