package com.ipme.poec.ACCSetup;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
<<<<<<< HEAD
import org.springframework.context.event.EventListener;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
=======
>>>>>>> 4e80c2a4280e14a76f2499602236acc495c36955

@SpringBootApplication
public class AccSetupApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

<<<<<<< HEAD
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Autowired
    private SessionService sessionService;

    @Autowired
    private SetupService setupService;

    @Autowired
    private DisplayService displayService;

    @Autowired
    private UserService userService;


    public static void main(String[] args) {
        SpringApplication.run(AccSetupApplication.class, args);

    }
=======

	public static void main(String[] args) {
		SpringApplication.run(AccSetupApplication.class, args);

	}
>>>>>>> 4e80c2a4280e14a76f2499602236acc495c36955

}
