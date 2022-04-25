package com.ipme.poec.ACCSetup.Service;

import java.util.List;
import java.util.Optional;

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
    } //méthode pour obtenir tous les users

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    } //méthode pour obtenir un user selon son userId

    public User getById(Integer id) {
        return userRepository.getById(id);
    }

    public User getByName(String name) {
        return userRepository.getByUserName(name);
    }
//	public void createUser(User user) { userRepository.saveAndFlush(user); } //méthode de création d'un user

    public void createUser(String name, String password) {
        User user = new User();
        user.setUserName(name);
        user.setUserPassword(password);
        userRepository.saveAndFlush(user);
    }


    public void saveUser(User user) {
        userRepository.saveAndFlush(user);
    }


//	public void connectUser(String name, String password) {
//		User user =  new User (name,password);
//		userRepository.getById();
//	}

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    } //méthode de suppression d'un user, selon son userId

    public void deleteUserbyName(String name) {
        userRepository.deleteByUserName(name);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    } //Suppression de tous les users

    public void updateUserName(User user, String userNameUpdate) {
        user.setUserName(userNameUpdate);
        userRepository.save(user);
    }

    public void updateUserPassword(User user, String userPassword){
        user.setUserPassword(userPassword);
        userRepository.save(user);
    }



}

