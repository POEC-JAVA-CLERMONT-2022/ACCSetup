package com.ipme.poec.ACCSetup.Controller;

import com.ipme.poec.ACCSetup.Model.Car;
import com.ipme.poec.ACCSetup.Model.Session;
import com.ipme.poec.ACCSetup.Model.Track;
import com.ipme.poec.ACCSetup.Model.User;
import com.ipme.poec.ACCSetup.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

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
