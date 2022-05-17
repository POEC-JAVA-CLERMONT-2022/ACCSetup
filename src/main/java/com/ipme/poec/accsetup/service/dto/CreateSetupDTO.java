package com.ipme.poec.accsetup.service.dto;

import com.ipme.poec.accsetup.model.Condition;
import com.ipme.poec.accsetup.model.Weather;
import lombok.Data;

import java.util.List;

@Data
public class CreateSetupDTO {
    //TODO
    private String name;

    private List<Weather> weathers;

    private List<Condition> conditions;

    private SessionDTO sessionDTO;

    public CreateSetupDTO(String name, List<Weather> weathers, List<Condition> conditions, SessionDTO sessionDTO) {
        this.name = name;
        this.weathers = weathers;
        this.conditions = conditions;
        this.sessionDTO = sessionDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public SessionDTO getSessionDTO() {
        return sessionDTO;
    }

    public void setSessionDTO(SessionDTO sessionDTO) {
        this.sessionDTO = sessionDTO;
    }
}
