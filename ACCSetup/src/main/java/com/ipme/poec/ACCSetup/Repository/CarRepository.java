package com.ipme.poec.ACCSetup.Repository;

import com.ipme.poec.ACCSetup.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CarRepository extends JpaRepository<Car, Integer> {
//    @Query("SELECT c FROM Car c WHERE c.carId = :id")
//    Car findById(@Param("carId") Car carId);
}
