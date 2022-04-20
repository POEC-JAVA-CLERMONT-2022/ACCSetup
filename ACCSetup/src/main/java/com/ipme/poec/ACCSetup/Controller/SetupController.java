package com.ipme.poec.ACCSetup.Controller;

import com.ipme.poec.ACCSetup.Model.*;
import com.ipme.poec.ACCSetup.Service.SessionService;
import com.ipme.poec.ACCSetup.Service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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


    @PostMapping("setups/add")   //mapping de la méthode
    public void createSetup(List<Integer> weatherIds, List<Integer> conditionIds, Integer id){
        setupService.createSetup(weatherIds,conditionIds,id);   //appel à la méthode de création du user dans le service, qui lui fait appel au repository
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
