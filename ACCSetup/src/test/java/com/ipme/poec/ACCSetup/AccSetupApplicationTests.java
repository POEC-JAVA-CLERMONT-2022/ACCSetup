package com.ipme.poec.ACCSetup;

import com.ipme.poec.ACCSetup.Model.Session;
import com.ipme.poec.ACCSetup.Model.User;
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

import javax.validation.ConstraintViolationException;
import java.nio.charset.Charset;

@SpringBootTest
class AccSetupApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private SetupService setupService;

    @Autowired
    private SessionService sessionService;

    @Test
    void userLoading() {
        //Instanciation des données
        this.userService.deleteAllUsers();
        String name = "test";
        String nameKo = "testKo";
        String password = "pass";
        String passKo = null;
        //Appel de la méthode à tester
        User user1 = new User(1,name,password);
        User user2 = new User(2,nameKo,passKo);
        userService.saveUser(user1);
//        userService.saveUser(user2);
        //test des valeurs après exécution du code
//        Assertions.assertEquals(1,userService.getById(1));
//        Assertions.assertThrows(ConstraintViolationException.class, () -> {user2.getUserPassword();});
//        Assertions.assertNotEquals(2,userService.getById(2));
        Assert.assertEquals("test",user1.getUserName());
        Assert.assertNotEquals("nameKo",user2.getUserName());

    }


}
