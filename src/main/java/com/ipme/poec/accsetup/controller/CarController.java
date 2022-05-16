package com.ipme.poec.accsetup.controller;

import com.ipme.poec.accsetup.model.Car;
import com.ipme.poec.accsetup.service.SessionService;
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
