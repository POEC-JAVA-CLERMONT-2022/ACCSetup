package com.ipme.poec.ACCSetup.Controller;

import com.ipme.poec.ACCSetup.Model.Car;
import com.ipme.poec.ACCSetup.Model.Session;
import com.ipme.poec.ACCSetup.Model.Track;
import com.ipme.poec.ACCSetup.Model.User;
import com.ipme.poec.ACCSetup.Service.SessionService;
import com.ipme.poec.ACCSetup.Service.UserService;
import org.hibernate.type.LocalDateType;
import org.hibernate.type.descriptor.java.LocalDateTimeJavaDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private UserService userService;


    @GetMapping("/sessions/search")
    public List<Session> getSessions(){
        return sessionService.findAllSessions();
    }


    @EventListener(classes = {ApplicationStartedEvent.class}) //méthode qui se lance au départ de l'application
    @PostMapping("/sessions")
    public void createSession(){


        Track track = sessionService.getTrackById(1);
        Car car = sessionService.getCarById(1);
        User user = userService.getById(1);
        Session session = new Session(1,"Test", LocalDate.now(),track,car,user);
        sessionService.createSession(session);
        System.out.println("Session démarrée");

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
