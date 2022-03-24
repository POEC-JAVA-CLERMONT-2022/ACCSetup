package com.ipme.poec.ACCSetup.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sessionID")
    private int sessionId;

    @Column(name = "sessionNAME")
    private String sessionName;

    @Column(name = "sessionDATE")
    private LocalDate sessionDate;

    public Session(String sessionName, LocalDate sessionDate) {
        this.sessionName = sessionName;
        this.sessionDate = sessionDate;
    }

    public Session() {

    }

    public int getSessionID() {
        return sessionId;
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
