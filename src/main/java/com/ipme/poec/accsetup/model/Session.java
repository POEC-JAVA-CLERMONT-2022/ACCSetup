package com.ipme.poec.accsetup.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Entity
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sessionid", length = 11)
    private int sessionId;

    @Column(name = "sessionname", length = 255)
    @NotNull
    @NotBlank(message = "La nom de session est obligatoire")
    private String sessionName;

    @Column(name = "sessiondate")
    @NotNull
    @PastOrPresent
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate sessionDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trackid")
    private Track track;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carID")
    private Car car;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Session(String sessionName, LocalDate sessionDate, Track track, Car car,User user) {
        this.sessionName = sessionName;
        this.sessionDate = sessionDate;
        this.track = track;
        this.car = car;
        this.user = user;
    }

    public Session(int sessionId, String sessionName, LocalDate sessionDate, Track track, Car car,User user) {
        this.sessionId = sessionId;
        this.sessionName = sessionName;
        this.sessionDate = sessionDate;
        this.track = track;
        this.car = car;
        this.user = user;
    }

    public Session() {

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
