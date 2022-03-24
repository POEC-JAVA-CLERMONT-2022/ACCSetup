package com.ipme.poec.ACCSetup.Repository;

import com.ipme.poec.ACCSetup.Model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {

//    @Query("SELECT w FROM Weather w WHERE w.weatherId = :id")
//    Weather findById(@Param("weatherId") Weather weatherId);
}
