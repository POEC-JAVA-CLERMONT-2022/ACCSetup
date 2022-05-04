package com.ipme.poec.ACCSetup;

import com.ipme.poec.ACCSetup.Service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AccSetupApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Autowired
    private SessionService sessionService;

    @Autowired
    private SetupService setupService;

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(AccSetupApplication.class, args);

    }
}
