package com.ipme.poec.ACCSetup.Model;

public class SetupCondition {

    private int setupId;
    private int conditionId;

    public SetupCondition(int setupId, int conditionId) {
        this.setupId = setupId;
        this.conditionId = conditionId;
    }

    public int getSetupId() {
        return setupId;
    }

    public void setSetupId(int setupId) {
        this.setupId = setupId;
    }

    public int getConditionId() {
        return conditionId;
    }

    public void setConditionId(int conditionId) {
        this.conditionId = conditionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SetupCondition that = (SetupCondition) o;

        if (setupId != that.setupId) return false;
        return conditionId == that.conditionId;
    }

    @Override
    public int hashCode() {
        int result = setupId;
        result = 31 * result + conditionId;
        return result;
    }


}
