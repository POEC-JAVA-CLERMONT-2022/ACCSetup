package com.ipme.poec.ACCSetup.Service.dto;

import com.ipme.poec.ACCSetup.Model.Condition;
import com.ipme.poec.ACCSetup.Model.Weather;
import lombok.Data;

import java.util.List;

@Data
public class SetupDTO {

    private int id;

    private String name;

    private float flPsi;

    private float frPsi;

    private float rlPsi;

    private float rrPsi;

    private float flToe;

    private float frToe;

    private float rlToe;

    private float rrToe;

    private float flCamber;

    private float frCamber;

    private float rlCamber;

    private float rrCamber;

    private float flCaster;

    private float frCaster;

    private String desc;

    private List<Weather> weathers;

    private List<Condition> conditions;

    private SessionDTO session;

    public SetupDTO(int id, String name, float flPsi, float frPsi, float rlPsi, float rrPsi, float flToe, float frToe, float rlToe, float rrToe, float flCamber, float frCamber, float rlCamber, float rrCamber, float flCaster, float frCaster, String desc, List<Weather> weathers, List<Condition> conditions, SessionDTO session) {
        this.id = id;
        this.name = name;
        this.flPsi = flPsi;
        this.frPsi = frPsi;
        this.rlPsi = rlPsi;
        this.rrPsi = rrPsi;
        this.flToe = flToe;
        this.frToe = frToe;
        this.rlToe = rlToe;
        this.rrToe = rrToe;
        this.flCamber = flCamber;
        this.frCamber = frCamber;
        this.rlCamber = rlCamber;
        this.rrCamber = rrCamber;
        this.flCaster = flCaster;
        this.frCaster = frCaster;
        this.desc = desc;
        this.weathers = weathers;
        this.conditions = conditions;
        this.session = session;
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

    public float getFlPsi() {
        return flPsi;
    }

    public void setFlPsi(float flPsi) {
        this.flPsi = flPsi;
    }

    public float getFrPsi() {
        return frPsi;
    }

    public void setFrPsi(float frPsi) {
        this.frPsi = frPsi;
    }

    public float getRlPsi() {
        return rlPsi;
    }

    public void setRlPsi(float rlPsi) {
        this.rlPsi = rlPsi;
    }

    public float getRrPsi() {
        return rrPsi;
    }

    public void setRrPsi(float rrPsi) {
        this.rrPsi = rrPsi;
    }

    public float getFlToe() {
        return flToe;
    }

    public void setFlToe(float flToe) {
        this.flToe = flToe;
    }

    public float getFrToe() {
        return frToe;
    }

    public void setFrToe(float frToe) {
        this.frToe = frToe;
    }

    public float getRlToe() {
        return rlToe;
    }

    public void setRlToe(float rlToe) {
        this.rlToe = rlToe;
    }

    public float getRrToe() {
        return rrToe;
    }

    public void setRrToe(float rrToe) {
        this.rrToe = rrToe;
    }

    public float getFlCamber() {
        return flCamber;
    }

    public void setFlCamber(float flCamber) {
        this.flCamber = flCamber;
    }

    public float getFrCamber() {
        return frCamber;
    }

    public void setFrCamber(float frCamber) {
        this.frCamber = frCamber;
    }

    public float getRlCamber() {
        return rlCamber;
    }

    public void setRlCamber(float rlCamber) {
        this.rlCamber = rlCamber;
    }

    public float getRrCamber() {
        return rrCamber;
    }

    public void setRrCamber(float rrCamber) {
        this.rrCamber = rrCamber;
    }

    public float getFlCaster() {
        return flCaster;
    }

    public void setFlCaster(float flCaster) {
        this.flCaster = flCaster;
    }

    public float getFrCaster() {
        return frCaster;
    }

    public void setFrCaster(float frCaster) {
        this.frCaster = frCaster;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public SessionDTO getSession() {
        return session;
    }

    public void setSession(SessionDTO session) {
        this.session = session;
    }
}
