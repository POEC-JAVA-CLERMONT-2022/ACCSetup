package com.ipme.poec.ACCSetup;

import com.ipme.poec.ACCSetup.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;

@SpringBootTest
class AccSetupApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }


}
