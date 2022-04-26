package com.ipme.poec.ACCSetup;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.ipme.poec.ACCSetup.Model.User;
import com.ipme.poec.ACCSetup.Repository.SessionRepository;
import com.ipme.poec.ACCSetup.Repository.UserRepository;
import com.ipme.poec.ACCSetup.Service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

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
	private DisplayService displayService;

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(AccSetupApplication.class, args);

	}
}
