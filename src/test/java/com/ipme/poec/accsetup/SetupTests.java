package com.ipme.poec.accsetup;


import com.ipme.poec.accsetup.model.*;
import com.ipme.poec.accsetup.service.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class SetupTests {

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
    void createSetupTest() {


        //Instanciation des donn?es
        Weather weatherTest = new Weather(1, "SUNNY");
        List<Integer> weatherIds = new LinkedList<>();
        weatherIds.add(1);
        weatherService.saveWeather(weatherTest);

        Condition conditionTest = new Condition(1, "OPTIMAL");
        List<Integer> conditionIds = new LinkedList<>();
        conditionIds.add(1);
        conditionService.saveCondition(conditionTest);

        Car carTest2 = new Car("Fiat Multipla");
        carService.saveCar(carTest2);
        Track trackTest2 = new Track("Charade");
        trackService.saveTrack(trackTest2);
        User userTest3 = new User("validName", "validPassword");
        userService.saveUser(userTest3);
        sessionService.createSession("validSessionTest2", LocalDate.parse("2022-04-02"), trackTest2, carTest2, userTest3);
        Session sessionTest = sessionService.getSessionByName("validSessionTest2");

        setupService.createSetup("valid_setup", weatherIds, conditionIds, sessionTest);
        Setup setupTest = setupService.getSetupByName("valid_setup");

        assertThat(setupTest.getSession()).isEqualTo(sessionTest);
    }

    @Test
    void updateSetupTest() {
        //Instanciation des donn?es
        Weather weatherTest = new Weather(1, "SUNNY");
        List<Integer> weathers = new LinkedList<>();
        weathers.add(1);
        weatherService.saveWeather(weatherTest);

        Condition conditionTest = new Condition(1, "OPTIMAL");
        List<Integer> conditions = new LinkedList<>();
        conditions.add(1);
        conditionService.saveCondition(conditionTest);

        Car carTest2 = new Car("Fiat Multipla");
        carService.saveCar(carTest2);
        Track trackTest2 = new Track("Charade");
        trackService.saveTrack(trackTest2);
        User userTest3 = new User("validName", "validPassword");
        userService.saveUser(userTest3);
        sessionService.createSession("validSessionTest2", LocalDate.parse("2022-04-02"), trackTest2, carTest2, userTest3);
        Session sessionTest = sessionService.getSessionByName("validSessionTest2");

        setupService.createSetup("valid_setup", weathers, conditions, sessionTest);
        Setup setupToUpdate = setupService.getSetupByName("valid_setup");

        setupService.updateSetup(setupToUpdate, "VraimentUnSetupValide", 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, "Ceci est une description", weathers, conditions);

        Setup setupTest = setupService.getSetupByName("VraimentUnSetupValide");
        assertThat(setupTest.getSetupFLCamber()).isEqualTo(0.1f);
    }

    @Test
    void deleteSetupTest() {
        Weather weatherTest = new Weather(1, "SUNNY");
        List<Integer> weathers = new LinkedList<>();
        weathers.add(1);
        weatherService.saveWeather(weatherTest);

        Condition conditionTest = new Condition(1, "OPTIMAL");
        List<Integer> conditions = new LinkedList<>();
        conditions.add(1);
        conditionService.saveCondition(conditionTest);

        Car carTest2 = new Car("Fiat Multipla");
        carService.saveCar(carTest2);
        Track trackTest2 = new Track("Charade");
        trackService.saveTrack(trackTest2);
        User userTest3 = new User("validName", "validPassword");
        userService.saveUser(userTest3);
        sessionService.createSession("validSessionTest2", LocalDate.parse("2022-04-02"), trackTest2, carTest2, userTest3);
        Session sessionTest = sessionService.getSessionByName("validSessionTest2");

        setupService.createSetup("valid_setup", weathers, conditions, sessionTest);
        Setup setupToDelete = setupService.getSetupByName("valid_setup");

        setupService.deleteSetup(setupToDelete.getSetupId());

        List<Setup> setups = setupService.findAll();
        assertThat(setups.contains(setupToDelete)).isFalse();
    }
}
