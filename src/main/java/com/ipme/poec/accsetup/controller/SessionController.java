package com.ipme.poec.accsetup.controller;

import com.ipme.poec.accsetup.model.Car;
import com.ipme.poec.accsetup.model.Session;
import com.ipme.poec.accsetup.model.Track;
import com.ipme.poec.accsetup.model.User;
import com.ipme.poec.accsetup.service.SessionService;
import com.ipme.poec.accsetup.service.UserService;
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


    @GetMapping
    public List<Session> getSessions() {
        return sessionService.findAllSessions();
    }

    @PostMapping("/add")
    public void createSession(String sessionName, LocalDate sessionDate, Track track, Car car, User user) {

        sessionService.createSession(sessionName, sessionDate, track, car, user);

    }

    @PutMapping("/edit")
    public void updateSession(Session session, String sessionNameUpdate, LocalDate sessionDateUpdate) {
        sessionService.updateSession(session, sessionNameUpdate, sessionDateUpdate);
    }

    @DeleteMapping("/delete")
    public void deleteSession(Session session) {
        sessionService.deleteSession(session.getSessionId());
    }

}
