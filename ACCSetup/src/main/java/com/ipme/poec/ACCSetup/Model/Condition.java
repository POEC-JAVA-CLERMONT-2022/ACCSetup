package com.ipme.poec.ACCSetup.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trackcondition")
public class Condition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trackconditionID")
    private int trackConditionId;

    @Column (name = "trackconditionNAME", length = 20)
    @NotNull
    private String trackConditionName;


    public Condition(String trackConditionName) {
        this.trackConditionName = trackConditionName;
    }


    public Condition() {

    }

    public int getTrackConditionId() {
        return trackConditionId;
    }

    public String getTrackConditionName() {
        return trackConditionName;
    }

    public void setTrackConditionName(String trackConditionName) {
        this.trackConditionName = trackConditionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Condition condition = (Condition) o;

        return trackConditionId == condition.trackConditionId;
    }

    @Override
    public int hashCode() {
        return trackConditionId;
    }
}
