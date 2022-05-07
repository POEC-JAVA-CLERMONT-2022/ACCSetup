package com.ipme.poec.ACCSetup.Controller;

import com.ipme.poec.ACCSetup.Model.User;
import com.ipme.poec.ACCSetup.Service.UserService;
import com.ipme.poec.ACCSetup.Service.dto.user.UserDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping(value = "/add", produces = "application/json")   //mapping de la méthode
    public void createUser(String name, String password) {
        userService.createUser(name, password);   //appel à la méthode de création du user dans le service, qui lui fait appel au repository
    }

    @PutMapping(value = "/nameEdit", consumes = "application/json", produces = "application/json")
    public void updateUserName(User user, String name) {
        userService.updateUserName(user, name);
    }

    @PutMapping(value = "/passwordEdit", consumes = "application/json", produces = "application/json")
    public void updateUserPassword(User user, String password) {
        userService.updateUserPassword(user, password);
    }

    @DeleteMapping(value = "/delete", consumes = "application/json")
    public void deleteUser(User user) {
        userService.deleteUser(user.getUserId());
    }



}
