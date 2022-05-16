package com.ipme.poec.accsetup;

import com.ipme.poec.accsetup.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccSetupApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

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
