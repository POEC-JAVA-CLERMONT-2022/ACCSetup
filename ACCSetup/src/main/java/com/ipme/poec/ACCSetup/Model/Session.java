package com.ipme.poec.ACCSetup.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sessionid", length = 11)
    private int sessionId;

    @Column(name = "sessionname", length = 255)
    private String sessionName;

    @Column(name = "sessiondate")
    private LocalDate sessionDate;

    @OneToOne
    @JoinColumn(name = "trackid")
    private Track track;

    @OneToOne
    @JoinColumn(name = "carid")
    private Car car;

    public Session(int sessionId, String sessionName, LocalDate sessionDate, Track track, Car car) {
        this.sessionId = sessionId;
        this.sessionName = sessionName;
        this.sessionDate = sessionDate;
        this.track = track;
        this.car = car;
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

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
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
