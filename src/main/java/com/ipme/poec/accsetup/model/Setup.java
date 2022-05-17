package com.ipme.poec.accsetup.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "setup")
public class Setup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "setupID", length = 11)
    private int setupId;

    @Column(name = "setupname")
    private String setupName;
    @Column(name = "setupflpsi")
    private float setupFLPsi;
    @Column(name = "setupfrpsi")
    private float setupFRPsi;
    @Column(name = "setuplpsi")
    private float setupRLPsi;
    @Column(name = "setuprrpsi")
    private float setupRRPsi;
    @Column(name = "setupfltoe")
    private float setupFLToe;
    @Column(name = "setupfrtoe")
    private float setupFRToe;
    @Column(name = "setuprltoe")
    private float setupRLToe;
    @Column(name = "setuprrtoe")
    private float setupRRToe;
    @Column(name = "setupflcamber")
    private float setupFLCamber;
    @Column(name = "setupfrcamber")
    private float setupFRCamber;
    @Column(name = "setuprlcamber")
    private float setupRLCamber;
    @Column(name = "setuprrcamber")
    private float setupRRCamber;
    @Column(name = "setupflcaster")
    private float setupFLCaster;
    @Column(name = "setupfrcaster")
    private float setupFRCaster;
    @Column(name = "setup_desc")
    private String setupDesc;

    @ManyToMany
    private List<Weather> weathers;

    @ManyToMany
    private List<Condition> conditions;

    @ManyToOne
    @JoinColumn(name = "sessionid", nullable = false)
    private Session session;

    public Setup(int setupId, String setupName, float setupFLPsi, float setupFRPsi, float setupRLPsi, float setupRRPsi, float setupFLToe, float setupFRToe, float setupRLToe, float setupRRToe, float setupFLCamber, float setupFRCamber, float setupRLCamber, float setupRRCamber, float setupFLCaster, float setupFRCaster, String setupDesc, List<Weather> weathers, List<Condition> conditions, Session session) {
        this.setupId = setupId;
        this.setupName = setupName;
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
        this.weathers = weathers;
        this.conditions = conditions;
        this.session = session;
    }

    public Setup() {

    }

    public int getSetupId() {
        return setupId;
    }

    public void setSetupId(int setupId) {
        this.setupId = setupId;
    }

    public String getSetupName() {
        return setupName;
    }

    public void setSetupName(String setupName) {
        this.setupName = setupName;
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

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
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
