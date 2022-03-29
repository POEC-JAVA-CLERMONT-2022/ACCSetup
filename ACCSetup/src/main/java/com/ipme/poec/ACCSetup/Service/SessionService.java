package com.ipme.poec.ACCSetup.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipme.poec.ACCSetup.Model.Session;
import com.ipme.poec.ACCSetup.Repository.CarRepository;
import com.ipme.poec.ACCSetup.Repository.SessionRepository;
import com.ipme.poec.ACCSetup.Repository.TrackRepository;

@Service
public class SessionService {


	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private TrackRepository trackRepository;
	
	
	public List<Session> findAll() {
		return sessionRepository.findAll();
	}
	
	
}
