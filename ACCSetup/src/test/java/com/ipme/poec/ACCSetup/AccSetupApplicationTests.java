package com.ipme.poec.ACCSetup;

import com.ipme.poec.ACCSetup.Model.Car;
import com.ipme.poec.ACCSetup.Model.Session;
import com.ipme.poec.ACCSetup.Model.Track;
import com.ipme.poec.ACCSetup.Model.User;
import com.ipme.poec.ACCSetup.Service.SessionService;
import com.ipme.poec.ACCSetup.Service.SetupService;
import com.ipme.poec.ACCSetup.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
class AccSetupApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private SetupService setupService;

    @Autowired
    private SessionService sessionService;

    @Test
    void creationValidUserTest() {
        //userService.deleteUser(9999);
        User userTest = new User(9999,"validName","validPassword");
        userService.saveUser(userTest);
    }

    @Test
    void creationValidSessionTest(){
        Car carTest = sessionService.getCarById(1);
        Track trackTest = sessionService.getTrackById(1);
        User user = new User(9999,"validName","validPassword");
        userService.saveUser(user);
        User userTest = userService.getById(9999);
        sessionService.createSession("validSessionTest", LocalDate.parse("2022-04-01"),trackTest,carTest,userTest);
    }

    @Test
    void creationValidSetupTest() {

    }


}
