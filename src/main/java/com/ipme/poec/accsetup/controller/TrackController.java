package com.ipme.poec.accsetup.controller;

import com.ipme.poec.accsetup.model.Track;
import com.ipme.poec.accsetup.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
public class TrackController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("tracks")
    public List<Track> getTracks(){
        return sessionService.findAllTracks();
    }


}
