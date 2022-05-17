package com.ipme.poec.accsetup.repository;

import com.ipme.poec.accsetup.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CarRepository extends JpaRepository<Car, Integer> {
    @Query("SELECT c FROM Car c WHERE c.carName = :carname")
    Car getCarByName(@Param("carname") String name);
}
