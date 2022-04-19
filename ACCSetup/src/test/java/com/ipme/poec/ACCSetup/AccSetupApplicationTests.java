package com.ipme.poec.ACCSetup;

import com.ipme.poec.ACCSetup.Model.*;
import com.ipme.poec.ACCSetup.Service.SessionService;
import com.ipme.poec.ACCSetup.Service.SetupService;
import com.ipme.poec.ACCSetup.Service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
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

    @Test
    void creationSaveUserTest() {
        //Instanciation des données
        this.userService.deleteAllUsers();
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
        User userTest = userService.getById(1);
        User userTest2 = userService.getById(2);

        assertThat(userTest.getUserName()).isEqualTo("test");
        assertThat(userTest.getUserName()).isNotEqualTo("nameKo");
    }

    @Test
    void creationCreateUserTest() {
        this.userService.deleteAllUsers();
        userService.createUser("monculsurlacommode", "pass");
        User userTest = userService.getById(1);
        assertThat(userTest.getUserName()).isEqualTo("monculsurlacommode");
    }

    @Test
    void creationValidSessionTest() {

        Car carTest = new Car(1, "Citronault Pipo");
        sessionService.saveCar(carTest);
        Track trackTest = new Track(1, "Charade");
        sessionService.saveTrack(trackTest);
        User userTest = new User(1, "validName", "validPassword");
        userService.saveUser(userTest);

        sessionService.createSession("validSessionTest", LocalDate.parse("2022-04-01"), 1, 1, 1);
        Session sessionTest = sessionService.getSessionById(1);
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

        Car carTest = new Car(1, "Citronault Pipo");
        sessionService.saveCar(carTest);
        Track trackTest = new Track(1, "Charade");
        sessionService.saveTrack(trackTest);
        User userTest = new User(1, "validName", "validPassword");
        userService.saveUser(userTest);
        sessionService.createSession("validSessionTest", LocalDate.parse("2022-04-01"), 1, 1, 1);
        Session sessionTest = sessionService.getSessionById(1);
        Setup setupTest = setupService.getSetupById(1);

        //Appel de la méthode à tester
        setupService.createSetup(weatherIds, conditionIds, 1);

        //test des valeurs après exécution du code
        assertThat(setupTest.getSession()).isEqualTo(sessionTest);


    }


}
