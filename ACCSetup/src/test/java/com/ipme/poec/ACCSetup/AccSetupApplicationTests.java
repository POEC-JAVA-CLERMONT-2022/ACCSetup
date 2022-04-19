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
    void creationSaveUserTest() {
        //Instanciation des données
        String name = "test";
        String nameKo = "testKo";
        String password = "pass";
        String passKo = null;
        //Appel de la méthode à tester
        User user1 = new User(1, name, password);
        User user2 = new User(2, nameKo, passKo);
        userService.saveUser(user1);
        try {
            userService.saveUser(user2);
        } catch (ConstraintViolationException constraintViolationException) {

        }

        //test des valeurs après exécution du code
        User userTest = userService.getById(2);
        User userTest2 = userService.getById(3);

        assertThat(userTest.getUserName()).isEqualTo("test");
        assertThat(userTest.getUserName()).isNotEqualTo("nameKo");
    }

    @Test
    void creationCreateUserTest() {
        userService.createUser("monculsurlacommode", "pass");
        User userTest = userService.getById(6);
        assertThat(userTest.getUserName()).isEqualTo("monculsurlacommode");
    }

    @Test
    void creationValidSessionTest() {


        Car carTest = new Car("Citronault Pipo");
        sessionService.saveCar(carTest);
        Track trackTest = new Track("Charade");
        sessionService.saveTrack(trackTest);
        User userTest2 = new User("validName", "validPassword");
        userService.saveUser(userTest2);

        sessionService.createSession("validSessionTest", LocalDate.parse("2022-04-01"), trackTest, carTest, userTest2);
        Session sessionTest = sessionService.getSessionById(2);
        assertThat(sessionTest.getSessionDate()).isEqualTo(LocalDate.parse("2022-04-01"));


    }

    @Test
    void creationValidSetupTest() {


        //Instanciation des données
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
        Session sessionTest = sessionService.getSessionById(2);

        setupService.createSetup(weatherIds, conditionIds, sessionTest);
        Setup setupTest = setupService.getSetupById(1);

        assertThat(setupTest.getSession()).isEqualTo(sessionTest);


    }

    @Test
    void updateUserNameTest() {
        userService.createUser("HuileDeCul", "pass");
        User userTest = userService.getById(4);
        userService.updateUserName(userTest, "FranckyVincent");
        assertThat(userTest.getUserName()).isEqualTo("FranckyVincent");
    }

    @Test
    void updateSessionUpdateTest(){
        Car carTest = new Car("Renault Fuego");
        sessionService.saveCar(carTest);
        Track trackTest = new Track("Nogaro");
        sessionService.saveTrack(trackTest);
        User userTest2 = new User("UwU", "Password");
        userService.saveUser(userTest2);

        sessionService.createSession("validSession", LocalDate.parse("2022-04-01"), trackTest, carTest, userTest2);
        Session sessionToUpdate = sessionService.getSessionById(1);
        sessionService.updateSession(sessionToUpdate,"VraimentUneSessionValide",LocalDate.parse("2023-01-01"));

        assertThat(sessionToUpdate.getSessionName()).isEqualTo("VraimentUneSessionValide");
        assertThat(sessionToUpdate.getSessionDate()).isEqualTo(LocalDate.parse("2023-01-01"));

    }

    @Test
    void updateSetupUpdateTest(){

    }

}



