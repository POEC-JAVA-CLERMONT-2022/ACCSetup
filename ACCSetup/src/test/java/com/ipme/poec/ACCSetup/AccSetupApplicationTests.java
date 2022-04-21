package com.ipme.poec.ACCSetup;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.ipme.poec.ACCSetup.Model.*;
import com.ipme.poec.ACCSetup.Service.SessionService;
import com.ipme.poec.ACCSetup.Service.SetupService;
import com.ipme.poec.ACCSetup.Service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
//TODO: plusieurs classes
//TODO: mettre en place des TU
class AccSetupApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private SetupService setupService;

    @Autowired
    private SessionService sessionService;

    @BeforeEach
    void beforeEach() {
        this.userService.deleteAllUsers();
        this.sessionService.deleteAllSessions();
        this.sessionService.deleteAllCars();
        this.sessionService.deleteAllTracks();


    }

    @AfterEach
    void afterEach() {

    }

    @Test
    void saveUserTest() {
        //Instanciation des donn�es
        String name = "test";
        String password = "pass";
        //Appel de la m�thode � tester
        User user1 = new User(1, name, password);
        userService.saveUser(user1);

        //test des valeurs apr�s ex�cution du code
        User userTest = userService.getByName("test");

        assertThat(userTest.getUserName()).isEqualTo("test");
    }

    @Test
    void createUserTest() {
        userService.createUser("monculsurlacommode", "pass");
        User userTest = userService.getByName("monculsurlacommode");
        assertThat(userTest.getUserName()).isEqualTo("monculsurlacommode");
    }

    @Test
    void createSessionTest() {


        Car carTest = new Car("Citronault Pipo");
        sessionService.saveCar(carTest);
        Track trackTest = new Track("Charade");
        sessionService.saveTrack(trackTest);
        User userTest2 = new User("validName", "validPassword");
        userService.saveUser(userTest2);

        sessionService.createSession("validSessionTest", LocalDate.parse("2022-04-01"), trackTest, carTest, userTest2);
        Session sessionTest = sessionService.getSessionByName("validSessionTest");
        assertThat(sessionTest.getSessionDate()).isEqualTo(LocalDate.parse("2022-04-01"));


    }

    @Test
    void createSetupTest() {


        //Instanciation des donn�es
        Weather weatherTest = new Weather(1, "SUNNY");
        List<Integer> weatherIds = new LinkedList<>();
        weatherIds.add(1);
        setupService.saveWeather(weatherTest);

        Condition conditionTest = new Condition(1, "OPTIMAL");
        List<Integer> conditionIds = new LinkedList<>();
        conditionIds.add(1);
        setupService.saveCondition(conditionTest);

        Car carTest2 = new Car("Fiat Multipla");
        sessionService.saveCar(carTest2);
        Track trackTest2 = new Track("Charade");
        sessionService.saveTrack(trackTest2);
        User userTest3 = new User("validName", "validPassword");
        userService.saveUser(userTest3);
        sessionService.createSession("validSessionTest2", LocalDate.parse("2022-04-02"), trackTest2, carTest2, userTest3);
        Session sessionTest = sessionService.getSessionByName("validSessionTest2");

        setupService.createSetup("valid_setup", weatherIds, conditionIds, sessionTest);
        Setup setupTest = setupService.getSetupByName("valid_setup");

        assertThat(setupTest.getSession()).isEqualTo(sessionTest);


    }

    @Test
    void updateUserNameTest() {
        userService.createUser("HuileDeCul", "pass");
        User userTest = userService.getByName("HuileDeCul");
        userService.updateUserName(userTest, "FranckyVincent");
        assertThat(userTest.getUserName()).isEqualTo("FranckyVincent");
    }

    @Test
    void updateUserPasswordTest() {
        userService.createUser("TourneJos�", "pass");
        User userTest = userService.getByName("TourneJos�");
        userService.updateUserPassword(userTest, "FranckyVincent");
        User userToBeTested = userService.getByName("TourneJos�");
        assertThat(userToBeTested.getUserPassword()).isEqualTo("FranckyVincent");
    }

    @Test
    void updateSessionTest() {
        Car carTest = new Car("Renault Fuego");
        sessionService.saveCar(carTest);
        Track trackTest = new Track("Nogaro");
        sessionService.saveTrack(trackTest);
        User userTest2 = new User("UwU", "Password");
        userService.saveUser(userTest2);

        sessionService.createSession("validSession", LocalDate.parse("2022-04-01"), trackTest, carTest, userTest2);
        Session sessionToUpdate = sessionService.getSessionByName("validSession");
        sessionService.updateSession(sessionToUpdate, "VraimentUneSessionValide", LocalDate.parse("2023-01-01"));

        assertThat(sessionToUpdate.getSessionName()).isEqualTo("VraimentUneSessionValide");
        assertThat(sessionToUpdate.getSessionDate()).isEqualTo(LocalDate.parse("2023-01-01"));

    }

    @Test
    void updateSetupTest() {
        //Instanciation des donn�es
        Weather weatherTest = new Weather(1, "SUNNY");
        List<Integer> weathers = new LinkedList<>();
        weathers.add(1);
        setupService.saveWeather(weatherTest);

        Condition conditionTest = new Condition(1, "OPTIMAL");
        List<Integer> conditions = new LinkedList<>();
        conditions.add(1);
        setupService.saveCondition(conditionTest);

        Car carTest2 = new Car("Fiat Multipla");
        sessionService.saveCar(carTest2);
        Track trackTest2 = new Track("Charade");
        sessionService.saveTrack(trackTest2);
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
    void getUserNameTest() {
        User userTest2 = new User("UwU", "Password");
        userService.saveUser(userTest2);

        User userToTest = userService.getByName("UwU");
        assertThat(userToTest.getUserName()).isEqualTo("UwU");
    }

    @Test
    void getSessionNameTest() {
        Car carTest = new Car("Citronault Pipo");
        sessionService.saveCar(carTest);
        Track trackTest = new Track("Charade");
        sessionService.saveTrack(trackTest);
        User userTest2 = new User("validName", "validPassword");
        userService.saveUser(userTest2);

        sessionService.createSession("validSessionTest", LocalDate.parse("2022-04-01"), trackTest, carTest, userTest2);
        Session sessionTest = sessionService.getSessionByName("validSessionTest");
        assertThat(sessionTest.getSessionDate()).isEqualTo(LocalDate.parse("2022-04-01"));
    }

//    @Test
//    void deleteUserTest() {
//        User userToDelete = new User(200,"UwU", "Password");
//        userService.saveUser(userToDelete);
//        User userToTest = new User("UwU", "Password");
//        userService.deleteUser(200);
//        assertThat(userService.getByName("UwU")).isEqualTo(userToTest);
//    }

}



