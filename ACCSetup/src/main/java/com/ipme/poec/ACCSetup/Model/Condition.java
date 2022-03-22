package com.ipme.poec.ACCSetup.Model;

import javax.persistence.*;

@Entity
@Table(name = "trackCondition")
public class Condition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int trackconditionId;

    @Column (name = "trackconditionNAME")
    private String trackconditionName;


    public Condition(int trackconditionId, String trackconditionName) {
        this.trackconditionId = trackconditionId;
        this.trackconditionName = trackconditionName;
    }

    public Condition() {

    }

    public int getTrackconditionId() {
        return trackconditionId;
    }

    public void setTrackconditionId(int trackconditionId) {
        this.trackconditionId = trackconditionId;
    }

    public String getTrackconditionName() {
        return trackconditionName;
    }

    public void setTrackconditionName(String trackconditionName) {
        this.trackconditionName = trackconditionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Condition condition = (Condition) o;

        return trackconditionId == condition.trackconditionId;
    }

    @Override
    public int hashCode() {
        return trackconditionId;
    }
}
