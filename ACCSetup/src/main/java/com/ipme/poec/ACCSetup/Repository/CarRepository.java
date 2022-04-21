package com.ipme.poec.ACCSetup.Repository;

import com.ipme.poec.ACCSetup.Model.Car;
import com.ipme.poec.ACCSetup.Model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface CarRepository extends JpaRepository<Car, Integer> {

    //TODO: utiliser JPA
    
    @Query("SELECT c FROM Car c WHERE c.carName = :carname")
    Car getCarByName(@Param("carname") String name);
}
