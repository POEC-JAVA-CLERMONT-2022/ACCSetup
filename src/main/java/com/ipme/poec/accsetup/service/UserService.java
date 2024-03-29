package com.ipme.poec.accsetup.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.ipme.poec.accsetup.service.dto.CreateUserDTO;
import com.ipme.poec.accsetup.service.dto.UpdateUserNameDTO;
import com.ipme.poec.accsetup.service.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipme.poec.accsetup.model.User;
import com.ipme.poec.accsetup.repository.UserRepository;
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

    public void updateUserName(User user, String name) {
        UpdateUserNameDTO updateUserNameDTO = new UpdateUserNameDTO(name);
        user.setUserName(updateUserNameDTO.getName());
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

    public List<UserDTO> convertUsersToDTO(List<User> users){       //conversion liste user vers DTO
        if (users != null){                                         //si on trouve des users
            List<UserDTO> userDTOS = new LinkedList<>();            //on crée la liste de DTO
            for (User user : users){                                //pour chaque user de la liste
                UserDTO userDTO = convertToDto(user);               //on crée un DTO à partir du user
                userDTOS.add(userDTO);                              //on ajoute le DTO à la liste
            }
            return userDTOS;                                        //on renvoie la liste de DTO
        }
        else {
            return null; //ajout d'exception (pas de users à convertir)?
        }
    }

    public User convertToUser(UserDTO userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDTO, User.class);
        user.setUserName(userDTO.getName());
        user.setUserPassword(userDTO.getPassword());
        return user;
    }

    public User convertCreationDtoToUser(CreateUserDTO createUserDTO){
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(createUserDTO, User.class);
        user.setUserName(createUserDTO.getName());
        user.setUserPassword(createUserDTO.getPassword());
        return user;
    }


}

