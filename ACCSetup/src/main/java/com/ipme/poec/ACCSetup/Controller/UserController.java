package com.ipme.poec.ACCSetup.Controller;

import com.ipme.poec.ACCSetup.Model.User;
import com.ipme.poec.ACCSetup.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    @GetMapping("users/search")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @PostMapping("users/add")   //mapping de la méthode
    public void createUser(String name, String password){
        userService.createUser(name,password);   //appel à la méthode de création du user dans le service, qui lui fait appel au repository
    }

//    @PostMapping("users/add")
//    public User create(){
//        return userService.createUser();
//    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }

    // standard constructors / other methods
}
