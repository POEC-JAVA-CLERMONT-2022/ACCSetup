package com.ipme.poec.ACCSetup.Service;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.ipme.poec.ACCSetup.Service.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipme.poec.ACCSetup.Model.User;
import com.ipme.poec.ACCSetup.Repository.SessionRepository;
import com.ipme.poec.ACCSetup.Repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {


    @Autowired
    private UserRepository userRepository;


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public User getById(Integer id) {
        return userRepository.getById(id);
    }

    public User getByName(String name) {
        return userRepository.getByUserName(name);
    }

    public void createUser(String name, String password) {
        User user = new User();
        user.setUserName(name);
        user.setUserPassword(password);
        userRepository.saveAndFlush(user);
    }

    public void saveUser(User user) {
        userRepository.saveAndFlush(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public void deleteUserbyName(String name) {
        userRepository.deleteByUserName(name);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    public void updateUserName(User user, String userNameUpdate) {
        user.setUserName(userNameUpdate);
        userRepository.save(user);
    }

    public void updateUserPassword(User user, String userPassword) {
        user.setUserPassword(userPassword);
        userRepository.save(user);
    }

    public UserDTO convertToDto(User user) {
        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    public List<UserDTO> convertUsersToDTO(List<User> users){
        if (users != null){
            List<UserDTO> userDTOS = new LinkedList<>();
            for (User user : users){
                UserDTO userDTO = convertToDto(user);
                userDTOS.add(userDTO);
            }
            return userDTOS;
        }
        else {
            return null; //ajout d'exception (pas de users à convertir)?
        }
    }

    public User convertToUser(UserDTO userDTO) throws ParseException {
    	ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDTO, User.class);
        User oldUser = userRepository.getById(userDTO.getId());
        user.setUserName(oldUser.getUserName());
        user.setUserPassword(oldUser.getUserPassword());
        return user;
    }

}

