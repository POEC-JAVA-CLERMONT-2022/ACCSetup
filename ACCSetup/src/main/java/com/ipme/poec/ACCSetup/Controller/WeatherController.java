package com.ipme.poec.ACCSetup.Controller;

import com.ipme.poec.ACCSetup.Model.Condition;
import com.ipme.poec.ACCSetup.Model.Weather;
import com.ipme.poec.ACCSetup.Service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class WeatherController {

    @Autowired
    private SetupService setupService;

    @GetMapping("weathers")
    public List<Weather> getWeathers(){
        return setupService.findAllWeathers();
    }


}
