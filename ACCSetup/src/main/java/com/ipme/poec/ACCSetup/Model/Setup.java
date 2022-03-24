package com.ipme.poec.ACCSetup.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "setup")
public class Setup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "setupID", length = 11)
    private int setupId;

    private float setupFLPsi;
    private float setupFRPsi;
    private float setupRLPsi;
    private float setupRRPsi;
    private float setupFLToe;
    private float setupFRToe;
    private float setupRLToe;
    private float setupRRToe;
    private float setupFLCamber;
    private float setupFRCamber;
    private float setupRLCamber;
    private float setupRRCamber;
    private float setupFLCaster;
    private float setupFRCaster;
    private String setupDesc;

    @ManyToMany
    private List<Weather> weathers;

    @ManyToMany
    private List<Condition> conditions;

    public Setup(int setupId, float setupFLPsi, float setupFRPsi, float setupRLPsi, float setupRRPsi, float setupFLToe, float setupFRToe, float setupRLToe, float setupRRToe, float setupFLCamber, float setupFRCamber, float setupRLCamber, float setupRRCamber, float setupFLCaster, float setupFRCaster, String setupDesc) {
        this.setupId = setupId;
        this.setupFLPsi = setupFLPsi;
        this.setupFRPsi = setupFRPsi;
        this.setupRLPsi = setupRLPsi;
        this.setupRRPsi = setupRRPsi;
        this.setupFLToe = setupFLToe;
        this.setupFRToe = setupFRToe;
        this.setupRLToe = setupRLToe;
        this.setupRRToe = setupRRToe;
        this.setupFLCamber = setupFLCamber;
        this.setupFRCamber = setupFRCamber;
        this.setupRLCamber = setupRLCamber;
        this.setupRRCamber = setupRRCamber;
        this.setupFLCaster = setupFLCaster;
        this.setupFRCaster = setupFRCaster;
        this.setupDesc = setupDesc;
    }

    public Setup() {

    }

    public int getSetupId() {
        return setupId;
    }

    public void setSetupId(int setupId) {
        this.setupId = setupId;
    }

    public float getSetupFLPsi() {
        return setupFLPsi;
    }

    public void setSetupFLPsi(float setupFLPsi) {
        this.setupFLPsi = setupFLPsi;
    }

    public float getSetupFRPsi() {
        return setupFRPsi;
    }

    public void setSetupFRPsi(float setupFRPsi) {
        this.setupFRPsi = setupFRPsi;
    }

    public float getSetupRLPsi() {
        return setupRLPsi;
    }

    public void setSetupRLPsi(float setupRLPsi) {
        this.setupRLPsi = setupRLPsi;
    }

    public float getSetupRRPsi() {
        return setupRRPsi;
    }

    public void setSetupRRPsi(float setupRRPsi) {
        this.setupRRPsi = setupRRPsi;
    }

    public float getSetupFLToe() {
        return setupFLToe;
    }

    public void setSetupFLToe(float setupFLToe) {
        this.setupFLToe = setupFLToe;
    }

    public float getSetupFRToe() {
        return setupFRToe;
    }

    public void setSetupFRToe(float setupFRToe) {
        this.setupFRToe = setupFRToe;
    }

    public float getSetupRLToe() {
        return setupRLToe;
    }

    public void setSetupRLToe(float setupRLToe) {
        this.setupRLToe = setupRLToe;
    }

    public float getSetupRRToe() {
        return setupRRToe;
    }

    public void setSetupRRToe(float setupRRToe) {
        this.setupRRToe = setupRRToe;
    }

    public float getSetupFLCamber() {
        return setupFLCamber;
    }

    public void setSetupFLCamber(float setupFLCamber) {
        this.setupFLCamber = setupFLCamber;
    }

    public float getSetupFRCamber() {
        return setupFRCamber;
    }

    public void setSetupFRCamber(float setupFRCamber) {
        this.setupFRCamber = setupFRCamber;
    }

    public float getSetupRLCamber() {
        return setupRLCamber;
    }

    public void setSetupRLCamber(float setupRLCamber) {
        this.setupRLCamber = setupRLCamber;
    }

    public float getSetupRRCamber() {
        return setupRRCamber;
    }

    public void setSetupRRCamber(float setupRRCamber) {
        this.setupRRCamber = setupRRCamber;
    }

    public float getSetupFLCaster() {
        return setupFLCaster;
    }

    public void setSetupFLCaster(float setupFLCaster) {
        this.setupFLCaster = setupFLCaster;
    }

    public float getSetupFRCaster() {
        return setupFRCaster;
    }

    public void setSetupFRCaster(float setupFRCaster) {
        this.setupFRCaster = setupFRCaster;
    }

    public String getSetupDesc() {
        return setupDesc;
    }

    public void setSetupDesc(String setupDesc) {
        this.setupDesc = setupDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Setup setup = (Setup) o;

        return setupId == setup.setupId;
    }

    @Override
    public int hashCode() {
        return setupId;
    }
}
