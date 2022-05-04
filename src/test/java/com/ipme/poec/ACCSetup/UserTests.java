package com.ipme.poec.ACCSetup;


import com.ipme.poec.ACCSetup.Model.User;
import com.ipme.poec.ACCSetup.Service.*;
import com.ipme.poec.ACCSetup.Service.dto.CreateUserDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

@SpringBootTest
@Transactional
class UserTests {

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
        //on initialise les donnees de nos users, le KO est fait pour planter
        String name = "test";
        String password = "pass";
        String nameKo = "testKO";
        String passKo = null;

        //on cree nos entites
        User user1 = new User(name, password);
        User user2 = new User(nameKo, passKo);
        //on sauvegarde en base l'utilisateur valide
        userService.saveUser(user1);
        //on recupere l'utilisateur valide en base
        User userTest = userService.getByName("test");
        //on teste la relation entre entite locale et base de donnees
        assertThat(userTest.getUserName()).isEqualTo("test");
        //on teste de charger l'utilisateur invalide en recuperant l'exception attendue
        Exception exception = assertThrows(ConstraintViolationException.class, () -> {
            userService.saveUser(user2);
        });
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
        userService.createUser("TourneJose", "pass");
        User userTest = userService.getByName("TourneJose");
        userService.updateUserPassword(userTest, "FranckyVincent");
        User userToBeTested = userService.getByName("TourneJose");
        assertThat(userToBeTested.getUserPassword()).isEqualTo("FranckyVincent");
    }

    @Test
    void getUserNameTest() {
        User userTest2 = new User("UwU", "Password");
        userService.saveUser(userTest2);

        User userToTest = userService.getByName("UwU");
        assertThat(userToTest.getUserName()).isEqualTo("UwU");
    }

    @Test
    void deleteUserTest() {
        userService.createUser("RandomDuStunfest", "sbire");
        User userToDelete = userService.getByName("RandomDuStunfest");
        userService.deleteUser(userToDelete.getUserId());
        List<User> users = userService.findAll();
        assertThat(users.contains(userToDelete)).isFalse();
    }


}
