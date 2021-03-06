package com.ipme.poec.accsetup.service;

import com.ipme.poec.accsetup.model.Car;
import com.ipme.poec.accsetup.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> findCarById(Integer id) {
        return carRepository.findById(id);
    }

    public Car getCarById(Integer id) {
        return carRepository.getById(id);
    }

    public Car getCarByName(String name) {
        return carRepository.getCarByName(name);
    }

    public Car saveCar(Car car) {
        return carRepository.saveAndFlush(car);
    }

    public void deleteAllCars() {
        carRepository.deleteAll();
    }
}
