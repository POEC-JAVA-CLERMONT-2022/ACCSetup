package com.ipme.poec.ACCSetup.Controller;

import com.ipme.poec.ACCSetup.Model.User;
import com.ipme.poec.ACCSetup.Service.UserService;
import com.ipme.poec.ACCSetup.Service.dto.CreateUserDTO;
import com.ipme.poec.ACCSetup.Service.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
        user = userService.getById(userId);
        userService.deleteUser(user.getUserId());
    }



}
