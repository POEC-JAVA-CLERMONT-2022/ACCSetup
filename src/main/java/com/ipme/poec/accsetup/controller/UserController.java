package com.ipme.poec.accsetup.controller;

import com.ipme.poec.accsetup.model.User;
import com.ipme.poec.accsetup.service.UserService;
import com.ipme.poec.accsetup.service.dto.CreateUserDTO;
import com.ipme.poec.accsetup.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping()
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("users")
    @ResponseBody()
    public List<UserDTO> getUsersDTO() {
        //...
        List<User> users = userService.findAll();
        List<UserDTO> usersDTO = new LinkedList<>();
        for (int i=0; i < users.size(); i++){
            User userToConvert = users.get(i);
            UserDTO userConverted = userService.convertToDto(userToConvert);
            usersDTO.add(userConverted);
        }
        return usersDTO;
    }

    @PostMapping(value = "user", produces = "application/json")
    public void createUserFromDTO(String name, String password) {
        CreateUserDTO createUserDTO = new CreateUserDTO(name,password);
        User user = userService.convertCreationDtoToUser(createUserDTO);
        userService.saveUser(user);   //appel à la méthode de création du user dans le service, qui lui fait appel au repository
    }

    @PutMapping(value = "user/name/{userId}", consumes = "application/json", produces = "application/json")
    public void updateUserName(@PathVariable int userId, User user, String name) {
        userService.updateUserName(user, name);
    }

    @PutMapping(value = "user/password/{userId}", consumes = "application/json", produces = "application/json")
    public void updateUserPassword(@PathVariable int userId, User user, String password) {
        userService.updateUserPassword(user, password);
    }

    @DeleteMapping(value = "user/{userId}", consumes = "application/json")
    public void deleteUser(@PathVariable int userId, @RequestBody User user){
        User userToDelete = userService.getById(userId);
        userService.deleteUser(userToDelete.getUserId());
    }



}
