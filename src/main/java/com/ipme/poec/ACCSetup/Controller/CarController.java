package com.ipme.poec.ACCSetup.Controller;

import com.ipme.poec.ACCSetup.Model.Car;
import com.ipme.poec.ACCSetup.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cars")
public class CarController {


    @Autowired
    private SessionService sessionService;

    @GetMapping(produces = "application/json")
    public List<Car> listCars() {
        return sessionService.findAllCars();
    }

}
