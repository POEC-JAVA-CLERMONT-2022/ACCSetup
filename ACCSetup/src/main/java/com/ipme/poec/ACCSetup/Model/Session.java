package com.ipme.poec.ACCSetup.Model;

import java.time.LocalDate;

public class Session {
    private int sessionId;
    private String sessionName;
    private LocalDate sessionDate;

    public Session(int sessionId, String sessionName, LocalDate sessionDate) {
        this.sessionId = sessionId;
        this.sessionName = sessionName;
        this.sessionDate = sessionDate;
    }

    public int getSessionID() {
        return sessionId;
    }

    public void setSessionID(int sessionID) {
        this.sessionId = sessionID;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDate sessionDate) {
        this.sessionDate = sessionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Session session = (Session) o;

        return sessionId == session.sessionId;
    }

    @Override
    public int hashCode() {
        return sessionId;
    }


}
