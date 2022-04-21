package com.ipme.poec.ACCSetup;


import com.ipme.poec.ACCSetup.Model.User;
import com.ipme.poec.ACCSetup.Service.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class UserTests {

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private TrackService trackService;


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
    void saveUserTest() {
        String name = "test";
        String password = "pass";

        User user1 = new User(1, name, password);
        userService.saveUser(user1);

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
    void updateUserNameTest() {
        userService.createUser("HuileDeCul", "pass");
        User userTest = userService.getByName("HuileDeCul");
        userService.updateUserName(userTest, "FranckyVincent");
        assertThat(userTest.getUserName()).isEqualTo("FranckyVincent");
    }

    @Test
    void updateUserPasswordTest() {
        userService.createUser("TourneJos?", "pass");
        User userTest = userService.getByName("TourneJos?");
        userService.updateUserPassword(userTest, "FranckyVincent");
        User userToBeTested = userService.getByName("TourneJos?");
        assertThat(userToBeTested.getUserPassword()).isEqualTo("FranckyVincent");
    }

    @Test
    void getUserNameTest() {
        User userTest2 = new User("UwU", "Password");
        userService.saveUser(userTest2);

        User userToTest = userService.getByName("UwU");
        assertThat(userToTest.getUserName()).isEqualTo("UwU");
    }
}
