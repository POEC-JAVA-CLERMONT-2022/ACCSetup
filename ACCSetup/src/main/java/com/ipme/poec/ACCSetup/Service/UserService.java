package com.ipme.poec.ACCSetup.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipme.poec.ACCSetup.Model.User;
import com.ipme.poec.ACCSetup.Repository.SessionRepository;
import com.ipme.poec.ACCSetup.Repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SessionRepository sessionRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
}
