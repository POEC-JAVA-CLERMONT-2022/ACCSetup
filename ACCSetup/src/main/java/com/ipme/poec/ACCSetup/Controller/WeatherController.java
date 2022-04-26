package com.ipme.poec.ACCSetup.Controller;

import com.ipme.poec.ACCSetup.Model.Weather;
import com.ipme.poec.ACCSetup.Service.SetupService;
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
