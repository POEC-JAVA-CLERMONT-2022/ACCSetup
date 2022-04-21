package com.ipme.poec.ACCSetup.Controller;

import com.ipme.poec.ACCSetup.Model.Car;
import com.ipme.poec.ACCSetup.Model.Session;
import com.ipme.poec.ACCSetup.Model.Track;
import com.ipme.poec.ACCSetup.Model.User;
import com.ipme.poec.ACCSetup.Service.SessionService;
import com.ipme.poec.ACCSetup.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private UserService userService;


    @GetMapping("/search")
    public List<Session> getSessions() {
        return sessionService.findAllSessions();
    }

    @PostMapping("/add")
    public void createSession(String sessionName, LocalDate sessionDate, Track track, Car car, User user) {

        sessionService.createSession(sessionName, sessionDate, track, car, user);

    }

}
