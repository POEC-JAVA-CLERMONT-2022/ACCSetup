package com.ipme.poec.ACCSetup.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.ipme.poec.ACCSetup.Model.Session;
import com.ipme.poec.ACCSetup.Repository.SessionRepository;

@ExtendWith(MockitoExtension.class)
class SessionServiceTest {
	
	@Mock private SessionRepository mockedSessionRepository;
	
	@Autowired
	private SessionService sessionService;
	

	@Test
	void testCreateSession() {
		
		when(mockedSessionRepository.save(Mockito.any(Session.class))).thenReturn(new Session(0, null, null, null, null, null));
		Session testSession = sessionService.createSession("sessionTest", LocalDate.now(), null, null, null);
		// test null
		assertNotNull(testSession);
		
		
	}

}

