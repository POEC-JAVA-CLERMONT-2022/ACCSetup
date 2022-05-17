package com.ipme.poec.accsetup.controller;

import com.ipme.poec.accsetup.model.Weather;
import com.ipme.poec.accsetup.service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    private SetupService setupService;

    @GetMapping("weathers")
    public List<Weather> getWeathers() {
        return setupService.findAllWeathers();
    }


}
