package com.ipme.poec.ACCSetup.Controller;

import com.ipme.poec.ACCSetup.Model.User;
import com.ipme.poec.ACCSetup.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

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

}
