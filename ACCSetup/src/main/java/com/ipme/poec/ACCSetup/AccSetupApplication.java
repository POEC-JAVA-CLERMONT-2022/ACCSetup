package com.ipme.poec.ACCSetup;

import com.ipme.poec.ACCSetup.Service.ACCsetupService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccSetupApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccSetupApplication.class, args);
//		ACCsetupService accSetupService = new ACCsetupService();
//		accSetupService.run();
	}

}
