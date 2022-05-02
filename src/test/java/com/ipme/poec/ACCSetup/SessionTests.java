package com.ipme.poec.ACCSetup;


import com.ipme.poec.ACCSetup.Model.Car;
import com.ipme.poec.ACCSetup.Model.Session;
import com.ipme.poec.ACCSetup.Model.Track;
import com.ipme.poec.ACCSetup.Model.User;
import com.ipme.poec.ACCSetup.Service.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class SessionTests {

    @Autowired
    private CarService carService;

    @Autowired
    private ConditionService conditionService;

    @Autowired
    private UserService userService;

    @Autowired
    private SetupService setupService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private TrackService trackService;

    @Autowired
    private WeatherService weatherService;

    @BeforeEach
    void beforeEach() {
        this.userService.deleteAllUsers();
        this.sessionService.deleteAllSessions();
        this.carService.deleteAllCars();
        this.trackService.deleteAllTracks();
    }

    @AfterEach
    void afterEach() {
    }

    @Test
    void createSessionTest() {
        Car carTest = new Car("Citronault Pipo");
        carService.saveCar(carTest);
        Track trackTest = new Track("Charade");
        trackService.saveTrack(trackTest);
        User userTest2 = new User("validName", "validPassword");
        userService.saveUser(userTest2);

        sessionService.createSession("validSessionTest", LocalDate.parse("2022-04-01"), trackTest, carTest, userTest2);
        Session sessionTest = sessionService.getSessionByName("validSessionTest");
        assertThat(sessionTest.getSessionDate()).isEqualTo(LocalDate.parse("2022-04-01"));
    }

    @Test
    void updateSessionTest() {
        Car carTest = new Car("Renault Fuego");
        carService.saveCar(carTest);
        Track trackTest = new Track("Nogaro");
        trackService.saveTrack(trackTest);
        User userTest2 = new User("UwU", "Password");
        userService.saveUser(userTest2);

        sessionService.createSession("validSession", LocalDate.parse("2022-04-01"), trackTest, carTest, userTest2);
        Session sessionToUpdate = sessionService.getSessionByName("validSession");
        sessionService.updateSession(sessionToUpdate, "VraimentUneSessionValide", LocalDate.parse("2023-01-01"));

        assertThat(sessionToUpdate.getSessionName()).isEqualTo("VraimentUneSessionValide");
        assertThat(sessionToUpdate.getSessionDate()).isEqualTo(LocalDate.parse("2023-01-01"));

    }

    @Test
    void getSessionNameTest() {
        Car carTest = new Car("Citronault Pipo");
        carService.saveCar(carTest);
        Track trackTest = new Track("Charade");
        trackService.saveTrack(trackTest);
        User userTest2 = new User("validName", "validPassword");
        userService.saveUser(userTest2);

        sessionService.createSession("validSessionTest", LocalDate.parse("2022-04-01"), trackTest, carTest, userTest2);
        Session sessionTest = sessionService.getSessionByName("validSessionTest");
        assertThat(sessionTest.getSessionDate()).isEqualTo(LocalDate.parse("2022-04-01"));
    }

    @Test
    void deleteSessionTest() {
        Car carTest = new Car("Citronault Pipo");
        carService.saveCar(carTest);
        Track trackTest = new Track("Charade");
        trackService.saveTrack(trackTest);
        User userTest2 = new User("validName", "validPassword");
        userService.saveUser(userTest2);

        sessionService.createSession("validSessionTest", LocalDate.parse("2022-04-01"), trackTest, carTest, userTest2);

        Session sessionToDelete = sessionService.getSessionByName("validSessionTest");

        sessionService.deleteSession(sessionToDelete.getSessionId());

        List<Session> sessions = sessionService.findAllSessions();

        assertThat(sessions.contains(sessionToDelete)).isFalse();
    }
}
