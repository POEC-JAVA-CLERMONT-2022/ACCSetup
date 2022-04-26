package com.ipme.poec.ACCSetup.Controller;

import com.ipme.poec.ACCSetup.Model.Track;
import com.ipme.poec.ACCSetup.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
//@RequestMapping("api/tracks")
public class TrackController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("tracks")
    public List<Track> getTracks(){
        return sessionService.findAllTracks();
    }


}
