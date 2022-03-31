package com.ipme.poec.ACCSetup.Controller;

import com.ipme.poec.ACCSetup.Model.*;
import com.ipme.poec.ACCSetup.Service.SessionService;
import com.ipme.poec.ACCSetup.Service.SetupService;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class SetupController {

    @Autowired
    private SetupService setupService;

    @Autowired
    private SessionService sessionService;


    @GetMapping("setups/search")
    public List<Setup> getSetups(){
        return setupService.findAll();
    }


    @EventListener(classes = {ApplicationStartedEvent.class}) //méthode qui se lance au départ de l'application
    @PostMapping("setups/add")   //mapping de la méthode
    public void createSetup(){

        List<Weather> weathers = new LinkedList<>();
        Weather weather = setupService.getWeatherById(1);
        weathers.add(weather);
        List<Condition> conditions = new LinkedList<>();

        Session session = sessionService.getSessionById(1);
        System.out.println("Setup ajouté");
        Setup setup = new Setup(1,2,3,4,5,6,7,8,9,10,11,12,13,14,"test",weathers,conditions,session);
        setupService.createSetup(setup);   //appel à la méthode de création du user dans le service, qui lui fait appel au repository
    }

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
